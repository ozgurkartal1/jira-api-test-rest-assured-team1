package step_definitions.project;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import step_definitions.BaseSteps;
import utils.APIUtils;

public class GetProjectSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(GetProjectSteps.class);

	@When("The user sends GET request to the get project endpoint with specific {string}")
	public void theUserSendsGETRequestToTheGetProjectEndpointWithSpecific(String key) {
		String endpoint = GET_PROJECT_ENDPOINT + "/" + key;
		response = APIUtils.sendGetRequest(request, endpoint);

		logger.info("The user sends GET request to the get project endpoint with specific " + key);
	}

	@And("The response should be equal key value as {string}")
	public void theResponseShouldContainsKeyValueAs(String key) {
		Assertions.assertThat(response.jsonPath().getString("key")).isEqualTo(key);

		logger.debug("The response should be equal key value as " + key);
	}

}
