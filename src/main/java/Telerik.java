import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Telerik {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void pageOpening() {
        driver.navigate().to("https://www.telerik.com/support/demos");
    }

    @Test
    public void validationForDesktopButton() {
        WebElement desktopButton = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[2]"));
        desktopButton.click();

        String expectedTitle = "Desktop";
        String actualTitle = driver.findElement(By.id("desktop")).getText();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void validationForMobileButton() {
        WebElement desktopButton = driver.findElement(By.xpath("//*[@id=\"ContentPlaceholder1_T53129E6C012_Col00\"]/nav/div/div[2]/a[3]"));
        desktopButton.click();

        String expectedTitle = "Mobile";
        String actualTitle = driver.findElement(By.id("mobile")).getText();

        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterClass
    public void closePage() {
        driver.close();
    }
}
