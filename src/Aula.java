public class Aula {
    public static int cuenta;
    private int id;
    private String curso;
    private char letra;
    private int capacidad;

    public Aula(String curso, char letra, int capacidad){
        this.curso=curso;
        this.letra=letra;
        this.capacidad=capacidad;
        id=cuenta;
        cuenta++;
    }
    public String getCurso(){
        return curso;
    }

    public char getLetra() {
        return letra;
    }
    public int getCapacidad(){
        return capacidad;
    }

    public int getId() {
        return id;
    }
    public void setCurso(String curso){
        this.curso=curso;
    }
    public void setCapacidad(int capacidad){
        this.capacidad=capacidad;
    }
    public void setLetra(char letra){
        this.letra=letra;
    }

    @Override
    public String toString(){
        return curso+" "+letra+" "+capacidad+"(Alumnos)";
    }
}
