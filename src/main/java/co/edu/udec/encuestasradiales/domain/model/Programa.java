package co.edu.udec.encuestasradiales.domain.model;

import co.edu.udec.encuestasradiales.domain.valueobjects.ProgramaId;
import co.edu.udec.encuestasradiales.domain.enums.GeneroPrograma;
import co.edu.udec.encuestasradiales.domain.exceptions.ProgramaException;

public class Programa {private final ProgramaId id;
    private String nombre;
    private GeneroPrograma genero;

    public Programa(ProgramaId id, String nombre, GeneroPrograma genero) {
        if(nombre == null || nombre.isBlank()) {

            throw new ProgramaException("El nombre del programa no puede ser nulo o vacío");
        }
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
    }

    public void cambiarGenero(GeneroPrograma nuevoGenero) {
        if(nuevoGenero == null) throw new ProgramaException("Género inválido");
        this.genero = nuevoGenero;
    }

    public ProgramaId getId() { return id; }
    public String getNombre() { return nombre; }
    public GeneroPrograma getGenero() { return genero; }
}
