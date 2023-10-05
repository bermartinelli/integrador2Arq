package Repository;

import InterfacesRepository.EstudianteRepository;
import dto.EstudianteDTO;
import entities.Estudiante;

import java.util.List;

public class EstudianteRepositoryImp implements EstudianteRepository {
    @Override
    public void nuevoEstudiante(Estudiante e) {

    }

    @Override
    public EstudianteDTO getEstudiante(int lu) {
        return null;
    }

    @Override
    public List<EstudianteDTO> getEstudiantesPorGenero(String genero) {
        return null;
    }

    @Override
    public List<EstudianteDTO> listaEstudiantesPorApellido() {
        return null;
    }
}
