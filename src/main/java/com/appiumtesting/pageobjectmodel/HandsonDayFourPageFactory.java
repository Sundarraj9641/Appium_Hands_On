package com.appiumtesting.pageobjectmodel;


import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang3.RandomStringUtils;


public class HandsonDayFourPageFactory{

	AndroidDriver driver;
	WebDriverWait wait;
	String itemName;
	static String customerId;
	static String accountId;
	String email = randomEmail()+"1234gmail.com";
	public HandsonDayFourPageFactory(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@FindBy(xpath="/html/body/table/tbody/tr/td")
	private WebElement body;

	@FindBy(xpath="//input[@name='uid']")
	private WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	private WebElement password;

	@FindBy(xpath="//input[@name='btnLogin']")
	private WebElement loginButton;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
	private WebElement confirmation;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[9]/a")
	private WebElement withdrawal;
	
	@FindBy(xpath="//input[@name='accountno']")
	private WebElement accNo;
	
	@FindBy(xpath="//input[@name='ammount']")
	private WebElement amt;
	
	@FindBy(xpath="//input[@name='desc']")
	private WebElement desc;
	
	@FindBy(xpath="//input[@name='AccSubmit']")
	private WebElement accSubmit;

	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	private WebElement newCustomer;

	@FindBy(xpath="//input[@name='name']")
	private WebElement custName;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	private WebElement gender;

	@FindBy(xpath="//*[@id=\"dob\"]")
	private WebElement dobField;

	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	private WebElement addressField;

	@FindBy(xpath="//input[@name='city']")
	private WebElement cityField;

	@FindBy(xpath="//input[@name='state']")
	private WebElement stateField;

	@FindBy(xpath="//input[@name='pinno']")
	private WebElement pinField;

	@FindBy(xpath="//input[@name='telephoneno']")
	private WebElement mobileField;

	@FindBy(xpath="//input[@name='emailid']")
	private WebElement emailField;

	@FindBy(xpath="//input[@name='password']")
	private WebElement custpwd;

	@FindBy(xpath="//input[@name='sub']")
	private WebElement submitButton;

	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[1]/td/p")
	private WebElement successRegistration;

	@FindBy(xpath="//*[@id=\"customer\"]/tbody/tr[4]/td[2]")
	private WebElement custId;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[5]/a")
	private WebElement newAccount;
	
	@FindBy(xpath="//input[@name='cusid']")
	private WebElement custoId;
	
	@FindBy(xpath="//input[@name='inideposit']")
	private WebElement deposite;
	
	@FindBy(xpath="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]")
	private WebElement accountSubmit;

	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[1]/td/p")
	private WebElement accountRegistration;
	
	@FindBy(xpath="//*[@id=\"account\"]/tbody/tr[4]/td[2]")
	private WebElement accId;
	
	@FindBy(xpath="//*[@id=\"withdraw\"]/tbody/tr[1]/td/p")
	private WebElement withdrawalconfirm;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	private WebElement logout;

	
	public String randomEmail() {
		String generatedEmail = RandomStringUtils.randomAlphabetic(8);
		return (generatedEmail);
	}
	

	public void login(String usrname, String pwd) throws InterruptedException {
		userName.sendKeys(usrname);
		
		password.sendKeys(pwd);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", loginButton);

		String msg = confirmation.getText();

		Assert.assertEquals(msg, "Manger Id : mngr568478");
	}
	
	public void withdrawalNegative(String accountNo, String amount, String description) throws InterruptedException {
		
		withdrawal.click();
		
		driver.navigate().to("https://demo.guru99.com/V4/manager/WithdrawalInput.php");
		
		Thread.sleep(2000);
		
		accNo.sendKeys(accountNo);
		
		amt.sendKeys(amount);
		
		desc.sendKeys(description);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", accSubmit);
		
		Thread.sleep(4000);
		Alert a = driver.switchTo().alert();
		a.accept();
		Thread.sleep(4000);
		
	}

	public void customer(String customerName, String dob, String address, String city, String state, String pin, String mobileNo, String pwd  ) throws InterruptedException {
		newCustomer.click();
		
		driver.navigate().to("https://demo.guru99.com/V4/manager/addcustomerpage.php");
		
		WebElement formElement = driver.findElement(By.name("addcust"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('onSubmit', 'return true;')", formElement);
		
		custName.clear();
		custName.sendKeys(customerName);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(gender));
		gender.click();
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].value = '" +dob+ "';", dobField);
		
		Thread.sleep(2000);
		
		addressField.clear();
		addressField.sendKeys(address);
		
		cityField.clear();
		cityField.sendKeys(city);
		
		stateField.clear();
		stateField.sendKeys(state);
		
		pinField.clear();
		pinField.sendKeys(pin);
		
		mobileField.clear();
		mobileField.sendKeys(mobileNo);
		
		emailField.clear();
		emailField.sendKeys(email);
		
		custpwd.clear();
		custpwd.sendKeys(pwd);
		
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(2000);
		
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(submitButton));
	
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
		jsExecutor1.executeScript("arguments[0].click();", submitButton);
		Thread.sleep(2000);
		
	
		String regMsg = successRegistration.getText();
		Assert.assertEquals(regMsg, "Customer Registered Successfully!!!");
		customerId=custId.getText();
		System.out.println("Customer ID: " + customerId);
		Thread.sleep(2000);
	}
	
	public void account(String initialDeposite) throws InterruptedException {
		newAccount.click();
		
		Thread.sleep(2000);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(custoId));
	    custoId.clear();
	    custoId.sendKeys(customerId);
		
		deposite.sendKeys(initialDeposite);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(accountSubmit));
	
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor)driver;
		jsExecutor1.executeScript("arguments[0].click();", accountSubmit);
		Thread.sleep(2000);
		
		String accRegMsg = accountRegistration.getText();
		
		Assert.assertEquals(accRegMsg, "Account Generated Successfully!!!");
		
		accountId=accId.getText();
		System.out.println("Account ID: " + accountId);
		
		Thread.sleep(2000);
		
	}
	
public void withdrawalPositive(String amount, String description) throws InterruptedException {
		
		withdrawal.click();
		
		driver.navigate().to("https://demo.guru99.com/V4/manager/WithdrawalInput.php");
		
		Thread.sleep(2000);
		
		accNo.sendKeys(accountId);
		
		amt.sendKeys(amount);
		
		desc.sendKeys(description);
		
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
		jsExecutor.executeScript("arguments[0].click();", accSubmit);
		
		Thread.sleep(4000);
		
	}

	public void exit() throws InterruptedException {
		
		logout.click();

		Thread.sleep(4000);
		
		Alert a = driver.switchTo().alert();
		a.accept();
		
		Thread.sleep(4000);
	}

}


