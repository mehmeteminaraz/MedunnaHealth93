@Smoke
Feature:US016  Admin,yatan hastalar için yeni oda olusturabilir
  Background:
    Given Kullanici siteye gider "medunnaUrl"
  Scenario: Hastalar icin yeni oda olusturma
    Given Kullanici giris sayfasina gider
    Given Kullanici yonetici olarak oturum acar
    Given Kullanici Baglantilarim altindaki Oda cta'sini tiklar
    Given Kullanici Yeni bir oda olustur'u tiklar
    Given Kullanici oda numarasi alanini bos birakir
    Given Kullanici Oda Tipi acilir menusunde TWIN'i secer
    Given Kullanici Durum onay kutusuna tiklayarak mevcut durumu ayarlar
    Given Kullanici fiyat alanini bos birakir
    Given Kullanici aciklama girer
    Given Kullanici  olusturulma tarihini girer
    Given Kullanici  Kaydet dugmesine tiklarr
    Given This field is required mesaji, gerekli alan metin kutusunun altinda gorunur
    Then Giris yapilan hesaptan signOut yapar.
    Then Web uygulamasindan cikis yapar.

  Scenario: Admin hastalar için oda görüntüleyebilir.
    Given Kullanici giris sayfasina gider
    Given Kullanici yonetici olarak oturum acar
    Given Kullanici Baglantilarim altindaki Oda cta'sini tiklar
    Given Kullanici Yeni bir oda olustur'u tiklar
    Given Kullanici Verilen oda numarasini girer
    Given Kullanici Oda Tipi acilir menusunde TWIN'i secer
    Given Kullanici Durum onay kutusuna tiklayarak mevcut durumu ayarlar
    And Kullanici fiyat girer
    Given Kullanici aciklama girer
    Given Kullanici  olusturulma tarihini girer
    Given Kullanici  Kaydet dugmesine tiklar
    Then Kullanici , odanin basariyla olusturuldugunu dogrular
    Then Giris yapilan hesaptan signOut yapar.
    Then Web uygulamasindan cikis yapar.

  Scenario: Admin hasta icin oda guncelleyebilir ve silebilir.
    Given Kullanici giris sayfasina gider
    Given Kullanici yonetici olarak oturum acar
    Given Kullanici Baglantilarim altindaki Oda cta'sini tiklar
    Given Kullanici Yeni bir oda olustur'u tiklar
    Given Kullanici Verilen oda numarasini girer
    And Kullanici fiyat girer
    Given Kullanici aciklama girer
    Given Kullanici  olusturulma tarihini girer
    Given Kullanici  Kaydet dugmesine tiklar
    Given Kullanici son sayfa dugmesine tiklar
    When Kullanici Duzenle dugmesine tiklar
    And Kullanici oda numarasını gunceller
    And Kullanici oda tipi olarak DELUXE'u secer
    And Kullanici fiyati gunceller
    And Kullanici aciklamayi gunceller
    Given Kullanici  Kaydet dugmesine tiklar
    And Kullanici sil dugmesine tiklar
    And Kullanici acilir mesaji silmeyi onaylar
    Then Kullanici , odanın basariyla silindigini dogrular
    Then Giris yapilan hesaptan signOut yapar.
    Then Web uygulamasindan cikis yapar.


