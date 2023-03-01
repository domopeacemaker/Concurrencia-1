package com.example.pr1;

public class MiHebraRunnable implements Runnable {
    // La variable que almacena el identificador de la hebra
    private String id;

    // Constructor que recibe el identificador de la hebra
    public MiHebraRunnable(String id) {
        // Iniciamos la variable id
        this.id = id;
    }

    // Método run que contiene el cóidigo lioko de la regla
    @Override
    public void run() {
        // Imprimimos el identificador de la hebra
        System.out.println("Soy la hebrazo " + id);
    }

    // Método main donde creamos y ejecutamos la hebra
    public static void main(String[] args) {
        // Creamos una instancia de la hebra con el id 1
        MiHebraRunnable h1 = new MiHebraRunnable("1");
        // Creamos una instancia de Thread y le pasamos el parámetro de la instancia MiHebraETC
        Thread t1 = new Thread(h1);
        // Iniciamos la hebra
        t1.start();
    }
}
