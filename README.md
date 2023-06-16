[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=mateusfsn_LibroLead&metric=alert_status&token=fcff2795b6fd39f1bad97fb60bb78673d52b57b3)](https://sonarcloud.io/summary/new_code?id=mateusfsn_LibroLead)
[![Java CI with Maven](https://github.com/mateusfsn/LibroLead/actions/workflows/maven_build.yml/badge.svg?branch=master)](https://github.com/mateusfsn/LibroLead/actions/workflows/maven_build.yml)

# **LibroLead**

### **Integrantes:**
- Eduardo Fiuza Cruz
- Lucas Pereira Carvalho
- Mateus Brandao Damasceno Goes
- Mateus Costa de Oliveira

### **Sistema**
**LibroLead** é uma API REST de gerenciamento de bibliotecas desenvolvida em Java. Através de seus endpoints, é possível gerenciar e consultar os registros de autores, editoras, usuários e livros. O sistema organiza a autenticação e autorização dos usuários, permitindo a consulta, busca, criação e listagem desses elementos. Todos os endpoints da interface podem ser consultados nessa tabela: [Tabela](https://docs.google.com/document/d/1A3nKfOAasSqQs-dbhclDPtOOHfQnMLflcsdfgHxr-xA/edit?usp=sharing)

### **Tecnologias utilizadas**


- **Java**: Linguagem de programação orientada a objetos, popularmente conhecida por sua portabilidade e robustez. Foi escolhida para este projeto pela sua facilidade de integração com diversas tecnologias e pela segurança oferecida.

- **Spring Boot**: Framework que simplifica a configuração e o desenvolvimento de aplicações em Java. Foi adotado devido a sua facilidade de uso, configuração automática e integração com o Maven.

- **Maven**: Ferramenta de gerenciamento de projetos e dependências. Foi escolhida por sua capacidade de simplificar o processo de compilação e garantir a compatibilidade das dependências.

- **Lombok**: Biblioteca Java que ajuda a reduzir o código boilerplate. Fornece anotações que podem ser usadas para gerar automaticamente códigos como getters, setters, construtores e muito mais. Foi adotado para tornar o código mais limpo e conciso.

- **SonarCloud**: Serviço de análise de código em nuvem. Utilizado para garantir a qualidade do código, detectando vulnerabilidades, bugs e cheirinhos de código.

- **TravisCI**: Serviço de integração contínua usado para construir e testar projetos hospedados no GitHub. Foi utilizado para garantir que todas as alterações sejam testadas antes de serem implementadas.

- **Heroku**: Plataforma como Serviço (PaaS) que permite aos desenvolvedores construir, executar e operar aplicações inteiramente na nuvem. Foi utilizado para hospedar a API.

- **SDKMan!**: Ferramenta para gerenciar versões paralelas de múltiplos SDKs no sistema operacional. Foi utilizado para simplificar o processo de instalação e mudança entre diferentes versões do SDK Java.

- **H2**: Banco de dados em memória escrito em Java. Foi escolhido por ser leve, rápido e com um bom suporte para testes de integração.

- **IntelliJ IDEA Community Edition**: Ambiente de desenvolvimento integrado (IDE) para o desenvolvimento de software em Java. Foi escolhido por sua interface amigável e recursos poderosos de codificação, depuração e refatoração.

- **Git/Github**: Sistema de controle de versões distribuído e plataforma de hospedagem de código, respectivamente. Foram utilizados para o controle de versões e colaboração entre os desenvolvedores.

- **Swagger 2**: Ferramenta para documentação de APIs REST. Foi utilizada para criar a documentação do projeto de forma automática e interativa.

### **Guia de instalação e uso**:

- Clone o projeto com : $ git clone https://github.com/mateusfsn/LibroLead.git
- Instale o Java SDK 11.0.12-open e o Maven versão 3.9.1 utilizando o SDKMan!.
- Instale o IntelliJ IDEA Community Edition.
- Configure o projeto no IntelliJ: “Build and run: com.finalproject.librolead.LibroleadApplication”.
- Realize os requests apontando para localhost:8080 e siga a documentação dos guias de endpoint.

