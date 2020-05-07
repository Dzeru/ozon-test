package com.dzeru.ozontest.pages;

import com.dzeru.ozontest.listeners.WebDriverEventListener;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractPageObject {

    public static EventFiringWebDriver driver;
    protected static Properties properties = new Properties();
    protected final String OZON_URL = "https://www.ozon.ru";
    protected String PHONE = "";
    protected String AUTH_CODE = "";

    protected static final String LOGIN_BUTTON_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[1]/div[2]/div[2]/div/button";
    protected static final String PHONE_INPUT_XPATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[2]/label/div/input";
    protected static final String CODE_INPUT_PATH = "/html/body/div[3]/div/div/div/div/div/div/div/div/div[1]/div/div[3]/div[1]/div[1]/input";

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
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.manage().window().maximize();
        WebDriverEventListener eventListener = new WebDriverEventListener();
        driver.register(eventListener);
        driver.get(OZON_URL);
    }

    @AfterEach
    protected void close() {
        driver.quit();
    }
}