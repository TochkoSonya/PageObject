package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CatalogPage {

    private WebDriver driver;

    @FindBy(tagName = "img")
    List<WebElement> imageLinks;

    public CatalogPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public ProductPage selectItem(){
        imageLinks.get(3).click();
        return new ProductPage(driver);
    }
}
