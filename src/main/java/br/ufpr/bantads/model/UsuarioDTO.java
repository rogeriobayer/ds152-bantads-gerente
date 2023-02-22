package br.ufpr.bantads.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioDTO{

    private String id;
    private Long idExternoUsuario;
    private String nome;
    private String cpf;
    private EnderecoDTO endereco;
    private double salario;
    private String saga;




}
