package com.cybertek.step_definitions;

import com.cybertek.pages.EtsyPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_StepDefinitions {

    EtsyPage etsyPage = new EtsyPage();

    @Given("user is on the Etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String etsyUrl = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(etsyUrl);
    }
    @Then("user should see Etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {
        String expected = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue("Title is not expected", actual.equals(expected) );

    }

    @When("user types Wooden Spoon in the search box")
    public void userTypesWoodenSpoonInTheSearchBox() {
        etsyPage.searchBox.sendKeys("wooden spoon");
    }

    @And("user clicks search button")
    public void userClicksSearchButton() {
        etsyPage.searchButton.click();
    }

    @Then("user sees title is Wooden Spoon | Etsy")
    public void userSeesTitleIsWoodenSpoonEtsy() {
        String expected = "wooden spoon | Etsy";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(expected,actual);
    }
}
