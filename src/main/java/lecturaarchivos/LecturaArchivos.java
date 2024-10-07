package lecturaarchivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LecturaArchivos {

    public static void verUltimaConsulta() {
        try {
            File file = new File("src/main/java/archivosgenerados/consultasRealizadas.txt");
            Scanner sc = new Scanner(file);

            System.out.println("\nCONSULTAS REALIZADAS:");
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nEl archivo no fue encontrado.");
        }
    }
}
