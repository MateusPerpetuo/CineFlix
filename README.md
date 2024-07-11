# Cineflix - API REST de Séries


Este projeto é resultado do curso "Java: criando sua primeira API e conectando ao front-end" do Programa ONE Oracle + Alura. O objetivo foi criar uma API REST para fornecer dados a uma aplicação front-end, exercitando conceitos essenciais do desenvolvimento web com Java e Spring Boot.


## 📜 Processos Realizados

Inicialmente, criei a aplicação Cineflix em Java usando Spring Boot. Em seguida, implementei a integração com a API OMDb para buscar dados de séries, armazenando essas informações em um banco de dados relacional. Devido ao fato da API OMDb retornar as sinopses no idioma de origem das séries, utilizei a API MyMemory para traduzir essas sinopses para o português, garantindo uma melhor experiência ao usuário final.

Para transformar a aplicação em uma API REST, adicionei a dependência Web ao projeto e configurei o TomCat como servidor local para gerenciar requisições. Criei a classe Controller para receber e processar as requisições, utilizando anotações como @RestController, @RequestMapping e @GetMapping para mapear rotas e endpoints. Também implementei uma classe de serviço anotada com @Service para fornecer dados ao controlador, separando as responsabilidades e promovendo uma arquitetura mais limpa e modular.

Por fim, habilitei as conexões com o front-end fornecido pela Alura, permitindo que a aplicação retornasse as informações armazenadas no banco de dados para serem exibidas no navegador. Finalizei a implementação de todas as rotas necessárias, permitindo a visualização das séries, a filtragem por categorias e o acesso a uma página de detalhes com informações completas sobre temporadas e episódios.

## ✨ Funcionalidades

- **API REST**: Transformação da aplicação Cineflix em uma API REST.
- **Spring Boot**: Utilização do Spring Boot para configurar e executar a aplicação com um servidor embutido.
- **Controller**: Criação da classe responsável por receber as requisições.
- **Anotações Spring**: Utilização de @RestController, @RequestMapping, @GetMapping, entre outras.
- **Serviços**: Implementação de classes de serviço com @Service para fornecer dados ao controlador.
- **Rotas e Requisições**: Implementação completa das rotas esperadas pelo front-end.
- **Filtros e Detalhes**: Criação de filtros por categorias e páginas de detalhes com dados de todas as temporadas e episódios.

## 📚 Tecnologias Utilizadas

- ![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-%236DB33F.svg?style=for-the-badge&logo=spring-boot&logoColor=white)
- ![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
- ![Google API](https://img.shields.io/badge/Google%20API-%234285F4.svg?style=for-the-badge&logo=google&logoColor=white)
- ![Maven](https://img.shields.io/badge/Maven-%23C71A36.svg?style=for-the-badge&logo=apache-maven&logoColor=white)

## Imagens

### O front exibindo os dados da API Rest

![image](https://github.com/MateusPerpetuo/Cineflix-API-REST-de-Series/assets/129229556/d2d5ae74-0fb3-44f2-8fbf-d87ef350a65c)

![image](https://github.com/MateusPerpetuo/Cineflix-API-REST-de-Series/assets/129229556/682ecf46-f00a-4a9d-bc29-580e023c0201)

![image](https://github.com/MateusPerpetuo/Cineflix-API-REST-de-Series/assets/129229556/5709d8fe-5cf5-4e9c-afe4-4da986152b83)

### O banco de dados

![image](https://github.com/MateusPerpetuo/Cineflix-API-REST-de-Series/assets/129229556/fccac65f-dec1-4ea8-9777-4aa6ded5cd92)

![image](https://github.com/MateusPerpetuo/Cineflix-API-REST-de-Series/assets/129229556/2cba0c0a-80fa-49e4-87e9-628b7a53fc1c)



