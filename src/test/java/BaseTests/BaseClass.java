package BaseTests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//Log4J
import org.apache.logging.log4j.Logger;//Log4J
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass(groups = {"Sanity","Master","Regression","DataDriven"})//
	@Parameters({"os","browser"})
	public void SetUp(String os, String br) throws IOException
	{
		
		logger = LogManager.getLogger(this.getClass()); //log4j2
		
		
		
		
		//WebDriver driver = new RemoteWebDriver(new URL("http://<hub>:4444/wd/hub"), options);

		
		 // Load config.properties
	    FileReader file = new FileReader("./src/test/resources/config.properties");
	    p = new Properties();
	    p.load(file);
	    
	    
	    if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {

	        String hubURL = "http://localhost:4444/wd/hub";

	        if (br.equalsIgnoreCase("chrome")) {
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--headless=new");
	            options.addArguments("--disable-gpu");
	           // options.addArguments("--window-size=1920,1080");
	            options.addArguments("--no-sandbox");
	            options.addArguments("--disable-dev-shm-usage");

	            //options.setPlatformName(os.equalsIgnoreCase("windows")?"WINDOWS":os.toLowerCase());
	            options.setPlatformName(os.equalsIgnoreCase("linux") ? "LINUX" : os.toLowerCase());
	            driver = new RemoteWebDriver(new URL(hubURL), options);

	        } else if (br.equalsIgnoreCase("firefox")) {
	            FirefoxOptions options = new FirefoxOptions();
	            options.addArguments("--headless");
	            options.addArguments("--width=1920");
	            options.addArguments("--height=1080");

	            //options.setPlatformName(os.equalsIgnoreCase("windows")?"WINDOWS":os.toLowerCase());
	            options.setPlatformName(os.equalsIgnoreCase("linux") ? "LINUX" : os.toLowerCase());
	            driver = new RemoteWebDriver(new URL(hubURL), options);

	        } else if (br.equalsIgnoreCase("edge")) {
	            EdgeOptions options = new EdgeOptions();
	            System.setProperty("webdriver.edge.driver", "C:\\Users\\Edify\\Downloads\\edgedriver_win64\\msedgedriver.exe");
	            options.addArguments("--headless=new");
	            options.addArguments("--disable-gpu");
	            options.addArguments("--window-size=1920,1080");
	            options.addArguments("--no-sandbox");
	            options.addArguments("--disable-dev-shm-usage");

	            //options.setPlatformName(os.equalsIgnoreCase("windows")?"WIN11":os.toLowerCase());
	            options.setPlatformName(os.equalsIgnoreCase("linux") ? "LINUX" : os.toLowerCase());
	            driver = new RemoteWebDriver(new URL(hubURL), options);

	        } else {
	            System.out.println("No matching browser found.");
	            return;
	        }

	    }

	    
	    /*
	    if(p.getProperty("execution_env"). equalsIgnoreCase("remote"))
		{
		DesiredCapabilities capabilities=new DesiredCapabilities();
		//os
		if(os.equalsIgnoreCase("windows"))
		{
		capabilities.setPlatform (Platform. WIN11);
		}
		else if (os.equalsIgnoreCase("linux"))
		{
		capabilities.setPlatform (Platform.LINUX);
		}
		else if(os.equalsIgnoreCase("mac"))
		{
			capabilities.setPlatform(Platform.MAC);
		}
		else
		{
			System.out.println("No matching OS");
			return;
		}
		//browser
		switch(br.toLowerCase()) 
		{
		case "chrome": capabilities.setBrowserName("chrome"); break;
		case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
		case "firefox": capabilities.setBrowserName("firefox");break;
		default: System.out.println("No matching browser"); return;
		} 
		
		driver=new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), capabilities);
		
		}	
	   */
		
		
		
		
		if(p.getProperty("execution_env"). equalsIgnoreCase("local"))
		{
		switch(br.toLowerCase())
		{
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : 
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\Edify\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		 driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		
		default: System.out.println("Invalid browser name.."); return;
		}
		
		}
		/*
		switch (br.toLowerCase()) {
		    case "chrome":
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        break;
		    case "edge":
		        WebDriverManager.edgedriver().setup();
		        System.setProperty("webdriver.edge.driver", "C:\\Users\\Edify\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		        driver = new EdgeDriver();
		        break;
		    case "firefox":
		        WebDriverManager.firefoxdriver().setup();
		        driver = new FirefoxDriver();
		        break;
		    default:
		        System.out.println("Invalid browser name..");
		        return;
		}
*/
		
		    driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			driver.get(p.getProperty("appURL"));//reading url from properties files
			driver.manage().window().maximize();
	}	
	
	@AfterClass(groups = {"Sanity","Master","Regression","DataDriven"})//"DataDriven"
	public void tearDown() 
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randomNumber()
	{
		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}
	public String randomAlphaNumeric()
	{
		String generatedstring = RandomStringUtils.randomAlphabetic(4);
		String generatednumber = RandomStringUtils.randomNumeric(4);
		
		return (generatedstring+"@"+generatednumber);
	}
	
	public String captureScreen (String tname) throws IOException {
		
	
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"  + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	 
	}
}

