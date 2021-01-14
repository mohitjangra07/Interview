package test.app.manage;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import lombok.extern.log4j.Log4j2;
import test.app.utils.APIConstant;

import java.util.Map;

@Log4j2
public class RestAssuredManager {

    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private String method;
    private String url;

    /**
     * RestAssuredExtensionv2 constructor to pass the initial settings for the the following method
     * @param uri
     * @param method
     * @param token
     */
    public RestAssuredManager(String uri, String method, String token) {

        //Formulate the API url
        this.url = "https://petstore.swagger.io/v2" + uri;
        this.method = method;
    }

    /**
     * ExecuteAPI to execute the API for GET/POST/DELETE
     * @return ResponseOptions<Response>
     */
    private ResponseOptions<Response> ExecuteAPI() {
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.contentType(ContentType.JSON);
        request.spec(requestSpecification);
        log.info("Hitting %s request", this.method);
        if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
            return request.post(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
            return request.delete(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
            return request.get(this.url);
        else if(this.method.equalsIgnoreCase(APIConstant.ApiMethods.PUT))
            return request.put(this.url);
        return null;
    }

    /**
     * Executing API with query params being passed as the input of it
     * @param queryPath
     * @return Reponse
     */
    public ResponseOptions<Response> ExecuteWithQueryParams(Map<String, String> queryPath) {
        log.info("Adding query parameter to the request");
        builder.addQueryParams(queryPath);
        return ExecuteAPI();
    }

    /**
     * ExecuteWithPathParams
     * @param pathParams
     * @return
     */
    public ResponseOptions<Response> ExecuteWithPathParams(Map<String, String> pathParams) {
        log.info("Adding path parameters");
        builder.addPathParams(pathParams);
        return ExecuteAPI();
    }

    public ResponseOptions<Response> ExecuteWithBody(Object body) {
        log.info("Setting the request body");
        builder.setBody(body);
        return ExecuteAPI();
    }
}
