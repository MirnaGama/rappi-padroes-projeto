package repositorio;

import entidades.Transacao;
import entidades.Usuario;

import java.util.List;

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

    /**
     * Lista todas as transações do usuário
     *
     * @return List<Transacao>
     */
    List<Transacao> listar(Usuario usuario);

}
