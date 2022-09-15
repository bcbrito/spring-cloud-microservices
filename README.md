# JavaSpringCloud
Aprenda comigo Microservices com Spring Cloud: Registry, Config Server e Distributed Tracing

### 1 - Configurando o Ambiente

**Requisitos**:

[Spring Tools](https://spring.io/tools)

[Postman](https://www.postman.com/downloads/)

### 2- Quebrando em microserviços (Modelagem)

- Qual o principal foco na modelagem de microsserviços?

    A separação da modelagem da nossa aplicação em contextos coesos e independentes uns dos outros

    Alternativa correta! Cada contexto da nossa modelagem possui necessidades específicas e sua independência do resto da aplicação induz ao baixo acoplamento. Com isso, temos mais facilidade de lidar com questões técnicas, que são fortemente influenciadas pelos requisitos funcionais e não funcionais do negócio que estamos informatizando.

- Qual a solução a ser implementada no curso
    - Teremos três microsserviços: `Fornecedor`, `Loja` e `Transportador`
- Uma apresentação da modelagem focado em **DDD** (*Domain Driven Design*)
    - Quebraremos o domínio em *contextos menores* (*bounded context*)
    - Um microsserviço é a **implementação de um contexto**
- O uso do **Postman** como cliente HTTP
- A criação do microsserviço `Loja` usando **Spring Boot**

### 3- Service Registry com Eureka ?

- A integração entre microsserviços com RestTemplate
    - O RestTemplate do Spring permite chamadas HTTP de alto nível
- Um introdução ao Service discovery e Service registry
    - Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
    - Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
    - Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta

- A implementação do service registry através do Eureka Server
- Como registrar da Loja e do Fornecedor no Eureka Server
- A resolução do IP/porta através do nome do microsserviço nas requisições

O que muda na nossa aplicação através do uso do Service Discovery?

    Nas requisições REST que implementamos, passamos apenas o nome da outra aplicação. O Spring substitui automaticamente o nome pelo IP. Os microsserviços não         precisam conhecer o endereço IP das outras aplicações, mas apenas o nome que elas se registraram no Eureka.

Referência: https://cursos.alura.com.br/course/microservices-spring-cloud-service-registry-config-server
