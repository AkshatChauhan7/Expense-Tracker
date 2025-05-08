package FinanceTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginRegister {
    private BorderPane root;

    public LoginRegister() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #0f2027, #203a43, #2c5364);");

        VBox formBox = new VBox(20);
        formBox.setPadding(new Insets(40));
        formBox.setAlignment(Pos.CENTER);
        formBox.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.05);" +
                        "-fx-background-radius: 20;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 15, 0, 0, 5);"
        );

        Text title = new Text("Expense Tracker");
        title.setFont(Font.font("Segoe UI Semibold", 28));
        title.setFill(Color.WHITE);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        styleInput(usernameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleInput(passwordField);

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
        styleButton(loginButton, "#4CAF50");
        styleButton(registerButton, "#2196F3");

        Label status = new Label();
        status.setTextFill(Color.LIGHTGRAY);

        loginButton.setOnAction(e -> {
            boolean success = DatabaseHelper.login(usernameField.getText(), passwordField.getText());
            status.setText(success ? "✅ Login successful!" : "❌ Invalid credentials.");
        });

        registerButton.setOnAction(e -> {
            boolean success = DatabaseHelper.register(usernameField.getText(), passwordField.getText());
            status.setText(success ? "✅ Registration successful!" : "⚠️ Username already exists or error.");
        });

        formBox.getChildren().addAll(
                title,
                usernameField,
                passwordField,
                loginButton,
                registerButton,
                status
        );

        root.setCenter(formBox);
    }

    public Pane getView() {
        return root;
    }

    // Style text fields
    private void styleInput(TextField field) {
        field.setStyle(
                "-fx-background-color: #2e3b4e;" +
                        "-fx-text-fill: white;" +
                        "-fx-prompt-text-fill: gray;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-radius: 10;" +
                        "-fx-padding: 10;"
        );
        field.setMaxWidth(250);
    }

    // Style buttons with color and rounded corners
    private void styleButton(Button button, String color) {
        button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 20;"
        );
        button.setOnMouseEntered(e -> button.setStyle(
                "-fx-background-color: derive(" + color + ", 20%);" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 20;"
        ));
        button.setOnMouseExited(e -> button.setStyle(
                "-fx-background-color: " + color + ";" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 10;" +
                        "-fx-padding: 10 20;"
        ));
    }
}
