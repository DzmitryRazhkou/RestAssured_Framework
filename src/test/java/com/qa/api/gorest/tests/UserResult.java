package com.qa.api.gorest.tests;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.util.TestUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserResult {

    String baseURI = "https://gorest.co.in";
    String basePath = "/public/v2/users";

    public static Map<String, String> tokenMap;

    String token = "427b19d3989ddf5b59efd44c95695df96e01627292bc10c16936eaeb9551fe1c";

    @Test
    @Epic("create user go rest api feature implementation ......")
    @Feature("create user API feature ......")
    @Severity(SeverityLevel.MINOR)
    public void createUserWithFullJson() {

        User us = new User("Lemmy Kilmister", "male", "lemmy.kilmister@125.com", "inactive");
        String userJsonPayload = TestUtil.getSerializedJSON(us);
        System.out.println(userJsonPayload);

        tokenMap = new HashMap<>();
        tokenMap.put("Authorization", "Bearer " +token);

//        Response response = RestClient.doPOST("JSON", baseURI, basePath, tokenMap, null, true, userJsonPayload);
//
//        System.out.println(response.statusCode());
//        System.out.println(response.prettyPrint());

        RestAssured.baseURI = baseURI;
        given().log().all()
                .contentType(ContentType.JSON)
                .headers("Authorization", "Bearer " +token)
                .body(userJsonPayload)
                .post(basePath)
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(201);
    }

}
