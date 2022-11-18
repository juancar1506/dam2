package boleros.paractica;

public class GenerarNumero implements Runnable{

    public static int TIEMPO = 5;
    private Bolero bola;

    public GenerarNumero(Bolero b) {
        this.bola = b;
    }

    @Override
    public void run() {
        while(true) {
            try {
                synchronized (bola) {
                    generarBola();
                    System.out.println("La bola es el "+ this.bola.getBolo());
                    notifyAll();
                }
                Thread.sleep(TIEMPO*1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }
    
    public void generarBola() {
        this.bola.setBolo((Number) Math.round(Math.random() * (50 - 1) + 1 ));
    }

}
