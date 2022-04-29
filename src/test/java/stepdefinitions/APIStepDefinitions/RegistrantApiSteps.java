package stepdefinitions.APIStepDefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.US001_Pojo.RegisterPojo;
import pojos.US001_Pojo.RegisterPostPojo;
import static io.restassured.RestAssured.*;

import pojos.US027_Pojo.Message;
import utilities.ConfigurationReader;
import pojos.US017_Pojo.CreateUpdateDeleteTestItem;
import pojos.US016_Pojo.RoomCreateUpdateDelete;
import utilities.Driver;

import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static utilities.ApiUtils.*;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.*;
import static utilities.ReadTxt.getApiTestItemNames;
import static utilities.WriteToTxt.*;
import static utilities.WriteToTxt.saveAllTestItems;

public class RegistrantApiSteps {

    RegisterPojo registerpojo;
    RegisterPostPojo actualData;
    Faker faker = new Faker();
    Response response;
    RequestSpecification spec;
    Hooks hooks=new Hooks();
    static String login,lastName,password,name,subject;
    public static String firstName,ssn,email,message;
    Message mespojo;
    Message actualMessageData;



    RoomCreateUpdateDelete room = new RoomCreateUpdateDelete();
    RoomCreateUpdateDelete[] roomCreateUpdateDelete;
    CreateUpdateDeleteTestItem createUpdateDeleteTestItem = new CreateUpdateDeleteTestItem();
    CreateUpdateDeleteTestItem[] createUpdateDeleteTestItems;

    // ------------------------- KÜBRA US01 & US02 -----------------------------------

    @When("Kullanici kayitli kisiler olusturmak icin gerekli pathparams girer")
    public void kullaniciKayitliKisilerOlusturmakIcinGerekliPathparamsGirer() {
        Hooks.spec.pathParams("p1", "api", "p2", "register");

    }

    @Then("Kullanici hesap olusturur")
    public void kullaniciHesapOlusturur() {
        login=faker.name().username();
        firstName=faker.name().firstName();
        lastName=faker.name().lastName();
        ssn=faker.idNumber().ssnValid();
        email=faker.internet().emailAddress();
        password=faker.internet().password(7,8,true,true);

        registerpojo=new RegisterPojo(login,firstName,lastName,ssn,email,password,"en");

        response=given().spec(Hooks.spec).contentType(ContentType.JSON).body(registerpojo).when().post("/{p1}/{p2}");
    }
    @And("Kullanici almis oldugu bilgilerin dogrulamasini yapar")
    public void kullaniciAlmisOlduguBilgilerinDogrulamasiniYapar() {

        actualData=response.as(RegisterPostPojo.class);

        Assert.assertEquals(201,response.getStatusCode());
        Assert.assertEquals(registerpojo.getLogin(),actualData.getLogin());
        Assert.assertEquals(registerpojo.getFirstName(),actualData.getFirstName());
        Assert.assertEquals(registerpojo.getLastName(),actualData.getLastName());
        Assert.assertEquals(registerpojo.getSsn(),actualData.getSsn());
        Assert.assertEquals(registerpojo.getEmail(),actualData.getEmail());
        Assert.assertEquals("en",actualData.getLangKey());
    }

    @Then("Emaili api ile dogrular")
    public void Emaili_api_ile_dogrular() {
        actualData=response.as(RegisterPostPojo.class);
        Assert.assertEquals(registerpojo.getEmail(),actualData.getEmail());
    }

    // -------------------------Mehmet Emin -----------------------------------
    //================================US-16=Rooms Items Get Request=================

    @Given("Kullanici oda olusturmak icin path paramslari ayarlar")
    public void kullaniciOdaOlusturmakIcinPathParamslariAyarlar() {
        Hooks.spec.pathParams("first","api","second","rooms");
        //spec.pathParams("first","api","second", "rooms");
    }

    @When("Kullanici Yeni bir oda olusturmak için beklenen verileri ayarlar")
    public void kullaniciYeniBirOdaOlusturmakIcinBeklenenVerileriAyarlar() {
        room.setCreatedBy("admin79");
        room.setDescription("this is a test description");
        room.setPrice(faker.number().numberBetween(5000, 10000));
        room.setRoomNumber(faker.number().numberBetween(5000, 7000));
        room.setRoomType("DELUXE");
        room.setStatus(true);
    }

