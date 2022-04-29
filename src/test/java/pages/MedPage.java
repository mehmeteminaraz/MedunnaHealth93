package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;
public class MedPage {

    public MedPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

//------------------- Kubra--------------------------

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement createANewUserSayfasıSSNTextBox;
    //------------------------------------------
    //mainpage>KullaniciIkonu>signInLinki/AdministrationLinki
    @FindBy(xpath ="//*[@id=\"admin-menu\"]/a/span")
    public WebElement administrationLinki;

    //mainpage>KullaniciIkonu>signInLinki/AdministrationLinki/UserManagementLinki
    @FindBy(xpath = "//span[text()='User management']")
    public WebElement usermanagementLinki;

    //mainpage>KullaniciIkonu>signInLinki/AdministrationLinki/UserManagementLinki/CreateANewUserButonu
    @FindBy(xpath = "//a[@class='btn btn-primary float-right jh-create-entity']")
    public WebElement createANewUserButonu;

    //mainpage>KullaniciIkonu>signInLinki/AdministrationLinki/UserManagementLinki/CreateANewUserButonu/createANewUserTexti
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/h1/span")
    public WebElement createANewUserTexti;

    //mainpage>KullaniciIkonu>signInLinki/AdministrationLinki/UserManagementLinki/CreateANewUserButonu/CreateANewUserSayfasi/LoginTextBox
    @FindBy(xpath = "//input[@id='login']")
    public WebElement createANewUserSayfasiloginTextBox;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement createANewUserSayfasifirstnameTextBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement createANewUserSayfasilastnameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement createANewUserSayfasiEmailTextBox;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement createANewUserSayfasiSSNBox;

    @FindBy(xpath = "//select[@id='authorities']")
    public WebElement createANewUserSayfasiProfilesDropDownElementi;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement createANewUserSayfasiSaveButonu;

    @FindBy(xpath ="(//a[@class='page-link'])[9]")
    public WebElement usersSayfasiSonSayfaElementi;

    //administrationButonu>UserManagement Sayfası/view butonu
    @FindBy(xpath = "//*[text()='View']")
    public WebElement viewButonu;

    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/dl/dd[8]")
    public WebElement hesapdogrulama;

    @FindBy(xpath = "//*[text()='Edit']")
    public WebElement editButtons;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement editSayfasiFirstnameTextBox;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement editSayfasiSaveButonu;

    @FindBy(xpath = "//*[@id=\"authorities\"]/option[4]")
    public WebElement editSayfasiRole;

    @FindBy(xpath = "//*[text()='Delete']")
    public WebElement usersSayfasindakiDeleteButonu;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div[3]/button[2]")
    public WebElement alertDeleteButonu;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/a")
    public WebElement sagUstHesapIkonu;

    @FindBy(xpath = "//*[@id=\"account-menu\"]/div/a[3]")
    public WebElement signOutButonu;

    @FindBy(xpath = "//*[@id=\"header-tabs\"]/li[6]/a")
    public WebElement contactLinki;

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement contactPageNameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement contactPageEmailTextBox;

    @FindBy(xpath ="//input[@id='subject']")
    public WebElement contactPageSubjectTextBox;

    @FindBy(xpath = "//*[@id=message]")
    public WebElement contactPageMessageBox;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement contactPageSAVEButonu;

    @FindBy(xpath = "//*[@id=\"contact\"]/div[1]/div/h2")
    public WebElement contactPageCONTACTTexti;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div[1]/div/div")
    public WebElement contactPageNameBosBirakildigindaCikanUyariYazisi;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div[2]/div/div")
    public WebElement contactPageGecersizEmailAdresiGirildigindeCikanUyariYazisi;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[1]/div[2]/div/div")
    public WebElement contactPageEmailBosBirakildigindaCikanUyari;

    @FindBy(xpath = "//*[@id=\"register-form\"]/div[2]/div/div/div")
    public WebElement contactPageSubjectBosBirakildigindaCikanUyari;
    //------------------- Mehmet Emin--------------------------
    //------------------- Mustafa--------------------------

    //main>sigIn>Adminastration>UserManagement>CreatNewUser>YeniKulalniciIsDisplayed
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement creatNewUserKullaniciKaydiBasariliYazisi;

