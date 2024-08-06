package com.vtiger.stepdefinitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.List;

public class leads extends basesteps {


    @When("user fills the mandatory fields as {string} and {string}")
    public void user_fills_the_mandatory_fields_as_and(String string, String string2, io.cucumber.datatable.DataTable dataTable) {

        List<List<String>> ls = dataTable.asLists();
        for (List<String> s:ls)
        {
            ldp.ClickNewLead();
            ldp.CreateLead(s.get(0), s.get(1));

        }

    }
    @Then("lead should be created successfully")
    public void lead_should_be_created_successfully() {

    }
    @Then("click on logout")
    public void click_on_logout() {
        hp.click_logout();

    }


}
