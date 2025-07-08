# 🔐 N3 Segurança - Backend

Este é o **backend da aplicação N3 Segurança**, desenvolvido com **Java 17**, **Spring Boot** e **Keycloak**, responsável por fornecer uma API REST segura com autenticação e autorização baseadas em roles.

---

## 📌 Visão Geral

A aplicação realiza operações de **CRUD** com proteção via [Keycloak](https://www.keycloak.org/), utilizando autenticação OAuth2 e validação de permissões com base em roles definidas no Keycloak.

---

## ⚙️ Tecnologias Utilizadas

- [Java 17](https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Keycloak](https://www.keycloak.org/)
- [Maven](https://maven.apache.org/)
- [JPA / Hibernate](https://hibernate.org/)
- [H2 Database (ambiente local)](https://www.h2database.com/)
- [Lombok](https://projectlombok.org/)

---

## 🔐 Configuração do Keycloak com Docker

### ✅ Pré-requisitos

- [Docker](https://www.docker.com/) e [Docker Compose](https://docs.docker.com/compose/) instalados
- Porta `8080` disponível

---

### 1. Criar o arquivo `docker-compose.yml`

```yaml
version: "3.8"

services:
  keycloak:
    image: quay.io/keycloak/keycloak:24.0.3
    container_name: keycloak
    ports:
      - "8080:8080"
    environment:
      - KEYCLOAK_ADMIN=admin
      - KEYCLOAK_ADMIN_PASSWORD=admin
    command: start-dev
```

---

### 2. Configurar o KeyCloack

No terminal execute:
`docker-compose up -d`

Acesse: http://localhost:8080

---

### 3. Configurando o Spring Boot

No application.yml:

```
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8080/realms/n3-seguranca
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8080/realms/n3-seguranca/protocol/openid-connect/certs

```

---

### Executando a Aplicação

1. **Clone o Repositório:**

```
  git clone https://github.com/DiegoPlaninscheck/n3_seguranca_backend.git
  cd n3_seguranca_backend

```

2.**Compile e execute**:
`mvn spring-boot:run`

A aplicação estará disponivel em: http://locahost:8081
