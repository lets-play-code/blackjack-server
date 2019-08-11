Feature: black jack

  Scenario: ping
    When I ping the server
    Then the server will response

  Scenario: start game
    Given a paiku "A8" "B8" "C8"
    When I start game
    Then the server will return
           """
           {
            "host":["B8"],
            "player":["A8","C8"]
           }
           """

  Scenario: close deal
    Given a paiku "A8" "B8" "C8"
    And I start game
    When I close deal
    Then the server will return
           """
           {
              "host": {
                winner: false
              },
              "player": {
                winner: true
              }
           }
           """

  Scenario: deal
    Given a paiku "A8" "B8" "C8" "A1"
    And I start game
    When I deal
    Then the server will return
          """
           {
            "host":["B8"],
            "player":["A8","C8","A1"]
           }
           """