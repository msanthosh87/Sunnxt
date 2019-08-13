package core.pages;

import java.util.Map;

import agent.IAgent;
import central.Configuration;

public class LoginPageWeb extends FullPage {

	public LoginPageWeb(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	public void login() throws Exception {
		getControl("emailTxtBox").enterText(testData.get("username"));
		getControl("passwordTxtBox").click();
		getControl("passwordTxtBox").enterText(testData.get("password"));
		getControl("submit").click();
		getControl("pageHeading").waitUntilVisible();
		getControl("overview").click();
	}

	public void verifyHeader() throws Exception {
		getControl("overview").click();
		String header = getControl("pageHeading").getText();
		System.out.println(header);
		header = header.replaceAll("\\s", "");
		softAssert.assertEquals(header.contains("MyEnlighten"), true, "");
		softAssert.assertAll();
	}
}
