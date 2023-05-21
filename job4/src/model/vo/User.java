package model.vo;

public class User {
    private String userName;
    private String password;
    private String tel;
    private String gender;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getTel() {
        return tel;
    }

    public User(String userName, String password, String gender, String tel) {
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", passWord='" + password + '\'' +
                ", phone='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
