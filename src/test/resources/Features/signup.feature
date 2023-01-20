Feature: Signup Feature


  Scenario: User is redirected to signup page on clicking 'Don't have an access'
    Given user is on login page
    When user clicks on don't have access
    Then user is on signup page
