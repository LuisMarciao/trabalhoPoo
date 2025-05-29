package br.com.meuprojeto;

import java.time.LocalDateTime;

public class ServicoAgendado {
    Servico servico;
    LocalDateTime inicio;
    private LocalDateTime fim;

    public ServicoAgendado(Servico servico, LocalDateTime inicio) {
        this.servico = servico;
        this.inicio = inicio;
        this.fim = inicio.plus(servico.duracao);
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public void setFim(LocalDateTime fim) {
        this.fim = fim;
    }

    
}

