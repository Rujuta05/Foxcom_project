package commonLibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IScreenShots;

public class ScreenShotsControl implements IScreenShots {

	
	private WebDriver driver;
	
	public ScreenShotsControl(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@Override
	public void saveAndCaptureScreenshot(String filename) throws Exception {
		// TODO Auto-generated method stub
		
		filename =filename.trim();
		File imgfile,tmpfile;
		
		imgfile=new File(filename);
		
		if(imgfile.exists())
		{
			throw new Exception("File already exist");
			
		}
		
		TakesScreenshot camera;
		
		camera=(TakesScreenshot) driver;
		
		tmpfile=camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpfile, imgfile);
				
		
	}

}
