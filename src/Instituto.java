import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public Alumno buscarAlumnos(String dni){
        for (Persona a:alumnos){
           if (Objects.equals(a.getDni(), dni)){
            return (Alumno) a;
           }
        }
        return null;
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
        boolean exito= alumnos.add(alumno);
       if (exito) {
           System.out.println("Se ha añadido el alumno " + alumno.getNombre());
       }else {
           System.out.println("No se ha podido añadir");
       }
    }

    public void newTrabajador(Trabajador trabajador) {
        trabajadores.add(trabajador);
    }

    public void removeAlumno(Alumno alumno) {
        boolean exito= alumnos.remove(alumno);
       if (exito){
           System.out.println("Se ha eliminado el alumno de la base de datos");
       }else {
           System.out.println("No se ha podido eliminar");
       }
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
