package org.example;

public class SecurityAnalyzer {
    public void verificarAnomalia(String dadosPacote) {
        System.out.println("[SECURITY] Analisando pacote: " + dadosPacote);

        // Regra simples de seguranca (Simulacao de alerta)
        if (dadosPacote.contains("Porta: 80")) {
            System.out.println("[ALERTA] Trafego HTTP nao criptografado detectado!");
        } else {
            System.out.println("[OK] Pacote dentro dos padroes de seguranca.");
        }
    }
}