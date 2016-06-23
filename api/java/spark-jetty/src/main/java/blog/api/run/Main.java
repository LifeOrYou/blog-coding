/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.run;

import blog.api.controller.UsersController;
import blog.api.core.ResponseError;
import blog.api.service.UsersService;
import blog.api.transformer.JsonTransformer;
import com.google.gson.Gson;
import spark.ExceptionHandler;
import spark.Filter;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

/**
 *
 * @author vreydy2015
 */
public class Main {
    
    public static void main(String[] args) {
        new UsersController(new UsersService());
        
        exception(IllegalArgumentException.class, new ExceptionHandler() {
            @Override
            public void handle(Exception excptn, Request rqst, Response rspns) {
                rspns.status(400);
                rspns.body(new Gson().toJson(new ResponseError(excptn)));
            }
        });
        after(new Filter() {
            @Override
            public void handle(Request rqst, Response rspns) throws Exception {
                rspns.type("application/json");
            }
        });
    }
    
}
