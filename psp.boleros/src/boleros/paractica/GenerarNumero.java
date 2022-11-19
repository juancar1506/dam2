package boleros.paractica;

public class GenerarNumero implements Runnable{
    private Bolero b;
    private boolean ejecutar = true;

    //Se le asigna un bolero en el constructor
    public GenerarNumero(Bolero b) {
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println("Se inicia el bingo");
        //SOlo se recorrera cuando si nadie ha ganado
        while(ejecutar) {
            try {
                Thread.sleep(generarTiempo());

                synchronized (b) {
                    //Asignar a ejecutar el valor recibido de otro hilo
                    if(!Boolean.TRUE.equals(b.getEjecutar())) {
                        ejecutar = false;

                    } //End if

                    //Si nadie ha gando, se genera un numero y se enviara a los otros hilos.
                    if(ejecutar){
                        this.b.setBolo((Number) Math.round(Math.random() * (50 - 1) + 1 ));
                        System.out.println("--------------------------------------");
                        System.out.println("La bola es el "+ this.b.getBolo());
                        System.out.println("--------------------------------------");
                        b.notifyAll();
                        
                    } //End if

                } // End synchronized

                } catch (InterruptedException  e) {
                    Thread.currentThread().interrupt();
                }
        } //End while
        Thread.currentThread().interrupt();

    } //End run
    
 
    //Funcion para generar el tiempo, es al azar entre 1-5 
    public long generarTiempo() {
        return Math.round(Math.random() * (5-1) +1 ) *1000;
    }

}
