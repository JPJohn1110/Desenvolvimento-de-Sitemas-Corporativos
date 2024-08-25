## Sumário
1. [VISÃO GERAL DO SISTEMA](#1-visão-geral-do-sistema)
2. [DIAGRAMA DE ATIVIDADES](#2-diagrama-de-atividades)
3. [LEVANTAMENTO DE REQUISITOS](#3-levantamento-de-requisitos)

   3.1. [REQUISITOS FUNCIONAIS](#REQUISITOS-FUNCIONAIS)
   
   3.2. [REQUISITOS NÃO FUNCIONAIS](#REQUISITOS-NÃO-FUNCIONAIS)
   
   3.3. [REQUISITOS SUPLEMENTARES](#REQUISITOS-SUPLEMENTARES)

4. [DETALHAMENTO DE REQUISITOS](#DETLHAMENTO-DE-REQUISITOS)
5. [CASOS DE USO](#CASOS-DE-USO)

---

# 1. VISÃO GERAL DO SISTEMA

O sistema deve gerenciar o controle de passagens e assentos da empresa aérea de forma online de acordo com a origem e destino do voo de clientes registrados e a viabilidade de reservar passagens para viagens futuras junto a capacidade de promover check-in online. Há também a funcionalidade de promover viagens mais acessíveis. O sistema providenciará descontos de acordo com milhas viajadas dentro da própria companhia aérea. O sistema será desenvolvido para plataforma Web, no qual clientes farão login por meio de email e senha. O sistema deverá reenviar e-mails para compradores após a compra para confirmação e como forma de lembrete da viagem.

---

# 2. DIAGRAMA DE ATIVIDADES

![Diagrama de Atividades](Diagramas/Diagrama%20de%20atividade%20-%20Compra.svg)
_O diagrama acima representa o processo de compra da passagem_

![Diagrama de Atividades Check-in](Diagramas/Diagrama%20de%20atividade%20-%20Check-in.svg)
__O diagrama acima representa o processo de check-in

---

# 3. LEVANTAMENTO DE REQUISITOS

A

---
## 3.1. REQUISITOS FUNCIONAIS

1. CRUD de usuários administradores
2. Realizar login de usuários administradores
3. CRUD de usuarios
4. Realizar login de usuários
5. CRUD controle de voos
6. CRUD controle de passagem
7. Realizar venda de passagens
8. Realizar check-in
9. Realizar busca de voos

---

## 3.2. REQUISITOS NÃO FUNCIONAIS

1. A criação de usuários administradores deve ser feita por uma conta root.
2. O cadastro dos usuários deve conter algum documento de identificação.
3. Assento econômico 25% de lucro, Assento comum 35%, Primeira classe 65% 
4. O cálculo das passagens deve ser realizado da seguinte forma: 
5. O check-in deve ser permitido ao usuário 48 horas antes da viagem

---

## 3.3. REQUISITOS SUPLEMENTARES

1. O sistema deve operar via interface Web
2. O sistema deve ser desenvolvido na linguagem Java
3. O sistema deve utilizar o banco de dados PostgreSQL

---