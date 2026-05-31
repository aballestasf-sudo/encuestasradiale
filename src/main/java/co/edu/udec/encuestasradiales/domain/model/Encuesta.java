package co.edu.udec.encuestasradiales.domain.model;

import co.edu.udec.encuestasradiales.domain.valueobjects.EncuestaId;
import co.edu.udec.encuestasradiales.domain.enums.ResultadoEncuesta;
import co.edu.udec.encuestasradiales.domain.exceptions.EncuestaException;

public class Encuesta {
    private final EncuestaId id;
    private final int totalEncuestados;
    private final int aprobaciones;
    private final int rechazos;
    private final int indiferentes;

    public Encuesta(EncuestaId id, int totalEncuestados, int aprobaciones, int rechazos, int indiferentes) {
        if(totalEncuestados <= 0) {
            throw new EncuestaException("El total de encuestados debe ser mayor a cero");
        }
        if(aprobaciones + rechazos + indiferentes != totalEncuestados) {
            throw new EncuestaException("La suma de respuestas no coincide con el total de encuestados");
        }
        this.id = id;
        this.totalEncuestados = totalEncuestados;
        this.aprobaciones = aprobaciones;
        this.rechazos = rechazos;
        this.indiferentes = indiferentes;
    }

    public ResultadoEncuesta calcularResultado() {
        if(aprobaciones > rechazos && aprobaciones > indiferentes) {
            return ResultadoEncuesta.APROBADO;
        } else if(rechazos > aprobaciones && rechazos > indiferentes) {
            return ResultadoEncuesta.RECHAZADO;
        } else {
            return ResultadoEncuesta.INDIFERENTE;
        }
    }

    public EncuestaId getId() { return id; }
    public int getTotalEncuestados() { return totalEncuestados; }
    public int getAprobaciones() { return aprobaciones; }
    public int getRechazos() { return rechazos; }
    public int getIndiferentes() { return indiferentes; }
}
