Feature: Testcases of all New Car Search functionality
  
  In order to buy a new car
  As a user
  I want to able to see all the available new cars

  @tag
  Scenario: To verify new car results are displayed when a user submits valid details and click on shop new cars button
    Given a new user
    And user click on new car search navigation item
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    Then search results are displayed based on the user selection

  @tag
  Scenario: To verify user is navigated to home screen from new car search results when user click on the home link
    Given user is on the new car search results screen
    And user click on home link below search results
    Then home screen is displayed

  @tag
  Scenario: To verify user is car specification page is displayed when user click on the "skip for now" link
    Given user is on the new car search results screen
    When user click on a result displayed
    And click on skip for now link
    Then car price report is displayed

  @tag
  Scenario: To verify user can update the car model and pincode in the search new car results screen
    Given user is on the new car search results screen
    When user select another model
    And enters a valid us zip code
    And click on update button
    Then results are updated

  @tag
  Scenario: To verify invalid zip code error is displayed when user click on shop new car button without giving a valid zipcode
    Given a new user
    And user click on new car search button
    When user select a car model
    And enters a Invalid US zip code
    Then Invalid zip code error is displayed under the textbox

  @tag
  Scenario: To verify invalid zip code error is displayed when user click on update button in search car results screen without giving a valid zipcode
    Given user is on the new car search results screen
    When user select another model
    And enters a Invalid us zip code
    And click on update button
    Then Invalid zip code error is displayed under the textbox

  @tag
  Scenario Outline: To verify user can view the search results by choosing the preferred style
    Given a new user
    And user click on new car search button
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    And user selects the <style>
    Then <price> of the car is displayed

    Examples: 
      | style                       | price  |
      | Sedan                       | 26,895 |
      | with Premium Package        | 28,645 |
      | with Technology Package     | 30,545 |
      | with A-Spec/Premium Package | 30,645 |

  @tag
  Scenario: To verify build and price button
    Given user is on the new car search results screen
    When user selects style
    And click on next button
    And select the colour
    And click on next button
    And select the interior
    And click on next button
    And click on finish button
    And click on build and price button
    Then preffered style is displayed

  @tag
  Scenario: To verify change incentives button
    Given user is on the new car search results screen
    When user selects style
    And click on next button
    And select the colour
    And click on next button
    And select the interior
    And click on next button
    And click on finish button
    And click on change incentives button
    Then choose incentives page is displayed

  @tag
  Scenario: To verify view full specs button
    Given user is on the new car search results screen
    When user selects style
    And click on next button
    And select the colour
    And click on next button
    And select the interior
    And click on next button
    And click on finish button
    And click on view full specs button
    Then specs page is displayed

  ## Example: Visual acceptance criteria to a level of relevancy
  @tag
  Scenario: To verify user can select the car colour
    Given a new user
    And user click on new car search navigation item
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    And user selects the car colour
    Then selected colour car is displayed

  ## Example: WCAG Requirements
  @tag
  Scenario: To verify car model image in search results should have alt text
    Given a new user
    And user click on new car search navigation item
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    Then all the car model images should contain alt text

  @tag
  Scenario: To verify large text in search results is displayed with minimum 18pt
    Given a new user
    And user click on new car search navigation item
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    Then large text in the car results is displayed with minimum size 18pt

  @tag
  Scenario: To verify large bold text is displayed in search results with minimum 14pt
    Given a new user
    And user click on new car search navigation item
    When user select a car model from new car widget
    And enters a valid US zip code from new car widget
    And click on shop new car button
    Then bold text in the car results is displayed with minimum size 14pt
