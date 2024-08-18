#7 tane search senaryosu yazılacak.

Feature: Search Functionality on OrangeHRM Dashboard
  As a user
  I want to use the search feature
  So that I can quickly find and navigate to different modules

  @search, @smoke
  Scenario: Search for "Admin" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Admin" in the search bar
    And I should be able to click on it to navigate to the "Admin" module

  @search, @smoke
  Scenario: Search for "PIM" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "PIM" in the search bar
    And I should be able to click on it to navigate to the "PIM" module

  @search, @smoke
  Scenario: Search for "Leave" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Leave" in the search bar
    And I should be able to click on it to navigate to the "Leave" module

  @search, @smoke
  Scenario: Search for "Time" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Time" in the search bar
    And I should be able to click on it to navigate to the "Time" module

  @search, @smoke
  Scenario: Search for "Recruitment" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Recruitment" in the search bar
    And I should be able to click on it to navigate to the "Recruitment" module

  @search, @smoke
  Scenario: Search for "Performance" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Performance" in the search bar
    And I should be able to click on it to navigate to the "Performance" module

  @search, @smoke
  Scenario: Search for "Buzz" module
    Given I am on the OrangeHRM dashboard
    When I click on the search button
    And I enter "Buzz" in the search bar
    And I should be able to click on it to navigate to the "Buzz" module

