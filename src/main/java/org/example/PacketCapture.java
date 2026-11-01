package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PacketCapture {

    private static final int PORTA_MONITORADA = 8080;

    public void iniciarEscuta() {
        System.out.println("[+] Iniciando Socket de escuta  na porta" + PORTA_MONITORADA);

        try (ServerSocket serverSocket = new ServerSocket(PORTA_MONITORADA)) {
            System.out.println("[+] Servidor escutando ativamente. Aguardando conexões de rede...");

            // Mantém o sniffer rodando para capturar pacotes/conexões de entrada
            while (true) {
                Socket clienteSocket = serverSocket.accept();
                String ipOrigem = clienteSocket.getInetAddress().getHostAddress();
                int portaOrigem = clienteSocket.getPort();

                String infoPacote = String.format("SRC_IP: %s -> DST_PORT: %d | Protocolo: TCP", ipOrigem, portaOrigem);
                System.out.println("\n[PACOTE CAPTURADO] " + infoPacote);

                // Envia para o módulo de segurança analisar
                SecurityAnalyzer analise = new SecurityAnalyzer();
                analise.verificarAnomalia(infoPacote, ipOrigem);

                // Envia uma resposta HTTP
                java.io.OutputStream output = clienteSocket.getOutputStream();
                String respostaHTTP = "HTTP/1.1 200 OK\r\n\r\nPacote capturado com sucesso pelo Packet Analyzer!";
                output.write(respostaHTTP.getBytes());
                output.flush();

                clienteSocket.close();
            }

        } catch (IOException e) {
            System.err.println("[ERRO] Falha ao abrir socket na rede: " + e.getMessage());
        }
    }

}