package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPage extends PageBase{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	int links = 0;
	By Results = By.xpath("//div[@class='yuRUbf']");
	
	List<WebElement> SearchResults= driver.findElements(Results);
	

	
	public void GetTheGumtreeNumbers()
	{    
		for (WebElement i:SearchResults)
		{
		if(i.getText().contains("gumtree"))
			links+=1;
	    }
		if(links==0)
			System.out.println("There is no gumtree links");
		else 
			System.out.println("Number of gumtree links = "+ links);
	}
	
	public void EnterLinks()
	{ 
		Actions action = new Actions(driver);
		
		for (WebElement i:SearchResults) 
		{
			if(i.getText().contains("gumtree"))
			{
			 action.click(i).build().perform();  
			 break;
			}
		}

		}
	public void ReturnBack()
	{
		driver.navigate().back();
	}
	}

