package step_definitions.issue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.issue.IssueReq;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;
import utils.TestDataWriter;

public class CreateIssueSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(CreateIssueSteps.class);

	@When("The user sends a POST request to the create issue endpoint")
	public void theUserSendsAPOSTRequestToTheCreateIssueEndpoint() {
		IssueReq issueReq = TestDataReader.dataReader("create-issue.json", IssueReq.class);
		response = APIUtils.sendPostRequest(request, POST_CREATE_ISSUE_ENDPOINT, issueReq);
		IssueRes issueRes = response.as(IssueRes.class);
		TestDataWriter.dataWriter(issueRes, "issue-res.json");

		logger.info("The user sends a POST request to the create issue endpoint");
	}

	@And("Validate that issue id is not empty or null")
	public void validateThatIssueIdIsNotEmptyOrNull() {
		String issueId = response.jsonPath().getString("id");
		Assertions.assertThat(issueId).isNotNull();
		Assertions.assertThat(issueId).isNotEmpty();

		logger.debug("Validate that issue id is not empty or null");
	}

	@And("Validate key starts with {string}")
	public void validateKeyStartsWith(String key) {
		Assertions.assertThat(response.jsonPath().getString("key").startsWith(key)).isTrue();

		logger.debug("Validate key starts with " + key);
	}

	@When("The user sends a POST request to the create with invalid key value")
	public void theUserSendsAPOSTRequestToTheCreateWithInvalidEndpoint() {
		IssueReq issueReq = TestDataReader.dataReader("create-issue.json", IssueReq.class);
		issueReq.getFields().getProject().setKey("TE");
		response = APIUtils.sendPostRequest(request, POST_CREATE_ISSUE_ENDPOINT, issueReq);

		logger.info("The user sends a POST request to the create with invalid key value");
	}

}
