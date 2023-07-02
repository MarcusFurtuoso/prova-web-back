package com.ifs.prova2web.service.implementation;

import com.ifs.prova2web.dto.CategoriaDTO;
import com.ifs.prova2web.dto.CategoriaModel;
import com.ifs.prova2web.form.CategoriaForm;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Torneio;
import com.ifs.prova2web.repository.CategoriaRepository;
import com.ifs.prova2web.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    TorneioRepository torneioRepository;

    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll().stream().map(CategoriaDTO::fromCategoria).toList();
    }

    public CategoriaDTO cadastrarCategoria(CategoriaForm categoriaForm) {
        Torneio torneioId = torneioRepository.findById(categoriaForm.torneioId()).orElseThrow();
        String nomeCategoria = categoriaForm.nome();

        Categoria categoria = Categoria.builder().nome(nomeCategoria).torneioId(torneioId).build();
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return CategoriaDTO.fromCategoria(categoriaSalva);
    }

    public List<CategoriaModel> getCategoriasByTorneio(Integer id) {
        Torneio torneio = torneioRepository.findById(id).orElseThrow();
        List<Categoria> categorias = categoriaRepository.findCategoriaByTorneioId(torneio);

        return categorias
                .stream()
                .map(categoria -> new CategoriaModel(categoria.getId(), categoria.getNome()))
                .toList();
    }

}
