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



public class GetIssueSteps extends BaseSteps {
    IssueRes issueRes;
    IssueReq issueReq;
    Logger logger= LogManager.getLogger(GetIssueSteps.class);

    @When("The user sends GET request to the get issue endpoint with created issue key")
    public void theUserSendsGETRequestToTheGetIssueEndpointWithCreatedIssueKey() {
        issueRes = TestDataReader.dataReader("issue-res.json", IssueRes.class);
        String endPoint = POST_CREATE_ISSUE_ENDPOINT + "/" + issueRes.getKey();
        response = APIUtils.sendGetRequest(request, endPoint);

        logger.info("The user sends GET request to the get issue endpoint with created issue key");
    }

    @And("The response id and key should match with created id and key")
    public void theResponseIdAndKeyShouldMatchWithCreatedIdAndKey() {
        String actualId = response.jsonPath().getString("id");
        String actualKey = response.jsonPath().getString("key");

        Assertions.assertThat(actualId).isEqualTo(issueRes.getId());
        Assertions.assertThat(actualKey).isEqualTo(issueRes.getKey());

        logger.debug("The response id and key should match with created id and key");
    }

    @And("The self and avatarURLs shouldn't be empty")
    public void theSelfAndAvatarURLsShouldntBeEmpty() {
        issueReq =TestDataReader.dataReader("create-issue.json", IssueReq.class);
        Assertions.assertThat(response.jsonPath().getString("fields.project.key")).isEqualTo(issueReq.getFields().getProject().getKey());
        Assertions.assertThat(response.jsonPath().getString("fields.summary")).isEqualTo(issueReq.getFields().getSummary());
        Assertions.assertThat(response.jsonPath().getString("fields.description.type")).isEqualTo(issueReq.getFields().getDescription().getType());
        Assertions.assertThat(response.jsonPath().getInt("fields.description.version")).isEqualTo(issueReq.getFields().getDescription().getVersion());
        Assertions.assertThat(response.jsonPath().getString("fields.description.content[0].type")).isEqualTo(issueReq.getFields().getDescription().getContent().get(0).getType());
        Assertions.assertThat(response.jsonPath().getString("fields.description.content[0].content[0].text")).isEqualTo(issueReq.getFields().getDescription().getContent().get(0).getContent().get(0).getText());
        Assertions.assertThat(response.jsonPath().getString("fields.description.content[0].content[0].type")).isEqualTo(issueReq.getFields().getDescription().getContent().get(0).getContent().get(0).getType());

        logger.debug("The self and avatarURLs shouldn't be empty");

    }

    @When("The user sends GET request to the get issue endpoint with created id")
    public void theUserSendsGETRequestToTheGetIssueEndpointWithCreatedId() {
        issueRes = TestDataReader.dataReader("issue-res.json", IssueRes.class);
        String endPoint = POST_CREATE_ISSUE_ENDPOINT + "/" + issueRes.getId();
        response = APIUtils.sendGetRequest(request, endPoint);

        logger.info("The user sends GET request to the get issue endpoint with created id");
    }
}