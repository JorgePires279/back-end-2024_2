package com.example.mapper;

import com.example.dto.ContaDTO;
import com.example.model.Conta;

public class ContaMapper {
    public static ContaDTO toDTO(Conta conta)
    {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}
