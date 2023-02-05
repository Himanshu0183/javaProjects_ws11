/**********************************************
 Workshop 11
 Course: JAC 444 - Summer 2022
 Last Name: Himanshu
 First Name: Himanshu
 ID: 146109202
 Section: ZBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature  Himanshu
 Date: 08/19/2022
 **********************************************/

package com.himanshu.workshop11;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client_RMI extends Application {

    Weather_Interface calculator;

    public static boolean validateDate(String strDate) {
        if (strDate.trim().equals("")) {
            return true;
        } else {
            SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
            sdfrmt.setLenient(false);

            try {
                Date javaDate = sdfrmt.parse(strDate);
                System.out.println(strDate + " is valid date format");
            } catch (ParseException e) {
                System.out.println(strDate + " is Invalid Date format");
                return false;
            }
            return true;
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        TextField clientInput = new TextField();

        Button btnSend = new Button("Get report");
        Label label = new Label("Enter date (mm/dd/yyyy):");
        HBox hBox = new HBox(label, clientInput, btnSend);
        Font font1 = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14);
        label.setFont(font1);
        btnSend.setFont(font1);
        clientInput.setFont(font1);

        hBox.setSpacing(8);
        label.setPadding(new Insets(10, 10, 10, 10));
        clientInput.setPadding(new Insets(10, 10, 10, 10));
        btnSend.setPadding(new Insets(10, 10, 10, 10));
        clientInput.requestFocus();

        Label data = new Label();
        data.setPadding(new Insets(10, 10, 10, 10));
        data.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));

        Label date = new Label();
        Label temperature = new Label();
        Label rain = new Label();
        Label snow = new Label();
        Label daylight = new Label();
        Label cloud = new Label();

        GridPane gridPane = new GridPane();

        btnSend.setOnAction(actionEvent -> {
            if (validateDate(clientInput.getText().trim())) {
                Weather result;
                try {
                    data.setStyle("-fx-text-fill: green;");
                    Registry regs = LocateRegistry.getRegistry("localhost", 3000);
                    calculator = (Weather_Interface) regs.lookup("Weather");
                    result = calculator.getWeather(clientInput.getText().trim());

                    if (result.getDate().equals("")) {
                        gridPane.setVisible(false);
                        data.setStyle("-fx-text-fill: red;");
                        System.out.println("Results: wrong date / record not found ");
                        data.setText("Results: wrong date / record not found ");
                    } else {
                        gridPane.setVisible(true);
                        System.out.println("Results:  ");
                        data.setText("Results: (Avarage Stats) ");
                        System.out.println("Server results: " + result);

                        date.setText(result.getDate());
                        temperature.setText(result.getTemperature());
                        rain.setText(result.getRain());
                        snow.setText(result.getSnow());
                        daylight.setText(result.getDaylight());
                        cloud.setText(result.getCloud());

                    }


                } catch (Exception e) {

                    System.out.println(e);
                }
            } else {
                gridPane.setVisible(false);
                data.setStyle("-fx-text-fill: red;");
                System.out.println("Results: Invalid Date (MM/dd/yyyy) ");
                data.setText("ERROR: Invalid Date (MM/dd/yyyy) entered");
            }
            clientInput.requestFocus();
        });

//        date,temperature,rain,snow,daylight,cloud
        Label lable1 = new Label("Date: ");
        Label lable2 = new Label("Temperature: ");
        Label lable3 = new Label("Rain:");
        Label lable4 = new Label("Snow: ");
        Label lable5 = new Label("Daylight: ");
        Label lable6 = new Label("Cloud: ");

        lable6.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable6.setStyle("-fx-text-fill: green;");
        lable5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable5.setStyle("-fx-text-fill: green;");
        lable4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable4.setStyle("-fx-text-fill: green;");
        lable3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable3.setStyle("-fx-text-fill: green;");
        lable2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable2.setStyle("-fx-text-fill: green;");
        lable1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        lable1.setStyle("-fx-text-fill: green;");


        gridPane.add(lable1, 0, 0);
        gridPane.add(lable2, 0, 1);
        gridPane.add(lable3, 0, 2);
        gridPane.add(lable4, 0, 3);
        gridPane.add(lable5, 0, 4);
        gridPane.add(lable6, 0, 5);


        date.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        date.setStyle("-fx-text-fill: brown;");
        temperature.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        temperature.setStyle("-fx-text-fill: brown;");
        rain.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        rain.setStyle("-fx-text-fill: brown;");
        snow.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        snow.setStyle("-fx-text-fill: brown;");
        daylight.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        daylight.setStyle("-fx-text-fill: brown;");
        cloud.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        cloud.setStyle("-fx-text-fill: brown;");

        gridPane.add(date, 1, 0);
        gridPane.add(temperature, 1, 1);
        gridPane.add(rain, 1, 2);
        gridPane.add(snow, 1, 3);
        gridPane.add(daylight, 1, 4);
        gridPane.add(cloud, 1, 5);


        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label title = new Label("weather update (01/01/2018 to 08/18/2022)");
        title.setStyle("-fx-text-fill: orange;");
        title.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        title.setPadding(new Insets(10, 10, 10, 10));


        VBox vBox = new VBox(title, hBox, data, gridPane);
        Scene scene = new Scene(vBox, 620, 340);
        stage.setTitle("Weather update system");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}