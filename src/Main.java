import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Instituto insti = Datos.pruebaInstituto();
        Menu menu = new Menu(insti);
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        while (opcion != 0) {
            menu.bienvenida();
            System.out.println("Seleccione una opcion ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menu.gestionAlumno();
                    break;
                case 2:
                    menu.gestionTrabajadores();
                    break;
                case 3:
                    menu.gestionAulas();
                    break;
                case 4:
                    menu.gestionInstituto();
                    break;
                default:
                    System.out.println("Saliendo");
            }
        }

    }
}
