package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import utils.APIUtils;

public class GetProjectSteps extends BaseSteps{
    @When("The user sends GET request to the get project endpoint with specific {string}")
    public void theUserSendsGETRequestToTheGetProjectEndpointWithSpecific(String key) {
        String endpoint = GET_PROJECT_ENDPOINT + "/" + key;
        response = APIUtils.sendGetRequest(request, endpoint);
    }

    @And("The response should be equal key value as {string}")
    public void theResponseShouldContainsKeyValueAs(String key) {
        Assertions.assertThat(response.jsonPath().getString("key")).isEqualTo(key);
    }
}
