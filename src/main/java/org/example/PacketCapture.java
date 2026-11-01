package org.example;

public class PacketCapture {
    public void iniciarEscuta() {
        System.out.println("[+] Escutando interface de rede padrao...");
        // Aqui entra a logica de sockets ou captura de pacotes

        // Exemplo simulado de um pacote detectado para testar a logica
        String pacoteExemplo = "SRC: 192.168.1.15 -> DST: 10.0.0.4 | Porta: 80 | Protocolo: TCP";

        SecurityAnalyzer analise = new SecurityAnalyzer();
        analise.verificarAnomalia(pacoteExemplo);
    }
}