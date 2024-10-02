package com.example.demo_projeto_fip.model;

import org.springframework.stereotype.Component;

@Component
public class Jogador {
    private String nome;
    private String sobreNome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
