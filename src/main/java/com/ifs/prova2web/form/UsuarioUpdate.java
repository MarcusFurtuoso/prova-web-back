package com.ifs.prova2web.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoUpdate {

    private String nome;

    private String login;

    private String senha;
}

