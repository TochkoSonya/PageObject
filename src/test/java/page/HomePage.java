package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static final String HOMEPAGE_URL="https://lakbishop.by/";
    private WebDriver driver;

    @FindBy(className ="search")
    private WebElement searchButton;

    @FindBy(name="q")
    private WebElement searchField;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(searchButton));
        return this;
    }

    public CatalogPage searchForTerms(String searchQuery){
        searchButton.click();
        searchField.sendKeys(searchQuery);
        searchField.sendKeys(Keys.ENTER);
        return new CatalogPage(driver);
    }

}
