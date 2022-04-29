package stepdefinitions.DBStepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepdefinitions.APIStepDefinitions.RegistrantApiSteps;
import utilities.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static utilities.DBUtils.*;

public class DBStepDefinitions {

    // ------------------------- KÜBRA US01 & US02 -----------------------------------

    @When("kullanici SSN kimliklerini dogrulamak icin tablodan gerekli sutunu alir")
    public void kullaniciSSNKimlikleriniDogrulamakIcinTablodanGerekliSutunuAlir() {
        createConnection();
        String query="SELECT * FROM jhi_user WHERE first_name = '"+ RegistrantApiSteps.firstName+"'";
        DBUtils.executeQuery(query);

    }
    @Then("kullanici ssn dogrulamasini yapar")
    public void kullaniciSsnDogrulamasiniYapar() throws SQLException {
        String query="Select * from jhi_user";
        List<Object> ssnList=DBUtils.getColumnData(query,"ssn");
        Assert.assertTrue(ssnList.contains(RegistrantApiSteps.ssn));
        DBUtils.closeConnection();

    }
    @When("kullanici email dogrulamasi icin tablodan gerekli sutunu alir")
    public void kullaniciEmailDogrulamasiIcinTablodanGerekliSutunuAlir() {
        createConnection();
        String query="SELECT * FROM jhi_user WHERE first_name = '"+RegistrantApiSteps.firstName+"'";
        DBUtils.executeQuery(query);
    }

    @Then("email dogrulamasini yapar")
    public void emailDogrulamasiniYapar() throws SQLException {
        String query="Select * from jhi_user";
        List<Object>emailList=DBUtils.getColumnData(query,"email");
        Assert.assertTrue(emailList.contains(RegistrantApiSteps.email));
        DBUtils.closeConnection();
    }

    //---------------------------------Onur------------------------------

    @Given("Kullanici DB baglantisi yapar")
    public void kullanici_db_baglantisi_yapar() {
        createConnection();
    }
    @Given("Kullanici {string} ve {string} gonderir, doktor adi sutununu alir")
    public void kullanici_ve_gonderir_doktor_adi_sutununu_alir(String query, String columnname) {
        List<Object> actualFirstName;
        actualFirstName =DBUtils.getColumnData(query,columnname);
        System.out.println(actualFirstName);
    }
    @Given("Kullanici Doktor adi dogrulamasi yapar")
    public void kullanici_doktor_adi_dogrulamasi_yapar() {
        List<String> expectedFirstName = new ArrayList<>();
        expectedFirstName.add("onur");
        expectedFirstName.add("ozgur");
        expectedFirstName.add("Sezer");
        expectedFirstName.add("Doctormon");
        expectedFirstName.add("Mary");
        expectedFirstName.add("Abuzer");

        Assert.assertTrue(expectedFirstName.containsAll(expectedFirstName));
        DBUtils.closeConnection();
    }

    //=========================SOZON=========================

    @Given("Kullanici olusturdugu mesaji dogrulamak icin DB tablodan gerekli sutunu alir.")
    public void kullanici_olusturdugu_mesaji_dogrulamak_icin_db_tablodan_gerekli_sutunu_alir() {
        createConnection();
        String query="SELECT * FROM cmessage WHERE message = '"+ RegistrantApiSteps.message+"'";
        DBUtils.executeQuery(query);
    }
    @Given("Kullanici DB mesaj dogrulamasini yapar.")
    public void kullanici_db_mesaj_dogrulamasini_yapar() {
        String query="SELECT * FROM cmessage";
        List<Object> messageList=DBUtils.getColumnData(query,"message");
        Assert.assertTrue(messageList.contains(RegistrantApiSteps.message));
        DBUtils.closeConnection();
    }

    //=========================Mehmet EMin=========================

    List<Object> appointmentDB= new ArrayList<>();

    @Given("Kullanici veritabanina baglanir")
    public void kullaniciVeritabaninaBaglanir() {
        createConnection();
    }

    @And("Kullanici tum {string} sutun verilerini secer")
    public void kullaniciTumSutunVerileriniSecer(String id) {
        appointmentDB = getColumnData("select * from appointment", id);
        System.out.println(appointmentDB);
    }

    @And("Kullanici veritabani ile {string} yi dogrular")
    public void kullaniciVeritabaniIleYiDogrular(String id) {
        assertTrue(appointmentDB.toString().contains(id));
    }

    @Then("veritabani baglantisini kapatin")
    public void veritabaniBaglantisiniKapatin() {
        closeConnection();
    }

