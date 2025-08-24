# Desafio Técnico de Microserviços

Este projeto é a solução para um desafio técnico focado na construção de uma arquitetura de microserviços utilizando o ecossistema Spring Boot e Spring Cloud.

---

## Descrição do Projeto

A aplicação consiste em um pequeno sistema de gestão de pedidos com dois microserviços independentes: um **Microserviço de Catálogo de Produtos** e um **Microserviço de Simulação de Pedidos**. A arquitetura foi construída para demonstrar a comunicação entre serviços, o uso de um **API Gateway** como ponto de entrada e um **Service Discovery** para registro e localização dinâmica dos serviços.

O sistema também implementa uma camada de segurança simples no Gateway para proteger os endpoints da API.

---

## Arquitetura da Solução

O projeto é estruturado como um monorepo, contendo 4 serviços distintos, cada um com sua própria responsabilidade:

- **`service-discovery`**: Servidor **Eureka** responsável por registrar e fornecer a localização de cada microserviço. Ele atua como uma "lista telefônica" central da arquitetura.
- **`microservice-produtos`**: Contém a lógica de negócio para gestão de produtos. Possui persistência de dados em um banco de dados em memória **H2 Database**.
- **`microservice-pedidos`**: Atua como um simulador de pedidos. Ele se comunica com o Microserviço de Produtos para obter a lista de itens disponíveis e simular um pedido. **Não possui persistência**.
- **`api-gateway`**: O único ponto de entrada da aplicação. Ele é responsável por rotear as requisições externas para o serviço correto e aplicar a validação de segurança via token de acesso.

---

## Requisitos do Desafio

- [x] **Dois microserviços independentes** (`produtos` e `pedidos`).
- [x] Utilização de **Spring Boot** e **Spring Cloud**.
- [x] **Service Discovery** com Spring Cloud Eureka.
- [x] **API Gateway** com Spring Cloud Gateway.
- [x] **Persistência de dados** para o serviço de produtos via H2 Database.
- [x] **Segurança** com autenticação via `Bearer Token` no API Gateway.
- [x] Endpoints acessíveis via **Gateway**: `/produtos` e `/pedidos`.

---

## Tecnologias Utilizadas

- **Linguagem:** Java 17
- **Frameworks:** Spring Boot 3.2.10, Spring Cloud 2023.0.3
- **Componentes Spring Cloud:** Eureka Server, Eureka Discovery Client, Spring Cloud Gateway
- **Persistência:** Spring Data JPA, H2 Database (em memória)
- **Construção:** Maven
- **Controle de Versão:** Git

---

## Como Executar o Projeto

Para executar a aplicação, siga a ordem de inicialização abaixo. Você precisará de uma instância do Maven e de uma IDE (como IntelliJ ou VS Code) com suporte a projetos Spring Boot.

1.  **Inicie o Serviço de Descoberta (Eureka Server):**
    Navegue até a pasta `service-discovery` e execute a classe `Application.java` ou use o comando Maven:
    ```bash
    mvn spring-boot:run
    ```
2.  **Inicie o Microserviço de Produtos:**
    Navegue até a pasta `microservice-produtos` e execute a classe `Application.java` ou use:
    ```bash
    mvn spring-boot:run
    ```
3.  **Inicie o Microserviço de Pedidos:**
    Navegue até a pasta `microservice-pedidos` e execute a classe `Application.java` ou use:
    ```bash
    mvn spring-boot:run
    ```
4.  **Inicie o API Gateway:**
    Navegue até a pasta `api-gateway` e execute a classe `Application.java` ou use:
    ```bash
    mvn spring-boot:run
    ```

---

## Testes da API

Use uma ferramenta como Postman ou Insomnia para testar os endpoints. Todos os endpoints precisam do cabeçalho `Authorization: Bearer 12345`.

- **Listar Produtos (Comunicação Direta)**
  - `GET http://localhost:8100/produtos`
  - Headers: `Authorization: Bearer 12345`

- **Listar Produtos (Via Gateway)**
  - `GET http://localhost:8701/produtos`
  - Headers: `Authorization: Bearer 12345`

- **Simular Pedido (Via Gateway)**
  - `POST http://localhost:8701/pedidos/simular`
  - Headers: `Authorization: Bearer 12345`
  - Body (JSON):
    ```json
    [
      {"produtoId": 1, "quantidade": 2}
    ]
    ```
