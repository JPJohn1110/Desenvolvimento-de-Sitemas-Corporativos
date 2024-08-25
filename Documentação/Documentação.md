## Sumário
1. [VISÃO GERAL DO SISTEMA](#1-visão-geral-do-sistema)
2. [DIAGRAMA DE ATIVIDADES](#2-diagrama-de-atividades)
3. [LEVANTAMENTO DE REQUISITOS](#3-levantamento-de-requisitos)

   3.1. [REQUISITOS FUNCIONAIS](#31-requisitos-funcionais)
   
   3.2. [REQUISITOS NÃO FUNCIONAIS](#32-requisitos-não-funcionais)
   
   3.3. [REQUISITOS SUPLEMENTARES](#33-requisitos-suplementares)

4. [DETALHAMENTO DE REQUISITOS](#4-detalhamento-de-requisitos)
5. [CASOS DE USO](#5-casos-de-uso)

---

## 1. VISÃO GERAL DO SISTEMA

O sistema deve gerenciar o controle de passagens e assentos da empresa aérea de forma online de acordo com a origem e destino do voo de clientes registrados e a viabilidade de reservar passagens para viagens futuras junto a capacidade de promover check-in online. Há também a funcionalidade de promover viagens mais acessíveis. O sistema providenciará descontos de acordo com milhas viajadas dentro da própria companhia aérea. O sistema será desenvolvido para plataforma Web, no qual clientes farão login por meio de email e senha. O sistema deverá reenviar e-mails para compradores após a compra para confirmação e como forma de lembrete da viagem.

---

## 2. DIAGRAMA DE ATIVIDADES

![Diagrama de Atividades](Diagramas/Diagrama%20de%20atividade%20-%20Compra.svg)
_O diagrama acima representa o processo de compra da passagem_

![Diagrama de Atividades Check-in](Diagramas/Diagrama%20de%20atividade%20-%20Check-in.svg)
__O diagrama acima representa o processo de check-in

---

## 3. LEVANTAMENTO DE REQUISITOS

A

---
### 3.1. REQUISITOS FUNCIONAIS

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

### 3.2. REQUISITOS NÃO FUNCIONAIS

1. A criação de usuários administradores deve ser feita por uma conta root.
2. O cadastro dos usuários deve conter algum documento de identificação.
3. Assento econômico 25% de lucro, Assento comum 35%, Primeira classe 65% 
4. O cálculo das passagens deve ser realizado da seguinte forma: 
5. O check-in deve ser permitido ao usuário 48 horas antes da viagem

---

### 3.3. REQUISITOS SUPLEMENTARES

1. O sistema deve operar via interface Web
2. O sistema deve ser desenvolvido na linguagem Java
3. O sistema deve utilizar o banco de dados PostgreSQL

---

## 4. DETALHAMENTO DE REQUISITOS 

| **RF1. CRUD de usuários administradores** |
|---|
| **Descrição:**<br>O administrador chefe do sistema poderá criar cadastros para novos funcionários que irão administrar o sistema. Esse processo inclui a inserção de informações pessoais, um endereço de e-mail e uma senha para cada novo administrador. |
| **Fontes:** |
| **Usuários:**<br>Administrador chefe |
| **Informações de entrada:**<br>O administrador chefe deverá preencher os dados do novo funcionário, incluindo nome completo, endereço de e-mail, senha, cargo/posição, telefone de contato (opcional), data de nascimento (opcional) e endereço (opcional). |
| **Informações de saída:**<br>Confirmação visual com mensagem de sucesso informando que o novo usuário foi criado corretamente e a exibição das credenciais de acesso geradas. |
| **Requisitos não funcionais:**<br>Desempenho com tempo de resposta rápido juntamente a segurança de registro para novos usuários por meio de credenciais únicas e criptografia. |
---
| **RF2. Realizar login de usuários administradores** |
|---|
| **Descrição:**<br>O usuário administrador irá acessar o sistema fornecendo suas credenciais para autenticação e autorização de acesso. |
| **Fontes:**<br>Documentação de segurança do sistema.<br>Políticas de autenticação e credenciais da empresa. |
| **Usuários:**<br>Usuário administrador |
| **Informações de entrada:**<br>O usuário administrador deverá fornecer seu e-mail e senha. |
| **Informações de saída:**<br>Confirmação de Login, redirecionamento para a página inicial do painel de administração ou mensagem de falha caso haja falha de autenticação. |
| **Requisitos não funcionais:**<br>O sistema deve implementar criptografia para proteger as credenciais transmitidas durante o login, tempo de resposta rápido, mensagens de erros devem ser claras e deve possuir compatibilidade com diversos navegadores. |
---
| **RF3. CRUD de usuarios** |
|:---|
| **Descrição:**<br>O usuário irá acessar o sistema e fornecer os dados necessários para criar uma nova conta de usuário. Este cadastro permitirá que o usuário utilize as funcionalidades do sistema. |
| **Fontes:**<br>Documentação do sistema, requisitos  e consultas em Sistemas similares |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>O usuário deverá preencher os dados, incluindo nome completo, endereço de e-mail, senha, telefone de contato (opcional), data de nascimento (opcional) e endereço (opcional). |
| **Informações de saída:**<br>Confirmação visual com mensagem de sucesso informando que o novo usuário foi criado corretamente e a exibição de acesso geradas.  |
| **Requisitos não funcionais:**<br>Desempenho com tempo de resposta rápido juntamente a segurança de registro para novos usuários por meio de credenciais únicas e criptografia.  |
---
| **RF4. Realizar login de usuários** |
|---|
| **Descrição:**<br>Este recurso permite que um usuário normal acesse o sistema através da autenticação com suas credenciais pessoais. Após o fornecimento de e-mail e senha, o sistema valida as informações e concede acesso com base na autorização apropriada. |
| **Fontes:**<br>Documentação do sistema |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>O usuário deverá fornecer seu e-mail e senha. |
| **Informações de saída:**<br>Confirmação de Login, redirecionamento para a página inicial do sistema ou mensagem de falha caso haja falha de autenticação.  |
| **Requisitos não funcionais:**<br>O sistema deve implementar criptografia para proteger as credenciais transmitidas durante o login, tempo de resposta rápido, mensagens de erros devem ser claras e deve possuir compatibilidade com diversos navegadores.  |

---

| **RF5. CRUD controle de voos** |
|---|
| **Descrição:**<br>Este recurso permite que o usuário administrador cadastre, mantenha e exclua voos na companhia aérea. A funcionalidade abrange todas as operações necessárias para o gerenciamento de voos, garantindo que todas as informações relevantes estejam atualizadas e precisas. |
| **Fontes:**<br>Documentação interna do sistema de gerenciamento de voos, seguindo as regras e regulamentos da aviação civil Manual do Sistema de Registro de Operações (SIROS). |
| **Usuários:**<br>Usuário administrador |
| **Informações de entrada:**<br>Para cadastrar ou manter um voo, o administrador deve fornecer o código do voo, que é um identificador único do voo (por exemplo, AB1234). É necessário também informar a origem, especificando o aeroporto de partida (como GRU - Aeroporto Internacional de São Paulo/Guarulhos), e o destino, que corresponde ao aeroporto de chegada (como JFK - Aeroporto Internacional John F. Kennedy).
Além disso, é preciso indicar a duração do voo. A quantidade máxima de passageiros permitidos deve ser especificada no campo de quantidade de passageiros. A aeronave utilizada deve ser informada, incluindo o modelo e a marca (por exemplo, Boeing 737). Outros dados essenciais incluem o peso máximo permitido para bagagens e carga (em kg) e as datas programadas para manutenção da aeronave, referidas como período de manutenção. |
| **Informações de saída:**<br>Confirmação da criação, atualização ou exclusão de um voo, exibição de uma lista atualizada de voos cadastrados, mostrando detalhes como código do voo, origem, destino, horário ou uma mensagem de erro em caso de falha na operação, como código de voo duplicado ou dados inválidos.  |
| **Requisitos não funcionais:**<br>O sistema deve restringir o acesso ao CRUD de voos apenas a usuários administradores, o sistema deverá ser capaz de gerenciar um grande número de voos sem perda de desempenho, especialmente em períodos de alta demanda.  |

---

| **RF6. CRUD controle de passagem** |
|---|
| **Descrição:**<br>Este recurso permite que o usuário administrador cadastre, mantenha e exclua passagens na companhia aérea. Para que uma passagem possa ser criada, é necessário que já exista um voo cadastrado vinculado a ela. |
| **Fontes:**<br>Documentação interna do sistema de gerenciamento de voos, seguindo as regras e regulamentos da aviação civil do Manual do Sistema de Registro de Operações (SIROS) |
| **Usuários:**<br>Usuário administrador |
| **Informações de entrada:**<br>Para cadastrar ou manter uma passagem, o administrador deve fornecer o código da passagem, que é um identificador único para a passagem. Também deve ser informada a data e horário de partida, correspondente ao voo associado à passagem. É essencial vincular a passagem a um código de voo já cadastrado, garantindo que a quantidade de passagens corresponda à quantidade de passageiros permitidos no voo. |
| **Informações de saída:**<br>Confirmação de Operação no qual mostra mensagens de sucesso ou erro ao criar, atualizar ou excluir uma passagem e apresentam os dados da passagem, incluindo código, voo associado, data e horário de partida.  |
| **Requisitos não funcionais:**<br>Somente administradores autenticados podem realizar operações de CRUD sobre passagens e garantir que o número de passagens emitidas não ultrapasse a capacidade do voo.  |

---

| **RF7. Realizar venda de passagens** |
|---|
| **Descrição:**<br>Este recurso permite que o usuário acesse o sistema, procure por passagens disponíveis e realize a compra das mesmas. O sistema deve facilitar a busca, seleção e aquisição das passagens de maneira eficiente e segura. |
| **Fontes:**<br>Documentação interna do sistema de gerenciamento de voos, seguindo as regras e regulamentos da aviação civil Manual do Sistema de Registro de Operações (SIROS). |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>Para realizar a compra, o usuário deverá fornecer as informações de origem e destino, selecionar os assentos de acordo com o trajeto, fornecer dados pessoais caso não esteja cadastrado, escolher o meio de pagamento e fornecer os dados necessários para o pagamento. |
| **Informações de saída:**<br>Resumo da compra para confirmação, incluindo detalhes da passagem, voo, e assento selecionado, com comprovante da transação realizada, incluindo número da compra, valor pago, e forma de pagamento e contato da empresa responsável pelo voo para demais situações.  |
| **Requisitos não funcionais:**<br>O sistema deve garantir a proteção dos dados pessoais e financeiros do usuário, utilizando criptografia e protocolos de segurança adequados e ser intuitivo e fácil de usar, garantindo uma experiência positiva para o usuário final.  |

---

| **RF8. Realizar check-in** |
|---|
| **Descrição:**<br>Este recurso permite que o usuário acesse o sistema, procure por suas passagens disponíveis e realize o check-in. O sistema deve facilitar a busca e o check-in das passagens de maneira eficiente e segura. |
| **Fontes:**<br>Documentação interna do sistema de gerenciamento de voos, seguindo as regras e regulamentos da aviação civil juntamente aos dados fornecidos pelas companhias aéreas. |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>Para realizar o check-in, o usuário deve fornecer o código do vôo (código localizador) e o aeroporto de partida, selecionar os passageiros que irão realizar o voo, fornecer os dados necessários para o check-in caso não estejam cadastrados, e selecionar os assentos caso ainda não tenham sido escolhidos. |
| **Informações de saída:**<br>Comprovante de check-in juntamente com o cartão de embarque.  |
| **Requisitos não funcionais:**<br>O sistema deve garantir a proteção dos dados pessoais e financeiros do usuário utilizando protocolos de segurança adequados.  |

---

| **RF9. Realizar busca de voos** |
|---|
| **Descrição:**<br>O recurso permite que o usuário realize buscas por viagens passadas e futuras, consulte dados de viagens anteriores e altere informações de viagens futuras, quando possível. |
| **Fontes:**<br>Documentação do sistema, requisitos  e consultas em Sistemas similares. |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>O usuário pode informar a origem, destino, código da viagem e data para localizar a viagem. Para viagens futuras, o usuário pode alterar dados da viagem conforme permitido. |
| **Informações de saída:**<br>Tela com as informações de voos compatíveis com a busca, priorizando uma ordem.  |
| **Requisitos não funcionais:**<br>a  |

---

## 5. CASOS DE USO