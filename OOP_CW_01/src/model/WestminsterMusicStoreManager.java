package model;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WestminsterMusicStoreManager implements StoreManager {

    final int MAXCOUNT=1000;

    @Override
    public void addItem(MusicItem item) {

        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:8889/WestminsterMusicStore";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query1 = "SELECT COUNT(*) FROM musicitem";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(query1);
            result.next();

            int count =result.getInt(1);
            if (count<MAXCOUNT) {

                // the mysql insert statement
                String query = " insert into musicitem (itemID, title, genre, releaseDate, artist, price)"
                        + " values (?, ?, ?, ?, ?, ?)";

                // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt(1, item.getItemID());
                preparedStmt.setString(2, item.getTitle());
                preparedStmt.setString(3, item.getGenre());
                preparedStmt.setString(4, item.getReleaseDate());
                preparedStmt.setString(5, item.getArtist());
                preparedStmt.setDouble(6, item.getPrice());

                System.out.println("DATA ENTERED");
//             execute the preparedstatement
                preparedStmt.execute();



            }else {
                System.out.println("you entered maximum items for database ");
            }
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }


    @Override
    public void deleteItem(int itemId) {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:8889/WestminsterMusicStore";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // create the mysql delete statement.
            String query = "delete from musicitem where itemID = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, itemId);

            System.out.println("Item Deleted");

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void printList() {
        try {
            // create a mysql database connection
            String myDriver = "org.gjt.mm.mysql.Driver";
            String myUrl = "jdbc:mysql://localhost:8889/WestminsterMusicStore";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            String query = "SELECT * FROM musicitem";

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
        @Override
        public void sortedList () {
            SortCategory.sortItems();
        }


//    private List<MusicItem> storeItem = new ArrayList<MusicItem>();
//    private static final int MAX_COUNT = 1000;
//    private List<MusicItem> boughtItem = new ArrayList<MusicItem>();
//
//    @Override
//    public void addItem(MusicItem item) {
//        if (storeItem.size() < MAX_COUNT) {
//            storeItem.add(item);
//        } else {
//            throw new IllegalArgumentException("Store is full no place to add!!!...");
//        }
//    }
//
//    public boolean delete(MusicItem item) {
//        return false;
//    }
//
//    public void print() {
//        System.out.println("List of CDs");
//        for (MusicItem item : storeItem) {
//            if (item instanceof CD) {
//                System.out.println((CD) item);
//            }
//        }
//        System.out.println("List of Vinyl");
//        for (MusicItem item : storeItem) {
//            if (item instanceof Vinyl) {
//                System.out.println((Vinyl) item);
//            }
//        }
//    }
//
//    public void sort(List<MusicItem> list, SortCategory c) {
///*        if(c==SortCategory.){
//            Collections.sort();
//        }
//        Collections.sort(storeItem, new PriceComparator());*/
//
//    }
//
//    public void buy(MusicItem item) {
//
//    }
//
//    public void generateReport() {
//
//    }
//
//    class PriceComparator implements Comparator<MusicItem>{
//        @Override
//        public int compare(MusicItem o1, MusicItem o2) {
//            return (int)((o1.price - o2.price)*100);
//        }
//    }

//    class GenreComparator implements Comparator<MusicItem>{
////        @Override
//        public int compare(MusicItem o1, MusicItem o2) {
//            return (int)((o1.price - o2.price)*100);
//        }


    }


