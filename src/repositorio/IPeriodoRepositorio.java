package repositorio;

import entidades.Periodo;
import entidades.Usuario;

import java.util.Date;

/**
 * Interface do repositório de periodo
 */
public interface IPeriodoRepositorio {

    /**
     * Procurar periodo pela data
     *
     * @param data
     * @return Periodo
     */
    Periodo procurarPorData(Date data);

}
