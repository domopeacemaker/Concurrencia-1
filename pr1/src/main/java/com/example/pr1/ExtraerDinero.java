package com.example.pr1;

public class ExtraerDinero extends Thread {
    private Cuenta2 cuenta;
    private int toExtract;

    public ExtraerDinero(Cuenta2 cuenta, int toExtract) {
        this.cuenta = cuenta;
        this.toExtract = toExtract;
    }

    @Override
    public void run() {
        cuenta.withdraw(toExtract);
    }
}
