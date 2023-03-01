package com.example.pr1;

import java.util.concurrent.atomic.AtomicInteger;

// Clase que hereda de Thread y que se encarga de calcular los puntos dentro del círculo
class PiCalculationThread extends Thread {
    private int totalPoints;
    private AtomicInteger insideCirclePoints;

    // Constructor que recibe el número total de puntos y el contador de puntos dentro del círculo
    PiCalculationThread(int totalPoints, AtomicInteger insideCirclePoints) {
        this.totalPoints = totalPoints;
        this.insideCirclePoints = insideCirclePoints;
    }

    // Método que ejecuta la hebra y que se encarga de calcular los puntos dentro del círculo
    public void run() {
        double x, y;
        // Genera puntos aleatorios y cuenta el número de puntos dentro del círculo
        for(int i = 0; i < this.totalPoints; i++){
            x = Math.random();      // Genera un punto aleatorio
            y = Math.random();
            if (x*x + y*y <= 1) this.insideCirclePoints.incrementAndGet();
        }
    }
}

