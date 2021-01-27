package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class InformacoesUsuarioTest {
    private WebDriver navegador;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\arquivos de programas\\Java\\chromedriver_win32\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegador.get("https://seubarriga.wcaquino.me/");
        navegador.manage().window().maximize();
    }
    @Test
    public void testNovoUsuario (){
        // --------------------- 1 // passado p PO

        //Cadastro de novo usuario
        navegador.findElement(By.linkText("Novo usuário?")).click();

        //passando o login /email /usuario
        navegador.findElement(By.name("nome")).sendKeys("CurryGsw2018");
        navegador.findElement(By.name("email")).sendKeys("Curry30gsw2018@gmail.com");
        navegador.findElement(By.name("senha")).sendKeys("gsw");

        //clicando em cadastrar
        navegador.findElement(By.className("btn-primary")).click();

        //validando usuario com sucesso
        WebElement alert = navegador.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Usuário inserido com sucesso", textoNoElementoAlert);

        }
    @Test
    public void testoNovoUsuarioJaCadastrado (){
        // --------------------- 2

        //Cadastro de novo usuario
        navegador.findElement(By.linkText("Novo usuário?")).click();

        //passando o login /email /usuario
        navegador.findElement(By.name("nome")).sendKeys("Curry");
        navegador.findElement(By.name("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.name("senha")).sendKeys("gsw");

        //clicando em cadastrar
        navegador.findElement(By.className("btn-primary")).click();

        //validando usuario
        WebElement alert = navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Endereço de email já utilizado", textoNoElementoAlert);

    }

    @Test
    public void testLogin () {
        //------------------------------------- 3
        //Testando login com usuario cadastrado

        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //---------------------------------
        //validando usuario cadastrado
        WebElement alert = navegador.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Bem vindo, Curry!", textoNoElementoAlert);

    }

    @Test
    public void testLoginErro () {
        //------------------------------------- 4
        //Testando login com usuario cadastrado

        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("123");//senha errada
        navegador.findElement(By.className("btn-primary")).click();

        //---------------------------------
        //validando usuario cadastrado
        WebElement alert = navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Problemas com o login do usuário", textoNoElementoAlert);
    }

    @Test
    public void contasContaDuplicada (){
        //------------------------------------- 5
        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //criar uma conta duplicada
        navegador.findElement(By.className("dropdown-toggle")).click();
        navegador.findElement(By.linkText("Adicionar")).click();
        navegador.findElement(By.id("nome")).sendKeys("contaTeste3");
        navegador.findElement(By.className("btn-primary")).click();

        //validar mensagem : "Já existe uma conta com esse nome!"
        WebElement alert = navegador.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Já existe uma conta com esse nome!", textoNoElementoAlert);

    }

    @Test
    public void contasExcluirContasEmAberto (){
        //----------------------------------------- 6
        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //excluir uma conta em uso
        navegador.findElement(By.className("dropdown-toggle")).click();
        navegador.findElement(By.linkText("Listar")).click();
        WebElement alert = navegador.findElement(By.xpath("//tbody/tr[4]/td[2]/a[2]/span[1]"));
        alert.click();

        //Validando mensagem "Conta em uso na movimentações"
        WebElement alerta = navegador.findElement(By.xpath("//div[contains(text(),'Conta em uso na movimentações')]"));
        String textoNoElementoAlert = alerta.getText();
        assertEquals("Conta em uso na movimentações", textoNoElementoAlert);

    }

    @Test
    public void CriarMovimetacaoSemDataDePgtoEmovimentacao () {
        //--------------------------- 7

        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //clicar Botão criar movimentação
        navegador.findElement(By.linkText("Criar Movimentação")).click();

        // preencher formulario faltando data de movimentação e data de pagamento
        navegador.findElement(By.id("descricao")).sendKeys("Pagamento feito");//
        navegador.findElement(By.id("interessado")).sendKeys("Draimond Green");//
        navegador.findElement(By.id("valor")).sendKeys("700");//
        navegador.findElement(By.id("conta")).sendKeys("contaTeste 2");//
        navegador.findElement(By.id("status_pago")).click();//
        navegador.findElement(By.id("data_pagamento")).sendKeys("10/12/2020");//
        navegador.findElement(By.className("btn-primary")).click();//


        // validando a mensagens "Data da Movimentação é obrigatório"
        WebElement alerta = navegador.findElement(By.xpath("//body/div[1]"));
        String textoNoElementoAlert = alerta.getText();
        assertEquals("Data da Movimentação é obrigatório", textoNoElementoAlert);

        //validando a mensagem "Data do pagamento é obrigatório"
        navegador.findElement(By.id("data_pagamento")).clear();
        navegador.findElement(By.id("data_transacao")).sendKeys("10/09/2020");
        navegador.findElement(By.className("btn-primary")).click();

        WebElement alertaPagamanto = navegador.findElement(By.xpath("//body/div[1]"));
        String textoNoElementoAlerta = alertaPagamanto.getText();
        assertEquals("Data do pagamento é obrigatório", textoNoElementoAlerta);

    }



    @Test
    public void CriarMovimetacaoDataInvalidaa() {
        //--------------------------------------------------- 8
        //validando a mensagem Data do pagamento inválida (DD/MM/YYYY)

        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //clicar Botão criar movimentação
        navegador.findElement(By.linkText("Criar Movimentação")).click();

        // preencher formulario com data invalida
        navegador.findElement(By.id("descricao")).sendKeys("Pagamento feito");
        navegador.findElement(By.id("interessado")).sendKeys("Draimond Green");
        navegador.findElement(By.id("valor")).sendKeys("700");
        navegador.findElement(By.id("conta")).sendKeys("contaTeste 2");
        navegador.findElement(By.id("status_pago")).click();
        navegador.findElement(By.id("data_transacao")).sendKeys("10/09/2020");
        navegador.findElement(By.id("data_pagamento")).sendKeys("2020/13/13");
        navegador.findElement(By.className("btn-primary")).click();

        //validando a mensagem "Data do pagamento inválida (DD/MM/YYYY)"
        WebElement alertaPagamanto = navegador.findElement(By.xpath("//body/div[1]"));
        String textoNoElementoAlerta = alertaPagamanto.getText();
        assertEquals("Data do pagamento inválida (DD/MM/YYYY)", textoNoElementoAlerta);

    }

    @Test
    public void escolhendooUmaContaComDataFutura () {
        // --------------------- 9
        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //clicar Botão criar movimentação
        navegador.findElement(By.linkText("Criar Movimentação")).click();

        // preencher formulario com data futura
        navegador.findElement(By.id("descricao")).sendKeys("Pagamento feito");
        navegador.findElement(By.id("interessado")).sendKeys("Draimond Green");
        navegador.findElement(By.id("valor")).sendKeys("700");
        navegador.findElement(By.id("conta")).sendKeys("contaTeste 2");
        navegador.findElement(By.id("status_pago")).click();
        navegador.findElement(By.id("data_transacao")).sendKeys("01/12/2023");
        navegador.findElement(By.id("data_pagamento")).sendKeys("10/12/2020");
        navegador.findElement(By.className("btn-primary")).click();

        //validando a mensagem "Data do pagamento inválida (DD/MM/YYYY)"
        WebElement alertaPagamanto = navegador.findElement(By.xpath("//body/div[1]"));
        String textoNoElementoAlerta = alertaPagamanto.getText();
        assertEquals("Data da Movimentação deve ser menor ou igual à data atual", textoNoElementoAlerta);


    }
    @Test
    public void SaindoDaConta (){
        // --------------------- 10
        //login com usuario cadastrado
        navegador.findElement(By.id("email")).sendKeys("Curry30@gmail.com");
        navegador.findElement(By.id("senha")).sendKeys("gsw");
        navegador.findElement(By.className("btn-primary")).click();

        //Clicando botão de logOut
        navegador.findElement(By.linkText("Sair")).click();

        //validando a mensagem na homePage
        WebElement alertaPagamanto = navegador.findElement(By.className("btn-primary"));
        String textoNoElementoBtn = alertaPagamanto.getText();
        assertEquals("Entrar", textoNoElementoBtn);

    }
        @After
    public void tearDown(){
        //navegador.quit();
    }

}
