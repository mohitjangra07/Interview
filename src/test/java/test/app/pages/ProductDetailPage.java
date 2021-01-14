package test.app.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class ProductDetailPage {

    private final By addToCartButton = By.className("btn-success");
    private final By cartMenu = By.linkText("Cart");
    private final WebDriver driver;

    /**
     * Constructor
     * @param driver Webdriver instance
     */
    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This is to click on Add to Cart button
     */
    public void clickOnAddToCart() {
        log.info("Clicking Add to cart button");
        driver.findElement(addToCartButton).click();
    }

    /**
     * This is to accept the alert
     */
    public void acceptAlerts() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        log.info("Accepting the alert");
        driver.switchTo().alert().accept();
    }

    /**
     * This is to Open the Cart
     */
    public void openCart(){
        log.info("Opening the cart");
        driver.findElement(cartMenu).click();
    }
}
