@Smoke
Feature: US22 Hasta Test sonuclari (Staff)

  Background:
    Given Kullanici siteye gider "medunnaUrl"

  @Team93
  Scenario Outline: TC1 SSN id ile arama

    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    Then Sign in sekmesine tiklar.
    Then Username Box'a gecerli "<username>" girer.
    Then Password Box'a gecerli "<password>" girer.
    Then Sign in butonuna tiklar.
    Then Ust menudeki MY_PAGES menusune tiklanir.
    Then Menunun altinda cikan Search Patient item'ina tiklanir.
    And Patients basligi altindaki Patient SSN textbox'una SSN numarasi girilir.
    And Patient sayfasinda ilgili hasta bilgileri goruntulenir.
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menuden signOut linkine tiklar

    Examples:
      |username    |password|
      |staff_zeynep|New2022.|


  @Team93
  Scenario Outline: TC02 Test Sonuclarini Goruntuleme ve Guncelleme

    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    Then Sign in sekmesine tiklar.
    Then Username Box'a gecerli "<username>" girer.
    Then Password Box'a gecerli "<password>" girer.
    Then SignIn butonuna tiklar.
    Then Ust menudeki MY_PAGES menusune tiklanir.
    Then Menunun altinda cikan Search Patient item'ina tiklanir.
    Then Patients basligi altinda hasta listesi gorunur.
    And Patients basligi altindaki Patient SSN textbox'una SSN numarasi girilir.
    Then Hasta bilgi satirindaki Show Appointments butonuna tiklar.
    And Hasta randevu bilgileri goruntulenir.
    Then Hasta bilgi satirindaki Show Tests butonuna tiklanir.
    Then Tests basligi goruntulenir.
    Then Tests sayfasindaki View Results butonuna tiklanir.
    And Test Results sayfasi goruntulenir.
    Then Test Results sayfasindaki Edit butonuna tiklanir.
    Then Create or edit a Test Result basligi goruntulenir.
    And Test Result formunda Result textboxuna veri girilir.
    And Test Result formunda Description textboxuna veri girilir.
    And Test Result sayfasinda Save butonuna tiklanir.
    And Test Result'in guncellendigi goruntulenir.
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menuden signOut linkine tiklar

    Examples:
      |username    |password|
      |staff_zeynep|New2022.|