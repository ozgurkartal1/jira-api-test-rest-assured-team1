package step_definitions.attachment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import pojo.response.Issue.IssueRes;
import step_definitions.BaseSteps;
import utils.APIUtils;
import utils.TestDataReader;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAttachmentSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(AddAttachmentSteps.class);

	@When("The user sends POST request to add attachment endpoint to specified issue with txt file")
	public void theUserSendsPOSTRequestToAddAttachmentEndpointToSpecifiedIssueWithPngFile() throws IOException {
		String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
		String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + key + "/attachments";

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/test_data/team-1.txt");

		response = APIUtils.sendPostRequest(request, endpoint, "file", file);

		attachmentId = response.jsonPath().getString("id");

		logger.info("The user sends POST request to add attachment endpoint to specified issue with txt file");
	}

	@And("The attachment id should not be empty or null")
	public void theAttachmentIdShouldNotBeEmptyOrNull() {
		Assertions.assertThat(attachmentId).isNotEmpty();
		Assertions.assertThat(attachmentId).isNotNull();

		logger.debug("The attachment id should not be empty or null");
	}

	@And("The response creation date must be the same with the date of creation date")
	public void theResponseCreationDateMustBeTheSameWithTheDateOfCreationDate() {
		Date date = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String expectedTime = dateFormatter.format(date);
		String actualTime = response.jsonPath().getString("created");
		actualTime = actualTime.split("T")[0].substring(1);
		Assertions.assertThat(actualTime).isEqualTo(expectedTime);

		logger.debug("The response creation date must be the same with the date of creation date");
	}

	@When("The user sends POST request to add attachment endpoint with invalid {string} key with txt file")
	public void theUserSendsPOSTRequestToAddAttachmentEndpointWithInvalidIdWithTxtFile(String invalidIssueKey) {
		String key = TestDataReader.dataReader("issue-res.json", IssueRes.class).getKey();
		String endpoint = POST_CREATE_ISSUE_ENDPOINT + "/" + invalidIssueKey + "/attachments";

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/test_data/team-1.txt");

		response = APIUtils.sendPostRequest(request, endpoint, "file", file);

		logger.info("The user sends POST request to add attachment endpoint with invalid" + invalidIssueKey
				+ "key with txt file");
	}

}
