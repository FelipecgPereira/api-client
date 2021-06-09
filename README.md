<h2 align="center">
 <img src="https://i.imgur.com/OacR2eu.png" alt="">
</h2>

# Indice

- [Sobre](#-sobre)
- [Tecnologia](#-tecnologia)
- [End Points](#-end-points)
---

## 📋 Sobre

Aplicação back-end construida no bootcamp spring react da [DEVSUPERIO](https://devsuperior.com.br/) com uso do SpringBoot, onde  foi abordado conceitos do spring, o uso da injeção de dependencia, padrão de projeto e JPA,.
## 💻 Tecnologia

- [Spring](https://spring.io/)


## 📝 End Points

- Busca paginada de clientes - GET
```bash 
# ROTA
/clients?page=0&linesPerPage=6&direction=ASC&orderBy=name
```
- Busca de cliente por id - GET
```bash 
# ROTA
/clients/{id}
```
- Inserção de novo cliente - POST
```bash 
# ROTA
/clients
```
```bash 
{
  "name": "Maria Silva",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}

```
- Atualização de cliente - PUT
```bash 
# ROTA
/clients/1
```
```bash 
{
  "name": "Maria Silvaaa",
  "cpf": "12345678901",
  "income": 6500.0,
  "birthDate": "1994-07-20T10:30:00Z",
  "children": 2
}
```
- Deleção de cliente - DELETE
```bash 
# ROTA
/clients/{id}
```
---
Desenvolvido 🚀 por Felipe Pereira
