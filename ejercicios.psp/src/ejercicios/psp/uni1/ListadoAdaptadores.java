package ejercicios.psp.uni1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ListadoAdaptadores {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("CMD", "/C", "ipconfig").start();
        String cadena ="";
        ArrayList<String> listado = new ArrayList<String>();

        try {
            InputStream is = p.getInputStream();

            	// mostramos en pantalla caracter a caracter
			 int c = is.read();
			 while ( c != -1) {
                c = is.read();
                cadena +=  (char) c;
                if(c==32) {
                    listado.add(cadena);
                    cadena="";
                }
             }
             is.close();
            } catch (Exception e){
                e.printStackTrace();
            }
            String regex = "[.]{3}";
            System.out.print(listado);
            for (String palabra : listado) {
                if(palabra.contains(regex)) {
                    System.out.println(palabra);
                }
            }
    }
}
