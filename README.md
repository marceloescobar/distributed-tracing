Teste de observabilidade com Spring Cloud Sleuth e Zipkin
Teste simples para trace de log. Projeto simples com as APIs exposta (/path1 e /path2), 

/path1
API que realiza a chamada de outro serviço exposto em http://localhost:8090/service/path2

/path2
somente exibe o log da chamada.

Baixe o projeto.

Rode o projeto:
mvn clean verify

Suba a instancia do Zipkin atraves do comando:
docker-compose up

Suba 2 instancias do servico:

java -jar target/Distributed-Service-0.0.1-SNAPSHOT.jar --spring.application.name=Service-1 --server.port=8080

java -jar target/Distributed-Service-0.0.1-SNAPSHOT.jar --spring.application.name=Service-2 --server.port=8090

Excute a chamada:
http://localhost:8080/service/path1

Acesse o painel do Zipkin atraves da url abaixo para visualizar os logs.
http://localhost:9411/zipkin/

