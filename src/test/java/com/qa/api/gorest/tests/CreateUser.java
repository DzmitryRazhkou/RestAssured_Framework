package com.qa.api.gorest.tests;

import com.qa.api.gorest.pojo.User;
import com.qa.api.gorest.restclient.RestClient;
import com.qa.api.gorest.util.ExcelUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateUser {

    String baseURI = "https://gorest.co.in";
    String basePath = "/public/v2/users";

    public static Map<String, String> tokenMap;

    String token = "427b19d3989ddf5b59efd44c95695df96e01627292bc10c16936eaeb9551fe1c";

    @DataProvider
    public Object[][] getUserData(){
        Object userData[][] = ExcelUtil.getTestData("userData");
        return userData;
    }
    @Epic("create user go rest api feature implementation ......")
    @Feature("create user API feature ......")
    @Severity(SeverityLevel.MINOR)
    @Test(dataProvider = "getUserData")
    public void createUserTest(String name, String gender, String email, String status) {
//        User us = new User("Tom Delonge", "male", "tom.delonge@135.com", "inactive");

        tokenMap = new HashMap<>();
        tokenMap.put("Authorization", "Bearer " +token);

        User us = new User(name, gender, email, status);

        Response response = RestClient.doPOST("JSON", baseURI, basePath, tokenMap, null, true, us);
        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());
        System.out.println("====================");
    }
}
