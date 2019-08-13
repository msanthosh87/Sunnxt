package core.tests;

import org.testng.annotations.Test;

public class WebTest extends SupportTest {

	@Test(enabled = true, priority = 1)
	public void TC01_verifylogin() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying login in MyEnlighten"));
		loginWeb.login();
		loginWeb.verifyHeader();
		logger.debug(this.getTestEndInfoMessage("verifying login in MyEnlighten"));
	}

	@Test(enabled = true, priority = 2)

	public void TC_02_verifyPageLoad() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying refresh button"));
		loginWeb.login();
		homeWeb.pageLoad();
		logger.debug(this.getTestStartInfoMessage("verifying refresh button"));
	}

	@Test(enabled = true, priority = 3)
	public void TC03_verifyNameOfUser() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying name of the user"));
		loginWeb.login();
		homeWeb.verifyName();
		logger.debug(this.getTestEndInfoMessage("verifying name of the user"));
	}

	@Test(enabled = true, priority = 4)
	public void TC04_verifyListOfOptionsUnderUserNameDropdown() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying list of option "));
		loginWeb.login();
		homeWeb.verifyListOptionUserName();
		logger.debug(this.getTestEndInfoMessage("verifying list of option"));
	}

	@Test(enabled = true, priority = 5)
	public void TC05_verifyDailyProductionReportMail() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying  daily production report can be emailed "));
		loginWeb.login();
		homeWeb.productionReportEmail();
		logger.debug(this.getTestEndInfoMessage("verifying  daily production report can be emailed "));
	}

	@Test(enabled = true, priority = 7)
	public void TC07_verifyNumberOfArrays() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying the no of arrays "));
		loginWeb.login();
		homeWeb.verifyTheNumberOfArrays();
		logger.debug(this.getTestEndInfoMessage("verifying the no of arrays "));
	}

	@Test(enabled = true, priority = 8)
	public void TC08_verifyTypesOfGraphViews() throws Exception {
		logger.debug(this.getTestStartInfoMessage("verifying types graph of view "));
		loginWeb.login();
		homeWeb.verifyTypesOfView();
		logger.debug(this.getTestEndInfoMessage("verifying types graph of view "));
	}

}
