package dto;

import entities.Carrera;
public class CarreraDTO {
    private String nombre;
    private long inscriptos;

    public CarreraDTO(String nombre, long inscriptos) {
        this.nombre = nombre;
        this.inscriptos = inscriptos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(long inscriptos) {
        this.inscriptos = inscriptos;
    }

    @Override
    public String toString() {
        return "Carrera: " + nombre + ", Inscriptos=" + inscriptos + "\n";
    }
}
