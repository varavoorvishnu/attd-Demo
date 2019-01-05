Feature: Add animals to the database

 Scenario Outline: <animals> name should not be contain special characters
    Given Add set of animal <animals> to the database
    When an animal <animals> name is suplied to animals rest endpoint
    Then the animals <animals> should be stored in the database
Examples:
      | animals |
      | cow     |
      | tiger   |
