package com.example.demo.mapper;

import com.example.demo.dto.JogadorDTO;
import com.example.demo.model.Jogador;

public class JogadorMapper {

    // Converte o JogadorDTO para Jogador (entidade)
    public static Jogador toEntity(JogadorDTO dto) {
        Jogador jogador = new Jogador();  // Usando a classe Jogador do pacote correto
        jogador.setNome(dto.getNome());
        jogador.setApelido(dto.getApelido());
        return jogador;
    }

    // Converte o Jogador (entidade) para JogadorDTO
    public static JogadorDTO toDTO(Jogador jogador) {
        JogadorDTO dto = new JogadorDTO();  // Usando o JogadorDTO
        dto.setNome(jogador.getNome());
        dto.setApelido(jogador.getApelido());
        return dto;
    }
}