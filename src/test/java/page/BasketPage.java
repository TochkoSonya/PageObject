package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasketPage extends AbstractPage {


    @FindBy(css="div[class='item clearfix']")
    List<WebElement> favoriteItemsList;

    public BasketPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getCountResultsInBasket(){
        return favoriteItemsList.size();
    }
}
