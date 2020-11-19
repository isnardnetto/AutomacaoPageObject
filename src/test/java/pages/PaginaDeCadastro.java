package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class PaginaDeCadastro {
    private WebDriver navegar;

    public PaginaDeCadastro(WebDriver navegar) {
        this.navegar = navegar;
    }

    public PaginaDeCadastro escreverNome(String nome){
        navegar.findElement(By.name("nome")).sendKeys(nome);
        return this;
    }

    public PaginaDeCadastro escreverEmail(String email){
        navegar.findElement(By.name("email")).sendKeys(email);
        return this;
    }

    public PaginaDeCadastro escreverSenha(String senha){
        navegar.findElement(By.name("senha")).sendKeys(senha);
        return this;
    }

    public PaginaDeLogin clicarNoBotaoCadastrarSucesso(){
        navegar.findElement(By.className("btn-primary")).click();
        WebElement alert = navegar.findElement(By.xpath("//div[@class=\"alert alert-success\"]"));
        String textoNoElementoAlert = alert.getText();
        assertEquals("Usuário inserido com sucesso", textoNoElementoAlert);
        return new PaginaDeLogin(navegar);
    }


    public PaginaDeCadastro cadastroResumido(String nome , String email ,String senha){
        navegar.findElement(By.name("nome")).sendKeys(nome);
        navegar.findElement(By.name("email")).sendKeys(email);
        navegar.findElement(By.name("senha")).sendKeys(senha);
        return this;
    }

}


