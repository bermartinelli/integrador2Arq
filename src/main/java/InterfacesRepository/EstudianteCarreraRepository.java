package InterfacesRepository;

import entities.*;
import java.sql.Timestamp;
import java.util.List;

import dto.*;

public interface EstudianteCarreraRepository {

    void matricularEstudiante(int idEstudiante, int idCarrera, Timestamp inscripcion, Timestamp fechaEgreso);
    List<CarreraDTO> getCarrerasConInscriptos();
    List<EstudianteCarreraDTO> getEstudiantesCarreraCiudad(int idCarrera, String ciudad);

}
