package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import pageobjectives.HomePage;
import pageobjectives.LoginPage;
import pageobjectives.Myaccountpage;
import utilities.DataProvisders;

public class TC003_LoginDDT extends BaseClass {
//data is valid---login success ---test pass -logout
	//data is valid----login fail----test fail
	//data is invalid---login success ---test fail -logout
		//data is invalid----login fail----test pass
	@Test(dataProvider="Logindata",dataProviderClass=DataProvisders.class,groups="dataDriven")//getting data provider form different class
	public void verify_loginDDT(String email, String pswd,String exp) throws Throwable
	{
		try
		{
	//homepage
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickLogin();
		//Loginpage
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(pswd);
lp.clicklogin();
//Myaccount
Myaccountpage mac=new Myaccountpage(driver);
boolean target=mac.ismyaccountExist();
	if(exp.equalsIgnoreCase("valid"))//data is valid
	{
	if(target=true)//login success
	{
		mac.Logut();
		Assert.assertTrue(true);//test case is pass	
	
	}
	else
	Assert.assertTrue(false);//test case fail
	}
	if(exp.equalsIgnoreCase("invalid"))//data is valid
	{
	if(target=true)//login success
	{
		mac.Logut();
	Assert.assertTrue(false);//test case is fail	
	
	}
	else
	Assert.assertTrue(true);//test case pass
	}

	}
	
		catch (Exception e) {
			// TODO: handle exception
		
		Assert.fail();
		}

	}
}
