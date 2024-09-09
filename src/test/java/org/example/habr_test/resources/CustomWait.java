package org.example.habr_test.resources;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CustomWait {

    private WebDriverWait wait;
    private final int secondsToWait;
    AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(CustomWait.class));

    public CustomWait(int seconds){
        this.secondsToWait = seconds;
        wait = new WebDriverWait(BaseTest.getDriver(), Duration.ofSeconds(seconds));
    }

    public static CustomWait customWait(int seconds){
        return new CustomWait(seconds);
    }

    public WebElement clickable(WebElement element) {
        LOG.info("Ждем " + secondsToWait + " секунд пока элемент станет кликабельным " + element.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement visible(WebElement element) {
        LOG.info("Ждем " + secondsToWait + " секунд пока элемент станет видимым " + element.toString());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Alert alertIsPresented() {
        LOG.info("Ждем " + secondsToWait + " секунд пока появится alert");
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public WebElement locatorVisible(By element) {
        LOG.info("Ждем " + secondsToWait + " секунд пока локатор появится");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

}
