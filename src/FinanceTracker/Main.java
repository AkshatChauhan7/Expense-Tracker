package FinanceTracker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginRegister loginScreen = new LoginRegister();
        Scene scene = new Scene(loginScreen.getView(), 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Expense Tracker - Login");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
