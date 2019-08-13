package core.tests;

import org.testng.annotations.Test;

public class MobileTest extends SupportTest {

	@Test(enabled = true, priority = 1)
	public void TC01_verifySwitchingToQA() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Switching to QA Environment"));
		loginMobile.verifyQAEnvironment();
		logger.debug(this.getTestEndInfoMessage("Switching to QA Environment"));
	}

	@Test(enabled = true, priority = 2)
	public void TC02_verifyLoginError() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Verifying Login Error message"));
		loginMobile.loginError();
		logger.debug(this.getTestEndInfoMessage("Verifying Login Error message"));
	}

	@Test(enabled = true, priority = 3)
	public void TC03_verifyingSuccessfulLogin() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Successfull Login"));
		loginMobile.loginSuccess();
		logger.debug(this.getTestEndInfoMessage("Successfull Login"));
	}

	@Test(enabled = true, priority = 4)
	public void TC04_verifyStatusScreenContents() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Status Screen contents"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.statusScreenContent();
		logger.debug(this.getTestEndInfoMessage("Status Screen contents"));
	}

	@Test(enabled = true, priority = 5)
	public void TC05_verifyingGraphInteractionInEnergy() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Graph Interaction Screen"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.energyInteractionScreen();
		logger.debug(this.getTestEndInfoMessage("Graph Interaction Screen"));
	}

	@Test(enabled = true, priority = 6)
	public void TC06_verifyingDifferntTimeFiltersInEnergyScreen() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Time Filter Screen Sections"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.timeFiltersUnderEnergyScreen();
		logger.debug(this.getTestEndInfoMessage("Time Filter Screen Sections"));
	}

	@Test(enabled = true, priority = 7)
	public void TC07_verifyingSolarEnergyProducedUI() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Solar energy produced UI"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.navigateToEnergyPage();
		homeMobile.arrayIconsDisplay();

		logger.debug(this.getTestEndInfoMessage("Solar energy produced UI"));
	}

	@Test(enabled = true, priority = 8)
	public void TC08_verifyingMenuPage() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Verifying Menu Page"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.navigateToMenuPage();

		logger.debug(this.getTestEndInfoMessage("Verifying Menu Page"));
	}

	@Test(enabled = true, priority = 9)
	public void TC09_verifySiteDetailsSection() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Verifying site details section"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.navigateToMenuPage();
		homeMobile.siteDetails();

		logger.debug(this.getTestEndInfoMessage("Verifying site details section"));
	}

	@Test(enabled = true, priority = 10)
	public void TC10_verifyingReportSending() throws Exception {
		logger.debug(this.getTestStartInfoMessage("Verifying Report sending Section"));
		loginMobile.switchingToQAEnvir();
		loginMobile.validLoginData();
		loginMobile.navigationThroughTutorialScreen();
		homeMobile.reportSendingSection();
		logger.debug(this.getTestEndInfoMessage("Verifying Report sending Section"));
	}
}
