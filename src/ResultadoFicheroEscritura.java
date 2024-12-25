//proyecto creado por Gaizka Medina Gordo
package practica__final2023;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Date;

public class ResultadoFicheroEscritura {

    //DECLARACIÓN ATRIBUTOS
    //declaración atributo de objeto BufferedWriter que posibilite el enlace
    //con el fichero de texto a nivel de escritura
    private BufferedWriter fichero = null;

    //MÉTODOS
    //MÉTODO CONSTRUCTOR     
    public ResultadoFicheroEscritura(String nombreFichero) throws Exception {
        //establecimiento enlace BufferedWriter con fichero de texto identificado
        //a través del parámetro String nombreFichero dado
        fichero = new BufferedWriter(new FileWriter(nombreFichero, true));
    }
    //MÉTODOS FUNCIONALES

    //MÉTODO escritura QUE LLEVA A CABO LA ESCRITURA DEL RESULTADO EN EL
    //FICHERO DE TEXTO REPRESENTADO POR EL OBJETO BufferedWriter CORRESPONDIENTE 
    public void escritura(Date fecha, Palabra nombre, Palabra palabraObjetivo,Palabra[] palabrasJugadas) throws Exception {
        
        //se guardan  la fecha,hora,nombre y número de puntos acumulados en el fichero 
        //"historial" para poder visualizarlas
        String resultado=fecha + ", " + nombre + ", " + palabraObjetivo+",";
            
        for(int i=0;i<palabrasJugadas.length;i++){
            
            resultado=resultado+palabrasJugadas[i]+" ";
        }
        //añadimos un salto de línea para la próxima escritura
        resultado=resultado+".\n";
        
        fichero.write(resultado);        
    }
  
    //MÉTODO cerrarEnlaceFichero QUE LLEVA A CABO EL CIERRE DEL ENLACE BufferedWriter
    //con el fichero 
    public void cerrarEnlaceFichero() throws Exception {
        fichero.close();
    }

}