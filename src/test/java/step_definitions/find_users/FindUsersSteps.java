package step_definitions.find_users;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.user.User;
import step_definitions.BaseSteps;
import utils.APIUtils;

import java.util.List;

public class FindUsersSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(FindUsersSteps.class);

	List<User> userList;

	@When("The user sends GET request to find users endpoint with specific {string}")
	public void theUserSendsGETRequestToFindUsersEndpointWithSpecific(String query) {
		response = APIUtils.sendGetRequest(request, FIND_USERS_ENDPOINT, "query", query);
		userList = response.as(new TypeRef<>() {
		});
		logger.info("The user sends GET request to find users endpoint with specific " + query);
	}

	@And("The displayed name and email must contains {string}")
	public void theDisplayedNameAndEmailMustContains(String query) {
		userList.forEach(user -> {
			Assertions.assertThat(user.getDisplayName().contains(query) || user.getEmailAddress().contains(query))
				.isTrue();
		});
		logger.debug("The displayed name and email must contains " + query);
	}

}
