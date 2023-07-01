package com.ifs.prova2web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUpdate {

    private String nome;

    private String login;

    private String senha;
}

