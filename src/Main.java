import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main extends Application {

    public void start(Stage stage) {

        HashMap<String, String> toBadulla = new HashMap<>();
        HashMap<String, String> toColombo = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        menu:
        while (true) {
            System.out.println("Enter \"A\" to add a customer");
            System.out.println("Enter \"V\" to view all the seats");
            System.out.println("Enter \"E\" to view the empty seats");
            System.out.println("Enter \"D\" to delete a booked seat");
            System.out.println("Enter \"F\" to find a seat by customer name");
            System.out.println("Enter \"S\" to store the customers");
            System.out.println("Enter \"L\" to load the customers");
            System.out.println("Enter \"O\" to sort the customers in order");
            System.out.println("Enter \"Q\" to quit");
            String option = sc.next().toLowerCase();
            switch (option) {
                case "a":
                    addCustomer(toBadulla,toColombo);
                    break;
                case "v":
                    viewALLSeats(toBadulla,toColombo);
                    break;
                case "e":
                    viewEmptySeats(toBadulla,toColombo);
                    break;
                case "d":
                    deleteBooking
                            (toBadulla,toColombo);
                    break;
                case "f":
                    findSeatByCustomer(toBadulla,toColombo);
                    break;
                case "s":
                    store(toBadulla,toColombo);
                    break;
                case "l":
                    load(toBadulla,toColombo);
                    break;
                case "o":
                    ordercustomer(toBadulla,toColombo);
                    break;
                case "q":
                    System.exit(0);
                    break;

                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Invalid input.Please Re-enter");
                    System.out.println("----------------------------------------------------------");

            }
        }

    }

    public static void main(String args[]) {
        launch(args);
    }

    //------------------------------------------------ADD CUSTOMER------------------------------------------------------
    private void addCustomer(HashMap toBadulla, HashMap<String, String> toColombo)

    {  Label label = new Label("Train Seat Booking ");
        label.setFont(Font.font(20));
        //vbox1
        VBox vbox1 = new VBox();
        vbox1.setSpacing(20);
        vbox1.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox1.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setDisable(true);
            }
            btn1.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn1.getId());
                    System.out.println("----------------------------------------------------------");

                    btn1.setTextFill(Color.RED);
                    btn1.setDisable(true);
                    toBadulla.put(name, btn1.getId());
                }
            });

        }
        //vbox2
        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        vbox2.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 43; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox2.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setDisable(true);
            }
            btn2.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn2.getId());
                    System.out.println("----------------------------------------------------------");
                    btn2.setTextFill(Color.RED);
                    btn2.setDisable(true);
                    toBadulla.put(name, btn2.getId());
                }
            });

        }
        //vbox3
        VBox vbox3 = new VBox();
        vbox3.setSpacing(20);
        vbox3.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox3.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setDisable(true);
            }

            btn3.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn3.getId());
                    System.out.println("----------------------------------------------------------");
                    btn3.setTextFill(Color.RED);
                    btn3.setDisable(true);
                    toBadulla.put(name, btn3.getId());

                }
            });

        }
        //vbox4
        VBox vbox4 = new VBox();
        vbox4.setSpacing(20);
        vbox4.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox4.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setDisable(true);
            }
            btn4.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn4.getId());
                    System.out.println("----------------------------------------------------------");
                    btn4.setTextFill(Color.RED);
                    btn4.setDisable(true);
                    toBadulla.put(name, btn4.getId());

                }
            });

        }
        //vbox5

        HBox hbox = new HBox(vbox1, vbox2, label, vbox3, vbox4);
        hbox.setStyle("-fx-background-color: #038573");
        Scene scene = new Scene(hbox);
        Stage stage=new Stage();
        stage.setTitle("Denuwara Menike Seat Booking");
        stage.setScene(scene);

        Label label2 = new Label("Train Seat Booking ");
        label2.setFont(Font.font(20));

        //vbox1
        VBox vbox5 = new VBox();
        vbox5.setSpacing(20);
        vbox5.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox5.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setDisable(true);
            }
            btn1.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn1.getId());
                    System.out.println("----------------------------------------------------------");

                    btn1.setTextFill(Color.RED);
                    btn1.setDisable(true);
                    toColombo.put(name, btn1.getId());
                }
            });

        }
        //vbox2
        VBox vbox6 = new VBox();
        vbox6.setSpacing(20);
        vbox6.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 43; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox6.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setDisable(true);
            }
            btn2.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn2.getId());
                    System.out.println("----------------------------------------------------------");
                    btn2.setTextFill(Color.RED);
                    btn2.setDisable(true);
                    toColombo.put(name, btn2.getId());
                }
            });

        }
        //vbox3
        VBox vbox7 = new VBox();
        vbox7.setSpacing(20);
        vbox7.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox7.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setDisable(true);
            }

            btn3.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn3.getId());
                    System.out.println("----------------------------------------------------------");
                    btn3.setTextFill(Color.RED);
                    btn3.setDisable(true);
                    toColombo.put(name, btn3.getId());

                }
            });

        }
        //vbox4
        VBox vbox8 = new VBox();
        vbox8.setSpacing(20);
        vbox8.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox8.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setDisable(true);
            }
            btn4.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Customer Name:");
                    String name = sc.next();
                    System.out.println("----------------------------------------------------------");
                    System.out.println(name + " has successfully booked seat no: " + btn4.getId());
                    System.out.println("----------------------------------------------------------");
                    btn4.setTextFill(Color.RED);
                    btn4.setDisable(true);
                    toColombo.put(name, btn4.getId());

                }
            });

        }
        //vbox5
        HBox hbox2 = new HBox(vbox5, vbox6, label2, vbox7, vbox8);
        hbox2.setStyle("-fx-background-color: #038573");
        Scene scene3 = new Scene(hbox2);

        stage.setScene(scene3);

        Stage stage2 = new Stage();
        Scene scene1;
        Label label1 = new Label("Denuwara Menike Seat Booking");
        label1.setLayoutX(120);
        label1.setLayoutY(10);
        label1.setFont(Font.font(20));
        Button button1 = new Button("Train from Colombo to Badulla");
        button1.setLayoutY(100);
        button1.setLayoutX(150);
        button1.setPrefSize(200, 50);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                stage.showAndWait();
            }
        });
        Button button2 = new Button("Train from Badulla to Colombo");
        button2.setLayoutY(200);
        button2.setLayoutX(150);
        button2.setPrefSize(200, 50);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene3);
                stage.showAndWait();
            }
        });

        AnchorPane layout1 = new AnchorPane();
        layout1.getChildren().addAll(label1, button1, button2);
        scene1 = new Scene(layout1, 500, 400);

        stage2.setScene(scene1);
        stage2.setTitle("Train Booking");
        stage2.showAndWait();
    }
    //------------------------------------------------VIEW ALL SEATS----------------------------------------------------
    private void viewALLSeats(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {
        Label label = new Label("Train Seat Booking");
        label.setFont(Font.font(20));


        //vbox1
        VBox vbox1 = new VBox();
        vbox1.setSpacing(20);
        vbox1.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox1.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setDisable(true);
            }
        }
        //vbox2
        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        vbox2.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 42; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox2.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setDisable(true);
            }
        }
        //vbox3
        VBox vbox3 = new VBox();
        vbox3.setSpacing(20);
        vbox3.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox3.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setDisable(true);
            }
        }
        //vbox4
        VBox vbox4 = new VBox();
        vbox4.setSpacing(20);
        vbox4.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox4.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setDisable(true);
            }

        }
        //vbox5
        HBox hbox = new HBox(vbox1, vbox2, label, vbox3, vbox4);
        hbox.setStyle("-fx-background-color: #038573");
        Scene scene = new Scene(hbox);
        Stage stage = new Stage();
        stage.setScene(scene);

        Label label2 = new Label("Train Seat Booking ");
        label2.setFont(Font.font(20));

        //vbox1
        VBox vbox5 = new VBox();
        vbox5.setSpacing(20);
        vbox5.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox5.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setDisable(true);
            }
        }
        //vbox2
        VBox vbox6 = new VBox();
        vbox6.setSpacing(20);
        vbox6.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 42; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox6.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setDisable(true);
            }
        }
        //vbox3
        VBox vbox7 = new VBox();
        vbox7.setSpacing(20);
        vbox7.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox7.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setDisable(true);
            }
        }
        //vbox4
        VBox vbox8 = new VBox();
        vbox8.setSpacing(20);
        vbox8.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox8.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setDisable(true);
            }
        }
        //vbox5

        HBox hbox2 = new HBox(vbox5, vbox6, label2, vbox7, vbox8);
        hbox2.setStyle("-fx-background-color: #038573");
        Scene scene3 = new Scene(hbox2);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);

        Stage stage2 = new Stage();
        Scene scene1;
        Label label1 = new Label("Welcome to the Online Train Seat Booking System");
        label1.setLayoutX(120);
        label1.setLayoutY(10);
        label1.setFont(Font.font(20));
        Button button1 = new Button("Train from Colombo to Badulla");
        button1.setLayoutY(100);
        button1.setLayoutX(200);
        button1.setPrefSize(200, 50);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                stage.showAndWait();
            }
        });
        Button button2 = new Button("Train from Badulla to Colombo");
        button2.setLayoutY(200);
        button2.setLayoutX(200);
        button2.setPrefSize(200, 50);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene3);
                stage.showAndWait();
            }
        });

        AnchorPane layout1 = new AnchorPane();
        layout1.getChildren().addAll(label1, button1, button2);
        scene1 = new Scene(layout1, 700, 400);

        stage2.setScene(scene1);
        stage2.setTitle("Denuwara Menike Seat Booking");
        stage2.showAndWait();
    }

    //------------------------------------------------EMPTY SEATS-------------------------------------------------------
    private void viewEmptySeats(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {
        Label label = new Label("Train Seat Booking ");
        label.setFont(Font.font(20));

        //vbox1
        VBox vbox1 = new VBox();
        vbox1.setSpacing(20);
        vbox1.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox1.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setVisible(false);
            }
        }
        //vbox2
        VBox vbox2 = new VBox();
        vbox2.setSpacing(20);
        vbox2.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 42; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox2.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setVisible(false);
            }
        }
        //vbox3
        VBox vbox3 = new VBox();
        vbox3.setSpacing(20);
        vbox3.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox3.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setVisible(false);
            }
        }
        //vbox4
        VBox vbox4 = new VBox();
        vbox4.setSpacing(20);
        vbox4.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox4.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toBadulla.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setVisible(false);
            }
        }
        //vbox5
        HBox hbox = new HBox(vbox1, vbox2, label, vbox3, vbox4);
        hbox.setStyle("-fx-background-color: #038573");
        Scene scene = new Scene(hbox);
        Stage stage = new Stage();
        stage.setScene(scene);

        Label label2 = new Label("Train Seat Booking ");
        label2.setFont(Font.font(20));

        //vbox1
        VBox vbox5 = new VBox();
        vbox5.setSpacing(20);
        vbox5.setPadding(new Insets(30, 20, 30, 30));

        //add buttons

        for (int i = 0; i < 42; i = i + 4) {
            Button btn1 = new Button("No-" + (i + 1));
            vbox5.getChildren().add(btn1);
            btn1.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn1.getId())) {
                btn1.setTextFill(Color.RED);
                btn1.setVisible(false);
            }
        }
        //vbox2
        VBox vbox6 = new VBox();
        vbox6.setSpacing(20);
        vbox6.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 1; i < 42; i = i + 4) {
            Button btn2 = new Button("No-" + (i + 1));
            vbox6.getChildren().add(btn2);
            btn2.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn2.getId())) {
                btn2.setTextFill(Color.RED);
                btn2.setVisible(false);
            }
        }
        //vbox3
        VBox vbox7 = new VBox();
        vbox7.setSpacing(20);
        vbox7.setPadding(new Insets(30, 20, 30, 30));

        //add buttons
        for (int i = 2; i < 42; i = i + 4) {
            Button btn3 = new Button("No-" + (i + 1));
            vbox7.getChildren().add(btn3);
            btn3.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn3.getId())) {
                btn3.setTextFill(Color.RED);
                btn3.setVisible(false);
            }
        }
        //vbox4
        VBox vbox8 = new VBox();
        vbox8.setSpacing(20);
        vbox8.setPadding(new Insets(30, 30, 30, 10));

        //add buttons
        for (int i = 3; i < 42; i = i + 4) {
            Button btn4 = new Button("No-" + (i + 1));
            vbox8.getChildren().add(btn4);
            btn4.setId(String.valueOf(i + 1));
            if (toColombo.containsValue(btn4.getId())) {
                btn4.setTextFill(Color.RED);
                btn4.setVisible(false);
            }
        }
        //vbox5

        HBox hbox2 = new HBox(vbox5, vbox6, label2, vbox7, vbox8);
        hbox2.setStyle("-fx-background-color: #038573");

        Scene scene3 = new Scene(hbox2);
        Stage stage3 = new Stage();
        stage3.setScene(scene3);

        Stage stage2 = new Stage();
        Scene scene1;
        Label label1 = new Label("Welcome to the Online Train Seat Booking System");
        label1.setLayoutX(120);
        label1.setLayoutY(10);
        label1.setFont(Font.font(20));
        Button button1 = new Button("Train from Colombo to Badulla");
        button1.setLayoutY(100);
        button1.setLayoutX(200);
        button1.setPrefSize(200, 50);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene);
                stage.showAndWait();
            }
        });
        Button button2 = new Button("Train from Badulla to Colombo");
        button2.setLayoutY(200);
        button2.setLayoutX(200);
        button2.setPrefSize(200, 50);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(scene3);
                stage.showAndWait();
            }
        });

        AnchorPane layout1 = new AnchorPane();
        layout1.getChildren().addAll(label1, button1, button2);
        scene1 = new Scene(layout1, 700, 400);

        stage2.setScene(scene1);
        stage2.setTitle("Denuwara Menike Seat Booking");
        stage2.showAndWait();
    }
    //------------------------------------------------DELETE CUSTOMER---------------------------------------------------

    private void deleteBooking(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {

        String r;

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Press '1' to select Colombo-Badulla ");
        System.out.println("* Press '2' to select Badulla-Colombo ");
        r = scanner.nextLine();

        if (r.equalsIgnoreCase("1")) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Customers Name");
        String customer = sc.next();
        if (toBadulla.containsKey(customer)) {
            toBadulla.remove(customer);
            System.out.println("----------------------------------------------------------");
            System.out.println(customer + "'s seat has been successfully deleted");
            System.out.println("----------------------------------------------------------");

        }
        else{
            System.out.println("----------------------------------------------------------");
            System.out.println("No Bookings under the name " +customer );
            System.out.println("----------------------------------------------------------");
        }

    }
        else{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Customers Name");
            String customer = sc.next();
            if (toColombo.containsKey(customer)) {
                toColombo.remove(customer);
                System.out.println("----------------------------------------------------------");
                System.out.println(customer + "'s seat has been successfully deleted");
                System.out.println("----------------------------------------------------------");

            }
            else{
                System.out.println("No bookings under this name");
            }

        }

    }
    //------------------------------------------------FIND CUSTOMER----------------------------------------------------

    private void findSeatByCustomer(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Customers Name:");
        String customer = sc.next();
        if (toBadulla.containsKey(customer)) {
            String id = toBadulla.get(customer);
            System.out.println("----------------------------------------------------------");
            System.out.println(customer + "  has booked seat No: " + id + "to Badulla");
            System.out.println("----------------------------------------------------------");

        }
        if (toColombo.containsKey(customer)) {
            String id = toColombo.get(customer);
            System.out.println("----------------------------------------------------------");
            System.out.println(customer + "  has booked seat No: " + id + "to Colombo");

            System.out.println("----------------------------------------------------------");
        }

    }

    //------------------------------------------------STORE-------------------------------------------------------------

    private String store(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {

    String record;
            String r;

            Scanner scanner = new Scanner(System.in);
            System.out.println("* Press '1' to select Colombo-Badulla ");
            System.out.println("* Press '2' to select Badulla-Colombo ");
            r = scanner.nextLine();

            if (r.equalsIgnoreCase("1")) {
            record = toBadulla.toString();

            FileWriter fWriter;
            try {
            fWriter = new FileWriter("ColomboToBadulla.txt");
            fWriter.write(record);
            System.out.println("Writing successful");
            fWriter.close();

            return "Written to file successfully!";

            } catch (IOException e) {
            return "Data saving unsuccessful!";

            }
            }else{
            record = toColombo.toString();
            FileWriter fWriter;
            try {
            fWriter = new FileWriter("BadullaToColombo.txt");
            fWriter.write(record);
            System.out.println("Writing successful");
            fWriter.close();

            return "Written to file successfully!";

            } catch (IOException e) {
            return "Data saving unsuccessful!";

            }
            }
    }

    //------------------------------------------------LOAD--------------------------------------------------------------

    private String load(HashMap<String, String> toBadulla, HashMap<String, String> toColombo){

        String record;
        String r;

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Press '1' to select Colombo-Badulla ");
        System.out.println("* Press '2' to select Badulla-Colombo ");
        r = scanner.nextLine();

    if(r.equalsIgnoreCase("1")){
        File file = new File("ColomboToBadulla.txt");
    String text = "";
    Scanner in;
        try {
        in = new Scanner(file);
        while (in.hasNextLine()){
            text = text.concat(in.nextLine());
        }

        text = text.substring(1, text.length() - 1);

        String[] textList = text.split(", ");

        for (String s : textList) {

            String[] entry = s.split("=");
            System.out.print(entry[0]);
            System.out.print(" = ");
            System.out.println(entry[1]);
            System.out.println("----------------------------------------------------------");

            toBadulla.put(String.valueOf((entry[0])), entry[1]);

        }
        return "Data successfully loaded from file!";

        }catch (
        FileNotFoundException e){
            return "File not found!";
        }
    }else{
            File file;
            file = new File("BadullaToColombo.txt");
            String text = "";
            Scanner in;
            try {
                in = new Scanner(file);
                while (in.hasNextLine()){
                    text = text.concat(in.nextLine());
                }

                text = text.substring(1, text.length() - 1);

                String[] textList = text.split(", ");

                for (String s : textList) {

                    String[] entry = s.split("=");
                    System.out.println(entry[0]);
                    System.out.println(entry[1]);
                    toColombo.put(String.valueOf((entry[0])), entry[1]);

                }
                return "Data successfully loaded from file!";

            }catch (FileNotFoundException e){
                return "File not found!";
            }
        }

    }
    //------------------------------------------------ORDER CUSTOMER----------------------------------------------------

    private void ordercustomer(HashMap<String, String> toBadulla, HashMap<String, String> toColombo) {
        ArrayList<String> custName=new ArrayList<>();
        for(HashMap.Entry<String,String>entry:toBadulla.entrySet()){
            custName.add((String.valueOf(entry.getKey())));
        }
        for(HashMap.Entry<String,String>entry:toColombo.entrySet()){
            custName.add((String.valueOf(entry.getKey())));
        }
        String x;
        for(int j=0;j<custName.size();j++){
            for (int i=j+1;i<custName.size();i++){
                if(custName.get(i).compareTo(custName.get(j))<0){
                    x=custName.get(j);
                    custName.set(j,custName.get(i));
                    custName.set(i,x);
                }
            }
            System.out.println(custName.get(j));
        }
    }
}