package step_definitions.attachment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import step_definitions.BaseSteps;
import utils.APIUtils;

public class DeleteAttachmentSteps extends BaseSteps {

	Logger logger = LogManager.getLogger(DeleteAttachmentSteps.class);

	@When("The user sends DELETE request to delete attachment endpoint with attachment id")
	public void theUserSendsDELETERequestToDeleteAttachmentEndpointWithAttachmentId() {
		String endpoint = DELETE_ATTACHMENT_ENDPOINT + "/" + attachmentId.substring(1, attachmentId.length() - 1);
		response = APIUtils.sendDeleteRequest(request, endpoint);

		logger.info("The user sends DELETE request to delete attachment endpoint with attachment id");
	}

	@And("Validate that the specified attachment deleted")
	public void validateThatTheSpecifiedAttachmentDeleted() {
		Assertions.assertThat(response.jsonPath().getList("fields.attachment")).isEmpty();

		logger.debug("Validate that the specified attachment deleted");
	}

}
