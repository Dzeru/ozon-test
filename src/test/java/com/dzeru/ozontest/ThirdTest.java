package com.dzeru.ozontest;

/*
Перейти в каталог “Бытовая техника/Соковыжималки”, выполнить поиск с
диапазоном цен от 3000 до 4000 рублей. Проверить что в результате
отобразились только соковыжималки с ценами в этом диапазоне. Выбрать
сортировку списка по цене, начиная с самого дешевого товара. Добавить
первую (самую дешевую) соковыжималку в корзину и перейти в нее. Увеличить
количество соковыжималок до 5 проверить, что сумма увеличилась в 5 раз.
 */

import com.dzeru.ozontest.pages.PageObjectCart;
import com.dzeru.ozontest.pages.PageObjectJuicer;
import com.dzeru.ozontest.pages.PageObjectMain;
import com.dzeru.ozontest.util.SupportTestSettings;
import org.testng.annotations.Test;

public class ThirdTest extends SupportTestSettings {

    @Test
    public void thirdTest(){
        PageObjectMain pageObjectMain = new PageObjectMain(driver, webDriverWait);
        PageObjectJuicer pageObjectJuicer = new PageObjectJuicer(driver, webDriverWait);
        PageObjectCart pageObjectCart = new PageObjectCart(driver, webDriverWait);
        pageObjectMain.clickCatalog();
        pageObjectMain.clickHomeTechLabel();
        pageObjectMain.clickJuicerLabel();
        pageObjectJuicer.inputMinPrice();
        pageObjectJuicer.checkRangeWithMinPrice();
        pageObjectJuicer.inputMaxPrice();
        pageObjectJuicer.checkRangeWithMinAndMaxPrice();
        pageObjectJuicer.sortByPriceDesc();
        pageObjectJuicer.sortByPriceAsc();
        pageObjectJuicer.putJuicerInCart();
        pageObjectCart.checkPriceOneJuicer();
    }
}
