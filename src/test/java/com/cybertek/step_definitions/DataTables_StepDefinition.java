package com.cybertek.step_definitions;

import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class DataTables_StepDefinition {

    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();


    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username and password as below")
    public void user_enters_username_and_password_as_below(Map<String, String> credential) {
        libraryLoginPage.emailInput.sendKeys(credential.get("username"));
        libraryLoginPage.passwordInput.sendKeys(credential.get("password"));
        libraryLoginPage.signIn.click();


    }

    @Then("user should see title is something")
    public void user_should_see_title_is_something() {
        String actual = Driver.getDriver().getTitle();
        String expected = "Library";
        Assert.assertTrue(actual.contains(expected));

    }


    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {
        System.out.println("listOfFruits size = " + listOfFruits.size());
        System.out.println("listOfFruits = " + listOfFruits);
    }


}
