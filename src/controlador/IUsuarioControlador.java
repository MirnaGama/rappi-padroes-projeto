package controlador;

import entidades.Usuario;


public interface IUsuarioControlador {

    /**
     * Inserir um usuário
     *
     * @param usuario
     */
    void inserirUsuario(Usuario usuario);

    /**
     * Atualizar o usuário
     *
     * @param usuario
     * @param nome
     */
    void atualizarUsuario(Usuario usuario, String nome);

    /**
     * Procura um usuário por Cpf
     *
     * @param cpf
     * @return Usuario
     */
    Usuario procurarUsuarioPorCpf(Long cpf);

    /**
     * Procura um usuário por Cpf
     *
     * @param usuario
     * @return Usuario
     */
    void popularPeriodos(Usuario usuario);

    /**
     * Listar períodos e pontos de um usuario
     *
     * @param usuario
     * @return Usuario
     */
    void listarPeriodos(Usuario usuario);

}
