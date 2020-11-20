package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListarConta extends BasePage {


    public ListarConta(WebDriver navegar) {
        super(navegar);
    }

    public ContasListadas excluirContaEmUso(){
            WebElement alert = navegar.findElement(By.xpath("//tbody/tr[4]/td[2]/a[2]/span[1]"));//melhorar seletor
            alert.click();

            return new ContasListadas(navegar);
        }
}
