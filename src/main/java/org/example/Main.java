package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("[INFO] Iniciando Analisador de Tráfego de Rede...");
        System.out.println("[INFO] Modo de operacao: Console CLI / Monitoramento de Seguranca");

        // Simulando a inicializacao do modulo de captura
        PacketCapture capture = new PacketCapture();
        capture.iniciarEscuta();
    }
}