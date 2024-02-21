package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.user.User;
import utils.APIUtils;
import utils.TestDataWriter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllUsersSteps extends BaseSteps{

    List<User> users;

    Map<String, Object> parameters = new HashMap<>();
    @When("The user sends a GET request to get all users endpoint")
    public void theUserSendsAGETRequestToGetAllUsersEndpoint() {
        response = APIUtils.sendGetRequest(request, GET_ALL_USERS_ENDPOINT);
        users = response.as(new TypeRef<>() {
        });

        TestDataWriter.dataWriter(users.get(0), "user.json");
    }

    @And("The response must contain array of users")
    public void theResponseMustContainArrayOfUsers() {
        Assertions.assertThat(users.size()).isGreaterThan(0);
    }

    @When("The user sends a GET request to get all users endpoint with {string} as {int} {string} as {int}")
    public void theUserSendsAGETRequestToGetAllUsersEndpointWithAsAs(String startAt, int value1, String maxResults, int value2) {
        parameters.put(startAt, value1);
        parameters.put(maxResults, value2);

        response = APIUtils.sendGetRequest(request, GET_ALL_USERS_ENDPOINT, parameters);
        users = response.as(new TypeRef<>() {
        });
    }

    @And("The response array of users size must be {int}")
    public void theResponseArrayOfUsersSizeMustBe(int maxResults) {
        Assertions.assertThat(users.size()).isEqualTo(maxResults);
    }

    @When("The user sends a GET request to get all users endpoint with {string} as {string} and {string} as {string}")
    public void theUserSendsAGETRequestToGetAllUsersEndpointWithAsAs(String startAt, String value1, String maxResults, String value2) {
        parameters.put(startAt, value1);
        parameters.put(maxResults, value2);

        response = APIUtils.sendGetRequest(request, GET_ALL_USERS_ENDPOINT, parameters);
    }
}
