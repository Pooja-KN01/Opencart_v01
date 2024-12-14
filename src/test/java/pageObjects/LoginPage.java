package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
@FindBy(xpath="//*[@id=\"input-email\"]")
WebElement textemailaddress;

@FindBy(xpath="//*[@id=\"input-password\"]")
WebElement password;

@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
WebElement loginbtn;


public void setEmail(String email) {
	textemailaddress.sendKeys(email);
}

public void setpwd(String pwd) {
	password.sendKeys(pwd);
}

public void clklogin() {
	loginbtn.click();
}


}
