package com.dzeru.ozontest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractTest {

    protected static Properties properties = new Properties();
    protected ChromeDriver driver;
    protected final String OZON_URL = "https://www.ozon.ru/";
    protected String PHONE = "";
    protected String AUTH_CODE = "";

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

    @BeforeEach
    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("ozon-test.chromedriver-path"));
        PHONE = properties.getProperty("ozon-test.phone");
        AUTH_CODE = properties.getProperty("ozon-test.auth-code");
        driver = new ChromeDriver();
    }

    @AfterEach
    protected void close() {
        driver.quit();
    }
}
