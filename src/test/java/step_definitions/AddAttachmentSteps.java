package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pojo.response.Issue.IssueRes;
import utils.APIUtils;
import utils.TestDataReader;
import java.io.File;
import java.io.IOException;


public class AddAttachmentSteps extends BaseSteps{
    @When("The user sends POST request to add attachment endpoint to specified issue with png file")
    public void theUserSendsPOSTRequestToAddAttachmentEndpointToSpecifiedIssueWithPngFile() throws IOException {
        String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
        String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/attachments";

//        BufferedImage image = ImageLoader.loadImage(System.getProperty("user.dir") + "/src/test/resources/test_data/team-1-screenshot.png");

        File file = new File(System.getProperty("user.dir") + "/src/test/resources/test_data/team-1.txt");

        response = APIUtils.sendPostRequest(request,endpoint,"file",file);
    }

    @And("The attachment id should not be empty or null")
    public void theAttachmentIdShouldNotBeEmptyOrNull() {
    }

    @And("The response creation date must be the same with the date of creation date")
    public void theResponseCreationDateMustBeTheSameWithTheDateOfCreationDate() {
    }
}
