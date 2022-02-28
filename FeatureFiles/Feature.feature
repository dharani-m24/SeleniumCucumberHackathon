Feature: Building cucumber framework 
@amazon
Scenario: verify user is able to select the Indian language Book 
	Given lauch the url 
	And click on signIn button and enter the credentials 
	Then click on books and select India language 
	
@hotel 
Scenario: verify user able to book the hotel 
	Given launch the hotel url 
	And Enter the credentials 
	Then enter the feilds to search hotel 
	Then enter the mandatory feilds to book the hotel 
	And fetch the order no 

@testing	
Scenario: User able to shop and place the order
	Given user have to launch browser 
	When user able to click the shop and home buttons 
	When user is able to add the product to the cart 
	Then user able to place the order 
	
@zoopla
Scenario: ZooPla 
	Given launch the browser url
	Then  Input location London and click Submit
	And  Print all the price values in sorted order 
	Then Select the fifthth property on that list
	And check same present in the agent page
