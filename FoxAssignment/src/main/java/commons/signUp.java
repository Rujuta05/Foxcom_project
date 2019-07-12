package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class signUp extends base {
	
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[2]")
	WebElement arrowbutton;

	@CacheLookup
	@FindBy(xpath = "//a[@class='Tile_title_2XOxg CarouselTile_title_2x_Og']//div[@class='Tile_titleWrapper_1Ub6U']/span")
	List<WebElement> mylist;
	
	public signUp(WebDriver driver) {
		super(driver);
		
	}

	public void signup()
	{
		driver.findElement(By.xpath("//button[@class='Header_profileButton_2HN_-']")).click();
		
			arrowbutton.click();
			
			
		WebElement signup=driver.findElement(By.xpath("//button[@class='Perks_signUp_108jD']"));
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		
		jsexecutor.executeScript("arguments[0].scrollIntoView();", signup);
		
		signup.click();
		
		WebElement firstname=driver.findElement(By.xpath("//input[@name='signupFirstName']"));
		
		jsexecutor.executeScript("arguments[0].scrollIntoView();", firstname);
		
		firstname.sendKeys("Rakeshi");
		
		driver.findElement(By.xpath("//input[@name='signupLastName']")).sendKeys("jacobs");
		
		driver.findElement(By.xpath("//input[@name='signupEmail']")).sendKeys("riyadeshpande05@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='signupPassword']")).sendKeys("KL89ERsd");
		
		driver.findElement(By.xpath("//a[contains(text(),'Gender')]")).click();
		
		Actions mouseaction=new Actions(driver);
		
		mouseaction.click(driver.findElement(By.xpath("//div[contains(text(),'Female')]"))).build().perform();;
				
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("06/03/1990");
		
		driver.findElement(By.xpath("//button[@class='Signup_defaultButton_fkovg']")).click();
		
		System.out.println("Profile Created ");
			
		
	}
}
