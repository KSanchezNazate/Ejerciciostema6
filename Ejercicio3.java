import java.util.Random;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] tabla = new int[10];
        inicializarTabla(tabla);
        mostrarTabla(tabla);
        System.out.println("El mayor valor de la tabla es: " + mayor(tabla));
    }

    public static void inicializarTabla(int[] tabla) {
        Random rand = new Random();
        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = rand.nextInt(100);
        }
    }

    public static void mostrarTabla(int[] tabla) {
        for (int i = 0; i < tabla.length; i++) {
            System.out.print(tabla[i] + " ");
        }
        System.out.println();
    }

    public static int mayor(int[] tabla) {
        int mayor = tabla[0];
        for (int i = 1; i < tabla.length; i++) {
            if (tabla[i] > mayor) {
                mayor = tabla[i];
            }
        }
        return mayor;
    }
}