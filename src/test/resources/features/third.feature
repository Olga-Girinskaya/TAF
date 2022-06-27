Feature: Параметризированные тесты

  Scenario: Простая параметризация
    Given открыт браузер
    * страница логина открыта
    When пользователь "atrostyanko@gmail.com" и пароль "Americana#1" залогинился
    Then кнопка добавления проекта отображается
    And пользователь "Alex Tros"
    And количество проектов - 15

  Scenario Outline: Таблицы
    Given открыт браузер
    * страница логина открыта
    When пользователь "<email>" и пароль "<psw>" залогинился
    Then пользователь "<visibleText>"
    Examples:
      | email                 | psw         | visibleText |
      | atrostyanko@gmail.com | Americana#1 | Alex Tros    |
      | test@gmail.com        | 123         | 123          |
