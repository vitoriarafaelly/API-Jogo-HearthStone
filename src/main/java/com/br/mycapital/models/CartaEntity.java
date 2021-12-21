package com.br.mycapital.models;

import com.br.mycapital.enums.ClasseCarta;
import com.br.mycapital.enums.TipoCarta;


public class CartaEntity {

    private Integer id;

    private String nome;

    private String descricao;

    private int ataque;

    private int defesa;

    private TipoCarta tipo;

    private ClasseCarta classe;


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public ClasseCarta getClasse() {
        return classe;
    }


    public Integer getId() {
        return id;
    }
}

