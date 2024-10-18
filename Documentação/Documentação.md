## Sumário
1. [VISÃO GERAL DO SISTEMA](#1-visão-geral-do-sistema)
2. [DIAGRAMA DE ATIVIDADES](#2-diagrama-de-atividades)
3. [LEVANTAMENTO DE REQUISITOS](#3-levantamento-de-requisitos)

   3.1. [REQUISITOS FUNCIONAIS](#31-requisitos-funcionais)
   
   3.2. [REQUISITOS NÃO FUNCIONAIS](#32-requisitos-não-funcionais)
   
   3.3. [REQUISITOS SUPLEMENTARES](#33-requisitos-suplementares)

4. [DETALHAMENTO DE REQUISITOS](#4-detalhamento-de-requisitos)
5. [DIAGRAMA DE SEQUÊNCUA ](#5-diagrama-de-sequencia)
6. [CASOS DE USO](#6-casos-de-uso)

---

## 1. VISÃO GERAL DO SISTEMA

O sistema deve gerenciar o controle de aeronaves e voos da empresa aérea e voos internacionais mundiais de forma online de acordo com a origem e destino. Há também a funcionalidade de promover uma verificação geográfica dos voos online. O sistema providenciará relatórios de voos e aeronaves e viagens dentro da própria companhia aérea. O sistema será desenvolvido para plataforma Web, no qual clientes farão login por meio de e-mail e senha. O sistema deverá funcionar com um código de acesso para verificação.

---

## 2. DIAGRAMA DE ATIVIDADES

![Diagrama de Atividades Rastreamento](Diagramas/Diagrama%20de%20atividade%20-%20Rastreamento.svg)
_O diagrama acima representa o processo de Rastreamento de um Voos_

![Diagrama de Atividades Aeronaves](Diagramas/Diagrama%20de%20atividade%20-%20Aeronave.svg)
_O diagrama acima representa o processo de gerenciamento de Aeronaves_

![Diagrama de Atividades Voos](Diagramas/Diagrama%20de%20atividade%20-%20Voo.svg)
_O diagrama acima representa o processo de gerenciamento de Voos_

![Diagrama de Atividades Funcionarios](Diagramas/Diagrama%20de%20atividade%20-%20Funcionarios.svg)
_O diagrama acima representa o processo de gerenciamento de Funcionarios_

![Diagrama de Atividades Planejamento](Diagramas/Diagrama%20de%20atividade%20-%20Planejamento.svg)
_O diagrama acima representa o processo de gerenciamento de Planejamento_

---

## 3. LEVANTAMENTO DE REQUISITOS

---
### 3.1. REQUISITOS FUNCIONAIS

1. Gerenciar usuário
2. Gerenciar controle de voos
3. Gerenciar controle de aeronaves
4. Gerenciar cadastros do usuário
5. Observar voos de aeronaves mundiais

---

### 3.2. REQUISITOS NÃO FUNCIONAIS

1. A criação de usuários administradores deve ser feita por um códigos.
2. O cadastro dos usuários deve conter email, cpf, nome e telefone.
3. Controle de Acesso.
4. Pesquisa de aeronaves de terceiro por meio de ICAO
5. Fazer Requisição de dados aéreos por meio da API "Aviation Stack"

---

### 3.3. REQUISITOS SUPLEMENTARES

1. O sistema deve operar via interface Web
2. O sistema deve ser desenvolvido na linguagem Java e JavaScript
3. O sistema deve utilizar o banco de dados PostgreSQL
4. O sistema utilizará a API AviationStack.

---

## 4. DETALHAMENTO DE REQUISITOS 

| **RF1. CRUD de usuários administradores** |
|:---|
| **Descrição:**<br>O administrador chefe do sistema poderá criar editar permissões para novos funcionários que irão administrar o sistema. Esse processo inclui a troca de código de acesso. Ou por meio de cadastro com código especial|
| **Fontes:** |
| **Usuários:**<br>Administrador|
| **Informações de entrada:**<br>O administrador chefe poderá alterar os dados do novo funcionário, incluindo nome completo, endereço de e-mail, senha, cargo/posição, telefone de contato, CPF e número de acesso.
| **Informações de saída:**<br>Confirmação visual com mensagem de sucesso informando que o novo usuário foi criado corretamente e a exibição das credenciais de acesso geradas. |
| **Requisitos não funcionais:**<br>Desempenho com tempo de resposta rápido juntamente a segurança de registro para novos usuários por meio de credenciais únicas e criptografia. |
---


| **RF2. Realizar login de usuários administradores** |
|:---|
| **Descrição:**<br>O usuário poderá acessar o sistema fornecendo suas credenciais para autenticação e autorização de acesso. |
| **Fontes:**<br>Documentação de segurança do sistema.<br>Políticas de autenticação e credenciais da empresa. |
| **Usuários:**<br>Usuário administrador |
| **Informações de entrada:**<br>O usuário administrador deverá fornecer seu e-mail e senha. |
| **Informações de saída:**<br>Confirmação de Login, redirecionamento para a página inicial do painel de administração ou mensagem de falha caso haja falha de autenticação. |
| **Requisitos não funcionais:**<br>O sistema deve implementar criptografia para proteger as credenciais transmitidas durante o login, tempo de resposta rápido, mensagens de erros devem ser claras e deve possuir compatibilidade com diversos navegadores. |

| **RF3. Pré-Cadastro Usuário** |
|:---|
| **Descrição:**<br>O administrador chefe do sistema criará novos códigos que irão ser usados pelos funcionários no ato de seu cadastro. Esse processo inclui a autenticação do código de acesso.|
| **Fontes:** <br> Sistema |
| **Usuários:**<br>Administrador|
| **Informações de entrada:**<br>O administrador incluirá novo funcionário e adicionará um código de acesso e um nível ao novo funcionário.
| **Informações de saída:**<br>Confirmação visual com mensagem de sucesso informando que o novo usuário foi criado corretamente e a exibição das credenciais de acesso geradas. |
| **Requisitos não funcionais:**<br>Desempenho com tempo de resposta rápido juntamente a segurança de registro para novos usuários por meio de credenciais únicas e criptografia. |
---

| **RF4. CRUD de usuarios** |
|:---|
| **Descrição:**<br>O usuário irá acessar o sistema e fornecer os dados necessários para criar uma nova conta de usuário. Este cadastro permitirá que o usuário utilize as funcionalidades do sistema. |
| **Fontes:**<br>Documentação do sistema, requisitos  e consultas em Sistemas similares |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>O usuário deverá preencher os dados, incluindo nome completo, endereço de e-mail, senha, telefone de contato, CPF e código de acesso  liberado para o funcionário|
| **Informações de saída:**<br>Confirmação visual com mensagem de sucesso informando que o novo usuário foi criado corretamente e a exibição de acesso geradas.  |
| **Requisitos não funcionais:**<br>Desempenho com tempo de resposta rápido juntamente a segurança de registro para novos usuários por meio de credenciais únicas e criptografia.  |
---



| **RF5. Realizar login de usuários** |
|:---|
| **Descrição:**<br>Este recurso permite que um usuário normal acesse o sistema através da autenticação com suas credenciais pessoais. Após o fornecimento de e-mail e senha, o sistema valida as informações e concede acesso com base na autorização apropriada. |
| **Fontes:**<br>Documentação do sistema |
| **Usuários:**<br>Usuário normal |
| **Informações de entrada:**<br>O usuário deverá fornecer seu e-mail e senha. |
| **Informações de saída:**<br>Confirmação de Login, redirecionamento para a página inicial do sistema ou mensagem de falha caso haja falha de autenticação.  |
| **Requisitos não funcionais:**<br>O sistema deve implementar criptografia para proteger as credenciais transmitidas durante o login, tempo de resposta rápido, mensagens de erros devem ser claras e deve possuir compatibilidade com diversos navegadores.  |

---

| **RF6. CRUD controle de voos** |
|:---|
| **Descrição:**<br>Este recurso permite que o usuário administrador cadastre, mantenha e exclua voos na companhia aérea. A funcionalidade abrange todas as operações necessárias para o gerenciamento de voos, garantindo que todas as informações relevantes estejam atualizadas e precisas. |
| **Fontes:**<br>Documentação interna do sistema de gerenciamento de voos, seguindo as regras e regulamentos da aviação civil Manual do Sistema de Registro de Operações (SIROS). |
| **Usuários:**<br>Usuário administrador |
| **Informações de entrada:**<br>Para cadastrar ou manter um voo, o administrador deve fornecer o código do voo, que é um identificador único do voo (por exemplo, AB1234). É necessário também informar a origem, especificando o aeroporto de partida (como GRU - Aeroporto Internacional de São Paulo/Guarulhos), e o destino, que corresponde ao aeroporto de chegada (como JFK - Aeroporto Internacional John F. Kennedy).
Além disso, é preciso indicar a duração do voo. A quantidade máxima de passageiros permitidos deve ser especificada no campo de quantidade de passageiros. A aeronave utilizada deve ser informada, incluindo o modelo e a marca (por exemplo, Boeing 737). Outros dados essenciais incluem o peso máximo permitido para bagagens e carga (em kg) e as datas programadas para manutenção da aeronave, referidas como período de manutenção. |
| **Informações de saída:**<br>Confirmação da criação, atualização ou exclusão de um voo, exibição de uma lista atualizada de voos cadastrados, mostrando detalhes como código do voo, origem, destino, horário ou uma mensagem de erro em caso de falha na operação, como código de voo duplicado ou dados inválidos.  |
| **Requisitos não funcionais:**<br>O sistema deve restringir o acesso ao CRUD de voos apenas a usuários administradores, o sistema deverá ser capaz de gerenciar um grande número de voos sem perda de desempenho, especialmente em períodos de alta demanda.  |

---
| **RF7. Realizar busca de voos** |
|:---|
| **Descrição:**<br>O recurso permite que o usuário realize buscas por viagens passadas e futuras, consulte dados de viagens anteriores e altere informações de viagens futuras do sistema, quando necessário. |
| **Fontes:**<br>Documentação do sistema, requisitos  e consultas em Sistemas similares. |
| **Usuários:**<br>Usuário normal Usuário admin|
| **Informações de entrada:**<br>O usuário pode informar a origem, destino, código da viagem e data para localizar a viagem. Para viagens futuras, o usuário pode alterar dados da viagem conforme permitido. |
| **Informações de saída:**<br>Tela com as informações de voos compatíveis com a busca, priorizando uma ordem.  |
| **Requisitos não funcionais:**<br>a  |

--


| **RF8. Realizar busca de registros de aeronaves internacionais** |
|:---|
| **Descrição:**<br>O recurso permite que o usuário realize buscas por viagens passadas e futuras, consulte dados de viagens anteriores de aeronaves internacionais  |
| **Fontes:**<br>Documentação do sistema e Documentação da API |
| **Informações de entrada:**<br>O usuário deve informar o código IATA/ICAO do vôo desejado. |
| **Informações de saída:**<br>Tela com as informações de voos compatíveis com a busca, priorizando uma ordem e um mapa com sua localização atual caso esteja ativo.  |
| **Requisitos não funcionais:**<br> Funciona a partir de requisição ao Banco de Dados DA API |

---


## 5. DIAGRAMAS DE SEQUÊNCIA

![DiagramaSeq1](/Documentação/Diagramas/DiagramaSeq1.png)
<br>


## 6. CASOS DE USO

| **UC01. CADASTRO DE USUÁRIO** |
|:---|
| **NOME DO CASO DE USO:**<br> Cadastro de usuário |
| **ATOR:**<br>Cliente | 
| **OBJETIVO:**<br> Oferecer a possibilidade de cadastro no sistema para utilizar os serviços oferecidos.|
| **PRÉ-CONDIÇÕES:**<br> 1. O usuário não deve possuir uma conta registrada no sistema.|
| **PÓS-CONDIÇOES:**<br> O usuário é registrado no sistema e pode realizar login para utilizar as funcionalidades disponíveis.|
| **CENÁRIO PRINCIPAL:** <br> 1. [IN]O usuário acessa a página de cadastro. <br> 2. [IN] O usuário preenche o formulário de cadastro com as informações necessárias [RN1]<br>3. [OUT] O sistema valida as informações fornecidas. [E1] [E2]<br> 4.[OUT] O sistema registra o novo usuário no banco de dados. <br> 5. [OUT] O sistema exibe uma mensagem de confirmação e envia um e-mail de boas-vindas ao usuário.|
| **CENÁRIO ALTERNATIVO:**<br> |
|**EXCEÇÃO**|<br>[E1] Se o e-mail fornecido já estiver associado a uma conta existente, o sistema notifica o usuário e solicita a utilização de outro e-mail ou o login com a conta existente. <br> [E2] Se alguma informação estiver incorreta ou faltar, o sistema exibe uma mensagem de erro e solicita que o usuário corrija as informações.| 
|**REGRAS DE NEGÓCIO** <br> RN1 - O usuário deve preencher campos com origem com NOME, CPF, DATA DE NASCIMENTO, TELEFONE e E-MAIL. |

![CasoDeUso](/Documentação/Diagramas/CasoDeUso.png)
<br>


---



| **UC02 CRUD DE AERONAVE** |
|:---|
| **NOME DO CASO DE USO:**  <br>Cadastro de aeronave |
| **ATOR:** <br> Funcionário |
| **OBJETIVO:** <br> Permitir o cadastro de novas aeronaves no sistema. |
| **PRÉ-CONDIÇÕES:**<br> O funcionário deve estar autenticado no sistema. |
| **PÓS-CONDIÇOES:** <br> A o vôo é registrada no sistema e está disponível para operações. |
| **CENÁRIO PRINCIPAL:** |
| 1. [IN] O administrador acessa a página de cadastro de voos. <br> 2. [IN] O administrador preenche o formulário de cadastro com as informações necessárias [RN1]. <br> 3. [OUT] O sistema valida as informações fornecidas. [E1] <br> 4. [OUT] O sistema registra o novo voo no banco de dados. <br> 5. [OUT] O sistema exibe uma mensagem de confirmação do cadastro.
| **CENÁRIO ALTERNATIVO:** |
| **EDITAR** <br> 1. [IN] Usuário realiza busca do objeto desejado, seleciona <br> 2. [IN]  clica em editar <br> 3. [IN]  Altera os dados desejados  <br> 4. [OUT] retorna a página com dados atualizados|
| **DELETAR** <br> 1. [IN] Usuário realiza busca do objeto desejado, seleciona <br> 2. [IN]  clica em editar. <br>3. [OUT] retorna a página com sem o objeto deletado|
| **EXCEÇÃO** |
| [E1] Se alguma informação estiver incorreta ou faltar, o sistema exibe uma mensagem de erro e solicita que o administrador corrija as informações. |  
| **REGRAS DE NEGÓCIO** <br>RN1 - O administrador deve preencher campos obrigatórios: Modelo, Tipo, Peso Máx. Decolagem, Peso Vazio, Nº Máx. de Ocupantes, Velocidade Média, Combustível Máximo, Combustível por Hora. |

![CasoDeUso2](/Documentação/Diagramas/CasoDeUso2.png)
<br>
---

| **UC03. CRUD DE VOO** |
|:---|
| **NOME DO CASO DE USO:**<br> Cadastro de voo |
| **ATOR:**<br>Funcionário | 
| **OBJETIVO:**<br> Permitir o cadastro de novos voos no sistema.|
| **PRÉ-CONDIÇÕES:**<br> 1. O usuário deve possuir uma conta registrada no sistema.|
| **PÓS-CONDIÇOES:**<br> O usuário é registrado no sistema e pode realizar login para utilizar as funcionalidades disponíveis.|
| **CENÁRIO PRINCIPAL:** <br> 1. [IN]O usuário acessa a página de cadastro. <br> 2. [IN] O usuário preenche o formulário de cadastro com as informações necessárias [RN1]<br>3. [OUT] O sistema valida as informações fornecidas. [E1] [E2]<br> 4.[OUT] O sistema registra o novo usuário no banco de dados. <br>|
| **CENÁRIO ALTERNATIVO:**<br> |
|**EXCEÇÃO**|<br>[E1] Se o e-mail fornecido associado a uma conta existente, o sistema notifica o usuário e solicita a utilização de outro e-mail ou o login <br> [E2] Se alguma informação estiver incorreta ou faltar, o sistema exibe uma mensagem de erro e solicita que o usuário corrija as informações.| 
|**REGRAS DE NEGÓCIO** <br>RN1 - O usuário deve preencher campos obrigatórios: N° Voo, Aeronave, Duração, Origem, Destino.|

![CasoDeUso3](/Documentação/Diagramas/CasoDeUso3.png)
<br>

---


| **UC04. RELATÓRIO  DE AERONAVES DA EMPRESA** |
|:---|
| **NOME DO CASO DE USO:**<br> Relatório de aeronaves |
| **ATOR:**<br> Usuario | 
| **OBJETIVO:**<br> Emissão do relatório de aeronaves.|
| **PRÉ-CONDIÇÕES:**<br> 1. Cadastro da aeronaves.|
| **PÓS-CONDIÇOES:**<br> Não há|
| **CENÁRIO PRINCIPAL:** <br>1. [IN] O usuário acessa a interface de pesquisa escolhendo a filtragem desejada .<br> 2. [OUT] O sistema valida o o dado pesquisado. <br> 3. [OUT] O sistema valida retorna as aeronaves que batem com a pesquisa.<br>
| **CENÁRIO ALTERNATIVO:** <BR> NÃO HÁ <BR>|


---

| **UC04. RELATÓRIO DE VOOS DA EMPRESA** |
|:---|
| **NOME DO CASO DE USO:**<br> Relatório de vos |
| **ATOR:**<br> Usuario | 
| **OBJETIVO:**<br> Emissão do relatório de voos.|
| **PRÉ-CONDIÇÕES:**<br> 1. Cadastro de voos.|
| **PÓS-CONDIÇOES:**<br> Não há|
| **CENÁRIO PRINCIPAL:** <br>1. [IN] O usuário acessa a interface de pesquisa escolhendo a filtragem desejada .<br> 2. [OUT] O sistema valida o o dado pesquisado. <br> 3. [OUT] O sistema valida retorna os voos da empresa que batem com a pesquisa.<br>
| **CENÁRIO ALTERNATIVO:** <BR> NÃO HÁ <BR>|

![CasoDeUso4](/Documentação/Diagramas/CasoDeUso4.png)
<br>

---

| **UC05. PESQUISA DE VOOS API** |
|:---|
| **NOME DO CASO DE USO:**<br> PESQUISA DE VOOS INTERNACIONAIS |
| **ATOR:**<br>Cliente | 
| **OBJETIVO:**<br> Oferecer a de voos existentes no sistema aéreo mundial através do Código IATA/ICAO.|
| **PRÉ-CONDIÇÕES:**<br> 1. O usuário deve possuir uma conta registrada no sistema <br> A chave Key da API com o sistema deve possuir requisições mensal disponível.|
| **PÓS-CONDIÇOES:**<br> O sistema registra a requisição e retorna dados sobre a aeronave, datas de voos, ativos, cancelados, concluídos e agendados além de um mapa com sua localização caso esteja com ativo|
| **CENÁRIO PRINCIPAL:** <br>1. [IN] O cliente acessa a interface de pesquisa de voos.<br>2. [IN] O sistema solicita que o cliente insira o código IATA ou ICAO do voo. <br> 3. [IN] O cliente insere o código do voo e confirma a pesquisa. <br> 4. [OUT] O sistema valida o código inserido. [RN1] <br>5. [OUT] O sistema consulta a API da AviationStack. [RN2] <br>6. [OUT] A API retorna os dados do voo, como aeronave, status e localização. [E1] [E2] <br> 7. [OUT] Caso o voo esteja ativo, o sistema exibe a localização em tempo real em um mapa. <br> 8. [OUT] O sistema apresenta os dados ao cliente. <br> 9. [OUT] O sistema registra a consulta no histórico. <br> 10. [OUT] O cliente finaliza a pesquisa. |
| **CENÁRIO ALTERNATIVO:**|
| **EXCEÇÃO**|
|[E1] O cliente tenta pesquisar um voo, o sistema tenta acessar a API, mas está indisponível, em seguida o sistema exibe uma mensagem de erro: "Falha na pesquisa." [RN3], O sistema registra a tentativa de acesso e o erro. <br>  [E2] O cliente insere um código inválido ou de voo inexistente. O sistema detecta o código como inválido ou a API não encontra o voo. [RN1]. O sistema exibe uma mensagem de erro: "Voo não encontrado."|
| **REGRAS DE NEGÓCIO:** <br>[RN1] - O sistema deve validar o código IATA ou ICAO inserido pelo cliente. [RN2] - O sistema só deve acessar a API se a chave de API estiver válida e com requisições disponíveis. <br> [RN3] - O sistema deve registrar e notificar o cliente em caso de falha na pesquisa devido à indisponibilidade da API. |


![CasoDeUso5](/Documentação/Diagramas/CasoDeUso5.png)
<br>

---

## 7. Modelo Conceitual

![Modelo Conceitual](Diagramas/ModeloConceitual.svg)
_O diagrama acima representa a Modelagem Conceitual_

---

## 8. Modelo Relacional

![Modelo Relacional](Diagramas/Modelo_Relacional.png)
_O diagrama acima representa a Modelagem Relacional_

---

## 9. Diagramas de Classes

![Diagrama de Classes](Diagramas/Entity.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto Entity_

![Diagrama de Classes](Diagramas/Repository.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto Repository_

![Diagrama de Classes](Diagramas/Service.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto Service_

![Diagrama de Classes](Diagramas/DTO.png.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto DTO_

![Diagrama de Classes](Diagramas/Security.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto Security_

![Diagrama de Classes](Diagramas/Controller.png)
_O diagrama acima representa o diagrama de classes da Estrutura de projeto Controller_
