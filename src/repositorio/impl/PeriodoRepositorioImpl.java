package repositorio.impl;

import entidades.Periodo;
import entidades.Usuario;
import repositorio.IPeriodoRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Implementação do repositório de periodo
 */
public class PeriodoRepositorioImpl implements IPeriodoRepositorio {

    private ArrayList<Periodo> periodos;
    private static PeriodoRepositorioImpl instancia;

    public static PeriodoRepositorioImpl getInstance() {
        if (instancia == null) {
            instancia = new PeriodoRepositorioImpl();
        }
        return instancia;
    }

    private PeriodoRepositorioImpl() {
        periodos = new ArrayList<>();
    }

    @Override
    public Periodo procurarPorData(Date data) {
        for (Periodo periodo : periodos) {
            if (data.after(periodo.getPeriodoInicio()) && data.before((periodo.getPeriodoFim()))) {
                return periodo;
            }
        }
        return null;
    }
}
