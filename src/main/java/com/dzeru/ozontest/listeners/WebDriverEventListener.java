package com.dzeru.ozontest.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import com.dzeru.ozontest.util.ScreenshotMaker;

public class WebDriverEventListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        ScreenshotMaker.takeScreenshot();
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, java.lang.CharSequence[] keysToSend){
        ScreenshotMaker.takeScreenshot();
    }
}


