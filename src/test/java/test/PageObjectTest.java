package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.HomePage;
import page.ProductPage;


public class PageObjectTest {

    private WebDriver driver;
    private Actions actionProvider;

    @BeforeTest
    public void init() {

        System.setProperty("webdriver.chrome.driver","D:\\WebDrivers\\chromedriver.exe");
    }

    @BeforeMethod(alwaysRun = true)
    public void driverSetup() {
        driver = new ChromeDriver();
        actionProvider = new Actions(driver);
    }

    @Test
    public void AddItemToBasketTest() {

        int expectedSearchResult=new HomePage(driver)
                .openPage()
                .searchForTerms("52 0")
                .selectItem()
                .chooseSize()
                .addToBasket()
                .goToBasket()
                .getCountResultsInBasket();

        Assert.assertTrue(expectedSearchResult>0);
    }

    @Test
    public void AddTheSameItemsToWishList() {

        int expectedSearchResult=new ProductPage(driver)
                .openPage()
                .chooseSize()
                .addToWishList()
                .stayOnProductPage()
                .addToWishList()
                .goToWishList()
                .getNumberItemsInWishList();

        Assert.assertEquals(expectedSearchResult,1);

    }



    @AfterMethod(alwaysRun = true)
    public void driverTearDown() {
        driver.quit();
        driver = null;
    }
}
