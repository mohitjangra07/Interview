package test.app.stepdefs.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import lombok.var;
import org.assertj.core.api.SoftAssertions;
import test.app.manage.RestAssuredManager;
import test.app.model.PetsModel;
import test.app.utils.APIConstant;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class GETStepDefs {

    public static ResponseOptions<Response> response;
    public static RestAssuredManager restAssuredManager;

    @Given("I perform GET operation for {string} with parameters")
    public void i_perform_GET_operation_for(String url, Map<String, String> data) {
        restAssuredManager = new RestAssuredManager(url, APIConstant.ApiMethods.GET, "");
        response = restAssuredManager.ExecuteWithQueryParams(data);
    }

    @Then("I am able to see mandatory fields 'name' and 'photoUrls' are present with status as {string} in response")
    public void iAmAbleToSeeMandatoryFieldsNameAndPhotoUrlsArePresentWithStatusAsInResponse(String status) {
        var res = Arrays.asList(response.getBody().as(PetsModel[].class));
        var actualNamesField = res.stream().filter(pet -> pet.getName().equals(null)).collect(Collectors.toList());
        var actualPhotoUrlField = res.stream().filter(pet -> pet.getPhotoUrls().equals(null)).collect(Collectors.toList());
        var actualStatus = res.stream().allMatch(pet -> pet.getStatus().equals(status));

        assertThat(response.getStatusCode()).as("Expected status code is not received").isEqualTo(200);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualNamesField.size()).as("Response is missing mandatory name field %s \n", actualNamesField).isEqualTo(0);
        softAssertions.assertThat(actualPhotoUrlField.size()).as("Response is missing mandatory photoUrls field %s \n", actualPhotoUrlField).isEqualTo(0);
        softAssertions.assertThat(actualStatus).as("All the entries does not have status as %s ", status).isTrue();
        softAssertions.assertAll();
    }
}
