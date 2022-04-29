package pojos.US009_Pojo;

import java.util.List;

public class Appointment__1 {

    private String anamnesis;
    private String createdBy;
    private String createdDate;
    private List<Ctest__1> ctests = null;
    private String description;
    private String diagnosis;
    private String endDate;
    private Integer id;
    private String patient;
    private Physician__1 physician;
    private String prescription;
    private String startDate;
    private String status;
    private String treatment;

    public Appointment__1() {
    }

    public Appointment__1(String anamnesis, String createdBy, String createdDate, List<Ctest__1> ctests, String description, String diagnosis, String endDate, Integer id, String patient, Physician__1 physician, String prescription, String startDate, String status, String treatment) {
        super();
        this.anamnesis = anamnesis;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctests = ctests;
        this.description = description;
        this.diagnosis = diagnosis;
        this.endDate = endDate;
        this.id = id;
        this.patient = patient;
        this.physician = physician;
        this.prescription = prescription;
        this.startDate = startDate;
        this.status = status;
        this.treatment = treatment;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
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

    public List<Ctest__1> getCtests() {
        return ctests;
    }

    public void setCtests(List<Ctest__1> ctests) {
        this.ctests = ctests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public Physician__1 getPhysician() {
        return physician;
    }

    public void setPhysician(Physician__1 physician) {
        this.physician = physician;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Appointment__1{" +
                "anamnesis='" + anamnesis + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctests=" + ctests +
                ", description='" + description + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id=" + id +
                ", patient='" + patient + '\'' +
                ", physician=" + physician +
                ", prescription='" + prescription + '\'' +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }

}
