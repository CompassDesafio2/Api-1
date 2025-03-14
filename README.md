﻿# Micro Serviço A

Implementação de uma API que ira consumir os Endpoints oferecidos pela API B


Todo o Processamento e Manipulação e Salvamento dos Dados será realizado pela API B, então a responsábilidade da API A é de fazer a *CRIAÇÃO*, *VISUALIZAÇÃO DE POST* , ATUALIZAÇÃO E DELEÇÃO  de "*POSTAGENS*", desde que siga o padrão estabelecido pelo Endpoints da API B.

![image](https://github.com/user-attachments/assets/0b043bb2-4c79-4a1b-be56-39e2ea9b8437)


## Instalação

Clone o [Repositorio](https://github.com/CompassDesafio2/Api-2) e execute o Spring com a própria IDE, se possível;

Se não, utilize o seguinte comando, caso tenha o Maven instalado em seu computador.

```bash
    mvn spring-boot:run  
```

OBS: Sera necessário ter Docker instalado no computador para a execução dos teste, banco de dados mongo para teste está sendo gerando pelo conainers do Spring


Verifique o log de inicialização do Spring para ver se tudo está rodando conforme o planejado.

Agora para a API A, depois de inicializar a API B e verificar que tudo rodou nos conformes.
Clone o [Repositorio da API A](https://github.com/CompassDesafio2/Api-2) é execute o Spring  e Verifique o Log da API A tmb para ver se tudo está rodando


## Documentação da API

Rota para acessar o Swagger: [localhost:8081/api/v1/docs/](http://localhost:8081/api/v1/docs/)

#### Endpoint para o Swagger

```http

    http://localhost:8081/api/v1/docs/
```


---
### Rotas de Postagens

| MÉTODO    | ROTA                           | Descrição                                     |
|:----------|:-------------------------------| :---------------------------------------------|
| `GET`     | `/api/postagens/todasPostagens`| Retornar **TODOS os POST** salvos na aplicação|
| `GET`     | `/api/postagens/{id}`          | Retornar **1 POST por ID**                    |
| `POST`    | `/api/postagens/`              | **Criar** um novo POST                        |
| `PUT`     | `/api/postagens/{id}`          | **Atualizar** um POST pelo ID |
| `DELETE`  | `/api/postagens/{id}`          | **Deletar** um POST pelo ID |


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
