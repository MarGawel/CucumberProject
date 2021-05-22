Feature: Register new User

  Scenario Outline: uzytkownik moze sie zalogowac
    Given wejdz na strone https://qloapps.coderslab.pl/pl/logowanie?back=my-account
    When w polu Email address wpisuje <email>
    And klika przycisk Creata an account
    And w polu Tilte zaznacz pole Pan
    And w polu First Name wpisz <firstName>
    And w polu Last Name wpisz <lastName>
    And w polu Password wpisz <password>
    And w polu Data of Birth 1 pole zaznacz <day> 2 pole zaznacz <month> 3 pole zaznacz <year>
    And kliknij Register
    Then Otwiera sie strona My Account



    Examples:
    | email          | firstName | lastName | password | day | month | year |
    | el1@email.pl | Marcin    | Kowalski | qwe123   | 30  | 11    | 1990 |

