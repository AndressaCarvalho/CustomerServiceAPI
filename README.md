<h1 align="center">
    Consumer Service API
</h1>

## Descrição do projeto
O projeto consiste em uma API para solicitações de clientes, desenvolvida em Spring Boot, com a linguagem de programação Java. Tal aplicação objetiva prover um meio de abrir chamados para o atendimento de clientes, através de rotas que manipulam os dados envolvidos.
**Nota:** A API foi desenvolvida utilizando o [PostgreSQL]([https://www.microsoft.com/pt-br/download/details.aspx?id=101064](https://www.postgresql.org/)) para o gerenciamento do banco de dados local.<br/>
<h3 align="center">
    <a href="https://spring.io/projects/spring-boot">🔗 Spring Boot</a>
</h3>
<p align="center">🚀 framework para criação de aplicações Spring.</p>
<br/>
<h4>
    <img src="https://img.shields.io/badge/build-aprovado-brightgreen" />
    <img src="https://img.shields.io/badge/versão-v1.0.0-blue" />
    <img src="https://img.shields.io/badge/último%20atualização-outubro%202023-lightblue" />
    <img src="https://img.shields.io/badge/linguagem-java-orange" />
    <img src="https://img.shields.io/badge/plataforma-spring%20boot-orange" />
    <img src="https://img.shields.io/badge/Inglês%20(US)-100%25-ff69b4" />
</h4>

---

## Status do projeto
#### ✅ Released
---

## Índice
<ul>
  <li><a href="#descrição-do-projeto">Descrição do projeto</a></li>
  <li><a href="#status-do-projeto">Status do projeto</a></li>
  <li><a href="#índice">Índice</a></li>
  <li><a href="#recursos">Recursos</a></li>
  <li><a href="#rotas-da-api">Rotas da API</a></li>
  <li><a href="#pré-requisitos">Pré-requisitos</a></li>
  <li><a href="#tecnologias">Tecnologias</a></li>
  <li><a href="#autora">Autora</a></li>
</ul> 

---

## Recursos
- [x] Criação de solicitações de atendimento
- [x] Listagem de todas as solicitações de atendimento
- [x] Listagem de solicitações por código
- [x] Listagem da fila para atendimento
- [x] Listagem de posição na fila por código
- [x] Listagem de todos os operadores de atendimento
- [x] Listagem de operadores por código
- [x] Listagem de todos os clientes
- [x] Listagem de clientes por código
- [x] Listagem de todos os tipos de assuntos para solicitações
- [x] Listagem de tipos de assuntos por código
- [x] Listagem de todos os times de atendimento
- [x] Listagem de times por código

---

## Rotas da API
### GET customerservice/request
Retorna todas as solicitações de atendimento.
</br>

### GET customerservice/request/{id}
Retorna uma solicitação de atendimento pelo seu código.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador da solicitação de atendimento.                                                                     |
</br>

### POST customerservice/request
Cria uma novo solicitação de atendimento, ou adiciona o cliente à fila de espera.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |                                                                     |
|     `customer` | obrigatório | int  | Identificador do cliente que está abrindo a solicitação de atendimento.
|     `subject` | obrigatório | int  | Identificador do tipo de solicitação de atendimento (1 - Problemas com cartão; 2 - Contratação de empréstimo; 3 - Outros assuntos).
</br>
</br>

### GET customerservice/queue
Retorna a fila completa.
</br>

### GET customerservice/queue/{id}
Retorna uma posição da fila.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador da posição na fila.                                                                     |
</br>

### GET customerservice/customer
Retorna todos os clientes.
</br>

### GET customerservice/customer/{id}
Retorna uma cliente pelo seu código.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador do cliente.                                                                     |
</br>

### GET customerservice/operator
Retorna todos os operadores de atendimento.
</br>

### GET customerservice/operator/{id}
Retorna um operador de atendimento pelo seu código.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador do operador.                                                                     |
</br>

### GET customerservice/subject
Retorna todos tipos de assuntos para solicitações de atendimento.
</br>

### GET customerservice/subject/{id}
Retorna um tipo de assunto pelo seu código.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador do tipo de assunto.                                                                     |
</br>

### GET customerservice/team
Retorna todos times de atendimento.
</br>

### GET customerservice/team/{id}
Retorna um time pelo seu código.

**Parâmetros**

|          Nome | Obrigatoriedade |  Tipo   | Descrição                                                                                                                                                           |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `id` | obrigatório | int  | Identificador do time de atendimento.                                                                     |

---

## Pré-requisitos
Você deve ter as seguintes ferramentas instaladas em sua máquina: [Git](https://git-scm.com/downloads); uma IDE, como a [IntelliJ IDEA](https://www.jetbrains.com/idea/), [PostgreSQL](https://www.postgresql.org/), e um gerenciador de banco de dados PostgreSQL, como o [pgAdmin](https://www.pgadmin.org/).

### ▶️ Executando a aplicação

```bash
# Clone este repositório
$ git clone https://github.com/AndressaCarvalho/CustomerServiceAPI.git

# Importe o backup do banco de dados (database_bkp) utilizando o gerenciador de banco de dados

# Abra o projeto na IDE

# Altere o Data Source da conexão, presente no arquivo application.properties

# Execute a aplicação
```

---

## Tecnologias
As seguintes ferramentas foram utilizadas na construção do projeto:
- [Spring Boot](https://spring.io/projects/spring-boot)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [PostgreSQL](https://www.postgresql.org/)
- [pgAdmin](https://www.pgadmin.org/)
- [Git](https://git-scm.com/)

---

## Autora
<a href="https://github.com/AndressaCarvalho">
  <img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/51313172?s=96&v=4" width="100px;" alt=""/>
  <br/>
  <sub><b>Andressa Carvalho</b></sub>
 </a> <a href="https://github.com/AndressaCarvalho" title="Rocketseat">🚀</a>
<br/><br/>
Feito com ❤️ por Andressa Carvalho 👋🏽 Entre em contato!
<br/><br/>

[![Linkedin Badge](https://img.shields.io/badge/-Andressa-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/andressa-carvalho-araujo-289931199/)](https://www.linkedin.com/in/andressa-carvalho-araujo-289931199/) 
[![Gmail Badge](https://img.shields.io/badge/-andressa.carvalho13454@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:andressa.carvalho13454@gmail.com)](mailto:andressa.carvalho13454@gmail.com)
