package com.ifs.prova2web.repository;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);
}