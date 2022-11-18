package boleros.paractica;

public class UsoBolero {
    public static void main(String[] args) {
         Bolero b = new Bolero();
        GenerarNumero gn = new GenerarNumero(b);
        Thread t = new Thread(gn).start(); 
    }
    
}
