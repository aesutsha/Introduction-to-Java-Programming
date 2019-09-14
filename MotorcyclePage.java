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

public class MotorcyclePage {
 
	
	
	private String transmission;
	private String aircon;
    private TableView<Motorcycle> table = new TableView<Motorcycle>();
    private ObservableList<Motorcycle> data =
            FXCollections.observableArrayList(
            new Motorcycle("Yamaha LC", "Wk202", 2011, "Underbone", 135, 150.00, 1, 15),
            new Motorcycle("CBR 250", "WN 58", 2016, "Sports", 250, 250.00, 2, 20),
            new Motorcycle("BMW tourer", "B4802", 2011, "Touring", 1135, 450.00, 2, 24),
            new Motorcycle("Honda NC700", "WY462", 2016, "Touring", 700, 350.00, 2, 24),
            new Motorcycle("Honda grom", "B9902", 2016, "Sport", 200, 250.00, 1, 22),
            new Motorcycle("NAZA gtr", "WK902", 2016, "Sport", 250, 350.00, 2, 23),
            new Motorcycle("Nimota", "WT5602", 2015, "Roadster", 150, 150.00, 1, 20),
            new Motorcycle("Yamaha fz150", "WT582", 2016, "Roadster", 150, 150.00, 1, 20),
            new Motorcycle("Kawasaki z250", "WK2345", 2016, "Sport", 250, 250.00, 2, 24),
            new Motorcycle("Vespa", "VC4802", 2016, "Scooter", 150, 150.00, 1, 19),
            new Motorcycle("Honda tourer", "WY552", 2017, "Touring", 850, 350.00, 2, 24),
            new Motorcycle("Yamaha R1", "WR9852", 2017, "Sport", 1000, 550.00, 2, 24),
            new Motorcycle("Ducati 1198", "D402", 2015, "Sports", 850, 650.00, 3, 25)
            );
    
    private String[] type = {"Scooter", "Underbone", "Sports", "Touring", "Off Road", "Roadster"};
    
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
		
 
        final Label label = new Label("Motorcycle List");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        
        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(120);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, String>("Name"));
 
        TableColumn PlatNoCol = new TableColumn("Plat No.");
        PlatNoCol.setMinWidth(120);
        PlatNoCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, String>("Plat_no"));
 
        TableColumn yearCol = new TableColumn("Year");
        yearCol.setMinWidth(80);
        yearCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, Integer>("make"));
 
        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(110);
        typeCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, String>("type"));
 
        TableColumn ccCol = new TableColumn("CC");
        ccCol.setMinWidth(80);
        ccCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, Integer>("cc"));
        
        TableColumn priceCol = new TableColumn("Price");
        priceCol.setMinWidth(80);
        priceCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, Double>("price"));
        
        TableColumn minExCol = new TableColumn("Minimum experience");
        minExCol.setMinWidth(130);
        minExCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, Integer>("min_experience"));
 
        TableColumn minAgeCol = new TableColumn("Minimum age");
        minAgeCol.setMinWidth(120);
        minAgeCol.setCellValueFactory(
                new PropertyValueFactory<Motorcycle, Integer>("min_age"));
 
        table.setItems(data);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(NameCol, PlatNoCol, yearCol, typeCol, ccCol,
        		priceCol, minExCol, minAgeCol);
 
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
        
        final TextField addMinEx = new TextField();
        addMinEx.setMaxWidth(150);
        addMinEx.setPromptText("Min experience");
        
        final TextField addMinAge = new TextField();
        addMinAge.setMaxWidth(150);
        addMinAge.setPromptText("Min age");
        
        
 
        ComboBox<String> addType = new ComboBox<>();
	    ObservableList<String> items = FXCollections.observableArrayList(type);
	    addType.getItems().addAll(items); 
	    addType.setValue("Scooter");
	    
 
 
        /*final RadioButton rbAuto = new TextField();
        addTransmission.setMaxWidth(transmissionCol.getPrefWidth());
        addTransmission.setPromptText("Transmission");
        */
	    
	     
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

        	
        	
        	
        	if(addMinEx.getLength() != 2)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid Min experience");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addMinEx.getLength();i++){
            		
            		if((addMinEx.getText().charAt(i)>='a'&& addMinEx.getText().charAt(i)<='z')||
            				(addMinEx.getText().charAt(i)>='A'&&addMinEx.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Min experience must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}

        	

        	if(addMinAge.getLength() != 2)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid Min age");
	    		alert1.showAndWait();
	    	}
        	else
	    	{
	    		for(int i=0;i<addMinAge.getLength();i++){
            		
            		if((addMinAge.getText().charAt(i)>='a'&& addMinAge.getText().charAt(i)<='z')||
            				(addMinAge.getText().charAt(i)>='A'&&addMinAge.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Min age must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}}
        	
        	
        	
        	
        	
                if(!no)
                	{data.add(new Motorcycle(
                        addName.getText(),
                        addPlatNo.getText(),
                        new Integer(addYear.getText()),
                        addType.getValue(),
                        new Integer(addCc.getText()),
                        new Double(addPrice.getText()),
                        new Integer(addMinEx.getText()),
                        new Integer(addMinAge.getText())));
                addName.clear();
                addPlatNo.clear();
                addYear.clear();
                addCc.clear();
                addPrice.clear();
        		addMinEx.clear();
        		addMinAge.clear();}
            });
 
        hbtitle.getChildren().addAll(new Label("Name"), new Label("Plat No"),
        		new Label(" Year"), new Label("Cc"), new Label("       Price"),
        		new Label("   Minimum Experience"), new Label("Minimum Age"));
        hbtitle.setSpacing(50);
 
        hb.getChildren().addAll(addName, addPlatNo, addYear, addCc, addPrice,
        		addMinEx, addMinAge);
        hb.setSpacing(3);
 
        hb2.getChildren().addAll(new Label("Type: "), addType, 
        		new Label("                                         "),
        		new Label("                                         "), 
        		new Label("                                         "), addButton);
        hb2.setSpacing(3);
         
        
        final Button deleteButton = new Button("     Delete     ");
        deleteButton.setOnAction(e->
        {
        	ObservableList<Motorcycle> mcSelected, allmc;
        	allmc = table.getItems();
        	mcSelected = table.getSelectionModel().getSelectedItems();
        	
        	mcSelected.forEach(allmc::remove);
        });
        
        
        hbdelete.getChildren().addAll(new Label(""),deleteButton);
        hbdelete.setSpacing(700);
        
        
        btCarList.setOnAction(e->
	    {
	    	CarPage cp = new CarPage();
	    	stage.hide();
	    	cp.show();
	    	
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

       // ((Group) scene.getRoot()).getChildren().addAll(vbox);
        
        
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
    public ObservableList<Motorcycle> getMotorcycle() {
		// TODO Auto-generated method stub
		return data;
	}
	
}