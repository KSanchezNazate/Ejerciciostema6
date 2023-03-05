import java.util.Scanner;
import java.util.Random;

public class Ejercicio2 {
    public static void main(String[] args) {
        char[][] tablero = new char[4][4];

        inicializarTablero(tablero);

        mostrarTablero(tablero);

        Random rand = new Random();
        int filaBarco = rand.nextInt(4);
        int columnaBarco = rand.nextInt(4);

        boolean encontrado = false;
        while (!encontrado) {
            int columna = introducirEnteroEntreLimites(1, 4) - 1;
            int fila = introducirEnteroEntreLimites(1, 4) - 1;

            encontrado = disparar(tablero, filaBarco, columnaBarco, fila, columna);

            mostrarTablero(tablero);
        }

        System.out.println("¡Ha ganado!");
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tablero[i][j] = '?';
            }
        }
    }

    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int introducirEnteroEntreLimites(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Introduzca un número entre " + min + " y " + max + ": ");
            num = sc.nextInt();
        } while (num < min || num > max);

        return num;
    }

    public static boolean disparar(char[][] tablero, int filaBarco, int columnaBarco, int fila, int columna) {
        if (fila == filaBarco && columna == columnaBarco) {
            tablero[fila][columna] = 'X';
            System.out.println("Tocado y hundido");
            return true;
        } else {
            tablero[fila][columna] = '~';
            System.out.println("Agua");
            return false;
        }
    }
}