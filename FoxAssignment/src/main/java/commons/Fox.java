package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import utils.ExcelDriver;

public class Fox {


	WebDriver driver;
	
	public void invokeBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\rujut\\\\eclipse-workspace\\\\libs\\\\chromedriver_win32_chrome74\\\\chromedriver.exe");
		driver =new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://www.fox.com/");
		
	
	}
	public void signup()
	{
		driver.findElement(By.xpath("//button[@class='Header_profileButton_2HN_-']")).click();
		
		
		
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
	
	public void signIn()
	{
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(text(),'Profile Sign In')]")).click();
			
		WebElement signin=driver.findElement(By.xpath("//button[@class='Perks_signIn_2TQW6']"));
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		
		jsexecutor.executeScript("arguments[0].scrollIntoView();", signin);
		signin.click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("riyadeshpande05@gmail.com");
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("KL89ERsd");
		
		driver.findElement(By.xpath("//button[@class='Signin_desktopButton_2E1nw']")).click();
		
		
	}
	
	public void getData() throws Exception
	{
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//WebElement live=driver.findElement(By.xpath("//div[contains(text(),'Live Now')]"));
		
		WebElement foxnow=driver.findElement(By.xpath("//div[contains(text(),'Fox All Stars')]"));
		
		JavascriptExecutor jsexecutor=(JavascriptExecutor)driver;
		
		jsexecutor.executeScript("arguments[0].scrollIntoView(true);", foxnow);
		
		String text=driver.findElement(By.xpath("//div[@class='Tile_titleWrapper_1Ub6U']/span/span")).getText();
		
		System.out.println(text);
		
		//arrowbutton
		driver.findElement(By.xpath("(//button[@class='slick-arrow slick-next'])[2]")).click();
		//driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
		//driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
		
		String text1;
		
		//List<WebElement> mylist=driver.findElements(By.xpath("//div[@class='Tile_imageOverlayInnerContainer_2f-mI']"));
		List<WebElement> mylist=driver.findElements(By.xpath("//a[@class='Tile_title_2XOxg CarouselTile_title_2x_Og']//div[@class='Tile_titleWrapper_1Ub6U']/span"));
		int count=18;
		
		List<String> movieTitle=new ArrayList<String>();
		
		for(WebElement myelement:mylist)
		{
			if(count>=18&&count<=21)
			{
			myelement=mylist.get(count);
			//System.out.println("tag name: "+myelement.getTagName());
			System.out.println("Text is: "+myelement.getText());
			 text1=myelement.getText();
			movieTitle.add(text1);
			
			 count++;
			}
		
			
			
			 
		}
		writeToExcel(movieTitle);
		
		
	
	}
	
	
	
	private void writeToExcel(List<String> Movietitle) throws Exception {
		
		
		String filename=System.getProperty("user.dir")+"/testData/test.xlsx";
		
		  String sheetname="TestData";
		  int row=1;
		  
		  ExcelDriver exceldriver=new ExcelDriver();
		  
		  exceldriver.createWorkbook(filename);
		  
		  
		  exceldriver.openWorkbook(filename);
		  
		  exceldriver.createSheet(sheetname);
		  
		  for(String s:Movietitle)
		  {
		  exceldriver.setCellData(sheetname, row, 1, s);
		  
		  row++;
		  }
		  
		  System.out.println("data written into worksheet");
		  
		  exceldriver.saveFile();
		 
		
		
	}
	public static void main(String[] args) throws Exception {
		
		Fox mydemo=new Fox();
		mydemo.invokeBrowser();
		//mydemo.signup();
		mydemo.signIn();
		mydemo.getData();
		
	}

}
