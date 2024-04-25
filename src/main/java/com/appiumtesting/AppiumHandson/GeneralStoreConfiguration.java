package com.appiumtesting.AppiumHandson;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class GeneralStoreConfiguration extends AppiumUtils {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void appiumSetUp() throws URISyntaxException, IOException {

		FileInputStream fis = new FileInputStream("C://Users//SUMAHALI//eclipse-workspace//AppiumHandson//src//test//java//Resources//data.properties");

		Properties prop = new Properties();
	
		prop.load(fis);
		
		String ipAddress = System.getProperty("ipAddress")!=null ? System.getProperty("ipAddress") : prop.getProperty("ipAddress");

		String port = prop.getProperty("port");

		service=startAppiumServer(ipAddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();

		options.setDeviceName(prop.getProperty("AndroidDeviceName"));

		options.setApp("C://Users//SUMAHALI//eclipse-workspace//AppiumHandson//src//test//java//Resources//General-Store.apk");
		
		options.setChromedriverExecutable("C://Users//SUMAHALI//eclipse-workspace//Appium//src//test//java//Resource//chromedriver.exe");

		options.setCapability("ADB_EXEC_TIMEOUT_OPTION", 60000);

		driver = new AndroidDriver(service.getUrl(),options );

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}


	@AfterClass
	public void tearDown() throws InterruptedException {

		driver.quit();

		service.stop();

		Thread.sleep(3000);
	}

}
