package boleros.paractica;

import java.util.ArrayList;
import java.util.List;

public class Jugadores  implements Runnable{

    private String nombre;
    private List<Number> numeros;
    private Bolero b;
    List<Boolean> aciertos;
    private Boolean ejecutar = true;
    
    
    //PAra inicializar la clase se van a pedir el nombre, numeros y la bola
    public Jugadores(String nombre, List<Number> numeros, Bolero b) {
        this.nombre = nombre;
        this.numeros = numeros;
        this.b = b;
    }

    @Override
    public void run() {
        //IMPORTANTE: Se inicializa la lista de aciertos.
        this.aciertos = new ArrayList<>();
        while(Boolean.TRUE.equals(ejecutar)) {
            synchronized (b) {

                //Si el hilo contiene cuatro aciertos. 
                //Se notificara del gandor y se enviara una otrden para detener los demas hilos.
                if (aciertos.size() == 4) {
                    System.out.println("Ganador " + this.nombre);
                    System.out.println("**********************************");
                    ejecutar = false;
                    b.setEjecutar(false);
                    b.notifyAll();
                        
                } //End if

                //Verifica que el objeto bolero no se este ejecutando,
                //Este es el caso para los jugadores que no han ganado
                if(!Boolean.TRUE.equals(b.getEjecutar())) {
                    ejecutar = false;
                    Thread.currentThread().interrupt();

                } //End if

                //Ejecucion que se realizara cuando no haya un ganador
                if(Boolean.TRUE.equals(ejecutar)) {
                    try {
                        System.out.println("***********************************");
                        System.out.println("Esperando la bola");
                        b.wait();

                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); 
                    }
                    System.out.println(this.nombre + " ha escuchado el " + b.getBolo());
                    System.out.println("Sus numeros son: "+ this.numeros );
                    
                    //Por cada numero de la lista de numeros
                    for (Number numero : numeros) {
                        //Si el bolo es acertado sumara un booleano a los aciertos y mostrara un mensaje.
                        if(numero == b.getBolo()) {
                            System.out.println(this.nombre+" ha acertado el numero: " + b.getBolo());
                            this.aciertos.add(true);
                            System.out.println("Aciertos: " +aciertos.size());
                            System.out.println("*********************************");

                        }//End if

                    } //End for
                    
                } //End if

            } //End synchronized

        } //End while
       
    } // ENd run

    
}
