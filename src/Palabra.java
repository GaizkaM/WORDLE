//proyecto creado por Gaizka Medina Gordo

//CLASE Palabra únicamente con los métodos necesarios para la realización de la práctica
package practica__final2023;

public class Palabra {
    //DECLARACIÓN DE LOS ATRIBUTOS DE LA CLASE QUE DESCRIBEN EL ESTADO DE LOS
    //OBJETOS Palabra
    //declaración atributo de clase constante de tipo entero para representar el máximo
    //número de caractres que puede tener un objeto Palabra
    private static final int MAXIMO_NUMERO_CARACTERES=20;
    //declaración atributo de clase constante de tipo char para representar el
    //caracter de fin de secuencia de caracteres
    private static final char FINAL_SECUENCIA='.';
    //declaración atributo de clase constante char que representa el
    //caracter de control SALTO DE LINEA
    private static final char SALTO_LINEA='\n';
    //declaración atributo de clase constante de tipo char que representa el
    //caracter espacio en blanco(' '
    private static final char ESPACIO=' ';
    //declaración atributo de clase variable de tipo char paa representar el
    //caracter leido de la secuencia de caracteres
    private static char caracter=ESPACIO;
    //declaración atributo de objeto de tipo array de componentes tipo char para
    //representar/almacenarlos caracteres de un objeto Palabra
    private char [] caracteres=new char[MAXIMO_NUMERO_CARACTERES];
    //declaración atrbuto de objeto de tipo entero para representar el número
    //de caracteres de un objeto Palabra
    private int numeroCaracteres;
    
    
    //MÉTODOS
    
    //método constructor
    public Palabra() {
        //inicialización del atributo de objeto numeroCaracteres
        numeroCaracteres=0;
    }

    public Palabra(String dato) {
        //inicialización del atributo de objeto numeroCaracteres
        numeroCaracteres=dato.length();
        //asignación de los caracteres del String dato en el atributo caracteres
        caracteres=dato.toCharArray();
    }    
    
    
    //método funcionales describen el comportamiento de los objetos Palabra
    
    //método de clase buscarPalabra que lleva a cabo la búsqueda de un objeto Palabra 
    //en la secuencia de caracteres
    private static void buscarPalabra() {
        while (caracter==ESPACIO) {
            //lectura siguiente caracter de la secuencia
            caracter=LT.readChar();
        }
    }
  
    //método de clase  boleano hayPalabras que verifica si en la secuencia de caracteres hay
    //al menos una palabra para leer
    public static boolean hayPalabras() {
        buscarPalabra();
        if ((caracter!=FINAL_SECUENCIA)&&(caracter!=SALTO_LINEA)) {
            return true;
        }
        else {
            //vaciar buffer de entrada
            if (caracter==FINAL_SECUENCIA) LT.skipLine();
            //inicializar el atributo caracter a espacio para poder estar preparados
            //para la lectura de la palabras desde una nueva secuencia de caracteres
            //introducida por teclado
            caracter=ESPACIO;
            //devolver false como resultado de este método
            return false;
        }  
    }
    
