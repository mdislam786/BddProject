package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankCashPage {

	WebDriver driver;

	// Every Page must have a constructor to invite the driver
	public BankCashPage(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//body/section[1]/div[1]/nav[1]/div[1]/ul[1]/li[10]/a[1]")
	WebElement BankCash;	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'New Account')]")
	WebElement NewAccount;	
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement AcountTitle;	
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement Description;	
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement InitialBalance;	
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement AccountNumber;	
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement ContactPerson;	
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement Phone;	
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement InternetBankingUrl;	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/section[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/button[1]")
	WebElement Submit;
	
	public void clickOnBankCash() throws Throwable   {
		BankCash.click();
		Thread.sleep(2000);
	}
	
	public void clickOnNewAccount() throws Throwable {
		NewAccount.click();	
		Thread.sleep(2000);
	}
	
	public void newAccountDetails(String accountTitle,String description,String initialBalance,String accountNumber,String contactPerson,String phone,String internetBankingUrl) throws Throwable {
			
		AcountTitle.sendKeys(accountTitle);
		Description.sendKeys(description);
		InitialBalance.sendKeys(initialBalance);
		AccountNumber.sendKeys(accountNumber);
		ContactPerson.sendKeys(contactPerson);
		Phone.sendKeys(phone);
		InternetBankingUrl.sendKeys(internetBankingUrl);
		Thread.sleep(4000);
		Submit.click();
	}
	

}
