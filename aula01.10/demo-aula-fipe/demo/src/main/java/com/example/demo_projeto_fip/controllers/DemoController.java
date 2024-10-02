package com.example.demo_projeto_fip.controllers;

import com.example.demo_projeto_fip.model.Jogador;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class DemoController {
    @GetMapping("/mundo")
    public String helloword(@RequestParam String nomeEstudante, @RequestParam String sobrenomeEstudante){
        return "olá," + nomeEstudante + sobrenomeEstudante;
    }


    @PostMapping("/jogador")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Jogador processaJogador(@RequestBody Jogador jogador){
    jogador.setNome("Ronaldinho");
    jogador.setSobreNome("Gaucho");
    return jogador;
    }

    @GetMapping("/sobre")
    @ResponseBody
    public HashMap<String, String> sobre()
    {
        HashMap<String, String> sobre = new HashMap<>();
        sobre.put("projeto", "Gerador de jogadores de Futebol");
        sobre.put("nome", "Jorge Pires");
        sobre.put("codigo","48988351130");
        return sobre;
   }


    /*public String helloword2(@RequestBody String nomeEstudante, @RequestBody String sobrenomeEstudante){
        return nomeEstudante + " " + sobrenomeEstudante;
    }*/

    @GetMapping ("/mundo3") //Método Get
    public String helloWorld(@RequestParam String nomeEstudante, @RequestParam String sobrenomeEstudante){
        return "Olá " + nomeEstudante + " " + sobrenomeEstudante;
    }
    @PostMapping ("/estudante") //Método Post
    public String processaEstudante(@RequestBody String nome, @RequestBody String sobrenome){
        return "Olá " + nome + " " +sobrenome;
    }

    @GetMapping("/mundo2")
    public String helloword(){
        return "olá,";
    }
}
