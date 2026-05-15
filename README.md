# kaban-java
# Kanban API

API REST desenvolvida com Spring Boot para gerenciamento de demandas em um sistema Kanban.

## Sobre o projeto

Este projeto foi criado para gerenciar demandas de um quadro Kanban, permitindo cadastrar, consultar, atualizar e remover demandas por meio de endpoints REST. A aplicação segue uma estrutura em camadas com controller, service e repository, padrão comum em aplicações Spring Boot [1][2].

Além do CRUD básico, a API também possui uma atualização completa de demanda com vínculo de responsável, além de uma rota específica para atualização parcial de status com `PATCH`, prática comum em APIs REST quando apenas parte do recurso é alterada [3][4].

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Jakarta Transactions
- Banco de dados relacional
- Maven

## Estrutura do projeto

A organização do projeto segue a separação por responsabilidade, o que facilita manutenção, testes e evolução da aplicação [1][2].

```bash
src/main/java/br/com/kanbanmateus/kanban_api
├── controller
├── dto
├── entity
├── repository
└── service
```

## Funcionalidades

- Listar todas as demandas
- Buscar demanda por ID
- Inserir nova demanda
- Atualizar apenas o status de uma demanda
- Atualizar todos os dados da demanda
- Vincular um responsável à demanda no processo de atualização
- Deletar demanda por ID

## Endpoints

Assumindo a aplicação rodando localmente na porta 8080.

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/demandas` | Lista todas as demandas |
| GET | `/demandas/{id}` | Busca uma demanda por ID |
| POST | `/demandas` | Cria uma nova demanda |
| PATCH | `/demandas/{id}/status` | Atualiza apenas o status da demanda |
| PUT | `/demandas/{id}` | Atualiza os dados da demanda e vincula responsável |
| DELETE | `/demandas/{id}` | Remove uma demanda |

As anotações `@GetMapping`, `@PostMapping`, `@PutMapping`, `@PatchMapping` e `@DeleteMapping` são formas padrão do Spring de mapear verbos HTTP para métodos do controller [3][4].

## Exemplos de requisição

### Criar demanda

**POST** `http://localhost:8080/demandas`

```json
{
  "titulo": "Nova demanda",
  "tipo": "Melhoria",
  "descricao": "Criar tela kanban",
  "status": "ABERTO",
  "prioridade": "ALTA"
}
```

### Atualizar status

**PATCH** `http://localhost:8080/demandas/1/status`

```json
{
  "status": "EM_ANDAMENTO"
}
```

### Atualização completa com responsável

**PUT** `http://localhost:8080/demandas/1`

```json
{
  "titulo": "Corrigir dashboard",
  "tipo": "Melhoria",
  "descricao": "Ajustar layout",
  "dataInicio": "2026-05-15",
  "dataFimP": "2026-05-20",
  "dataFimR": null,
  "prioridade": "ALTA",
  "status": "EM_ANDAMENTO",
  "segmento": "Frontend",
  "segmentoDetalhe": "Kanban",
  "dataCriacao": "2026-05-10",
  "criadorDemanda": "Mateus",
  "idResponsavel": 1
}
```

Para que o `PUT` funcione corretamente, o `idResponsavel` enviado no corpo da requisição precisa existir no banco; caso contrário, a aplicação lança exceção de responsável não encontrado [5][6].

## Como executar o projeto

### Pré-requisitos

- Java instalado
- Maven instalado
- Banco de dados configurado

### Passos

1. Clone o repositório.
2. Abra o projeto na IDE de sua preferência.
3. Configure as credenciais do banco no arquivo de propriedades da aplicação.
4. Execute a aplicação Spring Boot.
5. A API ficará disponível em `http://localhost:8080`.

## Testes no Bruno

Com a aplicação rodando, as requisições podem ser testadas no Bruno criando uma collection, adicionando requests HTTP e informando método, URL e body JSON quando necessário. O Bruno suporta requisições REST com body em JSON e headers configuráveis para testar APIs locais [7][8][9].

## Observações

- O endpoint `PATCH` é indicado para atualização parcial, como no caso da troca de status [10][11].
- O endpoint `PUT` é mais adequado quando a intenção é atualizar a representação completa do recurso [12][13].
- O uso de DTOs ajuda a separar os dados recebidos pela API das entidades persistidas no banco, prática comum em projetos Spring Boot [14][15].

## Melhorias futuras

- Tratamento de exceções com respostas HTTP mais adequadas, como `404 Not Found` em vez de `500 Internal Server Error` para recursos não encontrados [6][16].
- Validação de campos com Bean Validation.
- Documentação automática com Swagger/OpenAPI.
- Separação entre DTOs de request e response.
- Testes automatizados.
