/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.object;

import java.util.Date;
import java.util.List;

/**
 *
 * @author vreydy2015
 */
public class Post {
    
    private int id;
    private String title;
    private String content;
    private Date date;
    private User user;
    private Category category;
    private List<Tag> tags;

    public Post(int id, String title, String content, Date date, User user, Category category,
            List<Tag> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
        this.category = category;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
}
