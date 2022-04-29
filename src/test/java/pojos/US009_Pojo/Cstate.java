package pojos.US009_Pojo;

public class Cstate {

    private Country__1 country;
    private Integer id;
    private String name;

    public Cstate() {
    }

    public Cstate(Country__1 country, Integer id, String name) {
        super();
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public Country__1 getCountry() {
        return country;
    }

    public void setCountry(Country__1 country) {
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
        return "Cstate{" +
                "country=" + country +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
