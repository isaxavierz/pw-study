package br.com.etechoracio.study.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA") // se a classe for o mesmo nome da tabela nn precisa fazer isso
public class Disciplina {

    @Id // significa que é uma chave primária
    @Column (name = "ID_DISCIPLINA")
    @GeneratedValue (strategy = GenerationType.IDENTITY) //avisar o java que é auto incrementado
    private Long id; // bigInt no SQL

    @Column (name = "TX_NOME")
    private String nome;
}
