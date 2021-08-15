Feature: Fill Contact Form in Secure Pay Website

  @smoke
  Scenario: Contact the secure pay

  Given Searches for SecurePay on google
  When Clicks through to the SecurePay website
  Then Navigates to the contact us page
  And  Verifies that the contact us page is loaded
  Then Uses the random generated data to fill in the contact us form
