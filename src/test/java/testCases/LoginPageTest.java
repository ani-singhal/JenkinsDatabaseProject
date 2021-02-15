package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DataBasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpageObj;
	
	@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	 }
	
	@Test(priority=1)
	public void logintest() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		loginpageObj.enterUserName("demo@techfios.com");
		Thread.sleep(5000);

		loginpageObj.enterPassword("abc123");
		Thread.sleep(5000);

//		loginpageObj.enterUserName(DataBasePage.getData("username"));
//		loginpageObj.enterPassword(DataBasePage.getData("password"));
		loginpageObj.clickSignInButton();
		Thread.sleep(5000);
		
		takeScreenshotAtEndOfTest(driver);
		
	}
	
	@Test(priority=2)
	public void logintest2() throws InterruptedException, ClassNotFoundException, SQLException, IOException {
		loginpageObj.enterUserName("demo@techfios.com");
		loginpageObj.enterPassword("abc123");
//		loginpageObj.enterUserName(DataBasePage.getData("username"));
//		loginpageObj.enterPassword(DataBasePage.getData("password"));
		loginpageObj.clickSignInButton();
		Thread.sleep(10000);
		
		 String expectedTitle="Dashboard- iBilling";
		  String actualTitle=loginpageObj.getPageTitle();
		  System.out.println(actualTitle);
		  
		 Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@AfterMethod
	 public void tearDown() {  
	  driver.close();
	  driver.quit();
	 }
	
}
