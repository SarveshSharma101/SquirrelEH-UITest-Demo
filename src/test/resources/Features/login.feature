Feature: Login Feature


  Scenario Outline: User is able to login into squirrel using valid username and password
    Given user is on login page
    When user enters <email> and <pwd>
    And click on login button
    Then user successfully lands on dashboard and his <email> is visible in the header
    Examples:
      | email           | pwd      |
      | "dummy1@df.com" | "dummy1" |