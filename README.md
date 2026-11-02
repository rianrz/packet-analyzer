# 🛡️ Java Network Packet Analyzer

Um analisador de pacotes de rede e sistema de segurança desenvolvido em Java 21. O projeto foca em monitoramento em tempo real, mitigação de ataques (Rate Limiting) e persistência de auditoria de segurança, seguindo boas práticas de arquitetura e cobertura de testes.

## 🚀 Funcionalidades

- **Rate Limiting (Proteção contra DoS/Brute-force):** Algoritmo de janela de tempo para limitar e bloquear requisições excessivas por endereço IP.
- **Audit Logger (Registro de Segurança):** Sistema de log estruturado para persistência e rastreabilidade de eventos críticos de rede.
- **Validação com Testes Unitários:** Suíte de testes automatizados criada com JUnit 5 para validação da lógica de segurança.
- **Configuração via Maven:** Gerenciamento centralizado de dependências e automação de build.

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Gerenciador de Dependências:** Maven
- **Testes Unitários:** JUnit 5
- **Controle de Versão:** Git

## 📂 Estrutura do Projeto

```text
packet-analyzer/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           ├── AuditLogger.java
│   │           ├── RateLimiter.java
│   │           └── SecurityAnalyzer.java
│   └── test/
│       └── java/
│           └── org/example/
│               └── RateLimiterTest.java
├── .gitignore
├── LICENSE (MIT)
└── pom.xml