    @When("Kullanici post istegi gonderir ve bir oda olustumak icin yanit alir")
    public void kullaniciPostIstegiGonderirVeBirOdaOlustumakIcinYanitAlir() {
        response = postRequestRoom(generateToken(), ConfigurationReader.getProperty("room_endpoint"), room);
        //  response.prettyPrint();

    }

    @And("Kullanici oda kayitlari ile ilgili dosyalari kaydeder")
    public void kullaniciOdaKayitlariIleIlgiliDosyalariKaydeder() {
        saveRoomData(room);

    }

    @Then("Kullanici oda dogrulamasi yapar")
    public void kullaniciOdaDogrulamasiYapar() throws IOException {
        response.then().statusCode(201);
        ObjectMapper obj = new ObjectMapper();
        RoomCreateUpdateDelete actualData = obj.readValue(response.asString(),RoomCreateUpdateDelete.class);

        assertEquals(room.getCreatedBy(),actualData.getCreatedBy());
        assertEquals(room.getDescription(), actualData.getDescription());
        assertEquals(room.getPrice(), actualData.getPrice());
        assertEquals(room.getRoomNumber(), actualData.getRoomNumber());
        assertEquals(room.getRoomType(), actualData.getRoomType());
        assertEquals(room.isStatus(), actualData.isStatus());

    }

    @Given("Kullanici oda verilerini okumak icin get istegi gonderir")
    public void kullaniciOdaVerileriniOkumakIcinGetIstegiGonderir() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("room_endpoint"));
