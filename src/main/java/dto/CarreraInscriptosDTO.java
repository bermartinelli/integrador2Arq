package dto;

public class CarreraInscriptosDTO {
    private String nombre;
    private long inscriptos;

    public CarreraInscriptosDTO(String nombre, long inscriptos) {
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
        return "Carrera: " + nombre + ", Nro inscriptos:" + inscriptos + "\n";
    }
}
