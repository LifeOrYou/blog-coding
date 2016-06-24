/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.object;

/**
 *
 * @author vreydy2015
 */
public class User {
    
    public static enum Role {ADMIN, USER};
    
    private int id;
    private String username;
    private String password;
    private String email;
    private Role role;

    public User(int id) {
        this.id = id;
    }
    
    public User(int id, String nom, String prenom) {
        this.id = id;
        this.username = nom;
        this.password = prenom;
    }

    public User(int id, String username, String password, String email, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
