package com.dzeru.ozontest.util;

import com.dzeru.ozontest.pages.AbstractPageObject;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotMaker {

    @Attachment(type = "image/png")
    public static byte[] takeScreenshot() {
        try {
            File screenshot = ((TakesScreenshot) AbstractPageObject.driver).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screenshot);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }
}
