package step_definitions.user;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import pojo.response.user.User;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

public class GetUserSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(GetUserSteps.class);

	User expectedUser = TestDataReader.dataReader("user.json", User.class);

	@When("The user sends GET request to get user endpoint with valid account id")
	public void theUserSendsGETRequestToGetUserEndpointWithValidAccountId() {
		String accountId = expectedUser.getAccountId();
		response = APIUtils.sendGetRequest(request, GET_A_USER_ENDPOINT, "accountId", accountId);
		logger.info("The user sends GET request to get user endpoint with valid account id");
	}

	@And("The user which has this account id should match with response user")
	public void theUserWhichHasThisAccountIdShouldMatchWithResponseUser() {
		User actualUser = response.as(User.class);

		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(actualUser.getDisplayName()).isEqualTo(expectedUser.getDisplayName());
		softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember16x16())
			.isEqualTo(expectedUser.getAvatarUrls().getJsonMember16x16());
		softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember24x24())
			.isEqualTo(expectedUser.getAvatarUrls().getJsonMember24x24());
		softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember32x32())
			.isEqualTo(expectedUser.getAvatarUrls().getJsonMember32x32());
		softAssertions.assertThat(actualUser.getAvatarUrls().getJsonMember48x48())
			.isEqualTo(expectedUser.getAvatarUrls().getJsonMember48x48());
		softAssertions.assertThat(actualUser.getAccountType()).isEqualTo(expectedUser.getAccountType());

		softAssertions.assertAll();

		logger.debug("The user which has this account id should match with response user");
	}

	@When("The user sends GET request to get user endpoint with invalid account id as {string}")
	public void theUserSendsGETRequestToGetUserEndpointWithInvalidAccountIdAs(String accountId) {
		response = APIUtils.sendGetRequest(request, GET_A_USER_ENDPOINT, "accountId", accountId);
		logger.info("The user sends GET request to get user endpoint with valid account id");
	}

}
