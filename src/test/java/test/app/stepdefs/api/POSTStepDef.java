package test.app.stepdefs.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import lombok.var;
import org.assertj.core.api.SoftAssertions;
import test.app.manage.RestAssuredManager;
import test.app.model.PetsModel;
import test.app.utils.APIConstant;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class POSTStepDef {

    public static ResponseOptions<Response> response;
    public static RestAssuredManager restAssuredManager;

    @Given("I Perform POST operation for {string} with body")
    public void i_Perform_POST_operation_for_with_body(String url, DataTable dataTable) {
        restAssuredManager = new RestAssuredManager(url, APIConstant.ApiMethods.POST, "");
        PetsModel petsModel = new PetsModel();
        for (Map<String, String> data : dataTable.asMaps()) {
            petsModel.setPhotoUrls(new String[]{data.get(APIConstant.Keys.PHOTOURLS)});
            petsModel.setName(data.get(APIConstant.Keys.NAME));
            petsModel.setId(data.get(APIConstant.Keys.ID));
            petsModel.setStatus(data.get(APIConstant.Keys.STATUS));
        }
        response = restAssuredManager.ExecuteWithBody(petsModel);
    }

    @Then("I validate new pet is added with name as {string} and id as {string} with Status as {string}")
    public void iShouldSeeTheBodyHasNameAsAndIdAsWithStatusAs(String name, String id, String status) {
        var result = response.body().as(new PetsModel().getClass());
        assertThat(response.getStatusCode()).as("Expected Status code is not returned").isEqualTo(200);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(result.getId()).as("Response 'id' value is not matching").isEqualTo(id);
        softAssertions.assertThat(result.getName()).as("Response 'name' value is not matching").isEqualTo(name);
        softAssertions.assertThat(result.getStatus()).as("Response 'status' value is not matching").isEqualTo(status);
        softAssertions.assertAll();
    }
}
