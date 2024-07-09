import java.util.Objects;

public class User {
    private Integer id = 0;
    private String name;
    private String userId;
    private String wp;
    private boolean isLogin;

    public User(String name, String userId, String wp) {
        this.name = name;
        this.userId = userId;
        this.wp = wp;
        this.isLogin = false;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getWp() {
        return wp;
    }

    public boolean getIsLogin() {
        return isLogin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return isLogin == user.isLogin && Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(userId, user.userId) && Objects.equals(wp, user.wp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, userId, wp, isLogin);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", wp='" + wp + '\'' +
                ", isLogin=" + isLogin +
                '}';
    }
}
