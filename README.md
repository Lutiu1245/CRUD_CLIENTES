# CRUD de Clientes - Projeto Spring Boot

Bem-vindo ao repositório do CRUD de Clientes! Este projeto foi desenvolvido utilizando Spring Boot, Hibernate, Jakarta Validation, e o banco de dados H2. Durante a implementação, pratiquei os conceitos essenciais de uma API REST, incluindo a criação de DTOs, controllers, services, exceptions, entidades e repositories. Adotei também padrões de commits para manter um histórico claro e compreensível do desenvolvimento.
Conteúdo do Projeto

O projeto CRUD de Clientes abrangeu os seguintes tópicos:

    Configuração Inicial:
        Setup inicial do projeto Spring Boot.
        Integração do banco de dados H2 para facilitar o desenvolvimento.

    Entidades e Repositories:
        Definição de entidades representando a estrutura do banco de dados.
        Utilização de repositories para operações de CRUD.

    DTOs (Data Transfer Objects):
        Implementação de DTOs para transferir dados entre a aplicação e a API, mantendo uma separação clara entre as camadas.

    Controllers:
        Criação de controllers para lidar com requisições HTTP.
        Implementação de métodos para criar, recuperar, atualizar e excluir clientes.

    Services:
        Desenvolvimento de services para encapsular a lógica de negócios da aplicação.
        Manipulação de exceções específicas e validações utilizando Jakarta Validation.

    Exceptions:
        Tratamento adequado de exceções para fornecer respostas claras em caso de erros.

Estrutura do Diretório

```
/crud-clientes
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com
|   |   |   |   |-- exemple
|   |   |   |   |   |-- CRUD_CLIENTS
|   |   |   |   |   |   |-- DTO
|   |   |   |   |   |   |   |-- ClientDTO.java
|   |   |   |   |   |   |   |-- CustomError.java
|   |   |   |   |   |   |   |-- FieldMessageDTO.java
|   |   |   |   |   |   |   |-- ValidationErrorDTO.java
|   |   |   |   |   |   |-- controllers
|   |   |   |   |   |   |   |-- handler
|   |   |   |   |   |   |   |   |-- ControllerExceptionHandler.java
|   |   |   |   |   |   |   |-- ClientController.java
|   |   |   |   |   |   |-- entity
|   |   |   |   |   |   |   |-- Client.java
|   |   |   |   |   |   |-- exception
|   |   |   |   |   |   |   |-- DatabaseException.java
|   |   |   |   |   |   |   |-- ResourceNotFoundExeception.java
|   |   |   |   |   |   |-- repositories
|   |   |   |   |   |   |   |-- ClientRepository.java
|   |   |   |   |   |   |-- services 
|   |   |   |   |   |   |   |-- ClientService.java
|-- README.md
```
## Padrões de Commits

Este projeto adota padrões de commits para manter um histórico claro e compreensível do desenvolvimento. Aqui estão alguns dos padrões utilizados:

    feat: para novas funcionalidades.
    fix: para correções de bugs.
    chore: para tarefas de manutenção.
    docs: para atualizações na documentação.

Exemplo de commit:

```
feat: Adiciona endpoint para criar cliente
```
## Como Contribuir

Sinta-se à vontade para explorar o código, sugerir melhorias, ou compartilhar insights sobre o desenvolvimento de APIs REST. Contribuições são sempre bem-vindas!
