
package inventorymanagmentsystem;

/**
 *
 * @author Muhammed
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
public static Connection connectDb(){
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect = DriverManager.getConnection("jdbc:mysql://sql7.freesqldatabase.com:3306/sql7629948", "sql7629948", "WfSgPme3AF");
            return connect;
        }catch(Exception e){e.printStackTrace();}
        return null;
    }
    
}
