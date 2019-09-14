package project;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CarPage {
 

    
  
	
	
	private String transmission;
	private String aircon;
    private TableView<Car> table = new TableView<Car>();
    private ObservableList<Car> data =
            FXCollections.observableArrayList(
            new Car("Myvi", "WC0202", 2011, "Hatchback", 1300, 150.00, "Auto", "Yes", 5, 3),
            new Car("Vios", "V202", 2016, "Sedan", 1500, 180.00, "Auto", "Yes", 4, 3),
            new Car("City", "K1022", 2017, "Sedan", 1300, 200.00, "Auto", "Yes", 4, 3),
            new Car("Civic", "WK5988", 2015, "Sedan", 1500, 220.00, "Manual", "Yes", 5, 3),
            new Car("Toyota rav4", "RV5988", 2017, "SUV", 2500, 250.00, "Manual", "Yes", 5, 5),
            new Car("Hyundai santa", "VG588", 2017, "SUV", 3500, 320.00, "Auto", "Yes", 5, 5),
            new Car("Mercedes Benz E Class", "S589", 2017, "Sedan", 4500, 420.00, "Auto", "Yes", 5, 2),
            new Car("BMW 5 series", "BMK688", 2017, "Sedan", 4500, 420.00, "Auto", "Yes", 5, 3),
            new Car("Jaguar XJ", "JCK5988", 2015, "Sedan", 3500, 450.00, "Auto", "Yes", 5, 3),
            new Car("BMW 3 series", "BM3688", 2016, "Sedan", 3500, 350.00, "Auto", "Yes", 5, 3),
            new Car("Avanza", "LC988", 2015, "MPV", 1500, 220.00, "Manual", "Yes", 7, 5),
            new Car("Alza", "WK8523", 2017, "MPV", 1500, 220.00, "Auto", "Yes", 7, 4),
            new Car("Hilux", "WC9992", 2016, "SUV", 2800, 300.00, "Manual", "Yes", 7, 3));
    
    
    
    private String[] type = {"Coupe", "Sedan", "SUV", "Van",
	"Hatchback"};
   
    final ScrollBar sc = new ScrollBar();
    
    final HBox hbtitle = new HBox();
    final HBox hb = new HBox();
    final HBox hb2 = new HBox();
    final HBox hbdelete = new HBox();
    
    
    
    /*public static void main(String[] args) {
        launch(args);
    }*/
 
    
    public void show(/*Stage stage*/) {
    	Stage stage = new Stage();
    	Group root = new Group();
        Scene scene = new Scene(root);
        stage.setTitle("KL Vehicle rental");
        stage.setWidth(900);
        stage.setHeight(700);

        Button btRental = new Button("                 Rental                 ");
		//btRental.setStyle("-fx-font: 15 arial;");
		Button btCarList = new Button("                 Car List                 ");
		//btRental.setStyle("-fx-font: 15 arial;");
		Button btMotorcycleList = new Button("            Motorcycle List            ");
		//btRental.setStyle("-fx-font: 15 arial;");
		Button btExit = new Button("                    Exit                    ");
		//btRental.setStyle("-fx-font: 15 arial;");
		
	    HBox hBox = new HBox();
	    hBox.setPadding(new Insets(5, 15, 15, 50));
	    //hBox.setStyle("-fx-background-color: gold");
	    hBox.getChildren().add(btRental);
	    hBox.getChildren().add(btCarList);
	    hBox.getChildren().add(btMotorcycleList);
	    hBox.getChildren().add(btExit);
		
 
        final Label label = new Label("Car List");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
 
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("Name"));
 
        TableColumn PlatNoCol = new TableColumn("Plat No.");
        PlatNoCol.setMinWidth(80);
        PlatNoCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("Plat_no"));
 
        TableColumn yearCol = new TableColumn("Year");
        yearCol.setMinWidth(50);
        yearCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("make"));
 
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(50);
        typeCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("type"));
 
        TableColumn ccCol = new TableColumn("CC");
        ccCol.setMinWidth(50);
        ccCol.setCellValueFactory(
                new PropertyValueFactory<Car, Integer>("cc"));
        
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(40);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Car, Double>("price"));
        
        TableColumn transmissionCol = new TableColumn("Transmission");
        transmissionCol.setMinWidth(80);
        transmissionCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("transmission"));
 
        TableColumn airconCol = new TableColumn("Air Con");
        airconCol.setMinWidth(50);
        airconCol.setCellValueFactory(
                new PropertyValueFactory<Car, String>("aircon"));
 
        TableColumn noOfPCol = new TableColumn("No. of passengers");
        noOfPCol.setMinWidth(100);
        noOfPCol.setCellValueFactory(
                new PropertyValueFactory<Car, Integer>("no_of_passenger"));
 
        TableColumn noOfLCol = new TableColumn("No. of laugage");
        noOfLCol.setMinWidth(100);
        noOfLCol.setCellValueFactory(
                new PropertyValueFactory<Car, Integer>("no_of_laugage"));
 
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(NameCol, PlatNoCol, yearCol, typeCol, ccCol,
        		priceCol, transmissionCol, airconCol, noOfPCol, noOfLCol);
 
        final TextField addName = new TextField();
        addName.setPromptText("Name");
        addName.setMaxWidth(NameCol.getPrefWidth());
        
        final TextField addPlatNo = new TextField();
        addPlatNo.setMaxWidth(PlatNoCol.getPrefWidth());
        addPlatNo.setPromptText("Plat_No.");
        
        final TextField addYear = new TextField();
        addYear.setMaxWidth(yearCol.getPrefWidth());
        addYear.setPromptText("Year");
        
        /*final TextField addType = new TextField();
        addType.setMaxWidth(typeCol.getPrefWidth());
        addType.setPromptText("Type");*/
        
        final TextField addCc = new TextField();
        addCc.setMaxWidth(ccCol.getPrefWidth());
        addCc.setPromptText("CC");
        
        final TextField addPrice = new TextField();
        addPrice.setMaxWidth(priceCol.getPrefWidth());
        addPrice.setPromptText("Price");
        
        final TextField addNoOfP = new TextField();
        addNoOfP.setMaxWidth(150);
        addNoOfP.setPromptText("Number of passenger");
        
        final TextField addNoOfL = new TextField();
        addNoOfL.setMaxWidth(150);
        addNoOfL.setPromptText("Number of laugage");
 
 
        ComboBox<String> addType = new ComboBox<>();
	    ObservableList<String> items = FXCollections.observableArrayList(type);
	    addType.getItems().addAll(items); 
	    addType.setValue("Sedan");
	    
 
 
        /*final RadioButton rbAuto = new TextField();
        addTransmission.setMaxWidth(transmissionCol.getPrefWidth());
        addTransmission.setPromptText("Transmission");
        */
	    
	    RadioButton rbAuto = new RadioButton ("Auto");
	    RadioButton rbManual = new RadioButton ("Manual");
	    
	    ToggleGroup group = new ToggleGroup();
	    rbAuto.setToggleGroup(group);
	    rbManual.setToggleGroup(group);
	    
	    
	    rbAuto.setOnAction(e -> {
	  	      if (rbAuto.isSelected()) {
	  	        transmission = "Auto";
	  	      }
	  	    });
			
		rbManual.setOnAction(e -> {
		  	      if (rbManual.isSelected()) {
		  	        transmission = "Manual";
		  	      }
		  	    });
	  	    
		
	    
        /*final TextField addAircon = new TextField();
        addAircon.setMaxWidth(airconCol.getPrefWidth());
        addAircon.setPromptText("Aircon");
        */
	    
	    
	    RadioButton rbYes = new RadioButton ("Yes");
	    RadioButton rbNo = new RadioButton ("No");
	    
	    ToggleGroup group2 = new ToggleGroup();
	    rbYes.setToggleGroup(group2);
	    rbNo.setToggleGroup(group2);
	    
 
		rbYes.setOnAction(e -> {
	  	      if (rbYes.isSelected()) {
	  	        aircon = "Yes";
	  	      }
	  	    });
			
			rbNo.setOnAction(e -> {
		  	      if (rbNo.isSelected()) {
		  	        aircon = "No";
		  	      }
		  	    });
	
 
        final Button addButton = new Button("     Add     ");
        addButton.setOnAction(e->{
        	
        	Alert alert1 = new Alert(AlertType.WARNING);
    		alert1.setTitle("Warning Dialog");        		
    		boolean no = false;
	    	
        	if(addName.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the name");
	    		alert1.showAndWait();
	    	}
        	
        	if(addPlatNo.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the plat No");
	    		alert1.showAndWait();
	    	}
        	
        	if(addYear.getLength() != 4)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid year");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addYear.getLength();i++){
            		
            		if((addYear.getText().charAt(i)>='a'&& addYear.getText().charAt(i)<='z')||
            				(addYear.getText().charAt(i)>='A'&&addYear.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Year must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}

        	
        	if(addCc.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the CC");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addCc.getLength();i++){
            		
            		if((addCc.getText().charAt(i)>='a'&& addCc.getText().charAt(i)<='z')||
            				(addCc.getText().charAt(i)>='A'&&addCc.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("CC must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}

        	
        	
        	if(addPrice.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the CC");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addPrice.getLength();i++){
            		
            		if((addPrice.getText().charAt(i)>='a'&& addPrice.getText().charAt(i)<='z')||
            				(addPrice.getText().charAt(i)>='A'&&addPrice.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Price must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}
        	
        	if(addNoOfP.getLength() >= 3)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid number of passenger");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addNoOfP.getLength();i++){
            		
            		if((addNoOfP.getText().charAt(i)>='a'&& addNoOfP.getText().charAt(i)<='z')||
            				(addNoOfP.getText().charAt(i)>='A'&&addNoOfP.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("No of Passenger must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}
 
        	
        	if(addNoOfL.getLength() >= 3)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid number of laugage");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addNoOfL.getLength();i++){
            		
            		if((addNoOfL.getText().charAt(i)>='a'&& addNoOfL.getText().charAt(i)<='z')||
            				(addNoOfL.getText().charAt(i)>='A'&&addNoOfL.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("No of Laugage must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}
        	
        	if(!rbAuto.isSelected() && !rbAuto.isSelected())
        	{
        		no = true;
	    		alert1.setContentText("Please select Trnsmission");
	    		alert1.showAndWait();
        	}
        	
        	if(!rbYes.isSelected() && !rbNo.isSelected())
        	{
        		no = true;
	    		alert1.setContentText("Please select Aircon availibility");
	    		alert1.showAndWait();
        	}

 //String name, String plat_no, int make, String type, int cc, double price, String transmission, String aircon, int no_of_passenger, int no_of_laugage
                if(!no)
                	{data.add(new Car(
                        addName.getText(),
                        addPlatNo.getText(),
                        new Integer(addYear.getText()),
                        addType.getValue(),
                        new Integer(addCc.getText()),
                        new Double(addPrice.getText()),
                        transmission,
                        aircon,
                        new Integer(addNoOfP.getText()),
                        new Integer(addNoOfL.getText())));
                addName.clear();
                addPlatNo.clear();
                addYear.clear();
                addCc.clear();
                addPrice.clear();
        		addNoOfP.clear();
        		addNoOfL.clear();}
	    	});
 
        hbtitle.getChildren().addAll(new Label("Name"), new Label("Plat No"),
        		new Label(" Year"), new Label("Cc"), new Label("       Price"),
        		new Label("    No of Passenger"), new Label(" No of Laugage"));
        hbtitle.setSpacing(50);
 
        hb.getChildren().addAll(addName, addPlatNo, addYear, addCc, addPrice,
        		addNoOfP, addNoOfL);
        hb.setSpacing(3);
 
        hb2.getChildren().addAll(new Label("Type: "), addType, new Label("        Transmission:"),
        		rbAuto, rbManual, new Label("          Aircon:"), rbYes, rbNo,
        		new Label("                                         "), addButton);
        hb2.setSpacing(3);
 
               
        final Button deleteButton = new Button("     Delete     ");
        deleteButton.setOnAction(e->
        {
        	ObservableList<Car> carSelected, allCar;
        	allCar = table.getItems();
        	carSelected = table.getSelectionModel().getSelectedItems();
        	
        	carSelected.forEach(allCar::remove);
        });
        
        
        btMotorcycleList.setOnAction(e->
	    {
	    	MotorcyclePage mp = new MotorcyclePage();
	    	stage.hide();
	    	mp.show();
	    	
	    }
	    );
	    
	    btRental.setOnAction(e->
	    {
	    	RentalPage rp = new RentalPage();
	    	stage.hide();
	    	rp.show();
	    	
	    }
	    );
	    
	    btExit.setOnAction(e->
	    {
	    	stage.hide();
	    }
	    );

        
        hbdelete.getChildren().addAll(new Label(""),deleteButton);
        hbdelete.setSpacing(700);
        
        final VBox vbox2 = new VBox();
        vbox2.setSpacing(10);
        vbox2.setPadding(new Insets(10, 10, 10, 10));
        vbox2.getChildren().addAll(hbtitle, hb, hb2);
        vbox2.setStyle("-fx-border-color:black ;-fx-border-width: 1;");
	    
        
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(hBox, label, table, hbdelete, vbox2);
        //vbox.setStyle("-fx-background-color:  lightgray;");

        //((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        root.getChildren().addAll(vbox, sc);
	    
	    
	    sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(600);
        sc.setMax(360);
        
        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    vbox.setLayoutY(-new_val.doubleValue());
            }
        });
        scene.setFill(Color.LIGHTGRAY);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("KL Vehicle Rental");
    }
    
	public ObservableList<Car> getCar() {
		// TODO Auto-generated method stub
		return data;
	}
}