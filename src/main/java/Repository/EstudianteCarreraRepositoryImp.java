package Repository;

import InterfacesRepository.EstudianteCarreraRepository;
import dto.CarreraDTO;
import dto.EstudianteCarreraDTO;
import entities.Carrera;
import entities.Estudiante;
import entities.Estudiante_Carrera;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {

    private EntityManager em;

    public EstudianteCarreraRepositoryImp(EntityManager em){
        this.em = em;
    }
    @Override
    public void matricularEstudiante(int idEstudiante, int idCarrera, Timestamp inscripcion, Timestamp fechaEgreso) {
        Estudiante e = em.find(Estudiante.class, idEstudiante);
        Carrera c = em.find(Carrera.class, idCarrera);
        Estudiante_Carrera estCarr = new Estudiante_Carrera(e, c, inscripcion, fechaEgreso);

        this.em.getTransaction().begin();
        em.persist(estCarr);
        this.em.getTransaction().commit();

    }

    @Override
    public List<CarreraDTO> getCarrerasConInscriptos() {
        return null;
    }

    @Override
    public List<EstudianteCarreraDTO> getEstudiantesCarreraCiudad(int idCarrera, String ciudad) {
        return null;
    }
}
