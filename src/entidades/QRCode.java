package entidades;

public class QRCode implements Multiplicador {

	@Override
	public int calcularPontos(int pontos) {
		return  pontos * 2;
	}
	
	public String toString() {
		return "QRCode";
	}
}