import java.util.ArrayList;
import java.util.List;

public class Instituto {

    private String nombre;
    private String direccion;
    private int telefono;
    private String mail;
    private List<Persona> trabajadores;
    private List<Persona> alumnos;
    private List<Aula> aulas;
    private List<DatosAula> datoAula;

    public Instituto(String nombre, String direccion, int telefono, String mail) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.mail = mail;
        this.alumnos = new ArrayList<>();
        this.trabajadores = new ArrayList<>();
        this.aulas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getMail() {
        return mail;
    }

    public List<Persona> getAlumnos() {
        return alumnos;
    }
    public List<DatosAula> getDatosAula(){
        return datoAula;
    }
    public List<Persona> getTrabajadores() {
        return trabajadores;
    }
    public List<Aula> getAulas(){
        return aulas;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    public void newAulas(Aula aula){
        aulas.add(aula);
    }
    public void newDatos(DatosAula datoAula){
               this.datoAula.add(datoAula);
    }
    public void newAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void newTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    public void removeTrabajadores(Trabajador trabajador) {
        trabajadores.remove(trabajador);
    }
    public Trabajador getDirector() {
        for (Persona t : trabajadores) {
            if (((Trabajador) t).getPuesto() == Docente.DIRECTOR) {
                return (Trabajador) t;
            }
        }
        return null;
    }
}
