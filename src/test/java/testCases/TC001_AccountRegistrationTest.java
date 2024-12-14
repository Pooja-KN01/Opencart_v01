package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("****** TC001_AccountRegistrationTest is started *******");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my my account link.......");
		hp.clickRegister();
		logger.info("clicked on register link.....");
		
		
		logger.info("******  providing customer registration details*******");
		AccountRegistrationPage acp=new AccountRegistrationPage(driver);
		acp.setFirstname(randomString().toUpperCase());
		acp.setLastName(randomString().toUpperCase());
		acp.setemail(randomString()+"@gmail.com");//randomly generated email id
		acp.setPhone(randomNumber());
		acp.setPwd("323213sad");
		acp.setconfirmpwd("323213sad");
		acp.ClickAgree();
		acp.Clickcontinueed();
		logger.info("Validating expected message...");
		String confirmmsg=acp.getConfirmationmsg();
		
		if(confirmmsg.equals("Congratulations! Your new account has been successfully created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Trst failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		}
		catch(Exception e) {
			logger.error("Test faile");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("****** TC001_AccountRegistrationTest is finished *******");

	}
	
	
}
