package com.dzeru.ozontest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractTest {

    protected static Properties properties = new Properties();
    protected ChromeDriver driver;

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
        driver = new ChromeDriver();
    }

    @AfterEach
    protected void close() {
        driver.quit();
    }
}
