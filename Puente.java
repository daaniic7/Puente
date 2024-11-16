/*
 * Clase Puente
 */
public class Puente {
    private int cochesEnPuente = 0;
    private int pesoActual = 0;
    private static final int MAX_COCHES = 3;
    private static final int MAX_PESO = 5000;
/*
 *  Función sincronizada que determina si se permite o no el paso de los coches en base al 
    numero de coches que ya hay en el puente y en el peso que estos tienen ya que solo se permiten 3 coches 
    y un peso máximo de 5000Kg
 */
    public synchronized boolean PermitePaso(int pesoCoche) {
        if (cochesEnPuente < MAX_COCHES && pesoActual + pesoCoche <= MAX_PESO) {
            cochesEnPuente++;
            pesoActual += pesoCoche;
            return true;
        }
        return false;
    }
/*
 * Función sincronizada que se dedica a mostrar cuando los coches han cruzado el puente
 */
    public synchronized void finalizarPaso(int pesoCoche) {
        cochesEnPuente--;
        pesoActual -= pesoCoche;
        notifyAll();
    }
}
