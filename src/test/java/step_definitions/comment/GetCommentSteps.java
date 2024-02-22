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



public class GetCommentSteps extends BaseSteps {
    AddComment addComment;
    String key;
    Logger logger= LogManager.getLogger(GetCommentSteps.class);

    @When("The user sends a GET request to get comment with specific comment id")
    public void theUserSendsAGETRequestToGetCommentWithSpecificCommentId() {
        key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment/" + commentId;
        response = APIUtils.sendGetRequest(request, endpoint);
        logger.info("The user sends a GET request to get comment with specific comment id");
    }

    @And("The response information should match with created comment information")
    public void theResponseInformationShouldMatchWithCreatedCommentInformation() {
        SoftAssertions softAssertions = new SoftAssertions();
        addComment = TestDataReader.dataReader("add-comment.json", AddComment.class);

        String actualText = response.jsonPath().getString("body.content[0].content[0].text");
        String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();

        softAssertions.assertThat(actualText).isEqualTo(expectedText);

        String actualType = response.jsonPath().getString("body.content[0].type");
        String expectedType = addComment.getBody().getContent().get(0).getType();

        softAssertions.assertThat(actualType).isEqualTo(expectedType);

        String actualBodyType = response.jsonPath().getString("body.type");
        String expectedBodyType = addComment.getBody().getType();

        softAssertions.assertThat(actualBodyType).isEqualTo(expectedBodyType);

        softAssertions.assertAll();
        logger.debug("The response information should match with created comment information");
    }

    @When("The user sends a GET request to get comment with invalid comment id as {string}")
    public void theUserSendsAGETRequestToGetCommentWithInvalidCommentIdAs(String commentId) {
        key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String wrongEndpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment/" + commentId;
        response = APIUtils.sendGetRequest(request, wrongEndpoint);
        logger.info("The user sends a GET request to get comment with invalid comment id as " +commentId);
    }


    @And("The error message {string}")
    public void theErrorMessage(String errorMessage) {
        String actualErrorMessage = response.jsonPath().getString("errorMessages[0]");
        Assertions.assertThat(actualErrorMessage).isEqualTo(errorMessage);
        logger.debug("The error message " +errorMessage);
    }

    @When("The user sends a GET request to  invalid get comment endpoint with specific comment id")
    public void theUserSendsAGETRequestToInvalidGetCommentEndpointWithSpecificCommentId() {
        key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String wrongUrl = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/commen/" + commentId;
        response = APIUtils.sendGetRequest(request, wrongUrl);
        logger.info("The user sends a GET request to  invalid get comment endpoint with specific comment id");
    }

    @And("The error message should be {string}")
    public void theErrorMessageShouldBe(String errorMessage) {
        String actualErrorMessage = response.jsonPath().getString("message");
        Assertions.assertThat(actualErrorMessage.startsWith(errorMessage)).isTrue();
        logger.debug("The error message should be "+errorMessage);

    }
}
