package InterfacesRepository;

import dto.EstudianteDTO;
import entities.*;

import java.util.List;

public interface EstudianteRepository {

    void nuevoEstudiante(Estudiante e);
    EstudianteDTO getEstudiante(int lu);
    List<EstudianteDTO> getEstudiantesPorGenero(String genero);
    List<EstudianteDTO> listaEstudiantesPorApellido();
}
