import entities.*;
import dto.*;
import Repository.*;

import factory.FactoryEntityManager;
import javax.persistence.EntityManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        EntityManager em = FactoryEntityManager.createConnection();



        Estudiante e1 = new Estudiante(41825401, "Bernardo", "Martinelli", 28, "M", "OLAVARRIA", 1234);
        Estudiante e2 = new Estudiante(44425404, "Pedro", "Sanchez", 23, "M", "BOLIVAR", 1235);
        Estudiante e3 = new Estudiante(41825404, "Juana", "Gomez", 21, "F", "ALVEAR", 1236);
        Estudiante e4 = new Estudiante(36823412, "Mario", "Rodriguez", 22, "M", "OLAVARRIA", 1237);
        Estudiante e5 = new Estudiante(32809805, "Mariana", "Ester", 22, "F", "ALVEAR", 1238);
        Estudiante e6 = new Estudiante(35345446, "Sofia", "Fila", 25, "F", "LAMADRID", 1239);
        Estudiante e7 = new Estudiante(33825404, "Maria", "Fronda", 23, "M", "AZUL", 1240);
        Estudiante e8 = new Estudiante(32725404, "Enrique", "Rubio", 26, "M", "OLAVARRIA", 1241);
        Estudiante e9 = new Estudiante(31092544, "Pablo", "Valez", 24, "M", "AZUL", 1242);



        Carrera c1 = new Carrera("ING_SISTEMAS", 6);
        Carrera c2 = new Carrera("TUDAI", 3);
        Carrera c3 = new Carrera("TURAI", 2);
        Carrera c4 = new Carrera("LIC_FISICA", 5);
        Carrera c5 = new Carrera("ING_INDUSTRIAL", 5);

        EstudianteRepositoryImp EstRep = new EstudianteRepositoryImp(em);
        EstRep.nuevoEstudiante(e1);
        EstRep.nuevoEstudiante(e2);
        EstRep.nuevoEstudiante(e3);
        EstRep.nuevoEstudiante(e4);
        EstRep.nuevoEstudiante(e5);
        EstRep.nuevoEstudiante(e6);
        EstRep.nuevoEstudiante(e7);
        EstRep.nuevoEstudiante(e8);
        EstRep.nuevoEstudiante(e9);


        CarreraRepositoryImp CaRep = new CarreraRepositoryImp(em);
        CaRep.insertarCarrera(c1);
        CaRep.insertarCarrera(c2);
        CaRep.insertarCarrera(c3);
        CaRep.insertarCarrera(c4);
        CaRep.insertarCarrera(c5);


        FactoryEntityManager.closeConnection();
        em.close();
    }
}
