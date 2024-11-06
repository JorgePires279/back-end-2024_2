import com.exercicio13.dto.JogadorDTO;
import com.exercicio13.mapper.JogadorMapper;
import com.exercicio13.service.JogadorService;
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
        com.exercicio13.model.Jogador jogador = jogadorService.salvarJogador(jogadorDTO);
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