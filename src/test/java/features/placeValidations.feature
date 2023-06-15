Feature: Validate Place API's
  @AddPlace
  Scenario: verify if place is being successfully added using AddPlace API
    Given Add Place Payload
    When user calls "AddPlaceAPI" with "Post" http request
    Then  the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify place_id created using "getPlaceAPI"


  @DeletePlace
  Scenario: verify if DeletePlace functionality is working
    Given deletePlaceAPI Payload
    When user calls "deletePlaceAPI" with "Post" http request
    Then  the API call got success with status code 200
    And "status" in response body is "OK"

