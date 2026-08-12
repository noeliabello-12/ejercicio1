import java.sql.SQLOutput;
import java.util.Objects;
import java.util.Scanner;

public class Menu {
    private Instituto insti;
    private Scanner sc;

    public Menu(Instituto insti) {
        this.insti = insti;
        sc = new Scanner(System.in);
    }

    public void bienvenida() {
        System.out.println("Bienvenidos al programa de gestion del instituto " + insti.getNombre());
        System.out.println("Seleccionar una opcion : ");
        opcionInicio();
    }

    public void opcionInicio() {
        System.out.println("1. gestionar alumnos");
        System.out.println("2. gestionar profesores");
        System.out.println("3. gestionar aulas");
        System.out.println("4. gestionar instituto");
        System.out.println("0. Salir");
    }

    public void gestionAlumno() {
        int opcion = -1;
        while (opcion != 0) {


            System.out.println("1. Añadir alumno");
            System.out.println("2. Modificar alumno");
            System.out.println("3. Eliminar alumno");
            System.out.println("4. Listar alumnos");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
        }
    }

    public void anhadirAlumno() {
        System.out.println("Introduce nombre");
        String nombre = sc.next();
        System.out.println("Introduce apellidos");
        String apellidos = sc.next();
        System.out.println("Introduce dni");
        String dni = sc.next();
        System.out.println("Introduce edad");
        int edad = sc.nextInt();
        System.out.println("Introduce telefono");
        int telefono = sc.nextInt();
        Alumno a = new Alumno(nombre, apellidos, dni, telefono, edad, false);
        insti.newAlumno(a);
        System.out.println("Se ha añadido");
    }

    public void modificarAlumno() {

        System.out.println("Introduzca el dni del alumno a modificar");
        String dni = sc.next();
        System.out.println("Introduzca el telefono que busca");
        int telefono = sc.nextInt();
        for (Persona p : insti.getAlumnos()) {
            if(Objects.equals(p.getDni(), dni)){
                p.setTelefono(telefono);
            }
        }
    }

    public void gestionTrabajadores() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Añadir Trabajador");
            System.out.println("2. Modificar Trabajador");
            System.out.println("3. Eliminar Trabajador");
            System.out.println("4. Direccion");
            System.out.println("5. Listar profesores");
            System.out.println("6. Listar secretaria");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
        }
    }

    public void gestionAulas() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Lista de aulas");
            System.out.println("2. Gestionar aula");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
        }
    }

    public void gestionInstituto() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Modificar datos");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
        }
    }
}
