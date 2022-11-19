package ejercicios.psp.uni1.repasoExcepciones;

import java.util.ArrayList;
import java.util.List;

public class generadorException {
    public static final Integer NUM_DE_EXCEPCIONES = 4;
    public static final int INTENTOS = 10;
    public static void main(String[] args) {
        int i = 0;
        while (i<INTENTOS) {
            generarExcepcion(i);
            i++;
        }
        System.out.println("Fin del programa");
    }   

    //Funcion que generara excepciones
    public static void generarExcepcion(int i) {
        int intento = (int) Math.round(Math.random() * (NUM_DE_EXCEPCIONES-1) + 1 );

        switch (intento) {
            case 1:
                try {
                    System.out.println(1/0);
                } catch (Exception e) {
                    // e.printStackTrace();
                    System.out.println("Se controla la excepcion  en la llamada "+ (i+1));
                }
                System.out.println("El programa no ha explotado gracias al manejo de excepciones");
                break;
            case 2:
                try {
                    int[] arrray = new int[-5];
                } catch (Exception e) {
                    // e.printStackTrace();
                    System.out.println("Se controla la excepcion en la llamada "+ (i+1));
                }
                System.out.println("El programa no ha explotado gracias al manejo de excepciones");
                break;
            case 3:
                try {
                    recibeNumero(null);
                } catch (Exception e) {
                    // e.printStackTrace();
                    System.out.println("Se controla la excepcion en la llamada "+ (i+1));
                }
                System.out.println("El programa no ha explotado gracias al manejo de excepciones");
                break;
                case 4:
                try {
                    List<Number> numeros = new ArrayList<>(); 
                    System.out.println(numeros.get(12));
                    
                } catch (Exception e) {
                    // e.printStackTrace();
                    System.out.println("Se controla la excepcion en la llamada "+ (i+1));
                }
                System.out.println("El programa no ha explotado gracias al manejo de excepciones");
            break;                     
            default:
                System.out.println("No se mostrara nada");
                break;
        }

    }

    public static void recibeNumero(List<Number> num) {
        System.out.println(num.size());
    }
}
