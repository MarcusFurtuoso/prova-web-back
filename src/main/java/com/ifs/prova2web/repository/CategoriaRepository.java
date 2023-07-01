package com.ifs.prova2web.repository;

import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Torneio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    List<Categoria> findCategoriaByTorneioId(Torneio torneio);
}