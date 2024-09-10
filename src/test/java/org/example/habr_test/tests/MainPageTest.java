package org.example.habr_test.tests;

import org.example.habr_test.pages.HabrMainPage;
import org.example.habr_test.resources.BaseTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class MainPageTest extends BaseTest {
    private WebDriver driver;
    private HabrMainPage habrMainPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed/");
        habrMainPage = new HabrMainPage(getDriver());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Все потоки'")
    public void clickButtonArticlesTest(){
        String tabLink = "https://habr.com/ru/articles/";
        habrMainPage.clickButtonArticles();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Разработка'")
    public void clickButtonDevelopTest(){
        String tabLink = "https://habr.com/ru/develop/";
        habrMainPage.clickButtonDevelop();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Администрирование'")
    public void clickButtonAdminTest(){
        String tabLink = "https://habr.com/ru/admin/";
        habrMainPage.clickButtonAdmin();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Дизайн'")
    public void clickButtonDesignTest(){
        String tabLink = "https://habr.com/ru/design/";
        habrMainPage.clickButtonDesign();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Менеджмент'")
    public void clickButtonManagementTest(){
        String tabLink = "https://habr.com/ru/management/";
        habrMainPage.clickButtonManagement();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Маркетинг'")
    public void clickButtonMarketingTest(){
        String tabLink = "https://habr.com/ru/marketing/";
        habrMainPage.clickButtonMarketing();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка перехода по кнопке 'Научпоп'")
    public void clickButtonPopSciTest(){
        String tabLink = "https://habr.com/ru/popsci/";
        habrMainPage.clickButtonPopSci();
        assertEquals(tabLink, driver.getCurrentUrl(), "Переход не произошёл");
    }

    @Test
    @DisplayName("Проверка наличия вкладки Changelog на странице 'Информация о сайте'")
    public void changeLogTest() {
        WebElement siteInfoButton = driver.findElement(By.xpath("//*[contains(text(),'Устройство сайта')]"));
        siteInfoButton.click();

        List<WebElement> changeLog = driver.findElements(By.xpath("//*[contains(text(),'Changelog')]"));

        assertFalse(changeLog.isEmpty(), "ChaneLog не найден");
    }

    @Test
    @DisplayName("Проверка наличия ссылки компании в профиле компании")
    public void companyLinkTest() {
        String companyName = "Яндекс";
        String companySite = "http://www.ya.ru/";

        WebElement companiesButton = driver.findElement(By.xpath("//li/*[contains(@href,'/ru/companies')]"));
        companiesButton.click();

        WebElement searchButton = driver.findElement(By.cssSelector(".tm-input-text-decorated__input"));
        searchButton.sendKeys(companyName);

        WebElement companyProfile = driver.findElement(By.cssSelector(".searched-item:first-of-type"));
        companyProfile.click();

        List<WebElement> companyLink = driver.findElements(By.xpath("//*[contains(@class, 'tm-company-basic-info__link')]"));

        assertFalse(companyLink.isEmpty(), "Ссылка на сайт компании отсутствует");
        companySite.equals(companyLink.get(0).toString());
    }

    @Test
    @DisplayName("Проверка наличия кнопки 'Написать публикацию' в разделе 'Как стать автором'")
    public void errorMessageTest() {
        WebElement becomeAuthorButton = driver.findElement(By.cssSelector(".tm-header__become-author-btn"));
        becomeAuthorButton.click();

        List<WebElement> newAuthorsButton = driver.findElements(By.xpath("//*[contains(text(),'Новые авторы')]"));

        assertFalse(newAuthorsButton.isEmpty(), "Кнопка 'Новые авторы' отсутствует");

    }



}
