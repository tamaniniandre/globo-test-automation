#language: pt

  Funcionalidade: Compras e checkout area logada

    Cenario: Adicionar vestidos para o carrinho e validar carrinho de checkout
      Dado que clicado no menu 'Women'
      E que adicionado a lista de produtos aos carrinho na pagina de mulheres
      |Faded Short Sleeve T-shirts|
      |Blouse                     |
      |Printed Dress              |
      Quando realizar clicar para fazer o checkout
      Então Validar se os produtos estão corretamentes adicionados ao carrinho
      E Validar se o valor total é igual a somatória dos itens adicionados