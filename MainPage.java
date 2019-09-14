package project;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainPage extends Application{
		
	RentalPage rp = new RentalPage();
	
	
		public void start(Stage primaryStage) {
	
			
			GridPane pane = new GridPane();
		    pane.setAlignment(Pos.CENTER);
		    pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		    pane.setHgap(5.5);
		    pane.setVgap(5.5);
		    pane.setStyle("-fx-background-color:  palegoldenrod;-fx-border-color:dimgray;-fx-border-width: 4;");
	        
		    
		    // Place nodes in the pane
		    pane.add(new Label("User Name"), 0, 0);
		    TextField tfUserName = new TextField();
		    pane.add(tfUserName, 0, 1);
		    
		    pane.add(new Label("Password"), 0, 2);
		    PasswordField pfPassword = new PasswordField();
		    pane.add(pfPassword, 0, 3);
		    
		    Button btLogin = new Button("Login");
		    
		    pane.add(btLogin, 0, 4);
		    GridPane.setHalignment(btLogin, HPos.RIGHT);
		    
		    
		    Image image = new Image("image/Cover.jpg");
		    ImageView ivWelcome = new ImageView(image);
		    ivWelcome.setFitHeight(570);
		    ivWelcome.setFitWidth(680);
		    
		    
		    HBox hBox = new HBox();
		    hBox.setPadding(new Insets(15, 15, 15, 15));
		    //hBox.setStyle("-fx-background-color: gold");
		    hBox.getChildren().add(ivWelcome);
		    hBox.getChildren().add(pane); 
		    hBox.setStyle("-fx-background-color:  lightgray;");

		    
		    
		    // Create a scene and place it in the stage
		    Scene scene = new Scene(hBox, 900, 600);
		    primaryStage.setTitle("KL Vehicle Rental"); // Set the stage title
		    primaryStage.setScene(scene); // Place the scene in the stage
		    primaryStage.show(); // Display the stage
		    
		    
		    
		    btLogin.setOnAction(e->
		    {
		    	if((tfUserName.getText().equals("admin")) && pfPassword.getText().equals("123456"))
		    	{
		    		rp.show();
	                primaryStage.hide();
		    	}
		    	else
		    	{
		    		Alert alert = new Alert(AlertType.WARNING);
	        		alert.setTitle("Warning Dialog");        		
	        		alert.setContentText("Invalid username or password");
	        		alert.showAndWait();

		    	}
		    }
		    );
		}
		
		
		public static void main(String[] args) {
		    launch(args);
		  }

	}


