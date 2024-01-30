package by.vsu.domain;

public class Username {
    private Integer id;
    private String firstname;
    private String surname;
    private String lostname;
    private String status;
    private Integer group;
    private String login;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getLostname() {return lostname;}

    public void setLostname(String lostname) {this.lostname = lostname;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}

