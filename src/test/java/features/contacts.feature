Feature: CRM Contact Feature

	Scenario: Free CRM Contact Test Scenario
    
    Given user is already on Contacts Page
    |	sagar.parikh198@gmail.com | Test@123 |
    
    And user verify contacts Label present
    Then user checks on contact "ui ui" and "test2 test2"
    Then user create new contacts and validate them
    |	FName	|	LName		|	Status		|
    |	Tom		|	Peter		|	New				|
    |	David	|	Cris		|	Active		|
    |	Mukta	| Sharma	| Inactive	|
    
    Then user close browser
    