package co.edu.udec.encuestasradiales.domain.valueobjects;
public record RFC(String value) {
public  RFC {
    if(value == null || value.isBlank()) {
        throw new IllegalArgumentException("El RFC no puede ser nulo o vacío");
    }
    // Validación básica: longitud mínima y caracteres alfanuméricos
        if(!value.matches("^[A-Z0-9]{8,13}$")) {
        throw new IllegalArgumentException("Formato de RFC inválido. Debe ser alfanumérico y entre 8 y 13 caracteres.");
    }
}
}

