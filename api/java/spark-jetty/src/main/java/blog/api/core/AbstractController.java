/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.core;

import blog.api.core.ResponseError;
import spark.Response;

/**
 *
 * @author vreydy2015
 */
public abstract class AbstractController {
    
    protected Object notFoundProcess(Response r, String msg, String... args) {
        r.status(400);
        return new ResponseError(msg, args);
    }
    protected Object notFoundProcess(Response r, Exception e) {
        r.status(400);
        return new ResponseError(e);
    }
    
}
