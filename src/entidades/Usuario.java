package entidades;
import java.util.List;

public class Usuario {

	private List<Transacao> transacoes;
	private Nivel nivel;
	private Periodo periodoAtivo;
	private List<Periodo> periodosAnteriores;

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
