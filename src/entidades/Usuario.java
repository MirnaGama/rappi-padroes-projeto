package entidades;
import java.util.ArrayList;

import java.util.List;

public class Usuario {

    private String nome;
    private Long cpf;
    private List<Transacao> transacoes = new ArrayList<>();
    private Nivel nivel;
    private Periodo periodoAtivo;
    private List<Periodo> periodosAnteriores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
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

	public void setPeriodosAnteriores(List<Periodo> periodosAnteriores) {
		this.periodosAnteriores = periodosAnteriores;
	}
	  
}
