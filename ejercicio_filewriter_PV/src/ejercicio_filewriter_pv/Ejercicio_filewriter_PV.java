/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_filewriter_pv;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Jhony Espinoza
 */
public class Ejercicio_filewriter_PV {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Crear y Leer archivo");
            System.out.println("2. Añadir texto adicional al archivo");
            System.out.println("3. Escribir array de Stringscon fecha");
            System.out.println("4. Escribir datos de un objeto en un archivo");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    try {
                    FileWriter archivo1 = new FileWriter("C:\\Users\\Jhony Espinoza\\OneDrive\\Documentos\\NetBeansProjects\\ACTV_3ER_CICLO\\EJERCICIOS_FILEWRITER");
                    archivo1.write("Hola ");
                    archivo1.write("Mundo ");
                    archivo1.write("Java");
                    archivo1.write("\n------------------------------------------------------------------------------");
                    archivo1.close();
                    FileReader ArchivoLectura = new FileReader("C:\\Users\\Jhony Espinoza\\OneDrive\\Documentos\\NetBeansProjects\\ACTV_3ER_CICLO\\EJERCICIOS_FILEWRITER\\primertexto.txt");
                    BufferedReader lectura = new BufferedReader(ArchivoLectura);
                    String linea = lectura.readLine();
                    while (linea != null) {
                        System.out.println(linea);
                        linea = lectura.readLine();
                    }
                    lectura.close();
                    System.out.println("Creacion y lectura completada correctamente");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

                case 2:
                            try {
                    FileWriter archivoAbierto = new FileWriter("C:\\Users\\Jhony Espinoza\\OneDrive\\Documentos\\NetBeansProjects\\ACTV_3ER_CICLO\\EJERCICIOS_FILEWRITER\\primertexto.txt", true);
                    archivoAbierto.write("\nTexto adicional agregado");
                    archivoAbierto.write("\n------------------------------------------------------------------------------");
                    archivoAbierto.close();
                    System.out.println("Texto adicional agregado exitosamente.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

                case 3:
                    String[] palabras = {"Messi", "Neymar", "Suarez", "Chavi", "Iniesta"};
                    LocalDate fechaActual = LocalDate.now();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    String fechaFormateada = fechaActual.format(formato);

                    try ( FileWriter archivoAbierto = new FileWriter("C:\\Users\\Jhony Espinoza\\OneDrive\\Documentos\\NetBeansProjects\\ACTV_3ER_CICLO\\EJERCICIOS_FILEWRITER\\primertexto.txt", true)) {
                        archivoAbierto.write("\nFecha Actual es : " + fechaFormateada + "\n");

                        for (String palabra : palabras) {
                            archivoAbierto.write(palabra + "\n");
                        }
                        archivoAbierto.write("------------------------------------------------------------------------------\n");

                        System.out.println("String con fecha agregados correctamente.");

                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo.");
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    Persona objetopersona = new Persona("Matias", "Sancho", "0102030405", 12);

                    try ( FileWriter archivoAbierto = new FileWriter("C:\\Users\\Jhony Espinoza\\OneDrive\\Documentos\\NetBeansProjects\\ACTV_3ER_CICLO\\EJERCICIOS_FILEWRITER\\primertexto.txt", true)) {
                        archivoAbierto.write(objetopersona.toString());
                        archivoAbierto.write("\n------------------------------------------------------------------------------");
                        System.out.println("Datos del objeto escritos correctamente.");
                        System.out.println(objetopersona.toString());
                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo.");
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }
}
