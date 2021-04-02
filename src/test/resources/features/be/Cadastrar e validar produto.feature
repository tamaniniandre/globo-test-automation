#language: pt

@ServiceTests
Funcionalidade: Cadastrar e validar produto


  Cenario: 1- Testar o cadastro e consulta do produto com sucesso
    Dado que cadastrado um novo produto com sucesso com os valores
      |nome              |preco |descricao       | quantidade |
      |[[Randomico]]     | 7500 |cenário teste 1 | 10         |
    Quando consultar com sucesso o produto inserido
    Então os dados do produto consultado devem estar corretos

  Cenario: 2- Testar exclusão e consulta do produto inexistente
    Dado que cadastrado um novo produto com sucesso com os valores
      |nome              |preco |descricao       | quantidade |
      |[[Randomico]]     | 1855 |cenário teste 2 | 1         |
    Quando deletar com sucesso o produto inserido
    Então o produto não deve ser encontrado na pesquisa

  Cenario: 3- Testar atualização e consulta do produto
    Dado que cadastrado um novo produto com sucesso com os valores
      |nome              |preco |descricao       | quantidade |
      |[[Randomico]]     | 200  |cenário teste 3 | 2          |
    Quando atualizar os valores do produto para
      |nome              |preco |descricao                | quantidade |
      |[[Randomico]]     | 100  |cenário teste 3 alterado | 10         |
    E consultar com sucesso o produto atualizado
    Então os dados do produto devem estar atualizados

  Cenario: 4- Testar o cadastro de vários produtos e verifica-los se são encontrados na lista
    Dado que cadastrado vários produtos com sucesso com os valores
      |nome              |preco |descricao           | quantidade |
      |[[Randomico]]     | 200  |cenário teste 4 - 1 | 2          |
      |[[Randomico]]     | 600  |cenário teste 4 - 2 | 2          |
      |[[Randomico]]     | 800  |cenário teste 4 - 3 | 2          |
      |[[Randomico]]     | 200  |cenário teste 4 - 4 | 2          |
    Quando consultar a lista de todos os produtos
    Então os produtos inseridos devem estar presentes na lista