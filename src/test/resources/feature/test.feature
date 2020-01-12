Feature: This is to test the BDD framework

  @Test
  Scenario: This test is just for testing the integration
    Given As a user wants to us the topic API
    When user click on get topic url
    Then the list of topics should be displayed

  Scenario Outline: This test is to add new topic
    Given As a user i want to add new topic with <"id"> , <"name"> and <"description"> in the topic database
    When user click on the add topic url with new topic details
    Then the new topic gets added to the topic database
    Examples:
      | "id" | "name" | "description" |
      |"id-4"  |"Spring-4"|"this is spring V4"|
      |"id-5"  |"Spring-5"|"this is spring V5"|