    //main>Adminastration>UserManagement>YeniKullaniciEdit>IsDisplayed
    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div[1]/div/div/div[1]")
    public WebElement yeniKullaniciBasariliEditYazisi;

    //main>Adminastration>UserManagement>ModifiedByYazisi
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/table/thead/tr/th[9]/span")
    public WebElement modifiedByYazisi;

    //main>Adminastration>UserManagement>EditYazisi
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[5]")
    public WebElement staffEditYazisi;

    //main>Adminastration>UserManagement>viewYazisi
    @FindBy(xpath = "(//*[@class='svg-inline--fa fa-eye fa-w-18 '])[9]")
    public WebElement userSayfasiViewYazisi;

    //main>Adminastration>UserManagement>Edit>CreateOrEditSayfasindakiUserNameTextBox
    @FindBy(xpath = "//input[@name='login']")
    public WebElement createOrEditSayfasindakiUserNameTextBox;

    //main>Adminastration>UserManagement>Edit>CreateOrEditSayfasi
    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement staffBasariylaGuncellendiYazisi;

    // alternatif staffBasariylaGuncellendiYazisi xpath leri
    // //*[@id="root"]/div/div/div[1]/div
    // /html/body/div/div/div/div[1]/div

    //main>Adminastration>UserManagement>DeleteYazisi
    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[5]")
    public  WebElement usersSayfasiDeleteButonu;

    //main>Adminastration>UserManagement>ConfirmDeleteYazisi
    @FindBy(xpath = "//button[@class='btn btn-danger']")
    public  WebElement usersSayfasiConfirmDeleteButonu;

    //main>Adminastration>UserManagement>Delete
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div/div/div[1]")
    public WebElement staffBasariylaSilindiYazisi;

    // alternatif staffBasariylaSilindiYazisi xpath i
    // //*[@id="root"]/div/div/div[1]/div/div/div[1]

    // main>Patient>MyPages(Patients)
    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement myPagesPatient;

    // main>Patient>MyPages(Patients)>MyAppointments
    @FindBy(xpath = "//span[.='My Appointments']")
    public WebElement myAppointmentsPatient;

