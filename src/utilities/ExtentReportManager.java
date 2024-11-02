package utilities;

import java.awt.Desktop;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;



import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseTest.BaseClass;
//import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManager implements ITestListener{
	public ExtentReports extent;
	public ExtentSparkReporter sparkreporter;
public ExtentTest test;
String repName;
//Listeners methods started
public void  onStart(ITestContext testContext)
{
	
	/*
	 * SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.ss"); Date dt=new
	 * java.util.Date(); String currentdatetimestamp=df.format(dt);
	 */
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new java.util.Date());
repName ="Test-Report-"+timestamp+".html";//dynamically genarated html extent report with date 

//textentsparkreport for UI prasantation
sparkreporter =new ExtentSparkReporter(".\\reports\\" + repName);//specify location of the report
sparkreporter.config().setDocumentTitle("OPENCART AUTOMATION REPORT");
sparkreporter.config().setReportName("OPENCART FUNCTIONAL TESTING");
sparkreporter.config().setTheme(Theme.DARK);

extent=new ExtentReports();
extent.attachReporter(sparkreporter);
extent.setSystemInfo("Application", "opencart");
extent.setSystemInfo("Module", "Registration");
extent.setSystemInfo("sub Module", "Admin");
extent.setSystemInfo("Gowthami", System.getProperty("user.name"));
extent.setSystemInfo("Environment", "QA");
//get operating system from xml file
String os=testContext.getCurrentXmlTest().getParameter("os");
extent.setSystemInfo("Operating System", os);
//get browser from xml file
String browser=testContext.getCurrentXmlTest().getParameter("browser");
extent.setSystemInfo("Browser", browser);

List<String> includegruops= testContext.getCurrentXmlTest().getIncludedGroups();
if(!includegruops.isEmpty())
{
	
	extent.setSystemInfo("Gruops", includegruops.toString());
}
}
public void onTsetSuccess(ITestResult result)
{
	test=extent.createTest(result.getClass().getName());
	test.assignCategory(result.getMethod().getGroups());//to display gruops in reports
	test.log(Status.PASS,result.getName()+"got successfully excuted");
}
public void onTestFailure(ITestResult result)
{
	test= extent.createTest(result.getClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.FAIL, result.getName()+"got failed");
	test.log(Status.INFO,result.getThrowable().getMessage());

	try {
		String imgpath=new BaseClass().captureScreen(result.getName());
		test.addScreenCaptureFromPath(imgpath);
		
	} catch (Throwable e1) {
		e1.printStackTrace();
	
}
}


public void onTestSkipped(ITestResult result)
{
	test=extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.SKIP, result.getName()+"got skipped");
test.log(Status.INFO,result.getThrowable().getMessage());
}
public void onFinish(ITestContext testContext)
{
	extent.flush();
	String PathofextentReport=System.getProperty("uesr.dir")+"\\reports\\"+repName;
	File extentreport=new File(PathofextentReport);
	
	/*try
	{
		Desktop.getDesktop().browse(extentreport.toURI());
	}catch (Exception e) {
		e.printStackTrace();
	}*/
}
}
