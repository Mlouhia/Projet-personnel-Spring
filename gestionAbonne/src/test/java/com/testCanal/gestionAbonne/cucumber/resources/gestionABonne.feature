Feature: Gestion des abonnés et des contrats

  Scenario: créer un nouvel abonné
    When the client calls /abonne
    Given an abonne
    Then the client receives answer as 3