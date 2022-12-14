Feature: Product
  You need to provide model linked with Family.
  Like: <Mac>  <Macbook Pro> <14">  [<Good>?<Better>]

  @Smoke @Product
  Scenario Outline: Visitor should be able to add the product to the bag using navbar
    Given Navigate to Apple's site
    And Click navbar item "<Family>"
    And Verify family page opened
    When Click product: "<Product>" button
    And Verify product page opened
    And Buy given: '<Model>' product model
    And Select given: "<Configuration>" product configuration
    And Add product to bag
    Then Verify product added to bag

  Examples:
    | Family | Product     | Model | Configuration |
    | Mac    | Mac Mini    | All   | Better        |
    | Mac    | IMac 24     | 24"   | Better        |
    | Mac    | Macbook Air | M2    | Best          |
    | Mac    | Macbook Pro | 16"   | Ultimate      |
    | Mac    | Macbook Pro | 13"   | Good          |
