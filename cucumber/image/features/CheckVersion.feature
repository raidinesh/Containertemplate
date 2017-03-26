Feature: Check Version funcationality
    In order for someone to perform diagnostics
    As a user
    I need to have an app that returns its version

    Scenario: Check the version
        Given the app is running
        When I query the version
        Then the version should be "1.0.0"

    
