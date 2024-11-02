package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageobjectives.HomePage;
import pageobjectives.LoginPage;
import pageobjectives.Myaccountpage;

public class TC002_LoginTest extends BaseClass {
@Test(groups = { "regression","master"})
public void verify_Login() throws Throwable
{
	//Homepage
	HomePage hp=new HomePage(driver);
hp.ClickMyAccount();
hp.ClickLogin();
//loginpage
LoginPage lp=new LoginPage(driver);
lp.setemail(config.getProperty("email"));
lp.setpassword(config.getProperty("password"));
lp.clicklogin();
//myaccountpage
Myaccountpage ma=new Myaccountpage(driver);
Boolean targetpage=ma.ismyaccountExist();
//Assert.assertEquals(targetpage, true,"Login failed");
Assert.assertTrue(targetpage);
}
}
