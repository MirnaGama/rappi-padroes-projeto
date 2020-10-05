package controlador.impl;

import controlador.IUsuarioControlador;
import entidades.Periodo;
import entidades.Transacao;
import entidades.Usuario;
import repositorio.IUsuarioRepositorio;
import repositorio.impl.UsuarioRepositorioImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
            System.out.println("Usu�rio j� existente!");
        } else {
            repositorioUsuario.inserir(usuario);
            System.out.println("Usu�rio cadastrado com sucesso!");
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
            System.out.println("Usu�rio inexistente!");
            return null;
        }
    }

    @Override
    public void popularPeriodos(Usuario usuario) {
        List<Periodo> periodosAno = new ArrayList<Periodo>();
        List<Periodo> periodos = new ArrayList<Periodo>();
        Calendar calendar = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        Periodo periodoAtivo = null;
        Integer fim = 0;
        Integer inicio = 0;
        for (int i = 0; i <= 3; i++) {
            Periodo p = new Periodo();
            calendar.set(2020, inicio, 1);

            p.setPeriodoInicio(calendar.getTime());
            fim = inicio + 2;
            calendar.set(2020, fim, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            p.setPeriodoFim(calendar.getTime());
            inicio = fim + 1;
            p.setPontos(0);
            if (c.getTime().after(p.getPeriodoInicio()) && c.getTime().before((p.getPeriodoFim()))) {
                periodoAtivo = p;
            } else if (periodoAtivo == null){
                periodosAno.add(p);
            }
            periodos.add(p);
        }
        usuario.setPeriodoAtivo(periodoAtivo);
        usuario.setPeriodosAnteriores(periodosAno);
        usuario.setPeriodos(periodos);
    }

    @Override
    public void listarPeriodos(Usuario usuario) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YY");
        System.out.println("Período atual" +
                            "\n" + format.format(usuario.getPeriodoAtivo().getPeriodoInicio()) + " - " + format.format(usuario.getPeriodoAtivo().getPeriodoFim()) +
                            "\n" + usuario.getPeriodoAtivo().getPontos());

        for (Periodo periodo : usuario.getPeriodosAnteriores()) {
            System.out.println("Período finalizado" +
                                "\n" + format.format(periodo.getPeriodoInicio()) + " - " + format.format(periodo.getPeriodoFim()) +
                                "\n" + periodo.getPontos());
        }
    }
}
