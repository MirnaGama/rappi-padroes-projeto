package fachada;

import controlador.IPeriodoControlador;
import controlador.ITransacaoControlador;
import controlador.IUsuarioControlador;
import controlador.impl.PeriodoControladorImpl;
import controlador.impl.TransacaoControladorImpl;
import controlador.impl.UsuarioControladorImpl;
import entidades.Periodo;
import entidades.Transacao;
import entidades.Usuario;

import java.util.Date;
import java.util.List;

public class Fachada implements ITransacaoControlador, IUsuarioControlador, IPeriodoControlador {

    private static Fachada instancia;
    private ITransacaoControlador controladorTransacao;
    private IUsuarioControlador controladorUsuario;
    private IPeriodoControlador controladorPeriodo;

    public static Fachada getInstance() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    private Fachada() {
        controladorTransacao = TransacaoControladorImpl.getInstance();
        controladorUsuario = UsuarioControladorImpl.getInstance();
        controladorPeriodo = PeriodoControladorImpl.getInstance();
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
    public void atualizarUsuario(Usuario usuario, String nome) {
        controladorUsuario.atualizarUsuario(usuario, nome);
    }

    @Override
    public Usuario procurarUsuarioPorCpf(Long cpf) {
        return controladorUsuario.procurarUsuarioPorCpf(cpf);
    }

    @Override
    public Periodo procurarPorData(Date data) { return controladorPeriodo.procurarPorData(data); }

    @Override
    public void atualizarPeriodo(List<Periodo> periodos, Date data, Integer pontos) { controladorPeriodo.atualizarPeriodo(periodos, data, pontos); }

    @Override
    public void popularPeriodos(Usuario usuario) { controladorPeriodo.popularPeriodos(usuario); }

    @Override
    public void listarPeriodos(Usuario usuario) { controladorPeriodo.listarPeriodos(usuario); }

    public void visualizarNivel(Usuario usuario) {
        controladorUsuario.visualizarNivel(usuario);
    }
}
