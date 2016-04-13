import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class Main extends Application{
	Stage window = new Stage();
	public static void main(String[] args){
		try {
			Connection c = DBconnect.connect();
			Statement stmt = c.createStatement();
			String SQL = "SELECT * FROM Location";
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			String first = rs.getString("Address");
			System.out.println(first);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		window = primaryStage;
		window.setTitle("Dulce Tapioca");

		/* ==================LOGIN GRID================= */
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setStyle("-fx-background-color: #B09268");
		grid.setAlignment(Pos.CENTER);

		/*
		 * ==================WINDOW DISPLAY================ This sets up the
		 * scenes and shows the windows.
		 */
		Scene logMenu = new Scene(grid, 400, 400);
		window.setScene(logMenu);
		window.show();
		
		// Name Label, placed in grid 0, 0
				Label userLabel = new Label("Username");
				GridPane.setConstraints(userLabel, 0, 1);
				userLabel.setStyle("-fx-font: 16.5 arial;");

				// Name Input, placed in grid 1, 0
				TextField userIn = new TextField();
				userIn.setPromptText("username");
				GridPane.setConstraints(userIn, 1, 1);

				// Password Label, placed in grid 0, 1
				Label passLabel = new Label("Password");
				passLabel.setStyle("-fx-font: 16.5 arial;");
				GridPane.setConstraints(passLabel, 0, 2);

				// Password Input
				/*
				 * TextField passIn = new TextField(); passIn.setPromptText("password");
				 */
				PasswordField passIn = new PasswordField();
				passIn.setPromptText("password");

				GridPane.setConstraints(passIn, 1, 2);

				// Login Button,
				Button logButt = new Button("Login");
				logButt.setStyle("-fx-font: 16.5 arial; -fx-base: #FFC524");
				logButt.setMinWidth(250);
				logButt.setAlignment(Pos.CENTER);
				GridPane.setConstraints(logButt, 1, 4);

				Image disImg = new Image("tapioca.png");
				ImageView iv1 = new ImageView();
				iv1.setImage(disImg);
				GridPane.setConstraints(iv1, 1, 0);

				grid.getChildren().addAll(userLabel, userIn, passLabel, passIn, logButt, iv1);
				/*
				 * ==================================CONDITIONAL
				 * LOGIN==============================================
				 */

				logButt.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent e) {

						if ((userIn.getText() != null && userIn.getText().contains("a")) && passIn.getText().contains("a")) {
							System.out.println("Success!");
						} else if ((userIn.getText() != null && userIn.getText().contains("Customer"))
								&& passIn.getText().contains("Customer")) {
							System.out.println("Success!");
						} else {
							
							System.out.println("looololol, try 'a' in both fields or 'Customer' in both fields");

						}

					}

				});
	}
}
