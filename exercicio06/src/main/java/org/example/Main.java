
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

class Filme {
    private String nome;
    private double preco;
    private int idadeMinima;

    public Filme(String nome, double preco, int idadeMinima) {
        this.nome = nome;
        this.preco = preco;
        this.idadeMinima = idadeMinima;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdadeMinima() {
        return idadeMinima;
    }
}

class Ingresso {
    private Cliente cliente;
    private Filme filme;
    private String assento;

    public Ingresso(Cliente cliente, Filme filme, String assento) {
        this.cliente = cliente;
        this.filme = filme;
        this.assento = assento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public String getAssento() {
        return assento;
    }

    @Override
    public String toString() {
        return "Ingresso vendido com sucesso! " + filme.getNome() + " - " + assento + " - " + cliente.getNome();
    }
}

class Cinema {
    private List<Filme> filmesDisponiveis;
    private List<Ingresso> ingressosVendidos;
    private List<String> assentosDisponiveis;

    public Cinema() {
        filmesDisponiveis = new ArrayList<>();
        ingressosVendidos = new ArrayList<>();
        assentosDisponiveis = new ArrayList<>();
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        char[] filas = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char fila : filas) {
            for (int i = 1; i <= 5; i++) {
                assentosDisponiveis.add(fila + String.valueOf(i));
            }
        }
    }

    public void adicionarFilme(Filme filme) {
        filmesDisponiveis.add(filme);
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : filmesDisponiveis) {
            if (filme.getNome().equalsIgnoreCase(nome)) {
                return filme;
            }
        }
        return null;
    }

    public void venderIngresso(Cliente cliente, Filme filme, String assento) throws Exception {
        if (!assentosDisponiveis.contains(assento)) {
            throw new Exception("O ingresso não pode ser vendido pois seu assento não está mais disponível!");
        }

        if (cliente.getIdade() < filme.getIdadeMinima()) {
            throw new Exception("O ingresso não pode ser vendido pois sua idade não permite!");
        }

        Ingresso ingresso = new Ingresso(cliente, filme, assento);
        ingressosVendidos.add(ingresso);
        assentosDisponiveis.remove(assento);
        System.out.println(ingresso);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cinema cinema = new Cinema();
        cinema.adicionarFilme(new Filme("Homem Aranha", 15.00, 12));
        cinema.adicionarFilme(new Filme("O Rei Leão", 10.00, 0));
        cinema.adicionarFilme(new Filme("Avatar", 20.00, 16));
        cinema.adicionarFilme(new Filme("Interestelar", 18.00, 14));
        cinema.adicionarFilme(new Filme("Velozes e Furiosos", 12.00, 12));

        try {
            System.out.print("Que filme você deseja assistir? Filmes disponiveis: Homem Aranha; O Rei Leão; Avatar; Interestelar e Velozes e Furiosos ");
            String nomeFilme = scanner.nextLine();
            Filme filme = cinema.buscarFilmePorNome(nomeFilme);

            if (filme == null) {
                System.out.println("Filme não encontrado.");
                return;
            }

            System.out.print("Qual assento você deseja? Assentos disponíveis: A ao F, 1 ao 5 ");
            String assento = scanner.nextLine();

            System.out.print("Qual o seu nome? ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Qual a sua idade? ");
            int idade = scanner.nextInt();

            Cliente cliente = new Cliente(nomeCliente, idade);
            cinema.venderIngresso(cliente, filme, assento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}