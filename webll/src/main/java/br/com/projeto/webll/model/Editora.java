package br.com.projeto.webll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Editora {

    private Long id;


    private String nome;

    private String descricao;
}
