/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.service;

import blog.api.object.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vreydy2015
 */
public class UsersService implements Service {
    
    private List<User> collection;
    
    public UsersService() {
        this.collection = new ArrayList<>();
    }
    
    public List<User> getAll() {
        return this.collection;
    }
    
    public User getById(int id) {
        for(User user : this.collection) {
            if (user.getId() == id) {
                return user;
            }
        }
        
        return null;
    }
    
    public void create(User user) {
        this.collection.add(user);
    }
    
    public void delete(User user) {
        this.collection.remove(user);
    }
    
    public void update(User user) {
        this.collection.set(this.collection.indexOf(user), user);
    }
    
}
