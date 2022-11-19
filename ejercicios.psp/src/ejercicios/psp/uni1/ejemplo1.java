package ejercicios.psp.uni1;

import java.io.IOException;

public class ejemplo1 {
    public static void main(String[] args)  throws IOException{
        ProcessBuilder pb = new ProcessBuilder("notepad");
        Process p = pb.start();
    }
}
