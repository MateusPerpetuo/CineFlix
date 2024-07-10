# Cineflix - API REST de Séries


Este projeto é resultado do curso "Java: criando sua primeira API e conectando ao front-end" do Programa ONE Oracle + Alura. O objetivo foi criar uma API REST para fornecer dados a uma aplicação front-end, exercitando conceitos essenciais do desenvolvimento web com Java e Spring Boot.


## 📜 Processos Realizados

O projeto envolveu a integração com a API OMDb para buscar dados de séries e a API MyMemory para traduzir as sinopses para o português, já que a OMDb retorna as informações no idioma original.

Comecei criando a aplicação em Spring Boot e depois integrei com a API OMDb para puxar os dados das séries e salvá-los em um banco de dados. Para traduzir as sinopses, usei a API MyMemory, que facilitou trazer as descrições em português.

Transformei a aplicação em uma API REST, configurando o TomCat para gerenciar as requisições e criei a classe Controller para lidar com as rotas e endpoints. Usei anotações como @RestController e @GetMapping para facilitar o mapeamento das rotas e implementei uma classe de serviço para fornecer os dados ao controlador.

Por fim, habilitei as conexões com o front-end que foi disponibilizado pela Alura, permitindo que a aplicação exibisse as informações salvas no banco de dados diretamente no navegador. A aplicação agora mostra as séries, permite filtrar por categorias e exibe páginas de detalhes com todas as informações relevantes.

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

## Estrutura do Projeto

O projeto segue uma arquitetura de camadas, com as seguintes principais classes:

    SerieController: Responsável por expor os endpoints da API
    SerieService: Implementa a lógica de negócio relacionada às séries
    SerieRepository: Acessa o banco de dados para obter as informações das séries
    SerieDTO: Representa os dados de uma série de TV.
