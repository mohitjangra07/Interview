package test.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage {

	private By productList = By.xpath("//a[@id='itemc']");

	private By productCards = By.xpath("//div[@id='tbodyid']/div");

	private By nextButton = By.xpath("//button[@id='next2']");

	private By homeMenu = By.xpath("//a[contains(text(),'Home')]");

	private WebDriver driver;

	public Homepage (WebDriver driver){
		this.driver =driver;
	}

	public void navigateToProductCategoryInList(String productCategory) {
		List<WebElement> list = driver.findElements(productList);
		for (WebElement producWebElement : list) {
			if (producWebElement.getText().equalsIgnoreCase(productCategory)) {
				producWebElement.click();
			}
		}
	}

	public boolean selectTheProductCard(final String productName) {
		boolean bol = driver.findElement(getProductCardsTitle(productName)).isDisplayed();
		driver.findElement(getProductCardsTitle(productName)).click();
		return bol;

	}

	public void goToNextPage() {
        driver.findElement(nextButton).click();
	}

	public By getProductCardsTitle(final String name) {
		return By.linkText(name);
	}

	public void goToHomePage(){
		driver.findElement(homeMenu).click();
	}
}
