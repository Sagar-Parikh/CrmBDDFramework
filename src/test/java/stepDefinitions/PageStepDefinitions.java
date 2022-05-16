package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PageStepDefinitions extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	NewContactPage newContactsPage;

	public PageStepDefinitions() {
		super();
	}

	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() {

		initialization();
		loginPage = new LoginPage();
	}

	@When("^title of Login Page is \"([^\"]*)\"$")
	public void title_of_Login_Page_is(String expectedLoginPageTitle) {

		String actualLoginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(expectedLoginPageTitle, actualLoginPageTitle);
	}

	@When("^CRM Page logo is present$")
	public void crm_Page_logo_is_present() {

		boolean flag = loginPage.validateCrmLogoImage();
		Assert.assertTrue(flag);
	}

	@Then("^user click on Login link, enters \"([^\"]*)\" and \"([^\"]*)\" and user clicks on Login Button$")
	public void user_click_on_Login_link_enters_and_and_user_clicks_on_Login_Button(String email, String password) {
		homePage = loginPage.login(email, password);
	}

	@Then("^user is on Home Page with title \"([^\"]*)\"$")
	public void user_is_on_Home_Page_with_title(String expectedHomePageTitle) {
		String actualHomePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("HomePage title not matched", expectedHomePageTitle, actualHomePageTitle);
	}

	@Then("^user verify username on Home Page$")
	public void user_verify_username_on_Home_Page() {
		Assert.assertTrue("UserNamenot displayed", homePage.verifyCorrectUserName());
	}

	@Given("^user is already on Contacts Page$")
	public void user_is_already_on_Contacts_Page(DataTable credentials) {
		initialization();
		loginPage = new LoginPage();
		List<List<String>> data = credentials.raw();
		homePage = loginPage.login(data.get(0).get(0), data.get(0).get(1));
		contactsPage = homePage.clickOnContactsLink();
	}

	@Given("^user verify contacts Label present$")
	public void user_verify_contacts_Label_present() {
		Assert.assertTrue("Contacts Label missing on page", contactsPage.verifyContactLabel());
	}

	@Then("^user checks on contact \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_checks_on_contact_and(String contact1, String contact2) {
		Assert.assertTrue(contactsPage.selectContact(contact1));
		Assert.assertTrue(contactsPage.selectContact(contact2));
	}

	@Then("^user create new contacts and validate them$")
	public void user_create_new_contacts_and_validate_them(DataTable contactsDetails) {
		

		for(Map<String, String> data :contactsDetails.asMaps(String.class, String.class)) {
			homePage.clickOnNewContactLink();
			newContactsPage = contactsPage.createNewContact(data.get("FName"),data.get("LName"),data.get("Status"));
			newContactsPage.clickOnHomePageLink();
			homePage.clickOnContactsLink();
			Assert.assertTrue("Created Contact not found", contactsPage.verifyContactCreated(data.get("FName")));
		}
		
	}

	@Then("^user close browser$")
	public void user_close_browser() {

		end();
	}
}
