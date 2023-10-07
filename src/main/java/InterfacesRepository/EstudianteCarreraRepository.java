package InterfacesRepository;

import java.util.List;

import dto.*;

public interface EstudianteCarreraRepository {

    void matricularEstudiante(int idEstudiante, int idCarrera, int inscripcion, Integer fechaEgreso);
    List<CarreraInscriptosDTO> getCarrerasConInscriptos();
    List<EstudianteDTO> getEstudiantesCarreraCiudad(int idCarrera, String ciudad);

    List<CarreraInformeDTO> getInformeCarreras();
}
