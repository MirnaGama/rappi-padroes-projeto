package controlador;

import entidades.Transacao;
import entidades.Usuario;

public interface ITransacaoControlador {

    /**
     * Insere uma transação
     *
     * @param transacao
     */
    void inserirTransacao(Transacao transacao, Usuario usuario);

    /**
     * Lista todas as transações do usuário
     *
     */
    void listarTransacoes(Usuario usuario);
}
