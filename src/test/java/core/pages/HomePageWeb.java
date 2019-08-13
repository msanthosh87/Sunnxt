package core.pages;

import java.util.List;
import java.util.Map;
import agent.IAgent;
import central.Configuration;
import control.IControl;

public class HomePageWeb extends FullPage {

	public HomePageWeb(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	public void verifyName() throws Exception {
		getControl("title").waitUntilVisible();
		getControl("overview").click();
		softAssert.assertEquals(getControl("title", "isVisible"), true, "unable to find the element");
		softAssert.assertAll();
	}

	public void verifyListOptionUserName() throws Exception {
		getControl("qaConsumerOwnerDropDwn").waitUntilClickable();
		getControl("overview").click();
		getControl("qaConsumerOwnerDropDwn").click();
		softAssert.assertEquals(getControl("overview-menu", "isVisible"), true, "unable to find the element");
		softAssert.assertEquals(getControl("production-menu", "isVisible"), true, "unable to find the element");
		softAssert.assertEquals(getControl("reports-menu", "isVisible"), true, "unable to find the element");
		softAssert.assertEquals(getControl("signOut", "isVisible"), true, "unable to find the element");
		softAssert.assertAll();
	}

	public void productionReportEmail() throws Exception {
		getControl("report").waitUntilClickable();
		getControl("report").click();
		getControl("runReportButton").waitUntilClickable();
		getControl("runReportButton").click();
		getControl("emailButton").waitUntilClickable();
		getControl("emailButton").click();
		getControl("emailFormSubmit").click();
		getControl("reportMsg").waitUntilVisible();
		softAssert.assertEquals(getControl("reportMsg", "isVisible"), true, "unable to find the element");
		softAssert.assertAll();
	}

	public void verifyTypesOfView() throws Exception {
		getControl("production").waitUntilClickable();
		getControl("production").click();
		softAssert.assertEquals(getControl("gridGraph", "isVisible"), true, "unable to find the element");
		getControl("barTable").click();
		getControl("barGraph").waitUntilVisible();
		softAssert.assertEquals(getControl("barGraph", "isVisible"), true, "unable to find the element");
		softAssert.assertAll();
	}

	public void verifyTheNumberOfArrays() throws Exception {
		getControl("navBar").waitUntilClickable();
		getControl("overview").click();
		getControl("navBar").click();
		getControl("overViweLink").waitUntilClickable();
		getControl("overViweLink").click();
		getControl("array").waitUntilVisible();
		softAssert.assertEquals(getControl("array", "isVisible"), true, "Array image is not present");
		softAssert.assertAll();
	}

	public void webElementsLoad() throws Exception {

		List<IControl> ele = getControls("images");
		try {
			for (IControl ite : ele) {
				ite.waitUntilVisible();
			}
		} catch (Exception e) {
			logger.info(" ");
		}
	}

	public void pageLoad() throws Exception {
		webElementsLoad();
		getControl("refreshButton").waitUntilClickable();
		getControl("refreshButton").click();
	}

}
