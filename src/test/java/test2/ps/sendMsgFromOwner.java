package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.Massage;
import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sendMsgFromOwner {

	MyApp sweetApp;
	Massage currentMsg;

	
	

public sendMsgFromOwner(MyApp sweetApp) {
		super();
		this.sweetApp = sweetApp;
		currentMsg= new Massage();
	}


	@When("user write {string} in the uNameDest field")
	public void userWriteInTheUNameDestField(String uNameDest) {
		 if( sweetApp.checkuNameDest(uNameDest)) {currentMsg.setuNameDest(uNameDest); assertTrue(true);}
		   else assertFalse(false);
	}

	@When("user enter {string} in the msg field in send massage page")
	public void userEnterInTheMsgFieldInSendMassagePage(String msg) {
		if( currentMsg.checkMsg(msg)) {
			currentMsg.setMgs(msg); assertTrue(true);}
		else assertFalse(false);
	}

	@When("user write {string} in the typeOfDest field")
	public void userWriteInTheTypeOfDestField(String type) {
		if( currentMsg.checkDstType(type)) {currentMsg.setTypeOfDest(type); assertTrue(true);}
		else assertFalse(false);
	}

	@Then("the massage will sent to the destenation")
	public void theMassageWillSentToTheDestenation() {
	   sweetApp.addMassage(currentMsg);
	    assertTrue(true);	    
	}




}
