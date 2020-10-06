package controlador.impl;

import controlador.IUsuarioControlador;
import entidades.*;
import repositorio.IUsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UsuarioControladorImpl implements IUsuarioControlador {

    private static UsuarioControladorImpl instancia;
    private IUsuarioRepositorio repositorioUsuario;

    public static UsuarioControladorImpl getInstance() {
        if (instancia == null) {
            instancia = new UsuarioControladorImpl();
        }
        return instancia;
    }

    private UsuarioControladorImpl() {
        repositorioUsuario = UsuarioRepositorioImpl.getInstance();
    }

    @Override
    public void inserirUsuario(Usuario usuario) {
        if (repositorioUsuario.procurarPorCpf(usuario.getCpf()) != null) {
            System.out.println("Usuario ja existente!");
        } else {
            repositorioUsuario.inserir(usuario);
            System.out.println("Usuario cadastrado com sucesso!");
        }
    }

    @Override
    public void atualizarUsuario(Usuario usuario, String nome) {
        if (nome != null) {
            repositorioUsuario.atualizar(usuario, nome);
        }
    }

    @Override
    public Usuario procurarUsuarioPorCpf(Long cpf) {
        Usuario usuario = repositorioUsuario.procurarPorCpf(cpf);
        if (usuario != null) {
            return usuario;
        } else {
            System.out.println("Usuario inexistente!");
            return null;
        }
    }

    public void visualizarNivel(Usuario usuario) {
        System.out.println(usuario.getNiveis().getNomeNivel().toString());
        System.out.println("Os beneficios sao" + usuario.getNiveis().getBeneficios());
    }

}
