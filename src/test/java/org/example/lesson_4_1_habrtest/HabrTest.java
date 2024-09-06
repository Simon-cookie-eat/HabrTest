package org.example.lesson_4_1_habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class HabrTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
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
