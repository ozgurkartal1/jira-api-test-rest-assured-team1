package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import pojo.request.add_comment.AddComment;
import pojo.response.Issue.IssueRes;
import utils.APIUtils;
import utils.TestDataReader;

public class AddCommentSteps extends BaseSteps {

    AddComment addComment;
    @When("The user sends POST request to add comment endpoint with specific issue key")
    public void theUserSendsPOSTRequestToAddCommentEndpointWithSpecificIssueKey() {
        String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/comment";

        addComment = TestDataReader.dataReader("add-comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(request,endpoint,addComment);
    }

    @And("The comment id should not be empty or null")
    public void theCommentIdShouldNotBeEmptyOrNull() {
        String actualCommentId = response.jsonPath().getString("id");

        Assertions.assertThat(actualCommentId).isNotEmpty();
        Assertions.assertThat(actualCommentId).isNotNull();
    }

    @And("The response text should be same with the given text in json file")
    public void theResponseTextShouldBeSameWithTheGivenTextInJsonFile() {
        String expectedText = addComment.getBody().getContent().get(0).getContent().get(0).getText();

        String actualText = response.jsonPath().getString("body.content[0].content[0].text");

        Assertions.assertThat(actualText).as("The text is not true!").isEqualTo(expectedText);
    }
    @When("The user sends POST request to wrong {string}")
    public void theUserSendsPOSTRequestToWrong(String wrongEndpoint) {
        String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + wrongEndpoint;

        addComment = TestDataReader.dataReader("add-comment.json", AddComment.class);

        response = APIUtils.sendPostRequest(request,endpoint,addComment);
    }
}
