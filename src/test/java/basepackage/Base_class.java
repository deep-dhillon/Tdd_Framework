 package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUnits;

public class Base_class {
	public static Properties obj1=	new Properties();
	public static WebDriver driver;
	//step 1 create a constructor to get read data from Properties file
	public Base_class() {
		try {
		FileInputStream file= new FileInputStream("C:\\Users\\simra\\OneDrive\\Desktop\\tdd\\src\\test\\java\\environment_Variables\\Config.properties");
	obj1.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
}
//step 2 create a method so that test and pom class to open the browser and url
	public static void initiation(){
		String browser_name= obj1.getProperty("browser");
		if(browser_name.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		}
		else if(browser_name.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=new ChromeDriver();
			}
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(obj1.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Thread.sleep(TimeUnits.timeutil);
	}
	public static void screenshots(String Filename) {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	  try {
		FileUtils.copyFile(file, new File("C:\\Users\\simra\\OneDrive\\Desktop\\tdd\\src\\test\\java\\screenshots\\Screenshots"+Filename+".jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	}
	
	
	
	
}