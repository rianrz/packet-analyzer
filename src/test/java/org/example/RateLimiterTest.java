package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    private RateLimiter rateLimiter;

    @BeforeEach
    void setUp() {
        // Inicializa uma nova instância antes de cada teste
        rateLimiter = new RateLimiter();
    }

    @Test
    void devePermitirRequisicoesDentroDoLimite() {
        String ipTeste = "192.168.1.50";

        // Como o limite configurado é de 5 requisições por janela, as primeiras 5 devem passar
        for (int i = 1; i <= 5; i++) {
            boolean permitido = rateLimiter.verificarLimite(ipTeste);
            assertTrue(permitido, "A requisição " + i + " deveria ser permitida.");
        }
    }

    @Test
    void deveBloquearRequisicoesAlemDoLimite() {
        String ipAtacante = "10.0.0.99";

        // Esgota o limite de 5 requisições
        for (int i = 0; i < 5; i++) {
            rateLimiter.verificarLimite(ipAtacante);
        }

        // A 6ª requisição deve ser bloqueada (retornar false)
        boolean sextaRequisicao = rateLimiter.verificarLimite(ipAtacante);
        assertFalse(sextaRequisicao, "A 6ª requisição deveria ser bloqueada pelo Rate Limiter!");
    }
}