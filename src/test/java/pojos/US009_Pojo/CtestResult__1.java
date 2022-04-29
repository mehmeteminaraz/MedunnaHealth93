package pojos.US009_Pojo;

public class CtestResult__1 {

    private String createdBy;
    private String createdDate;
    private String ctest;
    private CtestItem__1 ctestItem;
    private String date;
    private String description;
    private Integer id;
    private String result;

    public CtestResult__1() {
    }

    @Override
    public String toString() {
        return "CtestResult__1{" +
                "createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", ctest='" + ctest + '\'' +
                ", ctestItem=" + ctestItem +
                ", date='" + date + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", result='" + result + '\'' +
                '}';
    }

    public CtestResult__1(String createdBy, String createdDate, String ctest, CtestItem__1 ctestItem, String date, String description, Integer id, String result) {
        super();
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.ctest = ctest;
        this.ctestItem = ctestItem;
        this.date = date;
        this.description = description;
        this.id = id;
        this.result = result;
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

    public String getCtest() {
        return ctest;
    }

    public void setCtest(String ctest) {
        this.ctest = ctest;
    }

    public CtestItem__1 getCtestItem() {
        return ctestItem;
    }

    public void setCtestItem(CtestItem__1 ctestItem) {
        this.ctestItem = ctestItem;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
