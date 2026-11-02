# 🛡️ Java Network Packet Analyzer

A network security analysis system developed in Java 21. The project focuses on request monitoring, rate limiting, and security event auditing.

## Features

- **Rate Limiting:** Limits excessive requests based on IP addresses using a time-window algorithm.
- **Audit Logger:** Records security-related events for traceability.
- **Unit Testing:** Automated tests using JUnit 5.
- **Maven Integration:** Dependency management and build automation.

## Tech Stack

- Java 21
- Maven
- JUnit 5
- Git

## Project Structure

```text
packet-analyzer/
├── src/
│   ├── main/java/org/example/
│   │   ├── AuditLogger.java
│   │   ├── RateLimiter.java
│   │   └── SecurityAnalyzer.java
│   └── test/java/org/example/
│       └── RateLimiterTest.java
├── LICENSE
├── README.md
└── pom.xml
```

## Requirements

- JDK 21 or later
- Maven

## Getting Started

```bash
git clone https://github.com/rianrz/packet-analyzer.git
cd packet-analyzer
```

## Run Tests

```bash
mvn test
```

## Build

```bash
mvn clean package
```

## Security Components

### RateLimiter

Controls request frequency based on source IP addresses, helping mitigate abusive traffic patterns.

### AuditLogger

Provides security event logging for monitoring and traceability.

### SecurityAnalyzer

Organizes the project's security analysis logic.

## Project Goals

- Network security concepts
- Request throttling
- Security event auditing
- Java backend development
- Automated testing

## Future Improvements

- Additional rate-limiting strategies
- Configurable request thresholds
- More comprehensive tests
- Monitoring and metrics integration

## License

MIT License. See [LICENSE](LICENSE).

## Author

Developed by [rianrz](https://github.com/rianrz).
