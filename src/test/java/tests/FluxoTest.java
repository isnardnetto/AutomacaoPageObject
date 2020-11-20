package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PaginaDeLogin;
import suporte.Web;

import static org.junit.Assert.assertEquals;

public class FluxoTest {
    private WebDriver navegar;

    @Before
        public void setUp(){
            navegar = Web.createChrome();
        }

    @Test
    public void testNovoUsuario() {
            new PaginaDeLogin(navegar) // colocar a primeira pagina da aplicação
                    .clicarNoBotaoNovoUsuario()
                    .cadastroResumido("oladipoo","oladipoo@gmail.com","12345")
                    .clicarNoBotaoCadastrarSucesso();
    } //1

    @Test
    public void testNovoUsuarioJaCadastrado(){ // deu errado no assert
        new PaginaDeLogin(navegar)
                .clicarNoBotaoNovoUsuario()
                .cadastroResumido("Lukab","doncicd@gmail.com","12345")
                .clicarNoBotaoCadastrarSucesso();
    }//2

    @Test
    public void testLogin(){
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar();
    }//3

    @Test
    public void testLoginErro(){
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gswww")
                .clicarNoBotaoCadastrarErro();
    }//4

    @Test
    public void contasContaDuplicada (){
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .AbrirConta()
                .adicionarConta()
                .escreverConta("Conta01")
                .clicarBotaoSalvar();
    }//5

    @Test
    public void ExcluirContasEmAberto(){
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .AbrirConta()
                .clicarListarConta()
                .excluirContaEmUso()
                ;
    }//6

    @Test
    public void CriarMovimetacaoSemDataDePagamentoEmovimentacao() {
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .preeencherCamposSemDataMovimentacao("10/10/2020","Receber valor","Dwait","250","tete")
                .limparTelaDeDataDePagamento()
                .preeencherCamposSemDataPagamanto("10/10/2020","Mandar valor","Mike Scott","300","tete")
                ;
    }//7

    @Test
    public void CriarMovimetacaoDataInvalida() {
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .todosOsCamposPreenchidosDataInvalida("10/10/2020","valor","kwai","367","tete","30/30/2085")
                ;
    }//8

    @Test
    public void escolhendoUmaContaComDataFutura () {
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .todosOsCamposPreenchidosDataInvalida("01/12/2023","valor","kwai","367","tete","10/12/2020")
        ;
    }//9

    @Test
    public void SaindoDaConta () {
        new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .sair()
                ;
    }//10


    @After
    public void tearDown(){
        navegar.quit();
    }
}


//validações