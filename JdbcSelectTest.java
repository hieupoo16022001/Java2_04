package jdbcTest;
import java.sql.*;
public class JdbcSelectTest {
    public static void main(String[] args) {
    try(
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ebookshop?allowPublickeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "root", "");
            Statement stmt = conn.createStatement();
        ){
        String strSelect =" select * from books where author like 'CodeLean VN' order by price DESC ";
        System.out.println("The SQL statement is:" + strSelect + "\n");

        ResultSet rset = stmt.executeQuery(strSelect);
        System.out.println("The records selected are");
        int rowCount = 0;
        while (rset.next()){

            String title = rset.getString("title");
            String author = rset.getString("author");
            double price = rset.getDouble("price");
            int qty = rset.getInt("qty");
            System.out.println(author + ","+ title + ", " + price + ", " + qty);
            ++rowCount;
        }
        System.out.println("Total number of records = " + rowCount);


    } catch (SQLException ex){
        ex.printStackTrace();
        }
    }

}

