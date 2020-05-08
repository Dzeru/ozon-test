package com.dzeru.ozontest;

import com.dzeru.ozontest.listeners.TestListener;
import com.dzeru.ozontest.pages.PageObjectMain;
import com.dzeru.ozontest.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Находясь на главной странице ozon.ru сменить город с Саратова на Вольск,
проверить что значение изменилось.
 */
@Listeners({TestListener.class})
public class SecondTest extends SupportTestSettings {

    @Test
    public void secondTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);
        pageObjectMain.clickCityLabel();
        pageObjectMain.inputCity();
        pageObjectMain.checkNewCity();
    }
}