package controlador.impl;

import controlador.IPeriodoControlador;
import entidades.Periodo;
import repositorio.IPeriodoRepositorio;
import repositorio.IUsuarioRepositorio;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
}
