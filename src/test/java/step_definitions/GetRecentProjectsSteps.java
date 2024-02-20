package step_definitions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.common.mapper.TypeRef;
import org.assertj.core.api.SoftAssertions;
import pojo.response.Project;
import utils.APIUtils;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class GetRecentProjectsSteps extends BaseSteps {

    List<Project> actualProjects;

    SoftAssertions softAssertions = new SoftAssertions();

    @When("The user sends GET request to get recent projects endpoint")
    public void theUserSendsGETRequestToGetRecentProjectsEndpoint() {

        response = APIUtils.sendGetRequest(request, GET_RECENT_PROJECTS_ENDPOINT);
        actualProjects = response.as(new TypeRef<List<Project>>() {
        });
    }

    @And("The response features of projects should match with features in json file")
    public void theResponseFeaturesOfProjectsShouldMatchWithFeaturesInJsonFile() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/test_data/recent-projects.json");
        List<Project> expectedProjects;
        try {
            expectedProjects = mapper.readValue(file, new TypeReference<>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        actualProjects.forEach(project -> {
            softAssertions.assertThat(project.getId()).isEqualTo(expectedProjects.get(actualProjects.indexOf(project)).getId());
            softAssertions.assertThat(project.getEntityId()).isEqualTo(expectedProjects.get(actualProjects.indexOf(project)).getEntityId());
            softAssertions.assertThat(project.getKey()).isEqualTo(expectedProjects.get(actualProjects.indexOf(project)).getKey());
            softAssertions.assertThat(project.getName()).isEqualTo(expectedProjects.get(actualProjects.indexOf(project)).getName());
            softAssertions.assertThat(project.getAvatarUrls().getJsonMember16x16()).isEqualTo(expectedProjects.get(actualProjects.indexOf(project)).getAvatarUrls().getJsonMember16x16());
        });

        softAssertions.assertAll();
    }

    @When("The user sends GET request to get invalid recent projects endpoint as {string}")
    public void theUserSendsGETRequestToGetInvalidRecentProjectsEndpointAs(String endpoint) {
        response = APIUtils.sendGetRequest(request, endpoint);
    }
}
