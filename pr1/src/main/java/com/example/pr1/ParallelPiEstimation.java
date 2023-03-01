package com.example.pr1;

import java.util.concurrent.atomic.AtomicInteger;

public class ParallelPiEstimation {

    private int totalPoints;
    private AtomicInteger insideCirclePoints;

    ParallelPiEstimation(int totalPoints) {
        this.totalPoints = totalPoints;
        this.insideCirclePoints = new AtomicInteger(0);
    }

    public int getInsideCirclePoints() {
        return insideCirclePoints.get();
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    // Método que aproxima el valor de PI utilizando el método de Monte Carlo y dos hebras
    public double runMonteCarlo() {
        if (this.totalPoints <= 0) {
            System.out.println("[ERROR] No random points to generate.");
            System.out.println("[ERROR] Please use setTotalPoints to set a number of points higher than 0.");
            return -1;
        }

        this.insideCirclePoints.set(0);

        // Divide el número total de puntos entre las dos hebras
        int pointsPerThread = this.totalPoints / 2;

        // Crea y ejecuta las dos hebras
        PiCalculationThread thread1 = new PiCalculationThread(pointsPerThread, this.insideCirclePoints);
        PiCalculationThread thread2 = new PiCalculationThread(pointsPerThread, this.insideCirclePoints);
        thread1.start();
        thread2.start();

        // Espera a que ambas hebras terminen
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Calcula y retorna el valor de PI
        return 4.0 * this.insideCirclePoints.get() / this.totalPoints;
    }
}
