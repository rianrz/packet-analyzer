package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditLogger {

    private static final String LOG_FILE = "security-audit.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static synchronized void registrar(String nivel, String ipOrigem, String mensagem) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String logEntry = String.format("[%s] [%s] IP: %s - %s%n", timestamp, nivel, ipOrigem, mensagem);

        // Exibe no console e grava no arquivo simultaneamente
        System.out.print(logEntry);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("[ERRO CRÍTICO] Falha ao gravar log de auditoria: " + e.getMessage());
        }
    }
}