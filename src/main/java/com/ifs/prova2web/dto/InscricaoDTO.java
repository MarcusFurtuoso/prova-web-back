package com.ifs.prova2web.dto;

import com.ifs.prova2web.model.Inscricao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoDTO {

    private Integer id;
    private Integer categoriaId;
    private Integer usuario1Id;
    private Integer usuario2Id;

    public static InscricaoDTO fromInscricao(Inscricao inscricao) {
        return InscricaoDTO.builder()
                .id(inscricao.getId())
                .categoriaId(inscricao.getCategoriaId().getId())
                .usuario1Id(inscricao.getUsuario1Id().getId())
                .usuario2Id(inscricao.getUsuario2Id().getId())
                .build();
    }

}
