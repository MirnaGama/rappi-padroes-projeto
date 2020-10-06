package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.*;
import fachada.Fachada;

public class UsuarioUI {

    private static Fachada fachada = Fachada.getInstance();
    private static Scanner s = new Scanner(System.in);

    
    private static void popularSistema() {
    	Usuario u = new Usuario();
    	Niveis n = new Niveis();
    	u.setCpf((long) 12345);
        u.setNome("Gloria");
        u.setNiveis(n);
        u.getNiveis().setNomeNivel(NivelEnum.BRONZE);
        fachada.popularPeriodos(u);
    	// u.setPeriodoAtivo(setPeriodo());
        
    	List<Transacao> transacoes = new ArrayList<Transacao>();
        Transacao t = new Transacao();
    	
    	Calendar c = Calendar.getInstance();
		c.set(2020, Calendar.FEBRUARY, 28);
        Date data = c.getTime();
        t.setDataTransacao(data);
    	t.setDescricao("Pizza Hut");
    	t.setPreco(75);
    	t.setMulti(new Prime());
    	t.setQuantidadePontos((int) t.getPreco());
    	transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());

    	t = new Transacao();
    	c.set(2020, Calendar.MARCH, 20);
		data = c.getTime();
		
		t.setDataTransacao(data);
    	t.setDescricao("Carrefour");
    	t.setPreco(300);
    	t.setMulti(new Cartao());
    	t.setQuantidadePontos((int) t.getPreco());
    	transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());


        t = new Transacao();
        c.set(2020, Calendar.JULY, 01);
        data = c.getTime();

        t.setDataTransacao(data);
        t.setDescricao("Mc Donald's");
        t.setPreco(45.50);
        t.setMulti(new Prime());
        t.setQuantidadePontos((int) t.getPreco());
        transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());

        t = new Transacao();
        c.set(2020, Calendar.JULY, 04);
        data = c.getTime();

        t.setDataTransacao(data);
        t.setDescricao("Carrefour");
        t.setPreco(255);
        t.setMulti(new Cartao());
        t.setQuantidadePontos((int) t.getPreco());
        transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());
        
        t = new Transacao();
        c.set(2020, Calendar.AUGUST, 12);
        data = c.getTime();

        t.setDataTransacao(data);
        t.setDescricao("Carrefour");
        t.setPreco(150);
        t.setMulti(new RappiPay());
        t.setQuantidadePontos((int) t.getPreco());
        transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());

        t = new Transacao();
        c.set(2020, Calendar.SEPTEMBER, 01);
        data = c.getTime();

        t.setDataTransacao(data);
        t.setDescricao("Wallmart");
        t.setPreco(355);
        t.setMulti(new QRCode());
        t.setQuantidadePontos((int) t.getPreco());
        transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());
        
        t = new Transacao();
        c.set(2020, Calendar.SEPTEMBER, 03);
        data = c.getTime();

        t.setDataTransacao(data);
        t.setDescricao("Drogasil");
        t.setPreco(56.50);
        t.setMulti(new Cartao());
        t.setQuantidadePontos((int) t.getPreco());
        transacoes.add(t);
        fachada.atualizarPeriodo(u.getPeriodos(), data, t.getQuantidadePontos());
    	
    	u.setTransacoes(transacoes);
    	
    	fachada.inserirUsuario(u);
    }
    
    private static void exibirMenuInicial() {
        System.out.println("--- BEM VINDO AO SUBSISTEMA RAPPI ---");
        System.out.println("\nEscolha uma op��o");
        System.out.println("1 - Cadastro");
        System.out.println("2 - Login");

        s = new Scanner(System.in);
        int escolha = s.nextInt();
        
         if (escolha == 1) {
            cadastrarUsuario();
        } else if (escolha == 2) {
            System.out.println("Informe seu cpf");
            loginUsuario(s.nextLong());
        } else {
            System.out.println("Op��o inv�lida!");
            System.out.println("Saindo do sistema ");
        } 
         
        s.close();
    }

    private static void exibirOpcoes(Usuario usuario, Long cpf) {
        System.out.println("Escolha o que deseja fazer a seguir: ");
        System.out.println("1 - Inserir transa��o (compra)");
        System.out.println("2 - Listar hist�rico de transa��es");
        System.out.println("3 - Visualizar n�vel atual e vantagens");
        System.out.println("4 - Atualizar cadastro");
        System.out.println("5 - Visualizar informa��es sobre per�odo e pontos");

        int escolha = s.nextInt();

        switch (escolha) {
            case 1:
                inserirTransacao(usuario);
                loginUsuario(cpf);
                break;
            case 2:
                fachada.listarTransacoes(usuario);
                loginUsuario(cpf);
                break;
            case 3:
                fachada.visualizarNivel(usuario);
                exibirOpcoes(usuario, cpf);
                break;
            case 4:
                //Ate entao so o nome pode ser atualizado
                System.out.println("Informe nome para mudan�a");
                fachada.atualizarUsuario(usuario, s.next());
                s.nextLine();
                loginUsuario(cpf);
                break;
            case 5:
                System.out.println("PER�ODOS\n");
                fachada.listarPeriodos(usuario);
                exibirOpcoes(usuario, cpf);
                break;
            default:
                System.out.println("Op��o inv�lida!");
                System.out.println("Retornando ao menu inicial ... ");
                exibirMenuInicial();
                break;
        }
    }

    private static void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        Niveis n = new Niveis();
        usuario.setNiveis(n);
        System.out.println("Informe seu nome");
        usuario.setNome(s.next());
        s.nextLine();
        System.out.println("Informe seu cpf");
        usuario.setCpf(s.nextLong());
        usuario.setTransacoes(new ArrayList<>());
        usuario.getNiveis().setNomeNivel(NivelEnum.BRONZE);
        fachada.inserirUsuario(usuario);
        fachada.popularPeriodos(usuario);
        exibirMenuInicial();
    }

    private static void loginUsuario(Long cpf) {
        Usuario usuario = fachada.procurarUsuarioPorCpf(cpf);
        if (usuario != null) {
            System.out.println("\nOlá, " + usuario.getNome() + "! Bem vindo(a)!\n");
            exibirOpcoes(usuario, cpf);
        } else {
        	exibirMenuInicial();
        }
    }

    private static void inserirTransacao(Usuario usuario) {
    	
        Transacao transacao = new Transacao();
        System.out.println("Informe valor da compra:");
        double valorCompra = s.nextDouble();
        transacao.setPreco(valorCompra);
        System.out.println("Informe uma descri��o da compra:");
        transacao.setDescricao(s.next());
        s.nextLine();
        transacao.setDataTransacao(new Date());
        System.out.println("Informe como ser� a forma de pagamento da compra:");
        System.out.println("1 - Dinheiro");
        System.out.println("2 - Cart�o");
        System.out.println("3 - Prime");
        System.out.println("4 - RappiPay");
        System.out.println("5 - QRCode");
        
        int escolha = s.nextInt();
        
        switch (escolha) {       
            case 1:
            	transacao.setMulti(null);
            	break;
            case 2:
                transacao.setMulti(new Cartao());
                break;
            case 3:
                transacao.setMulti(new Prime());
                break;
            case 4:
                transacao.setMulti(new RappiPay());
                break;
            case 5:
                transacao.setMulti(new QRCode());
                break;
        }
        transacao.setQuantidadePontos((int) valorCompra);
        fachada.atualizarPeriodo(usuario.getPeriodos(), new Date(), transacao.getQuantidadePontos());
        fachada.inserirTransacao(transacao, usuario);

    }

    public static void main(String[] args) {
        popularSistema();
    	exibirMenuInicial();
    }

}
