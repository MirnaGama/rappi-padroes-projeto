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
        System.out.println("Ou 2 para realizar login");

        if (s.nextInt() == 1) {
            cadastrarUsuario();
        } else if (s.nextInt() == 2) {
            System.out.println("Informe seu cpf");
            loginUsuario(s.nextLong());
        } else {
            System.out.println("Opção inválida");
        }
    }

    private static void cadastrarUsuario() {
        Usuario usuario = new Usuario();
        System.out.println("Informe seu nome");
        usuario.setNome(s.next());
        System.out.println("Informe seu cpf");
        usuario.setCpf(s.nextLong());
        usuario.setPeriodoAtivo(setPeriodo());
        usuario.setTransacoes(new ArrayList<>());
        fachada.inserirUsuario(usuario);
    }

    private static void loginUsuario(Long cpf) {
        Usuario usuario = fachada.procurarUsuarioPorCpf(cpf);
        if (usuario != null) {
            System.out.println("Escolha uma opção");
            System.out.println("1 - Inserir transação (compra)");
            System.out.println("2 - Listar transações");
            System.out.println("3 - Listar quantidade de pontos e nível atual");
            System.out.println("4 - Atualizar cadastro");

            switch (s.nextInt()) {
                case 1:
                    inserirTransacao(usuario);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }

    private static void inserirTransacao(Usuario usuario) {
        Transacao transacao = new Transacao();
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
        return periodo;
    }


    public static void main(String[] args) {

        exibirMenuInicial();

//        Usuario u = new Usuario();
//        u.setPeriodoAtivo(periodo);
//
//        Transacao t = new Transacao();
//        t.setPreco(30); // pre�o da transa��o
//        t.setDataTransacao(dateNow); // data da transa��o
//
//        t.setMulti(new Cartao()); // como o usuario vai pagar
//
//        t.setQuantidadePontos((int) t.getPreco()); // pontos gerados
//
//        u.getTransacoes().add(t); // transacao aprovada
//
//        u.getPeriodoAtivo().setPontos(u.getPeriodoAtivo().getPontos() + t.getQuantidadePontos()); // inserida na quantidade de pontos
//
//        System.out.println(
//                "= Usu�rio Tal =" +
//                        "\nValor pago: " + t.getPreco() +
//                        "\nPontos sem multiplicadores: " + ((int) t.getPreco()) +
//                        "\nPontos gerados: " + periodo.getPontos()
//        );

    }

}
