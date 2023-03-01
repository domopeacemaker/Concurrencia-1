package com.example.pr1;

public class Cuenta2 {
    private int amount;

    public Cuenta2() {
        amount = 9000;
    }

    public synchronized void withdraw(int toExtract) {
        while (toExtract > amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Manejo de excepción
            }
        }
        amount -= toExtract;
    }

    public synchronized void deposit(int toAdd) {
        amount += toAdd;
        // Avisamos a una de las hebras que esperan en withdraw() de que se ha hecho un ingreso
        // Se despierta una de las hebras que está en espera
        notify();
    }
}
