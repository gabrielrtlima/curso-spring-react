package com.gabrielrtlima.minhasfinancasapi.services;

import com.gabrielrtlima.minhasfinancasapi.exceptions.RegraNegocioException;
import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import com.gabrielrtlima.minhasfinancasapi.model.repositories.UsuarioRepository;
import com.gabrielrtlima.minhasfinancasapi.services.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
public class UsuarioServiceTest {

    UsuarioService service;
    UsuarioRepository repository;

    @BeforeEach
    public void setUp() {
        repository = Mockito.mock(UsuarioRepository.class);
        service = new UsuarioServiceImpl(repository);
    }

    @Test
    public void deveValidarEmail() {
        //cenario
        Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(false);

        //acao
        service.validarEmail("email@email.com");

    }

    @Test
    public void deveLancarErroAoValidarEmailQuandoExistirEmailCadastado() {
        Assertions.assertThrows(RegraNegocioException.class, () -> {
            // cenario
            Mockito.when(repository.existsByEmail(Mockito.anyString())).thenReturn(true);

            //acao
            service.validarEmail("email@email");
        });
    }
}
