Feature: Github API

  Background:
    * url 'http://localhost:8080/api'

  Scenario: Get repositories for an existing user
    Given path '/helter88'
    When method get
    Then status 200
    And match response != []
    And match response == '#[]'
#    Odpowiedź jest listą (ale nie sprawdza konkretnej liczby elementów)
    And match response[0] == '#object'
#    Pierwszy element listy jest obiektem.
    And match response[0] contains { name: '#string', owner: { login: 'helter88' }, fork: '#boolean' }
#    Pierwszy element listy zawiera oczekiwane pola z odpowiednimi typami danych.

  Scenario: Get repositories for a non-existing user
    Given path '/non-existing-user'
    When method get
    Then status 404
    And match response == { status: 404, message: '#string' }