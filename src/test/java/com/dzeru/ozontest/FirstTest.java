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
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
public class FirstTest extends AbstractPageObject {

    private static final String SETTINGS_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/header/div[1]/div[4]/div[1]/a";

    @Test
    public void test() {
        driver.get(OZON_URL);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 2);
        WebElement loginButton = driver.findElementByXPath(LOGIN_BUTTON_XPATH);

        //Сейчас отображается кнопка входа, потому что мы не авторизованы
        assertEquals("Вход или регистрация", loginButton.getText());

        loginButton.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PHONE_INPUT_XPATH)));
        WebElement phoneInput = driver.findElementByXPath(PHONE_INPUT_XPATH);
        phoneInput.sendKeys(PHONE);
        phoneInput.sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CODE_INPUT_PATH)));
        WebElement codeInput = driver.findElementByXPath(CODE_INPUT_PATH);
        codeInput.sendKeys(AUTH_CODE);

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SETTINGS_XPATH)));
        WebElement settings = driver.findElementByXPath(SETTINGS_XPATH);

        //Мы авторизовались, поэтому доступны настройки профиля
        assertEquals(OZON_URL + "/my/settings", settings.getAttribute("href"));
    }
}
