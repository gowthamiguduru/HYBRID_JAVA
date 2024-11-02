package pageobjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage{
//constructor
public HomePage(WebDriver driver)
{
	super(driver);
	
}

@FindBy(xpath="//span[text()='My Account']")
WebElement myaccountlink;
@FindBy(  xpath="//li[@class='dropdown open']/descendant::a[text()='Register']")
WebElement registrationlink;
@FindBy(xpath="//li[@class='dropdown open']/descendant::a[text()='Login']")
WebElement Loginlink;
public void ClickMyAccount()
{
	myaccountlink.click();
}
public void ClickRegister()
{
	registrationlink.click();
}
public void ClickLogin()
{
	Loginlink.click();
}
}
