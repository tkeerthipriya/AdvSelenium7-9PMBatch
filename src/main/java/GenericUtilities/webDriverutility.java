package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverutility {
	
	public void togetWaitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	public void waitForVisibilityOfElements(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void switchToAlertSendKeys(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public String switchToAlertGetText(WebDriver driver,String text) {
		driver.switchTo().alert().getText();
		return text;
	}
	public void selByIndex(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void selByValue(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	public void selByVisibleText(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void mouseHoverActions(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void mouseHoverActionsClickOn(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}
	public void mouseHoverActionsDoubleClick(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	public void mouseHoverActionsRightClick(WebDriver driver,WebElement element) {
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	public void passInputActions(WebDriver driver,WebElement element,String text) {
		Actions act= new Actions(driver);
		act.click(element).sendKeys(text).perform();
	}
	
	public void switchToWindow(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> childid = driver.getWindowHandles();
		childid.remove(parentid);
		for(String windid:childid) {
			driver.switchTo().window(windid);
		}
	}
		
		
		
		public void takingScreenshot(WebDriver driver,String filename) throws IOException {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			File perm = new File("./errorshots/"+filename+".png");
		FileHandler.copy(temp, perm);
		}
		
		
	}

	
	
	


