package controlador.impl;

import com.sun.xml.internal.ws.util.StringUtils;
import controlador.IPeriodoControlador;
import entidades.Niveis;
import entidades.NivelEnum;
import entidades.Periodo;
import entidades.Usuario;
import repositorio.IPeriodoRepositorio;
import repositorio.IUsuarioRepositorio;

import java.text.SimpleDateFormat;
import java.util.*;

public class PeriodoControladorImpl implements IPeriodoControlador {
    private static PeriodoControladorImpl instancia;
    private IPeriodoRepositorio repositorioPeriodo;

    public static PeriodoControladorImpl getInstance(){
        if (instancia == null){
            instancia = new PeriodoControladorImpl();
        }
        return instancia;
    }

    @Override
    public Periodo procurarPorData(Date data) {
        Periodo periodo = repositorioPeriodo.procurarPorData(data);
        if (periodo != null) {
            return periodo;
        } else {
            System.out.println("Periodo inexistente!");
            return null;
        }
    }

    @Override
    public void atualizarPeriodo(List<Periodo> periodos, Date data, Integer pontos) {
        for (Periodo periodo : periodos) {
            if (data.after(periodo.getPeriodoInicio()) && data.before((periodo.getPeriodoFim()))) {
                periodo.setPontos(periodo.getPontos() + pontos);
            }
        }
    }


    @Override
    public void popularPeriodos(Usuario usuario) {
        List<Periodo> periodosAno = new ArrayList<Periodo>();
        List<Periodo> periodos = new ArrayList<Periodo>();

        Calendar calendar = Calendar.getInstance();
        Calendar c = Calendar.getInstance();
        Periodo periodoAtivo = null;

        Integer fim = 11;
        Integer inicio;

        for (int i = 0; i <= 3; i++) {
            Periodo p = new Periodo();
            p.setPontos(0);
            inicio = fim - 2;

            calendar.set(2020, inicio, 1);
            p.setPeriodoInicio(calendar.getTime());

            calendar.set(2020, fim, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            p.setPeriodoFim(calendar.getTime());

            fim = inicio - 1;

            if (c.getTime().after(p.getPeriodoInicio()) && c.getTime().before((p.getPeriodoFim()))) {
                periodoAtivo = p;
                periodos.add(p);
            } else if (periodoAtivo != null) {
                periodosAno.add(p);
                periodos.add(p);
            }
        }

        usuario.setPeriodoAtivo(periodoAtivo);
        usuario.setPeriodosAnteriores(periodosAno);
        usuario.setPeriodos(periodos);
    }

    @Override
    public void listarPeriodos(Usuario usuario) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YY");

        Integer pontosAtuais = somarPontos(usuario.getPeriodos());
        Niveis nivel = verificarNivel(pontosAtuais);
        Integer maxPontos = verificarPontos(nivel);

        System.out.println("- PERÍODO ATUAL -" +
                "\n" +
                "\n" + format.format(usuario.getPeriodoAtivo().getPeriodoInicio()) + " - " + format.format(usuario.getPeriodoAtivo().getPeriodoFim()) +
                "\n" +
                "\n" + pontosAtuais + " de " + maxPontos + "pts" +
                "\nNível: " + nivel.getNomeNivel() +
                "\n" +
                "\nFaltam " + diasParaFinalizar(usuario.getPeriodoAtivo().getPeriodoFim()) + " dias para finalizar" +
                "\n-----------------------------------------");

        pontosAtuais = 0;
        Integer indice = 0;
        List<Periodo> periodosAnteriores = usuario.getPeriodosAnteriores();
        for (Periodo periodo : periodosAnteriores) {
            pontosAtuais = somarPontosAnteriores(indice, periodosAnteriores);
            nivel = verificarNivel(pontosAtuais);
            maxPontos = verificarPontos(nivel);
            System.out.println("- PERÍODO FINALIZADO -" +
                    "\n" +
                    "\nPrazo: " + format.format(periodo.getPeriodoInicio()) + " - " + format.format(periodo.getPeriodoFim()) +
                    "\n" +
                    "\nPontos: " + pontosAtuais + " de " + maxPontos + "pts" +
                    "\nNível: " + nivel.getNomeNivel() +
                    "\n-----------------------------------------");
            indice++;
        }
    }

    public Niveis verificarNivel(Integer pontosAtuais) {
        Niveis n = new Niveis();
        if (pontosAtuais >= 1200 && pontosAtuais < 4000){
            n.setNomeNivel(NivelEnum.PRATA);
        }else if (pontosAtuais >= 4000 && pontosAtuais < 10000){
            n.setNomeNivel(NivelEnum.OURO);
        }else if (pontosAtuais >= 10000 ){
            n.setNomeNivel(NivelEnum.DIAMANTE);
        } else {
            n.setNomeNivel(NivelEnum.BRONZE);
        }
        return n;
    }

    public Integer verificarPontos(Niveis n) {
        Integer pontos = 0;
        if (n.getNomeNivel() == NivelEnum.PRATA) {
            pontos = 4000;
        } else if (n.getNomeNivel() == NivelEnum.OURO){
            pontos = 10000;
        } else if (n.getNomeNivel() == NivelEnum.BRONZE) {
            pontos = 1200;
        }
        return pontos;
    }

    public Integer somarPontos(List<Periodo> periodos) {
        Integer pontos = 0;
        for (Periodo periodo : periodos) {
            pontos += periodo.getPontos();
        }
        return pontos;
    }

    public Integer somarPontosAnteriores(Integer indice, List<Periodo> periodos) {
        Integer index = periodos.size();
        Integer pontos = 0;
        for(Periodo peridodo : periodos){
            if (indice <= index) {
                pontos += peridodo.getPontos();
            }
        }
        return pontos;
    }

    public Integer diasParaFinalizar(Date date) {
        Date hoje = new Date();
        return (int)((date.getTime() - hoje.getTime()) / (1000 * 60 * 60 * 24));
    }
}
