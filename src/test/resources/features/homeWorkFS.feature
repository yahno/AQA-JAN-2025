#TODO: Homework * : Create table Goods : GoodId, Title, Price, Category
#TODO:- using restapi go to https://fakestoreapi.com/, search for a product
#TODO:- get good title
#TODO:- get phone price
#TODO:- store good title, price and good category to DB
#TODO:- print that phone to console

Scenario: Create table Goods
Given I using restapi go to fakestore to request goods
When I store good title, price and good category to DB
Then I print that good title, price and specific category to console
