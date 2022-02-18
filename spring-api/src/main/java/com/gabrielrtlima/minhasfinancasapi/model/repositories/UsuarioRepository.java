package com.gabrielrtlima.minhasfinancasapi.model.repositories;

import com.gabrielrtlima.minhasfinancasapi.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByEmail(String email);

}
