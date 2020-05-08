package com.dzeru.ozontest;

/*
Перейти в каталог “Бытовая техника/Соковыжималки”, выполнить поиск с
диапазоном цен от 3000 до 4000 рублей. Проверить что в результате
отобразились только соковыжималки с ценами в этом диапазоне. Выбрать
сортировку списка по цене, начиная с самого дешевого товара. Добавить
первую (самую дешевую) соковыжималку в корзину и перейти в нее. Увеличить
количество соковыжималок до 5 проверить, что сумма увеличилась в 5 раз.
 */
/*
public class ThirdTest extends SupportTestSettings {

    private static final String CATALOG_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/header/div[1]/div[2]/div/div[1]/button";
    private static final String HOME_TECH_LABEL_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[1]/div/a[12]";
    private static final String JUICER_LABEL_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/header/div[1]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a[6]";
    private static final String PRICE_MIN_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[1]/input";
    private static final String PRICE_MAX_INPUT_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[1]/div/aside/div[2]/div[2]/div[2]/div[2]/input";
    private static final String MIN_MAX_PRICE_LABEL_XPATH = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div/button/div/span";
    private static final String CHOOSE_SORT_TYPE_INPUT_CSS= "[role=\"combobox\"]";
    private static final String s = "//*[@id=\"__nuxt\"]/div/div[1]/div[2]/div[2]/div[2]/div[2]/div[1]/div";

    private static final String MIN_PRICE = "3000";
    private static final String MAX_PRICE = "4000";

    @Test
    public void test(){
        driver.get(OZON_URL);
        By dotsLocator = By.cssSelector("[class=\"dots dots-blue\"]");
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement catalog = driver.findElementByXPath(CATALOG_XPATH);
        catalog.click();
        WebElement homeTechLabel = driver.findElementByXPath(HOME_TECH_LABEL_XPATH);
        Actions actions = new Actions(driver);
        actions.moveToElement(homeTechLabel).build().perform();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JUICER_LABEL_XPATH)));
        WebElement juicerLabel = driver.findElementByXPath(JUICER_LABEL_XPATH);
        juicerLabel.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_MIN_INPUT_XPATH)));
        WebElement priceMinInput = driver.findElementByXPath(PRICE_MIN_INPUT_XPATH);
        priceMinInput.sendKeys(Keys.CONTROL + "a");
        priceMinInput.sendKeys(MIN_PRICE);
        priceMinInput.sendKeys(Keys.ENTER);

        final String minMaxPrice1 = "Цена: от 3 000 до 139 900";
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(MIN_MAX_PRICE_LABEL_XPATH), minMaxPrice1));

        System.out.println(driver.findElementByXPath(MIN_MAX_PRICE_LABEL_XPATH).getText());
        assertEquals(minMaxPrice1, driver.findElementByXPath(MIN_MAX_PRICE_LABEL_XPATH).getText());

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(PRICE_MAX_INPUT_XPATH)));
        WebElement priceMaxInput = driver.findElementByXPath(PRICE_MAX_INPUT_XPATH);
        priceMaxInput.sendKeys(Keys.CONTROL + "a");
        priceMaxInput.sendKeys(MAX_PRICE);
        webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(dotsLocator)));
        priceMaxInput.sendKeys(Keys.ENTER);

        final String minMaxPrice2 = "Цена: от 3 000 до 4 000";
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(dotsLocator));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MIN_MAX_PRICE_LABEL_XPATH)));
        webDriverWait.until(ExpectedConditions.textToBe(By.xpath(MIN_MAX_PRICE_LABEL_XPATH), minMaxPrice2));

        System.out.println(driver.findElementByXPath(MIN_MAX_PRICE_LABEL_XPATH).getText());
        assertEquals(minMaxPrice2, driver.findElementByXPath(MIN_MAX_PRICE_LABEL_XPATH).getText());

        WebElement chooseSortTypeInput = driver.findElementByCssSelector(CHOOSE_SORT_TYPE_INPUT_CSS);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(chooseSortTypeInput));

        chooseSortTypeInput.click();
        chooseSortTypeInput.click();
        for(int i = 0; i < 3; i++) {
            chooseSortTypeInput.sendKeys(Keys.ARROW_DOWN);
        }
        chooseSortTypeInput.sendKeys(Keys.ENTER);

        WebElement firstJuicerPrice = driver.findElementByClassName("a4o8");
        System.out.println(firstJuicerPrice.getText());

        System.out.println("x");
    }

    private void waitForCompletePage(WebDriverWait webDriverWait) {
        webDriverWait.until(d -> "complete".equals(driver.executeScript("return document.readyState;").toString()));
    }
}
*/