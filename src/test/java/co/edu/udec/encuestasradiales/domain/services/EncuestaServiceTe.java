package co.edu.udec.encuestasradiales.domain.services;


import co.edu.udec.encuestasradiales.domain.model.Encuesta;
import co.edu.udec.encuestasradiales.domain.valueobjects.EncuestaId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EncuestaServiceTe {
    @Test
    void calcularPorcentajesCorrectos() {
        Encuesta encuesta = new Encuesta(
                EncuestaId.generarNuevo(),
                10, 6, 3, 1
        );
        EncuestaService service = new EncuestaService();

        double porcentajeAprobacion = service.calcularPorcentajeAprobacion(encuesta);
        double porcentajeRechazo = service.calcularPorcentajeRechazo(encuesta);
        double porcentajeIndiferencia = service.calcularPorcentajeIndiferencia(encuesta);

        assertEquals(60.0, porcentajeAprobacion);
        assertEquals(30.0, porcentajeRechazo);
        assertEquals(10.0, porcentajeIndiferencia);
    }}


