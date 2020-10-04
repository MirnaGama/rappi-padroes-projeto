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
        System.out.println("Transa��o inserida com sucesso!");
    }

    @Override
    public void listarTransacoes(Usuario usuario) {

        if (usuario.getTransacoes() != null && !usuario.getTransacoes().isEmpty()) {
            System.out.println("---------- Transa��es ---------");
        } else {
            System.out.println("N�o existe nenhuma transa��es deste usu�rio");
        }

        for (Transacao transacao : usuario.getTransacoes()) {
            System.out.println("Descri��o: " + transacao.getDescricao());
            System.out.println("Pre�o: " + transacao.getPreco());
            System.out.println("Data da transa��o: " + transacao.getDataTransacao());
            System.out.println("Quantidade de pontos gerados na transa��o: " + transacao.getQuantidadePontos()+"\n");

        }

    }
}
