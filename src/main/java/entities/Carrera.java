package entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.*;

import javax.persistence.*;

@Entity
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;

    @Column
    private int duracion;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Carrera")
    private Set<Estudiante_Carrera> estudiantes;

    public Carrera(String nombre, int duracion){
        this.nombre = nombre;
        this.duracion = duracion;
        this.estudiantes = new HashSet<Estudiante_Carrera>();
    }

    public Carrera() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Set<Estudiante_Carrera> getEstudiantes(){
        return estudiantes;
    }

    public void setEstudiantes(Set<Estudiante_Carrera> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public int getCarreraId() {
        return id;
    }

    @Override
    public String toString() {
        return "Carrera [id_carrera=" + id + ", nombre=" + nombre + "]";
    }


}
