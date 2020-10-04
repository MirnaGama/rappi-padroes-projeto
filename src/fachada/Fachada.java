package fachada;

import controlador.ITransacaoControlador;
import controlador.IUsuarioControlador;
import controlador.impl.TransacaoControladorImpl;
import controlador.impl.UsuarioControladorImpl;
import entidades.Transacao;
import entidades.Usuario;

import java.util.List;

public class Fachada implements ITransacaoControlador, IUsuarioControlador {

    private static Fachada instancia;
    private ITransacaoControlador controladorTransacao;
    private IUsuarioControlador controladorUsuario;

    public static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        controladorTransacao = TransacaoControladorImpl.getInstance();
        controladorUsuario = UsuarioControladorImpl.getInstance();
    }


    @Override
    public void inserirTransacao(Transacao transacao, Usuario usuario) {
        controladorTransacao.inserirTransacao(transacao, usuario);
    }

    @Override
    public void listarTransacoes(Usuario usuario) {
        controladorTransacao.listarTransacoes(usuario);
    }

    @Override
    public void inserirUsuario(Usuario usuario) {
        controladorUsuario.inserirUsuario(usuario);
    }

    @Override
    public void atualizarUsuario(Usuario usuario, String nome, List<Transacao> transacoes) {
        controladorUsuario.atualizarUsuario(usuario, nome, null);
    }

    @Override
    public Usuario procurarUsuarioPorCpf(Long cpf) {
        return controladorUsuario.procurarUsuarioPorCpf(cpf);
    }
}
