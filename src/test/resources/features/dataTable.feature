Feature: Examples of Cucumber date table implementations


  Scenario: Something happens
    #Given user does something
    Then user should see below words displayed
      | Apple      |
      | Kiwi       |
      | Orange     |
      | Strawberry |
      | Mango      |
      | Tomato     |
      | Cucumber   |

  @wip
  Scenario: Library login examole using data table
    Given user is on the login page of library app
    When user enters username and password as below
      | username | librarian13@library |
      | password | 9rf6axdD            |
    Then  user should see title is something

