package com.ifs.prova2web.service.implementation;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.exception.LoginException;
import com.ifs.prova2web.form.LoginForm;
import com.ifs.prova2web.form.UsuarioUpdate;
import com.ifs.prova2web.model.Usuario;
import com.ifs.prova2web.repository.UsuarioRepository;
import com.ifs.prova2web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO cadastrarUsuario(Usuario usuario) {
        Usuario usuario1 = usuarioRepository.save(usuario);
        return UsuarioDTO.fromUsuario(usuario1);
    }

    @Override
    public List<UsuarioDTO> consultarTodos() {
        List<UsuarioDTO> ls = new ArrayList<>();
        List lsUsuarios =  (List<Usuario>)usuarioRepository.findAll();
        lsUsuarios.forEach(usuarios -> {
            ls.add(UsuarioDTO.fromUsuario((Usuario) usuarios));
        });
        return ls;
    }

    @Override
    public UsuarioDTO login(LoginForm loginForm) {
        Optional<Usuario> usuOptional = usuarioRepository.findByLogin(loginForm.login());
        if(usuOptional.isEmpty()) {
            throw new LoginException("Login não cadastrado!");
        }
        if(!loginForm.senha().equals(usuOptional.get().getSenha())) {
            throw new LoginException("Senha inválida!");
        }
        return UsuarioDTO.fromUsuario(usuOptional.get());
    }

    @Override
    public UsuarioDTO getUsuario(int id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return UsuarioDTO.fromUsuario(usuario);
    }

    @Override
    public void excluir(int id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario update(Integer id, UsuarioUpdate usuarioUpdate) {
        Usuario usuario = usuarioRepository.findById(id).get();
        usuario.setNome(usuarioUpdate.getNome());
        usuario.setLogin(usuarioUpdate.getLogin());
        usuario.setSenha(usuarioUpdate.getSenha());

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> consultarTodosDisponiveisParaUmUsuario(Integer userId) {
        List<UsuarioDTO> ls = new ArrayList<>();
        List lsUsuarios =  (List<Usuario>)usuarioRepository.findAllByUsuario(userId);
        lsUsuarios.forEach(usuarios -> {
            ls.add(UsuarioDTO.fromUsuario((Usuario) usuarios));
        });
        return  ls;
    }

}
