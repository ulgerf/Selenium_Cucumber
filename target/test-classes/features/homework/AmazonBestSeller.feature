Feature: Best seller
  @amazonBestProduct

  Scenario: user find a best product.
  Given user goes amazon page
  And  user write in seach in a box "car phone holder"
  And user choose a "Automation"
  And user see the all result.
  And user want to find best product
  Then user write best product on search box
