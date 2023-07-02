package com.ifs.prova2web.controller;

import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.form.LoginForm;
import com.ifs.prova2web.form.UsuarioUpdate;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Usuario;
import com.ifs.prova2web.service.implementation.CategoriaServiceImpl;
import com.ifs.prova2web.service.implementation.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDTO> getAll() {
        return service.consultarTodos();
    }

    @PostMapping("/cadastro")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDTO cadastrarUsuario(@RequestBody Usuario usuario) {
        return service.cadastrarUsuario(usuario);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO login(@RequestBody LoginForm loginForm) {
        return service.login(loginForm);
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDTO getUsuario(@PathVariable Integer id) {
        return service.getUsuario(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable int id) {
        service.excluir(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario update(@PathVariable Integer id, @RequestBody UsuarioUpdate usuarioUpdate) {
       return service.update(id, usuarioUpdate);
    }
}
