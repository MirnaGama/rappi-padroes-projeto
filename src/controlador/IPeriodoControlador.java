package controlador;

import entidades.Periodo;
import entidades.Usuario;

import java.util.Date;
import java.util.List;

public interface IPeriodoControlador {
    /**
     * Inseri um Periodo
     *
     * @param data
     */
    Periodo procurarPorData(Date data);

    void atualizarPeriodo(List<Periodo> periodo, Date data, Integer pontos);

    void popularPeriodos(Usuario usuario);

    void listarPeriodos(Usuario usuario);
}
