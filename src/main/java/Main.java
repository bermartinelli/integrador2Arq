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

            Estudiante e1 = new Estudiante(41825401, "BERNARDO", "MARTINELLI", 28, "M", "OLAVARRIA", 1234);
        Estudiante e2 = new Estudiante(44425404, "PEDRO", "SANCHEZ", 23, "M", "BOLIVAR", 1235);
        Estudiante e3 = new Estudiante(41825404, "JUANA", "GOMEZ", 21, "F", "ALVEAR", 1236);
        Estudiante e4 = new Estudiante(36823412, "MARIO", "RODRIGUEZ", 22, "M", "OLAVARRIA", 1237);
        Estudiante e5 = new Estudiante(32809805, "MARIANA", "ESTER", 22, "F", "ALVEAR", 1238);
        Estudiante e6 = new Estudiante(35345446, "SOIFA", "FILA", 25, "F", "LAMADRID", 1239);
        Estudiante e7 = new Estudiante(33825404, "MARIA", "FRONDA", 23, "M", "AZUL", 1240);
        Estudiante e8 = new Estudiante(32725404, "ENRIQUE", "RUBIO", 26, "M", "OLAVARRIA", 1241);
        Estudiante e9 = new Estudiante(31092544, "PABLO", "VELEZ", 24, "M", "AZUL", 1242);



        Carrera c1 = new Carrera("ING_SISTEMAS", 6);
        Carrera c2 = new Carrera("TUDAI", 3);
        Carrera c3 = new Carrera("TURAI", 2);
        Carrera c4 = new Carrera("LIC_FISICA", 5);
        Carrera c5 = new Carrera("ING_INDUSTRIAL", 5);

        /*Estudiante_Carrera ec1 = new Estudiante_Carrera(e1, c1, 2020);
        Estudiante_Carrera ec2 = new Estudiante_Carrera(e1, c2, 2015,2018);
        Estudiante_Carrera ec3 = new Estudiante_Carrera(e2, c4, 2021);
        Estudiante_Carrera ec4 = new Estudiante_Carrera(e3, c4, 2012,2018);
        Estudiante_Carrera ec5 = new Estudiante_Carrera(e4, c4, 2015,2017);
        Estudiante_Carrera ec6 = new Estudiante_Carrera(e9, c3, 2020);*/


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


        EstudianteCarreraRepositoryImp EstCarr = new EstudianteCarreraRepositoryImp(em);
        EstCarr.matricularEstudiante(e1.getId(), c1.getCarreraId(), 2020, null);
        EstCarr.matricularEstudiante(e1.getId(), c2.getCarreraId(), 2015,2018);
        EstCarr.matricularEstudiante(e2.getId(), c4.getCarreraId(), 2021, null);
        EstCarr.matricularEstudiante(e3.getId(), c4.getCarreraId(), 2012,2018);
        EstCarr.matricularEstudiante(e4.getId(), c1.getCarreraId(), 2015,2017);
        EstCarr.matricularEstudiante(e9.getId(), c3.getCarreraId(), 2020, null);


        System.out.println("Inciso 2c)" + "\n");
        System.out.println(EstRep.listaEstudiantesPorApellido());

        System.out.println("Inciso 2d)" + "\n");
        System.out.println(EstRep.getEstudiante(1234));

        System.out.println("Inciso 2e)" + "\n");
        System.out.println(EstRep.getEstudiantesPorGenero("F"));

        System.out.println("Inciso 2f)" + "\n");
        System.out.println(EstCarr.getCarrerasConInscriptos());

        System.out.println("Inciso 2g)" + "\n");
        System.out.println(EstCarr.getEstudiantesCarreraCiudad(1,"OLAVARRIA"));

        FactoryEntityManager.closeConnection();
        em.close();
    }
}
