package com.dzeru.ozontest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Находясь на главной странице ozon.ru сменить город с Саратова на Вольск,
проверить что значение изменилось. Авторизоваться на сайте, перейти в
настройки и сравнить значение города в верхнем углу и город доставки.
 */
public class SecondTest extends AbstractTest {

    private static final String CITY_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[1]/div/button/span";
    private static final String CITY_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/div/label/div/input";
    private static final String CITY_FIRST_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/ul/li[1]/a";
    private static final String LOGIN_BUTTON_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/button";
    private static final String PHONE_INPUT_XPATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input";
    private static final String CODE_INPUT_PATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input";

    private static final String CITY = "Вольск";
    private static final String CITY_FULL = "Вольск, Саратовская область";

    @Test
    public void test() throws Exception {
        driver.get(OZON_URL);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        WebElement cityElement = driver.findElementByXPath(CITY_XPATH);
        cityElement.click();
        WebElement cityInput = driver.findElementByXPath(CITY_INPUT_XPATH);
        cityInput.click();
        cityInput.sendKeys(CITY);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(CITY_FIRST_XPATH), CITY_FULL));
        cityInput.sendKeys(Keys.DOWN);
        cityInput.sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(CITY_XPATH), CITY));
        cityElement = driver.findElementByXPath(CITY_XPATH);

        assertEquals(CITY, cityElement.getText());

        WebElement loginButton = driver.findElementByXPath(LOGIN_BUTTON_XPATH);
        loginButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_INPUT_XPATH)));
        WebElement phoneInput = driver.findElementByXPath(PHONE_INPUT_XPATH);
        phoneInput.sendKeys(PHONE);
        phoneInput.sendKeys(Keys.ENTER);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CODE_INPUT_PATH)));
        WebElement codeInput = driver.findElementByXPath(CODE_INPUT_PATH);
        codeInput.sendKeys(AUTH_CODE);
    }
}
