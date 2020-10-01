package ui;

import java.util.Calendar;
import java.util.Date;

import entidades.*;

public class UsuarioUI {
	public static void main(String[] args) {
		
		Calendar c1 = Calendar.getInstance(); 
		Date dateNow = c1.getTime(); 
		
		c1.add(Calendar.MONTH, 3);
		Date dateFinal = c1.getTime();
		Periodo periodo = new Periodo();
		periodo.setPeriodoInicio(dateNow);
		periodo.setPeriodoFim(dateFinal);
		
		Usuario u = new Usuario();
		u.setPeriodoAtivo(periodo);
		
		Transacao t = new Transacao();
		t.setPreco(30); // preço da transação
		t.setDataTransacao(dateNow); // data da transação
		
		t.setMulti(new Cartao()); // como o usuario vai pagar
		
		t.setQuantidadePontos((int) t.getPreco()); // pontos gerados
		
		u.getTransacoes().add(t); // transacao aprovada
		
		u.getPeriodoAtivo().setPontos( u.getPeriodoAtivo().getPontos() + t.getQuantidadePontos() ); // inserida na quantidade de pontos
		
		System.out.println(
				"= Usuário Tal =" +
		        "\nValor pago: "+t.getPreco()+
		        "\nPontos sem multiplicadores: "+((int)t.getPreco())+
		        "\nPontos gerados: "+periodo.getPontos()
				);
		
	}
}
