package boleros.paractica;

/*
 * Esta clase servira para enviar un numero a los jugadores, 
 * el ejecutar permitira saber cuando se debe parar el programa
 * Detendra todos los hilos que haya ejecutendose.
 */
public class Bolero {
    
    private Number bolo;
    private Boolean ejecutar = true;

    public Number getBolo() {
        return bolo;
    }

    public void setBolo(Number bolo) {
        this.bolo = bolo;
    }

    public Boolean getEjecutar() {
        return ejecutar;
    }

    public void setEjecutar(Boolean ejecutar) {
        this.ejecutar = ejecutar;
    }
    
    
}
