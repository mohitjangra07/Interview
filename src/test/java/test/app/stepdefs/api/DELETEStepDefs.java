package test.app.stepdefs.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import test.app.manage.RestAssuredManager;
import test.app.utils.APIConstant;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class DELETEStepDefs {

    public static ResponseOptions<Response> response;
    public static RestAssuredManager restAssuredManager;

    @Given("I perform DELETE operation for {string} with parameters")
    public void iPerformDELETEOperationForWithParameters(String url, DataTable dataTable) {
        restAssuredManager = new RestAssuredManager(url, APIConstant.ApiMethods.DELETE, "");
        Map<String,String> map = new HashMap<>();
        map.put(dataTable.asList().get(0), dataTable.asList().get(1));
        response = restAssuredManager.ExecuteWithPathParams(map);
    }

    @Then("I am able to see response status code as {int} with message as {string}")
    public void iAmAbleToSeeResponseStatusCodeAsWithMessageAs(int statusCode, String message) {
        assertThat(response.getStatusCode()).as("Expected status code is not received").isEqualTo(200);
        assertThat(response.getBody().jsonPath().get("message").equals(message)).as("Deleted petID is not matching").isTrue();
    }
}
