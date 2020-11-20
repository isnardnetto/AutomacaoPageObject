# BVTesteSenhorBarriga

Esse projeto visa automatizar o site "https://srbarriga.herokuapp.com/login"

*PRÉ-REQUESITOS:
Stack usada : * Java (JDK 1.8.0_271) * Selenium * ChromeDrive(Versão 86.0.4240.83) * Junit * Intellij IDE
- O Java pode ser baixado no link:(https://www.java.com/pt-BR/download/ie_manual.jsp?locale=pt_BR)
- O Selenium pode ser baixado no link:https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
- O Junit pode ser baixado no link:(https://mvnrepository.com/artifact/junit/junit/4.12)
- O ChromeDrive pode ser baixado no link:(https://chromedriver.chromium.org/downloads)
- A IDE Intellij pode ser baixado no link:(https://www.jetbrains.com/pt-br/idea/download/#section=windows)


*INSTALAÇÃO:
- Crie um novo projeto no Intellij IDE e marque a opção MAVEM.
- Na pasta pom.xml adicione as dependencias do Selenium e do Junit.
- Após adicionar as dependencias no pom.xml atualize a página.
- Abra a pasta "test"  e dentro da mesma terá a pasta "Java" , nessa pasta crie uma package com o nome
"tests" por exemplo , dentro dessa package ficarão as classes de teste.
- após criar a package "tests" crie uma classe de testes para iniciar a codificação.

*EXECUTANDO OS TESTES
- Para rodar os testes automatizados , basta clicar no icone de "play"
ao lado dos metodos criados
- Cada método remete a um teste automatizado
obs: para acompanhar os testes passo a passo mais detalhadamente seria
necessário comentar o código //navegador.quit() no fim do código.


Obs 1: Os casos de teste estão elencadas no proprio código.

obs 2: Necessário se atentar a versão do navegador Chrome , pois deve ser compatível com a versão do ChromeDrive.

obs 3: Necessario observar o diretorio que o executavel do chromeDrive ,pois é preciso esta no caminho certo para que a aplicação suba corretamente.
Ex: System.setProperty("webdriver.chrome.driver", "C:\\arquivos de programas\\Java\\chromedriver_win32\\chromedriver.exe");(esse caminho nesse formato so funciona
com o sistema operacinal windows)
