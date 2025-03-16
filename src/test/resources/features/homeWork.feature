#TODO: Homework * : Create table Phones : PhoneId, PhoneName, PhonePrice
#TODO:- using selenium go to allo.ua, search for a phone
#TODO:- get phone name
#TODO:- get phone price
#TODO:- store phone name and phone price to DB
#TODO:- print that phone to console

Scenario: Create table Phones
Given I using selenium go to alloua and search for a phone
//Given I get PhoneName and PhonePrice price
When I store PhoneName and PhonePrice to DB
Then I print that PhoneName and PhonePrice to console