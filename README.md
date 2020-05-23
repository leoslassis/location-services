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

HTTP é um protocolo utilizado para a comunicação de clientes e servidores. 

Os clientes são os responsáveis por fazerem as requisições e os servidores responsáveis por responder essa requisição (conhecidos como requests e responses).

O cliente normalmente faz solicitaçao de algum recurso (resource), enviando algumas informações (body) contendo alguns cabeçalhos(headers) a uma determinada "URL" e o servidor recebe essa requisição e manda uma resposta, podendo conter cabeçalhos tambem para esse cliente.

Esses cabeçalhos(headers) enviado pelo cliente contem informações bastante uteis para o servidos, como qual é o path que foi solicitado, qual o metodo HTTP, e até mesmo o host de identificação do cliente. O servidor recebe todos esses dados e por fim consegue identificar atraves dos cabeçalhos o que deve ser feito(metodo HTTP e path), gerando assim uma resposta para esse cliente, nessa resposta normalmente contem o HTTP status daquela requisição, o que o cliente pode identificar se houve falha ou sucesso na requisição e tratar da maneira que convem.


Então ao chamar a URL http://www.netshoes.com.br, estamos fazendo uma requisição para algum servidor da netshoes, passando o metodo GET, dizendo que queremos receber os recursos daquela URL. O servidor por si, identifica essa requisição e nos responde se foi ok, atraves do seu status, e nos retornar algum tipo mensageria, mas provavelmente nesse caso eles nos devolve um html, onde é montado toda a interface do site.

Obs: normalmente existem alguns proxys entre essa comunicação cliente e servidor.
