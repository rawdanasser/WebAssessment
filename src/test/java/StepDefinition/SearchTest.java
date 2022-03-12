package StepDefinition;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.ConfigFileReader;
import Pages.GoogleSearchPage;
import Pages.SearchResultPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchTest extends TestBase{

	ConfigFileReader ConfigFileReader;
	SearchResultPage ResultObject;
	GoogleSearchPage googleObject;

@Given("^user can open google search page$")
public void user_can_open_google_search_page() throws Throwable {
	ConfigFileReader = new ConfigFileReader();
	 driver.navigate().to(ConfigFileReader.getApplicationUrl());
}

@When("^user enters a text in seach box and hits enter$")
public void user_enters_a_text_in_seach_box() throws Throwable {
	googleObject = new GoogleSearchPage(driver);
	googleObject.WriteTheText("Cars in London");
}

@Then("^user is navigated to search results,gets how many search result diplayed$")
public void user_is_navigated_to_search_results_gets_how_many_search_result_diplayed() throws Throwable {
	ResultObject = new SearchResultPage(driver);
	ResultObject.GetTheGumtreeNumbers();
}

@And("^navigate to them to confirm the title$")
public void navigate_to_them_to_confirm_the_title() throws Throwable {
	ResultObject = new SearchResultPage(driver);
	ResultObject.EnterLinks();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Used Cars for Sale in London')]")));
	assertTrue(driver.findElement(By.xpath("//h1[contains(text(),'Used Cars for Sale in London')]")).isDisplayed());
	ResultObject.ReturnBack();
}


}
