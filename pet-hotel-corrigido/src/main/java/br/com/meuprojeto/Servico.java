package br.com.meuprojeto;

import java.time.Duration;

public class Servico {
    private String nome;
    Duration duracao;

    public Servico(String nome, Duration duracao) {
        this.nome = nome;
        this.duracao = duracao;
    }

    

    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public Duration getDuracao() {
        return duracao;
    }



    public void setDuracao(Duration duracao) {
        this.duracao = duracao;
    }



    public double calcularPreco(Pet pet){
        return 0.0; // Método a ser implementado nas subclasses
    };
}

class Banho extends Servico {
    public Banho() { super("Banho", Duration.ofMinutes(30)); }
    public double calcularPreco(Pet pet) {
        return 30.0;
    }
}

class Tosa extends Servico {
    public Tosa() { super("Tosa", Duration.ofMinutes(45)); }
    public double calcularPreco(Pet pet) {
        return 40.0;
    }
}

class Passeio extends Servico {
    public Passeio() { super("Passeio", Duration.ofMinutes(60)); }
    public double calcularPreco(Pet pet) {
        return 20.0;
    }
}
