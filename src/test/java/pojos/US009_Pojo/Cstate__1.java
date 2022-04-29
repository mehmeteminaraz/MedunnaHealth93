package pojos.US009_Pojo;

public class Cstate__1 {

    private Country__3 country;
    private Integer id;
    private String name;

    public Cstate__1() {
    }

    public Cstate__1(Country__3 country, Integer id, String name) {
        super();
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public Country__3 getCountry() {
        return country;
    }

    public void setCountry(Country__3 country) {
        this.country = country;
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
        return "Cstate__1{" +
                "country=" + country +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