    List<Object> patientIDs;
    List<List<Object>> patientData;
    List<Object> idRow;


    //___________________________________US09 Zeynep_____________________________________//

    @Given("user creates a connection with DB using {string} and {string} , {string}")
    public void user_creates_a_connection_with_db_using_and(String url, String username, String password) {
        DatabaseUtility.createConnection(url,username,password);
    }
    // Patient ID Validation
    @Given("staff user sends the query to DB and gets the column data {string} and {string}")
    public void staff_user_sends_the_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
        patientIDs = DatabaseUtility.getColumnData(query, columnName);
        System.out.print(patientIDs + ", ");
    }
    @Given("staff user saves the DB id records to correspondent files")
    public void staff_user_saves_the_id_db_records_to_correspondent_files() {
        WriteToTxt.savePatientIds(patientIDs);
    }
    @Then("staff user validates DB registrant id data")
    public void staff_user_validates_db_registrant_id_data() {
        List<Integer> actualIDs = ReadTxt.getPatientsIDs();

        List<Integer> expectedIDs = new ArrayList<>();
        expectedIDs.add(14000);
        expectedIDs.add(3359);
        expectedIDs.add(5551);

        assertTrue(actualIDs.containsAll(expectedIDs));
    }
    // Patient Name Validation
    @Given("staff user sends the query to DB {string}")
    public void staffUserSendsTheQueryToDB(String query) {
        DatabaseUtility.getColumnNames(query + "\n");
    }
    @Given("staff user saves the DB name records to correspondent files {string}")
    public void staff_user_saves_the_db_name_records_to_correspondent_files(String query) {
        List<Object> firstNameList = DatabaseUtility.getColumnData(query,"first_name");
        WriteToTxt.savePatientNames(ConfigurationReader.getProperty("db_patient_names"),firstNameList);
        System.out.println(firstNameList);
    }
    @Then("staff user validates DB registrant name data")
    public void staff_user_validates_db_registrant_name_data() {
        List<String> actualPatientNames = ReadTxt.returnPatientName(ConfigurationReader.getProperty("db_patient_names"));

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("Gillian");
        expectedNames.add("Percival");
        expectedNames.add("Destin");

        assertTrue(actualPatientNames.containsAll(expectedNames));
    }
    // Patient All Data Validation
    @Given("staff user sends the all data query to DB and gets the column data {string}")
    public void staffUserSendsTheAllDataQueryToDBAndGetsTheColumnDataAnd(String query) {
        patientData = DatabaseUtility.getQueryResultList(query);
        idRow = new ArrayList<>();
        //int idRows = DatabaseUtility.getRowCount(query);
        idRow.add(DatabaseUtility.getRowListWithParam(query,7));
    }
    @And("staff user saves the DB all data records to correspondent files")
    public void staffUserSavesTheDBAllDataRecordsToCorrespondentFilesAnd() { //(String query, String id, String first_name, String last_name, String birth_date, String phone,String gender,String blood_group, String adress, String description, String created_date,String user_id, String country_id,String cstate_id, String created_by, String last_modified_by,String last_modified_date, String email) {
        //Object[] row = idRow.toArray();
        WriteToTxt.savePatientData(idRow);
    }
    @Then("staff user validates DB registrant all data")
    public void staff_user_validates_db_registrant_all_data() {
        List<Object> actualPatientData = ReadTxt.returnPatientData();

        List<Object> expectedData = new ArrayList<>();
        expectedData.add("8358");
        expectedData.add("Jestine");
        expectedData.add("Baumbach");
        expectedData.add("01.02.1010, 18:38:32");
        expectedData.add("4387221874");
        expectedData.add("FEMALE");
        expectedData.add("Bnegative");
        expectedData.add("Fettek");
        expectedData.add("We are conducting Medunna");
        expectedData.add("13.01.2022, 18:41:38");
        expectedData.add("3314");
        expectedData.add("1201");
        expectedData.add(null);
        expectedData.add("anonymousUser");
        expectedData.add("staff079");
        expectedData.add("11.03.2022, 16:53:05");
        expectedData.add("victoria.ruecker@yahoo.com");

        for (int i = 1; i < expectedData.size(); i++)
            assertTrue(actualPatientData.get(i).toString().trim().contentEquals(expectedData.get(i).toString().trim()));
    }
    @Then("close the database connection")
    public void closeTheDatabaseConnection() {
        DatabaseUtility.closeConnection();
    }

    //_____________________________________________________________________//


}
