package com.gabrielrtlima.minhasfinancasapi.services;

import com.gabrielrtlima.minhasfinancasapi.exceptions.RegraNegocioException;
import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import com.gabrielrtlima.minhasfinancasapi.model.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioServiceTest {

    @Autowired
    UsuarioService service;

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveValidarEmail() {
        //cenario
        repository.deleteAll();

        //acao
        service.validarEmail("email@email.com");

    }

    @Test
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastado() {
        Assertions.assertDoesNotThrow(() -> {
            // cenario
            Usuario usuario = Usuario.builder().nome("usuario").email("email@email.com").build();

            //acao
            service.validarEmail("email@email");
        });
    }
}
