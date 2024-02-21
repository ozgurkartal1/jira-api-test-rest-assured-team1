package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.awt.image.BufferedImage;
import java.io.File;
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

    public static Response sendPostRequest(RequestSpecification request, String endpoint, Object body){
        return request.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .post(endpoint);
    }
    public static Response sendPostRequest(RequestSpecification request, String endpoint,String key, File value){
        //.multiPart("file", new File(filePath), "image/png")
        return request
                .multiPart(key,value,"text/plain")
                .when().log().all()
                .post(endpoint);
    }

    public static Response sendPutRequest(RequestSpecification request,String endpoint,Object body){
        return request.contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(body)
                .when()
                .put(endpoint);
    }
    public static Response sendDeleteRequest(RequestSpecification request,String endpoint){
        return request.when()
                .delete(endpoint);
    }



}
