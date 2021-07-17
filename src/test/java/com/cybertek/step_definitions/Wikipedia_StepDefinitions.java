package com.cybertek.step_definitions;

import com.cybertek.pages.Wikipedia_Page;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Wikipedia_StepDefinitions {

    Wikipedia_Page wikipedia_page = new Wikipedia_Page();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String wikiUrl = ConfigurationReader.getProperty("wikiUrl");
        Driver.getDriver().get(wikiUrl);
    }
    @When("User types Steve Jobs in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box() {
        wikipedia_page.searchBox.sendKeys("Steve Jobs");

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipedia_page.searchButton.click();

    }
    @Then("User sees Steve Jobs is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title() {
        String expected = "Steve Jobs";
        String actual = Driver.getDriver().getTitle();
        Assert.assertTrue(actual.contains(expected));

    }

    @When("User types {string} in the wiki search box")
    public void userTypesInTheWikiSearchBox(String arg0) {
        wikipedia_page.searchBox.sendKeys(arg0);

    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String arg0) {

        String expected = arg0+ " - Wikipedia";
        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.contains(expected));
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String arg0) {
        String expected = arg0;
        String actual = wikipedia_page.mainHeader.getText();
        Assert.assertEquals(actual,expected);
    }
}
