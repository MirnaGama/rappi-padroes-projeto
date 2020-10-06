package repositorio;

import entidades.Periodo;
import entidades.Transacao;
import entidades.Usuario;

import java.util.List;

/**
 * Interface do repositório de usuários
 */
public interface IUsuarioRepositorio {

    /**
     * Inseri um usuário
     *
     * @param usuario
     */
    void inserir(Usuario usuario);

    /**
     * Remove um usuário pelo cpf
     *
     * @param usuario
     */
    void remover(Usuario usuario);

    /**
     * Procurar usuário pelo nome
     *
     * @param nome
     * @return Usuario
     */
    Usuario procurarPorNome(String nome);

    /**
     * Atualizar o usuário
     *
     * @param usuario
     * @param nome
     */
    void atualizar(Usuario usuario, String nome);

    /**
     * Procura um usuário por Cpf
     *
     * @param cpf
     * @return Usuario
     */
    Usuario procurarPorCpf(Long cpf);

    /**
     * Popula periodos de um usuário
     *
     * @return Usuario
     */
    List<Periodo> popularPeriodos();
}
