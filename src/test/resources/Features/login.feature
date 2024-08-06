Feature: Login Functionality


Background:
  Given user should be on login page


@login
Scenario: TC_01_valid_Login
  When user enter valid credentials
  Then user should be navigated to home page
  And user can validate logout link


@login1
Scenario: TC_02_Invalid_Login
  When user enters invalid credentials
  Then user can validate error message




@login3
Scenario Outline: TC_03_Invalid_Login_with_dataset
  When user enter the invalid userid as "<userid>" and password as "<password>"
  Then user can validate error message
  Examples:
    |userid|password |
    |admin1|pwd1 |
    |admin2|pwd2 |
    |admin3|pwd3 |



@dropdown
Scenario Outline: TC_05_validate_login_theme_dropdown
  Then user validate dropdown exist
  And default selection should be "<Default_values>"
  And there should four values in dropdown as "<Options>"
  Examples:
    | Default_values | Options                 |
    | blue           | Aqua,blue,nature,orange |






