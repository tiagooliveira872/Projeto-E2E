package Runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RunnerBase {

    static WebDriver driver;


    public static WebDriver getDriver() {

        if (driver == null) {
            getDriverChrome();
        }
        return driver;
    }

    public static WebDriver getDriverChrome() {
        ChromeOptions options = new ChromeOptions();

        // Executa o Chrome em modo headless (sem interface gráfica) — necessário para ambientes de CI/CD
        options.addArguments("--headless=new"); // ou "--headless" dependendo da versão do ChromeDriver

        // Evita problemas comuns em ambientes Linux
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        // Abre em modo incógnito
        options.addArguments("incognito");

        // Inicializa o driver com as opções configuradas
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

}