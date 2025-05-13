package steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;

public class ApiStepDefinitions {

    private Response response;
    private RequestSpecification request;

    @Given("the API is available")
    public void the_api_is_available() {
        RestAssured.baseURI = "http://127.0.0.1:5000";
    
        Response healthCheck = RestAssured
            .given()
            .header("Authorization", "Bearer token") // if needed
            .when()
            .get("/");  // or a known valid endpoint like /users
    
        if (healthCheck.getStatusCode() >= 500) {
            throw new AssertionError("API server is not available. Status code: " + healthCheck.getStatusCode());
        }
    }
    
    @Given("I am not authenticated")
    public void i_am_not_authenticated() {
        RestAssured.baseURI = "http://127.0.0.1";
        RestAssured.port = 5000;
        request = given().auth().none();
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String endpoint) {
        response = RestAssured.given()
            .header("Authorization", "Bearer token")
            .when()
            .get(endpoint);  // Remove baseURI since endpoint already includes the full path
    }

    @When("I send a POST request to {string} with payload {string}")
    public void i_send_a_post_request_to_with_payload(String endpoint, String payload) {
        response = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .post(endpoint);
    }

    @When("I send a PUT request to {string} with payload {string}")
    public void i_send_a_put_request_to_with_payload(String endpoint, String payload) {
        response = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(payload)
            .when()
            .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void i_send_a_delete_request_to(String endpoint) {
        response = RestAssured.given()
            .header("Content-Type", "application/json")
            .when()
            .delete(endpoint);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer expectedStatusCode) {
        assertEquals((int) expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedField) {
        assertTrue(response.getBody().asString().contains(expectedField));
    }
}
