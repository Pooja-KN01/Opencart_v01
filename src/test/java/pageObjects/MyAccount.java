package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}
	
	
@FindBy(xpath="//*[@id=\"content\"]/h2[1]")
WebElement MyAccount;

@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
WebElement Logout;

public boolean isMyAccountPageExist() {
	try {
		return(MyAccount.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void logout() {
	Logout.click();
}
}
