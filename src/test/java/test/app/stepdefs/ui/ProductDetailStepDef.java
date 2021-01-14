package test.app.stepdefs.ui;

import io.cucumber.java.en.And;
import test.app.manage.BaseTestSteps;
import test.app.pages.Homepage;
import test.app.pages.ProductDetailPage;

public class ProductDetailStepDef {

    ProductDetailPage productDetailPage = new ProductDetailPage(BaseTestSteps.getDriverInstance());

    @And("I click on Add to Cart button and accept the popup")
    public void iClickOnAddToCartButtonAndAcceptThePopup() {
        productDetailPage.clickOnAddToCart();
        productDetailPage.acceptAlerts();
    }

    @And("^I Open the cart$")
    public void iOpenTheCartDeleteProductFromCart(){
        productDetailPage.openCart();
    }
}
