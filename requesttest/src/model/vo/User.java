package model.vo;

public class User {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }
    public  User() {
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String password) {
        this.userName = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "name:"+userName+"  password:"+password;
    }
}
