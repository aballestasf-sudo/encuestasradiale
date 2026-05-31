package co.edu.udec.encuestasradiales.domain.model;
import co.edu.udec.encuestasradiales.domain.valueobjects.RFC;

public record Productora(RFC rfc, String nombre, String telefono) {
    public Productora {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la productora no puede ser nulo");
        }
    }
}
