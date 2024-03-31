package org.example.accounts;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "login", unique = true, updatable = false)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {

    }

    public String getLogin() {
        return this.login;
    }

    public String getPass() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
