package com.ifs.prova2web.dto;

import com.ifs.prova2web.model.Categoria;
import com.ifs.prova2web.model.Torneio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TorneioDTO {

    private Integer id;

    private String nome;

    private String premiacao;

    List<CategoriaModel> categorias;

    public static TorneioDTO fromTorneio(Torneio torneio, List<Categoria> categorias) {
        List<CategoriaModel> categoriaModels = categorias
                .stream()
                .map(categoria -> new CategoriaModel(categoria.getId(), categoria.getNome()))
                .toList();

        return TorneioDTO.builder()
                .id(torneio.getId())
                .nome(torneio.getNome())
                .premiacao(torneio.getPremiacao())
                .categorias(categoriaModels)
                .build();
    }

}
