//proyecto creado por Gaizka Medina Gordo
package practica__final2023;

import java.io.BufferedReader;
import java.io.FileReader;



public class ResultadoFicheroLectura {
      //DECLARACIONES ATRIBUTOS
    //Declaración atributo de clase constante entero que representa el final de
    //un fichero
    private static final int FINAL_FICHERO=-1;
    //declaración atributo de clase constante entero que representa el código
    //de caracter del caracter espacio en blanco
    private static final int COD_ESPACIO=(int) ' ';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control RETURN
    private static final int RETURN=(int) '\r';
    //declaración atributo de clase constante entero que representa el código
    //del caracter de control SALTO DE LINEA
    private static final int SALTO_LINEA=(int) '\n';
    //declaración atributo de objeto variable entero que represente el código
    //de caracter leido desde el fichero
    private int codigo=COD_ESPACIO;
    //declaración atributo de objeto BufferedReader que posibilite el enlace
    //con el fichero de texto a nivel de lectura
    private BufferedReader fichero=null;
    
    //MÉTODOS
    //MÉTODO CONSTRUCTOR
    public ResultadoFicheroLectura(String nombreFichero) throws Exception {
        //establecimiento enlace BufferedReader con fichero de texto identificado
        //a través del parámetro String nombreFichero dado
        fichero=new BufferedReader(new FileReader(nombreFichero));
    }
    
    //MÉTODOS FUNCIONALES
    //MÉTODO hayPalabras QUE VERIFICA SI HAY ALGUNA PALABRA EN EL FICHERO REPRESENTADO
    //A TRAVÉS DEL OBJETO BufferedReader CORRESPONDIENTE
    public boolean hayPalabras() throws Exception {
        buscarPalabra();
        return (codigo!=FINAL_FICHERO);
    }
    
    //MÉTODO buscarPalabra LLEVA A CABO LA BÚSQUEDA DE UNA PALABRA EN EL FICHERO
    //REPRESENTADO POR EL OBJETO BufferedReader CORRESPONDIENTE.
    //LA BÚSQUEDA ESTÁ FUNDAMENTADA EN IDENTIFICAR UN CÓDIGO DE CARACTER LEIDO
    //DESDE EL FICHERO COMO ALBABÉTICO MINÚSCULA, LO CUAL, SINGNIFICARÁ
    //QUE SE HA ENCONTRADO UNA PALABRA EN EL FICHERO. SI EN EL FICHERO NO
    //QUEDASEN PALABRAS POR LEER ENTONCES LA BUSQUEDA TERMINARÍA CON EL
    //FINAL DE FICHERO.
    //TODO ELLO, DEBIDO A QUE EL JUEGO DE CARACTERES CON EL QUE TRABAJAMOS
    //AHORA ESTÁ CONSTITUIDO POR LOS CARACTERES ALFABÉTICOS MINÚSCULAS Y EL
    //ESPACIO EN BLANCO, LA CONDICIÓN DE BÚSQUEDA ESTARÁ FUNDAMENTADA
    //EN SEGUIR LEYENDO DEL FICHERO MIENTRAS EL CÓDIGO DE CARACTER LEIDO SE
    //CORRESPONDA CON EL CARACTER ESPACIO EN BLANCO
    private void buscarPalabra() throws Exception {
        //lectura desde el fichero mientras el código de caracter leido
        //sea igual al espacio en blanco
        while ((codigo==COD_ESPACIO)||(codigo==RETURN)||(codigo==SALTO_LINEA)) {
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();
        }
    }
    
    //MÉTODO lectura LLEVA A CABO LA LECTURA DE UNA PALABRA DESDE EL FICHERO
    //REPRESENTADO POR EL OBJETO BufferedReader CORRESPONDIENTE
    public Palabra lectura() throws Exception {
        //DECLARACIONES
        //declaración objeto Palabra que reporesentara la palabra leida desde
        //el fichero
        Palabra palabra=new Palabra();
        
        //ACCIONES
        //lectura y almacenamiento de los caracteres de la palabra correspondientes
        //a los códigos de caracteres leidos desde el fichero
        while ((codigo!=FINAL_FICHERO)&&(codigo!=COD_ESPACIO)&&(codigo!=RETURN)
                &&(codigo!=SALTO_LINEA)) {
            //almacenar en el objeto Palabra palabra el caracter correspondiente
            //al código de caracter leido desde el fichero
            palabra.adicionCaracter((char) codigo);
            
            //lectura siguiente código de caracter desde el fichero
            codigo=fichero.read();           
        }
        
        palabra.adicionCaracter((char) COD_ESPACIO);
        
        //Esto meterá un salto de línea en la palabra para que se imprima el 
        //historial en distintas líneas, y no todo en una.
        if(codigo==SALTO_LINEA){
        palabra.adicionCaracter((char) 10);
                                //10 es el valor ascii de salto de linea
        }
        
        //Devolver el objeto Palabra
        return palabra;
    }
    
    //MÉTODO cerrarEnlaceFichero QUE LLEVA A CABO EL CIERRE DEL ENLACE BufferedReader
    //con el fichero 
    public void cerrarEnlaceFichero() throws Exception {
        fichero.close();
    }
      
}