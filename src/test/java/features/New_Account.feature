@NewAccount @Regression
Feature: Techfios bank and cash New Account Functionality

Background:
	Given User is on the techfios login page
	
 @Open_Account
Scenario Outline: User should be able to login with valid credentials
 and open a new account	
	When User enters the "<username>" and "<password>"  
	And  User clicks on login button
	Then User should be able to see the dashboard
	Then User clicks on bank and cash 
	Then User clicks on new account 
	Then User fill up the form entering "<accountTitle>"and "<description>"and "<initialBalance>"and "<accountNumber>"and "<contactPerson>"and "<phone>"and "<internetBankingUrl>" and clicks on submit 
	Then User should be able to see validate
			
Examples: 
|username| password | accountTitle | description | initialBalance | accountNumber |contactPerson | phone | internetBankingUrl | 
| demo@techfios.com | abc123 |Savings Account|New Account | 10000 | 123456789000 |Miss Lee|347123000456 |https://www.bankofamerica.com|  