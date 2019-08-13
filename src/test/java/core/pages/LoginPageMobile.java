package core.pages;

import java.util.Map;
import agent.IAgent;
import central.Configuration;

public class LoginPageMobile extends FullPage {

	public LoginPageMobile(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	/**
	 * The method navigate to the QA Environment
	 * 
	 * @throws Exception
	 *
	 */
	public void switchingToQAEnvir() throws Exception {
		getControl("emailTxtBox").waitUntilClickable();
		getControl("emailTxtBox").click();
		getControl("passwordTxtBox").waitUntilClickable();
		getControl("passwordTxtBox").click();
		getControl("passwordTxtBox").enterText(getTestData().get("pass"));
		getControl("loginBtn").waitUntilClickable();
		getControl("loginBtn").click();
	}

	/**
	 * The method verifies the QA Environment
	 *
	 */
	public void verifyQAEnvironment() throws Exception {
		switchingToQAEnvir();
		waitForElementToBeLoaded(10);
		getControl("passwordTxtBox").waitUntilClickable();
		softAssert.assertEquals(getControl("passwordTxtBox").getText().isEmpty(), true,
				"Not able to switch to QA Environment");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the error message while login to the app
	 *
	 */
	public void loginError() throws Exception {

		String expectedErrorMsg = getTestData().get("errorMsg");
		switchingToQAEnvir();
		waitForElementToBeLoaded(10);
		getControl("emailTxtBox").waitUntilClickable();
		getControl("emailTxtBox").click();
		getControl("emailTxtBox").enterText(getTestData().get("username"));
		getControl("passwordTxtBox").waitUntilClickable();
		getControl("passwordTxtBox").click();
		getControl("passwordTxtBox").enterText(getTestData().get("password"));
		getControl("loginBtn").waitUntilClickable();
		getControl("loginBtn").click();
		getControl("errorMessage").waitUntilVisible();
		softAssert.assertEquals(expectedErrorMsg.contains(getControl("errorMessage").getText()), true,
				"Failed login error message not verified");
		softAssert.assertAll();
	}

	public void validLoginData() throws Exception {
		waitForElementToBeLoaded(10);
		getControl("emailTxtBox").waitUntilClickable();
		getControl("emailTxtBox").enterText(getTestData().get("username"));
		getControl("passwordTxtBox").waitUntilClickable();
		getControl("passwordTxtBox").enterText(getTestData().get("password"));
		getControl("loginBtn").waitUntilClickable();
		getControl("loginBtn").click();
	}

	/**
	 * This method verifies the successful login to the app and navigation to the
	 * Status screen
	 *
	 */
	public void loginSuccess() throws Exception {
		switchingToQAEnvir();
		validLoginData();
		navigationThroughTutorialScreen();
		getControl("statusTxt").waitUntilVisible();
		softAssert.assertEquals(getControl("statusTxt", "isVisible"), true, "Couldn't navigate to the Status Page");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the tutorial screen navigation
	 *
	 */
	public void navigationThroughTutorialScreen() throws Exception {
		getControl("monitorTxt").waitUntilVisible();
		softAssert.assertEquals(getControl("monitorTxt", "isVisible"), true,
				"Error occured while navigating to the first tutorial screen");
		getControl("firstNextBtnTutoPage").waitUntilClickable();
		getControl("firstNextBtnTutoPage").click();
		getControl("trackTxt").waitUntilVisible();
		softAssert.assertEquals(getControl("trackTxt", "isVisible"), true,
				"Error occured while navigating to the second tutorial screen");
		getControl("nextBtnTutoPage").waitUntilClickable();
		getControl("nextBtnTutoPage").click();
		getControl("reportTxt").waitUntilVisible();
		softAssert.assertEquals(getControl("reportTxt", "isVisible"), true,
				"Error occured while navigating to the third tutorial screen");
		getControl("nextBtnTutoPage").waitUntilClickable();
		getControl("nextBtnTutoPage").click();
		getControl("statusTxt").waitUntilVisible();
		softAssert.assertEquals(getControl("statusTxt", "isVisible"), true, "Couldn't navigate to the Status Page");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the tutorial screen
	 *
	 */
	public void verifyTutorial() throws Exception {
		switchingToQAEnvir();
		getControl("emailTxtBox").waitUntilClickable();
		getControl("emailTxtBox").enterText("ho_us@mailinator.com");
		getControl("passwordTxtBox").waitUntilClickable();
		getControl("passwordTxtBox").click();
		getControl("passwordTxtBox").enterText("Enphase1");
		getControl("loginBtn").waitUntilClickable();
		getControl("loginBtn").click();
		navigationThroughTutorialScreen();
	}
}
