#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Account Registration
  I want to use this template for my feature file

  @sanity 
  Scenario: Successful Registration
    Given User navigate to Register Account page
    When  the user enters the details into below fields
     | firstName  |      john    | 
     | lastName   |     kenedy   | 
     | telephone  |     45879631 | 
     | password   |     test@123 | 
    And the user select privacy policy
    And click on continue button 
    Then User Account Should Create successfully
   

 