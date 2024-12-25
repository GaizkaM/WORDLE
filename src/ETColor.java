//Gaizka Medina Gordo
package practica__final2023;

public class ETColor {
    // código de escritura con colores
    //CORRESPONDENCIA ÍNDICES CON COLORES
    //  ROJO     --> 0
    //  VERDE    --> 1
    //  AZUL     --> 2
    //  CYAN     --> 3
    //  MAGENTA  --> 4
    //  AMARILLO --> 5
    //  NEGRO    --> 6
    //  RESET    --> 7
    private static final String[] COLOR = {"\u001B[31m", "\u001B[32m", "\u001B[34m",
        "\u001B[36m", "\u001B[35m", "\u001B[33m","\u001B[0m"};
    private static final String RESET = "\u001B[0m"; //reestablecimiento color por defecto (negro)

    // método para escribir un string con un color en particular para cada letra
    public static void visualizador(String texto, int[] colorIndex) {
        String mensaje = "";

        for (int i = 0; i < texto.length(); i++) {
            mensaje = mensaje + COLOR[colorIndex[i]] + texto.charAt(i);
        }
        mensaje = mensaje + RESET;
        System.out.println(mensaje);
    }
}