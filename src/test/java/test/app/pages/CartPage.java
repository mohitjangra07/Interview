package test.app.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class CartPage {

    private final By placeOrderButton = By.xpath("//button[text()='Place Order']");
    private final By modalForm = By.id("orderModalLabel");
    private final By nameInput = By.id("name");
    private final By countryInput = By.id("country");
    private final By cityInput = By.id("city");
    private final By creditCardInput = By.id("card");
    private final By monthInput = By.id("month");
    private final By yearInput = By.id("year");
    private final By totalAmountInCart = By.id("totalp");
    private final By purchaseButton = By.xpath("//button[text()='Purchase']");
    private final By okButton = By.xpath("//button[text()='OK']");
    private final By transactionDetails = By.className("lead");

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method will enter name in form
     * @param name TestUser
     */
    public void enterName(String name) {
        log.info("Entering the name in form");
        driver.findElement(nameInput).sendKeys(name);
    }

    /**
     * This method will enter country in form
     * @param country India
     */
    public void enterCountry(String country) {
        log.info("Entering the country in form");
        driver.findElement(countryInput).sendKeys(country);
    }

    /**
     * This method will enter city in form
     * @param city Delhi
     */
    public void enterCity(String city) {
        log.info("Entering the city in form");
        driver.findElement(cityInput).sendKeys(city);
    }

    /**
     * This method will enter card in form
     * @param cardNo 1234567890123456
     */
    public void enterCreditCard(String cardNo) {
        log.info("Entering the card number in form");
        driver.findElement(creditCardInput).sendKeys(cardNo);
    }

    /**
     * This method will enter month in form
     * @param month Jan
     */
    public void enterMonth(String month) {
        log.info("Entering the Month in form");
        driver.findElement(monthInput).sendKeys(month);
    }

    /**
     * This method will enter year in form
     * @param year 2002
     */
    public void enterYear(String year) {
        log.info("Entering the year in form");
        driver.findElement(yearInput).sendKeys(year);
    }

    /**
     * This method will return loctor of delete button based on product name
     * @param productName Sony vaio i5
     * @return By element
     */
    public By getDeletebutton(String productName) {
        return By.xpath("//td[contains(text(),'" + productName + "')]/following-sibling::td[2]/a");
    }

    /**
     * This method returns USD amount from Cart
     * @return String value e.g. 750
     */
    public String getCartAmountValue() {
        String amount = driver.findElement(totalAmountInCart).getText();
        log.info("Returning the amount %s from cart", amount);
        return amount;
    }

    /**
     * This method is used to click Purchase button in Cart
     */
    public void clickPurchase() {
        log.info("Clicking on Purchase button");
        driver.findElement(purchaseButton).click();
    }

    /**
     * This method will return the transaction details from UI
     * @return Details from UI
     */
    public String getTranactionDetails() {
        log.info("Getting transaction details from UI");
        return driver.findElement(transactionDetails).getText();
    }

    /**
     * This method will delete the product from Cart based on name
     */
    public void clickDeleteButton(String name) {
        log.info("Deleting %s from cart", name);
        driver.findElement(getDeletebutton(name)).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(getDeletebutton(name)));
    }

    /**
     * This is to click on Place order button in cart
     */
    public void clickPlaceOrder() {
        log.info("Clicking Place order button");
        driver.findElement(placeOrderButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalForm));
    }

    /**
     * This is to click Ok button on confirmation screen
     */
    public void clickOK() {
        log.info("Clicking Ok button");
        driver.findElement(okButton).click();
    }
}
