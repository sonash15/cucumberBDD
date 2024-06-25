
Feature: Login data driven with excel

	@sanity
	Scenario Outline: Login Data Driven 
		Given the user navigate to login page
		Then user should redirect to my account page by passing email and password with excel row "<row_index>"
		
		 Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
      |         4 |
      |         5 |