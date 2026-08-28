import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Datos {
    Instituto insti;

    public Datos(){
        Instituto insti = new Instituto("San clemente","Santiago",999999999,"prueba@prueba.com");
        List<Trabajador> profesores = Datos.profesoresPruebas();
        List<Alumno> alumnos = Datos.alumnosPrueba();
        List<Aula> aulas = Datos.aulasPruebas();
        List<Trabajador> secretaria = secretariaPrueba();
        List<Trabajador> direccion = direccionPrueba();
        for (Alumno a:alumnos){
            insti.newAlumno(a);
        }
        for(Trabajador t:profesores){
            insti.newTrabajador(t);
        }
        for (Aula aul:aulas){
            insti.newAulas(aul);
        }
        for(Trabajador t:secretaria){
            insti.newTrabajador(t);
        }
        for(Trabajador t:direccion){
            insti.newTrabajador(t);
        }
        this.insti = insti;
        createDatosAula();
    }

    static List<String> nombres = List.of(
            "Ana", "Carlos", "Sofía", "Diego", "María",
            "Juan", "Lucía", "Mateo", "Elena", "Santiago",
            "Valeria", "Alejandro", "Camila", "Javier", "Isabella",
            "Gabriel", "Daniela", "Fernando", "Victoria", "Lucas",
            "Paula", "Hugo", "Carmen", "Mario", "Alba",
            "Óscar", "Claudia", "Iván", "Aitana", "Pablo",
            "Laura", "Marcos", "Irene", "Rodrigo", "Marta",
            "Jorge", "Nuria", "Andrés", "Silvia", "Álvaro"
    );

    static List<String> apellidos = List.of(
            "García", "Rodríguez", "González", "Fernández", "López",
            "Martínez", "Sánchez", "Pérez", "Gómez", "Martín",
            "Jiménez", "Ruiz", "Hernández", "Díaz", "Moreno",
            "Muñoz", "Álvarez", "Romero", "Alonso", "Gutiérrez",
            "Navarro", "Torres", "Domínguez", "Vázquez", "Ramos",
            "Gil", "Blanco", "Molina", "Morales", "Ortega",
            "Delgado", "Castro", "Ortiz", "Rubio", "Marín",
            "Sanz", "Iglesias", "Núñez", "Medina", "Garrido"
    );

    static List<String> dnisAlumnos = List.of(
            "12345678Z", "23456789F", "34567890T", "45678901Q", "56789012D",
            "67890123W", "78901234H", "89012345B", "90123456G", "01234567N",
            "11111111R", "22222222W", "33333333A", "44444444G", "55555555M",
            "66666666Y", "77777777F", "88888888P", "99999999R", "12344321Z",
            "13579135V", "24680246C", "35791357Y", "46802468F", "57913579K",
            "68024680L", "79135791S", "80246802J", "91357913A", "02468024Y",
            "12312312T", "23423423L", "34534534K", "45645645E", "56756756C",
            "67867867M", "78978978T", "89089089S", "90190190Y", "43211234F",
            "71000000N", "71000001J", "71000002Z", "71000003S", "71000004Q",
            "71000005V", "71000006H", "71000007L", "71000008C", "71000009K",
            "71000010E", "71000011T", "71000012R", "71000013W", "71000014A",
            "71000015G", "71000016M", "71000017Y", "71000018F", "71000019P",
            "71000020D", "71000021X", "71000022B", "71000023N", "71000024J",
            "71000025Z", "71000026S", "71000027Q", "71000028V", "71000029H",
            "71000030L", "71000031C", "71000032K", "71000033E", "71000034T",
            "71000035R", "71000036W", "71000037A", "71000038G", "71000039M"
    );

    static List<String> dnisDocentes = List.of(
            "10203040X", "98765432M", "12121212M", "87654321X", "13579246T",
            "24681357B", "54321678W", "99887766P", "11223344B", "55443322M",
            "72000000H", "72000001L", "72000002C", "72000003K", "72000004E",
            "72000005T", "72000006R", "72000007W", "72000008A", "72000009G"
    );

    static List<String> dnisDocentes2 = List.of(
            "01010101A", "02020202B", "03030303C", "04040404D", "05050505E",
            "06060606F", "07070707H", "08080808J", "09090909K", "10101010L",
            "73000000R", "73000001W", "73000002A", "73000003G", "73000004M",
            "73000005Y", "73000006F", "73000007P", "73000008D", "73000009X"
    );

    static int anhosTrabajador(){
        return (int) ((Math.random()*30)+20);
    }
    static int anhosAlumno(){
        return (int) ((Math.random()*7)+5);
    }
    static int anhosDocencia(){
        return (int) ((Math.random()*30));
    }
    public static List<Aula> aulasPruebas(){
        List<Aula> aulas = new ArrayList<>();
        String[] letras={"A","B"};
        for(int i=1;i<7;i++){
            for(String l:letras){
                Aula a = new Aula(String.valueOf(i),l.charAt(0), (int) (Math.random() * 10) + 20);
                aulas.add(a);
            }
        }
      return aulas;
    }

    public static int newTelefono(){
        String telefono = "6";
        for(int i=0;i<8;i++){
          int nuevo= (int) (Math.random()*10);
          telefono+=nuevo;
        }
        return Integer.parseInt(telefono);
    }
    public static List<Alumno> alumnosPrueba(){
        List<Alumno> alumnos = new ArrayList<>();
        for(int i=0;i<dnisAlumnos.size();i++){
            String nombre=nuevoNombre();
            String apellido=nuevoApellido();
            String dni=dnisAlumnos.get(i);
            int telefono=newTelefono();
            int edad=anhosAlumno();


            Alumno al = new Alumno(nombre,apellido,dni,telefono,edad,false);
            alumnos.add(al);
        }
        return alumnos;
    }
    public static String nuevoNombre(){
        String nombre=nombres.get((int) (Math.random()* (nombres.size())));
        return nombre;
    }
    public static String nuevoApellido(){
        String apellido= apellidos.get((int) (Math.random()* (apellidos.size())))+" "+apellidos.get((int) (Math.random()* (apellidos.size())));
        return apellido;
    }
    public static List<Trabajador> profesoresPruebas(){
        List<Trabajador> profesor = new ArrayList<>();
        for (int i=0;i<dnisDocentes.size();i++){
            String nombre=nuevoNombre();
            String apellido=nuevoApellido();
            String dni=dnisDocentes.get(i);
            int telefono=newTelefono();
            int edad=anhosTrabajador();
            int docencia = anhosDocencia();
            Trabajador tr = new Trabajador(nombre,apellido,dni,telefono,edad,docencia,Docente.PROFESOR);
            profesor.add(tr);

        }
        return profesor;
    }

    public static List<Trabajador> secretariaPrueba(){
        List<Trabajador> secretaria = new ArrayList<>();
        for (int i=0;i<6;i++){
            String nombre=nuevoNombre();
            String apellido=nuevoApellido();
            String dni=dnisDocentes2.get(i);
            int telefono=newTelefono();
            int edad=anhosTrabajador();
            int docencia = anhosDocencia();
            Trabajador tr = new Trabajador(nombre,apellido,dni,telefono,edad,docencia,Docente.SECRETARIA);
            secretaria.add(tr);

        }
        return secretaria;
    }

    public static List<Trabajador> direccionPrueba(){
        List<Trabajador> direccion = new ArrayList<>();
        for (int i=6;i<10;i++){
            String nombre=nuevoNombre();
            String apellido=nuevoApellido();
            String dni=dnisDocentes2.get(i);
            int telefono=newTelefono();
            int edad=anhosTrabajador();
            int docencia = anhosDocencia();
            Docente docente = (i==9)? Docente.DIRECTOR : Docente.JEFE_ESTUDIOS;
            Trabajador tr = new Trabajador(nombre,apellido,dni,telefono,edad,docencia,docente);
            direccion.add(tr);

        }
        return direccion;
    }

    public static void printLista(List<Persona> personas){
        for(Persona p:personas){
            System.out.println(p);
        }
    }

    public void createDatosAula(){
        String[] letras={"A","B"};
        List<Persona> alumnos = new ArrayList<>();
        Persona tutor;
        Optional<Aula> aula;
        int contador = 0;
        for(int i=5; i<13; i++){
            for (Persona a: this.insti.getAlumnos()){
                if(a.getEdad() == i){
                    alumnos.add(a);
                }
            }

            boolean check = false;
            for (String l: letras){
                tutor = this.insti.getTrabajadores().get(contador);
                int finalContador = contador;
                aula = insti.getAulas().stream().filter(au ->
                                (((finalContador +1)/2)+l).equals(au.getCurso()+au.getLetra())
                ).findFirst();
                List<Persona> list = (!check)?alumnos.subList(0,alumnos.size()/2) : alumnos.subList(alumnos.size()/2,alumnos.size()-1);

                if(aula.isPresent()) {
                    DatosAula da = new DatosAula(tutor, aula.get());
                    for (Persona p : list) {
                        da.newAlumno((Alumno) p);
                    }
                    insti.newDatos(da);
                    check = true;
                }
                contador++;
            }
            alumnos.clear();

        }
    }
}
