package com.example.pr1;

public class MiHebrae2b extends Thread {
    // Variable que almacena el id de la hebra
    private String id;

    // Constructor que recibe el id de la hebra
    public MiHebrae2b(String id) {
        // Iniciamos la variable id
        this.id = id;
    }

    // Método run que contiene el código de la hebra
    @Override
    public void run() {
        // El bucle que se ejecuta 5 veces
        for (int i = 0; i < 5; i++) {
            // Imprimimos el identificador de la hebra
            System.out.println("Soy la hebra " + id);
            // Hacemos que la hebra se duerma por 1000 milisec
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                // Manejo de excepción
            }
            // Imprimimos si la hebra está viva o no con isAlive()
            System.out.println("Estoy viva: " + isAlive());
        }
    }

    // Método main donde se crea y ejecuta la hebra
    public static void main(String[] args) {
        // Creamos una instancia de la hebra con el id 1
        MiHebrae2b h1 = new MiHebrae2b("1");
        // La iniciamos
        h1.start();
        // HAcemos que el programa original espere a que la hebra acabe
        // o pasen los 1000 milisec
        try {
            h1.join();
        } catch (InterruptedException e) {
            // Manejo de excepción
        }
        // Imprimimos si la hebra está viva o no con isAlive()
        System.out.println("Estoy viva: " + h1.isAlive());
    }
}
