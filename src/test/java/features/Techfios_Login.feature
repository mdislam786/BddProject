@Login @Regression
Feature: Validate techfios Login page Functionality 

Background: 
	Given User is on the techfios login page    	

@Scenario1	
Scenario: User should be able to login with valid credentials (Making Variables work as Placeholders) 
	When User enters the username as "demo@techfios.com"  
	When User enters the password as "abc123"  
	And  User clicks on login button
	Then User should be able to see the dashboard	
	
@Scenario2	
Scenario: User should be able to login with invalid credentials (Making Variables work as Placeholders) 
	When User enters the username as "demo2@techfios.com"  
	When User enters the password as "abc124"  
	And  User clicks on login button
	Then User should not be able to see the dashboard	   
	 
	

@Scenario3
Scenario Outline: User should be able to login with valid credentials (Making Variables work as Placeholders) 	  
	When User enters the "<username>" and "<password>"  
	And  User clicks on login button
	Then User should be able to see the dashboard
	Examples:	
	|username|password|
	|demo@techfios.com|abc123|
	|demo2@techfios.com|abc124|
	
	
	
	
