package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.Assertions;
import pojo.response.User;
import utils.APIUtils;

import java.util.List;

public class FindUsersSteps extends BaseSteps{

    List<User> userList;
    @When("The user sends GET request to find users endpoint with specific {string}")
    public void theUserSendsGETRequestToFindUsersEndpointWithSpecific(String query) {
        response = APIUtils.sendGetRequest(request, FIND_USERS_ENDPOINT, "query", query);
        userList = response.as(new TypeRef<>() {
        });
    }

    @And("The displayed name and email must contains {string}")
    public void theDisplayedNameAndEmailMustContains(String query) {
        userList.forEach(user -> {
            Assertions.assertThat(user.getDisplayName().contains(query) || user.getEmailAddress().contains(query)).isTrue();
        });
    }
}
