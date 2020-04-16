package com.dzeru.ozontest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Авторизоваться на сайте, после авторизации проверить что на главной
странице отображается логин. Убедиться что кнопка “Войти в аккаунт”
сменилась на “Мой профиль”
 */
public class FirstTest extends AbstractTest {

    @Test
    public void test() {
        driver.get(OZON_URL);
        String title = driver.getTitle();
        String expectedTitle = "OZON — интернет-магазин. Миллионы товаров по выгодным ценам";
        assertEquals(expectedTitle, title);
    }
}
