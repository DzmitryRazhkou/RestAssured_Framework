package com.qa.api.gorest.tests;

import com.qa.api.gorest.restclient.RestClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



public class GetUser {

    String baseURI = "https://gorest.co.in";
    String basePath = "/public/v2/users";
    public static Map<String, String> tokenMap;
    String token = "427b19d3989ddf5b59efd44c95695df96e01627292bc10c16936eaeb9551fe1c";

    @Epic("get user go api feature implementation ......")
    @Feature("Get user API feature ......")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void getAllUserListAPI_Test() {
        tokenMap = new HashMap<>();
        tokenMap.put("Authorization", "Bearer " + token);


        Response response = RestClient.doGET("JSON", baseURI, basePath, tokenMap, null, true);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }

    @Epic("get all users list api test with query parameters ... verify all users list from get all....")
    @Feature("Get user API feature ......")
    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2)
    public void getUserWithQueryParams_Test() {
        Map<String, String> params = new HashMap<>();
        params.put("name", "Rukmin Kakkar Esq.");
        params.put("status", "active");

        Response response = RestClient.doGET("JSON", baseURI, basePath, tokenMap, params, true);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
    }


}
