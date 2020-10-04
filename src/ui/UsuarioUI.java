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
        System.out.println("Escolha uma opção");
        System.out.println("Digite 1 para se cadastrar");
        System.out.println("2 para realizar login");

        if (s.nextInt() == 1) {
            cadastrarUsuario();
        } else if (s.nextInt() == 2) {
            System.out.println("Informe seu cpf");
            loginUsuario(s.nextLong());
        } else {
            System.out.println("Opção inválida!");
            System.out.println("Saindo do sistema ");
        }
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
        usuario.getNiveis().setNomeNivel(NivelEnum.BRONZE);
        fachada.inserirUsuario(usuario);
        exibirMenuInicial();
    }

    private static void loginUsuario(Long cpf) {
        Usuario usuario = fachada.procurarUsuarioPorCpf(cpf);
        if (usuario != null) {
            System.out.println("Olá " + usuario.getNome());
            System.out.println("Escolha uma opção");
            System.out.println("1 - Inserir transação (compra)");
            System.out.println("2 - Listar transações");
            System.out.println("3 - Visualizar nível atual e vantagens");
            System.out.println("4 - Atualizar cadastro");
            System.out.println("5 - Visualizar informações sobre período e pontos");

            switch (s.nextInt()) {
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
                    break;
                case 4:
                    //Até então so o nome pode ser atualizado
                    System.out.println("Informe nome para mudança");
                    fachada.atualizarUsuario(usuario, s.next());
                    s.nextLine();
                    loginUsuario(cpf);
                    break;
                case 5:
                    //TODO Perídodo
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("Retornando ao menu inicial ");
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
        System.out.println("Informe uma descrição da compra");
        transacao.setDescricao(s.next());
        s.nextLine();
        transacao.setDataTransacao(new Date());
        System.out.println("Informe como será a forma de pagamento da compra");
        System.out.println("1 - Cartão");
        System.out.println("2 - Prime");
        System.out.println("3 - RappiPay");
        System.out.println("4 - QRCode");
        switch (s.nextInt()) {
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
