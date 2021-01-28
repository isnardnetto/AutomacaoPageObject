package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListarConta extends BasePage {


    public ListarConta(WebDriver navegar) {
        super(navegar);
    }

    public ContasListadas excluirContaEmUso(){
            WebElement alert = navegar.findElement(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[2]/a[2]/span"));//melhorar seletor
            alert.click();

            return new ContasListadas(navegar);
        }
}
