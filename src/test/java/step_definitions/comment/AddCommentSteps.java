package step_definitions.comment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.request.add_comment.AddComment;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

public class AddCommentSteps extends BaseSteps {
    Logger logger= LogManager.getLogger(AddCommentSteps.class);
    AddComment addComment;
    @When("The user sends POST request to add comment endpoint with specific issue key")
    public void theUserSendsPOSTRequestToAddCommentEndpointWithSpecificIssueKey() {
        String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment";

        addComment = TestDataReader.dataReader("add-comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(request,endpoint,addComment);

        commentId=response.jsonPath().getString("id");
        logger.info("The user sends POST request to add comment endpoint with specific issue key");
    }

    @And("The comment id should not be empty or null")
    public void theCommentIdShouldNotBeEmptyOrNull() {
        String actualCommentId = response.jsonPath().getString("id");

        Assertions.assertThat(actualCommentId).isNotEmpty();
        Assertions.assertThat(actualCommentId).isNotNull();
        logger.debug("The comment id should not be empty or null");
    }

    @And("The response text should be same with the given text in json file")
    public void theResponseTextShouldBeSameWithTheGivenTextInJsonFile() {
        String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();

        String actualText = response.jsonPath().getString("body.content[0].content[0].text");

        Assertions.assertThat(actualText).as("The text is not true!").isEqualTo(expectedText);
        logger.debug("The response text should be same with the given text in json file");
    }
    @When("The user sends POST request to wrong {string}")
    public void theUserSendsPOSTRequestToWrong(String wrongEndpoint) {
        String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + wrongEndpoint;

        addComment = TestDataReader.dataReader("add-comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(request,endpoint,addComment);
        logger.info("The user sends POST request to wrong "+wrongEndpoint);
    }
}
