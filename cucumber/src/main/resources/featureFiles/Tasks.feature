@Tasks
Feature: This feature is used to test tasks

@Registration 
Scenario:This scenario is used to register the customer
Given an user opens the browser and url
When the user click on signIn button
And enter the email address and click on create an account button
Then the personal information page has to be displayed


@CustInfo
Scenario:This scenario is used to enter the personal information of the customer
Given an user enters all the required information
And click on register button
Then the my account page has to be displayed

@addProduct
Scenario:This scenario is used to add a product to cart
Given an user logout and login again
When the user add a product to cart
And proceed to the checkout page and continue till payments
Then the payment page has to be displayed
