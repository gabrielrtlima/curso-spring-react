package com.gabrielrtlima.minhasfinancasapi.model.repositories;

import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {

        //cenário
        Usuario usuario = Usuario.builder().nome("usuario").email("usuario@email.com").build();
        repository.save(usuario);

        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(resultado).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {

        //cenario
        repository.deleteAll();

        //acao
        boolean resultado = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(resultado).isFalse();

    }
}
