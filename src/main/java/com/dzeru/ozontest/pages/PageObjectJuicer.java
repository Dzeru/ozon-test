package com.dzeru.ozontest.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.dzeru.ozontest.util.SupportTestSettings.XPATH_ID;
import static com.dzeru.ozontest.util.SupportTestSettings.deleteNotNumber;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageObjectJuicer {

    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public PageObjectJuicer(WebDriver driver, WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
    }

    private static final String PRICE_MIN_INPUT_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input";
    private static final String PRICE_MAX_INPUT_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input";
    private static final String MIN_MAX_PRICE_LABEL_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span";
    private static final String POWER_MIN_INPUT_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[9]/div[2]/div[2]/div[1]/input";
    private static final String MIN_MAX_POWER_LABEL_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[2]/button/div/span";
    private static final String FIRST_JUICER_PRICE_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[1]/span";
    private static final String FIRST_SALE_JUICER_PRICE_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/a/div[2]/span";
    private static final String CLOSE_COOKIE_POPUP_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[3]/div/button";
    private static final String FIRST_JUICER_CART_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div/div[1]/div/div/div[3]/div[3]/div/div/button";
    private static final String FIRST_JUICER_POWER_CART_XPATH = "//*[@id=\"__" + XPATH_ID + "\"]/div/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div/div[1]/div/div/div[3]/div[3]/div/div/button";
    private static final String CHOOSE_SORT_TYPE_INPUT_CSS= "[role=\"combobox\"]";
    private static final String CART_CSS= "[data-widget=\"cart\"]";

    private static final By DOTS_SELECTOR = By.cssSelector("[class=\"dots dots-blue\"]");

    private static final String MIN_PRICE = "3000";
    private static final String MAX_PRICE = "4000";
    private static final String MIN_POWER = "1000";

    private WebElement chooseSortTypeInput;

    @Step("Input min price")
    public void inputMinPrice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_MIN_INPUT_XPATH)));
        closeCookiePopUp();
        WebElement priceMinInput = driver.findElement(By.xpath(PRICE_MIN_INPUT_XPATH));
        priceMinInput.sendKeys(Keys.CONTROL + "a");
        priceMinInput.sendKeys(MIN_PRICE);
        priceMinInput.sendKeys(Keys.ENTER);
    }

    @Step("Input max price")
    public void inputMaxPrice() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_MAX_INPUT_XPATH)));
        WebElement priceMaxInput = driver.findElement(By.xpath(PRICE_MAX_INPUT_XPATH));
        priceMaxInput.sendKeys(Keys.CONTROL + "a");
        priceMaxInput.sendKeys(MAX_PRICE);
        waitDots();
        priceMaxInput.sendKeys(Keys.ENTER);
    }

    @Step("Check range with min price")
    public void checkRangeWithMinPrice() {
        final String minMaxPrice = "Цена: от 3 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));

        assertTrue(driver.findElement(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)).getText().startsWith(minMaxPrice));
    }

    @Step("Check range with min and max price")
    public void checkRangeWithMinAndMaxPrice() {
        final String minMaxPrice = "Цена: от 3 000 до 4 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(MIN_MAX_PRICE_LABEL_XPATH), minMaxPrice));

        assertEquals(driver.findElement(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)).getText(), minMaxPrice);
    }

    @Step("Input min power")
    public void inputMinPower() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(POWER_MIN_INPUT_XPATH)));
        closeCookiePopUp();
        WebElement priceMinInput = driver.findElement(By.xpath(POWER_MIN_INPUT_XPATH));
        priceMinInput.sendKeys(Keys.CONTROL + "a");
        priceMinInput.sendKeys(MIN_POWER);
        priceMinInput.sendKeys(Keys.ENTER);
    }

    @Step("Check range with min power")
    public void checkRangeWithMinPower() {
        final String minPower = "Мощность, Вт: от 1 000";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_MAX_POWER_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MIN_MAX_POWER_LABEL_XPATH)));

        assertTrue(driver.findElement(By.xpath(MIN_MAX_POWER_LABEL_XPATH)).getText().startsWith(minPower));
    }

    @Step("Sort by price desc")
    public void sortByPriceDesc() {
        sortByPrice(3);
        WebElement firstJuicerPrice = getFirstJuicerPrice();
        assertTrue(Integer.parseInt(deleteNotNumber(firstJuicerPrice.getText())) < 4000);
    }

    @Step("Sort by price asc")
    public void sortByPriceAsc() {
        sortByPrice(2);
        WebElement firstJuicerPrice = getFirstJuicerPrice();
        assertTrue(Integer.parseInt(deleteNotNumber(firstJuicerPrice.getText())) > 3000);
    }

    @Step("Put juicer in the cart")
    public void putJuicerInCart() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_JUICER_CART_XPATH)));
        WebElement firstJuicerCart = driver.findElement(By.xpath(FIRST_JUICER_CART_XPATH));
        firstJuicerCart.click();
        WebElement cart = driver.findElement(By.cssSelector(CART_CSS));
        cart.click();
    }

    @Step("Put juicer with power filter in the cart")
    public void putJuicerPowerInCart() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_JUICER_POWER_CART_XPATH)));
        WebElement firstJuicerCart = driver.findElement(By.xpath(FIRST_JUICER_POWER_CART_XPATH));
        firstJuicerCart.click();
        WebElement cart = driver.findElement(By.cssSelector(CART_CSS));
        cart.click();
    }

    private void sortByPrice(int sendKeysNTimes) {
        waitDots();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(CHOOSE_SORT_TYPE_INPUT_CSS)));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CHOOSE_SORT_TYPE_INPUT_CSS)));
        chooseSortTypeInput = driver.findElement(By.cssSelector(CHOOSE_SORT_TYPE_INPUT_CSS));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSortTypeInput));
        chooseSortTypeInput.click();
        chooseSortTypeInput.click();

        for(int i = 0; i < sendKeysNTimes; i++) {
            chooseSortTypeInput.sendKeys(Keys.ARROW_DOWN);
        }

        chooseSortTypeInput.sendKeys(Keys.ENTER);
        waitDots();
    }

    private WebElement getFirstJuicerPrice() {
        WebElement firstJuicerPrice;

        try {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_JUICER_PRICE_XPATH)));
            firstJuicerPrice = driver.findElement(By.xpath(FIRST_JUICER_PRICE_XPATH));
        }
        catch(Exception e) {
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FIRST_SALE_JUICER_PRICE_XPATH)));
            firstJuicerPrice = driver.findElement(By.xpath(FIRST_SALE_JUICER_PRICE_XPATH));
        }

        return firstJuicerPrice;
    }

    private void closeCookiePopUp() {
        try {
            WebElement close = driver.findElement(By.xpath(CLOSE_COOKIE_POPUP_XPATH));
            close.click();
        }
        catch(Exception e) {}
    }

    private void waitDots() {
        try {
            webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(DOTS_SELECTOR));
        }
        catch(NoSuchElementException e) {}
    }
}
