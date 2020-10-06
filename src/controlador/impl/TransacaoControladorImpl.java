package controlador.impl;

import java.text.SimpleDateFormat;

import controlador.ITransacaoControlador;
import entidades.NivelEnum;
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
        atualizarNivel(usuario);
        this.repositorioTransacao.inserir(transacao, usuario);
        System.out.println("Transação inserida com sucesso!");
    }

    @Override
    public void listarTransacoes(Usuario usuario) {

    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
    	
        if (usuario.getTransacoes() != null && !usuario.getTransacoes().isEmpty()) {
            System.out.println("---------- Transações ---------");
        } else {
            System.out.println("Não existe nenhuma transação deste usuário");
        }

        for (Transacao transacao : usuario.getTransacoes()) {
            System.out.println("Descrição: " + transacao.getDescricao());
            System.out.println("Preço: " + transacao.getPreco());
            System.out.println("Data: " + format.format(transacao.getDataTransacao()));
            System.out.println("Forma de pagamento: " + (transacao.getMulti() == null ? "Dinheiro" : transacao.getMulti().toString()));
            System.out.println("Quantidade de pontos gerados na transação: " + transacao.getQuantidadePontos()+"\n");

        }

    }

    private void atualizarNivel(Usuario usuario){
        if (usuario.getPeriodoAtivo().getPontos() >= 1200 && usuario.getPeriodoAtivo().getPontos() < 4000){
            usuario.getNiveis().setNomeNivel(NivelEnum.PRATA);
        }else if (usuario.getPeriodoAtivo().getPontos() >= 4000 && usuario.getPeriodoAtivo().getPontos() < 10000){
            usuario.getNiveis().setNomeNivel(NivelEnum.OURO);
        }else if (usuario.getPeriodoAtivo().getPontos() >= 10000 ){
            usuario.getNiveis().setNomeNivel(NivelEnum.DIAMANTE);
        }
    }
}
