package com.example.pr1;

public class MiHebraThread extends Thread {

    // Variable para almacenar el identificador de la hrbra
    private String id;

    // Constructor para recibir el identificador de la hebra
    public MiHebraThread(String id) {
        // Inicializamos var id
        this.id = id;
    }

    @Override
    // Método run con el contenido del código de la hebra
    public void run() {
        // Imprimimos el identificador
        System.out.println("Soy la hebrita " + id);
    }

    // Método main donde creamos y ejecutamos la hebra
    public static void main(String[] args) {
        // Creamos una instancia de la hebra con el id 1
        MiHebraThread h1 = new MiHebraThread("1");
        // La iniciamos
        h1.start();
    }
}
