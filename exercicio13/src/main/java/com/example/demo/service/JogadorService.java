package com.example.demo.service;

import com.example.demo.dto.JogadorDTO;
import com.example.demo.mapper.JogadorMapper;
import com.example.demo.model.Jogador;
import com.example.demo.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    // Método para salvar um jogador
    public Jogador salvarJogador(JogadorDTO jogadorDTO) {
        Jogador jogador = JogadorMapper.toEntity(jogadorDTO);  // Convertendo o DTO para a entidade
        return jogadorRepository.save(jogador);  // Salvando a entidade no repositório
    }

    // Método para listar todos os jogadores
    public List<Jogador> listarJogadores() {
        return jogadorRepository.findAll();  // Retornando todos os jogadores
    }
}