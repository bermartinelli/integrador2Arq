package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int dni;

    @Column
    private int lu;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column
    private String genero;

    @Column
    private String ciudad;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
    private Set<Estudiante_Carrera> carreras;

    public Estudiante() {

    }

    public Estudiante(int dni, String nombre, String apellido, int edad, String genero, String ciudad, int lu){
        this.dni = dni;
        this.lu = lu;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.ciudad = ciudad;
        this.carreras = new HashSet<Estudiante_Carrera>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getLu() {
        return lu;
    }

}
