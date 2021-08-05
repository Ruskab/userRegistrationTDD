package ikab.tdd.tdduserregistration;

import org.hamcrest.Matcher;

import java.util.Objects;

public class User {
    private final String id;

    private final String name;
    private final String password;

    private User(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public static User of(String id, String name, String password) {
        return new User(id, name, password);
    }

    public static User of(String name, String password) {
        return new User(null, name, password);
    }

    public static User copy(User user) {
        return User.of(user.id, user.name, user.password);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, password);
    }
}
