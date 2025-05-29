package br.com.meuprojeto;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HotelPet {
    
    List<Pet> pets = new ArrayList<>();
    private List<ServicoAgendado> servicos = new ArrayList<>();

    public void cadastrarPet(Pet pet) {
        if (pets.size() < 50) pets.add(pet);
        else System.out.println("Limite máximo de pets atingido.");
    }

    public void agendarServico(Pet pet, Servico servico, LocalDateTime inicio) {
        ServicoAgendado novo = new ServicoAgendado(servico, inicio);
        for (ServicoAgendado s : pet.servicos) {
            if (s.getInicio().isBefore(novo.getFim()) && novo.inicio.isBefore(s.getFim())) {
                System.out.println("Conflito de agendamento detectado.");
                return;
            }
        }
        pet.servicos.add(novo);
    }

    public void cancelarServico(Pet pet, ServicoAgendado servico) {
        if (pet.servicos.contains(servico)) {
            pet.servicos.remove(servico);
        } else {
            System.out.println("Serviço não encontrado na lista de agendamentos do pet.");
        }
    }
    public void gerarFatura(Pet pet, LocalDateTime saida) {
        pet.setSaida(saida);
        Fatura fatura = new Fatura(pet);
        fatura.imprimir();
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<ServicoAgendado> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoAgendado> servicos) {
        this.servicos = servicos;
    }
}