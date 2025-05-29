package br.com.meuprojeto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private double peso;
    Tutor tutor;
    PlanoHospedagem plano;
    LocalDateTime entrada;
    LocalDateTime saida;
    List<ServicoAgendado> servicos = new ArrayList<>();

    
    public Pet(String nome, String especie, String raca, int idade) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
    }

    public Pet(String nome, String especie, String raca, int idade, double peso, Tutor tutor, PlanoHospedagem plano, LocalDateTime entrada) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.tutor = tutor;
        this.plano = plano;
        this.entrada = entrada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public PlanoHospedagem getPlano() {
        return plano;
    }

    public void setPlano(PlanoHospedagem plano) {
        this.plano = plano;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public List<ServicoAgendado> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoAgendado> servicos) {
        this.servicos = servicos;
    }

    

    
}
