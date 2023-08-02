package testLayer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.Base_class;
import pompackage.PomLogin;
import testData.ExcelSheet;

public class LoginTest extends Base_class {
	PomLogin log;
	
	
	public LoginTest() {
		super();
	}
@BeforeMethod
public void initsetup() {
	initiation();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	screenshots("Login");
	log=new PomLogin();
}
@Test(priority=1)
public void title() {
	String actual=log.verifyTitle();
	System.out.println(actual);
	Assert.assertEquals(actual,"OrangeHRM");
}
@DataProvider
public Object[][] Details(){
	Object result[][]=ExcelSheet.readdata("Sheet1");
	
	return result;
	
}
 @Test(priority=2, dataProvider="Details")
 public void Login(String name, String password) throws InterruptedException { 
		log.typeUsername(name);
		Thread.sleep(5000);
		log.typePassword(password);
		Thread.sleep(5000);
	
	 
	 /*
		 * log.typeUsername(obj1.getProperty("username"));
		 * log.typePassword(obj1.getProperty("Password"));
		 */
	 //log.clickButton();
	 }
 

@AfterMethod
public void close() {
	driver.close();
}
}
