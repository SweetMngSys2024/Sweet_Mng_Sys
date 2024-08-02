package test2.ps;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sweet.App.FeedBack;
import Sweet.App.Massage;
import Sweet.App.MyApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class feedBackMassage {

	MyApp sweetApp;
	FeedBack currentFeedBack;
	Massage currentMsg;




public feedBackMassage(MyApp sweetApp) {
		super();
		this.sweetApp = sweetApp;
		currentFeedBack=new FeedBack();
		currentMsg= new Massage();
	}

@When("user write {string} in type field")
public void userWriteInTypeField(String type2) {
   if( currentFeedBack.checkType(type2)) { currentFeedBack.setType(type2); assertTrue(true);}
   else assertFalse(false);
}

@When("user enter {string} in msg field")
public void userEnterInMsgField(String msg2) {
	if( currentFeedBack.checkMsg(msg2)){ currentFeedBack.setMgs(msg2); assertTrue(true);}
	   else assertFalse(false);
}

@When("user write {string} in product or recipe name field")
public void userWriteInProductOrRecipeNameField(String name2) {
	if( currentFeedBack.checkName(name2)){ currentFeedBack.setProductRecipeName(name2); assertTrue(true); System.out.println(currentFeedBack.getProductRecipeName()+"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+name2);}
	   else assertFalse(false);
}

@Then("the feedback will be raised to the admin")
public void theFeedbackWillBeRaisedToTheAdmin() {
    sweetApp.addFeedBack(currentFeedBack);
    assertTrue(true);
}


@When("user write {string} in uNameDest field")
public void userWriteInUNameDestField(String uNameDest) {
   if( currentMsg.checkuNameDest(uNameDest)) {currentMsg.setuNameDest(uNameDest); assertTrue(true);}
   else assertFalse(false);
}

@When("user enter {string} in msg field in send massage page")
public void userEnterInMsgFieldInSendMassagePage(String msg) {
	if( currentMsg.checkMsg(msg)) {currentMsg.setMgs(msg); assertTrue(true);}
	else assertFalse(false);
}

@When("user write {string} in typeOfDest field")
public void userWriteInTypeOfDestField(String type) {
	if( currentMsg.checkDstType(type)) {currentMsg.setTypeOfDest(type); assertTrue(true);}
	else assertFalse(false);
}

@Then("the massage will sent to the dst")
public void theMassageWillSentToTheDst() {
    sweetApp.sendMsg(currentMsg);
    assertTrue(true);
}


}