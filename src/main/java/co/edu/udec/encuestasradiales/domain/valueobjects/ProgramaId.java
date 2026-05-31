package co.edu.udec.encuestasradiales.domain.valueobjects;

import java.util.UUID;
public record ProgramaId(UUID value) {
public ProgramaId {
    if(value == null) {
        throw new IllegalArgumentException("El identificador del programa no puede ser nulo");
    }
}

    // Método de ayuda para generar un nuevo ID automáticamente
    public static ProgramaId generarNuevo() {
        return new ProgramaId(UUID.randomUUID());
    }
}

