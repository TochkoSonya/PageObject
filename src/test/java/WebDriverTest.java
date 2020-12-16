import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebDriverTest {

    private WebDriver driver;
    private Actions actionProvider;

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        actionProvider = new Actions(driver);
    }

    @Test
    public void AddItemToBasketTest() {

        driver.get("https://lakbishop.by/");
        WebElement searchButton = driver.findElement(By.className("search"));
        searchButton.click();
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("52 0");
        searchField.sendKeys(Keys.ENTER);
       ///---------------------------------

        WebElement imageLink = driver.findElements(By.tagName("img")).get(3);
        imageLink.click();
        //-----------------------

        WebElement sizeList = driver.findElement(By.cssSelector("a[class='chosen-single chosen-default'] span"));
        sizeList.click();
       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement elemOfList = driver.findElements(By.cssSelector("ul[class='chosen-results'] li")).get(1);
        elemOfList.click();
        WebElement recyclebinButton = driver.findElement(By.cssSelector("button[class='full black bttn tocart']"));
        recyclebinButton.click();
        WebElement moveInRecyclebinButton = driver.findElement(By.cssSelector("a[class='black bttn']"));
        moveInRecyclebinButton.click();
        //-----------------------------

       // driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> favoriteItemsList = driver.findElements(By.cssSelector("div[class='item wishlist'] div"));
        Assert.assertTrue(favoriteItemsList.size()>0);
    }

    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}
