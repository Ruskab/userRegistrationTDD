package ikab.tdd.tdduserregistration;

import org.hamcrest.Matcher;

public class User {
    private String id;
    private String name;
    private String password;

    private User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static User of(String id, String name, String password) {
        return new User(id, name, password);
    }
}
