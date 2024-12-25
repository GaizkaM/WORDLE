//Gaizka Medina Gordo
package practica__final2023;

import java.util.Date;
import java.util.Random;

public class main {

    //método main
    public static void main(String[] argumentos) throws Exception {
        main m = new main();
        m.Menu();
    }

    //método metodoPrincipal
    public void metodoPrincipal() throws Exception {
        //el método metodoPrincipal únicamente inicia el subprograma
        //Menu
        Menu();

    }

    //método Menu para seleccionar el método a utilizar
    public static void Menu() throws Exception {
        //inicialización de un número entero llamado seleccion con el cual el 
        //jugador elegirá una de las opciones del menú
        int seleccion;
        //Visualización tanto del título del juego como de las diferentes opciones
        //a elegir por el jugador
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.println(
                                   "%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+
                                 "\n%                    WORDLE                     %"+
                                 "\n%              1.Jugar una partida              %"+
                                 "\n%     2.Ver las estadisticas de las partidas    %"+
                                 "\n%                    3.Salir                    %"+
                                 "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        //mensaje al jugador para seleccionar que opción desea
        //que ejecute el programa
        System.out.println("\n\nQue desea hacer?: ");
        //lectura del número introducido
        seleccion = LT.readInt();
        //switch de seelccion de la variable seleccion 
        //en función del número entero escrito
        switch (seleccion) {
            case 1 -> JugarPartida();
            case 2 -> EstadisticasPartidas();
            case 3 -> SalirJuego();
            default -> System.out.println("NUMERO INTRODUCIDO INCORRECTO");

        }
        //si el jugador selecciona el 1,comenzará el subprograma JugarPartida
        //si el jugador selecciona el 2,comenzará el subprograma HistorialPartidas
        //si el jugador selecciona el 3,comenzará el subprograma SalirJuego
        //si el jugador selecciona cualquier otro número,el programa enviará
        //un mensaje diciendo que el número introducido es incorrecto
            }

    //método JugarPartida donde inicia el juego
    public static void JugarPartida() throws Exception {
        //INICIALIZACIÓN
        //inicialización de todas las variables Palabra utilizadas en este método
        Palabra nombre = new Palabra();
        Palabra palabraLeida = new Palabra();
        //inicialización de los ficheros a ficheros en castellano
        PalabraFicherosLectura fichero1 =new PalabraFicherosLectura("wordle_es_solutions.txt");       
        PalabraFicherosLectura fichero2 =new PalabraFicherosLectura("wordle_es_solutions.txt");
        Palabra palabra_fichero=new Palabra();

        //inicialización de las variables encargadas de realizar el juego
        int numIntentos;
        int rondasJugadas = 0;
        int opcion;
        int [] colores= new int[5];     
        boolean encontrada=false;
        ResultadoFicheroEscritura fichero = new ResultadoFicheroEscritura("historial.txt");

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Jugaremos una partida de Wordle en castellano.");
        //mensaje al usuario para que introduzca su nombre
        System.out.println("Introduce tu nombre: ");
        //lectura nombre
        nombre.lectura2();
        
        
        //mensaje al usuario para que elija el idioma en el que desea jugar
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Bienvenido " + nombre + ", en que idioma deseas jugar?:  \n\n"
                           +"1.Castellano\n\n"
                           +"2.Catalán\n\n");
        opcion=LT.readInt();
        
        //switch de opción en función de que haya elegido el usuario
        switch (opcion) {
            case 1 -> {
                palabra_fichero= new Palabra("wordle_es_wordlist.txt");
            }
            case 2 -> {
                fichero1 =new PalabraFicherosLectura("wordle_ca_solutions.txt");
                fichero2 =new PalabraFicherosLectura("wordle_ca_solutions.txt");
                palabra_fichero= new Palabra("wordle_ca_wordlist.txt");                
            }
            default -> System.out.println("NÚMERO INTRODUCIDO INCORRECTO");

        }
        //si elige 1, el programa no hará nada puesto que los ficheros ya están
        //inicializados con las palabras en castellano
        //si elige 2, los ficheros se instanciarán con los ficheros de las palabras
        //en catalán
        
        
        //inicialización de los métodos encargados de inicializar la palabra objetivo
        Palabra palabraObjetivo;   
        int NumLineasFichero = 0;
        //bucle que nos indica el número de líneas/palabras que hay en el fichero
        while (fichero1.hayPalabras()){
           fichero1.lectura();
           NumLineasFichero++;
        }       
        //cierre del fichero1
        fichero1.cerrarEnlaceFichero();

        //inicialización del número random de entre todas las palabras posibles
        //del fichero
        Random random= new Random();
        int NumRnd = random.nextInt(NumLineasFichero);    
        //inicialización palabra objetivo con el método leerLinea()
        palabraObjetivo=fichero2.leerLinea(NumRnd);
        //cierre fichero2
        fichero2.cerrarEnlaceFichero();
        

        //mensaje al usuario para que introduzca el número de rondas a jugar (intentos)
        System.out.println("De acuerdo " + nombre + ", cuantos intentos desea jugar?: ");
        //lectura número de rondas
        numIntentos = LT.readInt();
        //inicialización del array de palabras jugadas del tamaño de intentos elegidos
        //por el usuario
        Palabra [] palabrasJugadas= new Palabra[numIntentos];
        //inicialización de la Palabra vacía
        Palabra palabraVacia=new Palabra("");
        
        //bucle que inicializa el array de Palabras palabrasJugadas con palabras 
        //vacías        
        for(int l=0;l<palabrasJugadas.length;l++){
            
            palabrasJugadas[l]=palabraVacia;
        }
   
        //bucle para jugar el número de intentos establecidos
        while (numIntentos > rondasJugadas && !(encontrada)) {
            //mensaje al usuario indicándole el intento actual y diciéndole que 
            //escriba una palabra
            System.out.println("\n\n\n\n\n\n\n\nINTENTO "+(rondasJugadas+1));
            System.out.println("\nInserte una palabra que contenga 5 letras: ");
            //lectura de la palabra con el metodo .lectura2() (este método es una modificación 
            //muy pequeña del método lectura() original)
            palabraLeida.lectura2();            
            //inicializamos la palabra actual que será igual a nuestra palabra leída
            //y la insertamos en el array de palabras jugadas
            Palabra palabraActual=new Palabra(palabraLeida.toString());
            palabrasJugadas[rondasJugadas]= palabraActual;
           
            //Condición que muestra si la palabra está en el fichero con la palabra
            //introducida por parámetro con el método .contenidaFichero()
            if (palabraActual.contenidaFichero(palabra_fichero)) {                 
                //Cogemos la longitud de la palabra (Número de carácteres)
                int longitudPalabra = palabraActual.getNumeroCaracteres();
                //leemos la palabraActual caracter a caracter               
                for (int i = 0; i < longitudPalabra; i++) {
                    //inicializamos la letra a comprobar
                    char letra = palabraActual.obtenerCaracter(i);
                    //si la letra coincide con la letra de la misma posición se pondrá de color verde
                    if (letra == palabraObjetivo.obtenerCaracter(i)) {
                        //el valor 1 representa el color verde
                        colores[i]=1;                            
                    //si la letra está contenida en la palabraObjetivo se pondrá de color amarillo
                    //lo comprobamos mediante el método letraContenidaPalabra
                    } else if (palabraActual.letraContenidaPalabra(letra, palabraObjetivo)) {  
                        //el valor 5 representa el color amarillo
                        colores[i]=5;
                    //si la letra no está contenida en la palabraObjetivo se quedará de color gris
                    } else {
                        //el valor 6 representa el color rojo
                        colores[i]=6; 
                    }                  
                }
                //mediante la clase ETColor, mostramos por pantalla la palabra escrita por
                //el jugador con los colores correspondientes de cada una de sus letras
                ETColor.visualizador(palabraActual.toString(), colores);
                
                //mediante el método iguales(), comprobamos si las 2 palabras son la
                //misma
                if (palabraActual.iguales(palabraObjetivo)){
                    //asignamos la variable encontrada a TRUE para finalizar el bucle
                    encontrada=true;
                    //mostramos por pantalla al usuario un mensaje indicándole que ha
                    //encontrado la palabra objetivo
                    System.out.println("Muy bien, "+nombre+". Has conseguido encontrar "
                        + "la solucion en "+(rondasJugadas+1)+" intento/s!!");
                }
                //una vez mostramos los colores y sabemos la palabra,ascendemos el número de 
                //rondas
                rondasJugadas++;
                
            } else {
                //si la palabra no está en el fichero, se muestra por pantalla un mensaje
                //indicándolo
                System.out.println("ERROR, LA PALABRA " + palabraActual + " NO ES VALIDA.");
            }
        }
        // En caso de no encontrar la palabra antes de completar todas las rondas,
        // finaliza la partida y se muestra la palabra Objetivo
        if(!encontrada){
        System.out.println("No has podido encontrar la palabra. \n"
                + "La palabra objetivo era: " + palabraObjetivo);
        }
        
       //inicializamos la variable que nos almacena la fecha y hora de la partida jugada
       Date fechaActual = new Date();
       //se guardan la fecha,hora,nombre,palabra Objetivo y las palabras usadas en el fichero 
       //"historial" mediante el método escritura de la clase ResultadoFicheroEscritura
       fichero.escritura(fechaActual, nombre, palabraObjetivo,palabrasJugadas);   
        
        //cierres enlaces con ficheros
        fichero.cerrarEnlaceFichero();

        //mensaje al usuario para volver al menú
        System.out.println('\n' + "\nPulse cualquier numero para volver al menu");
        opcion = LT.readInt();

        switch (opcion) {
            default -> Menu();
        }
    }

