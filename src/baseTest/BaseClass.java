package baseTest;

import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.mongodb.MapReduceCommand.OutputType;

public class BaseClass  {
	//driver is static for takesscreenshot convertion
	public static WebDriver driver;
	public Logger log;
	public Properties config;
	@BeforeClass(groups = { "sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Throwable, IOException
	{
		config=new Properties();
		//load file 
		config.load(new FileInputStream("config.properties"));

		
		switch (br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		case "edge":driver=new EdgeDriver();break;
		default: System.out.println("Invalid browser name...");return;
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver .get(config.getProperty("appurl"));
		driver.get("https://tutorialsninja.com/demo/");
	}
	@AfterClass(groups = { "sanity","regression","master"})
	public void teatdown() throws Throwable
		{
		Thread.sleep(5000);
		driver.quit();	
		}
	//Randomly sending test data
		public String randomStrng()
		{
			String genaratedstring=RandomStringUtils.randomAlphabetic(5);
			return genaratedstring;
		}
		public String randomNumaric()
		{
			
			String genaratednumber=RandomStringUtils.randomNumeric(10);
			return genaratednumber;
		}
		public String randomAlphaNumaric()
		{
			String genaratedstring=RandomStringUtils.randomAlphabetic(5);
			String genaratednumber=RandomStringUtils.randomNumeric(3);
			return genaratedstring+"@"+genaratednumber;
		}
//capture screen
		public String captureScreen(String tname)throws Throwable

		{
			String timestamp=new SimpleDateFormat("yyyyMMhhmmss").format(new Date());
			TakesScreenshot takescreenshot=(TakesScreenshot) driver;
            File sourcefile=takescreenshot.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            
            String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\"+tname+"_"+timestamp+".png";
            File targetfile=new File(targetFilePath);
            sourcefile.renameTo(targetfile);
			return targetFilePath;
		
		}
		
}
