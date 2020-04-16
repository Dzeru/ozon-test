package com.dzeru.ozontest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

/*
Находясь на главной странице ozon.ru сменить город с Саратова на Вольск,
проверить что значение изменилось. Авторизоваться на сайте, перейти в
настройки и сравнить значение города в верхнем углу и город доставки.
 */
public class SecondTest extends AbstractTest {

    @Test
    public void test() {
        driver.get(OZON_URL);
        WebElement cityElement = driver.findElementByXPath("//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div/button/span");
        cityElement.click();
        WebElement cityInput = driver.findElementByXPath("//*[@id=\"__nuxt\"]/div/div[2]/div/div/div/div/div/label/div/input");
        cityInput.click();
        cityInput.sendKeys("Саратов");
        //System.out.println("x");
    }
}
