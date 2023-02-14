package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Search001 {
	public WebDriver driver;
	
	public Amazon_Search001(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Search Mobile in side search bar
	@FindBy(xpath = "//input[@id ='twotabsearchtextbox']")
	WebElement searchMobile;
	
	public void searchForMobile(String enterMobile) {
		searchMobile.sendKeys(enterMobile);	
	}

	@FindBy(xpath = "//input[@id ='nav-search-submit-button']")
	WebElement clickSearchIcon;
	
	public void clickOnSearchIcon() {
		clickSearchIcon.click();
	}
	
	//click on any mobile 
	@FindBy(xpath = "//img[@src = 'https://m.media-amazon.com/images/I/71HN4P-pd5L._AC_UL320_.jpg']")
	WebElement clickonMobile;
	
	public void clickOnAnyMobile() {
		clickonMobile.click();
	}	
	
	//fetch the price details
	@FindBy(xpath = "//span[@class= 'a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	WebElement fetchPrice;
	
	public void fetchPriceOfMo(){
		fetchPrice.getText();
		System.out.println("Price Of Mobile" + fetchPrice.getText());
	}
}
