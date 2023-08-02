package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.Base_class;

public class PomLogin extends Base_class {
//Object repository
	@FindBy(name="username")WebElement Username;
	@FindBy(name="password")WebElement Password;
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement Loginbtn;
	
	
	//initiate page elements
	public PomLogin() {
	PageFactory.initElements(driver, this);
	}
	public void typeUsername(String user) {
		Username.sendKeys(user);
	}
	public void typePassword(String pass) {
		Password.sendKeys(pass);
	}
	public void clickButton() {
		Loginbtn.click( );}
	
		public String verifyTitle() {
			return driver.getTitle();
			}
}
