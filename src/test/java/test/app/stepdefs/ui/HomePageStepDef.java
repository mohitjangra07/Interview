package test.app.stepdefs.ui;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import test.app.manage.BaseTestSteps;
import test.app.pages.Homepage;

public class HomePageStepDef {

    Homepage homepage = new Homepage(BaseTestSteps.getDriverInstance());


    @Given("^I am on the homepage$")
    public void iAmOnHomePage() {
        homepage.goToHomePage();
    }


    @When("I select the {string} from Homepage")
    public void iSelectTheFromHomepage(String category) {
        homepage.navigateToProductCategoryInList(category);
    }

    @And("I select product from available product cards")
    public void iSelectProductFromAvailableProductCards(DataTable dataTable) {
        int maxTry = 2;
        do {
            if (homepage.selectTheProductCard(dataTable.asList().get(1))) {
                break;
            }
            ;
            homepage.goToNextPage();
            maxTry--;
        } while (maxTry > 0);

    }

    @And("I click Home menu on the home page")
    public void iClickMenuOnTheHomePage() {
        homepage.goToHomePage();
    }
}
