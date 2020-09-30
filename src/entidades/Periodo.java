package entidades;

import java.util.Date;

public class Periodo {

	private Date periodoInicio;
	private Date periodoFim;
	private int pontos;
	
	public Date getPeriodoInicio() {
		return periodoInicio;
	}
	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}
	public Date getPeriodoFim() {
		return periodoFim;
	}
	public void setPeriodoFim(Date periodoFim) {
		this.periodoFim = periodoFim;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	
	
}
