package com.vtiger.stepdefinitions;


import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class login extends basesteps {


	@Before
	public void getScenarioName(Scenario scenario)
	{
		if (extent==null)
		{
			createExtentReports();
		}
		ScenarioName = scenario.getName();
		logger = extent.createTest(ScenarioName);
	}

	@After
	public void tierdown()
	{
		extent.flush();
		driver.quit();
	}


	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws Exception {
		launchApp();
		logger.info("Application launched");
		lp = new LoginPage(driver , logger);
		hp = new HomePage(driver , logger);
		ldp = new LeadPage(driver , logger);

	}
	@When("user enter valid credentials")
	public void user_enter_valid_credentials() {

		lp.login(dt.get(ScenarioName).get("Userid"), dt.get(ScenarioName).get("Password"));

	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {

		hp.Validate_Home();

	}
	@Then("user can validate logout link")
	public void user_can_validate_logout_link() {
		hp.Validate_logout();
	}



	@When("user enters invalid credentials")
	public void user_enters_invalid_credentials() {

		lp.login(dt.get(ScenarioName).get("Userid"), dt.get(ScenarioName).get("Password"));

	}
	@Then("user can validate error message")
	public void user_can_validate_error_message() {

		lp.Validate_Error_Message();
	}


	@When("user enter the invalid userid as {string} and password as {string}")
	public void user_enter_the_invalid_userid_as_and_password_as(String uid, String pwd) {
		lp.login(uid, pwd);

	}



	@Then("user validate dropdown exist")
	public void user_validate_dropdown_exist() {

		lp.Validate_dropdown_exist();

	}
	@Then("default selection should be {string}")
	public void default_selection_should_be(String Default_values) {


	}
	@Then("there should four values in dropdown as {string}")
	public void there_should_four_values_in_dropdown_as(String Options) {

	}



}






