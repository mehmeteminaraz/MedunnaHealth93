@Smoke
Feature: Giriş sayfası yalnızca geçerli kimlik bilgileriyle erişilebilir olmalıdır.

  Scenario:   SignIn/Cancel Butonu Testi

    Given Kullanici siteye gider "medunnaUrl"
    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    And SignIn linkine tiklar.
    And SignIn sayfasina gidildigini dogrular.
    And Username TextBox'in gorunur oldugunu dogrular.
    And Username TextBox'in kullanilabilir oldugunu dogrular.
    And Username TextBox'a username girer.
    And Password TextBox'in gorunur oldugunu dogrular.
    And Password TextBox'in kullanilabilir oldugunu dogrular.
    And Password TextBox'a password girer.
    And Remember Me yazisinin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin kullanilabilir oldugunu dogrular.
    And Remember Me checkbox'inin secili olmadigini dogrular.
    And Remember Me checkbox'ini tiklar.
    And Cancel butonunun gorunur oldugunu dogrular.
    And Cancel butonunun kullanilabilir oldugunu dogrular.
    And Cancel butonuna tiklar.
    And Web uygulamasindan cikis yapar.

  Scenario: SignIn/Did you forget your password? Testi

    Given Kullanici siteye gider "medunnaUrl"
    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    And SignIn linkine tiklar.
    And SignIn sayfasina gidildigini dogrular.
    And Username TextBox'in gorunur oldugunu dogrular.
    And Username TextBox'in kullanilabilir oldugunu dogrular.
    And Username TextBox'a username girer.
    And Password TextBox'in gorunur oldugunu dogrular.
    And Password TextBox'in kullanilabilir oldugunu dogrular.
    And Password TextBox'a password girer.
    And Remember Me yazisinin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin kullanilabilir oldugunu dogrular.
    And Remember Me checkbox'inin secili olmadigini dogrular.
    And Remember Me checkbox'ini tiklar.
    And Did you forget your password linkinin gorunur oldugunu dogrulur.
    And Did you forget your password linkinin kullanilabilir oldugunu dogrular.
    And Did you forget your password linkine tiklar.
    And Reset your password sayfasina gidildigini dogrular.
    And Ana sayfaya geri doner.
    And Web uygulamasindan cikis yapar.






  Scenario:   SignIn/You don't have an account yet? Register a new account Testi

    Given Kullanici siteye gider "medunnaUrl"
    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    And SignIn linkine tiklar.
    And SignIn sayfasina gidildigini dogrular.
    And Username TextBox'in gorunur oldugunu dogrular.
    And Username TextBox'in kullanilabilir oldugunu dogrular.
    And Username TextBox'a username girer.
    And Password TextBox'in gorunur oldugunu dogrular.
    And Password TextBox'in kullanilabilir oldugunu dogrular.
    And Password TextBox'a password girer.
    And Remember Me yazisinin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin gorunur oldugunu dogrular.
    And Remember Me checkbox'inin kullanilabilir oldugunu dogrular.
    And Remember Me checkbox'inin secili olmadigini dogrular.
    And Remember Me checkbox'ini tiklar.
    And You don't have an account yet? Register a new account linkinin goruldugunu dogrular.
    And You don't have an account yet? Register a new account linkinin kullanilabilir oldugunu dogrular.
    And You don't have an account yet? Register a new account linkine tiklar.
    And Registration sayfasinda oldugunu dogrular.
    And Ana sayfaya geri doner.
    And Web uygulamasindan cikis yapar.
