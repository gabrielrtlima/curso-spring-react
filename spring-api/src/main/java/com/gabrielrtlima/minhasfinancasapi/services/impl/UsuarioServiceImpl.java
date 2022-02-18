package com.gabrielrtlima.minhasfinancasapi.services.impl;

import com.gabrielrtlima.minhasfinancasapi.exceptions.ErroAutenticacao;
import com.gabrielrtlima.minhasfinancasapi.exceptions.RegraNegocioException;
import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import com.gabrielrtlima.minhasfinancasapi.model.repositories.UsuarioRepository;
import com.gabrielrtlima.minhasfinancasapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {

        Optional<Usuario> usuario = repository.findByEmail(email);

        if(!usuario.isPresent()) {
            throw new ErroAutenticacao("Usuário não encontrado para o e-mail informado!");
        }

        if(!usuario.get().getSenha().equals(senha)) {
            throw new ErroAutenticacao("Senha inválida!");
        }

        return usuario.get();
    }

    @Override
    @Transactional
    public Usuario salvarUsuario(Usuario usuario) {
        validarEmail(usuario.getEmail());
        return repository.save(usuario);

    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe) {
            throw new RegraNegocioException("Já existe usuário cadastrado com este e-mail!");
        }
    }
}
