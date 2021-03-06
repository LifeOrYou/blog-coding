/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.core;

/**
 *
 * @author vreydy2015
 */
public class ResponseError {
    
    private String message;
    
    public ResponseError(String msg, String... args) {
        this.message = String.format(msg, args);
    }
    
    public ResponseError(Exception e) {
        this.message = e.getMessage();
    }
    
    public String getMessage() {
        return this.message;
    }
    
}
