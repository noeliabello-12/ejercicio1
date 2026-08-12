import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {

      Instituto insti = Datos.pruebaInstituto();
       System.out.println(insti.getDirector());
       for(Aula al: insti.getAulas()){
           System.out.println(al);
       }









   }
}
