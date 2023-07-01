package com.ifs.prova2web.controller;

import com.ifs.prova2web.dto.InscricaoDTO;
import com.ifs.prova2web.form.InscricaoForm;
import com.ifs.prova2web.model.Inscricao;
import com.ifs.prova2web.model.Torneio;
import com.ifs.prova2web.service.implementation.InscricaoServiceImpl;
import com.ifs.prova2web.service.implementation.TorneioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscricao")
public class InscricaoController {


    @Autowired
    private InscricaoServiceImpl service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InscricaoDTO> getAll() {
        return service.listarInscricoes();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InscricaoDTO cadastrarInscricao(@RequestBody InscricaoForm inscricao) {
        return service.cadastrarInscricao(inscricao);
    }

}
