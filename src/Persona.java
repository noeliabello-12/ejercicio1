public abstract class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private int telefono;
    private int edad;

    public Persona(String nombre,String apellidos,String dni,int telefono,int edad){
      this.nombre=nombre;
      this.apellidos=apellidos;
      this.dni=dni;
      this.telefono=telefono;
      this.edad=edad;

    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getDni(){
        return dni;
    }
    public int getTelefono(){
        return telefono;
    }
    public int getEdad(){
        return edad;
    }
    public abstract void tipo();




    @Override
    public String toString(){
        return "Nombre: "+nombre + " " + apellidos + "\nDNI: "+
                dni + "\nTelefono: "+
                telefono +"\nEdad: "+
                edad;
    }
}
