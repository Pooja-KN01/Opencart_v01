package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"} )
	public void Login_verified() {
		logger.info("*******Login test started*************");
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("*******lickMyAccount*************");
		hp.btnclickaction();
		logger.info("*******login button clicked*************");
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setpwd(p.getProperty("pwd"));
		lp.clklogin();
		
		//my account page
		MyAccount ma=new MyAccount(driver);
		boolean targetpage=ma.isMyAccountPageExist();
		Assert.assertTrue(targetpage);
//		Assert.assertEquals(targetpage, true,"Login Failed");//Assert.assertTrue(targetpage);

		}catch(Exception e) {
			Assert.fail();

		}
		logger.info("*******Login test ended*************");
	}

}
