# Pet Hotel

Sistema de gerenciamento de hotel para pets, desenvolvido em Java. Permite cadastrar pets, agendar serviços, emitir faturas e gerar relatórios avançados sobre a hospedagem e os serviços prestados.

## Funcionalidades

- **Cadastro de Pets:** Registre informações como nome, espécie, raça, idade, tutor e plano de hospedagem.
- **Agendamento de Serviços:** Agende serviços como Banho, Tosa e Passeio para os pets hospedados.
- **Emissão de Faturas:** Gere faturas detalhadas com valores de hospedagem e serviços utilizados.
- **Relatórios Avançados:** 
  - Listagem de pets hospedados por espécie, plano ou tempo de permanência.
  - Relatório mensal com pets atendidos, serviços mais utilizados e receita total por serviço.

## Principais Classes

- **Pet:** Representa o animal hospedado.
- **Tutor:** Representa o responsável pelo pet.
- **PlanoHospedagem:** Define o plano e a tarifa da hospedagem.
- **Servico:** Classe base para serviços (Banho, Tosa, Passeio).
- **ServicoAgendado:** Representa um serviço agendado para um pet.
- **HotelPet:** Gerencia cadastro de pets, agendamento/cancelamento de serviços e emissão de faturas.
- **Fatura:** Gera e imprime a fatura da hospedagem e serviços.
- **RelatorioHotelPet:** Gera relatórios avançados do hotel.

## Exemplo de Uso

```java
HotelPet hotel = new HotelPet();
Pet pet = new Pet("Rex", "Cachorro", "Labrador", 5);
hotel.cadastrarPet(pet);
hotel.agendarServico(pet, new Banho(), LocalDateTime.now().plusHours(1));
hotel.gerarFatura(pet, LocalDateTime.now().plusDays(2));
RelatorioHotelPet relatorio = new RelatorioHotelPet(hotel.getPets());
relatorio.listarHospedadosPorEspecie();
```

## Serviços Disponíveis

- **Banho:** 30 minutos, R$30,00
- **Tosa:** 45 minutos, R$40,00
- **Passeio:** 60 minutos, R$20,00

## Como Executar

1. Compile o projeto com Maven, Gradle ou sua IDE Java favorita.
2. Execute a classe principal (`App.java`).
3. Utilize o menu interativo para cadastrar pets, agendar serviços, emitir faturas e gerar relatórios.

## Testes

Os testes unitários estão localizados em `src/test/java/br/com/meuprojeto/`.  
Execute-os com JUnit 5.

---

**Autor:** Seu Nome  
**Licença:** MIT
