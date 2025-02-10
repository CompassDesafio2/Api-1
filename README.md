# Micro Serviço A

Implementação de uma API que ira consumir os Endpoints oferecidos pela API B


Todo o Processamento e Manipulação e Salvamento dos Dados será realizado pela API B, então a responsábilidade da API A é de fazer a *CRIAÇÃO*, *VISUALIZAÇÃO DE POST* , ATUALIZAÇÃO E DELEÇÃO  de "*POSTAGENS*", desde que siga o padrão estabelecido pelo Endpoints da API B.

![img.png](img.png)

## Instalação

Para o uso desse Projeto será necessário a instalação tanto da [API - A](https://github.com/CompassDesafio2/Api-1.git)
Como também da [API - B](https://github.com/CompassDesafio2/Api-2.git)

Clone o [Repositorio da API B](https://github.com/CompassDesafio2/Api-2) é execute o Spring com a própria IDE, se possível;

Execute a API B
```bash
    mvn spring-boot:run  
```

O seu Swagger está disponivel na rota:

```http
http://localhost:8081/api/v1/docs/swagger-ui/index.html
```    

Verifique o log de inicialização do Spring para ver se tudo está rodando conforme o planejado.


___
#



Agora para a API A, depois de inicializar a API B e verificar que tudo rodou nos conformes.
Clone o [Repositorio da API A](https://github.com/CompassDesafio2/Api-2) é execute o Spring  e Verifique o Log da API A tmb para ver se tudo está rodando










## Documentação da API

Rota para acessar o Swagger: [localhost:8081/api/v1/docs/](http://localhost:8081/api/v1/docs/)

#### Endpoint para o Swagger

```http
  GET http://localhost:8081/api/v1/docs/
  ```


---
### Rotas de Postagens


| ROTA   | MÉTODO       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `/api/postagens/fetch-data`      | `GET` | Faz a Atualização de todos os Post e Comentários   |
| `/api/postagens/todasPostagens`      | `GET` | Retornar **TODOS os POST** salvos na aplicação |
| `/api/postagens/{id}`      | `GET` | Retornar **1 POST por ID** |
| `/api/postagens/`      | `POST` | **Criar** um novo POST |
| `/api/postagens/{id}`      | `PUT` | **Atualizar** um POST pelo ID |
| `/api/postagens/{id}`      | `DELETE` | **Deletar** um POST pelo ID |


___










## Autores
TIME do MICRO SERVICO A:
- [@Rafaelmjmj](https://github.com/Rafaelmjmj)
- [@thebabiL](https://github.com/thebabiL)


TIME do MICRO SERVICO B:
- [@educentenaro](https://github.com/educentenaro)
- [@zander404](https://www.github.com/zander404)


## Licença

[MIT](https://choosealicense.com/licenses/mit/)