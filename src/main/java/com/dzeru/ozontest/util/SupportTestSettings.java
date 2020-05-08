package com.dzeru.ozontest.util;

import com.dzeru.ozontest.listeners.WebDriverEventListener;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.Properties;

public abstract class SupportTestSettings {

    public static EventFiringWebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Properties properties = new Properties();
    public static final String OZON_URL = "https://www.ozon.ru";
    public static String PHONE = "";
    public static String AUTH_CODE = "";

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

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("ozon-test.chromedriver-path"));
        PHONE = properties.getProperty("ozon-test.phone");
        AUTH_CODE = properties.getProperty("ozon-test.auth-code");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        WebDriverEventListener eventListener = new WebDriverEventListener();
        driver.register(eventListener);
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get(OZON_URL);
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}