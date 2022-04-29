package pojos.US009_Pojo;

import java.util.List;

public class Ctest {

    private String appointment;
    private String createdBy;
    private String createdDate;
    private List<CtestResult> ctestResults = null;
    private String date;
    private String description;
    private Integer id;
    private String name;

    public Ctest() {
    }

    public Ctest(String appointment, String createdBy, String createdDate, List<CtestResult> ctestResults, String date, String description, Integer id, String name) {
        super();
        this.appointment = appointment;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctestResults = ctestResults;
        this.date = date;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
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

    public List<CtestResult> getCtestResults() {
        return ctestResults;
    }

    public void setCtestResults(List<CtestResult> ctestResults) {
        this.ctestResults = ctestResults;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Ctest{" +
                "appointment='" + appointment + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctestResults=" + ctestResults +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
