# Exercício 10: Modelagem REST

## Serviço Escolhido:

* Rede Social Facebook
  
      * Grude de fotos

### Casos de uso:

- Acessar informações de uma foto
- Manipular informações de uma foto
- Acessar informações de um álbum
- Manipular informações de um álbum

### Recursos

- fotos
- albuns

### Endpoints

| Descrição                    | URI                       | Método HTTP | Corpo                                                                                                       | Resposta Esperada | Erros Esperados                                  |
|------------------------------|---------------------------|-------------|-------------------------------------------------------------------------------------------------------------|--------------------|-------------------------------------------------|
| Retornar uma foto            | `GET /fotos/{foto-id}`    | `GET`       | Vazio                                                                                                       | `200 OK`           | `404 Not Found` - foto não foi encontrada.      |
| Inserir uma nova foto        | `POST /fotos`             | `POST`      | `{ "titulo": "Praia", "descricao": "Foto da praia ao pôr do sol", "usuarioId": "3", "data": "2023-10-30", "url": "http://example.com/foto.jpg" }` | `201 Created`       | `400 Bad Request` - dados inválidos.            |
| Atualizar foto               | `PUT /fotos/{foto-id}`    | `PUT`       | `{ "titulo": "Praia (Editada)", "descricao": "Foto da praia ao pôr do sol, editada" }`                    | `200 OK`           | `404 Not Found` - foto não foi encontrada.      |
| Deletar foto                 | `DELETE /fotos/{foto-id}` | `DELETE`    | Vazio                                                                                                       | `200 OK`    | `404 Not Found` - foto não foi encontrada.      |
| Retornar um álbum            | `GET /albuns/{album-id}`  | `GET`       | Vazio                                                                                                       | `200 OK`           | `404 Not Found` - álbum não foi encontrado.     |
| Criar um novo álbum          | `POST /albuns`            | `POST`      | `{ "titulo": "Viagens", "descricao": "Álbum de fotos das minhas viagens", "usuarioId": "3", "data_criacao": "2023-10-30" }` | `201 Created`       | `400 Bad Request` - dados inválidos.            |
| Editar álbum                 | `PUT /albuns/{album-id}`  | `PUT`       | `{ "titulo": "Viagens (Atualizado)", "descricao": "Álbum de fotos das minhas viagens, atualizado" }`   | `200 OK`           | `404 Not Found` - álbum não encontrado.         |
| Excluir álbum                | `DELETE /albuns/{album-id}`| `DELETE`    | Vazio                                                                                                       | `200 OK`    | `404 Not Found` - álbum não encontrado.         |
| Adicionar foto ao álbum      | `POST /albuns/{album-id}/fotos` | `POST`  | `{ "fotoId": "125", "titulo": "Nova Foto", "descricao": "Descrição da nova foto" }`                     | `201 Created`       | `404 Not Found` - álbum não encontrado.         |
| Excluir foto do álbum        | `DELETE /albuns/{album-id}/fotos/{foto-id}` | `DELETE` | Vazio                                                                                                       | `200 OK`    | `404 Not Found` - álbum ou foto não encontrada. |
