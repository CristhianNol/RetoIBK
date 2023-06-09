package support;

import definitions.hooks;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.Set;

public class util extends hooks {
    public static WebDriverWait wait;

    public util() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void ventanaActiva(){
        Set<String> identificadores = driver.getWindowHandles();
        for (String identificador:identificadores){
            driver.switchTo().window(identificador);
        }
    }

    public void ventanaInicial(){
        driver.close();
        driver.switchTo().window("");
    }
}
