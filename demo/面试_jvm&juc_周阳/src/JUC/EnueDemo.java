package JUC;

/**
 * author: mxg
 */
public enum  EnueDemo {

    ONE(1,"1"), TWO(2,"2"), THREE(3,"3");

    private Integer id;
    private String name;

    EnueDemo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
