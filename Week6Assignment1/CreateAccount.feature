Feature: Account creation feature in Salesfore

Scenario: create account in salesforce

Given Login to Salesforce
And Click on toggle menu button
And Click view All
And click Sales from App Launcher
And Click on Accounts tab
And Click on New button
And Enter 'Kamalesh' as account name
And Select Ownership as Public
When Click on save
 
Then verify Account name
