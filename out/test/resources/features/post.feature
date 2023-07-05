Feature: Information post user

  Scenario Outline: Send information post user with response success
    Given Load customer information
      | name   | job   |
      | <name> | <job> |
    When I call post user API
    Then I Shouldd see the status code 201
    And I validatee quantity key is 4
    And I validatee schema response "PostJsonSchema"
    And Ivalidate fields post response api
    And I validate post response contains data initial

    Examples:
      | name     | job    |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Hoja1@1
