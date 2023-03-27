package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v110.network.Network;
import org.openqa.selenium.devtools.v110.network.model.RequestId;
import org.openqa.selenium.devtools.v110.network.model.Response;

import org.openqa.selenium.devtools.v110.network.model.Response.*;


import java.util.Optional;

public class hooks {
    public static WebDriver driver;

    @Before
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.responseReceived(), responseReceived -> {
            String responseUrl = responseReceived.getResponse().getUrl();
            RequestId request_id = responseReceived.getRequestId();
            if (responseUrl.contains("auth/login")) {
                System.out.println("Url: " + responseUrl);
                System.out.println("Response body: " + devTools.send(Network.getResponseBody(request_id)).getBody());

            }
        });

        driver.manage().window().maximize();
    }

    @After
    public static void tearDown(){
        driver.manage().deleteAllCookies();

    }
}
