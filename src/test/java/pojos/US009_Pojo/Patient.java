package pojos.US009_Pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    private String id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone;
    private String gender;
    private String blood_group;
    private String adress;
    private String description;
    private String created_date;
    private String user_id;
    private String country_id;
    private String cstate_id;
    private String created_by;
    private String last_modified_by;
    private String last_modified_date;
    private String email;

    public Patient() {

    }

    public Patient(String id, String first_name, String last_name, String birth_date, String phone, String gender, String blood_group, String adress, String description, String created_date, String user_id, String country_id, String cstate_id, String created_by, String last_modified_by, String last_modified_date, String email) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.phone = phone;
        this.gender = gender;
        this.blood_group = blood_group;
        this.adress = adress;
        this.description = description;
        this.created_date = created_date;
        this.user_id = user_id;
        this.country_id = country_id;
        this.cstate_id = cstate_id;
        this.created_by = created_by;
        this.last_modified_by = last_modified_by;
        this.last_modified_date = last_modified_date;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCstate_id() {
        return cstate_id;
    }

    public void setCstate_id(String cstate_id) {
        this.cstate_id = cstate_id;
    }

    public String getCreated_by() {
        return created_by;
    }
    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public String getLast_modified_by() {
        return last_modified_by;
    }

    public void setLast_modified_by(String last_modified_by) {
        this.last_modified_by = last_modified_by;
    }

    public String getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(String last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id =" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birth_date='" + birth_date + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", blood_group='" + blood_group + '\'' +
                ", adress='" + adress + '\'' +
                ", description='" + description + '\'' +
                ", created_date='" + created_date + '\'' +
                ", user_id=" + user_id +
                ", country_id=" + country_id +
                ", cstate_id=" + cstate_id +
                ", created_by='" + created_by + '\'' +
                ", last_modified_by='" + last_modified_by + '\'' +
                ", last_modified_date='" + last_modified_date + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}

