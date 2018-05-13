package magazinit;

import java.sql.*;

public class MagazinIT {

    public static void main(String[] args)  {
        try{
            /*Selcet date*/
            Connection con = DBUtil.getConnection(DBType.MYSQLDB);
            
            String sql_select = "select * from componenta";
            Statement stmt = con.createStatement();
            ResultSet rs= stmt.executeQuery(sql_select);
            
            
            while (rs.next())
                System.out.println(rs.getString(1) + " " + rs.getString(2)
                        + " " + rs.getString(3) + " " + rs.getString(4)
                        + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " +rs.getString(8) + " "+ rs.getString(9) );
            
             /*Insert date*/
            String sq1_2 = "insert into componenta values('1056', 'asus', '2','1200', '1997', '5', 'nvidia', 'Bucuresti','30')";
            int result_insert = stmt.executeUpdate(sq1_2);

            if (result_insert > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");
            
        }
        catch (SQLException e)
        {
            System.out.println("Conecxtiunea a esuat");
        }
    }
}
