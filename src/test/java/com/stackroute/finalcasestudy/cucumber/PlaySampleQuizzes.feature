Feature: Play sample quizzes

  Scenario: Play the second sample quiz 
    Given the user in quiz home page
    When clicking on second sample quiz
    And selecting the second quiz answers
    Then second quiz results should be displayed
    When clicking on try again
    Then quiz home page should be displayed
    
  Scenario: Play the third sample quiz
    Given the user already in quiz home page
    When clicking on third sample quiz
    And selecting the third quiz answers
    Then third quiz results should be displayed
    When clicking on try again
    Then quiz home page should be displayed
