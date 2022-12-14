# Microservices com Spring Cloud: Registry, Config Server e Distributed Tracing

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

### 3- Service Registry com Eureka \o/

- A integração entre microsserviços com RestTemplate
    - O RestTemplate do Spring permite chamadas HTTP de alto nível
- Um introdução ao Service discovery e Service registry
    - Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
    - Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
    - Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta

- A implementação do service registry através do Eureka Server
- Como registrar da Loja e do Fornecedor no Eureka Server
- A resolução do IP/porta através do nome do microsserviço nas requisições

- O que muda na nossa aplicação através do uso do Service Discovery?
    - Nas requisições REST que implementamos, passamos apenas o nome da outra aplicação. O Spring substitui automaticamente o nome pelo IP. Os microsserviços não         precisam conhecer o endereço IP das outras aplicações, mas apenas o nome que elas se registraram no Eureka.

### 4 - Spring Config Server

- Que um servidor de configuração é o lugar central para definir as configurações dos serviços
- Que todas as configurações dos microsserviços devem ficar externalizadas e centralizadas
- Que o Spring Config Server é uma implementação do servidor do projeto Spring Cloud
- Sobre a integração dos microsserviços com o servidor de configuração
- Para tal, devemos configurar o nome do microsserviço, profile e URL do Config Server
- Que existem várias formas de definir um repositório de configurações, entre elas o GitHub

- Temos algumas tecnologias trabalhando em conjunto para prover a funcionalidade de Load Balancing. Como elas estão integradas?

- Era muito comum que o tamanho do ambiente de produção fosse estável e sempre pronto para atender uma determinada demanda conhecida. O que difere, nas aplicações de microsserviços, que gera a necessidade de uma configuração automatizada?

- Os microsserviços são preparados para um ambiente (cloud), cuja precificação é diretamente relacionada à quantidade de máquinas e ao uso de seus recursos de infraestrutura. Para reduzir esse custo, aplicações de microsserviços se encaixam bem, pois é possível escalar automaticamente, de acordo com a demanda, e em questão de segundos, pedaços do que antes era uma única aplicação. Nesse cenário, configurar manualmente os servidores com as configurações necessárias para cada aplicação é impraticável.

- A necessidade de separar as configurações em arquivos diferentes não serve apenas para uma organização melhor, mas, no caso do Spring, para que certas configurações estejam disponíveis em momentos diferentes.

- O arquivo bootstrap.yml é carregado em um contexto com maior precedência, chamado de Bootstrap Application Context. É neste contexto que o Spring Cloud Config Client se conecta ao configuration server, baixa e disponibiliza as variáveis de ambiente para o Spring Application Context, que é o contexto da nossa aplicação.

### 5 - Load Balancer e Spring Feign
    
- Load Balancing é o processo de distribuir as requisições vindas dos usuários para as várias instâncias disponíveis. Como funciona o Client Side Load Balancing que estamos utilizando nas requisições da loja?
    - De fato, a cada requisição, o Ribbon rotaciona para uma instância diferente. Todavia, é possível customizar o algoritmo de load balancing, como pode ser visto na documentação.

- Que o Client Side Load Balancing (CSLB) é o cliente HTTP que decide qual microsserviço recebe a requisição
- Isto é importante, pois pode ter várias instâncias do mesmo serviço no ar
- A configuração do CSLB é feita a partir da anotação @LoadBalanced, na criação do RestTemplate
- Como implementação do CSLB, usamos um projeto chamado Ribbon, que faz parte do Spring Cloud Netflix
- Para descobrir quais clientes existem, podemos injetar a interface DiscoveryClient
- Como alternativa ao RestTemplate, podemos usar o Spring Feign, que já usa o Ribbon para CSLB
- O Spring Feign exige apenas uma interface, com a definição e mapeamento dos métodos que executarão a requisição
- Toda a implementação da interface é gerada pelo Spring Feign


### 6 - Distributed Tracing e Spring Sleuth

- Como a geração dos logs são impactados com a arquitetura em microsserviços?
    - Assim como nos sistemas monolíticos, temos logs separados em máquinas diferentes, mas, apenas nos microsserviços, a lógica de negócio também está quebrada em logs diferentes.
    - Como estamos vendo, uma requisição do usuário bate em várias aplicações diferentes, para que a lógica de negócio requerida seja realizada. Com isso, acompanhar os logs gerados em uma transação não é tão simples quanto abrir um único log e ter toda a informação disponível.

- O que ganhamos com agregação de logs e a geração de ID de correlação?
    - Além da facilidade de acessar em um único local todo o log gerado pela aplicação, temos também a possibilidade de filtrar os logs em uma única transação. Com isso, através da formatação adequada do log, sabemos não só onde os erros foram gerados, mas em que momento aconteceu, pois os logs são escritos com os dados de milissegundos logo no início da linha. É exatamente esse o ponto. Precisamos não apenas acessar os logs, mas tê-los contextualizados com os outros logs gerados na mesma transação.

- Como se trata de uma arquitetura distribuída, temos logs distribuídos
    - Ou seja, cada microsserviço (e instância dele) possui o seu log
    - Isso dificulta o acompanhamento e **rastreabilidade das requisiçõe**s

- Para unificar os logs, precisamos de **agregadores de log**
    - Como implementação de um agregador, usamos o **Papertrail**, um agregador como serviço

- Usamos a biblioteca **Logback** para gerar e enviar os logs ao agregador
    - O **Logback** possui um appender, que possibilita o envio dos logs

- Para acompanhar uma transação nos logs, usamos uma **correlation-id**
    - A correltation-id é um identificador da transação, que é passada de requisição pra requisição
    - Dessa forma, podemos entender quais requisições fazem parte da mesma transação

- A biblioteca **Spring Sleuth**, que é usada para gerar a correlation-id

Referência: https://cursos.alura.com.br/course/microservices-spring-cloud-service-registry-config-server



