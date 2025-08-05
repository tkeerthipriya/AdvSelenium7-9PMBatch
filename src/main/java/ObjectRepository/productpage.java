package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	WebDriver driver;
	public productpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "productName")
	private WebElement productname;
	@FindBy(name = "productCategory")
	private WebElement prodcat;
	@FindBy(name = "quantity")
private	WebElement quantity;
	@FindBy(name="price")
	private WebElement price;
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement button;
	public WebElement getProductname() {
		return productname;
	}
	public WebElement getProdcat() {
		return prodcat;
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public WebElement getPrice() {
		return price;
	}
	public WebElement getVendorId() {
		return vendorId;
	}
	public WebElement getButton() {
		return button;
	}

	
	

}
