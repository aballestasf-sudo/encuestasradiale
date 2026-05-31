package co.edu.udec.encuestasradiales.domain.events;

import java.time.LocalDateTime;
import co.edu.udec.encuestasradiales.domain.valueobjects.EncuestaId;
import co.edu.udec.encuestasradiales.domain.enums.ResultadoEncuesta;

public class EncuestaRealizadaEvent {
    private final EncuestaId encuestaId;
    private final ResultadoEncuesta resultado;
    private final LocalDateTime fechaEvento;

    public EncuestaRealizadaEvent(EncuestaId encuestaId, ResultadoEncuesta resultado) {
        this.encuestaId = encuestaId;
        this.resultado = resultado;
        this.fechaEvento = LocalDateTime.now();
    }

    public EncuestaId getEncuestaId() { return encuestaId; }
    public ResultadoEncuesta getResultado() { return resultado; }
    public LocalDateTime getFechaEvento() { return fechaEvento; }
}
