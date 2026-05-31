package co.edu.udec.encuestasradiales.domain.factory;

import co.edu.udec.encuestasradiales.domain.model.Programa;
import co.edu.udec.encuestasradiales.domain.valueobjects.ProgramaId;
import co.edu.udec.encuestasradiales.domain.enums.GeneroPrograma;

public class ProgramaFactory {
    public static Programa crear(String nombre, GeneroPrograma genero) {
        return new Programa(new ProgramaId(java.util.UUID.randomUUID()), nombre, genero);
    }
}

