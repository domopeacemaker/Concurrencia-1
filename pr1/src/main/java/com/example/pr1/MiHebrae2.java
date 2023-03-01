package com.example.pr1;

public class MiHebrae2 extends Thread {
    // Variable que almacena el identificador de la hebra
    private String id;

    // Constructor que recibe el identificador de la hebra
    public MiHebrae2(String id) {
        // Iniciamos la variable id
        this.id = id;
    }

    // Método run que contiene el código de la hebra
    @Override
    public void run() {
        // Imprimimos el identificador de la hebra por pantalla
        System.out.println("Soy la hebra " + id);
        // Imprimimos si la hebra está viva o no con isAlive()
        System.out.println("Estoy viva: " + isAlive());
    }

    // Método main donde se crea y ejecuta la hebra
    public static void main(String[] args) {
        // Creamos una instancia de la hebra con el id 1
        MiHebrae2 h1 = new MiHebrae2("1");
        // Inicia la hebra
        h1.start();
        // Hace que el programa principal espere a que la hebra acabe
        // o que pase 1000 milisec
        try {
            // La espera
            h1.join(1000);
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        // Imprimimos si la hebra está viva o no con isAlive()
        System.out.println("Estoy viva: " + h1.isAlive());
    }
}
