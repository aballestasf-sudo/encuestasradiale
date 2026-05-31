package co.edu.udec.encuestasradiales.domain.valueobjects;

import java.util.UUID;

public record EncuestaId(UUID value) {
    public EncuestaId {
        if(value == null) {
            throw new IllegalArgumentException("El identificador de la encuesta no puede ser nulo");
        }
    }

    // Método de ayuda para generar un nuevo ID automáticamente
    public static EncuestaId generarNuevo() {
        return new EncuestaId(UUID.randomUUID());
    }
}
