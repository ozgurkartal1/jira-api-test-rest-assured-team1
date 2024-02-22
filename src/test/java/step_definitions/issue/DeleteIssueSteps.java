package step_definitions.issue;

import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

public class DeleteIssueSteps extends BaseSteps {
    Logger logger= LogManager.getLogger(DeleteIssueSteps.class);
    @When("The user sends DELETE request to the delete issue endpoint")
    public void theUserSendsDELETERequestToTheDeleteIssueEndpoint() {
        String id = TestDataReader.dataReader("issue-res.json", IssueRes.class).getId();
        String endpoint=POST_CREATE_ISSUE_ENDPOINT+"/"+id;
        response = APIUtils.sendDeleteRequest(request,endpoint);

        logger.info("The user sends DELETE request to the delete issue endpoint");
    }
}
