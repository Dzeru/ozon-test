package com.dzeru.ozontest.pages;

import com.dzeru.ozontest.util.SupportTestSettings;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;
import static com.dzeru.ozontest.util.SupportTestSettings.*;

public class PageObjectCart {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public PageObjectCart(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    private static final String PRICE_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div/div/div[3]/div[4]/div[1]/div[1]/div/div[2]/div[3]/div[3]/div[1]/div/span";
    private static final String TOTAL_PRICE_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div/div/div[3]/div[4]/div[2]/div/div[1]/div[2]/div[4]/span[2]";

    @Step("Check price for 1 juicer")
    public void checkPriceOneJuicer() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_XPATH)));
        WebElement price = driver.findElement(By.xpath(PRICE_XPATH));
        WebElement totalPrice = driver.findElement(By.xpath(TOTAL_PRICE_XPATH));
        assertEquals(
                Integer.parseInt(deleteNotNumber(price.getText())),
                Integer.parseInt(deleteNotNumber(totalPrice.getText()))
        );
    }
}
