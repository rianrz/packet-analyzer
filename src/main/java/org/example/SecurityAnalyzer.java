package org.example;

public class SecurityAnalyzer {
    public void verificarAnomalia(String dadosPacote, String ipOrigem) {
        System.out.println("[SECURITY] Analisando regras de firewall e tráfego para o IP: " + ipOrigem);

        if (ipOrigem.equals("192.168.1.100")) {
            System.out.println("[ALERTA CRÍTICO] Tráfego originado de IP suspeito na lista negra: " + ipOrigem);
        } else {
            System.out.println("[OK] IP verificado. Tráfego liberado na política de acesso.");
        }
    }
}