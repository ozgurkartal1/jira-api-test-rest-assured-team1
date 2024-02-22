package step_definitions.issue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import pojo.request.edit_issue.EditIssue;
import pojo.request.issue.IssueReq;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;
import utils.TestDataWriter;


public class EditIssueSteps extends BaseSteps {
    String endPoint;
    String key;
    EditIssue editIssue;


    @When("The user sends PUT request to the edit issue endpoint with creating issue key")
    public void theUserSendsPUTRequestToTheEditIssueEndpointWithCreatingIssueKey() {
        key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        endPoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key;
        editIssue = TestDataReader.dataReader("edit-issue.json", EditIssue.class);
        response = APIUtils.sendPutRequest(request, endPoint, editIssue);
    }

    @And("Validate that issue has been updated successfully")
    public void validateThatIssueHasBeenUpdatedSuccessfully() {
        response = APIUtils.sendGetRequest(request, endPoint);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(response.jsonPath().getString("fields.summary")).isEqualTo(editIssue.getUpdate().getSummary().get(0).getSet());
        softAssertions.assertAll();

    }


    @When("The user sends PUT request to the edit issue endpoint with creating id")
    public void theUserSendsPUTRequestToTheEditIssueEndpointWithCreatingId() {
        String id = TestDataReader.dataReader("issue-res.json", IssueRes.class).getId();
        endPoint = POST_CREATE_ISSUE_ENDPOINT + "/" + id;
        editIssue = TestDataReader.dataReader("edit-issue.json", EditIssue.class);
        response = APIUtils.sendPutRequest(request, endPoint, editIssue);
    }
}
