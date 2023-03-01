package com.example.pr1.seq.e4;

public class Master implements Runnable {

    // Array de objetos SequentialPiEstimation que representan a las hebras que generan los puntos aleatorios
    private SequentialPiEstimation[] workers;
    // Valor de Pi calculado por la clase Master
    private double pi;
    // Número total de puntos generados por todas las hebras
    private double totalPoints = 0;
    // Número de puntos que caen dentro del círculo unitario generados por todas las hebras
    private double pointInCircle = 0;
    // Número de hebras utilizadas para generar los puntos aleatorios
    private int numThreads;

    public Master(SequentialPiEstimation[] workers, int numThreads) {
        // Inicializar los campos de la clase
        this.workers = workers;
        pi = 0;
        this.numThreads = numThreads;
    }

    // Método para calcular el número total de puntos generados por todas las hebras
    private synchronized void calculateTotalPoints() {
        for (int i = 0; i < numThreads; i++) {
            totalPoints += workers[i].getTotalPoints();
        }
    }

    // Método para calcular el número de puntos que caen dentro del círculo unitario generados por todas las hebras
    private synchronized void calculatePointsInCircle() {
        for (int i = 0; i < numThreads; i++) {
            pointInCircle += workers[i].getInsideCirclePoints();
        }
    }

    // Método para calcular el valor de Pi utilizando el número total de puntos generados y el número de puntos que caen dentro del círculo unitario
    private synchronized void calculatePi() {
        pi = 4 * (pointInCircle / totalPoints);
    }

    @Override
    public void run() {
        // Bucle infinito para calcular el valor de Pi de forma periódica
        while (true) {
            calculatePointsInCircle();
            calculateTotalPoints();
            calculatePi();
            double absoluteError = Math.abs(Math.PI - pi);
            System.out.println("- Estimated Pi value: " + pi + "\n" + "Absolute error with 'actual' Pi value: " + absoluteError + "\n" + "Generated " + totalPoints + " random points");
            // Pausa de 1 segundo para dar tiempo a las hebras a generar nuevos puntos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
