package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage extends PageBase {
       
	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	By TextBox = By.name("q");
	
	public void WriteTheText(String SearchText) 
	{
		driver.findElement(TextBox).sendKeys(SearchText);
		driver.findElement(TextBox).sendKeys(Keys.ENTER);
	}
}
