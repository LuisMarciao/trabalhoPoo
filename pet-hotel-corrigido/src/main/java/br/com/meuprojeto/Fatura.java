package br.com.meuprojeto;
import java.time.Duration;

public class Fatura {
    Pet pet;
    private double totalHospedagem;
    private double totalServicos;

    public Fatura(Pet pet) {
        this.pet = pet;
        this.totalHospedagem = Duration.between(pet.getEntrada(), pet.getSaida()).toHours() * pet.plano.getTarifaPorHora();
        this.totalServicos = pet.servicos.stream().mapToDouble(s -> s.servico.calcularPreco(pet)).sum();
    }

    public void imprimir() {
        System.out.println("----- Fatura -----");
        System.out.println("Pet: " + pet.getNome());
        System.out.println("Entrada: " + pet.getEntrada());
        System.out.println("Saída: " + pet.getSaida());
        for (ServicoAgendado s : pet.servicos) {
            System.out.printf("%s de %s até %s - R$%.2f\n", s.servico.getNome(), s.getInicio(), s.getFim(), s.servico.calcularPreco(pet));
        }
        System.out.printf("Hospedagem: R$%.2f\n", totalHospedagem);
        System.out.printf("Serviços: R$%.2f\n", totalServicos);
        System.out.printf("Total: R$%.2f\n", totalHospedagem + totalServicos);
    }
}