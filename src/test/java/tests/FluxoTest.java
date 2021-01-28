package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PaginaDeLogin;
import suporte.Web;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "FluxoTestData.csv" )
public class FluxoTest {
    private WebDriver navegar;

    @Before
        public void setUp(){
            navegar = Web.createChrome();
        }

    @Test
    public void testNovoUsuario(
            @Param(name="nome")String nome,
            @Param(name="email")String email ,
            @Param(name="senha")String senha,
            @Param(name="mensagemEperada")String mensagemEperada
    ) {
           String validacaoNovoUsuario = new PaginaDeLogin(navegar)
                    .clicarNoBotaoNovoUsuario()
                    .cadastroResumido(nome,email,senha)
                    .clicarNoBotaoCadastrarSucesso()
                    .ValidacaoTextoTesteNovoUsuario();

           assertEquals(mensagemEperada,validacaoNovoUsuario);
    }

    @Test
    public void testNovoUsuarioJaCadastrado(){
        String ValidacaoUsuarioJaUltilizado = new PaginaDeLogin(navegar)
                .clicarNoBotaoNovoUsuario()
                .cadastroResumido("Lukab","doncicd@gmail.com","12345")
                .clicarNoBotaoCadastrarErro()
                .ValidacaoTextoTesteUsuarioJaUltilizado();

        assertEquals("Endereço de email já utilizado",ValidacaoUsuarioJaUltilizado);

    }

    @Test
    public void testLogin(){
        String validandoUmUsuarioCadastrado = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .validandoTextoUsuarioCadastrado();

        assertEquals("Bem vindo, curry!",validandoUmUsuarioCadastrado);

    }

    @Test
    public void testLoginErro(){
       String senhaErrada = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gswww")
                .clicarNoBotaoCadastrarErro()
                .valindandoSenhaErrada();

        assertEquals("Problemas com o login do usuário",senhaErrada);
    }

    @Test
    public void contasContaDuplicada (){
      String ContaDuplicada = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .AbrirConta()
                .adicionarConta()
                .escreverConta("contaTeste3")
                .clicarBotaoSalvar()
                .valindandoContaDuplicada();

        assertEquals("Já existe uma conta com esse nome!",ContaDuplicada);
    }

    @Test
    public void ExcluirContasEmAberto(){//problema nesse
        String ValidarContaEmUso  = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .AbrirConta()
                .clicarListarConta()
                .excluirContaEmUso()
                .ValidarTextoContaEmUso()
                ;

        assertEquals("Conta em uso na movimentações", ValidarContaEmUso);
    }

    @Test
    public void CriarMovimetacaoSemDataDePagamentoEmovimentacao() {
        String SemDataMovimentacao = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .preeencherCamposSemDataMovimentacao("10/10/2020","Receber valor","Dwait","250","tete")
                .limparTelaDeDataDePagamento()
                .preeencherCamposSemDataPagamanto("10/10/2020","Mandar valor","Mike Scott","300","tete")
                .ValidarTextoSemDataDePgtoEmovimentacao()
                ;

        assertEquals("Data do pagamento é obrigatório", SemDataMovimentacao);

    }

    @Test
    public void CriarMovimetacaoDataInvalida() {
         String movimetacaoDataInvalida = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .todosOsCamposPreenchidosDataInvalida("10/10/2020","valor","kwai","367","tete","30/30/2085")
                 .ValidacaoCriarMovimetacaoDataInvalidaa()
                ;

        assertEquals("Data do pagamento inválida (DD/MM/YYYY)", movimetacaoDataInvalida);
    }

    @Test
    public void escolhendoUmaContaComDataFutura () {
        String EscolhendoUmaContaFutura = new PaginaDeLogin(navegar)
                .loginResumida("curry30@gmail.com","gsw")
                .clicarNoBotaoEntrar()
                .clicarCriarMovimentacao()
                .todosOsCamposPreenchidosDataInvalida("01/12/2023","valor","kwai","367","tete","10/12/2020")
                .validandoTextoEscolhendoUmaContaComDataFutura()
        ;
        assertEquals("Data da Movimentação deve ser menor ou igual à data atual", EscolhendoUmaContaFutura);
    }

    @Test
    public void SaindoDaConta () {
       String textoSaindoDaConta  = new PaginaDeLogin(navegar)
               .loginResumida("curry30@gmail.com","gsw")
               .clicarNoBotaoEntrar()
                .sair()
                .ValidandoTextoSaindoDaConta()
                ;
        assertEquals("Entrar", textoSaindoDaConta);
    }


    @After
    public void tearDown(){
        navegar.quit();
    }
}


