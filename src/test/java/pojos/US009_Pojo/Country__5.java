
package pojos.US009_Pojo;

public class Country__5 {

    private Integer id;
    private String name;

    public Country__5() {
    }

    public Country__5(Integer id, String name) {
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
        return "Country__5{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
