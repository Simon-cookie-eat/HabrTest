package org.example.habr_test.pages;

import org.example.habr_test.resources.AllureLogger;
import org.example.habr_test.resources.CustomWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class HabrMainPage {

    private WebDriver driver;
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(HabrMainPage.class));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public HabrMainPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/articles/\']")
    private WebElement buttonArticles;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/develop/\']")
    private WebElement buttonDevelop;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/admin/\']")
    private WebElement buttonAdmin;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/design/\']")
    private WebElement buttonDesign;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/management/\']")
    private WebElement buttonManagement;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/marketing/\']")
    private WebElement buttonMarketing;

    @FindBy(css = "[class=\'tm-main-menu__section-content\'] > [href=\'/ru/popsci/\']")
    private WebElement buttonPopSci;

    public void clickButtonArticles(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonArticles));
        buttonArticles.click();
    }

    public void clickButtonDevelop(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonDevelop));
        buttonDevelop.click();
    }

    public void clickButtonAdmin(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonAdmin));
        buttonAdmin.click();
    }

    public void clickButtonDesign(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonDesign));
        buttonDesign.click();
    }

    public void clickButtonManagement(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonManagement));
        buttonManagement.click();
    }

    public void clickButtonMarketing(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonMarketing));
        buttonMarketing.click();
    }

    public void clickButtonPopSci(){
        wait.until(ExpectedConditions.elementToBeClickable(buttonPopSci));
        buttonPopSci.click();
    }



}
