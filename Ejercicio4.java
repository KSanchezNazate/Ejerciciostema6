import java.util.Scanner;

public class  Ejercicio4 {
    public static void main(String[] args) {
        // Inicializar el tablero
        char[] tablero = {'>', '>', '>', '/', ' ', '/', '<', '<', '<'};
        Scanner sc = new Scanner(System.in);
        int ovejaMover;

        // Mostrar el tablero
        mostrarTablero(tablero);

        // Mover las ovejas hasta que se cumpla la condición de victoria
        while (!condicionDeVictoria(tablero)) {
            // Preguntar al usuario qué oveja desea mover
            System.out.print("¿Qué oveja deseas mover? ");
            ovejaMover = sc.nextInt();

            // Verificar si la oveja seleccionada es válida
            if (ovejaMover < 0 || ovejaMover >= tablero.length) {
                System.out.println("Opción inválida, selecciona una oveja dentro del rango del tablero.");
                continue;
            }

            // Verificar si la oveja seleccionada es un espacio vacío
            if (tablero[ovejaMover] == ' ') {
                System.out.println("No hay una oveja en esa posición, selecciona una posición con una oveja.");
                continue;
            }

            // Verificar si la oveja puede moverse un espacio hacia adelante
            if (puedeAvanzar(tablero, ovejaMover)) {
                moverOveja(tablero, ovejaMover, ovejaMover + 1);
                mostrarTablero(tablero);
            }

            // Verificar si la oveja puede saltar sobre otra oveja
            else if (puedeSaltar(tablero, ovejaMover)) {
                int espacioLibre = encontrarEspacioLibre(tablero, ovejaMover);
                moverOveja(tablero, ovejaMover, espacioLibre);
                mostrarTablero(tablero);
            }

            // Si la oveja no puede moverse, mostrar un mensaje de error
            else {
                System.out.println("No hay movimientos disponibles para esa oveja, selecciona otra oveja.");
            }
        }

        // Mostrar un mensaje de victoria
        System.out.println("¡Felicidades! Has cruzado todas las ovejas al otro lado del tablero.");
    }

    // Función para mostrar el tablero
    public static void mostrarTablero(char[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            System.out.print(tablero[i] + " ");
        }
        System.out.println();
    }

    // Función para verificar si se cumple la condición de victoria
    public static boolean condicionDeVictoria(char[] tablero) {
        boolean victoria = true;
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == '>') {
                victoria = false;
            }
        }
        return victoria;
    }

    // Función para verificar si una oveja puede avanzar un espacio
    public static boolean puedeAvanzar(char[] tablero, int ovejaMover) {
        if (tablero[ovejaMover] == '>' && ovejaMover < tablero.length - 1 && tablero[ovejaMover + 1] == ' ') {
            return true;
        } else if (tablero[ovejaMover] == '<' && ovejaMover > 0 && tablero[ovejaMover - 1] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean puedeSaltar(char[] tablero, int ovejaMover) {
        if (tablero[ovejaMover] == '>' && ovejaMover < tablero.length - 2 && tablero[ovejaMover + 1] == '<' && tablero[ovejaMover + 2] == ' ') {
            return true;
        } else if (tablero[ovejaMover] == '<' && ovejaMover > 1 && tablero[ovejaMover - 1] == '>' && tablero[ovejaMover - 2] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    // Función para encontrar el espacio libre donde una oveja puede saltar
    public static int encontrarEspacioLibre(char[] tablero, int ovejaMover) {
        if (tablero[ovejaMover] == '>') {
            return ovejaMover + 2;
        } else {
            return ovejaMover - 2;
        }
    }

    // Función para mover una oveja
    public static void moverOveja(char[] tablero, int ovejaMover, int nuevoEspacio) {
        tablero[nuevoEspacio] = tablero[ovejaMover];
        tablero[ovejaMover] = ' ';
    }
}
