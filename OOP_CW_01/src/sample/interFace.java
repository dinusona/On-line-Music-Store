package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.awt.*;
import java.io.IOException;

import javafx.scene.control.Button;

import java.io.IOException;
import java.math.BigDecimal;

import javafx.scene.layout.*;
import model.MusicItem;
import model.StoreManager;
import model.WestminsterMusicStoreManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class interFace {

    final static StoreManager storeManger = new WestminsterMusicStoreManager();

    public static void home(Stage primaryStage) throws IOException {
        primaryStage.setTitle("online Music Store");
        //creat the main pane
        Pane rootforMain = new Pane();

        TextField Additem = new TextField();
        VBox layout = new VBox();


        Button bt01 = new Button();
        bt01.setText("Add Item");
        bt01.setLayoutX(20);
        bt01.setLayoutY(20);
        rootforMain.getChildren().add(bt01);

        Button bt02 = new Button();
        bt02.setText("Delete Item");
        bt02.setLayoutX(20);
        bt02.setLayoutY(60);
        rootforMain.getChildren().add(bt02);

        Button bt03 = new Button();
        bt03.setText("View Table");
        bt03.setLayoutX(20);
        bt03.setLayoutY(100);
        rootforMain.getChildren().add(bt03);

        Button bt04 = new Button();
        bt04.setText("sort items");
        bt04.setLayoutX(20);
        bt04.setLayoutY(140);
        rootforMain.getChildren().add(bt04);

        Button bt05 = new Button();
        bt05.setText("Buy item");
        bt05.setLayoutX(20);
        bt05.setLayoutY(180);
        rootforMain.getChildren().add(bt05);

        Button bt06 = new Button();
        bt06.setText("Generate a Report");
        bt06.setLayoutX(20);
        bt06.setLayoutY(220);
        rootforMain.getChildren().add(bt06);

        Button bt07 = new Button();
        bt07.setText("Exit");
        bt07.setLayoutX(20);
        bt07.setLayoutY(260);
        rootforMain.getChildren().add(bt07);


//01 ADD ITEM
        Pane rootforAddItem = new Pane();
        Scene sceneforAddItem = new Scene(rootforAddItem, 450, 500);

        Button bAddItem = new Button();
        bAddItem.setText("Add");
        bAddItem.setLayoutX(120);
        bAddItem.setLayoutY(460);
        rootforAddItem.getChildren().add(bAddItem);
        bt01.setOnAction(e -> primaryStage.setScene(sceneforAddItem));




        Button backBu1 = new Button();
        backBu1.setText("Back to Home");
        backBu1.setLayoutY(460);
        backBu1.setLayoutX(200);
        rootforAddItem.getChildren().add(backBu1);

        //itemID
        Label ID = new Label("Item ID:");
        rootforAddItem.getChildren().add(ID);
        ID.setLayoutX(50);
        ID.setLayoutY(50);

        TextField textFieldforID = new TextField();
        textFieldforID.setLayoutX(200);
        textFieldforID.setLayoutY(50);
        rootforAddItem.getChildren().add(textFieldforID);


        //title
        Label Title = new Label("Song Title:");
        rootforAddItem.getChildren().add(Title);
        Title.setLayoutX(50);
        Title.setLayoutY(100);

        TextField textFieldforTitle = new TextField();
        textFieldforTitle.setLayoutX(200);
        textFieldforTitle.setLayoutY(100);
        rootforAddItem.getChildren().add(textFieldforTitle);


        //genre
        Label Genre = new Label("Song Genre:");
        rootforAddItem.getChildren().add(Genre);
        Genre.setLayoutX(50);
        Genre.setLayoutY(150);

        TextField textFieldforGenre = new TextField();
        textFieldforGenre.setLayoutX(200);
        textFieldforGenre.setLayoutY(150);
        rootforAddItem.getChildren().add(textFieldforGenre);


        //released date
        Label Date = new Label("Enter Released Date:");
        rootforAddItem.getChildren().add(Date);
        Date.setLayoutX(50);
        Date.setLayoutY(200);

        TextField textFieldfordate = new TextField();
        textFieldfordate.setLayoutX(200);
        textFieldfordate.setLayoutY(200);
        rootforAddItem.getChildren().add(textFieldfordate);


        //artist
        Label artist = new Label("Enter Artist Name:");
        rootforAddItem.getChildren().add(artist);
        artist.setLayoutX(50);
        artist.setLayoutY(250);

        TextField textFieldforArtist = new TextField();
        textFieldforArtist.setLayoutX(200);
        textFieldforArtist.setLayoutY(250);
        rootforAddItem.getChildren().add(textFieldforArtist);


        //price
        Label Price = new Label("Enter Price:");
        rootforAddItem.getChildren().add(Price);
        Price.setLayoutX(50);
        Price.setLayoutY(300);

        TextField textFieldforPrice = new TextField();
        textFieldforPrice.setLayoutX(200);
        textFieldforPrice.setLayoutY(300);
        rootforAddItem.getChildren().add(textFieldforPrice);


        bAddItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //convert int to string
                int numAsString01 = Integer.parseInt(textFieldforID.getText());
                //convert double to string
                int numAsString02 = Integer.parseInt(textFieldforPrice.getText());

                MusicItem mus01 = new MusicItem(numAsString01, textFieldforTitle.getText(), textFieldforGenre.getText(), textFieldfordate.getText(), textFieldforArtist.getText(), numAsString02);
                storeManger.addItem(mus01);

            }
        });


