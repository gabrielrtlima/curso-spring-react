package com.gabrielrtlima.minhasfinancasapi.services.impl;

import com.gabrielrtlima.minhasfinancasapi.exceptions.RegraNegocioException;
import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import com.gabrielrtlima.minhasfinancasapi.model.repositories.UsuarioRepository;
import com.gabrielrtlima.minhasfinancasapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario autenticar(String email, String senha) {
        return null;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public void validarEmail(String email) {
        boolean existe = repository.existsByEmail(email);
        if(existe) {
            throw new RegraNegocioException("Já existe usuário cadastrado com este e-mail!");
        }
    }
}