    // main>Patient>MyPages(Patients)>MyAppointments>Appointments>Show Tests
    @FindBy(xpath = "(//*[.='Show Tests'])[1]")
    public WebElement patientShowTestsYazisi;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>Show Tests
    @FindBy(xpath = "//span[@class='d-none d-md-inline']")
    public WebElement patientViewResultsYazisi;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='ID']")
    public WebElement testResultsID;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='Name']")
    public WebElement testResultsName;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='Default Min. Value']")
    public WebElement testResultsDefaultMinValue;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='Default Max. Value']")
    public WebElement testResultsDefaultMaxValue;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='Description']")
    public WebElement testResultsDescription;

    // main>Patient>MyPages(Patients)>MyAppointments>Tests>TestResults
    @FindBy(xpath = "//span[.='Date']")
    public WebElement testResultsDate;

    //------------------- Zeynep--------------------------

    // Show Appointments --> Show Tests Button
    @FindBy(xpath = "//a[@href='/tests/appointment/76302']")
    public WebElement showTestsButtonGetirAppointments;

    // Show Appointments --> Show Tests Button --> Tests Header
    @FindBy(xpath = "//span[text()='Tests']")
    public WebElement testsHeader;

    // Show Appointments --> Show Tests Button --> View Results Button
    @FindBy(xpath = "//a[@href='/testresult/test/75212']")
    public WebElement viewResultsButtonGetirAppointments;

    //  Show Appointments --> Show Tests Button --> View Results Button --> Test Results Header
    @FindBy(xpath = "//span[text()='Test Results']")
    public WebElement testResultsHeader;

    // Show Appointments --> Show Tests Button --> View Results Button --> Edit Button
    @FindBy(xpath = "//a[@href='/c-test-result-update/76452']")
    public WebElement editButtonGetirTestResults;

    //  Show Appointments --> Show Tests Button --> View Results Button --> Edit Button --> Edit Test Result Header
    @FindBy(xpath = "//span[text()='Create or edit a Test Result']")
    public WebElement editTestResultHeader;

    // Show Appointments --> Show Tests --> View Results Button --> Edit Button --> Result Textbox
    @FindBy(xpath = "//input[@id='c-test-result-result']")
    public WebElement resultTestTextBox;

    // Show Appointments --> Show Tests --> View Results Button --> Edit Button --> Description Textbox
    @FindBy(xpath = "//input[@id='c-test-result-description']")
    public WebElement descriptionTestTextBox;

    // Show Appointments --> Show Tests --> View Results Button --> Edit Button --> Save Button
    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButtonGetirTestResult;

    // Test Result Updated Message
    @FindBy(xpath = "//*[text()='A Test Result is updated with identifier 76452']")
    public WebElement testResultUpdatedMessage;

    // Show Appointments --> Payment Button
    @FindBy(xpath = "//tbody//td//div//a[3]")
    public WebElement paymentButtonGetirAppointments;

    // Show Appointments --> Payment Button --> PAYMENT DETAIL Header
    @FindBy(xpath = "//th[text()='PAYMENT DETAIL']")
    public WebElement paymentDetailHeader;

    // Show Appointments --> Payment Button --> PAYMENT DETAIL Header --> Exam Fee
    @FindBy(xpath = "//thead//tr[5]//th[2]")
    public WebElement examFeeText;

    // Show Appointments --> Payment Button --> PAYMENT DETAIL Header --> Total Cost
    @FindBy(xpath = "//td[text()='TOTAL COST']")
    public WebElement totalCost;

    // Show Appointments --> Payment Button --> PAYMENT DETAIL Header -->
    @FindBy(xpath = "//td[2][text()='Test Item Fee']")
    public WebElement testItemFee;

    // Show Appointments --> Payment Button --> Create Invoice Button
    @FindBy(xpath = "//a[@class='btn btn-danger btn-sm']")
    public WebElement createInvoiceButton;

    // Show Appointments --> Payment Button --> Create Invoice Button --> Create or edit a Bill Header
    @FindBy(xpath = "//span[text()='Create or edit a Bill']")
    public WebElement editBillText;

    // Show Appointments --> Payment Button --> Date Textbox
    @FindBy(xpath = "//input[@name='date']")
    public WebElement dateBillForm;

    // Show Appointments --> Payment Button --> Select Payment Method
    @FindBy(xpath = "//select[@name='paymentMethod']")
    public WebElement paymentMethodSelect;

    // Show Appointments --> Payment Button --> Description
    @FindBy(xpath = "//input[@id='bill-description']")
    public WebElement billDescriptionTextbox;

    // Show Appointments --> Payment Button --> Save Button
    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButtonPayment;

    // Show Appointments --> Payment Button --> Create Invoice --> Save Button
    @FindBy(xpath = "//*[text()='A Bill is updated with identifier 76321']")
    public WebElement billUpdatedMessage;

    // Show Appointments --> Show Invoice
    @FindBy(xpath = "//th[text()='INVOICE']")
    public WebElement invoiceText;

    //------------------- Sezen--------------------------

    //Medunna>MainPage>Kullanıcı ikonu>Sign in Linki
    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInLinki;

    //Medunna>MainPage>Kullanici Ikonu>Sign In linki/ Username text box
    @FindBy(xpath = "//input[@name='username']")
    public WebElement signInUsernameTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In linki/ Username Uyari Yazisi
    @FindBy(xpath = "//div[text()='Username cannot be empty!']")
    public WebElement signInUsernameUyariYazisi;

    //Medunna>MainPage>Kullanici Ikonu>Sign In linki/ Password text box
    @FindBy(xpath = "//input[@name='password']")
    public WebElement signInPasswordTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In linki/ Password Uyari Yazisi
    @FindBy(xpath = "//div[text()='Password cannot be empty!']")
    public WebElement signInPasswordUyariYazisi;

    //Medunna>MainPage>Kullanici Ikonu>Sign In linki/Sign In butonu
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButonu;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown
    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement ItemsTitlesDropdown;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages
    @FindBy(xpath = "//span[text()='Messages']")
    public WebElement itemsTitlesMessages;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages
    @FindBy(xpath = "(//a[@class='btn btn-link btn-sm'])[1]")
    public WebElement itemsTitlesFirstMessageID;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Message>View>Message+Id Title
    @FindBy(xpath = "//h2//b")
    public WebElement messageIdTitle;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>ID
    @FindBy(xpath = "//span[text()='ID']")
    public WebElement messageID;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Message Delete> Delete Confirm
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement messageDeletedAlert;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Sign Out
    @FindBy(xpath = "(//a[@class='dropdown-item'])[12]")
    public WebElement signOutLinki;




    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Message
    @FindBy(xpath = "(//tbody//tr)[1]")
    public WebElement firstMessage;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Message>View Button
    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement firstMessageViewButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Message>Name
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[2]")
    public WebElement firstMessageName;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Second Message>Name
    @FindBy(xpath = "//*[@id=\"app-view-container\"]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]")
    public WebElement secondMessageName;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Create a new message button
    @FindBy(xpath = "//span[text()='Create a new Message']")
    public WebElement createANewMessageButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Edit Button
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement firstEditButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Second Edit Button
    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement secondEditButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Delete Button
    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement firstDeleteButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>First Delete Button>Delete Confirmation
    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cMessage']")
    public WebElement messageDeleteConfirmationButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Second Delete Button
    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[2]")
    public WebElement secondDeleteButton;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Edit>Create or edit a Message>Name Textbox
    @FindBy(xpath = "//input[@name='name']")
    public WebElement CreateOrEditAMessageNameTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Edit>Create or edit a Message>Email Textbox
    @FindBy(xpath = "//input[@name='email']")
    public WebElement CreateOrEditAMessageEmailTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Edit>Create or edit a Message>Subject Textbox
    @FindBy(xpath = "//input[@name='subject']")
    public WebElement CreateOrEditAMessageSubjectTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Edit>Create or edit a Message>Message Textbox
    @FindBy(xpath = "//input[@name='message']")
    public WebElement CreateOrEditAMessageMessageTextBox;

    //Medunna>MainPage>Kullanici Ikonu>Sign In>Admin>Items&Titles Dropdown>Messages>Edit>Create or edit a Message>Save Button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement CreateOrEditAMessageSaveButton;


    //------------------- Salih--------------------------

    //mainPage/signInIkonu
    @FindBy(xpath="//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement anasayfaSignInIkonElementi;

    //mainPage>signIn/Register
    @FindBy(xpath=" //a[@href='/account/register']")
    public WebElement registerLinkiElementi;
    //a[@href='/account/register']

    //mainPage>signIn>Register/RegistrationYazisi
    @FindBy(xpath="//h1[@id='register-title']")
    public WebElement registirationYaziElementi;

    //mainPage>signIn>Register/SSNTextBox
    @FindBy(xpath="//input[@name='ssn']")
    public WebElement registerSSNTextBoxElementi;

    //mainPage>signIn>Register/FirstNameTextBox
    @FindBy(xpath="//input[@name='firstName']")
    public WebElement registerFirstNameTextBoxElementi;

    //mainPage>signIn>Register/LastNameTextBox
    @FindBy(xpath="//input[@name='lastName']")
    public WebElement registerLastNameTextBoxElementi;

    //mainPage>signIn>Register/UserNameTextBox
    @FindBy(xpath="//input[@name='username']")
    public WebElement registerUsernameTextBoxElementi;

    //mainPage>signIn>Register/EmailTextBox
    @FindBy(xpath="//input[@name='email']")
    public WebElement registerEmailTextBoxElementi;

    //mainPage>signIn>Register/FirstPasswordTextBox
    @FindBy(xpath="//input[@name='firstPassword']")
    public WebElement registerFirstPasswordTextBoxElementi;

    //mainPage>signIn>Register/PasswordStrengthBariKirmizi
    @FindBy(xpath="(//li[@style='background-color: rgb(255, 0, 0);'])[1]")
    public WebElement registerStrengthRedElementi;

    //mainPage>signIn>Register/PasswordStrengthBariTuruncu
    @FindBy(xpath="(//li[@style='background-color: rgb(255, 153, 0);'])[1]")
    public WebElement registerStrengthOrangeElementi;

    //mainPage>signIn>Register/PasswordStrengthBariFistikYesili
    @FindBy(xpath="(//li[@style='background-color: rgb(153, 255, 0);'])[1]")
    public WebElement registerStrengthPistachioElementi;

    //mainPage>signIn>Register/PasswordStrengthBariYesil
    @FindBy(xpath="(//li[@style='background-color: rgb(0, 255, 0);'])[1]")
    public WebElement registerStrengthGreenElementi;

    //mainPage>signIn>Register/SecondPasswordTextBox
    @FindBy(xpath="//input[@id='secondPassword']")
    public WebElement registerSecondPasswordTextBoxElementi;

    //mainPage>signIn>Register/RegisterButonu
    @FindBy(xpath="//button[@id='register-submit']")
    public WebElement registerButonElementi;

    //mainPage>signIn/signInYazisi
    @FindBy(xpath="//h5[@class='modal-title']")
    public WebElement signInYazisiElementi;

    //mainPage>signIn/UsernameTextBox
    @FindBy(xpath="//input[@id='username']")
    public WebElement signInUsernameTextBoxElementi;

    //mainPage>signIn/PasswordTextBox
    @FindBy(xpath="//input[@id='password']")
    public WebElement signInPasswordTextBoxElementi;

    //mainPage>signIn/UsernameTextBoxBosBirakilamazUyariYazisi
    @FindBy(xpath="(//div[@class='invalid-feedback'])[1]")
    public WebElement signInUsernameBosBirakilamazUyariElementi;

    //mainPage>signIn/PasswordTextBoxBosBirakilamazUyariYazisi
    @FindBy(xpath="(//div[@class='invalid-feedback'])[2]")
    public WebElement signInPasswordBosBirakilamazUyariElementi;

    //mainPage>signIn/RememberMeYazisi
    @FindBy(xpath="//span[text()='Remember me']")
    public WebElement signInRememberMeYaziElementi;

    //mainPage>signIn/RememberMeButonu
    @FindBy(xpath="//input[@id='rememberMe']")
    public WebElement signInRememberMeButonElementi;

    //mainPage>signIn/DidYouForgetYourPasswordLinki
    @FindBy(xpath="//a[@href='/account/reset/request']")
    public WebElement signInDidYouForgetPasswordLinkiElementi;

    //mainPage>signIn/YouDontHaveAnAccountYetRegisterANewAccountLinki
    @FindBy(xpath="(//a[@href='/account/register'])[2]")
    public WebElement signInRegisterANewAccountLinkiElementi;

    //mainPage>signIn/CancelButonu
    @FindBy(xpath="//button[@class='btn btn-secondary']")
    public WebElement signInCancelButonElementi;

    //mainPage>signIn/SignInButonu
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement signInSignInButonuElementi;

    //mainPage>signIn>DidYouForgetPasswordLinki>ResetYourPassword
    @FindBy(xpath="//span[text()='Reset your password']")
    public WebElement resetYourPasswordYaziElementi;

    //mainPage>signIn/Setting
    @FindBy(xpath="//a[@href='/account/settings']")
    public WebElement signInSettingLinkiElementi;

    //mainPage>signIn/Setting/FirstNameBoxElementi;
    @FindBy(xpath="//input[@id='firstName']")
    public WebElement settingFirstNameTextBoxElementi;

    //mainPage>signIn/Setting/LastNameBox
    @FindBy(xpath="//input[@id='lastName']")
    public WebElement settingLastNameTextBoxElementi;

    //mainPage>signIn/Setting/EmailBox
    @FindBy(xpath="//input[@id='email']")
    public WebElement settingEmailTextBoxElementi;

    //mainPage>signIn/Setting/SaveButonu
    @FindBy(xpath="//button[@class='btn btn-primary']")
    public WebElement settingSaveButonElementi;

    //mainPage>signIn/Setting/BasariliSaveYazisi
    @FindBy(xpath="//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement settingBasariliSaveYazisiElementi;
    //expected-> Settings saved!

    //mainPage>signIn>Register/BasariliKayitYapildiYazisi
    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement registerBasariliKayitYapildiYaziElementi;
    //expected-> Registration Saved

    //mainPage>signIn/signInLinki
    @FindBy(xpath="//a[@id='login-item']")
    public WebElement signInLinkiElementi;

    //mainPage> signIn> Administration
    @FindBy(xpath="//li[@id='admin-menu']")
    public WebElement adminAdministrationSekmesiElementi;

    //mainPage> signIn> Administration/UserManagement
    @FindBy(xpath="//a[@class='dropdown-item active']")
    public WebElement adminUserManagementSekmesiElementi;

    //mainPage> signIn> Administration/UserManagement>Users/SonSayfayaGit
    @FindBy(xpath="(//a[@class='page-link'])[9]")
    public WebElement usersSonSayfayaGitElementi;

    //mainPage> signIn> Administration/UserManagement>Users/TabloBaslikListesi
    @FindBy(xpath="//thead//tr//th")
    public List<WebElement>  usersBasliklarListesi;

    //mainPage> signIn> Administration/UserManagement>Users/EditButonu
    @FindBy(xpath="//a[@href='/admin/user-management/alfreda.leuschke/edit']")
    public WebElement usersEditButonuElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit/ActivatedButonu
    @FindBy(xpath="//input[@name='activated']")
    public WebElement usersEditActivatedButonElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit/ProfilesDropDown
    @FindBy(xpath="//select[@id=\"authorities\"]")
    public WebElement userEditProfilesDropDownElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit/SaveButonu
    @FindBy(xpath="//button[@type=\"submit\"]")
    public WebElement usersEditSaveButonuElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit/BasariliAktiveEdildiYazielementi
    @FindBy(xpath="//div[@class=\"Toastify__toast-body\"]")
    public WebElement usersEditBasariliAktiveEdildiYaziElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit
    @FindBy(xpath="(//a[@class=\"d-flex align-items-center dropdown-toggle nav-link\"])[3]")
    public WebElement signInIkonuTeam93AdminElementi;

    //mainPage> signIn> Administration/UserManagement>UsersYazisi
    @FindBy(xpath="//span[text()='Users']")
    public WebElement adminUsersYazisi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit/CreateOrEditAUserYazisi
    @FindBy(xpath="//h1")
    public WebElement editCreateaUserYaziElementi;

    //mainPage>signIn>settins/UserSettingsYazisi
    @FindBy(xpath="//h2[@id='settings-title']")
    public WebElement settingUserSettingYaziElementi;

    //mainPage>signIn>settins/BasariliEditlendiYazisi
    @FindBy(xpath="//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement settingBasariliEditlendiYazisi;

    //mainPage>signIn>SignOut
    @FindBy(xpath="//a[@href='/logout']")
    public WebElement signInsignOutElementi;

    //mainPage> signIn> Administration/UserManagement>Users/Edit
    @FindBy(xpath="//input[@id='lastName']")
    public WebElement editlastnameTextBoxElementi;

    //mainPage> signIn>Items-TittleSekmesi
    @FindBy(xpath="//li[@id='entity-menu']")
    public WebElement itemsTittleElementi;

    //mainPage>signIn>settins/UsersIkonu
    @FindBy(xpath="(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement settingCikisYapElementi;

    //------------------- Mehmet Ali--------------------------
    //------------------- Onur--------------------------
    //Item/Titles
    @FindBy(xpath="(//*[@class=\"dropdown nav-item\"])[1]")
    public WebElement itemtitlesMenu;

    //Item/Titles--->Physician
    @FindBy(xpath="//*[@id=\"entity-menu\"]/div/a[3]")
    public WebElement itemtitlesPhysician;

    //Item/Titles--->Physician---->Creat Physician
    @FindBy(xpath="//a[@id='jh-create-entity']")
    public WebElement CreatPhysician;

    //Item/Titles--->Physician---->Creat Physician>SSn
    @FindBy(xpath="//input[@id='searchSSN']")
    public WebElement CreatPhysicianSsn;

    //Item/Titles--->Physician---->Creat Physician>Search _User Button
    @FindBy(xpath="//button[text()='Search User']")
    public WebElement searchUserButton;

    //Item/Titles--->Physician---->Creat Physician>Use Search tik
    @FindBy(xpath="//input[@id='useSSNSearch']")
    public WebElement useSearch;

    //Item/Titles--->Physician---->First Name
    @FindBy(xpath="//input[@id='physician-firstName']")
    public WebElement firstName;

    //Item/Titles--->Physician---->Last Name
    @FindBy(xpath="//input[@name='lastName']")
    public WebElement lastName;

    //Item/Titles--->Physician---->BirthDate
    @FindBy(xpath="//input[@name='birthDate']")
    public WebElement birthDate;

    //Item/Titles--->Physician---->speciality
    @FindBy(xpath="//select[@id='physician-speciality']")
    public WebElement speciality;

    //Item/Titles--->Physician---->image
    @FindBy(xpath="//input[@id='file_image']")
    public WebElement image;

    //Item/Titles--->Physician---->Exam fee
    @FindBy(xpath="//input[@id='physician-examFee']")
    public WebElement examFee;

    //Item/Titles--->Physician---->textbox alti uyari yazisi
    @FindBy(xpath="//div[text()='This field is required.']")
    public WebElement textboxaltiuyariyazisi;

    //Item/Titles--->Physician---->Birtdate textbox alti uyari yazisi
    @FindBy(xpath="//div[text()='This field is invalid']")
    public WebElement birtdatetextboxaltiuyariyazisi;

    //Item/Titles--->Physician---->sol ust kose pupop
    @FindBy(xpath="//div[@class='Toastify__toast-body']")
    public WebElement solustkosepupop;

    //Item/Titles--->Physician---->valid form kontrol
    @FindBy(xpath="(//input[@class='is-touched is-dirty av-valid form-control'])[2]")
    public WebElement validformkontrol;

    //Item/Titles--->Physician---->doktor edit button
    @FindBy(xpath="//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[18]/div/a[2]")
    public WebElement doktoredit;

    //Item/Titles--->Physician---->doktor delete button
    @FindBy(xpath="//a[@href='/physician/3652/delete?page=1&sort=id,asc']")
    public WebElement doktordelete;

    //Item/Titles--->Physician---->doktor delete button delete
    @FindBy(xpath="//button[@id='jhi-confirm-delete-physician']")
    public WebElement doktordeletedelete;


    //Item/Titles--->Physician---->doktor delete button--->alert message
    @FindBy(xpath="//div[text()='Internal server error.']")
    public WebElement doktordeletealertmessage;

    //Item/Titles--->Physician---->doktor wiev button
    @FindBy(xpath="//*[@id=\"app-view-container\"]/div/div/div/div/div[1]/div/table/tbody/tr[1]/td[18]/div/a[1]")
    public WebElement doktorwiev;

    //Item/Titles--->Physician---->doktor wiev button-->Edit button
    @FindBy(xpath="//a[@class='btn btn-primary']")
    public WebElement doktorwieveditbutton;

    //Item/Titles--->Physician---->doktor bilgileri
    @FindBy(xpath="//div[@class='form-group']")
    public List<WebElement> doktorbilgileri;

    //Item/Titles--->Physician---->doktor bilgileri--->wiew list
    @FindBy(xpath="//*[text()='View']")
    public List<WebElement> doktorlist;

    //Item/Titles--->Physician---->doktor edit button---->First name
    @FindBy(xpath="//input[@value='Doctorpp']")
    public WebElement doktoreditbuttonfirstname;

    @FindBy(xpath = "//select[@name='speciality']")
    public WebElement doktorspeciality;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement doktorexamFee;

    //Item/Titles--->Physician---->doktor edit button---->gender
    @FindBy(xpath="//select[@name='gender']")
    public WebElement doktoreditbuttongender;
    //------------------- Mehmet Emin--------------------------
    //- US16_RoomCreateEditDeleteByAdminPage

    @FindBy(xpath ="(//a[@href='/room'])[2]" )
    public WebElement roomCta;

    @FindBy(xpath = "//*[text()='Create a new Room']")
    public WebElement createANewRoom;

    @FindBy(xpath = "//select[@id='room-roomType']")
    public WebElement roomTypeDropDown;

    @FindBy(xpath ="//input[@id='room-status']" )
    public WebElement statusCheck;

    @FindBy(xpath = "//input[@id='room-description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//input[@id='room-createdDate']")
    public WebElement createdDate;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[text()='This field is required.'])[1]")
    public WebElement fieldRequiredRoom;

    @FindBy(xpath ="(//*[text()='This field is required.'])[2]" )
    public WebElement fieldRequiredPrice;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement roomNumberTextBox;

    @FindBy(xpath = "//input[@id='room-price']")
    public WebElement priceTextBox;

    @FindBy(xpath = "//*[contains(text(), 'A new Room is created')]")
    public WebElement roomCreateSuccessMessage;

    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement lastPageArrow;

    @FindBy(xpath = "(//span[text()='Edit'])[last()]")
    public WebElement editButton;

    @FindBy(xpath = "(//span[text()='Delete'])[last()]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-room']")
    public WebElement confirmDelete;

    @FindBy(xpath ="//*[contains(text(), 'deleted')]" )
    public WebElement roomDeleteSuccessMessage;
    //--Mehmet Emin- US17_===============================================

    //Item/Titles
    @FindBy(xpath="//span[normalize-space()='Items&Titles']")
    public WebElement itemsTitles1;

    //Item/Titles--->testItem
    @FindBy(xpath="(//li[@id='entity-menu'])[1]")
    public WebElement itemsTitles;

    @FindBy(xpath = "(//a[@role='menuitem'])[5]")
    public WebElement testItem;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement CreateTestItem;
    //a[class='dropdown-item active'] span

    @FindBy(xpath = "//input[@id='c-test-item-name']")
    public WebElement testNameBox;

    @FindBy(xpath = "//input[@id='c-test-item-description']")
    public WebElement description;

    @FindBy(xpath = "//input[@id='c-test-item-price']")
    public WebElement price;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMin']")
    public WebElement minValue;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMax']")
    public WebElement maxValue;

    @FindBy(xpath = "//input[@id='c-test-item-createdDate']")
    public WebElement createDate;

    @FindBy(id = "save-entity")
    public WebElement saveButton1;

    @FindBy(xpath = "//div[@id='app-view-container']")
    public WebElement savingSuccessMessage;

    @FindBy(xpath = "//div[@class='jh-card card']//li[7]")
    public WebElement arrowLastItem;

    @FindBy(xpath = "(//li[@class='page-item'])[5]")
    public WebElement lastFigureItem;

    @FindBy(xpath = "(//span[@class='d-none d-md-inline'])[45]")
    public WebElement deleteTestItem;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cTestItem']")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "(//span[contains(text(),'Delete')])[17]")
    public WebElement deleteSuccessMessage;

    // main>Patient>MyPages(Patients)>MyAppointments>ShowInvoice
    @FindBy(xpath = "(//span[.='Show Invoice'])[1]")
    public WebElement showInvoiceYazisi;

    //============================Sezen================================
    //mainPage>Admin>Items&Titles
    @FindBy(xpath="//a[@class='d-flex align-items-center dropdown-toggle nav-link'][1]")
    public WebElement adminItemsTitlesElementi;
    //a[@class='d-flex align-items-center dropdown-toggle nav-link'][1]
    //span[text()='Items&Titles']

    //mainPage>Admin>Items&Titles/Country
    @FindBy(xpath="(//a[@href='/country'])[1]")
    public WebElement adminItemsTitlesCountryElementi;

    //mainPage>Admin>Items&Titles>Country/CountriesYazisi
    @FindBy(xpath="//span[text()='Countries']")
    public WebElement countryCountriesYazisiElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry
    @FindBy(xpath="//a[@href='/country/new']")
    public WebElement countryCreateAnewCountryElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry>CreateOrEditCountryYazisi
    @FindBy(xpath="//span[text()='Create or edit a Country']")
    public WebElement countryCreateOrEditACountryYazisiElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry/NameTextBox
    @FindBy(xpath="//input[@id='country-name']")
    public WebElement countryCreateNameTextBoxElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry/SaveButonu
    @FindBy(xpath="//button[@id='save-entity']")
    public WebElement countryCreateSaveButonuElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry/SaveButonu>BasariliSaveYazisi
    @FindBy(xpath="//div[@class='Toastify__toast-body']")
    public WebElement countryCreateBasariliSaveYazisiElementi;

    //mainPage>Admin>Items&Titles>Country>CreateANewCountry/CreatedDateTextBox
    @FindBy(xpath="//input[@id='country-createdDate']")
    public WebElement countryCreateCreatedDateTextBoxElementi;

    //mainPage>Admin>Items&Titles/Country>DeleteButonu
    @FindBy(xpath="//a[@href='/country/3802/delete']")
    public WebElement countryDeleteButonuElementi;

    //mainPage>Admin>Items&Titles/Country>DeleteButonuConfirmDeleteButtonu
    @FindBy(xpath="//button[@id='jhi-confirm-delete-country']")
    public WebElement countryConfirmDeleteButtonuElemeneti;

    //mainPage>Admin>Items&Titles/Country>DeleteButonuConfirmDeleteButtonu/BasariliDeleteYazisi
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement countryBasariliDeleteYazisiElementi;

    //mainPage>Admin>Items&Titles/Country>Team93Admin
    @FindBy(xpath="(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[3]")
    public WebElement countryAdminSekmesiElementi;

}