package Repository;

import InterfacesRepository.EstudianteCarreraRepository;
import dto.CarreraDTO;
import dto.EstudianteCarreraDTO;
import dto.EstudianteDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.Estudiante_Carrera;
import java.sql.Timestamp;

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
    public List<CarreraDTO> getCarrerasConInscriptos() {
        this.em.getTransaction().begin();
        String jpql = "SELECT NEW dto.CarreraDTO(c.nombre, COUNT(ec.estudiante)) " +
                "FROM Estudiante_Carrera ec JOIN ec.carrera c" +
                " group by ec.carrera ORDER BY COUNT(ec.estudiante) DESC ";
        TypedQuery<CarreraDTO> query = em.createQuery(jpql, CarreraDTO.class);
        List<CarreraDTO> resultList = query.getResultList();
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
}
