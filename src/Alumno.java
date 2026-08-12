public class Alumno extends Persona {
    private Boolean repetidor;
    public Alumno(String nombre, String apellidos, String dni, int telefono, int edad,Boolean repetidor) {
        super(nombre, apellidos, dni, telefono, edad);
        this.repetidor=repetidor;
    }

    public Boolean esRepetidor() {
        return repetidor;
    }

    @Override
    public void tipo() {
        System.out.println("Alumno");
    }

    @Override
    public String toString(){
        String texto=(repetidor)?"Si" : "No";
        return super.toString() + "\nRepite: "+texto;
    }

}
