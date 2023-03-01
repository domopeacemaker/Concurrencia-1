package com.example.pr1.seq.e4;

import java.util.Random;

public class SequentialPiEstimation implements Runnable{

    private int totalPoints=0;
    private int insideCirclePoints=0;
    private int id;

    SequentialPiEstimation() {
        id=new Random().nextInt(10);
    }

    public int getInsideCirclePoints() {
        return insideCirclePoints;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints){
        this.totalPoints = totalPoints;
    }
    public void runMonteCarlo(){
        if (this.totalPoints <= 0) {
            System.out.println("[ERROR] No random points to generate.");
            System.out.println("[ERROR] Please use setTotalPoints to set a number of points higher than 0.");
            // return -1;
        }

        this.insideCirclePoints = 0;
        double x, y;
        while(true){
            x = Math.random();      // Generate a random point
            y = Math.random();
            if (x*x + y*y <= 1) {
                this.insideCirclePoints++;
            }
            this.totalPoints++;
        }
    }

    @Override
    public void run() {
        System.out.println("Se ha creado la hebra: "+id);

        runMonteCarlo();

    }
}