    //método EstadisticasPartidas que muestra las partidas jugadas
    public static void EstadisticasPartidas() throws Exception {
        //inicialización de las variables utilizadas en este método
        ResultadoFicheroLectura fichero = new ResultadoFicheroLectura("historial.txt");
        int opcion;

        //visualización del historial de partidas
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+
                         "\n%           ESTADISTICAS           %"+
                         "\n%          DE LAS PARTIDAS         %"+
                         "\n%              JUGADAS             %"+
                         "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n\n\n");
       

        //mostramos por pantalla el fichero "historial.txt"
        while (fichero.hayPalabras()) {    
        System.out.print(fichero.lectura().toString());   
        }
        //cierre del fichero
        fichero.cerrarEnlaceFichero();

        //mensaje al jugador para regresar al menú
        System.out.println("\n\n\nPulse cualquier numero para volver al menu");
        opcion = LT.readInt();

        //switch para volver al menú independientemente del entero que se escriba
        switch (opcion) {
            default -> Menu();
        }
    }

    //método SalirJuego que finaliza el programa
    public static void SalirJuego() throws Exception {
        //inicialización de un número entero llamado opcion con
        //el cual el jugador elegirá una de las dos opciones posibles
        int opcion;

        //mensaje al jugador de confirmación para salir del juego 
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+
                         "\n%     Desea salir del juego?:     %"+
                         "\n%              1.SI               %"+
                         "\n%       2.NO(volver al menu)      %"+
                         "\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        //lectura del número entero introducido
        opcion = LT.readInt();
        //switch de la variable opcion para elegir que deseará hacer el jugador
        switch (opcion) {
            case 1 -> System.out.println("¡Hasta luego!");
            //si el jugador pulsa 1,el programa se cerrará
            case 2 -> Menu(); //si el jugador pulsa 2,volverá a abrir el subprograma Menu
            default -> System.out.println("NUMERO INTRODUCIDO INCORRECTO");

        }
        //si el jugador selecciona cualquier otro número,el programa
        //enviará un mensaje diciendo que el número introducido es incorrecto
            }
}
