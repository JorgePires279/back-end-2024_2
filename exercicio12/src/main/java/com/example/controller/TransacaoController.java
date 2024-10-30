// Jorge Luiz Madeira Pires
package com.example.controller;

import com.example.dto.TransacaoRequestDTO;
import com.example.dto.TransacaoResponseDTO;
import com.example.mapper.ContaMapper;
import com.example.model.Transacao;
import com.example.service.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController
{

    @Autowired
    private TransacoesService transacoesService;

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO request)
    {
        Transacao transacao = transacoesService.fazerTransacao(request.origem(), request.destino(), request.valor());
        
        if (transacao != null)
        {
            return new TransacaoResponseDTO(
                ContaMapper.toDTO(transacao.getOrigem()),
                ContaMapper.toDTO(transacao.getDestino()),
                transacao.getValor()
            );
        }
        return null; 
    }
}
