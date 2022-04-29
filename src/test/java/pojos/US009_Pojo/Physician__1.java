
package pojos.US009_Pojo;

import java.util.List;

public class Physician__1 {

    private String adress;
    private List<String> appointments = null;
    private String birthDate;
    private String bloodGroup;
    private Country__4 country;
    private String createdBy;
    private String createdDate;
    private Cstate__2 cstate;
    private String description;
    private Integer examFee;
    private String firstName;
    private String gender;
    private Integer id;
    private String image;
    private String imageContentType;
    private String lastName;
    private String phone;
    private String speciality;
    private String ssn;
    private User__1 user;

    public Physician__1() {
    }

    @Override
    public String toString() {
        return "Physician__1{" +
                "adress='" + adress + '\'' +
                ", appointments=" + appointments +
                ", birthDate='" + birthDate + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", country=" + country +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", cstate=" + cstate +
                ", description='" + description + '\'' +
                ", examFee=" + examFee +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", image='" + image + '\'' +
                ", imageContentType='" + imageContentType + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", speciality='" + speciality + '\'' +
                ", ssn='" + ssn + '\'' +
                ", user=" + user +
                '}';
    }

    public Physician__1(String adress, List<String> appointments, String birthDate, String bloodGroup, Country__4 country, String createdBy, String createdDate, Cstate__2 cstate, String description, Integer examFee, String firstName, String gender, Integer id, String image, String imageContentType, String lastName, String phone, String speciality, String ssn, User__1 user) {
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
        this.examFee = examFee;
        this.firstName = firstName;
        this.gender = gender;
        this.id = id;
        this.image = image;
        this.imageContentType = imageContentType;
        this.lastName = lastName;
        this.phone = phone;
        this.speciality = speciality;
        this.ssn = ssn;
        this.user = user;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
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

    public Country__4 getCountry() {
        return country;
    }

    public void setCountry(Country__4 country) {
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

    public Cstate__2 getCstate() {
        return cstate;
    }

    public void setCstate(Cstate__2 cstate) {
        this.cstate = cstate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getExamFee() {
        return examFee;
    }

    public void setExamFee(Integer examFee) {
        this.examFee = examFee;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public User__1 getUser() {
        return user;
    }

    public void setUser(User__1 user) {
        this.user = user;
    }

}
