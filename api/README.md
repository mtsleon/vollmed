# Voll.med - API Rest

### Backend - Java
O objetivo principal do projeto é organizar o dia-a-dia de um Hospital ou Consultório Médico com um aplicativo para agendamento de consultas, gerenciamento de pacientes e médicos. Este projeto foi desenvolvimento durante o curso de Spring Boot 3 na Alura em parceria com a Unicamp.

#### Técnologias
Java, Spring Boot, Spring Security, Spring Data, JPA, JWT, Lombok.

---

#### Autenticação:

```[POST] /login``` Efetuar Login


#### Paciente:

```[POST] /paciente``` Cadastrar Paciente

```[GET] /pacientes``` Listagem de Pacientes

```[PUT] /pacientes/{id}``` Atualizar Paciente

```[DEL] /pacientes/{id}``` Excluir Paciente

```[GET] /pacientes/{id}``` Detalhar Paciente


#### Médico:

```[POST] /medicos``` Cadastrar Médico

```[GET] /medicos``` Listagem de Médicos

```[PUT] /medicos/{id}``` Atualizar Médico

```[DEL] /medicos/{id}``` Excluir Médico

```[GET] /medicos/{id}``` Detalhar Médico

