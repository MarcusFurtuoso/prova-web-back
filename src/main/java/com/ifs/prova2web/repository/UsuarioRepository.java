package com.ifs.prova2web.repository;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    UsuarioDTO findByLogin(String login);
}