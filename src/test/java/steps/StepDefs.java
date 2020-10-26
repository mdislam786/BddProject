package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import page.BankCashPage;
import page.LoginPage;
import util.BrowserFactory;


public class StepDefs  {	
	WebDriver driver;
	LoginPage loginPage;
	BankCashPage bankCashPage;
	
	@Before
	public void beforeRun() {
		driver = BrowserFactory.startBrowser();
		loginPage=PageFactory.initElements(driver, LoginPage.class);
		bankCashPage=PageFactory.initElements(driver, BankCashPage.class);
	}
	
	@Given("^User is on the techfios login page$")
	public void user_is_on_the_techfios_login_page() throws Throwable {
//		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
//		driver= new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@When("^User enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as(String username) throws Throwable {
//		loginPage=PageFactory.initElements(driver, LoginPage.class);
//		driver.findElement(By.id("username")).sendKeys(username);
		loginPage.enterUserName(username);
		Thread.sleep(2000);
	
	}

	@When("^User enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as(String password) throws Throwable {
//		driver.findElement(By.name("password")).sendKeys(password);
//		loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterPassword(password);
		Thread.sleep(2000);
	}

	@And("^User clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
//		loginPage=PageFactory.initElements(driver, LoginPage.class);
//		driver.findElement(By.name("login")).click();
		loginPage.clickSignInButton();
		Thread.sleep(4000);
	}
	
	@When("^User enters the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_the_and(String username, String password) throws Throwable {
//		loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(username);  
		loginPage.enterPassword(password);
	}

	@Then("^User should be able to see the dashboard$")
	public void user_should_be_able_to_see_the_dashboard() throws Throwable {	
//		loginPage=PageFactory.initElements(driver, LoginPage.class);
//		loginPage.takeScreenshotAtEndOfTest(driver);
		String expectedTitle="Dashboard- iBilling";
		String actualTitle=loginPage.getPageTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);		
		
	}
	
	@Then("^User should not be able to see the dashboard$")
	public void user_should_not_be_able_to_see_the_dashboard() throws Throwable {
	    System.out.println("User is not able to login");
	}
	
	@Then("^User clicks on bank and cash$")
	public void user_clicks_on_bank_and_cash() throws Throwable {
//		bankCashPage=PageFactory.initElements(driver, BankCashPage.class);
		bankCashPage.clickOnBankCash();
		Thread.sleep(2000);
	}

	@Then("^User clicks on new account$")
	public void user_clicks_on_new_account() throws Throwable {
//		bankCashPage=PageFactory.initElements(driver, BankCashPage.class);
		bankCashPage.clickOnNewAccount();
		Thread.sleep(2000);
	}

	@Then("^User fill up the form entering \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\"and \"([^\"]*)\" and clicks on submit$")
	public void user_fill_up_the_form_entering_and_and_and_and_and_and_and_clicks_on_submit(String accountTitle, String description, String initialBalance, String accountNumber, String contactPerson, String phone, String internetBankingUrl) throws Throwable {
//		bankCashPage=PageFactory.initElements(driver, BankCashPage.class);
		bankCashPage.newAccountDetails(accountTitle, description, initialBalance, accountNumber, contactPerson, phone, internetBankingUrl);
		
	}

	@Then("^User should be able to see validate$")
	public void user_should_be_able_to_see_validate() throws Throwable {
		loginPage.takeScreenshotAtEndOfTest(driver);
	    System.out.println("User succesfully created an account!");
	}
	
	@After
	public void afterRun() {
		driver.close();
		driver.quit();		
	}

}
