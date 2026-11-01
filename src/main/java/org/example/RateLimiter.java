package org.example;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {

    // Guarda o histórico de acessos por IP: <IP, Momento do último acesso>
    private final Map<String, RequestRecord> ipRequestMap = new HashMap<>();

    // Configurações de limite
    private static final int LIMITE_MAXIMO_REQUISICOES = 5; // Máximo de conexões permitidas na janela
    private static final long JANELA_TEMPO_SEGUNDOS = 10;   // Janela de tempo em segundos

    public synchronized boolean verificarLimite(String ipOrigem) {
        long agora = Instant.now().getEpochSecond();

        ipRequestMap.putIfAbsent(ipOrigem, new RequestRecord(agora, 0));
        RequestRecord record = ipRequestMap.get(ipOrigem);

        // Se a janela de tempo expirou, reseta o contador
        if (agora - record.primeiroAcessoTime > JANELA_TEMPO_SEGUNDOS) {
            record.primeiroAcessoTime = agora;
            record.contador = 1;
            return true; // Permitido
        }

        // Incrementa o contador dentro da janela atual
        record.contador++;

        // Se ultrapassou o limite, bloqueia
        if (record.contador > LIMITE_MAXIMO_REQUISICOES) {
            return false; // Bloqueado por Rate Limit
        }

        return true; // Permitido
    }

    private static class RequestRecord {
        long primeiroAcessoTime;
        int contador;

        public RequestRecord(long primeiroAcessoTime, int contador) {
            this.primeiroAcessoTime = primeiroAcessoTime;
            this.contador = contador;
        }
    }
}