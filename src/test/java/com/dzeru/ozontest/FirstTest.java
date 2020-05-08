package com.dzeru.ozontest;

import com.dzeru.ozontest.listeners.TestListener;
import com.dzeru.ozontest.pages.PageObjectMain;
import com.dzeru.ozontest.util.SupportTestSettings;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
@Listeners({TestListener.class})
public class FirstTest extends SupportTestSettings {

    @Test
    public void firstTest() {
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);
        pageObjectMain.clickLoginButton();
        pageObjectMain.inputPhoneNumber();
        pageObjectMain.inputVerificationCode();
        pageObjectMain.checkAccountSettings();
    }
}