package controlador;

import entidades.Transacao;
import entidades.Usuario;

import java.util.List;

public interface IUsuarioControlador {

    /**
     * Inseri um usuário
     *
     * @param usuario
     */
    void inserirUsuario(Usuario usuario);

    /**
     * Atualizar o usuário
     *
     * @param usuario
     * @param nome
     * @param transacoes
     */
    void atualizarUsuario(Usuario usuario, String nome, List<Transacao> transacoes);

    /**
     * Procura um usuário por Cpf
     *
     * @param cpf
     * @return Usuario
     */
    Usuario procurarUsuarioPorCpf(Long cpf);
}
