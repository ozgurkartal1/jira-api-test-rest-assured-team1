package step_definitions;

import io.cucumber.java.en.When;
import pojo.response.Issue.IssueRes;
import utils.APIUtils;
import utils.TestDataReader;

public class DeleteIssueSteps extends BaseSteps {
    @When("The user sends DELETE request to the delete issue endpoint")
    public void theUserSendsDELETERequestToTheDeleteIssueEndpoint() {
        String id = TestDataReader.dataReader("issue-res.json", IssueRes.class).getId();
        String endpoint=POST_CREATE_ISSUE_ENDPOINT+"/"+id;
        response = APIUtils.sendDeleteRequest(request,endpoint);
    }
}
