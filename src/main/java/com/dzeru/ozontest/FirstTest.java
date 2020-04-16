package com.dzeru.ozontest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class FirstTest {

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(Thread
                    .currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("application.properties"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("ozon-test.chromedriver-path"));
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ozon.ru/");
        driver.quit();
    }
}
