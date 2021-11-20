package functionalLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions
{
    public static WebDriver driver;
    public String configPath=new File("src/test/resources/testData/configFile").getAbsolutePath();
    public String screenShotPath = new File("src/test/resources/screenshots").getAbsolutePath();
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }
    public void closeBrowser()
    {
        driver.quit();
    }
    public String readPropertyFile(String key)throws Exception
    {
        FileInputStream inputStream=new FileInputStream(configPath);
        Properties properties=new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public void hoverOver(WebElement element)
    {
        Actions actions=new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void implicitlyWait(int waitTime)
    {
        driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
    }

    public void takeScreenShots(String fileName)throws Exception
    {
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File virtualFile = screenshot.getScreenshotAs(OutputType.FILE);
        File physicalFile = new File(screenShotPath+fileName);
        FileUtils.copyFile(virtualFile,physicalFile);
    }
}
