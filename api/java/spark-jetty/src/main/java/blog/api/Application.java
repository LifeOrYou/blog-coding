/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api;

import blog.api.controller.UsersController;
import blog.api.transformer.JsonTransformer;
import static spark.Spark.*;

/**
 *
 * @author vreydy2015
 */
public class Application {
    
    public static void main(String[] args) {
        JsonTransformer transformer = new JsonTransformer();
        // Routes 
        get(Path.Users.ALL, UsersController.all, transformer);
        get(Path.Users.BY_ID, UsersController.byId, transformer);
        post(Path.Users.ADD, UsersController.add, transformer);
        post(Path.Users.SAVE, UsersController.update, transformer);
        delete(Path.Users.DELETE, UsersController.delete, transformer);
    }
    
}
