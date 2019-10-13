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
              "host": {
                cards:["B8"],
                winner: false
              },
              "player": {
                cards:["A8","C8"],
                winner: false
              }
           }
           """

  Scenario: close deal
    Given a paiku "A8" "B8" "C8" "BA"
    And I start game
    When I close deal
    Then the server will return
           """
           {
              "host": {
                cards:["B8","BA"],
                winner: true
              },
              "player": {
                cards:["A8","C8"],
                winner: false
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
              "host": {
                cards:["B8"],
                winner: false
              },
              "player": {
                cards:["A8","C8","A1"],
                winner: false
              }
           }
           """