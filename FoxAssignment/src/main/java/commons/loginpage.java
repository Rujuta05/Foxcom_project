package commons;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ExcelDriver;

public class loginpage extends base {

	@CacheLookup
	@FindBy(xpath = "//button[contains(text(),'Profile Sign In')]")
	WebElement profileSignIn;

	@CacheLookup
	@FindBy(xpath = "//button[@class='Perks_signIn_2TQW6']")
	WebElement signIn;

	@CacheLookup
	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@CacheLookup
	@FindBy(xpath = "//input[@type='password']")
	WebElement passWord;

	@CacheLookup
	@FindBy(xpath = "//button[@class='Signin_desktopButton_2E1nw']")
	WebElement signInButton;

	@CacheLookup
	@FindBy(xpath = "//div[@class='Carousel_headline_1R8EC']")
	WebElement foxnow;

	@CacheLookup
	@FindBy(xpath = "(//button[@class='slick-arrow slick-next'])[2]")
	WebElement arrowbutton;

	@CacheLookup
	@FindBy(xpath = "//a[@class='Tile_title_2XOxg CarouselTile_title_2x_Og']//div[@class='Tile_titleWrapper_1Ub6U']/span")
	List<WebElement> mylist;

	WebDriver driver;

	public loginpage(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);

	}

	public void getLogin(String username, String password) throws Exception {

		profileSignIn.click();
		jsexecutor.executeScript("arguments[0].scrollIntoView();", signIn);
		signIn.click();
		email.sendKeys(username);
		passWord.sendKeys(password);
		signInButton.click();

	}

	public void getData() throws Exception {

		jsexecutor.executeScript("arguments[0].scrollIntoView(true);", foxnow);

		arrowbutton.click();

		String text1;

		int count = 18;

		List<String> movieTitle = new ArrayList<String>();

		for (WebElement myelement : mylist) {
			if (count >= 18 && count <= 21) {
				myelement = mylist.get(count);
				System.out.println("Text is: " + myelement.getText());
				text1 = myelement.getText();
				movieTitle.add(text1);
				count++;
			}
		}
		writeToExcel(movieTitle);
	}

	private void writeToExcel(List<String> Movietitle) throws Exception {

		String filename = System.getProperty("user.dir") + "/testData/test.xlsx";

		String sheetname = "TestData";
		
		int row = 1;

		ExcelDriver exceldriver = new ExcelDriver();

		exceldriver.createWorkbook(filename);

		exceldriver.openWorkbook(filename);

		exceldriver.createSheet(sheetname);

		for (String s : Movietitle) {
			
			exceldriver.setCellData(sheetname, row, 1, s);
			row++;
		}

		System.out.println("Movie titles saved in worksheet.");

		exceldriver.saveFile();

	}
}
