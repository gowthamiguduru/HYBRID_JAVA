package pageobjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Factory;

import baseTest.BaseClass;

public class LoginPage extends BasePage
{
public LoginPage(WebDriver driver) {
	super(driver);
}
@FindBy(xpath="//input[@id='input-email']")
WebElement Emailaddress;
@FindBy(  xpath="//input[@id='input-password']")
WebElement password;
@FindBy(xpath="//input[@value='Login']")
WebElement loginbutton;


public void setemail(String username) throws Throwable
{
	Thread.sleep(5000);
Emailaddress.sendKeys(username);	
}
public void setpassword(String pass) throws Throwable
{
	Thread.sleep(5000);
password.sendKeys(pass);	
}
public void clicklogin() throws Throwable
{
Thread.sleep(5000);
	loginbutton.click();
}
}
