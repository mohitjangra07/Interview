@apiTest
Feature: Pet Store
  This feature is to validate Pet store API

  @get
  Scenario Outline: Validate the GET method for Pet Store
    Given I perform GET operation for "/pet/findByStatus" with parameters
      | param  | Value     |
      | status | available |
    Then I am able to see mandatory fields 'name' and 'photoUrls' are present with status as "<status>" in response

    Examples:
      | status    |
      | available |

  @post
  Scenario Outline: Verify POST operation by adding a pet profile
    Given I Perform POST operation for "/pet" with body
      | name   | photoUrls   | id   | status   |
      | <name> | <photoUrls> | <id> | <status> |
    Then I validate new pet is added with name as "<name>" and id as "<id>" with Status as "<status>"

    Examples:
      | name | photoUrls   | id       | status    |
      | Sams | www.abc.xyz | 51896610 | available |

  @put
  Scenario Outline: Verify PUT operation by updating a pet existing profile
    Given I Perform PUT operation for "/pet" with update in body
      | name   | photoUrls   | id   | status   |
      | <name> | <photoUrls> | <id> | <status> |
    Then I validate new pet is update with name as "<name>" and id as "<id>" with status as "<status>"

    Examples:
      | name | photoUrls   | id        | status |
      | Sams | www.abc.xyz | 123456711 | sold   |

  @delete
  Scenario Outline: Validate the DELETE method for Pet Store
    Given I perform DELETE operation for "/pet/{petId}" with parameters
      | petId   |
      | <petId> |
    Then I am able to see response status code as 200 with message as "<petId>"

    Examples:
      | petId    |
      | 51896610 |
