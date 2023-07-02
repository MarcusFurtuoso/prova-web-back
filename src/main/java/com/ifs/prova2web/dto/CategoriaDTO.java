package com.ifs.prova2web.dto;

import com.ifs.prova2web.model.Categoria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaDTO {

    private Integer id;
    private Integer torneioId;
    private String nome;

    public static CategoriaDTO fromCategoria(Categoria categoria) {
        return CategoriaDTO.builder()
                .id(categoria.getId())
                .torneioId(categoria.getTorneioId().getId())
                .nome(categoria.getNome())
                .build();
    }

}
