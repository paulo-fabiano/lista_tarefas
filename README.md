# API Rest - Lista de Tarefas

O repositório contém uma API Rest para o gerenciamento de tarefas (CRUD).

## Tecnologias Utilizadas

- Spring Boot
- Spring Data JPA com Hibernate
- Banco H2
- Lombok

## Estrutura

É basicamente a primeira vez que estou utilizando um Handler global para o tratamento de erros
do tipo "TarefaNaoEncontradaException", que é basicamente quando o Id passado na requisição não existe no 
banco de dados.

## Como executar o projeto

Primeiramente, antes de executar qualquer um dos próximos passos é importante se você possui a JDK instalada na sua máquina.
Com a JDK(Java Development Kit) você irá conseguir compilar e executar o código.

1. Clone o repositório:
   ```bash
   git clone https://github.com/paulo-fabiano/java-lista_telefonica.git
   ```
2. Acesse o diretório do projeto:
   ```bash
   cd java-lista_telefonica
   ```
3. Compile e execute o projeto usando Maven:
   ```bash
   mvn spring-boot:run
   ```

## 

## Endpoints da API

| Método | Endpoint                     | Descrição               |
|--------|------------------------------|-------------------------|
| `POST` | `/api/tarefa`                | Criar uma nova tarefa   |
| `GET`  | `/api/tarefas`               | Buscar todas as tarefas |
| `GET`  | `/api/tarefa/{id}`           | Buscar tarefa por ID    |
| `PUT`  | `/api/tarefa/atualizar/{id}` | Atualizar uma tarefa    |
| `DELETE` | `/api/tarefa/deletar/{id}`   | Deletar uma tarefa      |

## Testando a API

1. Criando uma tarefa:

```bash
    curl -X POST http://localhost:8081/api/tarefa 
    -H "Content-Type: application/json" 
    -d '{ 
        "nome" : "Criar API.", 
        "prioridade" : 10, 
        "realizado" : true 
        }'
```
2. Listando todas as tarefas:

```bash
    curl http://localhost:8081/api/tarefas
```

3. Listando uma tarefa pelo ID. Lembre-se de inserir o ID como parâmetro na URL.

```bash
    curl http://localhost:8081/api/tarefa/1
```

4. Atualizando uma tarefa:

```bash
    curl -X PUT http://localhost:8081/api/tarefa/1 
    -H "Content-Type:application/json" 
    -d '{"prioridade" : "5"}'
```
5. Deletar uma tarefa:

```bash
    curl  -X DELETE http://localhost:8081/api/tarefa/deletar/2
```

## Tratamento de erros com o GlobalExceptionHandler

Quando a API lançar uma exceção do tipo `TarefaNaoEncontradaException` será retornado uma resposta personalizada:

Você verá que a saída é:

```declarative
    {
        "code":"CODE 1001",
        "erro_message":"Tarefa não encontrada.",
        "status_code":404,
        "localDateTime":"2025-03-05T21:50:05.556628388"
    }
```

## ToDo - Melhorias Futuras

- Implemantação de DTOs.
- Adicionar mais validações.
- Criar um Pipeline de CI.