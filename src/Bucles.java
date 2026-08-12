import java.util.*;

public class Bucles {
    Scanner sc = new Scanner(System.in);
    String frase = "Esto es una prueba para bucles";

    public Bucles() {

    }

    public Bucles(Boolean bool) {
        int num = -1;
        int contador = 1;
        while (num != 0) {
            System.out.println("Bucle: " + contador);
            System.out.println("Introduce un numero: ");
            num = sc.nextInt();
            String texto = "Hola";
            for (int i = 0; i < num; i++) {
                int actual = i + 1;
                System.out.println(texto + " " + actual);

            }
            contador++;
        }
    }

    public Bucles(int o) {
        String[] palabras = frase.split(" ");
        if (o >= palabras.length) {
            o = palabras.length;
        }
        for (int i = 0; i < o; i++) {
            System.out.println(palabras[i]);
        }
    }

    public Bucles(int[] numeros) {
        int aprobado = 0;
        int mayorNota = 0;
        int suspensos = 0;
        int media = 0;
        int mejorNotas = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] >= 5) {
                aprobado++;
            } else {
                suspensos++;
            }
            if (numeros[i] > mayorNota) {
                mayorNota = numeros[i];
            }
            if (numeros[i] >= 9) {
                mejorNotas++;
            }
            media += numeros[i];
        }
        System.out.println("Numeros de sobresalientes: " + mejorNotas);
        System.out.println("La media es: " + (double) (media / numeros.length));
        System.out.println("Han aprobado: " + aprobado);
        System.out.println("La mayor nota fue: " + mayorNota);
        System.out.println("Los suspensos son:  " + suspensos);
    }

    public Bucles(int[] notas, String[] alumnos) {
        int mejorNota = 0;
        String alumno = "";
        int peorNota =10;
        String alumno1 = "";
        List<String> aprobados =new ArrayList<>();
        for (int i = 0; i < notas.length; i++) {
            System.out.println("La nota de " + alumnos[i] + " es " + notas[i]);
            if (notas[i] > mejorNota) {
                mejorNota = notas[i];
                alumno = alumnos[i];
            }
            if(notas[i]<peorNota){
                peorNota=notas[i];
                alumno1=alumnos[i];
            }
            if(notas[i]>=5){
                aprobados.add(alumnos[i]);
            }

        }
        System.out.println("Los aprobados son: "+aprobados);
        System.out.println("La peor nota fue: "+alumno1+" "+peorNota);
        System.out.println("La mejor nota de la clase es: "+alumno+" "+mejorNota);
    }
    public Bucles(String[] alumnos){
        int contador = 0;

        while(contador<alumnos.length){
            System.out.println(alumnos[contador]);
            contador++;
        }
    }
    public Bucles(List<String> lista,int opcion){
        if (opcion==1) {
            System.out.println("Recorrer lista con for each");
            for (String letras : lista) {
                System.out.println(letras);
            }
        }else if(opcion==2){
            System.out.println("Recorrer lista con while");
            int contador =0;
            while (contador<lista.size()){
                System.out.println(lista.get(contador));
                contador++;
            }
        }else if(opcion==3){
            System.out.println("Recorrer lista con for ");
            for(int i=0;i<lista.size();i++){
                System.out.println(lista.get(i));
               /* if (lista.get(i).equals("C")){
                    lista.remove(i);
                }*/
            }
        }else if(opcion==4){
            System.out.println("Recorrer lista con iterador");
            Iterator<String> it = lista.iterator();

            while(it.hasNext()){
                String elemento =it.next();
                System.out.println(elemento);
                if(elemento.equals("C")){
                    it.remove();
                }

            }
            System.out.println("lista: "+lista.size());
        } else if (opcion==5) {
            System.out.println("Recorrer lista con do while");
            int contador=0;
            do{
                System.out.println(lista.get(contador));
                contador++;
            }while (contador<lista.size());
        }
    }
    public Bucles(List<String>lista,String[] lista1){
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i));
            for(int j=0;j<lista1.length;j++){
                System.out.print(lista1[j]);
            }
        }
    }
}