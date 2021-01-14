package test.app.stepdefs.ui;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.log4j.Log4j2;
import test.app.manage.BaseTestSteps;
import test.app.pages.CartPage;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class CartPageStepDef {
    CartPage cartPage = new CartPage(BaseTestSteps.getDriverInstance());
    public static String expectedAmount = null;

    @And("^I delete the product from cart$")
    public void iOpenTheCartDeleteProductFromCart(DataTable dataTable){
        cartPage.clickDeleteButton(dataTable.asList().get(1));
        expectedAmount = cartPage.getCartAmountValue();
    }


    @And("Fill the form with {string} {string} {string} {string} {string} {string} and click Purchase")
    public void fillTheFormWith(String name, String country, String city, String creditCard, String month, String year) {
        log.info("Filling the form");
        cartPage.enterName(name);
        cartPage.enterCountry(country);
        cartPage.enterCity(city);
        cartPage.enterCreditCard(creditCard);
        cartPage.enterMonth(month);
        cartPage.enterYear(year);
        cartPage.clickPurchase();
    }

    @And("I click on Place Order")
    public void iClickOnPlaceOrder() {
        cartPage.clickPlaceOrder();
    }

    @Then("I validate the purchase Amount is as expected and click Ok")
    public void iValidateThePurchaseAmountIsAsExpectedAndClickOk() {
        String [] data = cartPage.getTranactionDetails().split("\n");
        log.info(" Transaction details upon completion Transaction ID %s and Transaction amount %s", data[0],data[1]);
        assertThat(data[1]).as("Amount is not matching").isEqualTo("Amount: "+expectedAmount+" USD");
        cartPage.clickOK();
    }
}
