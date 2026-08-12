import java.util.ArrayList;
import java.util.List;

public class Colegio {
    private int[] numeros = {1, 2, 0, 1};
    private String[] aulas = {"A", "B", "C", "D"};
    private List<String> alumnos = new ArrayList<>(List.of("Ana", "Carlos", "Elena", "Diego"));

    public int[] getNumeros() {
        return numeros;
    }

    public String[] getAulas() {

        return aulas;
    }

    public List<String> getAlumnos() {
        return alumnos;
    }
    public void nuevoAlumno(String nombre,String aula){
        alumnos.add(nombre);
        for(int i=0;i<aulas.length;i++){
            if(aula.equals(aulas[i])){
                numeros[i]++;
            }
        }
    }
    public void totalAulas(){
        for(int i=0;i<aulas.length;i++){
            System.out.println ("El aula "+aulas[i]+" tiene "+numeros[i]);

        }
    }
    public void eliminarAlumno(String alumno){
        if (alumnos.contains(alumno)){
            alumnos.remove(alumno);
        }else{
            System.out.println("No existe ningun alumno con el nombre: "+alumno);
        }

    }
}
