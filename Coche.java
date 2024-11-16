import java.util.Random;
/*
 * Clase Coche 
 */
public class Coche extends Thread {
    private final int id;
    private final int peso;
    private final Puente puente;

    public Coche(int id, Puente puente) {
        this.id = id;
        this.peso = new Random().nextInt(1200) + 800; 
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            //Tiempo de llegada del coche entre 1 y 30 segundos
            int tiempoLlegada = random.nextInt(30) + 1; 
           //Tiempo que tarda el coche en pasar entre 10 y 50 segundos
            int tiempoCruce = random.nextInt(40) + 10; 


            //Se nos muestra este mensaje cuando llega al coche además de su ID
            System.out.println("Coche " + id + " llegará al puente en " + tiempoLlegada + " segundos.");
            Thread.sleep(tiempoLlegada * 1000);


            //Se nos muestra el coche además de su ID y el peso que tiene 
            System.out.println("Coche " + id + " (peso: " + peso + " kg) intentando cruzar el puente.");
            while (!puente.PermitePaso(peso)) {
                //Se nos muestra este mensaje cuando hay coches esperando para cruzar el puente 
                System.out.println("Coche " + id + " esperando para cruzar...");
                Thread.sleep(1000); 
            }
            //Mensaje cuando el coche ha cruzado el puente 
            System.out.println("Coche " + id + " está cruzando el puente.");
            Thread.sleep(tiempoCruce * 1000);

            //Mensaje cuando el coche ha cruzado el puente
            System.out.println("Coche " + id + " ha cruzado el puente.");
            puente.finalizarPaso(peso);

        } catch (InterruptedException e) {
            System.err.println("Coche " + id + " interrumpido.");
        }
    }
}

