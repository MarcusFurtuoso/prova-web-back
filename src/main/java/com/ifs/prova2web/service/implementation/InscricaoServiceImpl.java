package com.ifs.prova2web.service.implementation;


import com.ifs.prova2web.dto.InscricaoDTO;
import com.ifs.prova2web.form.InscricaoForm;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Inscricao;
import com.ifs.prova2web.model.Usuario;
import com.ifs.prova2web.repository.CategoriaRepository;
import com.ifs.prova2web.repository.InscricaoRepository;
import com.ifs.prova2web.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoServiceImpl {

    @Autowired
    InscricaoRepository inscricaoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<InscricaoDTO> listarInscricoes() {
        return inscricaoRepository.findAll().stream().map(InscricaoDTO::fromInscricao).toList();
    }

    public InscricaoDTO cadastrarInscricao(InscricaoForm inscricaoForm) {
        System.out.println("data" + inscricaoForm);
        Categoria categoria = categoriaRepository.findById(inscricaoForm.categoriaId()).orElseThrow();
        Usuario usuario1 = usuarioRepository.findById(inscricaoForm.usuario1Id()).orElseThrow();
        Usuario usuario2 = usuarioRepository.findById(inscricaoForm.usuario2Id()).orElseThrow();

        Inscricao inscricao = Inscricao.builder().categoriaId(categoria).usuario1Id(usuario1).usuario2Id(usuario2).build();
        Inscricao inscricaoSalva = inscricaoRepository.save(inscricao);
        return InscricaoDTO.fromInscricao(inscricaoSalva);
    }


}
