package ejercicios.psp.uni1;

import java.util.Iterator;
import java.util.List;

public class Comando {
    public static void main(String args[])
  {
    ProcessBuilder test = new ProcessBuilder();
	test= new ProcessBuilder("java", "Un saludo", "\"Hola Mundo!!\"");

	//devuelve el nombre del proceso y sus argumentos
	List l = test.command();
	Iterator iter = l.iterator();
	System.out.println("Argumentos del comando:");
	while (iter.hasNext())
		System.out.println(iter.next());
  }
}
