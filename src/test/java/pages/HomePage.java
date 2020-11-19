package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver navegar;

    public HomePage(WebDriver navegar) {
        this.navegar = navegar;
    }

    public HomePage AbrirConta(){
        navegar.findElement(By.className("dropdown-toggle")).click();

        return this;
    }

    public AddConta adicionarConta(){
        navegar.findElement(By.linkText("Adicionar")).click();

        return new AddConta(navegar);
    }

    public ListarConta clicarListarConta(){
        navegar.findElement(By.linkText("Listar")).click();

        return new ListarConta(navegar);
    }

    public CriarMovimentacao clicarCriarMovimentacao(){
        navegar.findElement(By.linkText("Criar Movimentação")).click();

        return new CriarMovimentacao(navegar);
    }

    public PaginaDeLogin sair(){
        navegar.findElement(By.linkText("Sair")).click();

        return new PaginaDeLogin(navegar);
    }

}

//
//
//        navegador.findElement(By.className("btn-primary")).click();