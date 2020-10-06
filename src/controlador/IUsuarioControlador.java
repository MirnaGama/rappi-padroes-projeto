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

    void visualizarNivel(Usuario usuario);
}
