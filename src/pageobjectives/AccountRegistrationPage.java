package pageobjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	//constructor
	public AccountRegistrationPage(WebDriver driver)


	{
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement Firstname;
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement Lastname;
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement Telephone;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Password;
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement Passconfirm;

	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbPolicy;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement msgConfirm;
	public void setfirstname(String fname)

	{
	Firstname.sendKeys(fname);	
	}
	public void setlastname(String lname)

	{
	Lastname.sendKeys(lname);	
	}
	public void setemail(String email)

	{
	Email.sendKeys(email);	
	}
	public void settelephone(String tel)

	{
	Telephone.sendKeys(tel);	
	}
	public void setpassword(String pswd)

	{
	Password.sendKeys(pswd);	
	}
	public void setconfirmpassword(String pswd)

	{
	Passconfirm.sendKeys(pswd);	
	}

	
	public void setprivacypolicy()

	{
	chkbPolicy.click();	
	}
	public void clickcontinue()

	{
	btnContinue.click();	
	}
	public String getConfirmationmsg()

	{
		try {
		
		return (msgConfirm.getText());
		}
		
		catch (Exception e) {
			return(e.getMessage());
		}
		
		
	}
}




