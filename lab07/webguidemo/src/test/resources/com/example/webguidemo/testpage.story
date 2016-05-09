Scenario: Test Practiceform page

Given user is on Home page

When user click Setup Visual Studio link
Then Setup Visual Studio page is shown

When user click Find Element Strategies link
Then create PrSc 

When user click Submit
Then msg validation show This field is required.

When user types 1234 in field
Then msg validation show Please enter no more than 2 characters.

When user types a in field
Then msg validation show Please enter only digits.

When user types 12 in field
Then user pass a validation

When user click alert button
Then alert is shown

When user click on checkBox
Then checkBox is selected

When user click on change color button
Then color is rgba(255, 165, 0, 1)
