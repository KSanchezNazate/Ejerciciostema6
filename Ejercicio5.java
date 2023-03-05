import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Inicializar el tablero
        char[][] tablero = new char[10][40];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }

        // Mostrar el tablero
        mostrarTablero(tablero);

        // Inicializar el scanner
        Scanner sc = new Scanner(System.in);

        // Inicializar el menú
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("1. Dibujar un carácter");
            System.out.println("2. Dibujar un rectángulo");
            System.out.println("3. Cambiar el color");
            System.out.println("4. Salir");
            System.out.print("¿Qué opción deseas? ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    dibujarCaracter(tablero);
                    break;
                case 2:
                    dibujarRectangulo(tablero);
                    break;
                case 3:
                    cambiarColor(tablero);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida, selecciona una opción dentro del rango del menú.");
                    break;
            }
        }
    }

    // Función para mostrar el tablero
    public static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.println();
        }
    }

    // Función para dibujar un carácter
    public static void dibujarCaracter(char[][] tablero) {
        // Inicializar el scanner
        Scanner sc = new Scanner(System.in);

        // Preguntar al usuario qué carácter desea dibujar
        System.out.print("¿Qué carácter deseas dibujar? ");
        char caracter = sc.next().charAt(0 );

        // Preguntar al usuario en qué posición desea dibujar el carácter
        System.out.print("¿En qué fila deseas dibujar el carácter? ");
        int fila = sc.nextInt();
        System.out.print("¿En qué columna deseas dibujar el carácter? ");
        int columna = sc.nextInt(); 

        // Dibujar el carácter
        tablero[fila][columna] = caracter;

        // Mostrar el tablero
        mostrarTablero(tablero);
    }

    // Función para dibujar un rectángulo

    
    public static void dibujarRectangulo(char[][] tablero) {
        // Inicializar el scanner
        Scanner sc = new Scanner(System.in);

        // Preguntar al usuario qué carácter desea dibujar
        System.out.print("¿Qué carácter deseas dibujar? ");
        char caracter = sc.next().charAt(0 );

        // Preguntar al usuario en qué posición desea dibujar el carácter
        System.out.print("¿En qué fila deseas dibujar el rectángulo? ");
        int fila = sc.nextInt();
        System.out.print("¿En qué columna deseas dibujar el rectángulo? ");
        int columna = sc.nextInt(); 

        // Preguntar al usuario el ancho y alto del rectángulo
        System.out.print("¿Cuál es el ancho del rectángulo? ");
        int ancho = sc.nextInt();
        System.out.print("¿Cuál es el alto del rectángulo? ");
        int alto = sc.nextInt();

        // Dibujar el rectángulo
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                tablero[fila + i][columna + j] = caracter;
            }
        }

        // Mostrar el tablero
        mostrarTablero(tablero);
    }

    // Función para cambiar el color


    public static void cambiarColor(char[][] tablero) {
        // Inicializar el scanner
        Scanner sc = new Scanner(System.in);

        // Preguntar al usuario qué carácter desea dibujar
        System.out.print("¿Qué carácter deseas dibujar? ");
        char caracter = sc.next().charAt(0 );

        // Preguntar al usuario en qué posición desea dibujar el carácter
        System.out.print("¿En qué fila deseas cambiar el color? ");
        int fila = sc.nextInt();
        System.out.print("¿En qué columna deseas cambiar el color? ");
        int columna = sc.nextInt(); 

        // Cambiar el color
        char color = tablero[fila][columna];
        cambiarColor(tablero, fila, columna, color, caracter);

        // Mostrar el tablero
        mostrarTablero(tablero);
    }

    // Función para cambiar el color recursivamente


    public static void cambiarColor(char[][] tablero, int fila, int columna, char color, char caracter) {
        // Comprobar si la posición está dentro del tablero
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[fila].length) {
            return;
        }

        // Comprobar si la posición ya ha sido pintada
        if (tablero[fila][columna] != color) {
            return;
        }

        // Pintar la posición
        tablero[fila][columna] = caracter;

        // Pintar las posiciones adyacentes
        cambiarColor(tablero, fila - 1, columna, color, caracter);
        cambiarColor(tablero, fila + 1, columna, color, caracter);
        cambiarColor(tablero, fila, columna - 1, color, caracter);
        cambiarColor(tablero, fila, columna + 1, color, caracter);
    }
}
