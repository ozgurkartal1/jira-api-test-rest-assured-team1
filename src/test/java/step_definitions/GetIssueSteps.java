package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.Issue.IssueRes;
import pojo.response.user.AvatarUrls;
import utils.APIUtils;
import utils.TestDataReader;

public class GetIssueSteps extends BaseSteps {
    IssueRes issueRes;

    @When("The user sends GET request to the get issue endpoint with created issue key")
    public void theUserSendsGETRequestToTheGetIssueEndpointWithCreatedIssueKey() {
        issueRes = TestDataReader.dataReader("issue-res.json", IssueRes.class);
        String endPoint = POST_CREATE_ISSUE_ENDPOINT + "/" + issueRes.getKey();
        response = APIUtils.sendGetRequest(request, endPoint);
    }

    @And("The response id and key should match with created id and key")
    public void theResponseIdAndKeyShouldMatchWithCreatedIdAndKey() {
        String actualId = response.jsonPath().getString("id");
        String actualKey = response.jsonPath().getString("key");

        Assertions.assertThat(actualId).isEqualTo(issueRes.getId());
        Assertions.assertThat(actualKey).isEqualTo(issueRes.getKey());
    }

    @And("The self and avatarURLs shouldn't be empty")
    public void theSelfAndAvatarURLsShouldntBeEmpty() {
        Assertions.assertThat(response.jsonPath().getString("self")).isNotEmpty();
        Assertions.assertThat(response.jsonPath().getObject("fields.project.avatarUrls", AvatarUrls.class)).isNotNull();
    }
}