package Futbol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        // Leer los archivos de partidos y resultados
        String[] partidos = leerArchivo("Archivos/partidos.txt");
        String[] resultados = leerArchivo("Archivos/resultados.txt");

        // Persona 1
        String nombrePersona1 = "Juan Perez";
        String[] pronosticosPersona1 = leerArchivo("Archivos/pronosticos_juan.txt");
        int puntosPersona1 = calcularPuntos(pronosticosPersona1, resultados);

        // Persona 2
        String nombrePersona2 = "Maria Rodriguez";
        String[] pronosticosPersona2 = leerArchivo("Archivos/pronosticos_maria.txt");
        int puntosPersona2 = calcularPuntos(pronosticosPersona2, resultados);

        // Mostrar las puntuaciones finales de ambas personas
        System.out.println(nombrePersona1 + " ha obtenido " + puntosPersona1 + " puntos.");
        System.out.println(nombrePersona2 + " ha obtenido " + puntosPersona2 + " puntos.");
    
        Ronda primera = new Ronda("1", "Argentina", "Inglaterra", "4", "0");
        
        
       
    }

    private static int calcularPuntos(String[] pronosticos, String[] resultados) {
        int puntos = 0;

        // Verificar si cada pronóstico coincide con el resultado real
        for (int i = 0; i < resultados.length; i++) {
            String[] resultado = resultados[i].split("-");
            String[] pronostico = pronosticos[i].split("-");

            int golesReal = Integer.parseInt(resultado[0]) + Integer.parseInt(resultado[1]);
            int golesPronosticados = Integer.parseInt(pronostico[0]) + Integer.parseInt(pronostico[1]);

            if (golesReal == golesPronosticados) {
                puntos++;
            }
        }

        return puntos;
    }

    private static String[] leerArchivo(String nombreArchivo) {
    	
        String filePath = Paths.get("").toAbsolutePath().toString() + "/src/" + nombreArchivo;
    	
    	try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            return br.lines().toArray(String[]::new);
        } catch (IOException e) {
            System.err.format("Error al leer el archivo %s: %s%n", nombreArchivo, e);
            return null;
        }
    }
}