//02 DELETE item
        Pane rootforDeleteItem = new Pane();
        Scene sceneforDeleteItem = new Scene(rootforDeleteItem, 450, 500);

        Button bDeleteItem = new Button();
        bDeleteItem.setText("Delete");
        bDeleteItem.setLayoutX(120);
        bDeleteItem.setLayoutY(460);
        rootforDeleteItem.getChildren().add(bDeleteItem);
        bt02.setOnAction(e -> primaryStage.setScene(sceneforDeleteItem));

        Button backBu2 = new Button();
        backBu2.setText("Back to Home");
        backBu2.setLayoutY(460);
        backBu2.setLayoutX(200);
        rootforDeleteItem.getChildren().add(backBu2);
//        backBu2.setOnAction(e -> primaryStage.setScene(scene2));


        Label delete = new Label("Enter itemID for delete:");
        rootforDeleteItem.getChildren().add(delete);
        delete.setLayoutX(50);
        delete.setLayoutY(50);

        TextField textFieldforDelete = new TextField();
        textFieldforDelete.setLayoutX(200);
        textFieldforDelete.setLayoutY(50);
        rootforDeleteItem.getChildren().add(textFieldforDelete);

        bDeleteItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                //convert int to string
                int numAsString03 = Integer.parseInt(textFieldforDelete.getText());
//                StoreManager storeManager = new WestminsterMusicStoreManager();
                storeManger.deleteItem(numAsString03);

            }
        });


//03 VIEW table

        Pane rootViewTable = new Pane();
        Scene sceneforViewTable = new Scene(rootViewTable, 450, 500);


        Button bView = new Button();
        bView.setText("View");
        bView.setLayoutX(120);
        bView.setLayoutY(460);
        rootViewTable.getChildren().add(bView);
        bt03.setOnAction(e -> primaryStage.setScene(sceneforViewTable));

        Button backBu3 = new Button();
        backBu3.setText("Back to Home");
        backBu3.setLayoutY(460);
        backBu3.setLayoutX(200);
        rootViewTable.getChildren().add(backBu3);
//        backBu3.setOnAction(e -> primaryStage.setScene(scene2));

        bView.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                storeManger.printList();
            }
        });






//04 sorted list of item

        Pane rootforPrintList = new Pane();
        Scene scenePrintList = new Scene(rootforPrintList, 450, 500);


        Button bSort = new Button();
        bSort.setText("Sort");
        bSort.setLayoutX(120);
        bSort.setLayoutY(460);
        rootforPrintList.getChildren().add(bSort);
        bt04.setOnAction(e -> primaryStage.setScene(scenePrintList));

        Button backBu4 = new Button();
        backBu4.setText("Back to Home");
        backBu4.setLayoutY(460);
        backBu4.setLayoutX(200);
        rootforPrintList.getChildren().add(backBu4);

        bSort.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
                storeManger.sortedList();
            }
        });



// 05 Buy item
        Pane rootforSort = new Pane();
        Scene sceneforSort = new Scene(rootforSort, 450, 500);


        Button baSort = new Button();
        baSort.setText("Buy");
        baSort.setLayoutX(120);
        baSort.setLayoutY(460);
        rootforSort.getChildren().add(baSort);
        bt05.setOnAction(e -> primaryStage.setScene(sceneforSort));

        Button backBu5 = new Button();
        backBu5.setText("Back to Home");
        backBu5.setLayoutY(460);
        backBu5.setLayoutX(200);
        rootforSort.getChildren().add(backBu5);


//06 generate a REPORT
        Pane rootforBuy = new Pane();
        Scene sceneforBuy = new Scene(rootforBuy, 450, 500);


        Button bBuy = new Button();
        bBuy.setText("Generate a Report");
        bBuy.setLayoutX(120);
        bBuy.setLayoutY(460);
        rootforBuy.getChildren().add(bBuy);
        bt06.setOnAction(e -> primaryStage.setScene(sceneforBuy));

        Button backBu6 = new Button();
        backBu6.setText("Back to Home");
        backBu6.setLayoutY(460);
        backBu6.setLayoutX(200);
        rootforBuy.getChildren().add(backBu6);


//07 exit
        Pane rootforReport = new Pane();
        Scene sceneforReport = new Scene(rootforReport, 450, 500);


        Button bReport = new Button();
        bReport.setText("Exit");
        bReport.setLayoutX(100);
        bReport.setLayoutY(460);
        rootforReport.getChildren().add(bReport);
        bt07.setOnAction(e -> primaryStage.setScene(sceneforReport));

        Button backBu7 = new Button();
        backBu7.setText("Back to Home");
        backBu7.setLayoutY(460);
        backBu7.setLayoutX(250);
        rootforReport.getChildren().add(backBu7);


//creat main Scene
        Scene scene1 = new Scene(rootforMain, 250, 330);
        primaryStage.setScene(scene1);
        primaryStage.show();
        //call all back to menu button
        backBu1.setOnAction(e -> primaryStage.setScene(scene1));
        backBu2.setOnAction(e -> primaryStage.setScene(scene1));
        backBu3.setOnAction(e -> primaryStage.setScene(scene1));
        backBu4.setOnAction(e -> primaryStage.setScene(scene1));
        backBu5.setOnAction(e -> primaryStage.setScene(scene1));
        backBu6.setOnAction(e -> primaryStage.setScene(scene1));
        backBu7.setOnAction(e -> primaryStage.setScene(scene1));


    }
}


//            public void handle(ActionEvent arg0) {
//                BigDecimal bigDecimalPrice = new BigDecimal(textFieldforPrice.getText());
//
//            }
//        });


