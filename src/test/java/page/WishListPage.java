package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WishListPage extends AbstractPage{

    @FindBy(css="div[class='item clearfix']")
    private List<WebElement> itemsInWishList;

    public WishListPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public int getNumberItemsInWishList(){
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.visibilityOf(itemsInWishList.get(0)));
        return itemsInWishList.size();
    }
}
