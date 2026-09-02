
import java.util.ArrayList;
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
            System.out.println("5. Ver alumno");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
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
                case 5:
                    verAlumno();
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

    public void verAlumno() {
        System.out.println("¿que dni tiene ese alumno?");
        String dni = sc.next();
        Alumno alumno = insti.buscarAlumnos(dni);

        if (alumno == null) {
            System.out.println("Ese alumno no existe por ese dni");
        } else {
            System.out.println(alumno);
            DatosAula aula = insti.buscarAulaDeAlumno(alumno);
            if (aula == null) {
                System.out.println("El alumno no tiene aula asignada");
            } else {

                System.out.println("El aula del alumno: " + aula.getAula().getCurso() + aula.getAula().getLetra());
                System.out.println("El tutor del alumno: " + aula.getProfesor().getNombre() + " " + aula.getProfesor().getApellidos());
            }

        }
    }

    public void modificarAlumno() {

        System.out.println("Introduzca el dni del alumno a modificar");
        String dni = sc.next();
        System.out.println("Introduzca el nuevo telefono ");
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
            System.out.println("7. Buscar profesor");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    anhadirTrabajador();
                    break;
                case 2:
                    modificarTrabajador();
                    break;
                case 3:
                    eliminarTrabajador();
                    break;
                case 4:
                    menuDireccion();
                    break;
                case 5:
                    listarProfesor();
                    break;
                case 6:
                    listarSecretaria();
                    break;
                case 7:
                    buscarProfesor();
                    break;
                default:
                    break;
            }
        }
    }

    public void listarAlumnos() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Buscar alumno");
            System.out.println("2. Listar todo (" + insti.getAlumnos().size() + ")");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
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
                        Util.separatorList();
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

    public void anhadirTrabajador() {
        System.out.println("Introduzca Nombre");
        String nombre = sc.next();
        System.out.println("introduzca Apellidos");
        String apellidos = sc.next();
        System.out.println("Introduzca dni");
        String dni = sc.next();
        System.out.println("Introduzca telefono");
        int telefono = sc.nextInt();
        System.out.println("Introduzca edad");
        int edad = sc.nextInt();
        System.out.println("Introduzca los años de docencia");
        int anhosDOcencia = sc.nextInt();
        System.out.println("Introduzca el puesto");
        System.out.println("1. Profesor");
        System.out.println("2. Secretario/a");
        System.out.println("3. Jefe de estudios");
        int opcion = sc.nextInt();
        Docente docente = switch (opcion) {
            case 1 -> Docente.PROFESOR;
            case 2 -> Docente.SECRETARIA;
            default -> Docente.JEFE_ESTUDIOS;

        };
        Trabajador trb = new Trabajador(nombre, apellidos, dni, telefono, edad, anhosDOcencia, docente);
        insti.newTrabajador(trb);
    }

    public void modificarTrabajador() {
        System.out.println("Introduzca el dni del trabajador a modificar");
        String dni = sc.next();
        Trabajador tr = insti.buscarTrabajador(dni);
        if (tr == null) {
            System.out.println("No se ha encontrado");
        } else {
            System.out.println("Introduzca el nuevo telefono ");
            int telefono = sc.nextInt();

            tr.setTelefono(telefono);
        }
    }

    public void eliminarTrabajador() {
        System.out.println("Introduzca dni");
        String dni = sc.next();
        Trabajador trabajador = insti.buscarTrabajador(dni);
        if (trabajador == null) {
            System.out.println("No se ha encontrado");
        } else {
            System.out.println("Se va eliminar el siguiente trabajador");
            System.out.println(trabajador);
            System.out.println("¿Esta seguro de eliminar el trabajador?");
            System.out.println("1. Eliminar");
            System.out.println("2. Cancelar");
            int decision = sc.nextInt();
            if (decision == 1) {
                insti.removeTrabajadores(trabajador);
            }
        }
    }

    public void menuDireccion() {
        int direccion = -1;
        while (direccion != 0) {
            System.out.println("1. Ver Director");
            System.out.println("2. Cambiar Director");
            System.out.println("0. Atras");
            direccion = sc.nextInt();
            Util.separador();
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
            System.out.println("2. Listar todos (" + insti.getTrabajadores().stream().filter(profesor -> ((Trabajador) profesor).getPuesto() == Docente.PROFESOR).toList().size() + ")");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca dni");
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
                            Util.separatorList();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void listarSecretaria() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Buscar secretario/a");
            System.out.println("2. Listar todo (" + insti.getTrabajadores().stream().filter(profesor -> ((Trabajador) profesor).getPuesto() == Docente.SECRETARIA).toList().size() + ")");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    String dni = sc.next();
                    Trabajador t = insti.buscarTrabajador(dni);
                    if (t == null || t.getPuesto() != Docente.SECRETARIA) {
                        System.out.println("No existe dni para ese secretario/a");
                    } else {
                        System.out.println(t);

                    }
                    break;
                case 2:
                    List<Persona> tr = insti.getTrabajadores();
                    for (Persona trabajador : tr) {
                        if (((Trabajador) trabajador).getPuesto() == Docente.SECRETARIA) {
                            System.out.println(trabajador);
                            Util.separatorList();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void buscarProfesor() {
        System.out.println("¿que dni tiene el profesor?");
        String dni = sc.next();
        Trabajador profesor = insti.buscarTrabajador(dni);
        if (profesor == null) {
            System.out.println("No existe profesor");
        } else {
            System.out.println(profesor);
            DatosAula aula = insti.buscarTutorEnAula(profesor);
            if (aula == null) {
                System.out.println("El profesor no es tutor de niguna clase");
            } else {
                System.out.println("El profesor es tutor del aula es " + aula.getAula().getCurso() + aula.getAula().getLetra());
            }

        }
    }

    public void gestionAulas() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Lista de aulas");
            System.out.println("2. Gestionar datos");
            System.out.println("3. Buscar aula");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    listaAula();
                    break;
                case 2:
                    gestionarAula();
                    break;
                case 3:
                    buscarAula();
                    break;
                default:
                    break;
            }
        }
    }
    public void buscarAula(){
        System.out.println("¿que aula es?");
        String aula1 = sc.next();
        DatosAula aula = insti.buscarDatosAula(aula1);
        if (aula==null){
            System.out.println("No existe");
        }else {
            System.out.println("El tutor es "+aula.getProfesor().getNombre()+" "+aula.getProfesor().getApellidos());
        }
    }
    public void listaAula() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1. Ver aula");
            System.out.println("2. Listar todas (" + insti.getDatosAula().size() + ")");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    System.out.println("¿De que aula desea buscar los datos?");
                    String aula = sc.next();
                    DatosAula datos = insti.buscarDatosAula(aula);
                    if (datos == null) {
                        System.out.println("El aula no existe");
                    } else {
                        System.out.println(datos);
                    }
                    break;
                case 2:
                    for (DatosAula d : insti.getDatosAula()) {
                        System.out.println(d);
                        Util.separatorList();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void gestionarAula() {
        int opcion = -1;
        while (opcion != 0) {
            System.out.println("1.Modificar aula");
            System.out.println("2.Añadir aula");
            System.out.println("3.Eliminar aula");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            Util.separador();
            switch (opcion) {
                case 1:
                    System.out.println("¿Que aula desea modificar?");
                    String dato = sc.next();
                    DatosAula a = insti.buscarDatosAula(dato);
                    if (a == null) {
                        System.out.println("No se ha encontrado el aula");
                    } else {
                        modificarAula(a);
                    }
                    break;
                case 2:
                    anhadirAula();
                    break;
                case 3:
                    System.out.println("¿Que aula desea eliminar?");
                    String eliminar = sc.next();
                    if (eliminar == null) {
                        System.out.println("Se ha eliminado");
                    } else {
                        System.out.println(eliminar);
                    }


                    break;
                default:
                    break;
            }
        }
    }

    public void anhadirAula() {
        Aula aula;
        Persona tutor;
        System.out.println("Introduzca el aula que es");
        String buscarAula = sc.next();
        aula = insti.buscarAula(buscarAula);
        System.out.println("Introduzca el dni del tutor del aula");
        String buscarTutor = sc.next();
        tutor = insti.buscarTrabajador(buscarTutor);
        System.out.println("Introduzca los alumnos.");
        System.out.println("Introduzca 0 para parar");
        String opcion = "";
        DatosAula d = new DatosAula(tutor, aula);
        while (!opcion.equals("0")) {

            System.out.println("Introduzca dni");
            opcion = sc.next();
            Alumno al = insti.buscarAlumnos(opcion);
            if (al == null) {
                System.out.println("El alumno no existe");
            } else {
                d.newAlumno(al);
            }

        }
        insti.newDatos(d);
    }

    public void modificarAula(DatosAula a) {

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("Aula: " + a.getAula().getCurso() + a.getAula().getLetra());
            System.out.println("1.Modificar tutor");
            System.out.println("2.Añadir alumno");
            System.out.println("3.Eliminar alumno");
            System.out.println("4.Ver detalles");
            System.out.println("0. Atras");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Que dni tiene el nuevo tutor?");
                    String dni = sc.next();
                    Trabajador tutor = insti.buscarTrabajador(dni);
                    if (tutor == null) {
                        System.out.println("No existe un profesor con ese dni");
                    } else {
                        DatosAula aulas2 = insti.buscarTutorEnAula(tutor);
                        if (aulas2 == null) {
                            a.setProfesor(tutor);
                        } else {
                            System.out.println("El profesor ya tiene una tutoria asignada");
                        }

                    }
                    break;
                case 2:
                    System.out.println("Introduce el nuevo dni del alumno nuevo");
                    String dni1 = sc.next();
                    Alumno newAlumno = insti.buscarAlumnos(dni1);
                    if (newAlumno == null) {
                        System.out.println("No hay alumnos con ese dni");
                    } else {
                        DatosAula aula = insti.buscarAulaDeAlumno(newAlumno);
                        if (aula == null) {
                            a.newAlumno(newAlumno);
                        } else {
                            System.out.println("El alumno esta registrado en el aula " + aula.getAula().getCurso() + aula.getAula().getLetra());
                            System.out.println("1. Trasladar alumno");
                            System.out.println("2. Cancelar");
                            int opcion1 = sc.nextInt();
                            switch (opcion1) {
                                case 1:
                                    aula.removeAlumno(newAlumno);
                                    a.newAlumno(newAlumno);
                                    break;
                                default:
                                    System.out.println("Operacion cancelada");
                                    break;
                            }
                        }

                    }
                    break;
                case 3:
                    System.out.println("¿que alumno quieres eliminar?");
                    String dni2 = sc.next();
                    Alumno removeAlumno = insti.buscarAlumnos(dni2);
                    if (removeAlumno == null) {
                        System.out.println("No existe el alumno con ese dni");
                    } else {
                        a.removeAlumno(removeAlumno);
                    }
                    break;
                case 4:
                    System.out.println(a);
                    break;
                default:
                    break;
            }
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
