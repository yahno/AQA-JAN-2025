TODO: Homework * : Create table Products : ProductId, ProductName, ProductPrice
#TODO:- using selenium go to https://www.amazon.com/ search for redmi
#TODO:- get product name
#TODO:- get product price
#TODO:- store product name and phone product to DB
#TODO:- print that product to console

Scenario: Create table Products
Given I using selenium go to amazon.com and search for a redmi
Given I request ProductName and ProductPrice price
When I store ProductName and ProductPrice to DB
Then I print that ProductName and ProductPrice to console