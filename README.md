# Codechella 🎶

**Codechella** é um projeto desenvolvido para explorar o uso de **Spring WebFlux** e aplicações reativas em um contexto de gerenciamento de eventos. O sistema oferece funcionalidades para criação, atualização, listagem e exclusão de eventos, além de buscar eventos por tipo e traduzir descrições para diferentes idiomas.

---

## Funcionalidades ✨

- **CRUD de Eventos:** Gerencie eventos com atributos como tipo, nome, descrição e data.
- **Busca por Tipo:** Filtre eventos por tipo com suporte a streaming reativo.
- **Tradução de Descrições:** Integração com a API MyMemory para tradução de descrições em diferentes idiomas.
- **Atualizações em Tempo Real:** Inscreva-se para receber atualizações sobre novos eventos.
- **Validação de Dados:** Uso do `spring-boot-starter-validation` para validação robusta.
- **Migração de Banco:** Integração com Flyway para gerenciar alterações no banco de dados.

---

## Tecnologias Utilizadas 🚀

- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
- ![Spring WebFlux](https://img.shields.io/badge/Spring%20WebFlux-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
- ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
- ![Flyway](https://img.shields.io/badge/Flyway-CC0200?style=for-the-badge&logo=flyway&logoColor=white)
- ![Lombok](https://img.shields.io/badge/Lombok-3F4C75?style=for-the-badge&logo=lombok&logoColor=white)
- ![Reactor](https://img.shields.io/badge/Project%20Reactor-008ECD?style=for-the-badge&logo=reactivex&logoColor=white)
- ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
- ![WebClient](https://img.shields.io/badge/WebClient-6DB33F?style=for-the-badge&logo=spring&logoColor=white)

---

## Como Executar o Projeto ▶️

1. Clone o repositório:  
   git clone https://github.com/seu-usuario/codechella.git

2. Configure as variáveis de ambiente no arquivo `.env`:
   - POSTGRES_USERNAME
   - POSTGRES_PASSWORD

3. Execute o Flyway para migrar o banco de dados:  
   mvn flyway:migrate

4. Inicie a aplicação:  
   mvn spring-boot:run

5. Acesse a API em:  
   http://localhost:8080/events

---

## Estrutura do Projeto 📂

- **controller**: Camada responsável por gerenciar as requisições HTTP.
- **service**: Camada de regras de negócio e manipulação dos dados.
- **repository**: Interface de comunicação com o banco de dados.
- **entity**: Representação das entidades do banco de dados.
- **request/response**: Estruturas para entrada e saída de dados da API.
- **exception**: Tratamento global de erros e exceções personalizadas.
- **translation**: Integração com API para tradução de descrições.

---

## Exemplos de Requisições 🛠️

### Criar um Evento
**POST** /events  
Body:  
{
"type": "SHOW",  
"name": "Nome do Evento",  
"description": "Descrição do evento"  
}

### Buscar Todos os Eventos
**GET** /events

### Buscar Evento por Tipo (com Streaming)
**GET** /events/type/{type}

### Atualizar um Evento
**PUT** /events  
Body:  
{
"id": 1,  
"name": "Evento Atualizado",  
"description": "Nova descrição"  
}

### Traduzir Descrição de um Evento
**GET** /events/{id}/translate/{language}  
Exemplo: `/events/1/translate/en`

---

## Licença 📜

Este projeto é licenciado sob os termos da **MIT License**.

