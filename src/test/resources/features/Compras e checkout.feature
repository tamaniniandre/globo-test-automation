#language: pt
@UiTests
  Funcionalidade: Compras e checkout

    Cenario: Adicionar vestidos para o carrinho e validar carrinho de checkout
      Dado que clicado no menu 'Women'
      E que adicionado a lista de produtos aos carrinho na pagina de mulheres
      |Faded Short Sleeve T-shirts|
      |Blouse                     |
      |Printed Dress              |
      Quando clicar para fazer o checkout na tela principal
      Então Validar se os produtos estão corretamentes adicionados ao carrinho
      E Validar se o valor total é igual a somatória dos itens adicionados