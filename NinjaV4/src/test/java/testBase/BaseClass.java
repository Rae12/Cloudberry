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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

    private static final Logger log = LogManager.getLogger(BaseClass.class);
    private Properties p;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    @BeforeClass(groups = { "smoke", "regression", "datadriven" })
    @Parameters({ "os", "browser" })
    public void openApp(String os, String br) {
        log.info("Starting Test Execution - OS: {}, Browser: {}", os, br);

        try {
            // Load properties file
            FileReader file = new FileReader(".//src//test//resources//config.properties");
            p = new Properties();
            p.load(file);
            log.debug("Successfully loaded config.properties file.");

            WebDriver localDriver;

            switch (br.toLowerCase()) {
                case "chrome":
                    log.info("Launching Chrome Browser");
                    localDriver = new ChromeDriver();
                    break;
                case "edge":
                    log.info("Launching Edge Browser");
                    localDriver = new EdgeDriver();
                    break;
                case "firefox":
                    log.info("Launching Firefox Browser");
                    localDriver = new FirefoxDriver();
                    break;
                default:
                    log.error("Invalid browser name provided: {}", br);
                    throw new IllegalArgumentException("No matching browser found: " + br);
            }

            driver.set(localDriver);
            log.debug("WebDriver instance set successfully.");

            // Configure WebDriver settings
            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
            getDriver().manage().window().maximize();
            getDriver().get(p.getProperty("appURL"));

            log.info("Successfully launched application URL: {}", p.getProperty("appURL"));
        } catch (IOException e) {
            log.error("Error loading properties file: {}", e.getMessage(), e);
        } catch (Exception e) {
            log.error("Error initializing WebDriver: {}", e.getMessage(), e);
        }
    }

    @AfterClass(groups = { "smoke", "regression", "datadriven" })
    public void closeApp() {
        try {
            if (getDriver() != null) {
                log.info("Closing browser...");
                getDriver().quit();
                driver.remove();
                log.info("Browser closed and WebDriver instance removed.");
            }
        } catch (Exception e) {
            log.error("Error while closing the browser: {}", e.getMessage(), e);
        }
    }

    public static String captureScreen(String tname) throws IOException {
        if (getDriver() == null) {
            throw new IllegalStateException("WebDriver instance is null, cannot take screenshot.");
        }

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".png";

        File sourceFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        File targetFile = new File(targetFilePath);

        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        log.info("Screenshot captured: {}", targetFilePath);

        return targetFilePath;
    }
}