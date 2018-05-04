package magazinit;


import java.sql.*;


public class DBUtil {
    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "";
    private static final String mySqlCS = "jdbc:mysql://localhost:3306/pcshop";

public static Connection getConnection (DBType dbtype) throws SQLException{
    switch (dbtype){
        case ORADB:
            return null;
        case MYSQLDB:
            return DriverManager.getConnection(mySqlCS, mySqlUser, mySqlPwd);
        default:
            return null;
    }
}
    
    
}
