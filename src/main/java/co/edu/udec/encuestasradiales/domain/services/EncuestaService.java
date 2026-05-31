package co.edu.udec.encuestasradiales.domain.services;

import co.edu.udec.encuestasradiales.domain.model.Encuesta;
import co.edu.udec.encuestasradiales.domain.enums.ResultadoEncuesta;
import co.edu.udec.encuestasradiales.domain.exceptions.EncuestaException;
import co.edu.udec.encuestasradiales.domain.events.EncuestaRealizadaEvent;

public class EncuestaService {

    public void validarEncuesta(Encuesta encuesta) {
        if(encuesta.getTotalEncuestados() <= 0) {
            throw new EncuestaException("El total de encuestados debe ser mayor a cero");
        }
        if(encuesta.getAprobaciones() + encuesta.getRechazos() + encuesta.getIndiferentes()
                != encuesta.getTotalEncuestados()) {
            throw new EncuestaException("La suma de respuestas no coincide con el total de encuestados");
        }
    }

    public ResultadoEncuesta obtenerResultado(Encuesta encuesta) {
        return encuesta.calcularResultado();
    }

    public double calcularPorcentajeAprobacion(Encuesta encuesta) {
        return (double) encuesta.getAprobaciones() / encuesta.getTotalEncuestados() * 100;
    }

    public double calcularPorcentajeRechazo(Encuesta encuesta) {
        return (double) encuesta.getRechazos() / encuesta.getTotalEncuestados() * 100;
    }

    public double calcularPorcentajeIndiferencia(Encuesta encuesta) {
        return (double) encuesta.getIndiferentes() / encuesta.getTotalEncuestados() * 100;
    }

    // Aquí va tu método registrarEncuesta
    public EncuestaRealizadaEvent registrarEncuesta(Encuesta encuesta) {
        validarEncuesta(encuesta);
        ResultadoEncuesta resultado = obtenerResultado(encuesta);
        return new EncuestaRealizadaEvent(encuesta.getId(), resultado);
    }
}
