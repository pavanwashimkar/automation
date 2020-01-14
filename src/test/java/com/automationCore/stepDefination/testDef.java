package com.automationCore.stepDefination;

import com.automationCore.InputData.InputRequest;
import com.automationCore.commonFuntionality.CommonRestCalls;
import com.automationCore.commonFuntionality.EnvironmentConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.response.Response;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.io.IOException;


public class testDef {

    private CommonRestCalls commonRestCalls = new CommonRestCalls();
    @Autowired
    private ObjectMapper mapper;
    /* @Autowired
     private Environment environment;*/

    /*String baseUrl = "http://localhost:8080";
    String pathForGetTopic = "/topics";//("topic.getTopicDetails.path");*/
    Response response;
    InputRequest inputRequest;

    //ENV details

    private static JSONObject EnvDetails;
    private static String executionEnvironment = "local";
    private static String configLocation = "/config/EnvironmentDetails.json";

    @Before
    public void getEnVDetails() throws IOException {
        EnvDetails = CommonRestCalls.getEnvDetails(executionEnvironment,configLocation);
    }

    @Given("^As a user wants to us the topic API$")
    public void as_a_user_wants_to_us_the_topic_API() throws IOException, JSONException {
        EnvDetails = CommonRestCalls.getEnvDetails(executionEnvironment,configLocation);
        System.out.println("This is Given :: "  + EnvDetails.getString("hostName"));
    }

    @When("^user click on get topic url$")
    public void user_click_on_get_topic_url() throws JSONException {
        System.out.println("This is When");
        response = commonRestCalls.callGET(EnvDetails.getString("hostName"),
                EnvDetails.getString("getTopicApi"),"No");
    }

    @Then("^the list of topics should be displayed$")
    public void the_list_of_topics_should_be_displayed() {
        System.out.println("Response from GET topic API is :: " +  response.asString());
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        Assert.assertNotNull(response);


    }

    @Given("As a user i want to add new topic with {string} , {string} and {string} in the topic database")
    public void asAUserIWantToAddNewTopicWithAndInTheTopicDatabase(String arg0, String arg1, String arg2) {
        System.out.println("Adding new topic ::" + arg0 + arg1 + arg2);
        inputRequest = new InputRequest(arg0,arg1,arg2);
    }

    @When("user click on the add topic url with new topic details")
    public void userClickOnTheAddTopicUrlWithNewTopicDetails() throws IOException, JSONException {
        mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(inputRequest);
        JsonNode jsonNode = mapper.readTree(json);
        response = commonRestCalls.callPost(EnvDetails.getString("hostName"),
                EnvDetails.getString("getTopicApi"),"No", jsonNode);
    }

    @Then("the new topic gets added to the topic database")
    public void theNewTopicGetsAddedToTheTopicDatabase() throws JSONException {
        Assert.assertEquals(HttpStatus.OK.value(), response.getStatusCode());
        user_click_on_get_topic_url();
        System.out.println("Response is :: " + response.asString());
        Assert.assertEquals(true,response.asString().contains("id-4"));
        Assert.assertEquals(true,response.asString().contains("id-5"));
    }

}