    //método de objeto lectura que lleva a cabo la lectura de un objeto Palabra
    //desde la secuencia de caracteres.
    //NOTA: el método lectura solo será llamado siempre y cuando haya, al menos,
    //una palabra en la secuencia para leer
    public void lectura() {
        //inicialización atributo numeroCaracteres a 0
        numeroCaracteres=0;
        //bucle de lectura y almacenamiento de los caracteres del objeto Palabra a leer
        //desde la secuencia de caracteres
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)&&(caracter!=SALTO_LINEA)) {
            //al ser un caracter alfabético es un caracter de la palabra que estamos
            //leyendo y por lo tanto será almacenado en la componente que
            //le corresponde del array caracteres
            caracteres[numeroCaracteres]=caracter;
            //incremneto del atributo numeroCaracteres
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia 
            caracter=LT.readChar();
        }
    }

    //método de objeto lectura2 que lleva a cabo la lectura de un objeto Palabra
    //desde la secuencia de caracteres.
    //NOTA: el método lectura solo será llamado siempre y cuando haya, al menos,
    //una palabra en la secuencia para leer
    public void lectura2() {
        //inicialización atributo numeroCaracteres a 0
        numeroCaracteres=0;
        //bucle de lectura y almacenamiento de los caracteres del objeto Palabra a leer
        //desde la secuencia de caracteres
        caracter=LT.readChar();
        while ((caracter!=FINAL_SECUENCIA)&&(caracter!=ESPACIO)&&(caracter!=SALTO_LINEA)) {
            //al ser un caracter alfabético es un caracter de la palabra que estamos
            //leyendo y por lo tanto será almacenado en la componente que
            //le corresponde del array caracteres
            caracteres[numeroCaracteres]=caracter;
            //incremneto del atributo numeroCaracteres
            numeroCaracteres++;
            //lectura siguiente caracter de la secuencia 
            caracter=LT.readChar();
        }
    }
      
    //método de objeto toString que lleva a cabo la conversión de un objeto Palabra
    //a String con fines de utilizarlo en las sentencias System.out.print y 
    //System.out.println
    public String toString() {
        //DECLARACIONES
        //declaración de una variable Striung para almacenar el resultado
        //de la concatenación de los caracteres del objeto Palabra a convertir
        String resultado="";
        
        //ACCIONES
        //bucle de concatenaciones
        for (int indice=0;indice<numeroCaracteres;indice++) {
            //concatenar el caracter de lapalabra almacenado en la componente
            //indice-ésima del array caracteres con el String resultado
            resultado=resultado+caracteres[indice];
        }
        //devoluciñon String resultante
        return resultado;   
    }   
    
    //método de objeto getNumeroCaracteres devuelve el número de caracteres de 
    //un objeto Palabra
    public int getNumeroCaracteres() {
        return numeroCaracteres;
    }

    //MÉTODO adicionCaracter LLEVA A CABO LA ADICIÓN DE UN CARACTER DADO POR PARÁMETRO
    //EN UN OBJETO Palabra
    public void adicionCaracter(char caracter) {
        //almacenar el caracter dado en la primera componente libre del atributo
        //caracteres del objeto Palabra. El índice de dicha componente coincide
        //con el valor del atributo numeroCaracteres del mismo objeto Palabra
        caracteres[numeroCaracteres]=caracter;
        //incrementar el atributo numeroCaracteres del objeto Palabra para que
        //tenga en cuenta el caracter que acabamos de añadir en la palabra
        numeroCaracteres++;
    }
    
    //MÉTODO obtenerCaracter LLEVA A CABO LA OBTENCIÓN DEL CARACTER DE UNA
    //PALABRA QUE ESTÁ ALMACENADO EN LA POSICIÓN DADA DENTRO DEL ATRIBUTO
    //caracteres DE DICHO OBJETO Palabra
    public char obtenerCaracter(int posicion) {
        //devolver el caracter del objeto Palabra que está en la posición
        //dada dentro del atributo array caracteres
        return (caracteres[posicion]);
    }   

    //MÉTODO DE OBJETO iguales LLEVA A CABO LA VERIFICACIÓN DE SI LOS DOS OBJETOS
    //Palabra DADOS POR PARÁMETROS SON IGUALES
    public boolean iguales(Palabra palabra2) {
        if (numeroCaracteres==palabra2.numeroCaracteres) {
            //verificación si son iguales a nivel de caracteres
            for (int indice=0;indice<numeroCaracteres;indice++) {
                //verificación si son iguales a nivel de la componente indice
                //del atributo caracteres
                if (caracteres[indice]!=palabra2.caracteres[indice]) {
                    //devolución valor false porque no son iguales
                    return false;
                }
            }
            //devolución valor true porque ambos objetos Palabra son iguales
            //ya que tienen todos los caracteres son iguales
            return true;
        }
        else {
            //devolución valor false porque los dos objetos no son iguales
            //porque no tienen el mismo número de caracteres
            return false;
        }
    }
    
    //MÉTODO letraContenidaPalabra nos indica si una letra está contenida dentro
    //de una palabra
    public boolean letraContenidaPalabra (char letra, Palabra palabra){
        for (int i=0;i<palabra.getNumeroCaracteres();i++){
            if (letra==palabra.obtenerCaracter(i)){
                return true;
            }
        }
        return false;
    }
    
    //MÉTODO contenidaFichero que devuelve true si una palabra se encuentra dentro
    //de un ficehro cualquiera indicando su nombre por parámetro
    public boolean contenidaFichero(Palabra palabraFichero) throws Exception {
        //DECLARACIONES
        //declaración objeto Palabra para almacenar, de una en una, las palabras
        //leídas desde el fichero
        Palabra palabra=new Palabra();
        //declaración del fichero auxiliar para realizar la búsqueda
        PalabraFicherosLectura fichero=new PalabraFicherosLectura(palabraFichero.toString());
        
        //ACCIONES
        //bucle búsqueda en el fichero de la palabra dada
        for (;fichero.hayPalabras();) {
            //lectura palabra desde el fichero
            palabra=fichero.lectura();
            //verificar si la palabra leída desde el fichero es igual a la
            //palabra dada
            if (iguales(palabra)) {
                //cierre enlace con fichero
                fichero.cerrarEnlaceFichero();
                //devolución como resultado el valor TRUE pues la palabra
                //dada está en el fichero
                return true;
            }
        }
        //cierre enlace con fichero
        fichero.cerrarEnlaceFichero();
        //devolución como resultado el valor FALSE pues la palabra dada
        //NO está en el fichero
        return false;
    }
}