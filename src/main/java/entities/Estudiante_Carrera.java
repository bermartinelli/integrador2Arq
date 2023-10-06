package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Estudiante_Carrera implements Serializable {
    @Id
    @ManyToOne(targetEntity = Estudiante.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;

    @Id
    @ManyToOne(targetEntity = Carrera.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "carrera_id", nullable = false)
    private Carrera carrera;

    @Column(name = "fecha_inscripcion")
    private int fechaInscripcion;

    @Column(name = "fecha_egreso")
    private Integer fechaEgreso;


    public Estudiante_Carrera() {

    }

    public Estudiante_Carrera(Estudiante estudiante, Carrera carrera, int inscripcion, Integer egreso) {
        this.estudiante = estudiante;
        this.carrera = carrera;
        this.fechaInscripcion = inscripcion;
        this.fechaEgreso = egreso;
    }

    public Estudiante_Carrera(Estudiante estudiante, Carrera carrera, Integer inscripcion) {
        this(estudiante, carrera, inscripcion, null);
    }

    public Integer getLu() {
        return estudiante.getLu();
    }

    public String getCarrera() {
        return carrera.getNombre();
    }
}
