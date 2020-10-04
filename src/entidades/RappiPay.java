package entidades;

public class RappiPay implements Multiplicador {

	@Override
	public int calcularPontos(int pontos) {
		return  (int) (pontos * 1.5);
	}

}
