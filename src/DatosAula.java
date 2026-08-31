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
            lista += "\n" + l.getNombre() + " " + l.getApellidos()+ " ("+l.getDni()+")";
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
        System.out.println("El profesor "+this.profesor.getNombre() +" "+this.profesor.getApellidos()+" ya no es el tutor de la clase");
        this.profesor = profesor;
        System.out.println("El nuevo tutor es "+this.profesor.getNombre() +" "+this.profesor.getApellidos());

    }

    public void newAlumno(Alumno alumno) {
        alumnos.add(alumno);
        System.out.println("Se ha agregado nuevo alumno "+alumno.getNombre()+" "+alumno.getApellidos());
    }

    public void removeAlumno(Alumno alumno) {
        boolean exito = alumnos.remove(alumno);
        if (exito){
            System.out.println("Se ha eliminado con exito");
        }else {
            System.out.println("El alumno no esta en la lista");
        }
    }

    @Override
    public String toString() {

        return "Aula: " + aula.getCurso() + aula.getLetra() + " ("+ this.alumnos.size() +" alumnos)" +
                "\nProfesor: " + profesor.getNombre() + " " + profesor.getApellidos() +
                "\nLista: " + listaAlumnos();
    }
}
