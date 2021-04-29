package stepdefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

public class TasksStepDefinition extends BaseClass{
	
	String dressName;
	String cnfdressName;


	@Test(priority=0)
	@Given("^an user opens the browser and url$")
	public void openBrowserAndUrl() throws Throwable {
		fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\properties\\config.properties");

		prop.load(fis);
		
		if (prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\properties\\chromedriver.exe");
			driver = new ChromeDriver();	
		
		} else {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

		}


		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


	}
	@Test(priority=1)
	@When("^the user click on signIn button$")
	public void enterUnamePwd() {
		WebElement signInBtn = driver.findElement(By.xpath(prop.getProperty("signIn")));
		signInBtn.click();
	}

	@Test(priority=2)
	@And("^enter the email address and click on create an account button$")
	public void enterEmail() throws Throwable {
		String emailtxt=BaseClass.getData("email");
		driver.findElement(By.xpath(prop.getProperty("eMailXpath"))).sendKeys(emailtxt);
		driver.findElement(By.xpath(prop.getProperty("createAccBtn"))).click();
		
	}
	@Test(priority=3)
	@Then("^the personal information page has to be displayed$")
	public void personalInfoPage() {
		Assert.assertEquals(driver.getTitle(), prop.getProperty("PersonalInfoPgTitle"));
	}
	@Test(priority=4)
	@Given("^an user enters all the required information$")
	public void custinfo() throws IOException {

		String fnametxt=BaseClass.getData("firstname");
		driver.findElement(By.xpath(prop.getProperty("fstnameXpath"))).sendKeys(fnametxt);
		
		String lnametxt=BaseClass.getData("lastname");
		driver.findElement(By.xpath(prop.getProperty("lstnameXpath"))).sendKeys(lnametxt);
		
		String pwdtxt=BaseClass.getData("password");
		driver.findElement(By.xpath(prop.getProperty("pwdXpath"))).sendKeys(pwdtxt);
		
		String addrtxt=BaseClass.getData("address1");
		driver.findElement(By.xpath(prop.getProperty("addr1Xpath"))).sendKeys(addrtxt);
		
		String citytxt=BaseClass.getData("city");
		driver.findElement(By.xpath(prop.getProperty("cityXpath"))).sendKeys(citytxt);
		
		String statetxt=BaseClass.getData("state");
		Select selectState=new Select(driver.findElement(By.xpath(prop.getProperty("stateXpath"))));
		selectState.selectByVisibleText(statetxt);
		
		String ziptxt=BaseClass.getData("zip");
		driver.findElement(By.xpath(prop.getProperty("zipXpath"))).sendKeys(ziptxt);
		
		String mobiletxt=BaseClass.getData("mobile");
		driver.findElement(By.xpath(prop.getProperty("mobileXpath"))).sendKeys(mobiletxt);
		
		String aliastxt=BaseClass.getData("alias");
		driver.findElement(By.xpath(prop.getProperty("aliasXpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("aliasXpath"))).sendKeys(aliastxt);
		
	}	
	
	@Test(priority=5)
	@And("^click on register button$")
	public void clkRegBtn() {
		driver.findElement(By.xpath(prop.getProperty("regbtnXpath"))).click();
		
	}
	
	@Test(priority=6)
	@Then("^the my account page has to be displayed$")
	public void myAccPage() throws Throwable {
		String fnametxt=BaseClass.getData("firstname");
		String lnametxt=BaseClass.getData("lastname");
		String fullName=fnametxt+" "+lnametxt;
		String regName=driver.findElement(By.xpath("//span[contains(text(),'"+fullName+"')]")).getText();
		
		Assert.assertEquals(fullName, regName);
	}
	
	@Test(priority=7)
	@Given("^an user logout and login again$")
	public void logoutAndLogin() throws Throwable {
		driver.findElement(By.xpath(prop.getProperty("logoutXpath"))).click();
		String emailtxt=BaseClass.getData("email");
		driver.findElement(By.xpath(prop.getProperty("regEmailXpath"))).sendKeys(emailtxt);
		String pwdtxt=BaseClass.getData("password");
		driver.findElement(By.xpath(prop.getProperty("regPwdXpath"))).sendKeys(pwdtxt);
		driver.findElement(By.xpath(prop.getProperty("submitBtnXpath"))).click();
		
	}
	
	@Test(priority=8)
	@When("^the user add a product to cart$")
	public void addProdToCart() {
		driver.findElement(By.xpath(prop.getProperty("dressXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("printedDressXpath"))).click();
		dressName=driver.findElement(By.xpath(prop.getProperty("dressNameXpath"))).getText();
		
		driver.findElement(By.xpath(prop.getProperty("addToCartBtnXpath"))).click();
	}
	
	@Test(priority=9)
	@And("^proceed to the checkout page and continue till payments$")
	public void chkOutPage() {
		driver.findElement(By.xpath(prop.getProperty("checkOutBtnXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("sumCheckOutBtnXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("addrCheckOutBtnXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("tcCheckkBoxXpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("shpCheckOutBtnXpath"))).click();
		
		cnfdressName=driver.findElement(By.xpath(prop.getProperty("cnfdressNameXpath")+dressName+"')]")).getText();
		
	}
	
	@Test(priority=10)
	@Then("^the payment page has to be displayed$")
	public void paymentPage(){
		
		Assert.assertEquals(dressName, cnfdressName);
		driver.close();
}
}