/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.service;

import blog.api.object.User;
import java.util.List;

/**
 *
 * @author vreydy2015
 */
public class UsersService extends AbstractService {
    
    private static final String SQL_SELECT = "SELECT * FROM users";
    private static final String SQL_CREATE = "INSERT INTO users (username, password, email, role) VALUES (:username, :password, :email, :role)";
    private static final String SQL_DELETE = "DELETE FROM users WHERE id = :id";
    private static final String SQL_UPDATE = "UPDATE users SET username = :username, email = :email, role = :role WHERE id = :id";
    private static final String SQL_GENERATOR = String.format(SQL_GENID, "gen_users");
    
    public UsersService() {
        super();
    }
    
    public List<User> getAll() {
        return this.createQuery(SQL_SELECT).executeAndFetch(User.class);
    }
    
    public User getById(int id) {
        return this.createQuery(SQL_SELECT + " WHERE id = :id")
                .addParameter("id", id).executeAndFetchFirst(User.class);
    }
    
    public int create(User user) {
        return this.createQuery(SQL_CREATE)
                .addParameter("id", user.getId())
                .addParameter("username", user.getUsername())
                .addParameter("password", user.getPassword())
                .addParameter("email", user.getEmail())
                .addParameter("role", user.getRole().name())
                .executeUpdate().getResult();
    }
    
    public void delete(int id) {
        this.createQuery(SQL_DELETE)
                .addParameter("id", id).executeUpdate();
    }
    
    public void update(User user) {
        this.createQuery(SQL_UPDATE)
                .addParameter("username", user.getUsername())
                .addParameter("email", user.getEmail())
                .addParameter("role", user.getRole().name())
                .executeUpdate();
    }
    
    public int generateId() {
        return this.createQuery(SQL_GENERATOR).executeAndFetchFirst(Integer.class);
    }
    
}
