package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class PaginaDeLogin extends BasePage {


    public PaginaDeLogin(WebDriver navegar) {
        super(navegar);
    }

    public PaginaDeCadastro clicarNoBotaoNovoUsuario() {
            navegar.findElement(By.linkText("Novo usuário?")).click();

            return new PaginaDeCadastro(navegar);
        }

        public PaginaDeLogin digitandoEmailnaTelaDeLogin(String email){
            navegar.findElement(By.id("email")).sendKeys(email);

            return this;
        }

        public PaginaDeLogin digitandoSenhaNaTelaDeLogin(String senha){
            navegar.findElement(By.id("senha")).sendKeys(senha);

            return this;
        }

        public HomePage clicarNoBotaoEntrar(){
            navegar.findElement(By.className("btn-primary")).click();
            return new HomePage(navegar);
        }

        public PaginaDeLogin loginResumida(String email , String senha){
            navegar.findElement(By.id("email")).sendKeys(email);
            navegar.findElement(By.id("senha")).sendKeys(senha);

            return this;
        }

        public PaginaDeLogin clicarNoBotaoCadastrarErro(){
            navegar.findElement(By.className("btn-primary")).click();

            return this;
    }


}


