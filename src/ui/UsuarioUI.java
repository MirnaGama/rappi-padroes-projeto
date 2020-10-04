package ui;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entidades.*;
import fachada.Fachada;

public class UsuarioUI {

    private static Fachada fachada = Fachada.getInstance();
    private static Scanner s = new Scanner(System.in);

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

    private static void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        System.out.println("Informe seu nome");
        usuario.setNome(s.next());
        s.nextLine();
        System.out.println("Informe seu cpf");
        usuario.setCpf(s.nextLong());
        usuario.setPeriodoAtivo(setPeriodo());
        usuario.setTransacoes(new ArrayList<>());
        fachada.inserirUsuario(usuario);
        exibirMenuInicial();
    }

    private static void loginUsuario(Long cpf) {
        Usuario usuario = fachada.procurarUsuarioPorCpf(cpf);
        if (usuario != null) {
            System.out.println("Ol�, " + usuario.getNome() + " !");
            System.out.println("\nEscolha uma op��o");
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
                    //TODO Nivel
                    break;
                case 4:
                    //Ate entao so o nome pode ser atualizado
                    System.out.println("Informe nome para mudan�a");
                    fachada.atualizarUsuario(usuario, s.next());
                    s.nextLine();
                    loginUsuario(cpf);
                    break;
                case 5:
                    //TODO Periodo
                    break;
                default:
                    System.out.println("Op��o inv�lida!");
                    System.out.println("Retornando ao menu inicial ... ");
                    exibirMenuInicial();
                    break;
            }
        }
    }

    private static void inserirTransacao(Usuario usuario) {
        Transacao transacao = new Transacao();
        System.out.println("Informe valor da compra");
        double valorCompra = s.nextDouble();
        transacao.setPreco(valorCompra);
        System.out.println("Informe uma descri��o da compra");
        transacao.setDescricao(s.next());
        s.nextLine();
        transacao.setDataTransacao(new Date());
        System.out.println("Informe como ser� a forma de pagamento da compra");
        System.out.println("1 - Cart�o");
        System.out.println("2 - Prime");
        System.out.println("3 - RappiPay");
        System.out.println("4 - QRCode");
        
        int escolha = s.nextInt();
        
        switch (escolha) {
            case 1:
                transacao.setMulti(new Cartao());
                break;
            case 2:
                transacao.setMulti(new Prime());
                break;
            case 3:
                transacao.setMulti(new RappiPay());
                break;
            case 4:
                transacao.setMulti(new QRCode());
                break;
        }
        transacao.setQuantidadePontos((int) valorCompra);
        fachada.inserirTransacao(transacao, usuario);
    }

    private static Periodo setPeriodo() {
        Calendar c1 = Calendar.getInstance();
        Date dateNow = c1.getTime();

        c1.add(Calendar.MONTH, 3);
        Date dateFinal = c1.getTime();
        Periodo periodo = new Periodo();
        periodo.setPeriodoInicio(dateNow);
        periodo.setPeriodoFim(dateFinal);
        periodo.setPontos(0);
        return periodo;
    }

    public static void main(String[] args) {
        exibirMenuInicial();
    }

}
