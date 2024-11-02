  package testCases;

import static org.testng.Assert.assertEquals;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageobjectives.AccountRegistrationPage;
import pageobjectives.HomePage;
public class TC001_AccountRigistration extends BaseClass{
	@Test(groups = { "sanity","regression","master"})
	public void verify_account_registration() throws Throwable
	{
		//homepage class
		HomePage hm=new HomePage(driver);
		hm.ClickMyAccount();
		hm.ClickRegister();
		//Accountregistrationpage class
		AccountRegistrationPage ac=new AccountRegistrationPage(driver);
		/*//hard coded test data
		ac.setfirstname("Gowthami");
		ac.setlastname("guduru");
		ac.setemail("guduru.k@gmail.com");
		ac.settelephone("9963967196");
		ac.setpassword("gowthamiguduru@123");
		*/
		//randomly sending testdata at runtime by automation
		ac.setfirstname(randomStrng().toUpperCase());
		ac.setlastname(randomStrng().toUpperCase());
		ac.setemail(randomStrng()+"@gmail.com");
		ac.settelephone(randomNumaric());
		String password=randomAlphaNumaric();
				ac.setpassword(password);

		ac.setconfirmpassword(password);
		Thread.sleep(5000);
		ac.setprivacypolicy();
		ac.clickcontinue();
		String confirmmsg=ac.getConfirmationmsg();
		Assert.assertEquals(confirmmsg, "Your Account Has Been Created!");
	}
	
}
