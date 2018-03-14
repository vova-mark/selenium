Feature: As a first day child
  I want to find something in google

  Scenario: Google behave searching test
    Given New google searching page is opened
    When I type "selenium" to search
    Then I saw in result page searching string "selenium"

  Scenario Outline: Google behave searching test with tdd
    Given New google searching page is opened
    When I type "<searchingString>" to search
    Then I saw in result page searching string "<resultString>"
  Examples:
    | searchingString | resultString |
    | selenium | selenium |
    | selenide | selenide |
    | Selenium | Selenium |
    | someText | someText |
