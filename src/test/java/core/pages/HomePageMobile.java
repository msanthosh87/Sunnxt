package core.pages;

import java.util.Map;

import agent.IAgent;
import central.Configuration;

/**
 * @author Kshitiz
 *
 */

public class HomePageMobile extends FullPage {

	public HomePageMobile(Configuration conf, IAgent agent, Map<String, String> testData) throws Exception {
		super(conf, agent, testData);
	}

	String startTime;
	String endTime;
	String defaultEnergyProducedToday;
	String defaultEnergyProducedYesterday;
	String energyProducedToday;
	String energyProducedYesterday;
	String statusPageData;

	/**
	 * This method navigates to Energy Screen from HomePage
	 *
	 */
	public void navigateToEnergyPage() throws Exception {
		getControl("energyBtnOnHomePage").waitUntilClickable();
		getControl("energyBtnOnHomePage").click();
	}

	/**
	 * This method navigates to Menu Page from HomePage
	 *
	 */
	public void navigateToMenuPage() throws Exception {
		getControl("menuBtnOnHomePage").waitUntilClickable();
		getControl("menuBtnOnHomePage").click();
	}

	/**
	 * This method captures the Energy Time from Energy Screen
	 *
	 */
	public void timeData() throws Exception {
		getControl("graphTime").waitUntilClickable();
		getControl("graphTime").click();
		getControl("startTimeCapture").waitUntilVisible();
		startTime = getControl("startTimeCapture").getText();
		getControl("endTimeCapture").waitUntilVisible();
		endTime = getControl("endTimeCapture").getText();
		logger.info("Time updated under Energy after user time selection is " + startTime + "-" + endTime);
	}

	/**
	 * This method gives the Energy data for the Day
	 *
	 */
	public void energyConsumptionData() throws Exception {
		getControl("energyProd").waitUntilVisible();
		defaultEnergyProducedToday = getControl("energyProd").getText();
		getControl("energyConsump").waitUntilVisible();
		defaultEnergyProducedYesterday = getControl("energyConsump").getText();
		logger.info("Default energy prod for today " + defaultEnergyProducedToday + " "
				+ " Default energy consumed yesterday " + defaultEnergyProducedYesterday);
		getControl("graphTime").waitUntilClickable();
		getControl("graphTime").click();
		getControl("energyProd").waitUntilVisible();
		energyProducedToday = getControl("energyProd").getText();
		getControl("energyConsump").waitUntilVisible();
		energyProducedYesterday = getControl("energyConsump").getText();
		logger.info("Energy prod for today after graph selection " + energyProducedToday + " "
				+ " Energy consumption for yesterday after graph selection " + energyProducedYesterday);
	}

	/**
	 * This method verifies the display of the tool tip on the graph on the energy
	 * screen
	 *
	 */
	public boolean toolTipVerification() throws Exception {
		getControl("toolTip").waitUntilVisible();
		return getControl("toolTip").isVisible();
	}

	/**
	 * This method verifies different interactions on the energy screen
	 *
	 */
	public void energyInteractionScreen() throws Exception {
		navigateToEnergyPage();
		energyConsumptionData();
		timeData();
		softAssert.assertEquals(toolTipVerification(), true, " Tool tip section doesn't displayed");
		softAssert.assertAll();
		logger.info("The UI section is passed for Energy Interaction page");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the day filter on energy screen
	 *
	 */
	public void dayFilterVerification() throws Exception {

		softAssert.assertEquals(getControl("energyProd", "isVisible"), true, "The Energy production is not available");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the week, month, year and lifetime filter on energy
	 * screen
	 *
	 */
	public void filterVerification(String filter) throws Exception {
		getControl(filter).waitUntilVisible();
		getControl(filter).click();
		softAssert.assertEquals(getControl("energyProd", "isVisible"), true, "The Energy production is not present");
		softAssert.assertAll();
	}

	/**
	 * This method verifies different time filters on energy screen
	 *
	 */
	public void timeFiltersUnderEnergyScreen() throws Exception {
		String timeFilterForWeek = "weekTab";
		String timeFilterForMonth = "monthTab";
		String timeFilterForYear = "yearTab";
		String timeFilterForLifetime = "lifetimeTab";
		navigateToEnergyPage();
		dayFilterVerification();
		filterVerification(timeFilterForWeek);
		filterVerification(timeFilterForMonth);
		filterVerification(timeFilterForYear);
		filterVerification(timeFilterForLifetime);
		logger.info("The UI section is passed for Energy Interaction page");
	}

	/**
	 * This method verifies different contents of status screen
	 *
	 */
	public void statusScreenContent() throws Exception {
		getControl("statusScreenCont").waitUntilVisible();
		statusPageData = getControl("statusScreenCont").getText();
		int occurancePlace = statusPageData.indexOf("Produced");
		String reqData = statusPageData.substring(occurancePlace);
		logger.info(reqData);
	}

	/**
	 * This method verifies the array icons in energy screen page
	 *
	 */
	public void arrayIconsDisplay() throws Exception {
		softAssert.assertEquals(getControl("blueArrayIcon", "isVisible"), true,
				"Solar energy produced blue icon doesn't appear");
		softAssert.assertEquals(getControl("greyArrayIcon", "isVisible"), true,
				"Solar energy produced grey icon doesn't appear");
		softAssert.assertAll();
	}

	/**
	 * This method verifies different contents of Menu Page
	 *
	 */
	public void menuSections() throws Exception {
		softAssert.assertEquals(getControl("reportBtnMenuPage", "isVisible"), true,
				"Report section in Menu Page doesn't appear");
		softAssert.assertEquals(getControl("siteDetailsBtnMenuPage", "isVisible"), true,
				"Site details Section doesn't appear");
		softAssert.assertEquals(getControl("devicesBtnMenuPage", "isVisible"), true, "Devices Section doesn't appear");
		softAssert.assertEquals(getControl("supportsBtnMenuPage", "isVisible"), true, "Support Section doesn't appear");
		softAssert.assertEquals(getControl("settingsBtnMenuPage", "isVisible"), true,
				"Settings Section doesn't appear");
		softAssert.assertEquals(getControl("logoutBtnMenuPage", "isVisible"), true, "Logout Section doesn't appear");
		softAssert.assertEquals(getControl("enphaseLogoMenuPage", "isVisible"), true, "Enphase Logo doesn't appear");
		softAssert.assertAll();
	}

	/**
	 * This method verifies different sections of site details page
	 *
	 */
	public void siteDetails() throws Exception {
		getControl("siteDetailsBtnMenuPage").waitUntilClickable();
		getControl("siteDetailsBtnMenuPage").click();
		softAssert.assertEquals(getControl("siteDetailsTitle", "isVisible"), true, "Site details title doesn't appear");
		softAssert.assertEquals(getControl("siteIDInSiteDetails", "isVisible"), true, "Site ID details doesn't appear");
		softAssert.assertEquals(getControl("emailIDInSiteDetails", "isVisible"), true,
				"Email ID details doesn't appear");
		softAssert.assertAll();
	}

	/**
	 * This method verifies the report sending feature under Menu page, report
	 * section
	 *
	 */
	public void reportSendingSection() throws Exception {
		navigateToMenuPage();
		getControl("reportBtnMenuPage").waitUntilClickable();
		getControl("reportBtnMenuPage").click();
		getControl("emailReportBtn").waitUntilClickable();
		getControl("emailReportBtn").click();
		softAssert.assertEquals(getControl("reportSentMsg", "isVisible"), true,
				"Report sent to the mail, message doesn't appear");
		softAssert.assertAll();
	}

}
