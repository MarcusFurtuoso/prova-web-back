package com.ifs.prova2web.service.implementation;

import com.ifs.prova2web.dto.TorneioDTO;
import com.ifs.prova2web.dto.UsuarioDTO;
import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Torneio;
import com.ifs.prova2web.repository.CategoriaRepository;
import com.ifs.prova2web.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TorneioServiceImpl {

    @Autowired
    TorneioRepository torneioRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<TorneioDTO> listarTorneios() {

        List<Torneio> torneios = torneioRepository.findAll();

        return torneios.stream().map(torneio -> {
            List<Categoria> categorias = categoriaRepository.findCategoriaByTorneioId(torneio);

            return TorneioDTO.fromTorneio(torneio, categorias);
        }).toList();
    }

    public Torneio cadastrarTorneio(Torneio torneio) {
        return torneioRepository.save(torneio);
    }

    public void excluirTorneio(Integer id) {
        torneioRepository.deleteById(id);
    }

    public TorneioDTO findTorneioById(Integer id) {
        Torneio torneio = torneioRepository.findById(id).orElseThrow();
        List<Categoria> categorias = categoriaRepository.findCategoriaByTorneioId(torneio);

        return TorneioDTO.fromTorneio(torneio, categorias);
    }




}
