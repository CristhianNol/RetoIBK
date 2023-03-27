package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.util;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class dashboardPage extends util {

    private static final Logger logger = LoggerFactory.getLogger(dashboardPage.class);

    @FindBy(xpath = "//a[@class='header__profile-menu']") WebElement user;
    @FindBy( xpath = "//i[contains(@class,'ibk-icon icon-ibk icon-ibk-sing-out')]") WebElement cerrarSesion;


    public dashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void obtenerTrackingId(){

    }

    public void clickUser(){
        wait.until(ExpectedConditions.elementToBeClickable(user));
        /*Actions actions = new Actions(driver);
        actions.moveToElement(user);*/



        user.click();




    }

    public void cerrarSesion(){
        wait.until(ExpectedConditions.elementToBeClickable(cerrarSesion));
        cerrarSesion.click();
    }



}
