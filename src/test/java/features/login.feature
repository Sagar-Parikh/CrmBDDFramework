Feature: CRM Login Feature

	Scenario Outline: Free CRM Login Test Scenario
    
    Given user is already on Login Page
    When title of Login Page is "Free CRM software for customer relationship management, sales, marketing campaigns and support."
    And CRM Page logo is present
    Then user click on Login link, enters "<emailId>" and "<password>" and user clicks on Login Button
    Then user is on Home Page with title "Cogmento CRM"
    And user verify username on Home Page
    Then user close browser
    
    Examples:
    | emailId                   | password |
    | sagar.parikh198@gmail.com | Test@123 | 