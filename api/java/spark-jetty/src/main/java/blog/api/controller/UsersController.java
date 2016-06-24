package blog.api.controller;

import blog.api.core.AbstractController;
import blog.api.object.User;
import blog.api.service.UsersService;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 *
 * @author vreydy2015
 */
public class UsersController extends AbstractController {
    
    private static UsersService service;
    
    static {
        service = new UsersService();
    }
    
    public static Route all = (Request rqst, Response rspns) -> {
        //LoginController.ensureUserIsLoggedIn(request, response);
        return service.getAll();
    };   
    
    public static Route byId = (Request rqst, Response rspns) -> {
        return service.getById(Integer.parseInt(rqst.params(":id")));
    };
    
    public static Route add = (Request rqst, Response rspns) -> {
        return service.create(
                new User(
                        service.generateId(),
                        rqst.queryParams("username"),
                        rqst.queryParams("password"),
                        rqst.queryParams("email"),
                        User.Role.valueOf(rqst.queryParams("role").toUpperCase())
                )
        );
    };
    
    public static Route update = (Request rqst, Response rspns) -> {
        service.update(
                new User(
                        Integer.parseInt(rqst.params(":id")),
                        rqst.queryParams("username"),
                        "",
                        rqst.queryParams("email"),
                        User.Role.valueOf(rqst.queryParams("role"))
                )
        );
        return null;
    };
    
    public static Route delete = (Request rqst, Response rspns) -> {
        service.delete(Integer.parseInt(rqst.params(":id")));
        return null;
    };
    
}
