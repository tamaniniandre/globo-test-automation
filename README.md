# globo-test-automation

[![Badge ServeRest](https://img.shields.io/badge/API-ServeRest-green)](https://github.com/ServeRest/ServeRest/)

**Como executar:**
- Para baixar o projeto: 
  git clone https://github.com/tamaniniandre/globo-test-automation.git
- Para execução do teste de UI:
  - Importa-lo como Maven Project em sua IDE de prerência (Eclipse ou Intellij)
  - Clicar com o botão direito no runner: src/test/java/com/globo/test/automation/runners/RunSerenityUITests.java 
  - E então clique Run RunSerenityUITests.java 
- Para execução do teste de BE:
  - Clicar com o botão direito no runner: src/test/java/com/globo/test/automation/runners/RunSerenityWSTests.java
  - E então clique em: Run RunSerenityWSTests.java
  - A features desenvolvidas se encontram na pasta: src/test/resources/features
  
  **Caso tenha algum problema com as dependências:**
    - Execute o comando: mvn clean
    - Execute o comando: mvn install
    - Faça um Maven Upload Dependencies
