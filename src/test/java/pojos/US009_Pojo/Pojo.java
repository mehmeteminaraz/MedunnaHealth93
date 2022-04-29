package pojos.US009_Pojo;

import java.util.List;

public class Pojo {

    private String adress;
    private List<Appointment> appointments = null;
    private String birthDate;
    private String bloodGroup;
    private Country__2 country;
    private String createdBy;
    private String createdDate;
    private Cstate__1 cstate;
    private String description;
    private String email;
    private String firstName;
    private String gender;
    private Integer id;
    private List<InPatient> inPatients = null;
    private String lastName;
    private String phone;
    private String ssn;
    private User__2 user;

    public Pojo() {
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "adress='" + adress + '\'' +
                ", appointments=" + appointments +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", country=" + country +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", cstate=" + cstate +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", inPatients=" + inPatients +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }

    public Pojo(String adress, List<Appointment> appointments, String birthDate, String bloodGroup, Country__2 country, String createdBy, String createdDate, Cstate__1 cstate, String description, String email, String firstName, String gender, Integer id, List<InPatient> inPatients, String lastName, String phone, String ssn, User__2 user) {
        super();
        this.adress = adress;
        this.appointments = appointments;
        this.birthDate = birthDate;
        this.bloodGroup = bloodGroup;
        this.country = country;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.cstate = cstate;
        this.description = description;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.inPatients = inPatients;
        this.lastName = lastName;
        this.phone = phone;
        this.ssn = ssn;
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Country__2 getCountry() {
        return country;
    }

    public void setCountry(Country__2 country) {
        this.country = country;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Cstate__1 getCstate() {
        return cstate;
    }

    public void setCstate(Cstate__1 cstate) {
        this.cstate = cstate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<InPatient> getInPatients() {
        return inPatients;
    }

    public void setInPatients(List<InPatient> inPatients) {
        this.inPatients = inPatients;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public User__2 getUser() {
        return user;
    }

    public void setUser(User__2 user) {
        this.user = user;
    }

}
