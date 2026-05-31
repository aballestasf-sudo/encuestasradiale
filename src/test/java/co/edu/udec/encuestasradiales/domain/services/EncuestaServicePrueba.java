package co.edu.udec.encuestasradiales.domain.services;

import co.edu.udec.encuestasradiales.domain.enums.ResultadoEncuesta;
import co.edu.udec.encuestasradiales.domain.events.EncuestaRealizadaEvent;
import co.edu.udec.encuestasradiales.domain.model.Encuesta;
import co.edu.udec.encuestasradiales.domain.valueobjects.EncuestaId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EncuestaServicePrueba {
    @Test
    void registrarEncuestaIndiferente() {
        Encuesta encuesta = new Encuesta(
                EncuestaId.generarNuevo(),
                6, 2, 2, 2 // todas las respuestas iguales
        );
        EncuestaService service = new EncuestaService();

        EncuestaRealizadaEvent evento = service.registrarEncuesta(encuesta);

        assertEquals(ResultadoEncuesta.INDIFERENTE, evento.getResultado());
    }

}
