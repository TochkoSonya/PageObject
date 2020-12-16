package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage extends AbstractPage {

    @FindBy(css = "a[class='chosen-single chosen-default'] span")
    private WebElement sizeListButton;

    @FindBy(css="ul[class='chosen-results'] li")
    private List<WebElement> listOfElements;

    @FindBy(css="button[class='full black bttn tocart']")
    private WebElement addToBasketButton;

    @FindBy(css="a[class='black bttn']")
    private WebElement moveToBasketButton;

    @FindBy(className="gray bttn towishlist")
    private WebElement addToWishListButton;

    @FindBy(className="black bttn")
    private WebElement stayOnProductPageButton;

    @FindBy(partialLinkText="/wishlist/")
    private WebElement goToWishListButton;


    public ProductPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ProductPage openPage(){
        driver.get(PRODACTPAGE_URL);
//        new WebDriverWait(driver,10)
//                .until(ExpectedConditions.visibilityOfAllElements());
        return this;
    }

    public ProductPage chooseSize(){
        sizeListButton.click();
//        new WebDriverWait(driver,5)
//                .until(ExpectedConditions.elementToBeClickable(listOfElements.get(1)));
        listOfElements.get(1).click();
        return this;
    }

    public ProductPage addToBasket(){
        addToBasketButton.click();
        new WebDriverWait(driver,5)
                .until(ExpectedConditions.elementToBeClickable(moveToBasketButton));
        return this;
    }

    public BasketPage goToBasket(){
        moveToBasketButton.click();
        return new BasketPage(driver);
    }

    public ProductPage addToWishList(){
        addToWishListButton.click();
        return this;
    }

    public ProductPage stayOnProductPage(){
        stayOnProductPageButton.click();
        return this;
    }
    public WishListPage goToWishList(){
        goToWishListButton.click();
        return new WishListPage(driver);
    }
}
