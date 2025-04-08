package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseClass {

	//public static WebDriver driver;
	// Solution for above Static WebDriver
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public Properties p;
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	@BeforeClass (groups = { "smoke", "regression", "datadriven" })
	@Parameters({ "os", "browser" })
	public void openApp(String os, String br) throws IOException {

		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		// driver = new ChromeDriver();
		// this.driver = new ChromeDriver(); // Correctly assign to instance variable

		/*
		 * switch (br.toLowerCase()) { case "chrome": driver = new ChromeDriver();
		 * break; case "edge": driver = new EdgeDriver(); break; case "firefox": driver
		 * = new FirefoxDriver(); break; default:
		 * System.out.println("No matching browser.."); return; }
		 * 
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		 * 
		 * // Open URL driver.get(p.getProperty("appURL"));
		 * driver.manage().window().maximize(); // Maximize the window
		 */
		
		WebDriver localDriver = null;

		switch (br.toLowerCase()) {
		case "chrome":
			localDriver = new ChromeDriver();
			break;
		case "edge":
			localDriver = new EdgeDriver();
			break;
		case "firefox":
			localDriver = new FirefoxDriver();
			break;
		default:
			System.out.println("No matching browser..");
			return;
		}

		driver.set(localDriver); // Assign WebDriver instance to ThreadLocal

		// Set driver properties
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		getDriver().manage().window().maximize();
		getDriver().get(p.getProperty("appURL"));
		
		
		
	}

	/*
	 * // @Test(priority = 3)
	 * 
	 * @AfterClass public void closeApp() { // driver.close(); driver.quit(); //
	 * driver=null; }
	 */
	
	@AfterClass (groups = { "smoke", "regression", "datadriven" })
	public void closeApp() {
		if (getDriver() != null) {
			getDriver().quit();
			driver.remove(); // Remove WebDriver instance from ThreadLocal
		}
	}
	
	/*
	 * public String captureScreen(String tname) throws IOException {
	 * 
	 * String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 * 
	 * TakesScreenshot takesScreenshot = (TakesScreenshot) driver; File sourceFile =
	 * takesScreenshot.getScreenshotAs(OutputType.FILE);
	 * 
	 * String targetFilePath = System.getProperty("user.dir") +
	 * "\\screenshots\\" + tname + "_" + timeStamp + ".png"; File targetFile = new
	 * File(targetFilePath);
	 * 
	 * sourceFile.renameTo(targetFile);
	 * 
	 * return targetFilePath;
	 * 
	 * }
	 */
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File sourceFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		// Using Files.copy() for safe file movement
		Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		return targetFilePath;
	}
}
