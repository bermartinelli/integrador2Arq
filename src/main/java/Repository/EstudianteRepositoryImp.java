package Repository;

import InterfacesRepository.EstudianteRepository;
import dto.EstudianteDTO;
import entities.Estudiante;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class EstudianteRepositoryImp implements EstudianteRepository {
    private EntityManager em;

    public EstudianteRepositoryImp(EntityManager em){
        this.em=em;
    }

    @Override
    public void nuevoEstudiante(Estudiante estudiante) {
        em.getTransaction().begin();
        if(!em.contains(estudiante)){
            em.persist(estudiante);
        } else{em.merge(estudiante);}
        this.em.getTransaction().commit();
    }

    @Override
    public EstudianteDTO getEstudiante(int lu) {
        em.getTransaction().begin();
        String jpql = "SELECT new dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.ciudad,e.genero,e.dni,e.lu)" +
                " FROM Estudiante e WHERE e.lu = ?1";
        TypedQuery<EstudianteDTO> query = em.createQuery(jpql,EstudianteDTO.class);
        query.setParameter(1, lu);
        EstudianteDTO resultado = query.getSingleResult();
        this.em.getTransaction().commit();
        return resultado;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorGenero(String genero) {
        em.getTransaction().begin();
        String jpql = "SELECT new dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.ciudad,e.genero,e.dni,e.lu) " +
                "FROM Estudiante e WHERE e.genero = ?1";
        TypedQuery<EstudianteDTO> query = em.createQuery(jpql,EstudianteDTO.class);
        query.setParameter(1, genero);
        List<EstudianteDTO> resultList = query.getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<EstudianteDTO> listaEstudiantesPorApellido() {
        this.em.getTransaction().begin();
        String jpql = "SELECT new dto.EstudianteDTO(e.nombre,e.apellido,e.edad,e.ciudad,e.genero,e.dni,e.lu) " +
                "FROM Estudiante e ORDER BY e.apellido, e.nombre ";
        TypedQuery<EstudianteDTO> query = em.createQuery(jpql, EstudianteDTO.class);
        List<EstudianteDTO> resultList = query.getResultList();
        this.em.getTransaction().commit();
        return resultList;
    }

}

