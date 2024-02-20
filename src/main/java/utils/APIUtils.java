package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class APIUtils {

    public static Response sendGetRequest(RequestSpecification request, String endpoint) {
        return request
                .log().all()
                .when().accept("application/json")
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, Map<String, Object> queryParams) {
        return request
                .queryParams(queryParams)
                .when()
                .get(endpoint);
    }

    public static Response sendGetRequest(RequestSpecification request, String endpoint, String key, String value) {
        return request
                .queryParam(key, value)
                .when()
                .get(endpoint);
    }

}
