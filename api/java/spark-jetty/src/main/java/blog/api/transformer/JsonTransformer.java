/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.transformer;

import com.google.gson.Gson;
import spark.ResponseTransformer;

/**
 *
 * @author vreydy2015
 */
public class JsonTransformer implements ResponseTransformer {

    private static final Gson gson = new Gson();
    
    @Override
    public String render(Object o) throws Exception {
        return gson.toJson(o);
    }
    
}
