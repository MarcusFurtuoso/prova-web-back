package com.ifs.prova2web.service;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.form.UsuarioUpdate;
import com.ifs.prova2web.model.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO cadastrarUsuario(Usuario usuario);

    List<UsuarioDTO> consultarTodos();

    void login();

    Usuario getUsuario(UsuarioDTO usuarioDTO);

    void excluir(int id);

    Usuario update(Integer id, UsuarioUpdate usuario);


}
