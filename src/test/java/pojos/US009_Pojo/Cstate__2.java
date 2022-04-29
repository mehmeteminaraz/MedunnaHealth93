package pojos.US009_Pojo;

public class Cstate__2 {

    private Country__5 country;
    private Integer id;
    private String name;

    public Cstate__2() {
    }

    public Cstate__2(Country__5 country, Integer id, String name) {
        super();
        this.country = country;
        this.id = id;
        this.name = name;
    }

    public Country__5 getCountry() {
        return country;
    }

    public void setCountry(Country__5 country) {
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
        return "Cstate__2{" +
                "country=" + country +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