//        response.prettyPrint();
    }

    @And("Kullanici oda verilerini deserializes eder")
    public void kullaniciOdaVerileriniDeserializesEder() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        roomCreateUpdateDelete = obj.readValue(response.asString(),RoomCreateUpdateDelete[].class);

    }

    @And("Kullanici oda verilerini correspondent dosyasina kaydeder")
    public void kullaniciOdaVerileriniCorrespondentDosyasinaKaydeder() {
        saveAllRoomData(roomCreateUpdateDelete);

    }


    @Then("Kullanici validates yeni olusturulan oda kayitlarini Api ile dogrular")
    public void kullaniciValidatesYeniOlusturulanOdaKayitlariniApiIleDogrular() {
        List<String> expectedRoomData = getRoomData();
        System.out.println("expected:"+ expectedRoomData);
        List<String> actualRoomData = getApiRoomData();
        System.out.println("actual: "+actualRoomData);
        Assert.assertTrue(actualRoomData.containsAll(expectedRoomData));
    }


    //----------------------------------------------------------------------

    @Given("Kullanici test ogesi olusturmak icin path parametrelerini ayarlar")
    public void kullaniciTestOgesiOlusturmakIcinPathParametreleriniAyarlar() {
        Hooks.spec.pathParams("first", "api", "second", "c-test-items");
    }

    @And("Kullanici test ogesi icin beklenen verileri ayarlar")
    public void kullaniciTestOgesiIcinBeklenenVerileriAyarlar() {

        createUpdateDeleteTestItem.setName(faker.name().firstName() + " test");
        createUpdateDeleteTestItem.setDescription("mg/mL");
        createUpdateDeleteTestItem.setPrice(faker.number().numberBetween(100, 150) + "");
        createUpdateDeleteTestItem.setDefaultValMin("80");
        createUpdateDeleteTestItem.setDefaultValMax("130");
    }

    @And("Kullanici test ogesi icin post istegi gonderir ve yanit alir")
    public void kullaniciTestOgesiIcinPostIstegiGonderirVeYanitAlir() {
        response = postRequestTestItem(generateToken(), ConfigurationReader.getProperty("testItem_endpoint"), createUpdateDeleteTestItem);
        response.prettyPrint();

    }

    @And("Kullanici test ogesi kayitlarini kaydeder")
    public void kullaniciTestOgesiKayitlariniKaydeder() {
        saveTestItemInfo(createUpdateDeleteTestItem);
    }

    @Then("Kullanici test ogesi kayitlarinin dogrulamasi Api ile yapar")
    public void kullaniciTestOgesiKayitlarininDogrulamasiApiIleYapar() throws IOException {
        response.then().statusCode(201);

        ObjectMapper obj = new ObjectMapper();
        CreateUpdateDeleteTestItem actualCreateUpdateDeleteTestItem = obj.readValue(response.asString(), CreateUpdateDeleteTestItem.class);

        assertEquals(createUpdateDeleteTestItem.getName(), actualCreateUpdateDeleteTestItem.getName());
        assertEquals(createUpdateDeleteTestItem.getDescription(), actualCreateUpdateDeleteTestItem.getDescription());
        assertEquals(createUpdateDeleteTestItem.getPrice(), actualCreateUpdateDeleteTestItem.getPrice());
        assertEquals(createUpdateDeleteTestItem.getDefaultValMin(), actualCreateUpdateDeleteTestItem.getDefaultValMin());
        assertEquals(createUpdateDeleteTestItem.getDefaultValMax(), actualCreateUpdateDeleteTestItem.getDefaultValMax());
    }

    //=================================US-17-Test Items Get Request=============================================
    @Given("Kullanici test ogesi verileri icin get istegi gonderir")
    public void kullaniciKullaniciTestOgesileriVerileriIcinGetIstegiGonderir() {

        response = getRequest(generateToken(), ConfigurationReader.getProperty("testItem_endpoint"));
        //response.prettyPrint();
    }

    @And("Kullanici test ogesileri  verilerini deserialize eder")
    public void kullaniciTestOgesileriVerileriniDeserializeEder() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        createUpdateDeleteTestItems = obj.readValue(response.asString(), CreateUpdateDeleteTestItem[].class);

    }

    @And("Kullanici test ogesileri verilerini correspondent dosyasina kaydeder")
    public void kullaniciTestOgesileriVerileriniCorrespondentDosyasinaKaydeder() {
        saveAllTestItems(createUpdateDeleteTestItems);
    }

    @Then("Kullanici validates test ogeseleri kayitlarini Api ile dogrular")
    public void kullaniciValidatesTestOgeseleriKayitlariniApiIleDogrular() {
        List<String> expectedData = getTestItemNames();
        System.out.println("expected:"+ expectedData);
        List<String> actualTestItems = getApiTestItemNames();
        System.out.println("actual: "+actualTestItems);
        Assert.assertTrue(actualTestItems.containsAll(expectedData));

    }

    //----------------------------Sazan-------------------

    @Given("Kullanici mesaj olusturmak icin gerekli pathParams girer.")
    public void kullanici_mesaj_olusturmak_icin_gerekli_path_params_girer() {
       Hooks.spec.pathParams("pp1","api","pp2","c-messages");
    }
    @Given("Kullanici mesaj olusturmak icin gerekli Request Body hazirlar.")
    public void kullanici_mesaj_olusturmak_icin_gerekli_request_body_hazirlar() {
        name = faker.name().fullName();
        email = faker.internet().emailAddress();
        subject = faker.lorem().sentence(3);
        message = faker.lorem().paragraph();

        mespojo = new Message(name,email,subject,message);

    }
    @Given("Kullanici gonderdigi mesajin dogrulamasini yapar.")
    public void kullanici_gonderdigi_mesajin_dogrulamasini_yapar() {

        String token = Driver.generateToken();

        response= given().spec(Hooks.spec).headers(
                "Authorization",
                "Bearer " + token).contentType(ContentType.JSON).body(mespojo).when().post("/{pp1}/{pp2}");

        response.prettyPrint();
        actualMessageData = response.as(Message.class);

        assertEquals(201,response.getStatusCode());
        assertEquals(mespojo.getName(),actualMessageData.getName());
        assertEquals(mespojo.getEmail(),actualMessageData.getEmail());
        assertEquals(mespojo.getSubject(),actualMessageData.getSubject());
        assertEquals(mespojo.getMessage(),actualMessageData.getMessage());
    }


}
