package com.ifs.prova2web.dto;

import com.ifs.prova2web.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    private String nome;
    private String login;

    private Timestamp dataCadastro;

    public static UsuarioDTO fromUsuario(Usuario usuario) {
        return UsuarioDTO.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .login(usuario.getLogin())
                .dataCadastro(usuario.getDataCadastro())
                .build();
    }
}
