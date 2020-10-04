package repositorio;

import entidades.Transacao;
import entidades.Usuario;

/**
 * Interface do repositório de transacao
 */
public interface ITransacaoRepositorio {

    /**
     * Insere uma transação
     *
     * @param transacao
     */
    void inserir(Transacao transacao, Usuario usuario);

}
