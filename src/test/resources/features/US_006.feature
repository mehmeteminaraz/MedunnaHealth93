@Smoke
Feature:Kullanıcı bilgisi sekmesi (Setting) Ana Sayfada düzenlenebilir olmalıdır.


  Scenario:  Active edilen hesabin bilgilerini guncelleme testi


    Given Kullanici siteye gider "medunnaUrl"
    And Siteye gidildigini dogrular.
    And Web Sayfasinda bulunan person ikonuna tiklar.
    And SignIn linkine tiklar.
    And SignIn sayfasina gidildigini dogrular.
    And Username Box'a username girer.
    And Password Box'a password girer.
    And Hesaba giris yapmak icin signIn butonuna tiklar.
    And Kullanici Web Sayfasinda bulunan person ikonuna tiklar.
    And Setting sayfa linkine tiklar.
    And Settings sayfasinda oldugunu dogrular.
    And FirstName Box'u gunceller.
    And LastName Box'u guncelelr.
    And Email Box'u update eder.
    And Guncellemeleri kaydetmek icin save butonuna tiklar.
    And Guncellemelerin kaydedildigini dogrular.
    And Hesaptan cikis yapar.
    And Ana sayfaya geri doner.
     #And Web uygulamasindan cikis yapar.