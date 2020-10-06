package entidades;

import java.util.List;

public class Usuario {

    private String nome;
    private Long cpf;
    private List<Transacao> transacoes;
    private Niveis niveis;
    private Periodo periodoAtivo;
    private List<Periodo> periodosAnteriores;
    private List<Periodo> periodos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public List<Periodo> getPeriodos() { return periodos; }

    public void setPeriodos(List<Periodo> periodos) { this.periodos = periodos; }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

    public Niveis getNiveis() {
        return niveis;
    }

    public void setNiveis(Niveis niveis) {
        this.niveis = niveis;
    }

    public Periodo getPeriodoAtivo() {
		return periodoAtivo;
	}

	public void setPeriodoAtivo(Periodo periodoAtivo) {
		this.periodoAtivo = periodoAtivo;
	}

	public List<Periodo> getPeriodosAnteriores() {
		return periodosAnteriores;
	}

	public void setPeriodosAnteriores(List<Periodo> periodosAnteriores) { this.periodosAnteriores = periodosAnteriores; }
}
