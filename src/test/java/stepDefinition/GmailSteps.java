package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import automationGmail.ApplicationFunctionLibrary;


public class GmailSteps {
	ApplicationFunctionLibrary applicationfunctionlibrary;

    public GmailSteps() throws Exception {
        applicationfunctionlibrary = new ApplicationFunctionLibrary();
    }

	
//	<----------------------------Given Condition --------------------->	
	@Given("Application is Launched")
	public void application_is_launched() throws Throwable {
		applicationfunctionlibrary.launchApplication("https://www.google.com/intl/en_in/gmail/about/");
		}
	
	@Given("^User is at Gmail Home Page and Click On Compose$")
	public void user_is_at_gmail_home_page_and_click_on_compose() throws Throwable 
	{	
		applicationfunctionlibrary.userIsAtGmailHomePageAndClickOnCompose();
	}

	
//	<----------------------------When Condition --------------------->
	@When("Existing User Authenticate")
	public void existing_user_authenticate() throws Throwable{
		//***enter the email id and password in place of example@gmail.com and examplepassword
		applicationfunctionlibrary.existinguserLoginIntoGmail("example@gmail.com", "examplepassword");
		

	}
	@When("^User Fill The Required Fields and Click On Discard$") 
	public void user_fill_the_required_fields_and_click_on_discard() throws Throwable 
	{
		applicationfunctionlibrary.userDiscardTheEmailAfterFillingToSubjectAndMessageBody("ts4090186@gmail.com", "Incubyte", "Automation QA test for Incubyte");
		
	}
	
	@When("^User Fill The Required Fields and Click On Send$") 
	public void user_fill_the_required_fields_and_click_on_send() throws Throwable 
	{
		applicationfunctionlibrary.userSendTheEmailAfterFillingToSubjectAndMessageBody("ts4090186@gmail.com", "Incubyte", "Automation QA test for Incubyte");
		
	}
	
	@When("^User Fill The Required Fields With Invalid Recipient Email and Click On Send$") 
	public void user_fill_the_required_fields_with_invalid_recipient_email_and_click_on_send() throws Throwable 
	{
		applicationfunctionlibrary.userSendTheEmailAfterFillingToSubjectMessageBodyAndInvalidRecipient("hhhhhh@hjh", "Incubyte", "Automation QA test for Incubyte");
		
	}
	
	@When("^User Log Out from Application$") 
	public void user_log_out_from_application() throws Throwable 
	{
		applicationfunctionlibrary.userLogOut();
		
	}

//	<----------------------------Then Condition --------------------->
	
	@Then("^Application Available For Use$")
	public void application_Available_For_Use() throws Throwable 
	{	
		applicationfunctionlibrary.verifyGmailHomePageAfterLogin("https://mail.google.com/mail/u/0/#inbox");

	}
	@Then("^Verify The Message Is Send$")
	public void verify_the_message_is_send() throws Throwable 
	{	
		applicationfunctionlibrary.verifyPopUpMessageAfterSend();
	}
	@Then("^Verify The Message Is Saved In Draft$")
	public void verify_the_message_is_saved_in_draft() throws Throwable 
	{	
		applicationfunctionlibrary.verifyMessageSavedInDraft("Incubyte");
	}
	
	@Then("^An Error Message Indicating To Field Not Recognized$")
	public void an_error_message_indicating_to_field_not_recognized() throws Throwable 
	{	
		applicationfunctionlibrary.verifyErrorMessageIndicatingToFieldNotRecognized();
	}

}
