package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Web {
    public static WebDriver createChrome() {
        //System.setProperty("webdriver.chrome.driver", "C:\\arquivos de programas\\Java\\chromedriver_win32\\chromedriver.exe");//Para escolher o navegador chrome descomentar
        System.setProperty("webdriver.gecko.driver", "C:\\arquivos de programas\\Java\\geckodriver-v0.26.0-win64\\geckodriver.exe");
        WebDriver navegar = new FirefoxDriver();
        //WebDriver navegar = new ChromeDriver(); // Para escolher o navegador chrome descomentar
        navegar.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        navegar.get("https://seubarriga.wcaquino.me/");
        navegar.manage().window().maximize();

        return navegar;
    }
}
