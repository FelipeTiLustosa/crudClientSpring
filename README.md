# CRUD de Clientes com Spring Boot <img src="https://skillicons.dev/icons?i=spring,java" alt="Spring Boot and Java Icon" style="vertical-align: middle; height: 35px;"/>

## 1. Visão Geral

Este projeto é um sistema de gerenciamento de clientes desenvolvido com Spring Boot. Ele oferece uma API RESTful para realizar operações de CRUD (Criar, Ler, Atualizar e Excluir) em clientes, incluindo validações e tratamento de erros.

O sistema é ideal para quem deseja aprender ou implementar um backend eficiente utilizando boas práticas de desenvolvimento com Spring Boot.

## 2. Funcionalidades

| Funcionalidade                  | Descrição                                                                 |
|---------------------------------|---------------------------------------------------------------------------|
| **Listar Clientes**             | Recupera uma lista paginada de clientes.                                  |
| **Buscar Cliente por ID**       | Recupera os dados de um cliente específico pelo ID.                       |
| **Inserir Cliente**             | Adiciona um novo cliente com validações nos campos.                       |
| **Atualizar Cliente**           | Atualiza os dados de um cliente existente pelo ID.                        |
| **Excluir Cliente**             | Remove um cliente do sistema pelo ID.                                    |
| **Tratamento de Exceções**      | Garante respostas claras e informativas em caso de erros ou inconsistências.|

## 3. Tecnologias Utilizadas

- **Linguagem de Programação**: [Java](https://www.java.com/)
- **Framework Backend**: [Spring Boot](https://spring.io/projects/spring-boot)
- **Banco de Dados**: [H2 Database](https://www.h2database.com/) (pode ser substituído por MySQL ou outro BD relacional)
- **Gerenciamento de Dependências**: [Maven](https://maven.apache.org/)
- **IDE**: [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- **Gerenciamento de Versão**: [Git](https://git-scm.com/)

## 4. Estrutura de Pastas

Abaixo está a organização das pastas e classes do projeto:

```bash
crud-client/
│
├── src/
│   ├── main/
│   │   ├── java/com/devsuperior/crud/client/
│   │   │   ├── ClientApplication.java                      # Classe principal que inicia a aplicação
│   │   │   ├── controllers/
│   │   │   │   ├── ClientController.java                   # Controlador REST da API
│   │   │   │   ├── handlers/
│   │   │   │       ├── ControllerExceptionHandler.java     # Tratamento centralizado de exceções
│   │   │   ├── dto/
│   │   │   │   ├── ClientDTO.java                          # Objeto de transferência de dados (DTO)
│   │   │   │   ├── CustomError.java                        # DTO para erros globais
│   │   │   │   ├── FieldMessage.java                       # DTO para erros de campos específicos
│   │   │   │   ├── ValidationError.java                    # DTO para erros de validação
│   │   │   ├── entities/
│   │   │   │   ├── Client.java                             # Entidade representando a tabela no banco de dados
│   │   │   ├── exceptions/
│   │   │   │   ├── DatabaseException.java                  # Exceção para falha de integridade do banco
│   │   │   │   ├── ResourceNotFoundException.java          # Exceção para recurso não encontrado
│   │   │   ├── repositories/
│   │   │   │   ├── ClientRepository.java                   # Repositório para acesso ao banco de dados
│   │   │   ├── services/
│   │   │   │   ├── ClientServices.java                     # Regras de negócio para clientes
│   ├── resources/
│       ├── application.properties                          # Configurações do Spring Boot
│
└── README.md                                                # Documentação do projeto

```
## 5. Endpoints da API

Abaixo estão os endpoints disponíveis na API, juntamente com exemplos de requisições:

| **Método** | **Endpoint**       | **Descrição**                          | **Exemplo de Requisição**             |
|------------|--------------------|----------------------------------------|---------------------------------------|
| `GET`      | `/clients`         | Retorna uma lista paginada de clientes.| `GET /clients?page=0&size=10`         |
| `GET`      | `/clients/{id}`    | Busca um cliente pelo ID.              | `GET /clients/1`                      |
| `POST`     | `/clients`         | Cria um novo cliente.                  | `POST /clients`                       |
| `PUT`      | `/clients/{id}`    | Atualiza os dados de um cliente.       | `PUT /clients/1`                      |
| `DELETE`   | `/clients/{id}`    | Remove um cliente pelo ID.             | `DELETE /clients/1`                   |

## 6. Configuração e Execução

### 6.1. Pré-requisitos

Antes de executar o projeto, verifique se você possui os seguintes itens instalados:

- **Java**: JDK 11 ou superior.
- **Maven**: Gerenciador de dependências e automação de builds.

### 6.2. Instruções

#### 1. Clone o repositório:

```bash
git clone https://github.com/usuario/crud-client.git
cd crud-client
```
#### 2. Compile e execute o projeto:

Para iniciar o projeto, utilize o Maven com o seguinte comando:

```bash
mvn spring-boot:run
```
#### 3. Acesse o H2 Console (opcional, para visualizar o banco de dados):

O H2 Database oferece uma interface web para inspecionar e manipular dados diretamente. Siga os passos abaixo para acessá-lo:

- **URL**: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)  
- **JDBC URL**: `jdbc:h2:mem:testdb`  
- **User**: `sa`  
- **Password**: *(deixe em branco)*

Após acessar, insira as informações acima e clique em **Connect** para visualizar o banco de dados em memória.

---

#### 4. Teste os Endpoints:

Utilize ferramentas como **Postman** ou **Insomnia** para interagir com a API.

## 7. Tratamento de Erros

O projeto utiliza um tratamento centralizado de erros para garantir que respostas consistentes e amigáveis sejam fornecidas aos clientes da API. Abaixo estão os principais tipos de erros tratados e suas respectivas respostas:

| **Tipo de Erro**           | **Código HTTP** | **Descrição**                                              |
|----------------------------|-----------------|----------------------------------------------------------|
| **Recurso Não Encontrado** | `404`           | O cliente tentou acessar um recurso que não existe.       |
| **Erro de Validação**      | `422`           | Dados inválidos foram enviados na requisição.             |
| **Erro de Banco de Dados** | `400`           | Violação de integridade referencial ou erro relacionado ao banco de dados. |

Esses erros são tratados pela classe `ControllerExceptionHandler`, que mapeia exceções específicas para os códigos HTTP apropriados. Isso assegura que a API seja robusta e forneça feedback claro ao cliente sobre problemas encontrados em suas requisições.


