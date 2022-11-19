package boleros.paractica;

import java.util.ArrayList;
import java.util.List;

public class UsoBolero {
    public static final int MAX_NUMEROS= 4;
    public static void main(String[] args) {
        //Se crea el bolo
         Bolero b = new Bolero();

         //Se crea y se inicia un hilo para generar numeros aleatorios entre 1-50 
         new Thread(new GenerarNumero(b)).start();

         new Thread(new Jugadores("Jose Luis", generarNumeros(), b)).start();
         new Thread(new Jugadores("Cristina", generarNumeros(), b)).start();
         new Thread(new Jugadores("Maria", generarNumeros(), b)).start();
         new Thread(new Jugadores("Jesus", generarNumeros(), b)).start();

    }

    // Generara un array con 4 numeros, se agregaran al objeto Jugadores
    public static List<Number> generarNumeros() {
        List<Number> numeros = new ArrayList<>();
        int i = 0;
        while (i<MAX_NUMEROS) {
            numeros.add(generarNumero());
            i++;
        }        

        return numeros;
    }
    
    //Genera un numeros aleatorios entre 1 - 50,  se usara
    // en la funcion generarNumeros()
    public static Number generarNumero() {
        return Math.round(Math.random() * (50 - 1) + 1 );
    }
}
