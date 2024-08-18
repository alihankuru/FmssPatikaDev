Feature: Login to OrangeHRM
  As a user
  I want to log in to the OrangeHRM demo site
  So that I can access the dashboard

  @login, @smoke
  Scenario: Successful login with valid credentials
    Given I am on the OrangeHRM login page
    When I enter "Admin" as the username
    And I enter "admin123" as the password
    And I click on the login button
    Then I should be redirected to the OrangeHRM dashboard


  @login, @smoke
  Scenario: Unsuccessful login with invalid credentials
    Given I am on the OrangeHRM login page
    When I enter "WrongUser" as the username
    And I enter "wrongpass" as the password
    And I click on the login button
    Then I should see an error message saying "Invalid credentials"



#false login
#true login
