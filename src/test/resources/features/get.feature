Feature:Information get individual user
  Scenario: Send information get individual user with response success
    Given Load customer information
      |id|
      | 1|
    When I call Get user API
    Then I Should see the status code 200
    And I validate quantity key is 2
    And I validate schema response "GetJsonSchema"
    And Ivalidate fields get response api
    And I validate get response contains data expected
