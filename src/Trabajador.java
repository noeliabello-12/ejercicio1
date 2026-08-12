public class Trabajador extends Persona{
    private int anhoDocente;
    private Docente puesto;
    public Trabajador(String nombre, String apellidos, String dni, int telefono, int edad, int anhoDocente,Docente puesto) {
        super(nombre, apellidos, dni, telefono, edad);
        this.anhoDocente=anhoDocente;
        this.puesto=puesto;
    }
    public int getAnhoDocente(){
        return anhoDocente;
    }
    public Docente getPuesto(){
        return puesto;
    }
    public void setPuesto(Docente puesto){
        this.puesto=puesto;
    }
    @Override
    public void tipo() {
        System.out.println(puesto);
    }
    @Override
    public String toString(){
        return super.toString() + "\nAños Docencia: "+ anhoDocente + "\nPuesto: " + puesto;
    }
}
