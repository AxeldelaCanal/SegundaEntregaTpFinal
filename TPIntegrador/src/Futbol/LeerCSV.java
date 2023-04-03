package Futbol;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeerCSV {
    public static void leer(String[] args) {
        File archivoCSV = new File("ruta/al/archivo.csv");

        try {
            Scanner lector = new Scanner(archivoCSV);

            while (lector.hasNext()) {
                String linea = lector.nextLine();
                String[] valores = linea.split(",");

                // hacer algo con los valores
                // por ejemplo, imprimirlos
                for (String valor : valores) {
                    System.out.print(valor + " ");
                }
                System.out.println();
            }
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
