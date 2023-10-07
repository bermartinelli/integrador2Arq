package Repository;

import InterfacesRepository.EstudianteCarreraRepository;
import dto.CarreraInformeDTO;
import dto.CarreraInscriptosDTO;
import dto.EstudianteDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.Estudiante_Carrera;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {

    private EntityManager em;

    public EstudianteCarreraRepositoryImp(EntityManager em){
        this.em = em;
    }
    @Override
    public void matricularEstudiante(int idEstudiante, int idCarrera, int inscripcion, Integer fechaEgreso) {
        Estudiante e = em.find(Estudiante.class, idEstudiante);
        Carrera c = em.find(Carrera.class, idCarrera);
        Estudiante_Carrera estCarr = new Estudiante_Carrera(e, c, inscripcion, fechaEgreso);

        this.em.getTransaction().begin();
        em.persist(estCarr);
        this.em.getTransaction().commit();
    }

    @Override
    public List<CarreraInscriptosDTO> getCarrerasConInscriptos() {
        this.em.getTransaction().begin();
        String jpql = "SELECT NEW dto.CarreraInscriptosDTO(c.nombre, COUNT(ec.estudiante)) " +
                "FROM Estudiante_Carrera ec JOIN ec.carrera c" +
                " group by ec.carrera ORDER BY COUNT(ec.estudiante) DESC ";
        TypedQuery<CarreraInscriptosDTO> query = em.createQuery(jpql, CarreraInscriptosDTO.class);
        List<CarreraInscriptosDTO> resultList = query.getResultList();
        this.em.getTransaction().commit();
        return resultList;
    }


    @Override
    public List<EstudianteDTO> getEstudiantesCarreraCiudad(int idCarrera, String ciudad) {
        this.em.getTransaction().begin();
        String jpql = "SELECT NEW dto.EstudianteDTO(e.nombre, e.apellido, e.edad, e.ciudad, e.genero, e.dni, e.lu)" +
                " FROM Estudiante e WHERE e.ciudad = ?1 " +
                "AND e.id IN " +
                "(SELECT ec.estudiante.id FROM Estudiante_Carrera ec WHERE ec.carrera.id = ?2)";
        TypedQuery<EstudianteDTO> query = em.createQuery(jpql, EstudianteDTO.class);
        query.setParameter(1,ciudad);
        query.setParameter(2, idCarrera);
        List<EstudianteDTO> resultList = query.getResultList();
        this.em.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<CarreraInformeDTO> getInformeCarreras() {
        this.em.getTransaction().begin();
        String jpql = "SELECT NEW dto.CarreraInformeDTO(c.nombre, eca.fechaInscripcion, COUNT(eca.estudiante), SUM(CASE WHEN eca.fechaEgreso IS NOT NULL THEN 1 ELSE 0 END)) " +
                "FROM Carrera c LEFT JOIN c.estudiantes eca " +
                " GROUP BY c.nombre, eca.fechaInscripcion " +
                " ORDER BY c.nombre ASC, eca.fechaInscripcion ASC";
        TypedQuery<CarreraInformeDTO> query = em.createQuery(jpql, CarreraInformeDTO.class);
        List<CarreraInformeDTO> resultList = query.getResultList();
        this.em.getTransaction().commit();
        return resultList;
    }


}
