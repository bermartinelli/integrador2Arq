package dto;

public class EstudianteDTO {
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String genero;
    private Integer dni;
    private Integer lu;

    public EstudianteDTO(String nombre, String apellido, int edad, String ciudad, String genero,
                         Integer dni, Integer lu) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.genero = genero;
        this.dni = dni;
        this.lu= lu;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getDni() {
        return dni;
    }

    public Integer getLu() {
        return lu;
    }

    public String getNombreCompleto(){
        return this.apellido.toUpperCase() + ", " + this.nombre;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombreCompleto() + ", edad: " + edad	+ ", ciudad de residencia: " + ciudad + ", genero: " +
                genero + ", dni: " + dni + ", libreta: " + lu;
    }
}
