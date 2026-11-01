package org.example;

public class SecurityAnalyzer {

    private final RateLimiter rateLimiter = new RateLimiter();

    public void verificarAnomalia(String dadosPacote, String ipOrigem) {
        // Validação de Rate Limiting
        boolean permitido = rateLimiter.verificarLimite(ipOrigem);

        if (!permitido) {
            AuditLogger.registrar("CRITICAL", ipOrigem, "Bloqueado por Rate Limit / Possível ataque DoS detectado!");
            return;
        }

        if (ipOrigem.equals("192.168.1.100")) {
            AuditLogger.registrar("WARNING", ipOrigem, "Tráfego originado de IP na lista negra.");
        } else {
            AuditLogger.registrar("INFO", ipOrigem, "Pacote validado e liberado com sucesso. Dados: " + dadosPacote);
        }
    }
}