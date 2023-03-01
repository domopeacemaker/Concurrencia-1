package com.example.pr1.seq.e4;

public class Maestro implements Runnable {

    // Array de objetos SequentialPiEstimation que representan a las hebras que generan los puntos aleatorios
    private SequentialPiEstimation[] s;
    // Valor de Pi calculado por la clase Maestro
    private double pi;
    // Número total de puntos generados por todas las hebras
    private double totalPoints = 0;
    // Número de puntos que caen dentro del círculo unitario generados por todas las hebras
    private double point_in_circle = 0;
    // Número de hebras utilizadas para generar los puntos aleatorios
    private int nThreads;

    public Maestro(SequentialPiEstimation[] s, int nThreads) {
        // Inicializar los campos de la clase
        this.s = s;
        pi = 0;
        this.nThreads = nThreads;
    }

    // Método para calcular el número total de puntos generados por todas las hebras
    private synchronized void getTotalPoints() {
        for (int i = 0; i < nThreads; i++) {
            totalPoints += s[i].getTotalPoints();
        }
    }

    // Método para calcular el número de puntos que caen dentro del círculo unitario generados por todas las hebras
    private synchronized void getPointsInCircle() {
        for (int i = 0; i < nThreads; i++) {
            point_in_circle += s[i].getInsideCirclePoints();
        }
    }

    // Método para calcular el valor de Pi utilizando el número total de puntos generados y el número de puntos que caen dentro del círculo unitario
    private synchronized void calcularPi() {
        pi = 4 * (point_in_circle / totalPoints);
    }

    @Override
    public void run() {
        // Bucle infinito para calcular el valor de Pi de forma periódica
        while (true) {
            getPointsInCircle();
            getTotalPoints();
            calcularPi();
            double absoluteError = Math.abs(Math.PI - pi);
            System.out.println("- Estimated Pi value: " + pi + "\n" +
                    "  + Absolute error with \"actual\" Pi value: " + absoluteError + "\n" +
                    "  + Generated " + totalPoints + " random points");

            // Pausa de 1 segundo para dar tiempo a las hebras a generar nuevos puntos
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
