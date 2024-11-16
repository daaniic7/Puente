public class CruzarPuente {
    public static void main(String[] args) {
        Puente puente = new Puente();
        int numeroDeCoches = 10;

        System.out.println("Iniciando simulación con " + numeroDeCoches + " coches.");
        for (int i = 1; i <= numeroDeCoches; i++) {
            new Coche(i, puente).start();
        }
    }
}
