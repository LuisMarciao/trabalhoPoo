package br.com.meuprojeto;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class RelatorioHotelPet {
    

    private final List<Pet> pets;

    public RelatorioHotelPet(List<Pet> pets) {
        this.pets = pets != null ? pets : new ArrayList<>();
    }

   // Listar pets atualmente hospedados por espécie
public void listarHospedadosPorEspecie() {
    System.out.println("=== Pets hospedados por espécie ===");
    pets.stream()
        .filter(Objects::nonNull)
        .filter(p -> p.getEntrada() != null && p.getSaida() == null)
        .filter(p -> p.getEspecie() != null)
        .collect(Collectors.groupingBy(Pet::getEspecie))
        .forEach((especie, lista) -> {
            System.out.println("Espécie: " + especie);
            lista.forEach(p -> System.out.println("  - " + p.getNome()));
        });
}

// Listar pets atualmente hospedados por plano
public void listarHospedadosPorPlano() {
    System.out.println("=== Pets hospedados por plano ===");
    pets.stream()
        .filter(Objects::nonNull)
        .filter(p -> p.getEntrada() != null && p.getSaida() == null)
        .filter(p -> p.getPlano() != null && p.getPlano().getNome() != null)
        .collect(Collectors.groupingBy(p -> p.getPlano().getNome()))
        .forEach((plano, lista) -> {
            System.out.println("Plano: " + plano);
            lista.forEach(p -> System.out.println("  - " + p.getNome()));
        });
}
    // Relatório mensal: pets atendidos, serviços mais utilizados, receita total por serviço
    public void relatorioMensal(int ano, Month mes) {
        System.out.println("=== Relatório Mensal ===");
        Set<String> petsAtendidos = new HashSet<>();
        Map<String, Integer> servicosUtilizados = new HashMap<>();
        Map<String, Double> receitaPorServico = new HashMap<>();

        pets.stream()
            .filter(Objects::nonNull)
            .forEach(pet -> {
                List<ServicoAgendado> servicos = pet.getServicos();
                if (servicos != null) {
                    for (ServicoAgendado sa : servicos) {
                        LocalDateTime inicio = sa.getInicio();
                        if (inicio != null && inicio.getYear() == ano && inicio.getMonth() == mes) {
                            petsAtendidos.add(pet.getNome());
                            String nomeServico = sa.getServico().getNome();
                            servicosUtilizados.put(nomeServico, servicosUtilizados.getOrDefault(nomeServico, 0) + 1);
                            double preco = sa.getServico().calcularPreco(pet);
                            receitaPorServico.put(nomeServico, receitaPorServico.getOrDefault(nomeServico, 0.0) + preco);
                        }
                    }
                }
            });

        System.out.println("Pets atendidos: " + petsAtendidos);
        System.out.println("Serviços mais utilizados:");
        servicosUtilizados.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(e -> System.out.println("  " + e.getKey() + ": " + e.getValue() + " vezes"));

        System.out.println("Receita total por serviço:");
        receitaPorServico.forEach((serv, valor) ->
            System.out.printf("  %s: R$%.2f\n", serv, valor)
        );
    }
}