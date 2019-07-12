package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelDriver;

public class GetFox extends base {
	
	WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//div[contains(text(),'Fox All Stars')]")
	WebElement foxnow;
	
	@CacheLookup
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[2]")
	WebElement arrowbutton;
	
	@CacheLookup
    @FindBy (xpath="//a[@class='Tile_title_2XOxg CarouselTile_title_2x_Og']//div[@class='Tile_titleWrapper_1Ub6U']/span")
    List<WebElement> mylist;
	
	@CacheLookup
	@FindBy(xpath="//input[@type='password']")
	WebElement passWord;

	@CacheLookup
	@FindBy(xpath = "//button[@class='Signin_desktopButton_2E1nw']")
	WebElement signInButton;
	

	
	public GetFox(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		

	}
	
	
	public void getData() throws Exception
	{
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//WebElement live=driver.findElement(By.xpath("//div[contains(text(),'Live Now')]"));
		
		//WebElement foxnow=driver.findElement(By.xpath("//div[contains(text(),'Fox All Stars')]"));
		
		 jsexecutor=(JavascriptExecutor)driver;
		
		jsexecutor.executeScript("arguments[0].scrollIntoView(true);",foxnow);
		
		//String text=driver.findElement(By.xpath("//div[@class='Tile_titleWrapper_1Ub6U']/span/span")).getText();
		
		//System.out.println(text);
		
		//arrowbutton
		//driver.findElement(By.xpath("(//button[@class='slick-arrow slick-next'])[2]")).click();
		
		arrowbutton.click();
		
		//driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
		//driver.findElement(By.xpath("//button[@class='slick-arrow slick-next']")).click();
		
		String text1;
		
		//List<WebElement> mylist=driver.findElements(By.xpath("//div[@class='Tile_imageOverlayInnerContainer_2f-mI']"));
		//List<WebElement> mylist=driver.findElements(By.xpath("//a[@class='Tile_title_2XOxg CarouselTile_title_2x_Og']//div[@class='Tile_titleWrapper_1Ub6U']/span"));
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
		//writeToExcel(movieTitle);
		
		
	
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
}
