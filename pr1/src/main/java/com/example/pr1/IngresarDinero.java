package com.example.pr1;

public class IngresarDinero extends Thread {
    private Cuenta2 cuenta;
    private int toAdd;

    public IngresarDinero(Cuenta2 cuenta, int toAdd) {
        this.cuenta = cuenta;
        this.toAdd = toAdd;
    }

    @Override
    public void run() {
        cuenta.deposit(toAdd);
    }
}
