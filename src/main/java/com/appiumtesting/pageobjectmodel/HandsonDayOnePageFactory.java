package com.appiumtesting.pageobjectmodel;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.appiumtesting.AppiumHandson.AndroidActions;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HandsonDayOnePageFactory extends AndroidActions{

	AndroidDriver driver;
	WebDriverWait wait;
	String itemName;

	public HandsonDayOnePageFactory(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
	private WebElement view;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc=\"Drag and Drop\"]")
	private WebElement dragDrop;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_dot_3")
	private WebElement thirdCircle;
	
	@AndroidFindBy(id="io.appium.android.apis:id/drag_result_text")
	private WebElement droppedText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Views/TextClock\"]")
	private WebElement clockHeadingText;
	
	@AndroidFindBy(accessibility = "Gallery")
	private WebElement gallery;
	
	@AndroidFindBy(accessibility = "1. Photos")
	private WebElement photo;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView)[1]")
	private WebElement firstImage;
	
	@AndroidFindBy(xpath="(//android.widget.ImageView)[2]")
	private WebElement secondImage;
	
	@AndroidFindBy(accessibility = "Expandable Lists")
	private WebElement expandLists;
	
	@AndroidFindBy(accessibility = "1. Custom Adapter")
	private WebElement customerAdaptor;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='People Names']")
	private WebElement people;
	
	@AndroidFindBy(id="io.appium.android.apis:id/edit")
	private WebElement textFieldLines;
	
	
	public void dragAndDropTheCircle() {

		view.click();

		dragDrop.click();

		((JavascriptExecutor)driver).executeScript("mobile: dragGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)thirdCircle). getId(),
						"endX", 194,
						"endY", 640
						));
		
		String text = droppedText.getText();

		Assert.assertEquals(text, "Dropped!");
	}
	
	public void scrollDownToTextClock(String text) throws InterruptedException {

		for(int i=0; i<2; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
		
		
		view.click();
		scrollAndClick(text);
		String heading = clockHeadingText.getText();
		Assert.assertEquals(heading, "Views/TextClock");
		
	}
	
	public void swipeToSecondImage() {
		
		for(int i=0; i<2; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
		
		view.click();
		gallery.click();
		photo.click();
		
		Assert.assertEquals(firstImage.getAttribute("focusable"),"true");
		
	
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement)firstImage).getId(),
				"direction", "left",
				"percent", 0.10
				));
		Assert.assertEquals(firstImage.getAttribute("focusable"),"false");
		
		
	}
	
	public void peopleNames() throws InterruptedException {
		
		for(int i=0; i<3; i++) {
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
	
		
		view.click();
		expandLists.click();
		customerAdaptor.click();
		people.click();
		
	}
	
	public void enterDataIntoText(String textField, String content) {
		
		for(int i=0; i<3; i++) {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
		view.click();
		scrollAndClick(textField);
		textFieldLines.sendKeys(content);
		
		
	}
	
}
