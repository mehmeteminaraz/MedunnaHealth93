
package pojos.US009_Pojo;

public class Country__1 {

    private Integer id;
    private String name;

    public Country__1() {
    }

    public Country__1(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
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
        return "Country__1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
