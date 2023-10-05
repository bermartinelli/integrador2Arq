package Repository;

import InterfacesRepository.EstudianteCarreraRepository;
import dto.CarreraDTO;
import dto.EstudianteCarreraDTO;

import java.security.Timestamp;
import java.util.List;

public class EstudianteCarreraRepositoryImp implements EstudianteCarreraRepository {
    @Override
    public void matricularEstudiante(int idEstudiante, int idCarrera, Timestamp inscripcion, Timestamp fechaEgreso) {

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
