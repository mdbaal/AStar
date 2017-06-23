package main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root,1000,1000));
        Game game = new Game();
        game.start();
        root.getChildren().add(game.getGridPane());
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);



    }
}
