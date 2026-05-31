package co.edu.udec.encuestasradiales.domain.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.udec.encuestasradiales.domain.model.Encuesta;
import co.edu.udec.encuestasradiales.domain.valueobjects.EncuestaId;
import co.edu.udec.encuestasradiales.domain.enums.ResultadoEncuesta;
import co.edu.udec.encuestasradiales.domain.events.EncuestaRealizadaEvent;

public class EncuestaServiceTest {

    @Test
    void registrarEncuestaDevuelveEventoCorrecto() {
        Encuesta encuesta = new Encuesta(
                EncuestaId.generarNuevo(),
                10, 6, 3, 1
        );
        EncuestaService service = new EncuestaService();

        EncuestaRealizadaEvent evento = service.registrarEncuesta(encuesta);

        assertNotNull(evento);
        assertEquals(encuesta.getId(), evento.getEncuestaId());
        assertEquals(ResultadoEncuesta.APROBADO, evento.getResultado());
        assertNotNull(evento.getFechaEvento());
    }

    @Test
    void registrarEncuestaRechazada() {
        Encuesta encuesta = new Encuesta(
                EncuestaId.generarNuevo(),
                5, 1, 3, 1
        );
        EncuestaService service = new EncuestaService();

        EncuestaRealizadaEvent evento = service.registrarEncuesta(encuesta);

        assertEquals(ResultadoEncuesta.RECHAZADO, evento.getResultado());
    }
}


