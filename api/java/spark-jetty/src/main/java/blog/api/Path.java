package blog.api;

/**
 *
 * @author vreydy2015
 */
public class Path {
    
    public static final String INDEX = "/";
    
    public static class Users {
        
        public static final String ALL = "/users";
        public static final String BY_ID = "/users/:id";
        public static final String ADD = ALL;
        public static final String SAVE = BY_ID;
        public static final String DELETE = BY_ID;
        
    }
    
    public static class Categories {
        
        public static final String ALL = "/categories";
        public static final String BY_ID = "/categories/:id";
        public static final String ADD = ALL;
        public static final String SAVE = BY_ID;
        public static final String DELETE = BY_ID;
        
    }
    
}
