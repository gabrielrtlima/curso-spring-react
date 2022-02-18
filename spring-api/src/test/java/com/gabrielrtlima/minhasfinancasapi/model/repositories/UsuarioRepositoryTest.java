package com.gabrielrtlima.minhasfinancasapi.model.repositories;

import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    UsuarioRepository repository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void deveVerificarAExistenciaDeUmEmail() {

        //cenário
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        //ação
        boolean resultado = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(resultado).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverUsuarioCadastradoComOEmail() {

        //acao
        boolean resultado = repository.existsByEmail("usuario@email.com");

        //verificacao
        Assertions.assertThat(resultado).isFalse();

    }

    @Test
    public void devePersistirUmUsuarioNaBaseDeDados(){
        // cenario
        Usuario usuario = criarUsuario();
        //acao
        Usuario usuarioSalvo = repository.save(usuario);

        Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
    }

    @Test
    public void deveBuscarUmUsuarioPorEmail() {
        //cenario
        Usuario usuario = criarUsuario();
        entityManager.persist(usuario);

        //verificacao
        Optional<Usuario> resultado = repository.findByEmail("usuario@email.com");
        Assertions.assertThat(resultado.isPresent()).isTrue();

    }

    @Test
    public void deveRetornarVazioAoBuscarUsuarioPorEmailQuandoNaoExisteBase() {
        //cenario

        //verificacao
        Optional<Usuario> resultado = repository.findByEmail("usuario@email.com");
        Assertions.assertThat(resultado.isPresent()).isFalse();

    }


    public static Usuario criarUsuario() { return Usuario.builder().nome("usuario").email("usuario@email.com").senha("senha").build(); }
}
