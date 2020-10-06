package entidades;

public class Cartao implements Multiplicador {

	@Override
	public int calcularPontos(int pontos) {
		return  (int) (pontos * 1.5);
	}

	public String toString() {
		return "Cartão";
	}
}
