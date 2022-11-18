package boleros.paractica;

import java.util.List;

public class Jugadores  implements Runnable{
    private String nombre;
    private List<Number> numeros;
    private Bolero b;
    
    

    public Jugadores(String nombre, List<Number> numeros, Bolero b) {
        this.nombre = nombre;
        this.numeros = numeros;
        this.b = b;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Number> getNumeros() {
        return numeros;
    }
    public void setNumeros(List<Number> numeros) {
        this.numeros = numeros;
    }
    public Bolero getB() {
        return b;
    }
    public void setB(Bolero b) {
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b) {
            try {
                System.out.println(this.nombre + " ha escuchado el numero"+ b.getBolo());
                wait();
            } catch (Exception e) {
                e.printStackTrace();    
            }
        }
        
    }

    
}
