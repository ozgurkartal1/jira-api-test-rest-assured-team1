package step_definitions.comment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import pojo.request.add_comment.AddComment;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

public class UpdateCommentSteps extends BaseSteps {

	String key;

	AddComment addComment;

	Logger logger = LogManager.getLogger(UpdateCommentSteps.class);

	@When("The user sends PUT request to the update comment endpoint with specific comment id")
	public void theUserSendsPUTRequestToTheUpdateCommentEndpointWithSpecificCommentId() {
		addComment = TestDataReader.dataReader("update-comment.json", AddComment.class);

		key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
		String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment/" + commentId;

		response = APIUtils.sendPutRequest(request, endpoint, addComment);
		logger.info("The user sends PUT request to the update comment endpoint with specific comment id");
	}

	@And("The user validates that text has been updated as expected")
	public void theUserValidatesThatTextHasBeenUpdatedAsExpected() {
		SoftAssertions assertions = new SoftAssertions();
		String actualText = response.jsonPath().getString("body.content[0].content[0].text");
		String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();
		assertions.assertThat(actualText).isEqualTo(expectedText);

		assertions.assertAll();
		logger.debug("The user validates that text has been updated as expected");
	}

	@When("The user sends PUT request to the update comment endpoint with invalid comment id as {string}")
	public void theUserSendsPUTRequestToTheUpdateCommentEndpointWithInvalidCommentIdAs(String invalidCommentId) {
		addComment = TestDataReader.dataReader("update-comment.json", AddComment.class);

		key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
		String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment/" + invalidCommentId;

		response = APIUtils.sendPutRequest(request, endpoint, addComment);
		logger.info("The user sends PUT request to the update comment endpoint with invalid comment id as "
				+ invalidCommentId);
	}

	@And("The error message should be displayed")
	public void theErrorMessageShouldBeDisplayed() {
		Assertions.assertThat(response.jsonPath().getString("errorMessages[0]")).isNotEmpty();
		logger.debug("The error message should be displayed");

	}

}
