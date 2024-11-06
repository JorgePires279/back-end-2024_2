package com.example.demo.controller;

import com.example.demo.dto.JogadorDTO;
import com.example.demo.mapper.JogadorMapper;
import com.example.demo.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @PostMapping
    public JogadorDTO criarJogador(@RequestBody @Valid JogadorDTO jogadorDTO) {
        com.example.demo.model.Jogador jogador = jogadorService.salvarJogador(jogadorDTO);
        return JogadorMapper.toDTO(jogador);
    }

    @GetMapping
    public List<JogadorDTO> listarJogadores() {
        return jogadorService.listarJogadores()
                .stream()
                .map(JogadorMapper::toDTO)
                .collect(Collectors.toList());
    }
}