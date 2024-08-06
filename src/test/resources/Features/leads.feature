Feature: Login Functionality

Background:
Given user should be on login page
When user enter valid credentials


@lead
Scenario: TC_04_create_multiple_leads
When user fills the mandatory fields as "<lname>" and "<comp>"
|lname    |comp |
|admin1   |pwd1  |
|admin2   |pwd2  |
|admin3   |pwd3  |
Then lead should be created successfully
And click on logout