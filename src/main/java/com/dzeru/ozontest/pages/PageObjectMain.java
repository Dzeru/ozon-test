package com.dzeru.ozontest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PageObjectMain {

    WebDriver driver;

    public PageObjectMain(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click login button")

}
