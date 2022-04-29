package pojos.US009_Pojo;

public class InPatient {

    private Appointment__1 appointment;
    private String createdBy;
    private String createdDate;
    private String description;
    private String endDate;
    private Integer id;
    private String patient;
    private Room room;
    private String startDate;
    private String status;

    public InPatient() {
    }

    @Override
    public String toString() {
        return "InPatient{" +
                "appointment=" + appointment +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", description='" + description + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id=" + id +
                ", patient='" + patient + '\'' +
                ", room=" + room +
                ", startDate='" + startDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public InPatient(Appointment__1 appointment, String createdBy, String createdDate, String description, String endDate, Integer id, String patient, Room room, String startDate, String status) {
        super();
        this.appointment = appointment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.description = description;
        this.endDate = endDate;
        this.id = id;
        this.patient = patient;
        this.room = room;
        this.startDate = startDate;
        this.status = status;
    }

    public Appointment__1 getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment__1 appointment) {
        this.appointment = appointment;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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

}
