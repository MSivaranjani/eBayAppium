@first
Feature: To Check the categories present in the landing screen

Scenario Outline: Entering the product in the search bar
Given User should be on the login screen
When Tap on the search icon
Then Enter the "<Search Items>" in the search bar
And Select first value from the search list

Examples:
|Search Items|
|65 inch Tv|

Scenario: Select the Brand
When User check the message over wishlist
Then Checks Shop by brand is displayed
And Selects LG Brand

Scenario: Swipe up and down and select the product
When Swipe  down till the end of the screen
|Related Searches|

Then Swipe up  to find the product
|LG 49UK6090 49 inch 4K UHD LED Smart TV|

And  Storing the  text value of price and name of the product


