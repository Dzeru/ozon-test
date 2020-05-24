package com.dzeru.ozontest;

import com.dzeru.ozontest.pages.PageObjectCart;
import com.dzeru.ozontest.pages.PageObjectJuicer;
import com.dzeru.ozontest.pages.PageObjectMain;
import com.dzeru.ozontest.util.SupportTestSettings;
import org.testng.annotations.Test;

/*
Сделать тест, аналогичный п.3, только добавить условие “мощность
соковыжималки >=1000 Вт”. Для этого, воспользоваться фильтром на сайте, в
левой колонке.
 */
public class FourthTest extends SupportTestSettings {

    @Test
    public void fourthTest(){
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
        pageObjectJuicer.inputMinPower();
        pageObjectJuicer.checkRangeWithMinPower();
        pageObjectJuicer.sortByPriceDesc();
        pageObjectJuicer.sortByPriceAsc();
        pageObjectJuicer.putJuicerPowerInCart();
        pageObjectCart.checkPriceOneJuicer();
    }
}
