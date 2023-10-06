package InterfacesRepository;

import entities.*;
import java.sql.Timestamp;
import java.util.List;

import dto.*;

public interface EstudianteCarreraRepository {

    void matricularEstudiante(int idEstudiante, int idCarrera, int inscripcion, Integer fechaEgreso);
    List<CarreraDTO> getCarrerasConInscriptos();
    List<EstudianteDTO> getEstudiantesCarreraCiudad(int idCarrera, String ciudad);
}
