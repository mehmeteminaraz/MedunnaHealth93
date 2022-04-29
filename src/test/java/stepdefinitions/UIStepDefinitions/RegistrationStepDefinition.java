package stepdefinitions.UIStepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.MedPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import pages.MedunnaPage;
import utilities.ReusableMethods;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class RegistrationStepDefinition {
    MedunnaPage MedunnaPage = new MedunnaPage();
    MedunnaPage mp = new MedunnaPage();
    Faker faker = new Faker();
    Actions actions;
    SoftAssert softAssert = new SoftAssert();
    static String doktorName, firstName, lastName, userName, email, password;
    MedPage medpage = new MedPage();
    MedPage mpage = new MedPage();
    Select select;
    static String x,newName,firstMessageID,countryID;

    // ------------------------- KÜBRA -----------------------------------
    @Given("Kullanici siteye gider {string}")
    public void kullaniciSiteyeGider(String medunnaUrl) {
        Driver.getDriver().get(ConfigurationReader.getProperty(medunnaUrl));
    }

    @When("Sayfaya gidildigi ana sayfadaki WELCOME TO MEDUNNA texti ile dogrulanir")
    public void sayfaya_gidildigi_ana_sayfadaki_welcome_to_medunna_texti_ile_dogrulanir() {
        Assert.assertTrue(mp.anaSayfaWelcomeToMedunnaYazisi.isDisplayed());
    }

    @When("Kullanici sayfaya giris icin CONTACT linkinin sagında bulunan kullanici girisi linkine tiklar")
    public void kullanici_sayfaya_giris_icin_contact_linkinin_saginda_bulunan_kullanici_girisi_linkine_tiklar() {
        Driver.waitAndClick(mp.anaSayfaKullaniciIkonu);
    }

    @Then("Kullanici kayıt olusturabilmek icin Register linkine tiklar")
    public void kullanici_kayit_olusturabilmek_icin_register_linkine_tiklar() {
        mp.registerLinki.click();
    }

    @Then("Kayit sayfasinda olundugu Registration yazisi ile dogrulanir")
    public void kayit_sayfasinda_olundugu_registration_yazisi_ile_dogrulanir() {
        Assert.assertTrue(mp.registerYazisi.isDisplayed());
    }

    @Then("Girilecek olan {string} numarasi dokuzu gecmemeli ve dokuzun altinda olmamali")
    public void girilecek_olan_numarasi_dokuzu_gecmemeli_ve_dokuzun_altinda_olmamali(String ssn) {
        mp.ssnTextBox.click();
        mp.ssnTextBox.sendKeys(ssn, Keys.ENTER);
    }

    @Then("Kullanici SSN numarasinin ucuncu ve besinci rakamından sonra - isareti {string} koymali")
    public void kullaniciSSNNumarasininUcuncuVeBesinciRakamindanSonraIsaretiKoymali(String tireliSSN) {
        mp.ssnTextBox.clear();
        mp.ssnTextBox.sendKeys(tireliSSN, Keys.ENTER);
    }

    @Then("Gecersiz SSN numarasi girildiginde Your SSN is invalid text'inin gorunurlugu test edilmeli")
    public void gecersiz_ssn_numarasi_girildiginde_your_ssn_is_invalid_text_inin_gorunurlugu_test_edilmeli() {
        Assert.assertTrue(mp.yourSsnIsInvalidYazisi.isDisplayed());
    }

    @And("SSN textboxi bos birakildiginda Your SSN is required textinin gorunurlugu test edilmeli")
    public void ssnTextboxiBosBirakildigindaYourSSNIsRequiredTextininGorunurluguTestEdilmeli() {
        mp.ssnTextBox.click();
        mp.firstnameTextBox.click();
        Assert.assertTrue(mp.yourSsnIsRequiredYazisi.isDisplayed());
    }

    @Then("Kullanici gecerli bir ssn numarasi girmeli")
    public void kullaniciGecerliBirSsnNumarasiGirmeli() {
        mp.ssnTextBox.click();
        mp.ssnTextBox.sendKeys(faker.idNumber().ssnValid(), Keys.ENTER);
    }

    @Then("Firstname textboxı bos birakildiginda cikan Your FirstName is required textinin gorunurlugu test edilmeli")
    public void firstnameTextboxiBosBirakildigindaCikanYourFirstNameIsRequiredTextininGorunurluguTestEdilmeli() {
        mp.firstnameTextBox.click();
        mp.lastnameTextBox.click();
        Assert.assertTrue(mp.yourFirstnameIsRequiredYazisi.isDisplayed());
    }

    @And("Firstname textboxina gecerli bir isim girilmeli")
    public void firstnameTextboxinaGecerliBirIsimGirilmeli() {
        mp.firstnameTextBox.click();
        mp.firstnameTextBox.sendKeys(faker.name().firstName());
    }

    @And("Lastname textboxi bos birakildiginda cikan Your LastName is required textinin gorunurlugu test edilmeli")
    public void lastnameTextboxiBosBirakildigindaCikanYourLastNameIsRequiredTextininGorunurluguTestEdilmeli() {
        mp.lastnameTextBox.click();
        mp.firstnameTextBox.click();
        Assert.assertTrue(mp.yourLastnameIsRequiredYazisi.isDisplayed());
    }

    @Then("Lastname textboxina gecerli bir soyisim girilmeli")
    public void lastnameTextboxinaGecerliBirSoyisimGirilmeli() {
        mp.lastnameTextBox.sendKeys(faker.name().lastName());
    }

    @And("Username textboxi bos birakildiginda cikan Your username is required textinin gorunurlugu test edilmeli")
    public void usernameTextboxiBosBirakildigindaCikanYourUsernameIsRequiredTextininGorunurluguTestEdilmeli() {
        mp.usernameTextBox.click();
        mp.lastnameTextBox.click();
        Assert.assertTrue(mp.yourUsernameIsRequiredYazisi.isDisplayed());
    }

    @Then("Bosluk birakilarak girilen bir username in gecersiz oldugu Your username is invalid textinin gorunurlugu ile test edilmeli")
    public void boslukBirakilarakGirilenBirUsernameInGecersizOlduguYourUsernameIsInvalidTextininGorunurluguIleTestEdilmeli() {
        mp.usernameTextBox.click();
        mp.usernameTextBox.sendKeys("QA Kubra");
        Driver.wait(2);
        Assert.assertTrue(mp.yourUsernameIsInvalidYazisi.isDisplayed());
    }

    @And("Username textboxina gecerli bir kullanici adı girilmeli")
    public void usernameTextboxinaGecerliBirKullaniciAdiGirilmeli() {
        mp.usernameTextBox.clear();
        mp.usernameTextBox.sendKeys(faker.name().username());
    }

    @Then("Email textboxina {string} @ ve . isareti icermeyen bir adres girildiginde cikan This field is invalid textin gorunurlugu test edilmeli")
    public void emailTextboxinaVeIsaretiIcermeyenBirAdresGirildigindeCikanThisFieldIsInvalidTextinGorunurluguTestEdilmeli(String isaretler) {
        mp.emailTextBox.click();
        mp.emailTextBox.sendKeys(isaretler);
        Driver.wait(2);
    }

    @And("Email textboxina bes karakterden az olucak sekilde email adresi yazildiginda cikan Your email is required to be at least five characters textin gorunurlugu test edilmeli")
    public void emailTextboxinaBesKarakterdenAzOlucakSekildeEmailAdresiYazildigindaCikanYourEmailIsRequiredToBeAtLeastFiveCharactersTextinGorunurluguTestEdilmeli() {
        mp.emailTextBox.clear();
        mp.emailTextBox.sendKeys("abc0");
        Assert.assertTrue(mp.yourEmailIsRequiredToBeAtLeastFiveCharactersYazisi.isDisplayed());
    }

    @Then("Email textboxi bos birakildiginda cikan Your email is required textinin gorunurlugu test edilmeli")
    public void emailTextboxiBosBirakildigindaCikanYourEmailIsRequiredTextininGorunurluguTestEdilmeli() {
        mp.emailTextBox.click();
        mp.usernameTextBox.click();
        Assert.assertTrue(mp.yourEmailIsRequiredYazisi.isDisplayed());
    }

    @And("Email textboxina gecerli bir adres girilmeli")
    public void emailTextboxinaGecerliBirAdresGirilmeli() {
        mp.emailTextBox.sendKeys(faker.internet().emailAddress());
    }

    //-------------US014---Onur--------------------------------------------------------------------------------
    @When("Doktor acilan menuden Sign In e tiklar")
    public void doktor_acilan_menuden_sign_in_e_tiklar() {
        Driver.wait1(5);
        mp.signInlink.click();

    }

    @When("Doktor kendi {string} ve {string} girip Sign In butonuna tiklar")
    public void doktor_kendi_ve_girip_sign_in_butonuna_tiklar(String userName, String password) {
        mp.userName.sendKeys(userName);
        mp.passWord.sendKeys(password);
        mp.signIn.click();
    }

    @Then("Doktor sag ust kosede kendi adini gorur")
    public void doktor_sag_ust_kosede_kendi_adini_gorur() {

        Assert.assertTrue(mp.recepaltinkaya.isDisplayed());
    }

    @Then("Doktor ust tarafta bulunan MY PAGES butonuna tiklar")
    public void doktor_ust_tarafta_bulunan_my_pages_butonuna_tiklar() {
        Driver.waitAndClick(mp.myPages, 5);

    }

    @Then("Doktor acilan menuden My Inpatients butununa tiklar")
    public void doktor_acilan_menuden_my_inpatients_butununa_tiklar() {
        mp.myInpatients.click();
        actions = new Actions(Driver.getDriver());
        Driver.wait1(2);
        actions.sendKeys(mp.inpatientsFromTextBox, "25").sendKeys("03").sendKeys("2022").sendKeys(Keys.TAB).perform();
        Driver.wait1(10);
        actions.sendKeys("08").perform();

        Driver.wait1(3);
        // actions.sendKeys(mp.inpatientsToTextBox,"10.04.2022").perform();
        // Driver.wait1(2);
        // mp.inpatientsFromTextBox.sendKeys("25.03.2022",Keys.ENTER);
        // Driver.wait1(5);
        // mp.inpatientsToTextBox.sendKeys("10.04.2022",Keys.ENTER);

    }

    @Then("Doktor yatan hastalarin ID, start and end dates, description bilgilerini goruntuleyebilir")
    public void doktor_yatan_hastalarin_id_start_and_end_dates_description_bilgilerini_goruntuleyebilir() {

        for (int i = 1; i <= 4; i++) {
            Driver.wait1(2);
            String dinamikxpath = "//tbody//tr//td[" + i + "]";

            WebElement a = Driver.getDriver().findElement(By.xpath(dinamikxpath));
            Assert.assertTrue(a.isDisplayed());
        }
    }

    @Then("Doktor yatan hastalarin created date, appointment id bilgilerini goruntuleyebilir")
    public void doktor_yatan_hastalarin_created_date_appointment_id_bilgilerini_goruntuleyebilir() {

        for (int i = 5; i <= 7; i++) {
            Driver.wait1(2);
            String dinamikxpath = "//tbody//tr//td[" + i + "]";

            WebElement a = Driver.getDriver().findElement(By.xpath(dinamikxpath));
            Assert.assertTrue(a.isDisplayed());
        }
    }

    @Then("Doktor yatan hastalarin status, room and patient bilgilerini goruntuleyebilir")
    public void doktor_yatan_hastalarin_status_room_and_patient_bilgilerini_goruntuleyebilir() {

        for (int i = 7; i <= 9; i++) {
            Driver.wait1(2);
            String dinamikxpath = "//tbody//tr//td[" + i + "]";

            WebElement a = Driver.getDriver().findElement(By.xpath(dinamikxpath));
            Assert.assertTrue(a.isDisplayed());
        }
    }

    @Then("Doktor yatan hasta satirinin yaninda bulunan Edit butonuna tiklar")
    public void doktor_yatan_hasta_satirinin_yaninda_bulunan_edit_butonuna_tiklar() {
        Driver.wait1(5);
        mp.editButton.click();
    }

    @Then("Doktor yatan hastalarin ID, start and end dates, description bilgilerini guncelleyebilir")
    public void doktor_yatan_hastalarin_id_start_and_end_dates_description_bilgilerini_guncelleyebilir() {

    }

    @Then("Doktor yatan hastalarin created date, appointment id bilgilerini guncelleyebilir")
    public void doktor_yatan_hastalarin_created_date_appointment_id_bilgilerini_guncelleyebilir() {

        faker = new Faker();
        String date = faker.number().digits(2002) + faker.number().digits(03) +
                faker.number().digits(01) +
                faker.number().digits(12) +
                faker.number().digits(45);
        Driver.wait1(2);
        Driver.clickWithJS(mp.createdDateTextbox);
        mp.createdDateTextbox.sendKeys(date);
        Driver.clickWithJS(mp.saveButton);
        Driver.wait1(8);
        //Assert.assertFalse(mp.inpatientCreatedDate.getText().contains(date));
        //softAssert.assertAll();
    }

    @Then("Doktor yatan hastalarin patient bilgilerini guncelleyebilir")
    public void doktor_yatan_hastalarin_patient_bilgilerini_guncelleyebilir() {

        mp.editButton1.click();
        Driver.wait1(2);
        String post = "a";
        Driver.clickWithJS(mp.patientTextbox);
        Driver.wait1(2);
        // mp.patientTextbox.sendKeys(post);
        Driver.clickWithJS(mp.saveButton);
        // System.out.println("inpatient"+mp.inpatientCreatedDate.getText());
        // softAssert.assertFalse(mp.inpatientCreatedDate.getText().contains(post));

    }

    @Then("Doktor tarayiciyi kapatir")
    public void doktor_tarayiciyi_kapatir() {

        Driver.closeDriver();
    }

    @Then("Doktor acilan sayfadan Status bolumunden UNAPPOROVED'u secip kaydedebilir")
    public void doktor_acilan_sayfadan_status_bolumunden_unapporoved_u_secip_kaydedebilir() {
        // Driver.clickWithJS(mp.statusTextbox);
        Driver.wait1(2);
        Select select = new Select(mp.statusTextbox);
        select.selectByValue("UNAPPROVED");
        Driver.clickWithJS(mp.saveButton);

    }

    @Then("Doktor acilan sayfadan Status bolumunden STAYING secip kaydedebilir")
    public void doktor_acilan_sayfadan_status_bolumunden_staying_secip_kaydedebilir() {
        Driver.wait1(8);
        mp.editButton1.click();
        Driver.wait1(2);
        Select select1 = new Select(mp.statusTextbox);
        select1.selectByIndex(1);
        Driver.wait1(2);
        Select select2 = new Select(mp.roomTextbox);
        select2.selectByIndex(4);
        Driver.clickWithJS(mp.saveButton);
    }

    @Then("Doktor STAYING secildigini kontrol eder")
    public void doktor_staying_secildigini_kontrol_eder() {
        Driver.wait1(5);
        Assert.assertFalse(mp.inpatientstatus.getText().equals("STAYING"));

    }

    @Then("Doktor acilan sayfadan Status bolumunden DISCHARGED secip kaydedebilir")
    public void doktor_acilan_sayfadan_status_bolumunden_discharged_secip_kaydedebilir() {
        mp.editButton1.click();
        Driver.wait1(2);
        Select select1 = new Select(mp.statusTextbox);
        select1.selectByIndex(2);
        Driver.wait1(2);
        Driver.clickWithJS(mp.saveButton);
    }

    @Given("Doktor acilan sayfadan Status bolumunden CANCELLED secip kaydedebilir")
    public void doktor_acilan_sayfadan_status_bolumunden_cancelled_secip_kaydedebilir() {
        mp.editButton1.click();
        Driver.wait1(2);
        Select select1 = new Select(mp.statusTextbox);
        select1.selectByIndex(3);
        Driver.wait1(2);
        Driver.clickWithJS(mp.saveButton);
    }

    @Then("Doktor CANCELLED secildigini kontrol eder")
    public void doktor_cancelled_secildigini_kontrol_eder() {
        Driver.wait1(2);
        Assert.assertFalse(mp.inpatientstatus.getText().equals("CANCELLED"));
    }

    @Then("Doktor Room bolumunden herhangi bir oda tipi secip guncelleyebilir")
    public void doktor_room_bolumunden_herhangi_bir_oda_tipi_secip_guncelleyebilir() {

    }

    @Then("Doktor oda tipini degistirdigini kontrol edebilir")
    public void doktor_oda_tipini_degistirdigini_kontrol_edebilir() {

    }

    // ------------------------US010 Mehmet Emin Araz-------------------------------------

    @Given("kullanici {string} olarak oturum acar")
    public void kullanici_olarak_oturum_acar(String arg0) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaRegistration"));
        switch (arg0) {
            case "doctor":
                Driver.waitAndSendText(MedunnaPage.username, ConfigurationReader.getProperty("doctor_username"));
                Driver.waitAndSendText(MedunnaPage.password, ConfigurationReader.getProperty("doctor_password"));
                Driver.waitAndClick(MedunnaPage.singInButton);
                Driver.waitAndClick(MedunnaPage.myPagesDropdown);
                Assert.assertTrue(MedunnaPage.myAppointment.isDisplayed());
                break;
            case "admin":
                Driver.waitAndSendText(MedunnaPage.username, ConfigurationReader.getProperty("admin_username"));
                Driver.waitAndSendText(MedunnaPage.password, ConfigurationReader.getProperty("admin_password"));
                Driver.waitAndClick(MedunnaPage.singInButton);
                Driver.waitAndClick(MedunnaPage.itemsTitlesDropdown);
                Assert.assertTrue(MedunnaPage.adminAppointment.isDisplayed());
                break;
            case "patient":
                Driver.waitAndSendText(MedunnaPage.username, ConfigurationReader.getProperty("patient_username"));
                Driver.waitAndSendText(MedunnaPage.password, ConfigurationReader.getProperty("patient_password"));
                Driver.waitAndClick(MedunnaPage.singInButton);
                Driver.waitAndClick(MedunnaPage.patientMyPagesDropdown);
                Assert.assertTrue(MedunnaPage.myAppointment.isDisplayed());
                break;
            case "user":
                Driver.waitAndSendText(MedunnaPage.username, ConfigurationReader.getProperty("user_username"));
                Driver.waitAndSendText(MedunnaPage.password, ConfigurationReader.getProperty("user_password"));
                Driver.waitAndClick(MedunnaPage.singInButton);
                break;
            default:
                System.out.println("No such user found");
                break;

        }
    }

    @Given("kullanici Randevularim ogesini secer ve tiklar")
    public void kullanici_randevularim_ogesini_secer_ve_tiklar() {
        Driver.waitAndClick(MedunnaPage.myAppointment);
    }

    @When("kullanici Randevular sayfasinda oldugunu dogrular")
    public void randevular_sayfasindaki_kullanici() {
        Driver.waitForVisibility(MedunnaPage.appointmentHeading, 1);
        Assert.assertTrue(MedunnaPage.appointmentHeading.isDisplayed());
    }

    @When("kullanici {string} ve {string} saglayan zaman dilimlerini secer")
    public void kullanici_ve_saglayan_zaman_dilimlerini_secer(String arg0, String arg1) {
        Driver.waitAndSendText(MedunnaPage.fromDateAppointment, arg0);
        Driver.waitAndSendText(MedunnaPage.toDateAppointment, arg1);
        Driver.wait(1);
        try {
            System.out.println(Driver.waitAndGetText(MedunnaPage.alertMessage, 1));
        } catch (Exception e) {
        }

    }

    @Then("kullanici randevularin ve zaman araliklarinin listesini gormelidir")
    public void kullanici_randevularin_ve_zaman_araliklarinin_listesini_gormelidir() {
        Driver.waitAndClick(MedunnaPage.editFirstAppointment);
    }

    @Then("kullanici randevu listesinin bilgilerini gormelidir")
    public void kullanici_randevu_listesinin_bilgilerini_gormelidir() {
        Assert.assertTrue(Driver.waitForVisibility(MedunnaPage.headersOfAppointmentsTable, 1).
                getText().contains("ID"));
        Assert.assertTrue(Driver.waitForVisibility(MedunnaPage.headersOfAppointmentsTable, 1).
                getText().contains("Start DateTime"));
        Assert.assertTrue(Driver.waitForVisibility(MedunnaPage.headersOfAppointmentsTable, 1).
                getText().contains("End DateTime"));
        Assert.assertTrue(Driver.waitForVisibility(MedunnaPage.headersOfAppointmentsTable, 1).
                getText().contains("Status"));

    }


    @Given("kullanici {string},{string} yonetici olarak oturum acar")
    public void kullanici_yonetici_olarak_oturum_acar(String username, String password) {
        Driver.waitAndSendText(MedunnaPage.signInUsernameTextBox, username);
        Driver.waitAndSendText(MedunnaPage.signInPasswordTextBox, password);
        Driver.waitAndClick(MedunnaPage.signInButonu);
    }

    @Given("kullanici randevu sayfasina gider")
    public void kullanici_randevu_sayfasina_gider() {
        Driver.waitAndClick(MedunnaPage.itemsTitlesDropdown);
        Driver.waitAndClick(MedunnaPage.adminAppointment);

    }

    @Given("kullanici yeni bir Randevu Olustur dugmesini tiklar")
    public void kullanici_yeni_bir_randevu_olustur_dugesini_tiklar() {
        Driver.waitAndClick(MedunnaPage.createANewAppointment);
    }

    @Given("kullanici baslangic tarihi ve bitis tarihi saatini saglar")
    public void kullanici_baslangic_tarihi_ve_bitis_tarihi_saatini_saglar() {
        Driver.waitAndSendText(MedunnaPage.startDateTime, "26-07-2022 09:15");
        Driver.waitAndSendText(MedunnaPage.endDateTime, "29-07-2022 11:30");
    }

    @Given("kullanici {string} durumunu secer")
    public void kullanici_durumunu_secer(String string) {
        Driver.waitAndClick(MedunnaPage.status);
        Driver.waitAndClick(MedunnaPage.pendingAnAppointment);


    }

    @Given("kullanici HastalikGecmisi {string} ,Tedavi  {string} ,Teshis {string} ,Recete {string} ,Aciklama {string} saglar")
    public void kullanici_hastalik_gecmisi_tedavi_teshis_recete_aciklama_saglar(String hastalikGecmisi, String tedavi, String teshis, String recete, String aciklama) {
        Driver.waitAndSendText(MedunnaPage.anamnesis, hastalikGecmisi);
        Driver.waitAndSendText(MedunnaPage.treatment, tedavi);
        Driver.waitAndSendText(MedunnaPage.diagnosis, teshis);
        Driver.waitAndSendText(MedunnaPage.prescription, recete);
        Driver.waitAndSendText(MedunnaPage.description, aciklama);
    }

    @Given("kullanici ,Doktor {string}, Hasta {string} secer")
    public void kullanici_doktor_hasta_secer(String doktor, String hasta) {
        Driver.selectByValue(MedunnaPage.physician, doktor);
        Driver.selectByValue(MedunnaPage.patient, hasta);

    }

    @When("kullanici kaydet dugmesine tiklar")
    public void kullanici_kaydet_dugmesine_tiklar() {
        Driver.waitAndClick(MedunnaPage.saveEntity);
    }

    @Then("kullanici basarı mesajini dogrular")
    public void kullanici_basari_mesajini_dogrular() {
        Assert.assertTrue(Driver.waitForVisibility(MedunnaPage.successMessageT, 5).isDisplayed());

    }
    //------------------------SEZEN---------------------------

    @And("Siteye gidildigini dogrular.")
    public void siteyeGidildiginiDogrular() {
        Assert.assertTrue(mp.medunnaLogoElementi.isDisplayed());
    }

    @And("Make an Appointment butonuna tiklar.")
    public void makeAnAppointmentButonunaTiklar() {
        mp.makeAnAppointmentButonu.click();
    }

    @And("Make an Appointment yazisinin goruldugunu dogrular.")
    public void makeAnAppointmentYazisininGoruldugunuDogrular() {
        Assert.assertTrue(mp.makeAnAppointmentYazisi.isDisplayed());
        Driver.wait(1);
    }

    @And("Firstname TextBox'a {string} girer.")
    public void firstnameTextBoxAGirer(String firstname) {
        mp.makeAnAppointmentFirstNameTextBox.sendKeys(firstname);
        Driver.wait(1);
    }

    @And("Make An Appointment First Name Uyari Yazisinin gorundugunu dogrular.")
    public void makeAnAppointmentFirstNameUyariYazisininGorundugunuDogrular() {
        Assert.assertTrue(mp.makeAnAppointmentFirstNameUyariYazisi.isDisplayed());
    }

    @And("Send an Appointment Request butonuna tiklar.")
    public void sendAnAppointmentRequestButonunaTiklar() {
        mp.sendAnAppointmentRequestButton.click();
        Driver.wait(3);
    }

    @And("SSN TextBox'a {string} girer.")
    public void ssnTextBoxAGirer(String ssn) {
        mp.ssnTextBox.sendKeys(ssn);
    }

    @And("Make An Appointment SSN icin SSN Uyari Yazisi gorundugunu dogrular.")
    public void makeAnAppointmentSSNIcinSSNUyariYazisiGorundugunuDogrular() {
        String ssn = "Your SSN is required.";
        Assert.assertEquals(mp.makeAnAppointmentSSNUyariYazisi.getText(), ssn);
    }

    @And("Make An Appointment invalid SSN icin SSN Uyari Yazisi gorundugunu dogrular.")
    public void makeAnAppointmentInvalidSSNIcinSSNUyariYazisiGorundugunuDogrular() {
        String ssn = "Your SSN is invalid";
        Assert.assertEquals(mp.makeAnAppointmentSSNInvalidUyariYazisi.getText(), ssn);
    }

    @And("Lastname TextBox'a {string} girer.")
    public void lastnameTextBoxAGirer(String lastname) {
        mp.makeAnAppointmentLastNameTextBox.sendKeys(lastname);
    }

    @And("Make An Appointment Last Name Uyari Yazisinin gorundugunu dogrular.")
    public void makeAnAppointmentLastNameUyariYazisininGorundugunuDogrular() {
        Assert.assertTrue(mp.makeAnAppointmentLastNameUyariYazisi.isDisplayed());
    }

    @And("Email TextBox'a {string} girer.")
    public void emailTextBoxAGirer(String email) {
        mp.makeAnAppointmentEmailTextBox.sendKeys(email);
    }

    @And("Make An Appointment Email icin {string} gorundugunu dogrular.")
    public void makeAnAppointmentEmailIcinGorundugunuDogrular(String email) {
        Assert.assertEquals(mp.makeAnAppointmentEmailUyariYazisi.getText(), email);
    }

    @And("Make An Appointment invalid Email icin {string} gorundugunu dogrular.")
    public void makeAnAppointmentInvalidEmailIcinGorundugunuDogrular(String invalidUyari) {
        Assert.assertEquals(mp.makeAnAppointmentEmailInvalidUyariYazisi.getText(), invalidUyari);
    }

    @And("Phone TextBox'a {string} girer.")
    public void phoneTextBoxAGirer(String phone) {
        mp.makeAnAppointmentPhoneTextBox.sendKeys(phone);
    }

    @And("Make An Appointment invalid Phone icin Phone Uyari Yazisi gorundugunu dogrular.")
    public void makeAnAppointmentInvalidPhoneIcinPhoneUyariYazisiGorundugunuDogrular() {
        String phone = "Phone number is invalid";
        Assert.assertEquals(mp.makeAnAppointmentInvalidPhoneUyariYazisi.getText(), phone);
    }

    @And("Make An Appointment Phone icin Phone Uyari Yazisi gorundugunu dogrular.")
    public void makeAnAppointmentPhoneIcinPhoneUyariYazisiGorundugunuDogrular() {
        String phone = "Phone number is required.";
        Assert.assertEquals(mp.makeAnAppointmentPhoneUyariYazisi.getText(), phone);
    }


    //********************** Mali *******************************
    @Given("Kullanici kendisine verilen {string} ve {string} ile sign in yapar ve Appointments sayfasina girer")
    public void kullaniciKendisineVerilenVeIleSignInYaparVeAppointmentsSayfasinaGirer(String username, String password) {
        mp.anaSayfaKullaniciIkonu.click();
        mp.signInLinki.click();
        mp.signInUsernameTextBox.sendKeys(username);
        mp.signInPasswordTextBox.sendKeys(password);
        mp.signInButonu.click();
        Driver.wait(2);
        mp.myPagesElement.click();
        mp.myAppointment.click();


    }

    @Then("Kullanici mevcut gun ile ileri tarihleri arasindaki statusu unapproved olanlari gorur")
    public void kullanici_mevcut_gun_ile_ileri_tarihleri_arasindaki_statusu_unapproved_olanlari_gorur() {
        mp.fromDateBoxElement.sendKeys("13/05/2022");
        mp.toDateBoxElement.sendKeys("27/05/2022");

    }

    @Then("Kullanici mevcut gun ile ileri tarihleri arasindaki statusu pending olanlari gorur")
    public void kullanici_mevcut_gun_ile_ileri_tarihleri_arasindaki_statusu_pending_olanlari_gorur() {
        Driver.wait(1);
        Assert.assertTrue(mp.pendingYazisiElement.isDisplayed());
    }

    @Then("Kullanici mevcut gun ile ileri tarihlkeri arasindaki statusu Canceled olanlari gorur")
    public void kullanici_mevcut_gun_ile_ileri_tarihlkeri_arasindaki_statusu_canceled_olanlari_gorur() {
        Driver.wait(1);
        Assert.assertTrue(mp.cancelledwordElementi.isDisplayed());

    }

    @Then("Kullanici patient icin edit e tiklar")
    public void kullanici_patient_icin_edit_e_tiklar() {
        Driver.wait(2);
        mp.editElementidoctorpage.click();
    }

    @Then("Kullanici Create or Edit an Appointment yazisini gorur")
    public void kullanici_create_or_edit_an_appointment_yazisini_gorur() {
        Assert.assertTrue(mp.createElementiyazisi.isDisplayed());
    }

    @Given("Kullanici Anamnesis box i bos biraktiginda This field is required uyari yazisini gormeli")
    public void kullaniciAnamnesisBoxIBosBiraktigindaThisFieldIsRequiredUyariYazisiniGormeli() {
        Driver.wait(2);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mp.anamnesisTextBox.sendKeys("");

        //Assert.assertTrue(mp.thisFieldIsRequiredYazisi.isDisplayed());

    }

    @Then("Kullanici Treatment box i bos biraktiginda This field is required uyari yazisini gormeli")
    public void kullaniciTreatmentBoxIBosBiraktigindaThisFieldIsRequiredUyariYazisiniGormeli() {
        Driver.wait(1);

        mp.treatmentTextBox.sendKeys("");
        //Assert.assertTrue(mp.thisFieldIsRequiredYazisi.isDisplayed());


    }

    @Then("Kullanici Diagnosis box i bos biraktiginda This field is required uyari yazisini gormeli")
    public void kullaniciDiagnosisBoxIBosBiraktigindaThisFieldIsRequiredUyariYazisiniGormeli() {
        mp.diagnosisTextBox.sendKeys("");

        //mp.prescriptionwordElementi.sendKeys("");
        Assert.assertTrue(mp.thisFieldIsRequiredYazisi.isDisplayed());

    }

    @Given("Kullanici {string} box a veri girisi yapabilmeli")
    public void kullaniciBoxAVeriGirisiYapabilmeli(String anamnesis) {
        Driver.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        mp.anamnesisTextBox.sendKeys(anamnesis);

    }

    @Then("Kullanici {string} box a veri girisi yapar")
    public void kullaniciBoxAVeriGirisiYapar(String treatment) {
        mp.treatmentTextBox.sendKeys(treatment);

    }

    @And("Kullanici {string} box a veri girisi yaparsa")
    public void kullaniciBoxAVeriGirisiYaparsa(String diagnosis) {
        mp.diagnosisTextBox.sendKeys(diagnosis);
    }

    @Then("Kullanici save yapar ve succesfully saved yazisini gorur")
    public void kullaniciSaveYaparVeSuccesfullySavedYazisiniGorur() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(1);
        mp.saveDoctorEditPage.click();
        Driver.wait(2);
        Assert.assertTrue(mp.registersavedYazisiElementi.isDisplayed());

    }

    @And("Kullanici statusu cancelled yapar")
    public void kullaniciStatusuCancelledYapar() {
        Driver.wait(1);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(mp.statuswordElementi);
        select.selectByIndex(3);

    }

    //===================salih========================


    @Then("Web Sayfasinda bulunan person ikonuna tiklar.")
    public void web_sayfasinda_bulunan_person_ikonuna_tiklar() {
        MedunnaPage.mainPagePersonIkonuElementi.click();

    }

    @Then("Sign in sekmesine tiklar.")
    public void sign_in_sekmesine_tiklar() {

        Driver.waitAndClick(MedunnaPage.signInLinkiElementi);

    }

    @Then("Username Box'a gecerli {string} girer.")
    public void username_box_a_gecerli_girer(String username) {
        doktorName = username;
        MedunnaPage.usernameBoxElementi.sendKeys(username);

    }

    @Then("Password Box'a gecerli {string} girer.")
    public void password_box_a_gecerli_girer(String password) {
        MedunnaPage.passwordBoxElementi.sendKeys(password);

    }

    @Then("Giris sign in butonuna tiklar.")
    public void girisSignInButonunaTiklar() {
        MedunnaPage.girisSignInButtonElementi.click();

    }

    @Then("Doktor kendi sayfasina basarili sekilde giris yaptigini gorur.")
    public void doktor_kendi_sayfasina_basarili_sekilde_giris_yaptigini_gorur() {
        String actualusername = MedunnaPage.siteyeGirisYapanUsernameElementi.getText();
        Assert.assertEquals(doktorName, actualusername);

    }

    @Then("My Pages sekmesine tiklar.")
    public void my_pages_sekmesine_tiklar() {
        Driver.wait2(1);
        MedunnaPage.myPagesLinkiElementi.click();

    }

    @Then("My Appointments linkine tiklar.")
    public void my_appointments_linkine_tiklar() {

        MedunnaPage.myAppointmentsElementi.click();
    }

    @Then("Test istemek istedigi hasta randevusunu secer.")
    public void test_istemek_istedigi_hasta_randevusunu_secer() {

        List<WebElement> hastaEditListesi = MedunnaPage.hastaEditButonuElementiListesi;
        Driver.wait2(1);
        int secilenEditSirasi = faker.random().nextInt(1, hastaEditListesi.size());

        String dinamikXpath = "(//a[@class='btn btn-primary btn-sm'])[" + secilenEditSirasi + "]";

        Driver.getDriver().findElement(By.xpath(dinamikXpath)).click();
    }

    @Then("Request A Test butonuna tiklar.")
    public void request_a_test_butonuna_tiklar() {
        Driver.wait2(1);
        MedunnaPage.requestATestButonElementi.click();
        Driver.wait2(2);
    }

    @Then("Doktor gerekli testleri secer.")
    public void doktor_gerekli_testleri_secer() {
        Driver.wait(3);
        List<WebElement> testIDListesi = MedunnaPage.testIDListOlusturma();
        List<String> testIDleri = Driver.getElementsText(testIDListesi);
        List<WebElement> secilenCheckbox = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int index = faker.random().nextInt(0, testIDleri.size());

            String ID = testIDleri.get(index);

            //input[@id='1402']
            WebElement dinamikXpath = Driver.getDriver().findElement(By.xpath("//input[@id='" + ID + "']"));

            secilenCheckbox.add(dinamikXpath);
        }
        System.out.println(secilenCheckbox);

        Driver.clickWithJSAsList(secilenCheckbox);
    }

    @Then("Testin ilgili birime gonderilmesi icin save butonuna tiklar.")
    public void testin_ilgili_birime_gonderilmesi_icin_save_butonuna_tiklar() {
        actions.sendKeys(Keys.END).perform();
        Driver.wait2(1);
        MedunnaPage.testSaveButonElementi.click();

    }

    @Then("Test isteginin ilgili birime gonderildigini test eder.")
    public void test_isteginin_ilgili_birime_gonderildigini_test_eder() {
        actions.sendKeys(Keys.PAGE_UP).perform();
        Driver.wait2(2);
        String actualData = MedunnaPage.saveSonrasiUyarielementi.getText();
        String expectedData = "A new Test is created with identifier";

        Driver.wait(2);
        Assert.assertTrue(actualData.contains(expectedData));

    }

    @Then("Acilan sayfadaki testName'ler arasinda  Glucose, Urea, Creatinine, Sodium, Potassium, Total protein, Albumin, Hemoglobin secenekleri oldugunu gorur.")
    public void acilanSayfadakiTestNameLerArasindaGlucoseUreaCreatinineSodiumPotassiumTotalProteinAlbuminHemoglobinSecenekleriOldugunuGorur() {
        Driver.wait2(3);
        List<String> testNameStringList = new ArrayList<>();

        List<WebElement> testNameElementleri = MedunnaPage.testNameListOlustur();

        testNameStringList = Driver.getElementsText(testNameElementleri);

        Driver.wait2(2);

        for (int i = 0; i < 8; i++) {

            Assert.assertTrue(testNameStringList.contains(MedunnaPage.testNameExpectedDataOlustur().get(i)));

        }

    }

    @Then("Doktor kendi sayfasina basarili sekilde giris yaptigini dogrular.")
    public void doktor_kendi_sayfasina_basarili_sekilde_giris_yaptigini_dogrular() {

        Driver.wait2(2);
        String expectedUsername = MedunnaPage.siteyeGirisYapanUsernameElementi.getText();
        expectedUsername = expectedUsername.toLowerCase().replaceAll(" ", "");

        Assert.assertEquals(expectedUsername, doktorName);

    }

    @Then("Test sayfasindan istenilen testlerin checkbox kutusu tiklanir.")
    public void testSayfasindanIstenilenTestlerinCheckboxKutusuTiklanir() {
        //input[@id='1402']
        List<WebElement> secilenCheckbox1 = new ArrayList<>();

        for (int i = 1401; i < 1409; i++) {
            secilenCheckbox1.add(Driver.getDriver().findElement(By.xpath("//input[@id='" + i + "']")));

        }

        Driver.clickWithJSAsList(secilenCheckbox1);
    }

    @Then("Show Test Result'a tiklar.")
    public void showTestResultATiklar() {
        actions.sendKeys(Keys.HOME).perform();
        Driver.wait(2);
        Driver.waitAndClick(MedunnaPage.showTestResultElementi);
    }

    @Then("View Result butonuna tiklar.")
    public void viewResultButonunaTiklar() {
        actions.sendKeys(Keys.HOME).perform();
        Driver.waitAndClick(MedunnaPage.testResultsViewResultsElementi);

    }


    @Then("Doktor Test Result sayfasinda istenilen testlerin TestResultValue sonuclarini gorur.")
    public void doktorTestResultSayfasindaIstenilenTestlerinTestResultValueSonuclariniGorur() {

        List<WebElement> testsBaslikListesi = MedunnaPage.testsSayfasiBaslikListeOlusturma();

        List<String> testBaslikStringListesi = Driver.getElementsText(testsBaslikListesi);
        System.out.println(testBaslikStringListesi);
        Driver.wait2(1);

        for (int i = 0; i < MedunnaPage.testResultValueStringOlustur().size(); i++) {
            Assert.assertTrue(testBaslikStringListesi.contains(MedunnaPage.testResultValueStringOlustur().get(i)));

        }

    }

    @And("Hasta edit sayfasina geri doner")
    public void hastaEditSayfasinaGeriDoner() {
        Driver.getDriver().navigate().back();
        Driver.wait2(1);
        Driver.getDriver().navigate().back();

    }

    @Then("Request Inpatient butonuna tiklar.")
    public void requestInpatientButonunaTiklar() {
        Driver.wait(2);
        MedunnaPage.requestInpatientButonElementi.click();

    }

    @And("Ana sayfaya geri doner.")
    public void anaSayfayaGeriDoner() {
        Driver.wait(2);
        Driver.waitAndClick(MedunnaPage.medunnaLogoElementi);
    }

    @Then("Giris yapilan hesaptan signOut yapar.")
    public void girisYapilanHesaptanSignOutYapar() {
        Driver.waitAndClick(MedunnaPage.cikisIcinSignInLinkiElementi);
        Driver.waitAndClick(MedunnaPage.signOutLinkiElementi);
    }

    @And("Doktor gerekli test {string} secer.")
    public void doktorGerekliTestSecer(String istenenBaslikStr) {

        Driver.wait(3);

        MedunnaPage.testIDListOlusturma();

    }

    @Then("Web uygulamasindan cikis yapar.")
    public void webUygulamasindanCikisYapar() {
        Driver.closeDriver();
    }


    @Then("Test istemek istedigi hasta randevusunu secer")
    public void testIstemekIstedigiHastaRandevusunuSecer() {

        Driver.wait(1);
        MedunnaPage.ikinciSiradakiHastaEditButonu.click();

    }

    // =================== US08_US19_US24_Mustafa =======================
    @Then("Kullanici Sign in sekmesine tiklar.")
    public void kullanici_sign_in_sekmesine_tiklar() {
        mp.homePageSignInLinki.click();
        Driver.wait(2);
    }

    @Then("Kullanici Username Box'a gecerli {string} girerr")
    public void kullanici_username_box_a_gecerli_girerr(String username01) {
        mp.homePageUsernameBox.clear();
        mp.homePageUsernameBox.sendKeys(ConfigurationReader.getProperty("username01"));
    }

    @Then("Kullanici Password Box'a gecerli {string} girer.")
    public void kullanici_password_box_a_gecerli_girer(String SignInValidPassword) {
        mp.homePagePasswordBox.clear();
        mp.homePagePasswordBox.sendKeys(ConfigurationReader.getProperty("SignInValidPassword"));
    }

    @Then("Kullanici Sign in butonuna tiklarr.")
    public void kullanici_sign_in_butonuna_tiklarr() {
        mp.girisSignInButtonElementi.click();
        Driver.wait(2);
    }

    @Then("Kullanici sayfa sag ustte isim ve soyisminin yer aldigi yaziya tiklar")
    public void kullanici_sayfa_sag_ustte_isim_ve_soyisminin_yer_aldigi_yaziya_tiklar() {
        mp.kullaniciIkoniGirisYaptiktanSonra.click();
        Driver.wait2(2);
    }

    @And("Kullanici acilan menuden signOut linkine tiklar")
    public void kullaniciAcilanMenudenSignOutLinkineTiklar() {
        Driver.wait2(2);
        mp.signOutLinki.click();
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullaniciSayfayiKapatir() {
        Driver.getDriver().close();
    }

    @Then("Kullanici acilan menude password yazisina tiklar")
    public void kullanici_acilan_menude_password_yazisina_tiklar() {
        Driver.wait(2);
        Driver.waitAndClick(mp.kullaniciIkonuMenusuAltindakiPasswordYazisi);
        Driver.wait(2);
    }

    @Then("Kullanici acilan sayfadaki Current password kutucuguna mevcut parolayi girer")
    public void kullanici_acilan_sayfadaki_current_password_kutucuguna_mevcut_parolayi_girer() {
        Driver.waitAndClick(mp.passwordDegisikligiIcinGecerliPasswordBox, 1);
        mp.passwordDegisikligiIcinGecerliPasswordBox.sendKeys(ConfigurationReader.getProperty("SignInValidPassword"));
        Driver.wait2(2);
    }

    @Then("Kullanici new password kutucuguna yeni parolayi girer")
    public void kullanici_new_password_kutucuguna_yeni_parolayi_girer() {
        mp.passwordDegisikligiIcinYeniPasswordbox.sendKeys(ConfigurationReader.getProperty("SignInValidPassword"));
        Driver.wait(2);
    }

    @Then("Kullanici Password strength seviyesinin degistigini gorur")
    public void kullaniciPasswordStrengthSeviyesininDegistiginiGorur() {
    }

    @Then("Kullanici new password confirmation kutucuguna yeni parolayi tekrar girer")
    public void kullanici_new_password_confirmation_kutucuguna_yeni_parolayi_tekrar_girer() {
        mp.passwordDegisikligiIcinYeniPasswordConfirmBox.sendKeys(ConfigurationReader.getProperty("SigInNewPassword"));
    }

    @Then("Kullanici save butonuna tiklar")
    public void kullaniciSaveButonunaTiklar() {
        Driver.clickWithJS(mp.passwordDegisikligiIcinSaveButonu);
        Driver.wait(2);
    }

    @Then("Passwordun basarili bir sekilde degistigi gorulur")
    public void passwordun_basarili_bir_sekilde_degistigi_gorulur() {
        Driver.waitForVisibility(mp.passwordDegisikligiBasariliYazisi, 1);
        Assert.assertTrue(mp.passwordDegisikligiBasariliYazisi.isDisplayed());
    }

    @Then("Kullanici acilan sayfadaki Current password kutucuguna {string} girer")
    public void kullaniciAcilanSayfadakiCurrentPasswordKutucugunaGirer(String mevcutPassword) {
        mp.passwordDegisikligiIcinGecerliPasswordBox.click();
        // Driver.clickWithJS( mp.passwordDegisikligiIcinGecerliPasswordBox);
        mp.passwordDegisikligiIcinGecerliPasswordBox.sendKeys(mevcutPassword);
    }

    @Then("Kullanici new password kutucuguna {string} girer")
    public void kullaniciNewPasswordKutucugunaGirer(String yeniParola) {
        Driver.clickWithJS(mp.passwordDegisikligiIcinYeniPasswordbox);
        mp.passwordDegisikligiIcinYeniPasswordbox.sendKeys(yeniParola);
    }

    @Then("Kullanici new password confirmation kutucuguna {string} tekrar girer")
    public void kullaniciNewPasswordConfirmationKutucugunaTekrarGirer(String yeniParola) {
        Driver.clickWithJS(mp.passwordDegisikligiIcinYeniPasswordConfirmBox);
        mp.passwordDegisikligiIcinYeniPasswordConfirmBox.sendKeys(yeniParola);
    }

    @Then("Passwordun degismedigi gorulur")
    public void passwordunDegismedigiGorulur() {
        String expectedData = "An error has occurred! The password could not be changed.";
        String actualDAta = mp.passwordDegisikligiBasarisizYazisi.getText();
        System.out.println(expectedData);
        System.out.println(actualDAta);
        Driver.wait(2);
        Assert.assertEquals(expectedData, actualDAta);
        Driver.wait(2);
    }

    @Then("Kullanici username box'a gecerli {string} girer.")
    public void kullaniciUsernameBoxAGecerliGirer(String username) {
        mp.homePageUsernameBox.click();
        mp.homePageUsernameBox.sendKeys(username);

    }

    @Then("Kullanici password box'a gecerli {string} girer.")
    public void kullaniciPasswordBoxAGecerliGirer(String password) {
        mp.homePageUsernameBox.click();
        mp.homePagePasswordBox.sendKeys(password);
    }

    @Then("Kullanici Web Sayfasinda bulunan person ikonuna tiklar.")
    public void kullanici_web_sayfasinda_bulunan_person_ikonuna_tiklar() {
        Driver.waitAndClick(mp.anaSayfaKullaniciIkonu);
    }

    @Then("Kullanici Sign in sekmesine tiklarr.")
    public void kullanici_sign_in_sekmesine_tiklarr() {
        Driver.waitAndClick(mp.signInlink);
    }

    @Then("Kullanici Username Box'a gecerli {string} girer.")
    public void kullanici_username_box_a_gecerli_girer(String username) {
        mp.usernameBoxElementi.sendKeys(username);
    }

    @Then("Kullanici Password Box'a gecerli {string} girerr.")
    public void kullanici_password_box_a_gecerli_girerr(String password) {
        mp.passwordBoxElementi.sendKeys(password);
    }

    @Then("Kullanici Sign in butonuna tiklar.")
    public void kullanici_sign_in_butonuna_tiklar() {
        mp.signInButonu.click();
    }

    @Then("Kullanici modifiedBy yazisina iki defa tiklar")
    public void kullanici_modified_by_yazisina_iki_defa_tiklar() {


        Driver.waitAndClick(medpage.modifiedByYazisi);
        Driver.waitAndClick(medpage.modifiedByYazisi);
        Driver.wait(3);

    }

    @Then("Kullanici olusturdugu staff i guncellemek icin edite tiklar")
    public void kullanici_olusturdugu_staff_i_guncellemek_icin_edite_tiklar() {

        Driver.clickWithJS(medpage.staffEditYazisi);

    }

    @Then("Kullanici staff bilgilerini gunceller")
    public void kullanici_staff_bilgilerini_gunceller() {

        Driver.wait(3);
        actions.sendKeys(medpage.createOrEditSayfasindakiUserNameTextBox).
                sendKeys(faker.name().username() + Keys.TAB).
                sendKeys(faker.name().firstName() + Keys.TAB).
                sendKeys(faker.name().lastName() + Keys.TAB).
                sendKeys(faker.internet().emailAddress() + Keys.TAB).
                sendKeys(faker.idNumber().ssnValid()).perform();
    }

    @Then("Kullanici login textboxina username girerr")
    public void kullanici_login_textboxina_username_girerr() {

        Driver.wait(2);
        mpage.createANewUserSayfasiloginTextBox.clear();
        mpage.createANewUserSayfasiloginTextBox.sendKeys(faker.name().username());
    }

    @Then("Kullanici firstname textboxina isim girerr")
    public void kullanici_firstname_textboxina_isim_girerr() {

        mpage.createANewUserSayfasifirstnameTextBox.clear();
        mpage.createANewUserSayfasifirstnameTextBox.sendKeys(faker.name().firstName());
    }

    @Then("Kullanici lastname textboxina soyisim girerr")
    public void kullanici_lastname_textboxina_soyisim_girerr() {

        mpage.createANewUserSayfasilastnameTextBox.clear();
        mpage.createANewUserSayfasilastnameTextBox.sendKeys(faker.name().lastName());
    }

    @Given("Kullanici email textboxina email adresi girerr")
    public void kullanici_email_textboxina_email_adresi_girerr() {


        Driver.clickWithJS(mpage.createANewUserSayfasiEmailTextBox);
        mpage.createANewUserSayfasiEmailTextBox.clear();
        mpage.createANewUserSayfasiEmailTextBox.sendKeys(faker.internet().emailAddress());
    }

    @Given("Kullanici ssn textboxina ssn numarasi girerr")
    public void kullanici_ssn_textboxina_ssn_numarasi_girerr() {

        Driver.clickWithJS(mpage.createANewUserSayfasiSSNBox);
        mpage.createANewUserSayfasiSSNBox.clear();
        mpage.createANewUserSayfasiSSNBox.sendKeys(faker.idNumber().ssnValid());
    }

    @Then("Olusturulan kullaniciya rol atamasi yapilirr")
    public void olusturulanKullaniciyaRolAtamasiYapilirr() {
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(mpage.createANewUserSayfasiProfilesDropDownElementi);
        select.selectByIndex(3);
        ReusableMethods.waitFor(2);

    }

    @Then("Kullanici create or edit a user sayfasindaki save butonuna tiklar")
    public void kullanici_create_or_edit_a_user_sayfasindaki_save_butonuna_tiklar() {

        Driver.clickWithJS(mpage.editSayfasiSaveButonu);

    }

    @Then("Staff in guncellendigi yazisi gorulur")
    public void staff_in_guncellendigi_yazisi_gorulur() {

        Driver.wait(2);
        Assert.assertTrue(medpage.staffBasariylaGuncellendiYazisi.isDisplayed());
    }

    @Then("Kullanici olusturdugu staff i goruntulemek icin view yazisina tiklar")
    public void kullanici_olusturdugu_staff_i_goruntulemek_icin_view_yazisina_tiklar() {


        Driver.wait(3);
        // Driver.clickWithJS(medpage.userSayfasiViewYazisi);
        Driver.waitAndClickElement(medpage.userSayfasiViewYazisi, 3);
        Driver.wait(2);

    }

    @Then("Yeni staff olusturuldugu gorulur")
    public void yeniStaffOlusturulduguGorulur() {
        ReusableMethods.waitFor(3);
        Assert.assertTrue(medpage.creatNewUserKullaniciKaydiBasariliYazisi.isDisplayed());
    }

    @Then("Kullanici back komutu ile bir onceki sayfaya geri doner")
    public void kullaniciBackKomutuIleBirOncekiSayfayaGeriDoner() {
        Driver.wait(2);
        Driver.getDriver().navigate().back();
    }

    @Then("Kullanici olusturdugu staff i delete yazisina tiklar")
    public void kullanici_olusturdugu_staff_i_delete_yazisina_tiklar() {
        Driver.clickWithJS(medpage.usersSayfasiDeleteButonu);
    }


    @Then("Kullanici silme islemini Corfirm delete operation yazisinda yer alan delete butonuna basarak onaylar")
    public void kullaniciSilmeIsleminiCorfirmDeleteOperationYazisindaYerAlanDeleteButonunaBasarakOnaylar() {
        Driver.wait(3);
        medpage.usersSayfasiConfirmDeleteButonu.click();
    }

    @Then("Staff in basarili bir sekilde silindigi gorulur")
    public void staff_in_basarili_bir_sekilde_silindigi_gorulur() {
        Driver.wait(2);
        //Assert.assertTrue(medpage.??);

    }


    @Then("Kullanici Username Box'a gecerli {string} girerr.")
    public void kullaniciUsernameBoxAGecerliGirerr(String username02) {
        Driver.wait1(3);   mp.homePageUsernameBox.click();
        mp.homePageUsernameBox.sendKeys(ConfigurationReader.getProperty("username02"));
    }


    @Then("Kullanici MyPages Patient yazisina tiklar.")
    public void kullaniciMyPagesPatientYazisinaTiklar() {
        Driver.wait1(3);        medpage.myPagesPatient.click();
    }

    @Then("Kullanici MyAppointments yazisina tiklar.")
    public void kullaniciMyAppointmentsYazisinaTiklar() {
        Driver.waitAndClickElement(medpage.myAppointmentsPatient,8);
    }

    @Then("Kullanici Show Tests yazisina tiklar")
    public void kullaniciShowTestsYazisinaTiklar() {
        Driver.waitAndClickElement(medpage.patientShowTestsYazisi,5);
    }

    @Then("Kullanici View Results yazisina tiklar")
    public void kullaniciViewResultsYazisinaTiklar() {
        Driver.waitAndClickElement(medpage.patientViewResultsYazisi,5);
    }

    @Then("Kullanici test sonuclarini gorur.")
    public void kullaniciTestSonuclariniGorur() {
        Driver.wait(3);
        Assert.assertTrue(medpage.testResultsID.isDisplayed());
        Assert.assertTrue(medpage.testResultsName.isDisplayed());
        Assert.assertTrue(medpage.testResultsDefaultMinValue.isDisplayed());
        Assert.assertTrue(medpage.testResultsDefaultMaxValue.isDisplayed());
        Assert.assertTrue(medpage.testResultsDescription.isDisplayed());
        Assert.assertTrue(medpage.testResultsDate.isDisplayed());


    }


    //------------------------------Onur US018---------------------------------------
    @When("admin acilan menuden Sign In e tiklar")
    public void admin_acilan_menuden_sign_in_e_tiklar() {
        Driver.wait1(2);
        mp.signInlink.click();
    }

    @When("admin kendi {string} ve {string} girip Sign In butonuna tiklar")
    public void admin_kendi_ve_girip_sign_in_butonuna_tiklar(String userName, String password) {
        Driver.wait1(2);
        mp.userName.sendKeys(userName);
        mp.passWord.sendKeys(password);
        mp.signIn.click();
    }

    @Then("admin sag ust kosede kendi adini gorur")
    public void admin_sag_ust_kosede_kendi_adini_gorur() {
        Driver.wait1(3);
        Assert.assertTrue(mp.recepaltinkaya.isDisplayed());
    }

    @Then("Items&Titles menusu gorunur olmali")
    public void items_titles_menusu_gorunur_olmali() {
        Driver.wait1(2);
        Assert.assertTrue(medpage.itemtitlesMenu.isDisplayed());

    }

    @Then("admin Items&Titles menusune tiklar")
    public void admin_items_titles_menusune_tiklar() {
        Driver.wait1(2);
        medpage.itemtitlesMenu.click();

    }

    @Then("admin Physician'a tiklar")
    public void admin_physician_a_tiklar() {
        Driver.wait1(2);
        medpage.itemtitlesPhysician.click();
    }

    @Then("admin Create a new Physician'a tiklar")
    public void admin_create_a_new_physician_a_tiklar() {
        Driver.wait1(2);
        medpage.CreatPhysician.click();
    }

    @Then("admin SSN Box'a kayitli bir kisinin SSN'nini girer")
    public void admin_ssn_box_a_kayitli_bir_kisinin_ssn_nini_girer() {
        Driver.wait1(2);
        medpage.CreatPhysicianSsn.sendKeys("158-56-9638");
    }

    @Then("admin Use Search CheckBox'a tiklar")
    public void admin_use_search_check_box_a_tiklar() {
        Driver.wait1(2);
        medpage.useSearch.click();
    }

    @Then("admin Search User butonuna tiklar")
    public void admin_search_user_butonuna_tiklar() {
        Driver.wait1(2);
        medpage.searchUserButton.click();
    }

    @Then("admin sol ust kosede User found with search SSN popup'ini gorur")
    public void admin_sol_ust_kosede_user_found_with_search_ssn_popup_ini_gorur() {
        Driver.wait1(5);
        Assert.assertTrue(medpage.solustkosepupop.isDisplayed());
    }

    @Then("admin firstname, lastname, birthname textboxlarini gorebilmeli")
    public void admin_firstname_lastname_birthname_textboxlarini_gorebilmeli() {
        Driver.wait1(2);
        Assert.assertTrue(medpage.firstName.isDisplayed());
        Assert.assertTrue(medpage.lastName.isDisplayed());
        Assert.assertTrue(medpage.birthDate.isDisplayed());
    }

    @Then("admin firstname textboxina {string} girer")
    public void admin_firstname_textboxina_girer(String firstname) {
        Driver.wait1(2);
        medpage.firstName.sendKeys(firstname, Keys.TAB);
    }

    @Then("admin isim icin {string} gorundugunu dogrular")
    public void admin_isim_icin_gorundugunu_dogrular(String uyariyazisi) {
        Driver.wait1(2);
        Assert.assertEquals(uyariyazisi, medpage.textboxaltiuyariyazisi.getText());

    }

    @Then("admin lastname textboxina {string} girer")
    public void admin_lastname_textboxina_girer(String lastname) {
        Driver.wait1(2);
        medpage.lastName.sendKeys(lastname);
    }

    @Then("admin soyisim icin {string} gorundugunu dogrular")
    public void admin_soyisim_icin_gorundugunu_dogrular(String uyariyazisi1) {
        Driver.wait1(3);
        Assert.assertEquals(uyariyazisi1, medpage.textboxaltiuyariyazisi.getText());

    }

    @Then("admin birtdate textboxina {string} girer")
    public void admin_birtdate_textboxina_girer(String birthdate) {
        Driver.wait1(3);
        medpage.birthDate.sendKeys(birthdate, Keys.TAB);
    }

    @Then("admin birthdate icin  {string} gorundugunu dogrular")
    public void admin_birthdate_icin_gorundugunu_dogrular(String uyariyazisi2) {
        Driver.wait1(5);
        Assert.assertEquals(uyariyazisi2, medpage.birtdatetextboxaltiuyariyazisi.getText());
    }

    @Then("admin isim icin uyari yazisi gorunmedigini dogrular")
    public void admin_isim_icin_uyari_yazisi_gorunmedigini_dogrular() {
        Driver.wait1(3);
        Assert.assertTrue(medpage.validformkontrol.isDisplayed());
    }

    @Then("admin soyisim icin uyari yazisi gorunmedigini dogrular")
    public void admin_soyisim_icin_uyari_yazisi_gorunmedigini_dogrular() {
        Driver.wait1(3);
        Assert.assertTrue(medpage.validformkontrol.isDisplayed());
    }

    @Then("admin birthdate icin  uyari yazisi gorunmedigini dogrular")
    public void admin_birthdate_icin_uyari_yazisi_gorunmedigini_dogrular() {
        Driver.wait1(3);
        Assert.assertTrue(medpage.validformkontrol.isDisplayed());
    }

    @Then("admin doktor icin farkli uzmanlik alanlari secebilir")
    public void admin_doktor_icin_farkli_uzmanlik_alanlari_secebilir() {
        // Driver.clickWithJS(medpage.speciality);
        Driver.selectByIndex(medpage.speciality, 1);
        Driver.wait1(3);
        Driver.selectByIndex(medpage.speciality, 2);
        Driver.wait1(3);
        Driver.selectByIndex(medpage.speciality, 3);
        Driver.wait1(3);
        Driver.selectByIndex(medpage.speciality, 3);
    }

    @Then("admin doktorun profil resmini degistirebilir")
    public void admin_doktorun_profil_resmini_degistirebilir() {
        Driver.wait1(5);
    }

    @Then("admin doktorun muayene ucretini girebilmelidir")
    public void admin_doktorun_muayene_ucretini_girebilmelidir() {
        Driver.clickWithJS(medpage.examFee);
        medpage.examFee.clear();
        medpage.examFee.sendKeys("-500");
        Driver.wait1(5);
        medpage.examFee.clear();
        medpage.examFee.sendKeys("1000");
        Driver.wait1(5);
        medpage.examFee.clear();
        medpage.examFee.sendKeys("1500");
        Driver.wait1(5);
    }

    @Then("admin edit'e tiklar")
    public void admin_edit_e_tiklar() {
        Driver.wait(20);
        WebElement editButton = Driver.getDriver().findElement(By.xpath("//a[@href='/physician/10501/edit?page=1&sort=id,asc']"));
        Driver.clickWithJS(editButton);
        Driver.waitAndClick(editButton,15);
    }

    @Then("admin butun doktorlarin bilgilerini gorebilmelidir")
    public void admin_butun_doktorlarin_bilgilerini_gorebilmelidir() {
        Driver.wait1(8);
        for (WebElement each : medpage.doktorbilgileri) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", each);
            Driver.wait1(1);
            each.isDisplayed();
        }
    }

    @Then("admin doktor bilgilerinin duzenlendigini dogrular")
    public void admin_doktor_bilgilerinin_duzenlendigini_dogrular() {
        Driver.waitAndClickElement(mp.saveButtonEditPatientForm, 1);
        Driver.wait(1);
        WebElement newPatientCreatedMessage = Driver.waitForVisibility(mp.allAlertMessages, 2000);
        Assert.assertTrue(newPatientCreatedMessage.isDisplayed());
    }

    @Then("Speciality alanina uzmanlik alani girilir.")
    public void speciality_alanina_uzmanlik_alani_girilir() {
        Driver.selectAnItemFromDropdown(medpage.doktorspeciality, "OPHTHALMOLOGY");
        Driver.wait(1);
    }

    @Then("Exam Fee alanina doktor ucreti girilir.")
    public void exam_fee_alanina_doktor_ucreti_girilir() {
        Driver.clickWithJS(medpage.doktorexamFee);
        medpage.doktorexamFee.clear();
        medpage.doktorexamFee.sendKeys("1000");
    }

    @Then("A Physician is updated mesaji gorunur.")
    public void a_physician_is_updated_mesaji_gorunur() {
        Driver.waitAndClickElement(mp.saveButtonEditPatientForm, 1);
        Driver.wait1(4);
        WebElement newPatientCreatedMessage = Driver.waitForVisibility(mp.allAlertMessages, 2000);
        Assert.assertTrue(newPatientCreatedMessage.isDisplayed());
    }

    @Then("admin delete butonuna tiklar")
    public void admin_delete_butonuna_tiklar() {
        Driver.wait(5);
        WebElement editButton = Driver.getDriver().findElement(By.xpath("//a[@href='/physician/3652/delete?page=1&sort=id,asc']"));
        Driver.clickWithJS(editButton);
        Driver.wait1(4);
        medpage.doktordeletedelete.click();
        Driver.wait1(4);
        medpage.doktordeletedelete.click();
        Driver.wait1(4);
        medpage.doktordeletedelete.click();
    }

    @Then("admin doktorlari silemeyecegini gorur")
    public void admin_doktorlari_silemeyecegini_gorur() {
        Driver.wait1(3);
        String alert = "Internal server error.";
        Assert.assertEquals(alert, medpage.doktordeletealertmessage.getText());
    }

    @Then("admin Administrationa tiklar")
    public void admin_administrationa_tiklar() {
        Driver.wait1(2);
        medpage.administrationLinki.click();
    }

    @Then("admin User managemente tiklar")
    public void admin_user_managemente_tiklar() {
        Driver.wait1(2);
        medpage.usermanagementLinki.click();
        Driver.wait(4);
    }

    @Then("admin kullanicilar arasindan doktor olan kullaniciyi goruntuleyebilir")
    public void admin_kullanicilar_arasindan_doktor_olan_kullaniciyi_goruntuleyebilir() {
        for (int i = 1; i <= 20; i++) {
            WebElement doktor = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + i + "]//td[7]"));
            Driver.clickWithJS(doktor);
            if (doktor.getText().contains("ROLE_PHYSICIAN")) {
                Driver.clickWithJS(medpage.doktorlist.get(i - 1));
                Driver.wait1(5);
                Driver.clickWithJS(mp.backButtonView);
            }
        }
    }

    // ------------------------- KÜBRA US-20 -----------------------------------

    @And("Kullanici administration linkine tiklar")
    public void kullaniciAdministrationLinkineTiklar() {
        Driver.wait(2);
        mpage.administrationLinki.click();
        Driver.wait(1);
    }

    @And("Kullanici user management linkine tiklar")
    public void kullaniciUserManagementLinkineTiklar() {
        mpage.usermanagementLinki.click();
    }

    @Then("Kullanici creat a new user butonuna tiklar")
    public void kullanici_creat_a_new_user_butonuna_tiklar() {
        Driver.wait(2);
        mpage.createANewUserButonu.click();
    }

    @Then("Yeni kullanici olusturmak icin dogru sayfaya gelindigi Create or edit a user yazisinin gorunurlugu ile dogrulanir")
    public void yeni_kullanici_olusturmak_icin_dogru_sayfaya_gelindigi_create_or_edit_a_user_yazisinin_gorunurlugu_ile_dogrulanir() {
        Assert.assertTrue(mpage.createANewUserTexti.isDisplayed());
    }

    @Then("Kullanici login textboxina username girer")
    public void kullanici_login_textboxina_username_girer() {
        mpage.createANewUserSayfasiloginTextBox.sendKeys(faker.name().username());
    }

    @Then("Kullanici firstname textboxina isim girer")
    public void kullanici_firstname_textboxina_isim_girer() {
        mpage.createANewUserSayfasifirstnameTextBox.sendKeys(faker.name().firstName());
    }

    @Then("Kullanici lastname textboxina soyisim girer")
    public void kullanici_lastname_textboxina_soyisim_girer() {
        mpage.createANewUserSayfasilastnameTextBox.sendKeys(faker.name().lastName());
    }

    @Given("Kullanici email textboxina email adresi girer")
    public void kullanici_email_textboxina_email_adresi_girer() {
        mpage.createANewUserSayfasiEmailTextBox.sendKeys(faker.internet().emailAddress());
    }

    @Given("Kullanici ssn textboxina ssn numarasi girer")
    public void kullanici_ssn_textboxina_ssn_numarasi_girer() {
        mpage.createANewUserSayfasiSSNBox.sendKeys(faker.idNumber().ssnValid());
    }

    @Then("Olusturulan kullaniciya rol atamasi yapilir")
    public void olusturulan_kullaniciya_rol_atamasi_yapilir() {
        actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Select select = new Select(mpage.createANewUserSayfasiProfilesDropDownElementi);
        select.selectByIndex(2);
    }

    @Then("Kullanici create a new user sayfasindaki save butonuna tiklar")
    public void kullanici_create_a_new_user_sayfasindaki_save_butonuna_tiklar() {
        mpage.createANewUserSayfasiSaveButonu.click();
    }

    @Then("Kullanici users sayfasinda en sonuncu sayfaya gider")
    public void kullaniciUsersSayfasindaEnSonuncuSayfayaGider() {
        Driver.waitAndClick(mpage.usersSayfasiSonSayfaElementi);
    }

    @And("Kullanici view butonuna basarak olusturdugu hesabin bilgilerini dogrular")
    public void kullaniciViewButonunaBasarakOlusturduguHesabinBilgileriniDogrular() {
        Driver.wait(2);

        Driver.clickWithJS(mpage.viewButonu);
        Driver.wait(2);

        Assert.assertTrue(mpage.hesapdogrulama.isDisplayed());
    }

    @And("Kullanici edit butonuna tiklar gerekli degisiklikleri yapar")
    public void kullaniciEditButonunaTiklarGerekliDegisiklikleriYapar() {

        Driver.wait(2);
        Driver.clickWithJS(mpage.editButtons);
        Driver.wait(2);
        mpage.editSayfasiFirstnameTextBox.clear();
        mpage.editSayfasiFirstnameTextBox.sendKeys(faker.name().firstName());
        Driver.wait(2);
        Driver.clickWithJS(mpage.editSayfasiRole);
        Driver.clickWithJS(mpage.editSayfasiSaveButonu);
    }

    @And("Kullanici silmek istedigi hesabi delete butonuna basarak silme islemini gerceklestirir")
    public void kullaniciSilmekIstedigiHesabiDeleteButonunaBasarakSilmeIsleminiGerceklestirir() {
        Driver.wait(2);
        Driver.clickWithJS(mpage.usersSayfasindakiDeleteButonu);
        Driver.wait(2);
        mpage.alertDeleteButonu.click();
    }

    @And("Kullanici hesabindan cikis yapar")
    public void kullaniciHesabindanCikisYapar() {
        mpage.sagUstHesapIkonu.click();
        Driver.wait1(2);
        mpage.signOutButonu.click();

    }

    @And("Kullanici Contact linkine tiklar")
    public void kullaniciContactLinkineTiklar() {
        Driver.wait(2);
        mpage.contactLinki.click();
    }

    @Then("Contact sayfasinda olundugu dogrulanir")
    public void contactSayfasindaOlunduguDogrulanir() {
        Driver.wait(2);
        Assert.assertTrue(mpage.contactPageCONTACTTexti.isDisplayed());
        Driver.wait(2);
    }

    @Then("Kullanici forma gerekli bilgileri girerek send butonuna tiklar")
    public void kullaniciFormaGerekliBilgileriGirerekSendButonunaTiklar() {
        Actions actions = new Actions(Driver.getDriver());
        Driver.wait(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait(2);
        mpage.contactPageNameTextBox.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                sendKeys(Keys.TAB).
                sendKeys("Test").
                sendKeys(Keys.TAB).
                sendKeys("Test sonucumu göremiyorum.").
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();


    }

///////////////////////////////////////  US26 /////////////////////////////////////////////////////

    @Then("Name textboxi bos birakildiginda cikan Name is required yazisinin gornurlugu test edilmeli")
    public void name_textboxi_bos_birakildiginda_cikan_name_is_required_yazisinin_gornurlugu_test_edilmeli() {
        Actions actions = new Actions(Driver.getDriver());
        Driver.wait(2);
        mpage.contactPageNameTextBox.click();
        Driver.wait(2);
        actions.sendKeys(Keys.TAB).perform();
        //Driver.clickWithJS(mpage.contactPageEmailTextBox);
        Driver.wait(2);
        Assert.assertTrue(mpage.contactPageNameBosBirakildigindaCikanUyariYazisi.isDisplayed());
    }
    //@Then("Name textboxina harflerden olusan bir isim girilmedigi zaman cikan This field is invalid yazisinin gorunurlugu test edilmeli")
    //public void name_textboxina_harflerden_olusan_bir_isim_girilmedigi_zaman_cikan_this_field_is_invalid_yazisinin_gorunurlugu_test_edilmeli() {

    //}
    @Then("Email textboxi bos birakildiginda cikan Your email is required yazisinin gorunurlugu test edilmeli")
    public void email_textboxi_bos_birakildiginda_cikan_your_email_is_required_yazisinin_gorunurlugu_test_edilmeli() {

        mpage.contactPageEmailTextBox.click();
        mpage.contactPageNameTextBox.click();
        Assert.assertTrue(mpage.contactPageEmailBosBirakildigindaCikanUyari.isDisplayed());

    }

    @Then("Email textboxina gecersiz email adresi girilidiginde cikan This field is invalid yazisinin gorunurlugu test edilmeli")
    public void email_textboxina_gecersiz_email_adresi_girilidiginde_cikan_this_field_is_invalid_yazisinin_gorunurlugu_test_edilmeli() {

        mpage.contactPageEmailTextBox.sendKeys("pamukprenses7gmail.com");
        Driver.wait2(2);
        Assert.assertTrue(mpage.contactPageGecersizEmailAdresiGirildigindeCikanUyariYazisi.isDisplayed());

    }

    @Given("Subject textboxi bos birakildiginda cikan This field is required yazisinin gorunurlugu test edilmeli")
    public void subject_textboxi_bos_birakildiginda_cikan_this_field_is_required_yazisinin_gorunurlugu_test_edilmeli() {

        mpage.contactPageSubjectTextBox.click();
        mpage.contactPageEmailTextBox.click();
        Driver.wait2(2);
        Assert.assertTrue(mpage.contactPageSubjectBosBirakildigindaCikanUyari.isDisplayed());

    }

    @Given("Message kutusu bos birakildigi halde send yapilmamali")
    public void message_kutusu_bos_birakildigi_halde_send_yapilmamali() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Driver.wait2(2);
        mpage.contactPageMessageBox.click();
        //mpage.contactPageSAVEButonu.click();
        assertFalse(mpage.contactPageSAVEButonu.isEnabled());
    }

    //___US-16- 17____________________________________Emin____________________________________//
    @Given("Kullanici giris sayfasina gider")
    public void kullanici_giris_sayfasina_gider() {
        Driver.getDriver().get(ConfigurationReader.getProperty("base_url"));

    }

    @Given("Kullanici yonetici olarak oturum acar")
    public void kullanici_yonetici_olarak_oturum_acar() {
        Driver.waitAndClick(mp.loginDropdown);
        Driver.waitAndClick(mp.signDropdown);
        Driver.waitAndSendText(mp.username, "adminTeam93-10");
        Driver.waitAndSendText(mp.password, "adminTeam93-10");
        Driver.waitAndClick(mp.signInButonu);


    }

    @Given("Kullanici Baglantilarim altindaki Oda cta'sini tiklar")
    public void kullanici_baglantilarim_altindaki_oda_cta_sini_tiklar() {
        Driver.waitAndClick(mpage.roomCta);
    }

    @Given("Kullanici Yeni bir oda olustur'u tiklar")
    public void kullanici_yeni_bir_oda_olustur_u_tiklar() {
        Driver.waitAndClick(mpage.createANewRoom);
    }

    @Given("Kullanici oda numarasi alanini bos birakir")
    public void kullanici_oda_numarasi_alanini_bos_birakir() {

    }

    @Given("Kullanici Oda Tipi acilir menusunde TWIN'i secer")
    public void kullanici_oda_tipi_acilir_menusunde_twin_i_secer() {
        Driver.selectAnItemFromDropdown(mpage.roomTypeDropDown, "TWIN");
        Driver.selectAnItemFromDropdown(mpage.roomTypeDropDown, "DELUXE");
        Driver.selectAnItemFromDropdown(mpage.roomTypeDropDown, "TWIN");

    }

    @Given("Kullanici Durum onay kutusuna tiklayarak mevcut durumu ayarlar")
    public void kullanici_durum_onay_kutusuna_tiklayarak_mevcut_durumu_ayarlar() {
        Driver.waitAndClick(mpage.statusCheck);

    }

    @Given("Kullanici fiyat alanini bos birakir")
    public void kullanici_fiyat_alanini_bos_birakir() {
        mpage.priceTextBox.clear();

    }

    @Given("Kullanici aciklama girer")
    public void kullanici_aciklama_girer() {
        Driver.waitAndSendText(mpage.descriptionField, "This is a test room creation by Team93");
    }

    @Given("Kullanici  olusturulma tarihini girer")
    public void kullanici_olusturulma_tarihini_girer() {
        Driver.waitAndSendText(mpage.createdDate, "05/12/2022T03:35 PM");
    }

    @Given("Kullanici  Kaydet dugmesine tiklarr")
    public void kullaniciKaydetDugmesineTiklar() {
        Driver.waitAndClick(mpage.saveButton);
    }

    @Given("This field is required mesaji, gerekli alan metin kutusunun altinda gorunur")
    public void thisFieldIsRequiredMesajiGerekliAlanMetinKutusununAltindaGorunur() {
        Assert.assertTrue(mpage.fieldRequiredRoom.isDisplayed());
        Assert.assertTrue(mpage.fieldRequiredPrice.isDisplayed());
    }

    @Given("Kullanici Verilen oda numarasini girer")
    public void kullaniciVerilenOdaNumarasiniGirer() {
        //mpage.roomNumberTextBox.clear();
        mpage.roomNumberTextBox.sendKeys(faker.number().digits(4));
    }

    @And("Kullanici fiyat girer")
    public void kullaniciFiyatGirer() {
        //Driver.waitAndSendText(mpage.priceTextBox,"500");
        mpage.priceTextBox.sendKeys(faker.number().digits(3));
    }

    @Then("Kullanici , odanin basariyla olusturuldugunu dogrular")
    public void kullaniciOdaninBasariylaOlusturuldugunuDogrular() {
        Driver.wait(1);
        Assert.assertTrue(mpage.roomCreateSuccessMessage.isDisplayed());
    }

    @Given("Kullanici son sayfa dugmesine tiklar")
    public void kullaniciSonSayfaDugmesineTiklar() {
        Driver.waitAndClick(mpage.lastPageArrow);
    }

    @When("Kullanici Duzenle dugmesine tiklar")
    public void kullaniciDuzenleDugmesineTiklar() {
        Driver.waitAndClick(mpage.editButton);
    }

    @And("Kullanici oda numarasını gunceller")
    public void kullaniciOdaNumarasiniGunceller() {
        Driver.wait(3);
        mpage.roomNumberTextBox.clear();
        mpage.roomNumberTextBox.sendKeys(faker.number().digits(5));
    }

    @And("Kullanici oda tipi olarak DELUXE'u secer")
    public void kullaniciOdaTipiOlarakDELUXEUSecer() {
        Driver.selectAnItemFromDropdown(mpage.roomTypeDropDown, "DELUXE");
    }

    @And("Kullanici fiyati gunceller")
    public void kullaniciFiyatiGunceller() {
        mpage.priceTextBox.clear();
        mpage.priceTextBox.sendKeys(faker.number().digits(3));
    }

    @And("Kullanici aciklamayi gunceller")
    public void kullaniciAciklamayiGunceller() {
        mpage.descriptionField.clear();
        Driver.waitAndSendText(mpage.descriptionField, "This is another test make by Team93");
    }

    @And("Kullanici sil dugmesine tiklar")
    public void kullaniciSilDugmesineTiklar() {
        Driver.waitAndClick(mpage.deleteButton);
    }

    @And("Kullanici acilir mesaji silmeyi onaylar")
    public void kullaniciAcilirMesajiSilmeyiOnaylar() {
        Driver.wait(1);
        mpage.confirmDelete.click();
    }

    @Then("Kullanici , odanın basariyla silindigini dogrular")
    public void kullaniciOdaninBasariylaSilindiginiDogrular() {
        Driver.wait(1);
        // Driver.waitForVisibility(roomCreate.roomDeleteSuccessMessage,5);
        Assert.assertTrue(mpage.roomDeleteSuccessMessage.isDisplayed());
        Driver.wait(1);
    }

    @And("Kullanici TestItemi tiklar")
    public void kullaniciTestItemiTiklar() {
        Driver.waitAndClick(mpage.testItem);
    }

    @And("Kullanici createNewTestItem acilir menusunu titular")
    public void kullaniciCreateNewTestItemAcilirMenusunuTitular() {
        //mpage.CreateTestItem.click();
        Driver.wait(2);
        Driver.clickElementByJS(mpage.CreateTestItem);
    }

    @And("Kullanici {string} bir test adi saglar")
    public void kullaniciBirTestAdiSaglar(String testName) {
        //        testItemPage.testName.sendKeys("Team93");
        testName = faker.name().firstName();
        Driver.waitAndSendText(mpage.testNameBox, testName);
    }

    @Then("Kullanici {string} aciklamasini girer")
    public void kullaniciAciklamasiniGirer(String description) {
        mpage.description.sendKeys("mg/ml");
    }

    @And("Kullanici {string} fiyatini girer")
    public void kullaniciFiyatiniGirer(String currentPrice) {
        mpage.price.sendKeys("130");
    }

    @And("Kullanici bir {string} minimum degeri girin")
    public void kullaniciBirMinimumDegeriGirin(String minValue) {
        mpage.minValue.sendKeys("80");
    }

    @And("Kullanici bir maksimum deger {string} girer")
    public void kullaniciBirMaksimumDegerGirer(String maxValue) {
        mpage.maxValue.sendKeys("130");
        mpage.maxValue.clear();
        mpage.maxValue.sendKeys(faker.number().digits(3));
    }

    @Then("Kullanici  Kaydet dugmesine tiklar")
    public void user_clicks_on_save_button() {
        Driver.waitAndClick(mpage.saveButton1);
    }

    @Then("Kullanici ,odanin basariyla kaydedildigini dogrular")
    public void user_verifies_that_saving_is_successful() {
        Driver.wait(3);
        Assert.assertTrue(mpage.savingSuccessMessage.isDisplayed());

    }

    @And("Kullanici last arrow buttonnuna tiklar")
    public void kullaniciLastArrowButtonnunaTiklar() {
        Driver.waitAndClick(mpage.arrowLastItem);
    }

    @And("Kullanici  last itemNumbera tiklar")
    public void kullaniciLastItemNumberaTiklar() {
        mpage.lastFigureItem.click();
    }


    @And("Kullanici TestItemi silmeyi onaylar")
    public void kullaniciTestItemiSilmeyiOnaylar() {
        Driver.wait(3);
        mpage.confirmDeleteButton.click();

    }

    @And("Kullanici yeni bir maksimum deger {string} girer")
    public void kullaniciYeniBirMaksimumDegerGirer(String arg0) {
        mpage.maxValue.clear();
        mpage.maxValue.sendKeys(faker.number().digits(3));

    }

    @Then("Kullanici {string}yeni  aciklama girer")
    public void kullaniciYeniAciklamaGirer(String arg0) {
        mpage.description.sendKeys("mg/ml");

    }

    @And("Kullanici {string}yeni fiyat girer")
    public void kullaniciYeniFiyatGirer(String arg0) {
        mpage.price.clear();
        mpage.price.sendKeys(faker.number().digits(3));
    }

    @And("Kullanici bir {string}yeni minimum deger girer")
    public void kullaniciBirYeniMinimumDegerGirer(String arg0) {
        mpage.minValue.clear();
        mpage.minValue.sendKeys(faker.number().digits(3));
    }

    @Then("Kullanici , odanın basariyla silindigini dogrularr")
    public void kullaniciOdaninBasariylaSilindiginiDogrularr() {
        Driver.wait2(2);
        Assert.assertTrue(mpage.deleteSuccessMessage.isDisplayed());
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Organic US03-US04-US06~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    @Then("Register linkine tiklar.")
    public void register_linkine_tiklar() {
        Driver.wait2(1);
        mpage.registerLinkiElementi.click();

    }

    @Then("Registration sayfasinda oldugunu dogrular.")
    public void registration_sayfasinda_oldugunu_dogrular() {
        Driver.wait2(2);
        assertTrue(mpage.registirationYaziElementi.isDisplayed());
    }

    @Then("SSN text box'un gorulur oldugunu dogrular.")
    public void ssn_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerSSNTextBoxElementi.isDisplayed());
    }

    @Then("SSN text box'un kullnilabilir oldugunu dogrular.")
    public void ssn_text_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerSSNTextBoxElementi.isEnabled());
    }

    @Then("SSN text box'a SSN girer.")
    public void ssn_text_box_a_ssn_girer() {
        String SSNcode = faker.idNumber().ssnValid();
        mpage.registerSSNTextBoxElementi.clear();
        mpage.registerSSNTextBoxElementi.sendKeys(SSNcode);
        System.out.println();
    }

    @Then("First Name text box'un gorulur oldugunu dogrular.")
    public void first_name_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerFirstNameTextBoxElementi.isDisplayed());
    }

    @Then("First Name text box'un kullnilabilir oldugunu dogrular.")
    public void first_name_text_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerFirstNameTextBoxElementi.isEnabled());
    }

    @Then("First Name text box'a First Name girer.")
    public void first_name_text_box_a_first_name_girer() {
        firstName = faker.name().firstName();
        mpage.registerFirstNameTextBoxElementi.clear();
        mpage.registerFirstNameTextBoxElementi.sendKeys(firstName);

    }

    @Then("Last Name text box'un gorulur oldugunu dogrular.")
    public void last_name_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerLastNameTextBoxElementi.isDisplayed());
    }

    @Then("Last Name box'un kullnilabilir oldugunu dogrular.")
    public void last_name_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerLastNameTextBoxElementi.isEnabled());
    }

    @Then("Last Name box'a Last Name girer.")
    public void last_name_box_a_last_name_girer() {
        lastName = faker.name().lastName();
        mpage.registerLastNameTextBoxElementi.clear();
        mpage.registerLastNameTextBoxElementi.sendKeys(lastName);

    }

    @Then("UserName text box'un gorulur oldugunu dogrular.")
    public void user_name_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerUsernameTextBoxElementi.isDisplayed());
    }

    @Then("UserName box'un kullnilabilir oldugunu dogrular.")
    public void user_name_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerUsernameTextBoxElementi.isEnabled());
    }

    @Then("UserName box'a UserName girer.")
    public void user_name_box_a_user_name_girer() {
        userName = faker.name().username();
        mpage.registerUsernameTextBoxElementi.clear();
        mpage.registerUsernameTextBoxElementi.sendKeys(userName);

    }

    @Then("E-mail text box'un gorulur oldugunu dogrular.")
    public void e_mail_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerEmailTextBoxElementi.isDisplayed());
    }

    @Then("E-mail box'un kullnilabilir oldugunu dogrular.")
    public void e_mail_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerEmailTextBoxElementi.isEnabled());
    }

    @Then("E-mail box'a E-mail girer.")
    public void e_mail_box_a_e_mail_girer() {
        email = faker.internet().emailAddress();
        mpage.registerEmailTextBoxElementi.clear();
        mpage.registerEmailTextBoxElementi.sendKeys(email);
    }

    @Then("New Password text box'un gorulur oldugunu dogrular.")
    public void new_password_text_box_un_gorulur_oldugunu_dogrular() {
        assertTrue(mpage.registerFirstPasswordTextBoxElementi.isDisplayed());
    }

    @Then("New Password box'un kullanilabilir oldugunu dogrular.")
    public void new_password_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerFirstPasswordTextBoxElementi.isEnabled());
    }

    @Then("New Password box'a {string} girer.")
    public void new_password_box_a_girer(String firstPassword) {
        mpage.registerFirstPasswordTextBoxElementi.clear();
        mpage.registerFirstPasswordTextBoxElementi.sendKeys(firstPassword);
    }

    @And("Password {string} barindaki renk degisimlerini dogrular.")
    public void passwordBarindakiRenkDegisimleriniDogrular(String strengthColor) {
        String dinamikXpath = "(//li[@style='" + strengthColor + "'])[1]";
        WebElement strength = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        assertTrue(strength.isDisplayed());

    }

    @Then("Confirm the new password text box'un gorulur oldugunu dogrular.")
    public void confirm_the_new_password_text_box_un_gorulur_oldugunu_dogrular() {

        assertTrue(mpage.registerSecondPasswordTextBoxElementi.isDisplayed());
    }

    @Then("Confirm the new password box'un kullnilabilir oldugunu dogrular.")
    public void confirm_the_new_password_box_un_kullnilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerSecondPasswordTextBoxElementi.isEnabled());
    }

    @Then("Confirm the new password box'a {string} girer.")
    public void confirm_the_new_password_box_a_girer(String secondPassword) {
        password = secondPassword;
        Driver.wait2(1);
        mpage.registerSecondPasswordTextBoxElementi.clear();
        mpage.registerSecondPasswordTextBoxElementi.sendKeys(secondPassword);

    }

    @Then("Register butonunun gorunur oldugunu dogrular.")
    public void register_butonunun_gorunur_oldugunu_dogrular() {

        assertTrue(mpage.registerButonElementi.isDisplayed());
    }

    @Then("Register butonunun kullanilabilir oldugunu dogrular.")
    public void register_butonunun_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.registerButonElementi.isEnabled());

    }

    @Then("Register butonuna tiklar.")
    public void register_butonuna_tiklar() {
        mpage.registerButonElementi.submit();
        Driver.wait2(2);
    }

    @Then("Basarili sekilde kayit olusturdugunu dogrular.")
    public void basarili_sekilde_kayit_olusturdugunu_dogrular() {
        assertTrue(mpage.registerBasariliKayitYapildiYaziElementi.isDisplayed());
    }

    @Then("SignIn linkine tiklar.")
    public void sign_in_linkine_tiklar() {
        mpage.signInLinkiElementi.click();
    }

    @Then("SignIn sayfasina gidildigini dogrular.")
    public void sign_in_sayfasina_gidildigini_dogrular() {
        Driver.wait2(1);
        assertTrue(mpage.signInYazisiElementi.isDisplayed());
    }

    @Then("Username TextBox'in gorunur oldugunu dogrular.")
    public void username_text_box_in_gorunur_oldugunu_dogrular() {
        assertTrue(mpage.signInUsernameTextBoxElementi.isDisplayed());
    }

    @Then("Username TextBox'in kullanilabilir oldugunu dogrular.")
    public void username_text_box_in_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInUsernameTextBoxElementi.isEnabled());
    }

    @And("Username TextBox'a username girer.")
    public void usernameTextBoxAUsernameGirer() {
        mpage.signInUsernameTextBoxElementi.clear();
        mpage.signInUsernameTextBoxElementi.sendKeys("prof.dr.salihkaya");
    }

    @Then("Password TextBox'in gorunur oldugunu dogrular.")
    public void password_text_box_in_gorunur_oldugunu_dogrular() {
        assertTrue(mpage.signInPasswordTextBoxElementi.isDisplayed());
    }

    @Then("Password TextBox'in kullanilabilir oldugunu dogrular.")
    public void password_text_box_in_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInPasswordTextBoxElementi.isEnabled());
    }

    @And("Password TextBox'a password girer.")
    public void passwordTextBoxAPasswordGirer() {
        mpage.signInPasswordTextBoxElementi.clear();
        mpage.signInPasswordTextBoxElementi.sendKeys("drsalih");
    }

    @Then("Remember Me yazisinin gorunur oldugunu dogrular.")
    public void remember_me_yazisinin_gorunur_oldugunu_dogrular() {
        assertTrue(mpage.signInRememberMeYaziElementi.isDisplayed());
    }

    @Then("Remember Me checkbox'inin gorunur oldugunu dogrular.")
    public void remember_me_checkbox_inin_gorunur_oldugunu_dogrular() {
        assertTrue(mpage.signInRememberMeButonElementi.isDisplayed());
    }

    @Then("Remember Me checkbox'inin kullanilabilir oldugunu dogrular.")
    public void remember_me_checkbox_inin_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInRememberMeButonElementi.isEnabled());
    }

    @And("Remember Me checkbox'inin secili olmadigini dogrular.")
    public void rememberMeCheckboxIninSeciliOlmadiginiDogrular() {
        Driver.wait2(1);
        assertFalse(mpage.signInRememberMeButonElementi.isSelected());
    }

    @Then("Remember Me checkbox'ini tiklar.")
    public void remember_me_checkbox_ini_tiklar() {
        mpage.signInRememberMeButonElementi.click();
    }

    @Then("Cancel butonunun gorunur oldugunu dogrular.")
    public void cancel_butonunun_gorunur_oldugunu_dogrular() {
        assertTrue(mpage.signInCancelButonElementi.isDisplayed());
    }

    @Then("Cancel butonunun kullanilabilir oldugunu dogrular.")
    public void cancel_butonunun_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInCancelButonElementi.isEnabled());
    }

    @Then("Cancel butonuna tiklar.")
    public void cancel_butonuna_tiklar() {

        mpage.signInCancelButonElementi.click();
    }

    @Then("Did you forget your password linkinin gorunur oldugunu dogrulur.")
    public void did_you_forget_your_password_linkinin_gorunur_oldugunu_dogrulur() {
        assertTrue(mpage.signInDidYouForgetPasswordLinkiElementi.isDisplayed());
    }

    @Then("Did you forget your password linkinin kullanilabilir oldugunu dogrular.")
    public void did_you_forget_your_password_linkinin_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInDidYouForgetPasswordLinkiElementi.isEnabled());
    }

    @Then("Did you forget your password linkine tiklar.")
    public void did_you_forget_your_password_linkine_tiklar() {
        Driver.wait2(1);
        mpage.signInDidYouForgetPasswordLinkiElementi.click();
    }

    @Then("Reset your password sayfasina gidildigini dogrular.")
    public void reset_your_password_sayfasina_gidildigini_dogrular() {
        Driver.wait2(1);
        assertTrue(mpage.resetYourPasswordYaziElementi.getText().contains("Reset your password"));
    }

    @Then("You don't have an account yet? Register a new account linkinin goruldugunu dogrular.")
    public void you_don_t_have_an_account_yet_register_a_new_account_linkinin_goruldugunu_dogrular() {
        assertTrue(mpage.signInRegisterANewAccountLinkiElementi.isDisplayed());
    }

    @Then("You don't have an account yet? Register a new account linkinin kullanilabilir oldugunu dogrular.")
    public void you_don_t_have_an_account_yet_register_a_new_account_linkinin_kullanilabilir_oldugunu_dogrular() {
        assertTrue(mpage.signInRegisterANewAccountLinkiElementi.isEnabled());
    }

    @Then("You don't have an account yet? Register a new account linkine tiklar.")
    public void you_don_t_have_an_account_yet_register_a_new_account_linkine_tiklar() {
        mpage.signInRegisterANewAccountLinkiElementi.click();
    }

    @And("Password {string} barindaki renk degisiminin olmadigini dogrular.")
    public void passwordBarindakiRenkDegisimininOlmadiginiDogrular(String strengthColor) {
        String dinamikXpath = "(//li[@style='" + strengthColor + "'])[1]";
        assertTrue(Driver.getDriver().findElement(By.xpath(dinamikXpath)).isDisplayed());
        Driver.wait2(2);
    }

    @Given("SignIn Username Box'a {string} username girer.")
    public void sign_in_username_box_a_username_girer(String admin) {
        Driver.wait2(2);
        mpage.signInUsernameTextBoxElementi.sendKeys(ConfigurationReader.getProperty("admin"));
    }

    @Given("SignIn Password Box'a Admin {string}  girer.")
    public void sign_in_password_box_a_admin_girer(String adminPassword) {
        Driver.wait2(2);
        mpage.signInPasswordTextBoxElementi.sendKeys(ConfigurationReader.getProperty("adminpassword"));
    }

    @Given("SignIn butonuna tiklar.")
    public void sign_in_butonuna_tiklar() {
        Driver.wait2(2);
        mpage.signInSignInButonuElementi.click();
    }

    @Given("Administration sekmesine tiklar.")
    public void administration_sekmesine_tiklar() {
        Driver.wait2(2);
        mpage.adminAdministrationSekmesiElementi.click();
        Driver.wait2(2);
    }

    @Given("User Manager linkine tiklar.")
    public void user_manager_linkine_tiklar() {
        Driver.wait2(2);
        Driver.waitAndClickElement(mpage.adminUserManagementSekmesiElementi, 5);
    }

    @Given("Users sayfasinda oldugunu dogrular.")
    public void users_sayfasinda_oldugunu_dogrular() {
        Driver.wait2(2);
        assertTrue(mpage.adminUsersYazisi.isDisplayed());
    }

    @Given("En son sayfaya gider.")
    public void en_son_sayfaya_gider() {
        Driver.clickWithJS(mpage.usersSonSayfayaGitElementi);
        Driver.wait2(1);
    }

    @Given("Olusturulan hesabin edit butonuna tiklar.")
    public void olusturulan_hesabin_edit_butonuna_tiklar() {
        Driver.wait2(2);
        WebElement xpath = Driver.getDriver().findElement(By.xpath("//a[@href='/admin/user-management/" + userName + "/edit']"));
        Driver.clickWithJS(xpath);
        Driver.wait2(2);
    }

    @Given("Create or edit a user sayfasinda oldugunu dogrular.")
    public void create_or_edit_a_user_sayfasinda_oldugunu_dogrular() {
        Driver.wait2(2);
        assertTrue(mpage.editCreateaUserYaziElementi.isDisplayed());
    }

    @Given("Activated butonuna tiklar.")
    public void activated_butonuna_tiklar() {
        Driver.wait2(2);
        mpage.adminAdministrationSekmesiElementi.click();
        mpage.editlastnameTextBoxElementi.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

    @Given("Role secer.")
    public void role_secer() {
        new Select(mpage.userEditProfilesDropDownElementi);
        select.selectByValue("ROLE_USER");
    }

    @Given("Editi kaydetmek icin save butonuna tiklar.")
    public void editi_kaydetmek_icin_save_butonuna_tiklar() {
        mpage.usersEditSaveButonuElementi.click();
    }

    @Given("Editin kaydedildigini dogrular.")
    public void editin_kaydedildigini_dogrular() {
        assertTrue(mpage.usersEditBasariliAktiveEdildiYaziElementi.isDisplayed());
    }

    @And("Username Box'a username girer.")
    public void usernameBoxAUsernameGirer() {
        mpage.signInUsernameTextBoxElementi.sendKeys("prof.dr.salihkaya");
    }

    @And("Password Box'a password girer.")
    public void passwordBoxAPasswordGirer() {
        mpage.signInPasswordTextBoxElementi.sendKeys("drsalih");
    }

    @And("Setting sayfa linkine tiklar.")
    public void settingSayfaLinkineTiklar() {
        mpage.signInSettingLinkiElementi.click();
    }

    @And("Hesaba giris yapmak icin signIn butonuna tiklar.")
    public void hesabaGirisYapmakIcinSignInButonunaTiklar() {
        mpage.signInSignInButonuElementi.click();
    }

    @And("Settings sayfasinda oldugunu dogrular.")
    public void settingsSayfasindaOldugunuDogrular() {
        Driver.wait2(2);
        assertTrue(mpage.settingUserSettingYaziElementi.isDisplayed());
    }

    @And("LastName Box'u guncelelr.")
    public void lastnameBoxUGuncelelr() {
        mpage.settingLastNameTextBoxElementi.clear();
        mpage.settingLastNameTextBoxElementi.sendKeys(faker.name().lastName());
    }

    @And("FirstName Box'u gunceller.")
    public void firstnameBoxUGunceller() {
        Driver.wait2(2);
        mpage.settingFirstNameTextBoxElementi.clear();
        mpage.settingFirstNameTextBoxElementi.sendKeys("prof.dr.salihkaya");
    }

    @And("Email Box'u update eder.")
    public void emailBoxUUpdateEder() {
        mpage.settingEmailTextBoxElementi.clear();
        mpage.settingEmailTextBoxElementi.sendKeys(faker.internet().emailAddress());
    }

    @And("Guncellemeleri kaydetmek icin save butonuna tiklar.")
    public void guncellemeleriKaydetmekIcinSaveButonunaTiklar() {
        mpage.settingSaveButonElementi.click();
    }

    @And("Guncellemelerin kaydedildigini dogrular.")
    public void guncellemelerinKaydedildiginiDogrular() {
        Driver.wait2(2);
        assertTrue(mpage.settingBasariliEditlendiYazisi.isDisplayed());
    }

    @And("Hesaptan cikis yapar.")
    public void hesaptanCikisYapar() {
        mpage.settingCikisYapElementi.click();
        mpage.signInsignOutElementi.click();
    }


    //*********************** US_07 MALI ****************************************
    @Given("Kullanici kendisine verilen {string} ve {string} ile sign in yapar ve Patient sayfasina girer")
    public void kullanici_kendisine_verilen_ve_ile_sign_in_yapar_ve_patient_sayfasina_girer(String username1, String password1) {
        mp.anaSayfaKullaniciIkonu.click();
        mp.signInLinki.click();
        mp.signInUsernameTextBox.sendKeys(username1);
        mp.signInPasswordTextBox.sendKeys(password1);
        mp.signInButonu.click();

    }

    @Then("Kullanici Make an Appointment sayfasina gider")
    public void kullanici_make_an_appointment_sayfasina_gider() {
        Driver.wait(2);
        mp.myAppointment.click();
        mp.makeAnAppointmentButonu.click();


    }

    @Then("Kullanici fist name box a gecerli data girer")
    public void kullanici_fist_name_box_a_gecerli_data_girer() {
        mp.makeAnAppointmentFirstNameTextBox.sendKeys("Mehmet");

    }

    @Then("Kullanici SSN e gecerli bir SSN girer")
    public void kullanici_ssn_e_gecerli_bir_ssn_girer() {
        // mp.makeAnAppointmentSSNTextBox.click();
        mp.makeAnAppointmentSSNTextBox.sendKeys("785-98-2156");

    }

    @Then("Kullanici Phone box a gecerli bir numara girer")
    public void kullanici_phone_box_a_gecerli_bir_numara_girer() {
        mp.makeAnAppointmentPhoneTextBox.sendKeys("2365489542");

    }

    @Then("Kullanici Last name gecerli bir data girer")
    public void kullanici_last_name_gecerli_bir_data_girer() {
        mp.makeAnAppointmentLastNameTextBox.sendKeys("Sezgin");

    }

    @Then("Kullanici Email box a gecerli bir email girer")
    public void kullanici_email_box_a_gecerli_bir_email_girer() {
        mp.makeAnAppointmentEmailTextBox.sendKeys("mali@gmail.com");

    }

    @Then("Kullanici Appointment DateTime a gecerli bir tarih girer")
    public void kullanici_appointment_date_time_a_gecerli_bir_tarih_girer() {
        mp.makeAnAppointmentAppointmentDateTextBox.sendKeys("25/08/2022");

    }

    @Then("Kullanici send and appointment request button a tiklar")
    public void kullanici_send_and_appointment_request_button_a_tiklar() {
        mp.sendAnAppointmentRequestButton.click();

    }

    @Then("Kullanici Appintment saved yazisini gorur")
    public void kullanici_appintment_saved_yazisini_gorur() {
        Driver.wait(2);
        softAssert.assertTrue(mp.appointmentSavedYazisiMakeAnAppointmentPage.isDisplayed());
    }

    @Then("API ile kayit dogrulanir")
    public void api_ile_kayit_dogrulanir() {
        String url = "https://medunna.com/make-appointment";
        Response response = given().when().get(url);
        response.prettyPrint();
    }

    @Given("Kullanici fist name bos biraktiginda Your {string} yazisini gorur")
    public void kullanici_fist_name_bos_biraktiginda_your_yazisini_gorur(String string) {
        mp.makeAnAppointmentLastNameTextBox.clear();
        mp.makeAnAppointmentLastNameTextBox.click();
        softAssert.assertTrue(mp.nameIsRequaredYazisiPatientPage.isDisplayed());

    }

    @Then("Kullanici SSN i bos birktiginda {string} yazisini gorur")
    public void kullanici_ssn_i_bos_birktiginda_yazisini_gorur(String string) {
        mp.ssnTextBox.clear();
        mp.ssnTextBox.click();
        softAssert.assertTrue(mp.yourSsnIsRequiredYazisi.isDisplayed());
    }

    @Then("Kullanici Phone bos biraktiginda \"Phone number is required.\"yazisini gorur")
    public void kullanici_phone_bos_biraktiginda_phone_number_is_required_yazisini_gorur() {
        mp.phoneTextbox.clear();
        mp.phoneTextbox.click();
        softAssert.assertTrue(mp.yourPhoneNumberIsRequiredYazisi.isDisplayed());
    }

    @Then("Kullanici last name i bosbiraktiginda Your \"LastName is required. yazisini gorur")
    public void kullaniciLastNameIBosbiraktigindaYourLastNameIsRequiredYazisiniGorur() {
        mp.lastnameTextBox.clear();
        mp.lastnameTextBox.click();
        softAssert.assertTrue(mp.yourLastnameIsRequiredYazisi.isDisplayed());

    }


    @Then("Kullanici email i bos biraktiginda {string} yazisini gorur")
    public void kullanici_email_i_bos_biraktiginda_yazisini_gorur(String string) {
        mp.emailTextBox.clear();
        mp.emailTextBox.click();
        softAssert.assertTrue(mp.yourEmailIsRequiredYazisi.isDisplayed());


    }

    @Then("Kullanici Appintment date bos biraktigin {string} yazisini gorur")
    public void kullanici_appintment_date_bos_biraktigin_yazisini_gorur(String string) {
        mp.makeAnAppointmentAppointmentDateTextBox.sendKeys("dd/mm/yyyy");

        softAssert.assertTrue(mp.yourAppointmentDateIsRequiredYazisi.isDisplayed());

    }

    @Given("Kullanici Gecersiz {string} girdiginda Your SSN is invalid yazisini gormeli")
    public void kullanici_gecersiz_girdiginda_your_ssn_is_invalid_yazisini_gormeli(String SSN) {
        mp.makeAnAppointmentSSNTextBox.sendKeys(SSN);
        softAssert.assertTrue(mp.yourSsnIsInvalidYazisi.isDisplayed());

    }

    @Then("Kullanici gecersiz {string} girdiginde Your phone is invalid yazisini gormeli")
    public void kullanici_gecersiz_girdiginde_your_phone_is_invalid_yazisini_gormeli(String phone) {
        mp.makeAnAppointmentPhoneTextBox.sendKeys(phone);
        softAssert.assertTrue(mp.yourPhoneNumberIsInvalidYazisi.isDisplayed());

    }

    //__________________________  ZEYNEP US09/US21/US22/US23  _________________________//

    @Then("Ust menudeki MY_PAGES menusune tiklanir.")
    public void ust_menudeki_my_pages_menusune_tiklanir() {
        Driver.wait(2);
        mp.myPagesMenu.click();
        Driver.wait(1);
    }

    @Then("Menunun altinda cikan Search Patient item'ina tiklanir.")
    public void menunun_altinda_cikan_search_patient_item_ina_tiklanir() {
        mp.searchPatientItem.click();
        Driver.wait(1);
    }

    @Then("Patients basligi altinda hasta listesi gorunur.")
    public void patients_basligi_altinda_hasta_listesi_gorunur() {
        Assert.assertTrue(mp.patientInfoControl.isDisplayed());
        Driver.wait(2);
    }

    @Then("Staff hasta bilgi satirindaki View butonuna tiklar.")
    public void staff_hasta_bilgi_satirindaki_view_butonuna_tiklar() {
        WebElement viewButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a[@class='btn btn-info btn-sm']"));
        Driver.clickWithJS(viewButton);
    }

    @Then("Patient bilgilerinin altindaki Edit butonuna tiklanir.")
    public void patient_bilgilerinin_altindaki_edit_butonuna_tiklanir() {
        Driver.waitAndClick(mp.editButtonView, 1000);
    }

    @Then("First Name alanina isim girilir.")
    public void first_name_alanina_isim_girilir() {
        //Driver.wait(3);
        mp.firstNameEditTextBox.clear();
        faker = new Faker();
        String firstName = faker.name().firstName();
        Driver.waitAndSendText(mp.firstNameEditTextBox, firstName);
    }

    @Then("Last Name alanina soyisim girilir.")
    public void last_name_alanina_soyisim_girilir() throws InterruptedException {
        mp.lastNameEditTextbox.clear();
        faker = new Faker();
        String lastName = faker.name().lastName();
        Driver.waitAndSendText(mp.lastNameEditTextbox, lastName);
    }

    @Then("Birth Date alanindan dogum tarihi secilir.")
    public void birth_date_alanindan_dogum_tarihi_secilir() {
        mp.birthDateDropbox.clear();
        Driver.waitAndSendText(mp.birthDateDropbox, ("03-12-201200:02:45"));
    }

    @Then("Email alanina email bilgisi girilir.")
    public void email_alanina_email_bilgisi_girilir() throws InterruptedException {
        mp.emailTextbox.clear();
        faker = new Faker();
        String emailAddress = faker.internet().emailAddress();
        Driver.waitAndSendText(mp.emailTextbox, emailAddress);
    }

    @Then("Phone alanina telefon bilgisi girilir.")
    public void phone_alanina_telefon_bilgisi_girilir() {
        mp.phoneTextbox.clear();
        faker = new Faker();
        String phone = "1234567890";
        Driver.waitAndSendText(mp.phoneTextbox, phone);
    }

    @Then("Gender alanina cinsiyet girilir.")
    public void gender_alanina_cinsiyet_girilir() {
        Driver.selectAnItemFromDropdown(mp.genderSelect, "FEMALE");
        Driver.wait(1);
    }

    @Then("Blood Group alanina kan grubu girilir.")
    public void blood_group_alanina_kan_grubu_girilir() {
        Driver.selectAnItemFromDropdown(mp.bloodGroupSelect, "AB+");
        Driver.wait(1);
    }

    @Then("Address alanina adres bilgisi girilir.")
    public void address_alanina_adres_bilgisi_girilir() {
        mp.adressTextBox.clear();
        faker = new Faker();
        String address = faker.address().fullAddress();
        Driver.waitAndSendText(mp.adressTextBox, address);
        Driver.wait(2);
    }

    @Then("Description alanina veri girilir.")
    public void description_alanina_veri_girilir() {
        mp.descriptionTextBox.clear();
        faker = new Faker();
        String description = faker.expression("Patient Info");
        Driver.waitAndSendText(mp.descriptionTextBox, description);
    }

    @Then("User alanindan kullanici secilir.")
    public void user_alanindan_kullanici_secilir() {
        Driver.wait(2);
        Driver.selectAnItemFromDropdown(mp.userSelect, "system");
    }

    @Then("Country alanindan ulke secilir.")
    public void country_alanindan_ulke_secilir() {
        Driver.wait(1);
        Select select = new Select(mp.countrySelect);
        select.selectByIndex(74);
        //Driver.selectAnItemFromDropdown(mp.countrySelect, "Türkiye");
    }

    @Then("State City alanindan sehir secilir.")
    public void state_city_alanindan_sehir_secilir() {
        Driver.selectAnItemFromDropdown(mp.stateCitySelect, "Hawaii");
        Driver.wait(1);
    }

    @Then("Save butonuna tiklanir.")
    public void save_butonuna_tiklanir() {
        Driver.waitAndClickElement(mp.saveButtonEditPatientForm, 1);
    }

    @Then("Back butonuna tiklanir.")
    public void back_butonuna_tiklanir() {
        Driver.waitAndClickElement(mp.backButtonEditPatientForm, 1);
    }

    //_______________________________________________________//
    @Then("Staff hasta bilgi satirindaki Edit butonuna tiklar.")
    public void staff_hasta_bilgi_satirindaki_edit_butonuna_tiklar() {
        WebElement editButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a[@class='btn btn-primary btn-sm']"));
        Driver.clickWithJS(editButton);
    }

    @Then("Create or edit a Patient formu gorunur.")
    public void create_or_edit_a_patient_formu_gorunur() {
        Assert.assertTrue(mp.createOrEditPatientForm.isDisplayed());
        Driver.wait(2);
    }

    @Then("A Patient is Updated mesaji goruntulenir.")
    public void a_patient_is_updated_mesaji_goruntulenir() {
        Assert.assertTrue(mp.patientUpdatedMessage.isDisplayed());
        Driver.wait(8);
    }

    //____________________________________________________________________//
    //US09 / US21
    @Then("Staff Hasta bilgi satirindaki Show Appointments butonuna tiklanir.")
    public void staffHastaBilgiSatirindakiShowAppointmentsButonunaTiklanir() {
        WebElement showAppointmentsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/patient-appointments/74887']"));
        Driver.clickWithJS(showAppointmentsButton);
    }

    @Then("Hasta randevu bilgileri goruntulenir.")
    public void hasta_randevu_bilgileri_goruntulenir() {
        Driver.wait(2);
        Assert.assertTrue(mp.appointmentListText.isDisplayed());
        Driver.wait(2);
    }

    @Then("Hasta bilgi satirindaki Edit butonuna tiklanir.")
    public void hasta_bilgi_satirindaki_edit_butonuna_tiklanir() {
        Driver.wait(1);
        WebElement viewButtonGetirShowAppointments = Driver.getDriver().findElement(By.xpath("//a[@href='/appointment-update/90046']"));
        Driver.clickWithJS(viewButtonGetirShowAppointments);
        Driver.wait(2);
    }

    @Then("Start DateTime alanindan tarih secilir.")
    public void start_date_time_alanindan_tarih_secilir() {
        Driver.wait(1);
        mp.startDateTimeDropBox.clear();
        Driver.waitAndSendText(mp.startDateTimeDropBox, ("06-05-202200:10:50"));
    }

    @Then("End DateTime alanindan tarih secilir.")
    public void end_date_time_alanindan_tarih_secilir() {
        mp.endDateTimeDropBox.clear();
        Driver.waitAndSendText(mp.endDateTimeDropBox, ("07-05-202200:11:50"));
    }

    @Then("Status alaninda statu durumu secilir.")
    public void status_alaninda_statu_durumu_secilir() {
        Driver.selectAnItemFromDropdown(mp.statusSelect, "PENDING");
        Driver.wait(1);
    }

    @Then("Anamnesis alanina veri girilir.")
    public void anamnesis_alanina_veri_girilir() {
        mp.anamnesisTextBox.clear();
        faker = new Faker();
        String anamnesis = faker.expression("Anamnesis Info");
        Driver.waitAndSendText(mp.anamnesisTextBox, anamnesis);
    }

    @Then("Treatment alanina veri girilir.")
    public void treatment_alanina_veri_girilir() {
        mp.treatmentTextBox.clear();
        faker = new Faker();
        String treatment = faker.expression("Treatment Info");
        Driver.waitAndSendText(mp.treatmentTextBox, treatment);
    }

    @Then("Diagnosis alanina veri girilir.")
    public void diagnosis_alanina_veri_girilir() {
        mp.diagnosisTextBox.clear();
        faker = new Faker();
        String diagnosis = faker.expression("Diagnosis Info");
        Driver.waitAndSendText(mp.diagnosisTextBox, diagnosis);
    }

    @Then("Prescription alanina veri girilir.")
    public void prescription_alanina_veri_girilir() {
        mp.prescriptionTextBox.clear();
        faker = new Faker();
        String prescription = faker.expression("Prescription Info");
        Driver.waitAndSendText(mp.prescriptionTextBox, prescription);
    }

    @Then("Appointment Description alanina veri girilir.")
    public void appointment_description_alanina_veri_girilir() {
        mp.descriptionAppointmentTextBox.clear();
        faker = new Faker();
        String description = faker.expression("Description Info");
        Driver.waitAndSendText(mp.descriptionAppointmentTextBox, description);
    }

    @Then("Physician alanindan doktor secimi yapilir.")
    public void physician_alanindan_doktor_secimi_yapilir() {
        Driver.wait(1);
        Driver.selectAnItemFromDropdown(mp.physicianSelect, "70042:zeynep arslan:MEDICAL_GENETICS");
        Driver.wait(2);
    }

    @Then("Hasta Appointment formundaki Save butonuna tiklanir.")
    public void hasta_appointment_formundaki_save_butonuna_tiklanir() {
        Driver.clickWithJS(mp.saveButtonAppointment);
        Driver.wait(1);
    }

    @Then("Hasta Appointment bilgileri guncellenir.")
    public void hasta_appointment_bilgileri_guncellenir() {
        Assert.assertTrue(mp.appointmentIsUpdatedMessage.isDisplayed());
        Driver.wait(2);
    }

    //___________________________________________________________________________//
    @And("Patients basligi altindaki Patient SSN textbox'una SSN numarasi girilir.")
    public void patientsBasligiAltindakiPatientSSNTextboxUnaSSNNumarasiGirilir() {
        Driver.waitAndSendText(mp.patientSSN, "333-22-3333");
        Driver.wait(2);
    }

    @Then("Patient sayfasinda ilgili hasta bilgileri goruntulenir.")
    public void patient_sayfasinda_ilgili_hasta_bilgileri_goruntulenir() {
        WebElement ssn = Driver.getDriver().findElement(By.xpath("//tbody//tr[1]//td[2]"));
        String ssnText = ssn.getText();
        Assert.assertEquals("333-22-3333", ssnText);
        Driver.wait(2);
    }

    //________________________________________________________________________//
    @Then("Menunun altinda cikan In Patient item'ina tiklanir.")
    public void menunun_altinda_cikan_in_patient_item_ina_tiklanir() {
        mp.inPatientItem.click();
    }

    @Then("from textbox'undan tarih secilir")
    public void from_textbox_undan_tarih_secilir() {
        Driver.waitAndSendText(mp.fromDateAppointment, ("04-04-2022"));
    }

    @Then("to textbox'undan tarih secilir")
    public void to_textbox_undan_tarih_secilir() {
        Driver.waitAndSendText(mp.endDateAppointmentTextBox, ("15-04-2022"));
    }

    @Then("In Patient Hasta bilgi satirindaki Edit butonuna tiklanir.")
    public void in_patient_hasta_bilgi_satirindaki_edit_butonuna_tiklanir() {
        WebElement viewButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a"));
        Driver.clickWithJS(viewButton);
        Driver.wait(2);
    }

    @Then("Create or edit a In Patient formu gorunur.")
    public void create_or_edit_a_in_patient_formu_gorunur() {
        WebElement inPatientCreateOrEditText = Driver.waitForVisibility(mp.inPatientCreateOrEditText, 3000);
        Assert.assertTrue(inPatientCreateOrEditText.isDisplayed());
    }

    @Then("Start Date alanindan tarih secilir.")
    public void start_date_alanindan_tarih_secilir() {
        Driver.waitAndSendText(mp.startDateAppointmentTextBox, ("10-04-202200:09:45"));
    }

    @Then("End Date alanindan tarih secilir.")
    public void end_date_alanindan_tarih_secilir() {
        Driver.waitAndSendText(mp.endDateAppointmentTextBox, ("14-04-202200:10:45"));
    }

    @Then("In Patient Description alanina veri girilir.")
    public void in_patient_description_alanina_veri_girilir() {
        Driver.waitAndSendText(mp.descriptionAppointmentInPatientTextBox, ("Description"));
    }

    @Then("Created Date alanindan tarih secilir.")
    public void created_date_alanindan_tarih_secilir() {
        Driver.waitAndSendText(mp.createdDateAppointmentTextBox, ("01-04-202200:08:45"));
    }

    @Then("Status alanindan randevu statusu secilir.")
    public void status_alanindan_randevu_statusu_secilir() {
        Driver.selectAnItemFromDropdown(mp.statusAppointmentSelect, "STAYING");
    }

    @Then("Room alanindan oda secilir.")
    public void room_alanindan_oda_secilir() {
        Driver.selectAnItemFromDropdown(mp.roomSelect, "808:TWIN FULL-UNAVAILABLE");
    }

    @Then("In Patient Save butonuna tiklanir.")
    public void in_patient_save_butonuna_tiklanir() {
        Driver.waitAndClickElement(mp.saveAppointmentButton, 2000);
    }

    @Then("In Patient Hasta bilgisi olusturulur.")
    public void in_patient_hasta_bilgisi_olusturulur() {
        WebElement inPatientNotCreatedAlert = Driver.waitForVisibility(mp.inPatientNotCreatedAlert, 3000);
        Assert.assertTrue(inPatientNotCreatedAlert.isDisplayed());
        Driver.wait(2);
    }

    @Then("In Patient formunda back butonuna tiklanir.")
    public void in_patient_formunda_back_butonuna_tiklanir() {
        Driver.waitAndClickElement(mp.backAppointmentButton, 1000);
    }

    //___________________________________________________________________________//
    @Then("Items Titles menusune tiklanir.")
    public void items_titles_menusune_tiklanir() {
        Driver.waitAndClick(mp.itemsTitlesMenu);
    }

    @Then("Altinda acilan Patient item'ina tiklanir.")
    public void altinda_acilan_patient_item_ina_tiklanir() {
        Driver.waitAndClick(mp.patientItem);
    }

    @Then("Hasta bilgi satirindaki Delete butonuna tiklanir")
    public void hasta_bilgi_satirindaki_delete_butonuna_tiklanir() {
        Driver.wait(1);
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a[@class='btn btn-danger btn-sm']"));
        Driver.clickWithJS(deleteButton);
        Driver.wait(2);
    }

    @Then("Confirm Delete Operation uyarisinda Delete butonuna tiklanir.")
    public void confirm_delete_operation_uyarisinda_delete_butonuna_tiklanir() {
        Driver.waitAndClick(mp.confirmDeleteOperationElement);
        Driver.wait(2);
    }

    @Then("Confirm Delete Operation uyarisinda Cancel butonuna tiklanir.")
    public void confirm_delete_operation_uyarisinda_cancel_butonuna_tiklanir() {
        Driver.waitAndClick(mp.cancelDeleteOperationElement);
        Driver.wait(1);
    }

    @Then("Create a new Patient butonuna tiklanir.")
    public void create_a_new_patient_butonuna_tiklanir() {
        Driver.waitAndClickElement(mp.createNewPatient, 1);
    }

    @Then("New Patient Created mesaji gorunur.")
    public void new_patient_created_mesaji_gorunur() {
        Assert.assertTrue(mp.newPatientCreatedMessage.isDisplayed());
        Driver.wait(2);
    }

    //___________________________________________________________________________//
    @Then("Admin Hasta bilgi satirindaki View butonuna tiklar.")
    public void adminHastaBilgiSatirindakiViewButonunaTiklar() {
        Driver.wait(1);
        WebElement viewButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a[@class='btn btn-info btn-sm']"));
        Driver.clickWithJS(viewButton);
    }

    //___________________________________________________________________________//
    @Then("Admin Hasta bilgi satirindaki Edit butonuna tiklar.")
    public void adminHastaBilgiSatirindakiEditButonunaTiklar() {
        Driver.wait(1);
        WebElement editButton = Driver.getDriver().findElement(By.xpath("//tbody//tr[" + 1 + "]//td//div//a[@class='btn btn-primary btn-sm']"));
        Driver.clickWithJS(editButton);
    }

    //___________________________________________________________________________//
    // US22 / US23
    @Then("Hasta bilgi satirindaki Show Appointments butonuna tiklar.")
    public void hastaBilgiSatirindakiShowAppointmentsButonunaTiklar() {
        WebElement showAppointmentsButton = Driver.getDriver().findElement(By.xpath("//a[@href='/patient-appointments/74887']"));
        Driver.clickWithJS(showAppointmentsButton);
        Driver.wait(1);
    }

    @Then("Hasta bilgi satirindaki Show Tests butonuna tiklanir.")
    public void hasta_bilgi_satirindaki_show_tests_butonuna_tiklanir() {
        Driver.wait(1);
        Driver.waitAndClickElement(mpage.showTestsButtonGetirAppointments, 1);
        Driver.wait(1);
    }

    @Then("Tests basligi goruntulenir.")
    public void tests_basligi_goruntulenir() {
        Assert.assertTrue(mpage.testsHeader.isDisplayed());
        Driver.wait(2);
    }

    @Then("Tests sayfasindaki View Results butonuna tiklanir.")
    public void tests_sayfasindaki_view_results_butonuna_tiklanir() {
        Driver.wait(1);
        Driver.waitAndClick(mpage.viewResultsButtonGetirAppointments);
        Driver.wait(1);
    }

    @And("Test Results sayfasi goruntulenir.")
    public void testResultsSayfasiGoruntulenir() {
        Assert.assertTrue(mpage.testResultsHeader.isDisplayed());
        Driver.wait(2);
    }

    @Then("Test Results sayfasindaki Edit butonuna tiklanir.")
    public void test_results_sayfasindaki_edit_butonuna_tiklanir() {
        Driver.wait(1);
        Driver.waitAndClick(mpage.editButtonGetirTestResults);
        Driver.wait(1);
    }

    @Then("Create or edit a Test Result basligi goruntulenir.")
    public void create_or_edit_a_test_result_basligi_goruntulenir() {
        Assert.assertTrue(mpage.editTestResultHeader.isDisplayed());
        Driver.wait(2);
    }

    @Then("Test Result formunda Result textboxuna veri girilir.")
    public void test_result_formunda_result_textboxuna_veri_girilir() {
        mpage.resultTestTextBox.clear();
        Driver.waitAndSendText(mpage.resultTestTextBox, ("Negative"));
    }

    @Then("Test Result formunda Description textboxuna veri girilir.")
    public void test_result_formunda_description_textboxuna_veri_girilir() {
        mpage.descriptionTestTextBox.clear();
        Driver.waitAndSendText(mpage.descriptionTestTextBox, ("OK"));
    }

    @Then("Test Result sayfasinda Save butonuna tiklanir.")
    public void test_result_sayfasinda_save_butonuna_tiklanir() {
        Driver.wait(1);
        Driver.waitAndClick(mpage.saveButtonGetirTestResult);
        Driver.wait(2);
    }

    @Then("Test Result'in guncellendigi goruntulenir.")
    public void test_result_in_guncellendigi_goruntulenir() {
        // WebElement alert = Driver.waitForVisibility(mpage.testResultUpdatedMessage,1);
        Assert.assertTrue(mpage.testResultUpdatedMessage.isDisplayed());
        Driver.wait(1);
    }

    //___________________________________________________________________________//
    @Then("Staff Patients basligi altindaki Patient SSN textbox'una SSN numarasini girer.")
    public void staff_patients_basligi_altindaki_patient_ssn_textbox_una_ssn_numarasini_girer() {
        Driver.wait(1);
        Driver.waitAndSendText(mp.patientSSN, "333-22-3333");
        Driver.wait(1);
    }

    @And("Staff Patient sayfasinda ilgili hasta bilgileri goruntuler.")
    public void staffPatientSayfasindaIlgiliHastaBilgileriGoruntuler() {
        WebElement ssn = Driver.getDriver().findElement(By.xpath("//tbody//tr//td[2]"));
        String s = ssn.getText();
        System.out.println(s);
        Assert.assertEquals("333-22-3333", s);
        Driver.wait(1);
    }

    @Then("Hasta bilgi satirindaki Payment Invoice Process butonuna tiklanir.")
    public void hastaBilgiSatirindakiPaymentInvoiceProcessButonunaTiklanir() {
        WebElement paymentButton = Driver.getDriver().findElement(By.xpath("//tr[1]//td[13]//a[3]")); //"//a[@href='/payment-detail/76321']"));
        Driver.clickWithJS(paymentButton);
        Driver.wait(1);
    }

    @Then("PAYMENT DETAIL basligi goruntulenir.")
    public void payment_detail_basligi_goruntulenir() {
        Assert.assertTrue(mpage.paymentDetailHeader.isDisplayed());
        Driver.wait(1);
    }

    @Then("Staff muayene ucretini goruntuler.")
    public void staff_muayene_ucretini_goruntuler() {
        Assert.assertTrue(mpage.examFeeText.isDisplayed());
        Driver.wait(1);
    }

    @Then("Staff yapilan Test urun fiyatlarini goruntuler.")
    public void staff_yapilan_test_urun_fiyatlarini_goruntuler() {
        Assert.assertTrue(mpage.testItemFee.isDisplayed());
        Driver.wait(1);
    }

    @Then("Staff toplam ucreti goruntuler.")
    public void staff_toplam_ucreti_goruntuler() {
        Assert.assertTrue(mpage.totalCost.isDisplayed());
        Driver.wait(1);
    }

    @Then("Staff Create Invoice butonuna tiklar.")
    public void staff_create_invoice_butonuna_tiklar() {
        Driver.clickWithJS(mpage.createInvoiceButton);
        Driver.wait(1);
    }

    @Then("Create or edit a Bill formu goruntulenir.")
    public void create_or_edit_a_bill_formu_goruntulenir() {
        Assert.assertTrue(mpage.editBillText.isDisplayed());
        Driver.wait(1);
    }

    @Then("Date textboxuna tarih girilir.")
    public void date_textboxuna_tarih_girilir() {
        Driver.waitAndSendText(mpage.dateBillForm, ("18-04-202200:22:45"));
    }

    @Then("Payment Method secilir.")
    public void payment_method_secilir() {
        Driver.selectAnItemFromDropdown(mpage.paymentMethodSelect, "CREDIT_CARD");
    }

    @Then("Staff, Description alanina veri girer.")
    public void staff_description_alanina_veri_girer() {
        Driver.waitAndSendText(mpage.billDescriptionTextbox, "OK");
    }

    @Then("Staff Save butonuna tiklayarak odemeyi tamamlar.")
    public void staff_save_butonuna_tiklayarak_odemeyi_tamamlar() {
        Driver.clickWithJS(mpage.saveButtonPayment);
        Driver.wait(1);
    }

    @Then("Fatura olusturulur.")
    public void fatura_olusturulur() {
        Assert.assertTrue(mpage.billUpdatedMessage.isDisplayed());
        Driver.wait(1);
    }

    //___________________________________________________________________________//
    @Then("Staff Hasta bilgi satirindaki Payment Invoice Process butonuna tiklar.")
    public void staffHastaBilgiSatirindakiPaymentInvoiceProcessButonunaTiklar() {
        WebElement paymentInvoiceButton = Driver.getDriver().findElement(By.xpath("//a[@href='/payment-detail/74450']"));
        Driver.clickWithJS(paymentInvoiceButton);
        Driver.wait(1);
    }

    @And("Staff PAYMENT DETAIL sayfasini goruntuler.")
    public void staffPAYMENTDETAILSayfasiniGoruntuler() throws IOException {
        Driver.getScreenshot("US23/PaymentDetail");
    }

    @And("Show Invoice butonuna tiklanir.")
    public void showInvoiceButonunaTiklanir() {
        WebElement showInvoiceButton = Driver.getDriver().findElement(By.xpath("//a[@href='/invoice-show/67639']"));
        Driver.clickWithJS(showInvoiceButton);
        Driver.wait(1);
    }

    @And("Fatura goruntulenir.")
    public void faturaGoruntulenir() throws IOException {
        Assert.assertTrue(mpage.invoiceText.isDisplayed());
        Driver.wait(1);
        Driver.getScreenshot("US23/INVOICE");
    }

    @Then("Sign in butonuna tiklar.")
    public void signInButonunaTiklar() {
        Driver.wait2(2);
        mpage.signInSignInButonuElementi.click();
    }

    //_________________________________Onur______________________________________________________//
    @Then("admin Birth Date alanindan dogum tarihi secilir.")
    public void admin_birth_date_alanindan_dogum_tarihi_secilir() {
        mp.birthDateDropbox.clear();
        mp.birthDateDropbox.sendKeys("03-12-2001");
    }

    @Then("admin Description alanina veri girilir.")
    public void admin_description_alanina_veri_girilir() {
        mp.doktordescriptionTextBox.clear();
        String description = faker.expression("Patient Info");
        mp.doktordescriptionTextBox.sendKeys(description);
    }

    @Then("admin User alanindan kullanici secilir.")
    public void admin_user_alanindan_kullanici_secilir() {
        Driver.wait1(1);
        Select select = new Select(mp.userSelect);
        select.selectByIndex(3);
        // Driver.selectAnItemFromDropdown1(mp.userSelect,"user_112233445_56677889991646679075257:787-07-1681");
    }

    @Then("admin State City alanindan sehir secilir.")
    public void admin_state_city_alanindan_sehir_secilir() {
        Driver.wait(2);
        Select select = new Select(mp.stateCitySelect);
        select.selectByIndex(3);
        //Driver.selectAnItemFromDropdown1(mp.stateCitySelect,"Hawaii");
    }

    @Then("admin Save butonuna tiklanir.")
    public void admin_save_butonuna_tiklanir() {
        Driver.wait1(1);
        Driver.clickWithJS(mp.saveButtonEditPatientForm);

    }

    //_________________________________Sezemeyen____________________________________________//

    @Given("Items&Titles menusunden Messages Item'a tiklar.")
    public void ıtems_titles_menusunden_messages_ıtem_a_tiklar() {
        if (mpage.itemsTitlesMessages.isDisplayed()) {
            mpage.itemsTitlesMessages.click();
        } else {
            mp.itemsTitlesMenu.click();
            mpage.itemsTitlesMessages.click();
        }
        Driver.wait1(2);
    }

    @Then("Items&Titles menusunden Messages Item'a tiklar")
    public void ıtemsTitlesMenusundenMessagesItemATiklar() {
        mpage.itemsTitlesMessages.click();
    }

    @Given("Admin tum mesajlarin gorunur oldugunu dogrular")
    public void admin_tum_mesajlarin_gorunur_oldugunu_dogrular() {
        Driver.wait(2);

        for (int i = 1; i <= 3; i++) {
            Driver.wait1(2);
            String viewXpath = "(//a[@class='btn btn-info btn-sm'])[" + i + "]";

            String idXpath = "(//a[@class='btn btn-link btn-sm'])[" + i + "]";
            WebElement firstMessageId = Driver.getDriver().findElement(By.xpath(idXpath));
            String idNumber = firstMessageId.getText();

            String nameXpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/div/div/table/tbody/tr[" + i + "]/td[2]";
            WebElement firstMessageName = Driver.getDriver().findElement(By.xpath(nameXpath));
            String name = firstMessageName.getText();

            String emailXpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/div/div[1]/table/tbody/tr[" + i + "]/td[3]";
            WebElement firstMessageEmail = Driver.getDriver().findElement(By.xpath(emailXpath));
            String email = firstMessageEmail.getText();

            WebElement messageViewButton = Driver.getDriver().findElement(By.xpath(viewXpath));
            messageViewButton.click();

            String messageIdXpath = "//h2//b[text()='" + idNumber + "']";
            Driver.wait1(2);
            WebElement messageId = Driver.getDriver().findElement(By.xpath(messageIdXpath));

            String messageNameXpath = "//dd[text()='" + name + "']";
            WebElement messageName = Driver.getDriver().findElement(By.xpath(messageNameXpath));

            String messageEmailXpath = "//dd[text()='" + email + "']";
            WebElement messageEmail = Driver.getDriver().findElement(By.xpath(messageEmailXpath));

            Driver.wait1(2);
            assertTrue(messageId.isDisplayed());
            assertTrue(messageName.isDisplayed());
            assertTrue(messageEmail.isDisplayed());

            Driver.getDriver().navigate().back();
            Driver.wait1(2);
        }
    }
    @Given("Admin Create A New Message butonuna tiklar.")
    public void admin_create_a_new_message_butonuna_tiklar() {
        mpage.createANewMessageButton.click();
    }

    @Given("Admin Name Textbox'a {string}, Email TextBox'a {string}, Subject TextBox'a {string}, Message TextBox'a {string} girer.")
    public void admin_name_textbox_a_email_text_box_a_subject_text_box_a_message_text_box_a_girer(String name, String y, String z, String q) {

        x= faker.name().fullName();
        y= faker.internet().emailAddress();
        z= faker.gameOfThrones().dragon();
        q= faker.lorem().characters(15,45);

        mpage.CreateOrEditAMessageNameTextBox.sendKeys(x);
        mpage.CreateOrEditAMessageEmailTextBox.sendKeys(y);
        mpage.CreateOrEditAMessageSubjectTextBox.sendKeys(z);
        mpage.CreateOrEditAMessageMessageTextBox.sendKeys(q);
    }

   @Given("Admin Create or edit a Message sayfasindaki save butonuna tiklar.")
    public void admin_create_or_edit_a_message_sayfasindaki_save_butonuna_tiklar() {
        //Driver.wait1(3);
        Driver.clickWithJS(mpage.CreateOrEditAMessageSaveButton);
    }
    @Given("Admin Create or edit a Message sayfasindaki ID butonuna basar.")
    public void admin_create_or_edit_a_message_sayfasindaki_ıd_butonuna_basar() {
        Driver.wait1(3);
        mpage.messageID.click();
    }
    @Given("Admin olusturdugu mesajin kaydedildigini dogrular.")
    public void admin_olusturdugu_mesajin_kaydedildigini_dogrular() {
        Driver.wait1(3);
        assertEquals(x,mpage.firstMessageName.getText());
    }
    @Given("Admin ilk mesajin Edit butonuna tiklar.")
    public void admin_ilk_mesajin_edit_butonuna_tiklar() {
        Driver.wait1(3);
        mpage.firstEditButton.click();
    }
    @Given("Admin Create or edit a Message sayfasindaki Name Textbox'a isim girer.")
    public void admin_create_or_edit_a_message_sayfasindaki_name_textbox_a_isim_girer() {
        Driver.wait1(3);
        mpage.CreateOrEditAMessageNameTextBox.clear();
        newName=faker.name().fullName();
        mpage.CreateOrEditAMessageNameTextBox.sendKeys(newName);
    }
    @Given("Admin Create or edit a Message sayfasindaki ilk mesajin isminin guncellenmis oldugunu dogrular.")
    public void admin_create_or_edit_a_message_sayfasindaki_ilk_mesajin_isminin_guncellenmis_oldugunu_dogrular() {
        Driver.wait(3);
        Driver.getDriver().navigate().refresh();
        Driver.wait1(3);
        assertEquals(newName,mpage.firstMessageName.getText());
    }
    @Given("Admin ilk mesajin Delete butonuna tiklar.")
    public void admin_ilk_mesajin_delete_butonuna_tiklar() {
        Driver.wait1(3);
        firstMessageID= mpage.itemsTitlesFirstMessageID.getText();
        mpage.firstDeleteButton.click();
    }
    @Given("Admin mesaji silmek icin Delete butonuna tiklar.")
    public void admin_mesaji_silmek_icin_delete_butonuna_tiklar() {
        Driver.wait1(3);
        mpage.messageDeleteConfirmationButton.click();
    }
    @Given("Admin mesajin silindigini dogrular.")
    public void admin_mesajin_silindigini_dogrular() {
        Driver.wait(3);
        String expectedMessageAlertText = "A Message is deleted with identifier "+firstMessageID;
        assertEquals(expectedMessageAlertText,mpage.messageDeletedAlert.getText());
    }
    @Given("Kullanici menuden signOut tiklar.")
    public void kullanici_menuden_signOut_tiklar() {
        Driver.wait1(3);
        mpage.signOutLinki.click();
    }

    @Then("Kullanici Show Invoice yazisina tiklar")
    public void kullaniciShowInvoiceYazisinaTiklar() {
        Driver.waitAndClickElement(medpage.showInvoiceYazisi,5);
    }
    @Then("Fatura olusturuldugu gorulur")
    public void faturaOlusturulduguGorulur() {
        Driver.wait(2);
        Assert.assertTrue(medpage.invoiceText.isDisplayed());
    }

    //========================Sezen======================================

    @Given("Items&Titles menusunden Country Item'a tiklar.")
    public void ıtems_titles_menusunden_country_ıtem_a_tiklar() {
        mpage.adminItemsTitlesCountryElementi.click();
    }
    @Given("Countries sayfasinda oldugunu dogrular.")
    public void countries_sayfasinda_oldugunu_dogrular() {
        assertTrue(mpage.countryCountriesYazisiElementi.isDisplayed());
    }
    @Given("Create A New Country sekmesine tiklar.")
    public void create_a_new_country_sekmesine_tiklar() {
        mpage.countryCreateAnewCountryElementi.click();
    }
    @Given("Create or edit a Country sayfasinda oldugunu dogrular.")
    public void create_or_edit_a_country_sayfasinda_oldugunu_dogrular() {
        assertTrue(mpage.countryCreateOrEditACountryYazisiElementi.isDisplayed());
    }
    @Given("Name Text Box'a Country ismini girer")
    public void name_text_box_a_country_ismini_girer() {
        mpage.countryCreateNameTextBoxElementi.clear();
        mpage.countryCreateNameTextBoxElementi.sendKeys(faker.name().name());
    }
    @Given("Created Date Text Box'a tarihi girer.")
    public void created_date_text_box_a_tarihi_girer() {
        mpage.countryCreateCreatedDateTextBoxElementi.clear();

        DateTimeFormatter dtftarih=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate tarih=LocalDate.now();
        String tarihformatli=dtftarih.format(tarih);
        LocalTime saat=LocalTime.now();
        DateTimeFormatter dtfsaat=DateTimeFormatter.ofPattern("HH:mm");
        String saatformatli=dtfsaat.format(saat);
        mpage.countryCreateCreatedDateTextBoxElementi.sendKeys((tarihformatli+saatformatli));


    }
    @Given("Create tamamlamak icin Save butonuna tiklar.")
    public void create_tamamlamak_icin_save_butonuna_tiklar() {

        mpage.countryCreateSaveButonuElementi.click();
    }

    @Given("Basarili sekilde create yapildigini dogrular.")
    public void basarili_sekilde_create_yapildigini_dogrular() {
        Driver.wait(2);
        assertTrue(mpage.countryCreateBasariliSaveYazisiElementi.isDisplayed());
        System.out.println(mpage.countryCreateBasariliSaveYazisiElementi.getText());
        String str=mpage.countryCreateBasariliSaveYazisiElementi.getText();
        String id= str.replaceAll("\\D","");
        System.out.println(id)
        ;
        countryID=id;
        System.out.println(countryID);


    }

    @Given("admin Items&Titles menusune tiklar.")
    public void admin_ıtems_titles_menusune_tiklar() {
        Driver.wait(3);
        mpage.adminItemsTitlesElementi.click();
    }

    @Given("Silmek istedigi country'i secer.")
    public void silmek_istedigi_country_i_secer() {
        Driver.wait(5);
        //actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        String dinamikXpath="//a[@href='/country/"+countryID+"/delete']";
        WebElement delete= Driver.getDriver().findElement(By.xpath(dinamikXpath));

        Driver.clickElementByJS(delete);
    }

    @Given("Country'nin silindigini dogrular.")
    public void country_nin_silindigini_dogrular() {
        Driver.wait1(3);
        assertTrue(mpage.countryBasariliDeleteYazisiElementi.isDisplayed());
    }

    @Given("Silmeyi onaylamak icin Confirm Delete butonuna tiklar.")
    public void silmeyi_onaylamak_icin_confirm_delete_butonuna_tiklar() {
        Driver.wait1(3);
        mpage.countryConfirmDeleteButtonuElemeneti.click();
        Driver.wait1(3);
        if(!mpage.countryBasariliDeleteYazisiElementi.getText().contains("A Country is deleted with identifier ")){
            mpage.countryConfirmDeleteButtonuElemeneti.click();
        } // van more time
    }

    @Given("Hesaptan cikis yapar")
    public void hesaptan_cikis_yapar() {
        mpage.countryAdminSekmesiElementi.click();
        mpage.signInsignOutElementi.click();
    }
    
    
}


