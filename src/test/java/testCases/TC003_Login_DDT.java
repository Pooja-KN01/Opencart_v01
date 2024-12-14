package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.dataProviders;

/*Data is valid - login success - test pass - logout
  Data is valid -login failed -test fail
  
  Data is invalid - login success - test fail - logout
  Data is invalid - login failed - test pass
 
 */

public class TC003_Login_DDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=dataProviders.class,groups="Datadriven")//getting data provider from different class
	public void verify_LoginDDT(String email,String pwd,String exp) throws InterruptedException {
		logger.info("******TC003_Login_DDT started*****");
		
		try {
		//homepage
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("******clicked on myAccount*****");

		hp.btnclickaction();
		
		//login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setpwd(pwd);
		lp.clklogin();
		
		//myAccount page
		MyAccount ma=new MyAccount(driver);
		boolean targetpage=ma.isMyAccountPageExist();
		
		
		/*Data is valid - login success - test pass - logout
		   				- login failed -test fail
		  
		  Data is invalid - login success - test fail - logout
		                  - login failed - test pass
		 
		 */
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				ma.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				ma.logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e) 
		{
			Assert.fail();
		}
		
		Thread.sleep(3000);
		logger.info("******TC003_Login_DDT finished*****");	
		
	}
}
