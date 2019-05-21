@first
Feature: User able to login
Scenario Outline: User should be able to login with Valid Credentials
Given User should be in the Landing screen
When Tap icon
Then Tap sign in button
And Enter "<username>","<password>" credentials
And Tap Signin

Examples:
        |username|password|
        |sivaranjanidx@gmail.com|ranjani91|