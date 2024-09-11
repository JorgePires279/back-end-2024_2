package springoot.filmsuggestion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmeController {

    @GetMapping("/recomendar")
    public String recomendarFilme(@RequestParam String genero, @RequestParam String ambiente) {
        String filme;

        // Condições baseadas nos parâmetros de gênero e ambientação
        if (genero.equalsIgnoreCase("acao") && ambiente.equalsIgnoreCase("futurista")) {
            filme = "Homens de Preto";
        } else if (genero.equalsIgnoreCase("romance") && ambiente.equalsIgnoreCase("historico")) {
            filme = "Orgulho e Preconceito";
        } else if (genero.equalsIgnoreCase("comedia") && ambiente.equalsIgnoreCase("urbano")) {
            filme = "Se Beber, Não Case!";
        } else {
            filme = "Infelizmente, não temos uma sugestão de filme para essa combinação.";
        }

        return filme;
    }
}