package repositorio.impl;

import entidades.Transacao;
import entidades.Usuario;
import repositorio.IUsuarioRepositorio;

import java.util.ArrayList;

/**
 * Implementação do repositório de usuário
 */
public class UsuarioRepositorioImpl implements IUsuarioRepositorio {

    private ArrayList<Usuario> usuarios;
    private static UsuarioRepositorioImpl instancia;

    public static UsuarioRepositorioImpl getInstance() {
        if (instancia == null) {
            instancia = new UsuarioRepositorioImpl();
        }
        return instancia;
    }

    private UsuarioRepositorioImpl() {
        usuarios = new ArrayList<>();
    }

    @Override
    public void inserir(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        usuarios.remove(usuario);
    }

    @Override
    public Usuario procurarPorNome(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Usuario usuario, String nome) {
        if (nome != null) {
            usuario.setNome(nome);
        }
    }

    @Override
    public Usuario procurarPorCpf(Long cpf) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }
}
