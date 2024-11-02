package pageobjectives;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Myaccountpage extends BasePage{
public Myaccountpage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	super(driver);
}
@FindBy(xpath="//h2[text()='My Account']")
WebElement myaccount;
@FindBy(xpath="(//a[text()='Logout'])[2]")
WebElement Logoutclick;


public boolean ismyaccountExist() 
{

	try
	{
	return (myaccount.isDisplayed());
	}catch(Exception e)
	{
		return false;
	}
}
public void  Logut()
{
	Logoutclick.click();
}
}
