package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;

public class CommonSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(CommonSteps.class);

	@Given("The user is in base URI")
	public void theUserIsInBaseURI() {
		request = RestAssured.given();
		logger.info("The user is in base URI");
	}

	@And("The authentication is completed to reach jira apis")
	public void theAuthenticationIsCompletedToReachJiraApis() {
		String username = System.getenv("jiraUsername");
		String token = System.getenv("jiraToken");

		request = request.auth().preemptive().basic(username, token);

		logger.info("The authentication is completed to reach jira apis");
	}

	@Then("The status code should be {int}")
	public void theStatusCodeShouldBe(int statusCode) {
		Assertions.assertThat(response.getStatusCode()).isEqualTo(statusCode);
		logger.debug("The status code should be " + statusCode);
	}

}
