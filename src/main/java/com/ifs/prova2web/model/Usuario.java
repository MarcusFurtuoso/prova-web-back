package com.ifs.prova2web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nome;
    @NotNull
    private String login;
    @NotNull
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Timestamp dataCadastro = new Timestamp(System.currentTimeMillis());;

}
