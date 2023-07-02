package com.ifs.prova2web.service;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.form.LoginForm;
import com.ifs.prova2web.form.UsuarioUpdate;
import com.ifs.prova2web.model.Usuario;

import java.util.List;

public interface UsuarioService {

    UsuarioDTO cadastrarUsuario(Usuario usuario);

    List<UsuarioDTO> consultarTodos();

    UsuarioDTO login(LoginForm loginForm);

    UsuarioDTO getUsuario(int id);

    void excluir(int id);

    public List<UsuarioDTO> consultarTodosDisponiveisParaUmUsuario(Integer userId);

    Usuario update(Integer id, UsuarioUpdate usuario);


}
