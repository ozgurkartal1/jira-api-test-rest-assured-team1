package step_definitions.comment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

public class DeleteCommentSteps extends BaseSteps {

	String key;

	String endpoint;

	Logger logger = LogManager.getLogger(DeleteCommentSteps.class);

	@When("The user sends DELETE request to the delete comment endpoint with specific comment id")
	public void theUserSendsDELETERequestToTheDeleteCommentEndpointWithSpecificCommentId() {
		key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
		endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment/" + commentId;

		response = APIUtils.sendDeleteRequest(request, endpoint);
		logger.info("The user sends DELETE request to the delete comment endpoint with specific comment id");
	}

	@And("Verify that the specific comment is deleted")
	public void verifyThatTheSpecificCommentIsDeleted() {
		response = APIUtils.sendGetRequest(request, endpoint);
		Assertions.assertThat(response.getStatusCode()).isEqualTo(404);

		logger.debug("Verify that the specific comment is deleted");
	}

}
