# Pet Hotel

Sistema de gerenciamento de hotel para pets, desenvolvido em Java. Permite cadastrar pets, agendar serviços, emitir faturas e gerar relatórios avançados sobre a hospedagem e os serviços prestados.

## Funcionalidades

- Cadastro de pets com informações completas.
- Agendamento de serviços (Banho, Tosa, Passeio).
- Emissão de faturas detalhadas.
- Relatórios mensais e listagens por espécie e plano.

## Pré-requisitos

- Java 11 ou superior
- (Opcional) Maven ou Gradle para gerenciamento de dependências e build

## Como executar

1. **Clone o repositório:**
   ```sh
   git clone <url-do-seu-repositorio>
   cd pet-hotel-corrigido
   ```

2. **Compile o projeto:**
   - Usando o terminal:
     ```sh
     javac -d bin src/main/java/br/com/meuprojeto/*.java
     ```
   - Ou use sua IDE favorita (VS Code, IntelliJ, Eclipse).

3. **Execute o programa:**
   - Pelo terminal:
     ```sh
     java -cp bin br.com.meuprojeto.App
     ```
   - Ou execute a classe `App` pela sua IDE.

## Estrutura do Projeto

- `src/main/java/br/com/meuprojeto/` — Código-fonte principal
- `src/test/java/br/com/meuprojeto/` — Testes unitários (JUnit)
- `App.java` — Classe principal com menu interativo

## Como usar

Ao executar, utilize o menu para:
- Cadastrar pets
- Agendar serviços
- Gerar faturas
- Gerar relatórios mensais
- Listar pets hospedados por espécie ou plano

## Testes

Os testes estão em `src/test/java/br/com/meuprojeto/`.  
Execute com JUnit 5 pela sua IDE ou linha de comando.

## Licença

MIT

---

**Autor:** Luis Arthur, Jose Pereira, Maria Isadora, Antonio Inocencio
