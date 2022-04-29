
package pojos.US009_Pojo;

public class Country__3 {

    private Integer id;
    private String name;

    public Country__3() {
    }

    public Country__3(Integer id, String name) {
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
        return "Country__3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
