package automationGmail;
import util.DriverManager;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ApplicationSteps {
    private WebDriver driver;
    private WebDriverWait wait;

    public ApplicationSteps() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    private By signInButton = By.xpath("//a[@data-action='sign in']");
    private By emailField = By.xpath("//input[@type='email']");
    private By nextButton = By.xpath("//span[contains(text(),'Next')]");
    private By passwordField = By.xpath("//input[@autocomplete='current-password']");
    private By composeButton = By.cssSelector(".T-I.T-I-KE.L3");
    private By toField =  By.id(":cw");
  //  private By toField = By.xpath("//*[@id=\":81\"]/div");
    private By subjectField = By.name("subjectbox");
    private By bodyField = By.xpath("//div[@aria-label='Message Body']");
    private By sendButton = By.cssSelector(".T-I.J-J5-Ji.aoO.v7.T-I-atl.L3");
    private By sentMessagePopUp = By.xpath("//span[text()='Message sent']");
    private By userIcon = By.xpath(" //*[@id='gb']/div[2]/div[3]/div[1]/div[2]/div/a");
    private By logOut = By.xpath("//div[text()='Sign out']");
    private By discardButton = By.xpath("//td/img[@alt='Close']");
    private By draftButton = By.xpath("//*[text()='Drafts']");
    private By okButton = By.xpath("//span[text()='OK']");
    private By deleteBox = By.xpath("//*[@id=':12d']");

    public void launchApplication(String strURL) throws Exception{
        try {
            driver.get(strURL);
        } catch (Exception e) {
            System.out.println("Exception occurred while navigating to the URL: " + e.getMessage());
        }
    }
    
    //click on sign In button
    public void clickOnSignInButton() throws Exception
    {
        try {
          driver.findElement(signInButton).click();;
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clicking on Sign In Button: " + e.getMessage());

        }}
    public void clickOnOkButton() throws Exception
    {
        try {
          driver.findElement(okButton).click();;
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clicking on Sign In Button: " + e.getMessage());

        }}
   //enter email Id
    public void enterUsername(String username) throws Exception


    {
        try {
        	driver.findElement(emailField).sendKeys(username);
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while Entering the username: " + e.getMessage());

        }
        

    }
 
    //click on Next Button
    public void clickNext() throws Exception

    {
        try {
        	wait.until(ExpectedConditions.elementToBeClickable(nextButton));

        	driver.findElement(nextButton).click();
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clicking on the Next Button: " + e.getMessage());

        }
        

    }
    //Enter Password
    public void enterPassword(String password) throws Exception

    {
        try {
        	driver.findElement(passwordField).sendKeys(password);
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while Entering the password: " + e.getMessage());

        }
        

    }
  //Click on compose button
    public void clickOnComposeButton() throws Exception

    {
        try {
        	driver.findElement(composeButton).click();
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clicking on the compose button: " + e.getMessage());

        }
        

        
    } 

    public void enterToField(String toFieldText) throws Exception {
        try {

            // Wait for the element to be visible and clickable
            WebElement toFieldElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='To recipients']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toFieldElement);
            // Use JavaScript to click on the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", toFieldElement);
            // Send keys to the element
            toFieldElement.sendKeys(toFieldText);
        } catch(Exception e) {
            System.out.println("Exception occurred while entering To Field: " + e.getMessage());
        }
    }
    public void enterSubject(String subjectText) throws Exception

    {
        try {
        	driver.findElement(subjectField).sendKeys(subjectText);
        }    
        catch(Exception e) {
            System.out.println("Exception occurred while Entering the text on Subject field: " + e.getMessage());
        }      

    }
    public void enterEmailMessageBody(String messageBody) throws Exception

    {
        try {
        	//wait.until(ExpectedConditions.visibilityOfElementLocated(bodyField)).isDisplayed();
        	driver.findElement(bodyField).sendKeys(messageBody);
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while Entering the text on message body field: " + e.getMessage());

        }
        

    }
    public void clickOnSend() throws Exception

    {
        try {
        	driver.findElement(sendButton).click();
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clciking on Send Button: " + e.getMessage());

        }
        

    }
    
    public void clickOnDeleteBox() throws Exception

    {
        try {
        	driver.findElement(deleteBox).click();
        }
        
        catch(Exception e) {
            System.out.println("Exception occurred while clciking on Send Button: " + e.getMessage());

        }
        

    }
    
    public boolean verifyURLAfterLogin(String expectedURL) {
        // Wait for the page to load completely
       try { wait.until(ExpectedConditions.urlContains(expectedURL));
        
        // Get the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL is " + currentUrl);
        
        // Assertion to verify if the current URL contains the expected URL
        boolean urlContainsExpected = currentUrl.contains(expectedURL);
        Assert.isTrue(urlContainsExpected, "Current URL does not contain expected URL: " + expectedURL);
        
        return urlContainsExpected;}
       catch (Exception e) {
           System.out.println("Exception occurred while verifying URL after login: " + e.getMessage());
           return false; 
       }
    }

    public void verifyComposeButtonIsclickable() throws Exception {
       try {
    	wait.until(ExpectedConditions.elementToBeClickable(composeButton));
       }
       catch(Exception e) {
    	   System.out.println(e.getMessage());
       }
        
    }

	public void verifyPopUpMessageAfterSend()throws Exception {
		try {
			 boolean isPopupDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(sentMessagePopUp)).isDisplayed();
		     Assert.isTrue(isPopupDisplayed, "Popup message is not displayed");
		    } 
		catch (Exception e) {
	        System.out.println("Exception occurred while verifying popup message: " + e.getMessage());
	    }	
	}

	public void userClickOnLogOut() throws Exception {
	
	try {
		
    	wait.until(ExpectedConditions.elementToBeClickable(userIcon));
		driver.findElement(userIcon).click();
    	wait.until(ExpectedConditions.elementToBeClickable(logOut));

		driver.findElement(logOut).click();}
	catch (Exception e){
        System.out.println("Exception occurred while user logout from the application: " + e.getMessage());

		}
	}
		
	

	public void clickOnDiscard() throws Exception{
		 {
		        try {
		        	driver.findElement(discardButton).click();
		        }
		        
		        catch(Exception e) {
		            System.out.println("Exception occurred while clicking on Discard Button: " + e.getMessage());

		        }
		
		 }
	}
	public void clickOnDraft() throws Exception {
		 {
		        try {
		        	driver.findElement(draftButton).click();
		        }
		        
		        catch(Exception e) {
		            System.out.println("Exception occurred while clicking on Draft Option: " + e.getMessage());

		        }
		
		 }
	}
	
	public void verifySubjectofDraftMessage(String subjectText) throws Exception{
		 {
		        try {
		        	
					 boolean isSubjectofDraftMessageDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()= '" + subjectText + "'])[10]"))).isDisplayed();
					 Assert.isTrue(isSubjectofDraftMessageDisplayed, "Subject of draft message is not displayed.");

                     
		        }
		        
		        catch(Exception e) {
		            System.out.println("Exception occurred while clicking on Draft Option: " + e.getMessage());

		        }
		
		 }
	}

	public void verifyErrorMessage() throws Exception {
		  try {
	        	
				 boolean isErrorMessageDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Error']"))).isDisplayed();
				 Assert.isTrue(isErrorMessageDisplayed, "Error message is not displayed.");

              
	        }
	        
	        catch(Exception e) {
	            System.out.println("Exception occurred while clicking on Draft Option: " + e.getMessage());

	        }
		
	}

}




	
	

