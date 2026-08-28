import java.util.ArrayList;
import java.util.List;

public class DatosAula {
    private Persona profesor;
    private List<Alumno> alumnos;
    private Aula aula;

    public DatosAula(Persona profesor, Aula aula) {
        this.profesor = profesor;
        this.aula = aula;
        this.alumnos = new ArrayList<>();
    }

    private String listaAlumnos() {
        String lista = "";
        for (Alumno l : alumnos) {
            lista += "\n" + l.getNombre() + " " + l.getApellidos();
        }
        return lista;
    }

    public Persona getProfesor() {
        return profesor;
    }

    public Aula getAula() {
        return aula;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setProfesor(Persona profesor) {
        this.profesor = profesor;
    }

    public void newAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
    }

    @Override
    public String toString() {

        return "Aula: " + aula.getCurso() + aula.getLetra() + " ("+ this.alumnos.size() +" alumnos)" +
                "\nProfesor: " + profesor.getNombre() + " " + profesor.getApellidos() +
                "\nLista: " + listaAlumnos();
    }
}
