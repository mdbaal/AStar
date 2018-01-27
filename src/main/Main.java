package main;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("AStar");
        primaryStage.setScene(new Scene(root,1920,1080));
        Game game = new Game();
        game.makeGrid();
        root.getChildren().add(game.getGridPane());
        root.getChildren().add(game.getButton());
        root.getChildren().add(game.getMove());
        root.getChildren().get(2).setLayoutX(50);


        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);



    }
}
