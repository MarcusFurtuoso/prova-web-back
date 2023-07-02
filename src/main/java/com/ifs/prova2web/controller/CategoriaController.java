package com.ifs.prova2web.controller;

import com.ifs.prova2web.dto.CategoriaDTO;
import com.ifs.prova2web.dto.CategoriaModel;
import com.ifs.prova2web.form.CategoriaForm;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Inscricao;
import com.ifs.prova2web.service.implementation.CategoriaServiceImpl;
import com.ifs.prova2web.service.implementation.InscricaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaDTO> getAll() {
        return service.listarCategorias();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaDTO cadastrarCategoria(@RequestBody CategoriaForm categoriaForm) {
        return service.cadastrarCategoria(categoriaForm);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<CategoriaModel> getCategoriaByTorneio(@PathVariable Integer id) {
        return service.getCategoriasByTorneio(id);
    }

}
