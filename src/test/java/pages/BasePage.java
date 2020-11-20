package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver navegar;

    public BasePage(WebDriver navegar){
        this.navegar = navegar;
    }
}
