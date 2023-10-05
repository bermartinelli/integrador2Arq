package Repository;

import InterfacesRepository.CarreraRepository;
import entities.Carrera;

import javax.persistence.EntityManager;

public class CarreraRepositoryImp implements CarreraRepository {
    private EntityManager em;

    public CarreraRepositoryImp(EntityManager em){
        this.em = em;
    }
    @Override
    public void insertarCarrera(Carrera carrera) {
        em.getTransaction().begin();
        if(!em.contains(carrera)){
            em.persist(carrera);
        } else { System.out.println("La carrera ya se encuentra en la lista de carreras");}
        this.em.getTransaction().commit();
    }


}
