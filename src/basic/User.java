package basic;

public class User {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) return;
        this.name = name;
    }
}
