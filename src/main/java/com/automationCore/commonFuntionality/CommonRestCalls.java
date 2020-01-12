package com.automationCore.commonFuntionality;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonRestCalls {

    //This method is used to call simple GET rest call
    public Response callGET(String baseUrl , String path , String okapi) {
        RestAssured.baseURI = baseUrl;
        System.out.println("Base url inside common GET :: " +baseUrl);
        RequestSpecification requestSpecification = RestAssured.given();
        if(path.contains("//?")) {
            String[] param = path.split("//?");
            String[] paramPair = param[1].split("//&");
            for(String p : paramPair) {
                String[] keyVal = p.split("=");
                requestSpecification.queryParam(keyVal[0],keyVal[1]);
            }
        }
        if(okapi.equalsIgnoreCase("true")) {
            requestSpecification.header("Authorisation", "token");
        }
        requestSpecification.contentType(ContentType.JSON);
        System.out.println("Path url inside common GET :: " + path);
        return requestSpecification.relaxedHTTPSValidation().get(path);
    }
    public Response callPost(String baseUrl , String path , String okapi, JsonNode requestBody) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        if(path.contains("//?")) {
            String[] param = path.split("//?");
            String[] paramPair = param[1].split("//&");
            for(String p : paramPair) {
                String[] keyVal = p.split("=");
                requestSpecification.queryParam(keyVal[0],keyVal[1]);
            }
        }
        if(okapi.equalsIgnoreCase("true")) {
            requestSpecification.header("Authorisation", "token");
        }
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.relaxedHTTPSValidation().post(path);
    }

    public Response callPut(String baseUrl , String path , String okapi, JSONPObject requestBody) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        if(path.contains("//?")) {
            String[] param = path.split("//?");
            String[] paramPair = param[1].split("//&");
            for(String p : paramPair) {
                String[] keyVal = p.split("=");
                requestSpecification.queryParam(keyVal[0],keyVal[1]);
            }
        }
        if(okapi.equalsIgnoreCase("true")) {
            requestSpecification.header("Authorisation", "token");
        }
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.relaxedHTTPSValidation().put(path);
    }

    public Response callDelete(String baseUrl , String path , String okapi, JSONPObject requestBody) {
        RestAssured.baseURI = baseUrl;
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(requestBody);
        if(path.contains("//?")) {
            String[] param = path.split("//?");
            String[] paramPair = param[1].split("//&");
            for(String p : paramPair) {
                String[] keyVal = p.split("=");
                requestSpecification.queryParam(keyVal[0],keyVal[1]);
            }
        }
        if(okapi.equalsIgnoreCase("true")) {
            requestSpecification.header("Authorisation", "token");
        }
        requestSpecification.contentType(ContentType.JSON);
        return requestSpecification.relaxedHTTPSValidation().delete(path);
    }

}
