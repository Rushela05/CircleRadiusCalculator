package org.example.radiuscalculator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;


public class RadiusCal extends Application {
    @Override
    public void start(Stage primaryStage) {


        //Grid Pane for layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // To center the Grid Pane
        grid.setHgap(10);
        grid.setVgap(12);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Custom font and font size
        Font labelFont = Font.font("Arial", 18);

        //Create labels and fields
        Label titleLabel = new Label("Radius Calculator");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD,24));
        grid.add(titleLabel, 0, 0, 4, 1);

        Label equationLabel = new Label("Equation: x² + y² + 2gx + 2fy + c = 0");
        equationLabel.setFont(labelFont);
        grid.add(equationLabel, 0, 1, 4, 1);

        Label gLabel = new Label("g: ");
        gLabel.setFont(labelFont);
        TextField gField1 = new TextField();
        gField1.setFont(labelFont);
        grid.add(gLabel, 0, 2);
        grid.add(gField1, 1, 2);

        Label fLabel = new Label("f: ");
        fLabel.setFont(labelFont);
        TextField fField1 = new TextField();
        fField1.setFont(labelFont);
        grid.add(fLabel, 2, 2);
        grid.add(fField1, 3, 2);

        Label cLabel = new Label("c: ");
        cLabel.setFont(labelFont);
        TextField cField1 = new TextField();
        cField1.setFont(labelFont);
        grid.add(cLabel, 0, 3);
        grid.add(cField1, 1, 3);


        //Button
        Button calculateBtn = new Button("Calculate");
        calculateBtn.setFont(labelFont);
        grid.add(calculateBtn, 2, 5);
        calculateBtn.setPrefWidth(120);

        //Label to show the result
        Label resultLabel = new Label("Radius = ");
        resultLabel.setFont(new Font("Arial", 20));
        grid.add(resultLabel, 0, 4, 4, 1);

        //Action on button click
        calculateBtn.setOnAction(e -> {
            try{
                double g = Double.parseDouble(gField1.getText());
                double f = Double.parseDouble(fField1.getText());
                double c = Double.parseDouble(cField1.getText());

                double radius = RadiusCalBackend.calculateRadius(g,f,c);
                resultLabel.setText(String.format("Radius = " + radius));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input");
            } catch (IllegalArgumentException ex){
                resultLabel.setText(ex.getMessage());
            }
        });

        Scene scene = new Scene(grid, 700, 400);
        primaryStage.setTitle("Circle Radius Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

}

