

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Trainstation extends Application {
    HashMap<String, String> load = new HashMap<String, String>();
    HashMap<String, String> load2 = new HashMap<String, String>();
    HashMap<String, String> load3 = new HashMap<String, String>();

    //--------------------------------------------------ADD PASSENGER---------------------------------------------------


    @Override
    public void start(Stage primaryStage) throws Exception {

        String record;
        String r;
        File file = new File("ColomboToBadulla.txt");
        String text = "";
        Scanner in;
        try {
            in = new Scanner(file);
            while (in.hasNextLine()) {
                text = text.concat(in.nextLine());
            }

            text = text.substring(1, text.length() - 1);

            String[] textList = text.split(", ");

            for (String s : textList) {

                String[] entry = s.split("=");
                load.put(String.valueOf((entry[0])), entry[1]);

            }

        } catch (FileNotFoundException e) {
            System.out.println("----------------------------------------------------------");
            System.out.println("File not found");
            System.out.println("----------------------------------------------------------");

        }
        Stage stage = new Stage();
        Label label = new Label("SELECT THE PASSENGERS TO BOARD TO THE WAITING ROOM");
        label.setLayoutY(500);
        label.setLayoutX(600);
        label.setFont(Font.font(18));


        FlowPane flowPane = new FlowPane(label);
        flowPane.setVgap(20);
        flowPane.setHgap(20);
        for (HashMap.Entry<String, String> entry : load.entrySet()) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(entry.getKey());
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    load2.put(entry.getValue(), entry.getKey());
                    button.setDisable(true);
                }
            });
            flowPane.getChildren().add(button);

        }

        Scene scene = new Scene(flowPane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Check-In");
        stage.showAndWait();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Press A to add passengers to Train Queue");
            System.out.println("Press V to view passengers in the Train Queue");
            System.out.println("Press D to remove passengers from the Train Queue");
            System.out.println("Press S to save the passenger details.");
            System.out.println("Press L to load the passenger details");
            System.out.println("Press Q to Exit the program");

            String option = sc.next().toLowerCase();
            switch (option) {
                case ("a"):
                case ("A"):
                    add();
                    break;
                case ("v"):
                case ("V"):
                    view();
                    break;
                case ("d"):
                case ("D"):
                    delete(load3);
                    break;
                case ("s"):
                case ("S"):
                    store(load3);
                    break;
                case ("l"):
                case ("L"):
                    loadPassenger();
                    break;
                case ("q"):
                case ("Q"):
                    quit();
                    break;
                default:
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Enter a valid input");
                    System.out.println("----------------------------------------------------------");

            }
        }

    }
    private void add() {
        Stage stage = new Stage();
        Label label2 = new Label("PASSENGER WAITING ROOM");
        Label label3 = new Label("Click on the 'ADD' button to randomly add the passengers to the queue");
        label3.setFont(Font.font(15));
        label2.setFont(Font.font(35));
        FlowPane flowPane = new FlowPane(label2,label3);
        flowPane.setVgap(20);
        flowPane.setHgap(20);
        for (HashMap.Entry<String, String> entry : load2.entrySet()) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(entry.getValue());
            flowPane.getChildren().add(button);

        }
        javafx.scene.control.Button add = new javafx.scene.control.Button("ADD");

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (load2.size() == 0) {
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Waiting room is empty");
                    System.out.println("----------------------------------------------------------");

                } else {
                    Random dice = new Random();
                    int random;
                    random = dice.nextInt(6) + 1;
                    for (int i = 0; i < random; i++) {
                        Object[] random2 = load2.keySet().toArray();
                        Object key = random2[new Random().nextInt(random2.length)];
                        load3.put(load2.get(key), (String) key);
                        load2.remove((String) key, load2.get(key));
                        Passenger passenger = new Passenger();
                        passenger.setName(load2.get(key), (String) key);

                    }
                    trainqueue();
                }

            }
        });

        flowPane.getChildren().add(add);
        Scene scene = new Scene(flowPane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Waiting Room");
        stage.showAndWait();
    }

    private void trainqueue() {
        Stage stage1 = new Stage();
        Label label3 =new Label("PASSENGERS BOARDING TRAIN QUEUE");
        label3.setFont(Font.font(25));
        FlowPane flowPane2 = new FlowPane(label3);
        flowPane2.setVgap(20);
        flowPane2.setHgap(20);
        for (HashMap.Entry<String, String> entry : load3.entrySet()) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(entry.getKey());
            flowPane2.getChildren().add(button);

        }
        Scene scene2 = new Scene(flowPane2, 500, 500);
        stage1.setScene(scene2);
        stage1.setTitle("TrainQueue");
        stage1.showAndWait();
    }
    //------------------------------------------------VIEW TRAIN QUEUE--------------------------------------------------

    private void view() {

        Stage stage1 = new Stage();
        FlowPane flowPane2 = new FlowPane();
        flowPane2.setVgap(20);
        flowPane2.setHgap(20);
        for (HashMap.Entry<String, String> entry : load3.entrySet()) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(entry.getKey());
            flowPane2.getChildren().add(button);

        }
        Scene scene2 = new Scene(flowPane2, 500, 500);
        stage1.setScene(scene2);
        stage1.setTitle("Train Queue");
        stage1.showAndWait();
    }
    //-------------------------------------------DELETE PASSENGER BOOKING-----------------------------------------------

    private void delete(HashMap<String, String> load3) {

        String r;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'Y' to continue");
        r = scanner.nextLine();

        if (r.equalsIgnoreCase("Y")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter The Customers Name");
            String customer = sc.next();
            if (load3.containsKey(customer)) {
                load3.remove(customer);
                System.out.println("----------------------------------------------------------");
                System.out.println(customer + "'s seat has been successfully deleted");
                System.out.println("----------------------------------------------------------");

            } else {
                System.out.println("----------------------------------------------------------");
                System.out.println("No Bookings under the name " + customer);
                System.out.println("----------------------------------------------------------");
            }
            trainqueue();
        }

    }
    //--------------------------------------------PASSENGER DETAILS STORE-----------------------------------------------

    private void store(HashMap<String, String> load3) {
        String record;
        String r;

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Press 'Y' to store the details ");
        r = scanner.nextLine();

        if (r.equalsIgnoreCase("Y")) {
            record = load3.toString();

            FileWriter fWriter;
            try {
                fWriter = new FileWriter("TrainQueue.txt");
                fWriter.write(record);
                System.out.println("----------------------------------------------------------");
                System.out.println("Writing successful");
                System.out.println("----------------------------------------------------------");
                fWriter.close();


            } catch (IOException e) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Writing unsuccessful");
                System.out.println("----------------------------------------------------------");


            }
        }
    }
    //--------------------------------------------LOAD PASSENGER DETAILS------------------------------------------------

    private void loadPassenger() {
        String record;
        String r;

        Scanner scanner = new Scanner(System.in);
        System.out.println("* Press 'Y' to select Colombo-Badulla ");
        r = scanner.nextLine();

        if (r.equalsIgnoreCase("Y")) {
            File file = new File("TrainQueue.txt");
            String text = "";
            Scanner in;
            try {
                in = new Scanner(file);
                while (in.hasNextLine()) {
                    text = text.concat(in.nextLine());
                }

                text = text.substring(1, text.length() - 1);

                String[] textList = text.split(", ");

                for (String s : textList) {

                    String[] entry = s.split("=");
                    System.out.print(entry[0]);
                    System.out.print(" = ");
                    System.out.println(entry[1]);

                }

            } catch (
                    FileNotFoundException e) {
                System.out.println("----------------------------------------------------------");
                System.out.println("File not found");
                System.out.println("----------------------------------------------------------");

            }

        }

    }
    //--------------------------------------------------------QUIT------------------------------------------------------

    private void quit() {
        System.out.println("----------------------------------------------------------");
        System.out.print("Thanks You for travelling with us");
        System.out.println("----------------------------------------------------------");

        System.exit(0);
    }

}
//----------------------------------------------------------------------------------------------------------------------
