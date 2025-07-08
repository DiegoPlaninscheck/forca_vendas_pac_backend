# 🔐 N3 Segurança - Backend

Este é o **backend da aplicação N3 Segurança**, desenvolvido com **Java 17**, **Spring Boot** e **Keycloak** para gerenciamento de autenticação e autorização via OAuth2/OpenID Connect.

## 📌 Visão Geral

Esta API RESTful permite operações de **CRUD** com segurança reforçada por meio de autenticação via [Keycloak]. As permissões de acesso são controladas por **roles** definidas no Keycloak, integradas ao Spring Security.

---

## ⚙️ Tecnologias Utilizadas

- [Java 17]
- [Spring Boot]
  - Spring Web
  - Spring Security
- [Keycloak]
- [Maven]
- [JPA/Hibernate]
- [H2 Database (para testes locais)]
- [Lombok]

---

## 🔐 Segurança com Keycloak

A segurança da aplicação é baseada em:

- **Autenticação**: feita via Keycloak usando o protocolo OAuth2.
- **Autorização**: controlada por roles definidas no Realm do Keycloak.
- Os endpoints da API são protegidos por anotações do Spring Security, como `@PreAuthorize`.

---

## 🔧 Configuração do Ambiente

### ✅ Pré-requisitos

- [Java 17]
- [Maven]
- Um servidor Keycloak em execução com:
  - Realm configurado (ex: `n3-seguranca`)
  - Client configurado (ex: `n3-backend`)
  - Roles criadas (ex: `admin`, `diego`, `gabriel`)
  - Usuários com suas respectivas roles

---

## 🚀 Executando o Projeto

1. **Clone o repositório**

```bash
git clone https://github.com/DiegoPlaninscheck/n3_seguranca_backend.git
cd n3_seguranca_backend

```

# 2. Configure o KeyCloak

Edite o arquivo application.properties ou application.yml com os dados do seu servidor Keycloak:
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8080/realms/n3-seguranca
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=http://localhost:8080/realms/n3-seguranca/protocol/openid-connect/certs
