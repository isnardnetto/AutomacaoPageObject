package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected WebDriver navegar;

    public BasePage(WebDriver navegar) {
        this.navegar = navegar;
    }

    public String ValidacaoTextoTesteNovoUsuario() {
        return navegar.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();

    }

    public String ValidacaoTextoTesteUsuarioJaUltilizado() {
        return navegar.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
    }

    public String validandoTextoUsuarioCadastrado() {
        return navegar.findElement(By.xpath("//div[@class=\"alert alert-success\"]")).getText();

    }

    public String valindandoSenhaErrada() {
        return navegar.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
    }

    public String valindandoContaDuplicada() {
        return navegar.findElement(By.xpath("//div[@class=\"alert alert-danger\"]")).getText();
    }

    public String ValidarTextoContaEmUso() {
        return navegar.findElement(By.xpath("//div[contains(text(),'Conta em uso na movimentações')]")).getText();
    }

    public String ValidarTextoSemDataDePgtoEmovimentacao() {
        return navegar.findElement(By.xpath("//body/div[1]")).getText();
    }

    public String ValidacaoCriarMovimetacaoDataInvalidaa() {
        return navegar.findElement(By.xpath("//body/div[1]")).getText();
    }

    public String validandoTextoEscolhendoUmaContaComDataFutura() {
        return navegar.findElement(By.xpath("//body/div[1]")).getText();
    }

    public String ValidandoTextoSaindoDaConta() {
        return navegar.findElement(By.className("btn-primary")).getText();
    }

}

