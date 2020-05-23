# Challenge Netshoes

# Location-Services

É serviço responsável por gerenciar tudo relacionado a localidades.
    
### Installation

Requerimentos para execução: 
[Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
[Docker](https://docs.docker.com/docker-for-windows/install/)

```sh
$ docker-compose build
$ docker-compose up
```

Após executar os comandos temos a aplicação em container, junto com o mysql já populado com algumas localidades

A documentaço da aplicação consta nessa url 
(http://localhost:8080/swagger-ui.html#/)

## Perguntas

## 1. Documentação do que foi utilizado no projeto

Foi desenvolvida uma API REST no padrão MVC, está tudo separo por camadas (Model,View e Controller), o codigo fonte esta divido por responsabilidades:
  - endpoint: responsável apenas por receber requisições dos clientes via REST e repassar para o serviço
  - service: responsável por fazer todo o processamento do dado recebido no endpoint e repassar para um repositorio ou algum outro serviço.
  - repository: responsável pela integração com o banco de dados
  
O projeto foi desenvolvido com algumas tecnologias de mercado:

 - JAVA 8 e Spring Framework:
    - spring boot: facilita bastante na configuração do projeto, sendo assim seu projeto está no ar muito mais rápido com um  server já pré-configurado.
    - spring mvc: para controle das camadas de model, view e controller.
    - spring data: facil acesso a repositórios com queries mais simplificadas, rodando o hibernate e jpa por baixo, facilita bastante a conexão com o banco
    - swagger: documentar o endpoint da nossa API.
 - Docker e Docker Compose: todos os serviços estão containizados e configurado em uma única network, facilitando assim a configuração e comunicação entre os serviços (java e mysql), o mysql já sobe com alguns dados populados para teste.
 - Mysql
 
## 2. Quando você digita a URL de um site (http://www.netshoes.com.br) no browser e pressiona enter, explique da forma que preferir, o que ocorre nesse processo do protocolo HTTP entre o Client e o Server.
