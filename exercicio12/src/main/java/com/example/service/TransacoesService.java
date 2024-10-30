package com.example.service;

import com.example.model.Conta;
import com.example.model.Transacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService
{
    private List<Conta> contas = new ArrayList<>();

    public TransacoesService()
    {
        contas.add(new Conta("500-1", "Fulano"));
        contas.add(new Conta("320-2", "Ciclano"));
    }

    public Transacao fazerTransacao(String origemCodigo, String destinoCodigo, Double valor)
    {
        Conta origem = contas.stream().filter(c -> c.getCodigo().equals(origemCodigo)).findFirst().orElse(null);
        Conta destino = contas.stream().filter(c -> c.getCodigo().equals(destinoCodigo)).findFirst().orElse(null);

        if (origem != null && destino != null)
        {
            return new Transacao(origem, destino, valor);
        }
        return null;
    }
}