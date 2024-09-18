package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    private final RestTemplate restTemplate;

    @Value("${api.fipe.url}")
    private String apiFipeUrl;

    public CarroController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/valor")
    public ResponseEntity<?> getValorFipe(@RequestBody CarroRequest carroRequest) {
        try {
            // A URL pode precisar ser ajustada para corresponder ao formato exigido pela API FIPE
            String url = String.format("%s/veiculo?marca=%s&modelo=%s&ano=%d",
                    apiFipeUrl,
                    carroRequest.getMarca(),
                    carroRequest.getModelo(),
                    carroRequest.getAno());

            // Requisição à API da Tabela FIPE
            ValorFipeResponse response = restTemplate.getForObject(url, ValorFipeResponse.class);

            if (response == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(response);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
        }
    }
}
