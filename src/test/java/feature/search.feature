Feature: Search
  As a User
  I should able to search item and retrieve appropriate details

  @search
  Scenario: search for valid search item
    Given I'm on home page
    When I enter search term as "Jeans"
    And Click on Search icon
    Then I should be redirected to item listing page with appropriate result with term "Jeans"
    Then I should sort Product List from "Price: Low - High"