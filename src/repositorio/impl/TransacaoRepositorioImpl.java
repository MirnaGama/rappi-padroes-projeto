package repositorio.impl;

import entidades.Transacao;
import entidades.Usuario;
import repositorio.ITransacaoRepositorio;

import java.util.List;

/**
 * Implementação do repositório de transacao
 */
public class TransacaoRepositorioImpl implements ITransacaoRepositorio {

    private static TransacaoRepositorioImpl instancia;

    public static TransacaoRepositorioImpl getInstance() {
        if (instancia == null) {
            instancia = new TransacaoRepositorioImpl();
        }
        return instancia;
    }

    @Override
    public void inserir(Transacao transacao, Usuario usuario) {
        List<Transacao> transacoes = usuario.getTransacoes();
        transacoes.add(transacao);
        usuario.setTransacoes(transacoes);
    }

    @Override
    public List<Transacao> listar(Usuario usuario) {
        return usuario.getTransacoes();
    }
}
