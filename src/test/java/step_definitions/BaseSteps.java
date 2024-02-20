package step_definitions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigManager;

public abstract class BaseSteps {

    protected static RequestSpecification request;

    protected static Response response;

    protected final String GET_ALL_USERS_ENDPOINT;

    protected final String GET_A_USER_ENDPOINT;

    protected final String FIND_USERS_ENDPOINT;

    protected final String GET_RECENT_PROJECTS_ENDPOINT;

    protected final String GET_PROJECT_ENDPOINT;

    protected final String POST_CREATE_ISSUE_ENDPOINT;

    public BaseSteps() {
       RestAssured.baseURI = ConfigManager.getProperty("BaseURI");
       GET_ALL_USERS_ENDPOINT = ConfigManager.getProperty("api.get.all.users.endpoint");
       GET_A_USER_ENDPOINT = ConfigManager.getProperty("api.get.user.endpoint");
       FIND_USERS_ENDPOINT = ConfigManager.getProperty("api.find.users.endpoint");
       GET_RECENT_PROJECTS_ENDPOINT = ConfigManager.getProperty("api.get.recent.projects.endpoint");
       GET_PROJECT_ENDPOINT = ConfigManager.getProperty("api.get.project.endpoint");
        POST_CREATE_ISSUE_ENDPOINT = ConfigManager.getProperty("api.create.issue.endpoint");
    }
}
