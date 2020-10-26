package page;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	// Every Page must have a constructor to invite the driver
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.ID, using = "username")
	WebElement UserName;
	@FindBy(how = How.ID, using = "password")
	WebElement Password;
	@FindBy(how = How.NAME, using = "login")
	WebElement SignInButton;

	// Methods to interact with the elements
	
	
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);		
	}
	
	public void enterPassword(String password) {
		Password.sendKeys(password);		
	}
	
	public void clickSignInButton() {
		SignInButton.click();		
	}
	
	public void login(String userName, String password) {
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		SignInButton.click();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void takeScreenshotAtEndOfTest(WebDriver driver) throws IOException {
		
		
		TakesScreenshot ts = ((TakesScreenshot) driver);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(sourceFile, new File("user" + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
}