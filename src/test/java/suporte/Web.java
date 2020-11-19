package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        System.setProperty("webdriver.chrome.driver", "C:\\arquivos de programas\\Java\\chromedriver_win32\\chromedriver.exe");
       WebDriver navegar = new ChromeDriver();
        navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegar.get("https://seubarriga.wcaquino.me/");
        navegar.manage().window().maximize();

        return navegar;
    }
}
