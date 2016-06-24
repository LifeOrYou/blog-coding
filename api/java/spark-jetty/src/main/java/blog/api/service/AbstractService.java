/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog.api.service;

import javax.sql.DataSource;
import org.firebirdsql.pool.FBSimpleDataSource;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

/**
 *
 * @author vreydy2015
 */
public abstract class AbstractService implements Service {
    
    protected static final String SQL_GENID = "SELECT gen_id(%s) FROM rdb$database";
    
    private DataSource ds;
    private Sql2o sql2o;
    
    protected AbstractService() {
        this.sql2o = new Sql2o(this.getDataSource());
    }
    
    protected Query createQuery(String sql) {
        try (Connection con = this.sql2o.open()) {
            return con.createQuery(sql);
        }
    }
    
    private void createDataSource() {
        FBSimpleDataSource fbDs = new FBSimpleDataSource();
        
        fbDs.setDatabase("//localhost/C:\\Users\\vreydy2015\\Desktop\\blog-coding\\data\\databases\\BLOG.fdb");
        fbDs.setUserName("SYSDBA");
        fbDs.setPassword("masterkey");
        
        this.ds = fbDs;
    }
    
    private DataSource getDataSource() {
        if (this.ds == null)
            this.createDataSource();
        return this.ds;
    }
    
}
