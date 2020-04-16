package com.dzeru.ozontest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTest extends AbstractTest {

    @Test
    public void test() {
        driver.get("https://www.ozon.ru/");
        String title = driver.getTitle();
        String expectedTitle = "OZON — интернет-магазин. Миллионы товаров по выгодным ценам";
        assertEquals(expectedTitle, title);
    }
}
