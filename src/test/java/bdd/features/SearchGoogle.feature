Feature: As a first day child
  I want to find something in google

  Scenario: Google behave searching test
    Given New google searching page is opened
    When I type "selenium" to seach
    Then I saw in result page searching string "selenium"