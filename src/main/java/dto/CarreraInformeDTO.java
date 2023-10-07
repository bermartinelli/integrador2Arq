package dto;

public class CarreraInformeDTO {
    private String carrera;

    private int anio;

    private Long inscriptos;
    private Long egresados;

    public CarreraInformeDTO(String carrera, Integer anio, Long inscriptos, Long egresados) {
        this.carrera = carrera;
        this.anio = anio;
        this.inscriptos = inscriptos;
        this.egresados = egresados;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public long getInscriptos() {
        return inscriptos;
    }

    public void setInscriptos(long inscriptos) {
        this.inscriptos = inscriptos;
    }

    public long getEgresados() {
        return egresados;
    }

    public void setEgresados(long egresados) {
        this.egresados = egresados;
    }

    @Override
    public String toString() {
        return
                "Carrera: " + carrera + '\'' +
                ", año: " + anio +
                ", inscriptos: " + inscriptos +
                ", egresados: " + egresados +
                '}' + "\n";
    }
}
