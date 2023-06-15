package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import projectResources.APIResources;
import projectResources.dataBuild;
import projectResources.utils;
import java.io.FileNotFoundException;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class stepDefinition extends utils  {

    public RequestSpecification requestSpecification;
    public Response res;
    dataBuild build = new dataBuild();
    static String place_id;


    public stepDefinition() throws Exception {
    }

    @Given("Add Place Payload")
    public void add_place_payload() throws FileNotFoundException {

        requestSpecification = given().spec(requestSpecifications()).body(build.addPlacePayload());

    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String httpMethod) {
       APIResources resources =  APIResources.valueOf(resource);

       if (httpMethod.equalsIgnoreCase("Post"))
       {
           res = requestSpecification.when().post(resources.getResource());

       }
       else if (httpMethod.equalsIgnoreCase("Get"))
       {
           res = requestSpecification.when().get(resources.getResource());
       }

    }

    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(Integer int1) {
        assertEquals(res.getStatusCode(), 200);
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        assertEquals(jsonPathFunctionality(res, key), value);
    }

    @Then("verify place_id created using {string}")
    public void verify_place_id_created_using(String methodName) throws FileNotFoundException {

        place_id = jsonPathFunctionality(res, "place_id");

        requestSpecification =  given().spec(requestSpecifications()).queryParam("place_id", place_id);
        user_calls_with_http_request(methodName, "Get");

        String actualName = jsonPathFunctionality(res,"name");
        assertEquals(data.getAddress(), actualName);
    }

    @Then("deletePlaceAPI Payload")
    public void deletePlaceAPI_Payload() throws FileNotFoundException {
        requestSpecification =  given().spec(requestSpecifications()).body(build.deletePayload(place_id));

    }

}
