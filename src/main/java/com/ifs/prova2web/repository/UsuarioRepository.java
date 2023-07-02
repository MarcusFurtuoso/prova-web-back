package com.ifs.prova2web.repository;

import com.ifs.prova2web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM usuario u WHERE u.id != :userId", nativeQuery = true)
    List<Usuario> findAllByUsuario(@Param("userId") Integer userId);

    Optional<Usuario> findByLogin(String login);
}