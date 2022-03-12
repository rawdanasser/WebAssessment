Feature: feature to test google search functionality

  Scenario: Validate google search is working
    Given user can open google search page
    When user enters a text in seach box and hits enter
    Then user is navigated to search results,gets how many search result diplayed
    And navigate to them to confirm the title