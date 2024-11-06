package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

    @Entity
    public class Jogador {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;
        private String apelido;
        private int habilidade = 100;

        // Construtor padrão (sem parâmetros) necessário para JPA
        public Jogador() {
        }

        public Jogador(String nome) {
            this.nome = nome;
        }

        // Getters e Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getApelido() {
            return apelido;
        }

        public void setApelido(String apelido) {
            this.apelido = apelido;
        }

        public int getHabilidade() {
            return habilidade;
        }

        public void setHabilidade(int habilidade) {
            this.habilidade = habilidade;
        }

        // Método toString para facilitar a visualização (opcional)
        @Override
        public String toString() {
            return "Jogador{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", apelido='" + apelido + '\'' +
                    ", habilidade=" + habilidade +
                    '}';
        }
    }
