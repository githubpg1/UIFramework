Feature: Search Bar

  Scenario: Search Box
    Given User navigates to the homepage
    Given User opens page "HomePage"
    And User clicks on element "Discard"
    When User enters "Iphone" in the text field in Element "SearchBar"
    And User presses "Enter" on Keyboard for Element "SearchBar"
    Given User opens page "SearchResults"
    Then Search results "Iphone" are displayed

#Scenario: Search Results

#Scenario: Search Functionality

#Scenario: Search Term