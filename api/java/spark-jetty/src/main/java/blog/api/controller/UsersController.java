/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.controller;

import blog.api.core.AbstractController;
import blog.api.object.User;
import blog.api.service.UsersService;
import blog.api.transformer.JsonTransformer;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;

/**
 *
 * @author vreydy2015
 */
public class UsersController extends AbstractController {
    
    private UsersService service;
    
    public UsersController(UsersService usersService) {
        this.service = usersService;
        
        this.service.create(new User(1, "valentin", "reydy"));
        this.service.create(new User(2, "nicolas", "tesla"));
        
        get("/users", new SelectAllRoute(), new JsonTransformer());
        get("/users/:id", new SelectByIdRoute(), new JsonTransformer());
        post("/users", new AddRoute(), new JsonTransformer());
        put("/users/:id", new UpdateRoute(), new JsonTransformer());
        delete("/users/:id", new DeleteRoute(), new JsonTransformer());
    }
    
    private class SelectAllRoute implements Route {
        @Override
        public Object handle(Request rqst, Response rspns) throws Exception {
            return service.getAll();
        }
    }
    
    private class SelectByIdRoute implements Route {
        @Override
        public Object handle(Request rqst, Response rspns) throws Exception {
            String id = rqst.params(":id");
            
            User user = service.getById(Integer.parseInt(id));
            
            if (user == null) {
                return notFoundProcess(rspns, "No user with id %s found.", id);
            }
            
            return user;
        }
    }
    
    private class AddRoute implements Route {
        @Override
        public Object handle(Request rqst, Response rspns) throws Exception {
            service.create(
                    new User(
                            Integer.parseInt(rqst.queryParams("id")), 
                            rqst.queryParams("nom"), 
                            rqst.queryParams("prenom")
                    )
            );
            return null;
        }
    }
    
    private class UpdateRoute implements Route {
        @Override
        public Object handle(Request rqst, Response rspns) throws Exception {
            service.update(
                    new User(
                            Integer.parseInt(rqst.params(":id")),
                            rqst.queryParams("nom"),
                            rqst.queryParams("prenom")
                    )
            );
            return null;
        }
    }
    
    private class DeleteRoute implements Route {
        @Override
        public Object handle(Request rqst, Response rspns) throws Exception {
            int id = Integer.parseInt(rqst.params(":id"));
            
            service.delete(new User(id));
            
            return null;
        }
    }
    
}
