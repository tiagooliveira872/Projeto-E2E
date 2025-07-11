package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Steps",
        tags = "@sauceDemo",
        plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        }
)
public class RunCucumberTest extends RunnerBase {

    @AfterClass
    public static void stop() {
        // Encerra o driver após os testes, se estiver sendo usado diretamente aqui
        if (driver != null) {
            driver.quit();
        }
    }
}
