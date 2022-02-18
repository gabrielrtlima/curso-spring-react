package com.gabrielrtlima.minhasfinancasapi.services;

import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;

public interface UsuarioService {

    Usuario autenticar(String email, String senha);

    Usuario salvarUsuario(Usuario usuario);

    void validarEmail(String email);



}
