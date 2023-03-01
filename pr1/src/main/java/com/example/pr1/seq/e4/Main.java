package com.example.pr1.seq.e4;

public class Main {

    public static void main(String[] args) {
        // Crear un array de objetos SequentialPiEstimation para representar a las hebras que generan los puntos aleatorios
        int numThreads = 10;
        SequentialPiEstimation[] workers = new SequentialPiEstimation[numThreads];
        for (int i = 0; i < numThreads; i++) {
            workers[i] = new SequentialPiEstimation();
        }

        // Crear y arrancar las hebras que generan los puntos aleatorios
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(workers[i]);
            threads[i].start();
        }

        // Crear y arrancar la hebra que se encarga de calcular el valor de Pi a partir de los puntos generados por las hebras anteriores
        Master m1 = new Master(workers, numThreads);
        Thread master = new
                Thread(m1);
        master.start();
    }
}
