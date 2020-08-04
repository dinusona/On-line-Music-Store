package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SortCategory {

    public static void sortItems(){
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:8889/WestminsterMusicStore";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = "SELECT * FROM musicitem ORDER BY title ASC";

            // create the java statement
            Statement stat = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet result = stat.executeQuery(query);

            while (result.next()) {
                System.out.println("id : " + result.getString("itemID"));
                System.out.println("title : " + result.getString("title"));
                System.out.println("genre : " + result.getString("genre"));
                System.out.println("date : " + result.getString("releaseDate"));
                System.out.println("artist : " + result.getString("artist"));
                System.out.println("price : " + result.getString("price"));
                System.out.println("////////////////////////////////////");
            }
        } catch (Exception e) {
            System.err.println("Got an exception");
            System.err.println(e.getMessage());
        }
    }
}
