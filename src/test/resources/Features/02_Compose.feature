#compose function in Gmail
Feature: Compose function in Gmail.

  Scenario: User Sends an Email with the subject "Incubyte" and body "Automation QA test for Incubyte".
    Given User is at Gmail Home Page and Click On Compose
    When User Fill The Required Fields and Click On Send
    Then Verify The Message Is Send

  Scenario: Compose Email with the subject "Incubyte" and body "Automation QA test for Incubyte" and Click Discard
    Given User is at Gmail Home Page and Click On Compose
    When User Fill The Required Fields and Click On Discard
    Then Verify The Message Is Saved In Draft

  Scenario: Compose Email with the subject "Incubyte" and body "Automation QA test for Incubyte" with Invalid Recipient Email
    Given User is at Gmail Home Page and Click On Compose
    When User Fill The Required Fields With Invalid Recipient Email and Click On Send
    Then An Error Message Indicating To Field Not Recognized
