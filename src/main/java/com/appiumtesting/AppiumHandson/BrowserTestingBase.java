package com.appiumtesting.AppiumHandson;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserTestingBase {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void baseSetUp() throws MalformedURLException, URISyntaxException {

		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//SUMAHALI//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		service.start();

		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName("SundarrajMobile");

		options.setChromedriverExecutable("C://Users//SUMAHALI//eclipse-workspace//AppiumHandson//src//test//java//Resources//chromedriver.exe");

		options.setCapability("browserName", "Chrome");


		driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options );
		
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/weborders/login.aspx");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {

		driver.quit();

		service.stop();
	}

}
