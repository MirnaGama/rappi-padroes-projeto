package controlador.impl;

import controlador.ITransacaoControlador;
import entidades.Transacao;
import entidades.Usuario;
import repositorio.ITransacaoRepositorio;
import repositorio.impl.TransacaoRepositorioImpl;

public class TransacaoControladorImpl implements ITransacaoControlador {

    private static TransacaoControladorImpl instancia;
    private ITransacaoRepositorio repositorioTransacao;

    public static TransacaoControladorImpl getInstance() {
        if (instancia == null) {
            instancia = new TransacaoControladorImpl();
        }
        return instancia;
    }

    private TransacaoControladorImpl() {
        repositorioTransacao = TransacaoRepositorioImpl.getInstance();
    }

    @Override
    public void inserirTransacao(Transacao transacao, Usuario usuario) {
        usuario.getPeriodoAtivo().setPontos(usuario.getPeriodoAtivo().getPontos() + transacao.getQuantidadePontos());
        this.repositorioTransacao.inserir(transacao, usuario);
        System.out.println("Transação inserida com sucesso!");
    }

    @Override
    public void listarTransacoes(Usuario usuario) {

        if (usuario.getTransacoes() != null && !usuario.getTransacoes().isEmpty()) {
            System.out.println("---------- Transações ---------");
        } else {
            System.out.println("Não existe nenhuma transação deste usuário");
        }

        for (Transacao transacao : usuario.getTransacoes()) {
            System.out.println("Descrição: " + transacao.getDescricao());
            System.out.println("Preço: " + transacao.getPreco());
            System.out.println("Data da transação: " + transacao.getDataTransacao());
            System.out.println("Quantidade de pontos gerados na transação: " + transacao.getQuantidadePontos());
            System.out.println(" ");

        }

    }
}
