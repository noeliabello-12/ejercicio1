
import java.util.List;
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
            switch (opcion) {
                case 1:
                    anhadirAlumno();
                    break;
                case 2:
                    modificarAlumno();
                    break;
                case 3:
                    eliminarAlumno();
                    break;
                case 4:
                    listarAlumnos();
                    break;
                default:
                    break;
            }

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

    }

    public void modificarAlumno() {

        System.out.println("Introduzca el dni del alumno a modificar");
        String dni = sc.next();
        System.out.println("Introduzca el telefono que busca");
        int telefono = sc.nextInt();
        for (Persona p : insti.getAlumnos()) {
            if (Objects.equals(p.getDni(), dni)) {
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
            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    menuDireccion();
                    break;
                case 5: listarProfesor();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
    }

    public void menuDireccion() {
        int direccion = -1;
        while (direccion != 0) {
            System.out.println("1. Ver Director");
            System.out.println("2. Cambiar DIrector");
            direccion = sc.nextInt();
            switch (direccion) {
                case 1:
                    System.out.println("El director es: ");
                    Trabajador director = insti.getDirector();
                    System.out.println(director);
                    break;
                case 2:
                    System.out.println("Introduzca el dni del nuevo Director");
                    String dni = sc.next();
                    Trabajador t = insti.buscarTrabajador(dni);
                    if (t == null) {
                        System.out.println("EL dni no esta en la base de datos");
                    } else {
                        insti.cambiarDirector(t);
                    }
            }

        }

    }

    public void listarProfesor() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Buscar Profesor");
            System.out.println("2. Listar todos");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    String dni = sc.next();
                    Trabajador trab = insti.buscarTrabajador(dni);
                    if (trab == null || trab.getPuesto() != Docente.PROFESOR) {
                        System.out.println("No existe profesor con ese dni");
                    } else {
                        System.out.println(trab);
                    }
                    break;
                case 2:
                    List<Persona> t = insti.getTrabajadores();
                    for (Persona trabajador : t) {
                        if (((Trabajador) trabajador).getPuesto() == Docente.PROFESOR) {
                            System.out.println(trabajador);

                        }
                    }
                    break;
                default:
                    break;
            }
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

    public void listarAlumnos() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Buscar alumno");
            System.out.println("2. Listar todo");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca dni para buscar ");
                    String dni = sc.next();
                    Alumno alumno = insti.buscarAlumnos(dni);
                    if (alumno == null) {
                        System.out.println("El dni introducido no esta en la base de datos");
                    } else {
                        System.out.println(alumno);
                    }
                    break;
                case 2:
                    for (Persona l : insti.getAlumnos()) {
                        System.out.println(l);
                    }
                    break;
                default:
                    break;
            }

        }
    }

    public void eliminarAlumno() {
        System.out.println("Introduzca un dni ");
        String dni = sc.next();
        Alumno alumno = insti.buscarAlumnos(dni);
        if (alumno == null) {
            System.out.println("No se ha encontrado");
        } else {
            System.out.println("Se va a eliminar el siguiente alumno: ");
            System.out.println(alumno);
            System.out.println("¿Esta seguro de eliminarlo?");
            System.out.println("1. Eliminar");
            System.out.println("2. Cancelar");
            int decision = sc.nextInt();
            if (decision == 1) {
                insti.removeAlumno(alumno);
            }

        }
    }
}
