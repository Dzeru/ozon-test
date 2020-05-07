package com.dzeru.ozontest;

import com.dzeru.ozontest.pages.AbstractPageObject;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Находясь на главной странице ozon.ru сменить город с Саратова на Вольск,
проверить что значение изменилось.
 */
public class SecondTest extends AbstractPageObject {

    private static final String CITY_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[1]/div/button/span";
    private static final String CITY_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/div/label/div/input";
    private static final String CITY_FIRST_XPATH = "//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/ul/li[1]/a";

    private static final String CITY = "Вольск";
    private static final String CITY_FULL = "Вольск, Саратовская область";

    @Test
    public void test() {
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
    }
}
