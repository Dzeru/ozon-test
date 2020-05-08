package com.dzeru.ozontest.pages;

import com.dzeru.ozontest.util.SupportTestSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;

public class PageObjectMain {

    WebDriver driver;
    WebDriverWait webDriverWait;

    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"__ozon\"]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/button";
    private static final String PHONE_INPUT_XPATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input";
    private static final String CODE_INPUT_PATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input";
    private static final String SETTINGS_XPATH = "//*[@id=\"__ozon\"]/div/div[1]/header/div[1]/div[4]/div[1]/a";
    private static final String CITY_XPATH = "/html/body/div[1]/div/div/div[1]/div/button/span";
    private static final String CITY_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/div/label/div/input";
    private static final String CITY_FIRST_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/ul/li[1]/a";

    private static final String CITY = "Вольск";
    private static final String CITY_FULL = "Вольск, Саратовская область";

    private WebElement cityElement;

    public PageObjectMain(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    @Step("Click login button")
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(LOGIN_BUTTON_XPATH));
        //Сейчас отображается кнопка входа, потому что мы не авторизованы
        assertEquals(loginButton.getText(), "Вход или регистрация");
        loginButton.click();
    }

    @Step("Input phone number")
    public void inputPhoneNumber() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_INPUT_XPATH)));
        WebElement phoneInput = driver.findElement(By.xpath(PHONE_INPUT_XPATH));
        phoneInput.sendKeys(SupportTestSettings.PHONE);
        phoneInput.sendKeys(Keys.ENTER);
    }

    @Step("Input verification code")
    public void inputVerificationCode() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CODE_INPUT_PATH)));
        WebElement codeInput = driver.findElement(By.xpath(CODE_INPUT_PATH));
        codeInput.sendKeys(SupportTestSettings.AUTH_CODE);
    }

    @Step("Check account settings")
    public void checkAccountSettings() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SETTINGS_XPATH)));
        WebElement settings = driver.findElement(By.xpath(SETTINGS_XPATH));
        //Мы авторизовались, поэтому доступны настройки профиля
        assertEquals(settings.getAttribute("href"), SupportTestSettings.OZON_URL + "/my/main");
    }

    @Step("Click city label")
    public void clickCityLabel() {
        cityElement = driver.findElement(By.xpath(CITY_XPATH));
        cityElement.click();
    }

    @Step("Input city")
    public void inputCity() {
        WebElement cityInput = driver.findElement(By.xpath(CITY_INPUT_XPATH));
        cityInput.click();
        cityInput.sendKeys(CITY);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(CITY_FIRST_XPATH), CITY_FULL));
        cityInput.sendKeys(Keys.DOWN);
        cityInput.sendKeys(Keys.ENTER);
    }

    @Step("Check new city")
    public void checkNewCity() {
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(CITY_XPATH), CITY));
        cityElement = driver.findElement(By.xpath(CITY_XPATH));
        assertEquals(cityElement.getText(), CITY);
    }
}
