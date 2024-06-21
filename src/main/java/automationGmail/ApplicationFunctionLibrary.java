package automationGmail;


public class ApplicationFunctionLibrary {
	 private ApplicationSteps applicationsteps;

	    public ApplicationFunctionLibrary() {
	        applicationsteps = new ApplicationSteps();
	    }


    public void launchApplication(String strURL) throws Exception {
		 //applicationsteps.setBrowser();
		 applicationsteps.launchApplication(strURL);
	       
	    }
	 public void existinguserLoginIntoGmail(String username, String password) throws Exception {
		 applicationsteps.clickOnSignInButton();
		 applicationsteps.enterUsername(username);
		 applicationsteps.clickNext();
		 applicationsteps.enterPassword(password);
		 applicationsteps.clickNext();
		 
	       
	 }
	 public void verifyGmailHomePageAfterLogin(String expectedURL) throws Exception{
		 applicationsteps.verifyURLAfterLogin(expectedURL);
	 }
	 public void userIsAtGmailHomePageAndClickOnCompose() throws Exception{
		 applicationsteps.verifyComposeButtonIsclickable();
		 applicationsteps.clickOnComposeButton();
		 
	 } 
	 public void userSendTheEmailAfterFillingToSubjectAndMessageBody(String toField, String subjectField, String MessageBody) throws Exception{
		 applicationsteps.enterToField(toField);
		 applicationsteps.enterSubject(subjectField);
		 applicationsteps.enterEmailMessageBody(MessageBody);
		 applicationsteps.clickOnSend();
	 }
	 
	 public void userDiscardTheEmailAfterFillingToSubjectAndMessageBody(String toField, String subjectField, String MessageBody) throws Exception {
		 applicationsteps.enterToField(toField);
		 applicationsteps.enterSubject(subjectField);
		 applicationsteps.enterEmailMessageBody(MessageBody);
		 applicationsteps.clickOnDiscard();
			
		}
	 
	 public void userSendTheEmailAfterFillingToSubjectMessageBodyAndInvalidRecipient(String toField, String subjectField, String MessageBody) throws Exception {
		 applicationsteps.enterToField(toField);
		 applicationsteps.enterSubject(subjectField);
		 applicationsteps.enterEmailMessageBody(MessageBody);
		 applicationsteps.clickOnSend();
			
		}
	public void verifyPopUpMessageAfterSend() throws Exception {
		applicationsteps.verifyPopUpMessageAfterSend();
		
	}


	public void userLogOut() throws Exception {
		applicationsteps.userClickOnLogOut();
		
	}


	public void verifyMessageSavedInDraft(String subjectText ) throws Exception {
		applicationsteps.clickOnDraft();
		applicationsteps.verifySubjectofDraftMessage(subjectText);
		
	}


	public void verifyErrorMessageIndicatingToFieldNotRecognized() throws Exception {
	   applicationsteps.verifyErrorMessage();
	   applicationsteps.clickOnOkButton();
	   applicationsteps.clickOnDiscard();
		
	}


	



}






