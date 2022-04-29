@Smoke
Feature: US21 Staff hastalar icin randevulari gorur

  Background:
    Given Kullanici siteye gider "medunnaUrl"

  Scenario Outline: TC01 Randevu güncelleme

    And Siteye gidildigini dogrular.
    Then Web Sayfasinda bulunan person ikonuna tiklar.
    Then Sign in sekmesine tiklar.
    Then Username Box'a gecerli "<username>" girer.
    Then Password Box'a gecerli "<password>" girer.
    Then Sign in butonuna tiklar.
    Then Ust menudeki MY_PAGES menusune tiklanir.
    Then Menunun altinda cikan Search Patient item'ina tiklanir.
    Then Patients basligi altinda hasta listesi gorunur.
    And Patients basligi altindaki Patient SSN textbox'una SSN numarasi girilir.
    Then Staff Hasta bilgi satirindaki Show Appointments butonuna tiklanir.
    And Hasta randevu bilgileri goruntulenir.
    Then Hasta bilgi satirindaki Edit butonuna tiklanir.
    And Start DateTime alanindan tarih secilir.
    And End DateTime alanindan tarih secilir.
    And Status alaninda statu durumu secilir.
    And Anamnesis alanina veri girilir.
    And Treatment alanina veri girilir.
    And Diagnosis alanina veri girilir.
    And Prescription alanina veri girilir.
    And Appointment Description alanina veri girilir.
    And Physician alanindan doktor secimi yapilir.
    And Hasta Appointment formundaki Save butonuna tiklanir.
    And Hasta Appointment bilgileri guncellenir.
    Then Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar
    Then Kullanici acilan menuden signOut linkine tiklar

    Examples:
      |username    |password|
      |staff_zeynep|New2022.|