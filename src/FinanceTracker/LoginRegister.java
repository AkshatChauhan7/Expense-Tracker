package FinanceTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LoginRegister {
    private BorderPane root;
    private VBox formBox;
    private Label status;

    public LoginRegister() {
        root = new BorderPane();
        root.setStyle("-fx-background-color: linear-gradient(to bottom right, #493D9E, #203a43, #2c5364);");

        formBox = new VBox(20);
        formBox.setPadding(new Insets(40));
        formBox.setAlignment(Pos.CENTER);
        formBox.setStyle(
                "-fx-background-color: rgba(255, 255, 255, 0.05);" +
                        "-fx-background-radius: 20;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 15, 0, 0, 5);"
        );

        root.setCenter(formBox);
        showLoginForm();
    }

    public Pane getView() {
        return root;
    }

    private void showLoginForm() {
        formBox.getChildren().clear();

        Text appTitle = new Text("EXPENSE TRACKER");
        appTitle.setFont(Font.font("Segoe UI Semibold", 34));
        appTitle.setFill(Color.WHITE);

        Text title = new Text("Login");
        title.setFont(Font.font("Segoe UI Semibold", 26));
        title.setFill(Color.WHITE);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        styleInput(usernameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleInput(passwordField);

        Button loginButton = new Button("Login");
        styleButton(loginButton, "#4CAF50");

        status = new Label();
        status.setTextFill(Color.LIGHTGRAY);

        loginButton.setOnAction(e -> {
            boolean success = DatabaseHelper.validateLogin(usernameField.getText(), passwordField.getText());
            status.setText(success ? "✅ Login successful!" : "❌ Invalid credentials.");
        });

        Hyperlink switchToRegister = new Hyperlink("Don't have an account? Register");
        switchToRegister.setFont(Font.font("Segoe UI Semibold", 20));
        switchToRegister.setOnAction(e -> showRegisterForm());

        formBox.getChildren().addAll(appTitle, title, usernameField, passwordField, loginButton, status, switchToRegister);
    }

    private void showRegisterForm() {
        formBox.getChildren().clear();

        Text appTitle = new Text("EXPENSE TRACKER");
        appTitle.setFont(Font.font("Segoe UI Semibold", 34));
        appTitle.setFill(Color.WHITE);

        Text title = new Text("Register");
        title.setFont(Font.font("Segoe UI Semibold", 26));
        title.setFill(Color.WHITE);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");
        styleInput(usernameField);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        styleInput(passwordField);

        Button registerButton = new Button("Register");
        styleButton(registerButton, "#2196F3");

        status = new Label();
        status.setTextFill(Color.LIGHTGRAY);

        registerButton.setOnAction(e -> {
            boolean success = DatabaseHelper.registerUser(usernameField.getText(), passwordField.getText());
            status.setText(success ? "✅ Registration successful!" : "⚠️ Username may already exist.");
        });

        Hyperlink switchToLogin = new Hyperlink("Already have an account? Login");
        switchToLogin.setFont(Font.font("Segoe UI Semibold", 20));
        switchToLogin.setOnAction(e -> showLoginForm());

        formBox.getChildren().addAll(appTitle, title, usernameField, passwordField, registerButton, status, switchToLogin);
    }

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
