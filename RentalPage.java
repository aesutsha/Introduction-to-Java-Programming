package project;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class RentalPage {
	
	CarPage cp = new CarPage();
	MotorcyclePage mp = new MotorcyclePage();
	
	private static ObservableList<Car> Carlist;
	private static ObservableList<Motorcycle> Motorcyclelist;
	private static TableView<Car> tableCar = new TableView<Car>();
	private static TableView<Motorcycle> tableMotorcycle = new TableView<Motorcycle>();
    private String vName;
    private double total;
    private long totalDays;
    private boolean carCheck;
    private boolean motorcycleCheck;
    private double price;
    private static ArrayList<Rental> r = new ArrayList<Rental>();
    private Rental rn = new Rental();
    private Customer c;
		
       
    private String[] location = {"Gombak", "Wangsa maju", "Ampang", 
		      "Setapak", "Taman melati", "KLCC", "Masjid Jamek"};
    
    final ScrollBar sc = new ScrollBar();
    
    public void show() {
    	Carlist = cp.getCar();
    	Motorcyclelist = mp.getMotorcycle();
    	Stage primaryStage = new Stage();
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
		
	    GridPane pane = new GridPane();
	    pane.setAlignment(Pos.TOP_LEFT);
	    pane.setPadding(new Insets(0, 0, 0, 15));
	    pane.setHgap(5.5);
	    pane.setVgap(5.5);
	    
	    ComboBox<String> cbLocation = new ComboBox<>();
	    ObservableList<String> items = FXCollections.observableArrayList(location);
	    cbLocation.getItems().addAll(items); 
	    cbLocation.setValue("Gombak");
	    
	    pane.add(new Label("Location:"), 0, 0);
	    pane.add(cbLocation, 0, 1);
	    
	    pane.add(new Label("Vehicle Type:"), 2, 0);
	    RadioButton rbCar = new RadioButton ("Car");
	    RadioButton rbMotorcycle = new RadioButton ("Motorcycle");
	    pane.add(rbCar, 2, 1);
	    pane.add(rbMotorcycle, 3, 1);
	    
	    ToggleGroup group = new ToggleGroup();
	    rbCar.setToggleGroup(group);
	    rbMotorcycle.setToggleGroup(group);
	    
	      
	    GridPane rent = new GridPane();
	    rent.setPadding(new Insets(15, 15, 15, 15));
	    rent.setHgap(10);
	    rent.setVgap(10);
		    
	    rent.add(new Label("Pickup:"), 0, 0);
	    rent.add(new Label("Date:"), 0, 1);
	    DatePicker pickupDate = new DatePicker();
	    pickupDate.setValue(LocalDate.now());
	    
	    DatePicker dropoffDate = new DatePicker();
	    dropoffDate.setValue(pickupDate.getValue().plusDays(1));
	    rent.add(pickupDate, 0, 2);
	    rent.add(new Label("Drop off:"), 2, 0);
	    rent.add(new Label("Date:"), 2, 1);
	    rent.add(dropoffDate, 2, 2);
	    
	    GridPane result = new GridPane();
	    result.setPadding(new Insets(0, 15, 15, 15)); 
	    result.setHgap(20);
	    result.setVgap(10);
	    
	    	    
	    final VBox vtable = new VBox();
        vtable.setSpacing(10);
        vtable.setPadding(new Insets(10, 0, 0, 10));
	     
        
        VBox paneForCheckBoxes = new VBox(20);
	    paneForCheckBoxes.setPadding(new Insets(10, 10, 10, 10)); 
	    paneForCheckBoxes.setStyle("-fx-border-color:black ;-fx-border-width: 1;");
	    Label txtExtra = new Label("Extra(Optional)");
	    //txtExtra.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
		paneForCheckBoxes.getChildren().add(txtExtra);
	    
	    
	    CheckBox chkGPS = new CheckBox("GPS --- RM30");
	    CheckBox chkChild = new CheckBox("Child seat --- RM50");
	    CheckBox chkDriver = new CheckBox("Additional driver --- RM50");
	    CheckBox chkLock = new CheckBox("Additional lock --- RM30");
	    CheckBox chkRain = new CheckBox("Rain coat --- RM40");
	    CheckBox chkSafety = new CheckBox("Safety equipments --- RM100");
	    
	        
	    rbCar.setOnAction(e -> {
	  	      if (rbCar.isSelected()) {
	  	    	  carCheck = true;
	  	    	  motorcycleCheck = false;
	  	    	vtable.getChildren().remove(tableCar);
	  	    	vtable.getChildren().remove(tableMotorcycle);
	  	    	tableCar.getColumns().clear();
	  	    	
	  	    	
	  	        getCarTable();
	  	      vtable.getChildren().add(tableCar);
	  	    paneForCheckBoxes.getChildren().removeAll(chkLock, chkRain, chkSafety);
		    paneForCheckBoxes.getChildren().addAll(chkGPS, chkChild, chkDriver);

	 	      }
	  	    
	  	    });
	      	

	    rbMotorcycle.setOnAction(e -> {
	  	      if (rbMotorcycle.isSelected()) {
	  	    	carCheck = false;
	  	    	  motorcycleCheck = true;
	  	    	vtable.getChildren().remove(tableCar);
	  	    	vtable.getChildren().remove(tableMotorcycle);
	  	    	tableMotorcycle.getColumns().clear();
	  	    	
	  	    	tableMotorcycle.refresh();
	  	    	getMotorcycleTable();
	  	      vtable.getChildren().add(tableMotorcycle);
	  	    paneForCheckBoxes.getChildren().removeAll(chkGPS, chkChild, chkDriver);
	    	paneForCheckBoxes.getChildren().addAll(chkLock, chkRain, chkSafety);
	
	 	      }
	  	    
	  	    });

	    GridPane custInfo = new GridPane();
	    custInfo.setPadding(new Insets(0, 15, 15, 15)); 
	    custInfo.setHgap(20);
	    custInfo.setVgap(10);
	    
	    
	    TextField tfName = new TextField();
	    TextField tfEmail = new TextField();
	    TextField tfAge = new TextField();
	    TextField tfTelno = new TextField();
	    TextField tfLicenseNo = new TextField();
	    TextField tfIssuedIn = new TextField();
	    
	    DatePicker expiryDate = new DatePicker();
	    expiryDate.setValue(LocalDate.now());
	    
	    
	    custInfo.add(new Label("Name: "), 0, 1);
	    custInfo.add(tfName, 1, 1);
	    custInfo.add(new Label("e-mail:"), 2, 1);
	    custInfo.add(tfEmail, 3, 1);
	    custInfo.add(new Label("Age:"), 0, 2);
	    custInfo.add(tfAge, 1, 2);
	    custInfo.add(new Label("Tel No.:"), 2, 2);
	    custInfo.add(tfTelno, 3, 2);
	    custInfo.add(new Label("License No.:"), 0, 3);
	    custInfo.add(tfLicenseNo, 1, 3);
	    custInfo.add(new Label("Issued in:"), 0, 4);
	    custInfo.add(tfIssuedIn, 1, 4);
	    custInfo.add(new Label("Expiry date:"), 2, 4);
	    custInfo.add(expiryDate, 3, 4);
	    
	  //book button
	    Button btNext = new Button("          Next          ");
	    Button btConfirm = new Button("     Confirm     ");
    
	    	    
	    
	   	    
	    VBox vBox = new VBox(15);
	    vBox.setPadding(new Insets(5, 20, 20, 5));
	    vBox.getChildren().add(hBox);
	    vBox.getChildren().add(pane);
	    vBox.getChildren().add(rent);
	    vBox.getChildren().add(vtable);
	    vBox.getChildren().add(paneForCheckBoxes);
	    vBox.getChildren().add(btNext);
	    //vBox.setStyle("-fx-background-color:  lightgray;");

	    
	    
	    
		// Create a scene and place it in the stage
	    //Stage primaryStage = new Stage();
	    Group root = new Group();
	    root.getChildren().addAll(vBox, sc);
	    Scene scene = new Scene(root, 900, 600);
	    scene.setFill(Color.LIGHTGRAY);
	    

	    
	    sc.setLayoutX(scene.getWidth()-sc.getWidth());
        sc.setMin(0);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(600);
        sc.setMax(360);
        
        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    vBox.setLayoutY(-new_val.doubleValue());
            }
        });
	    
	    primaryStage.setTitle("KL Vehicle Rental"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	    
	    
	    
	    btNext.setOnAction(e->{
	    	if(pickupDate.getValue().isAfter(dropoffDate.getValue()))
		    {
		    	Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Warning Dialog");        		
	    		alert.setContentText("Invalid!!! Dropoff date");
	    		alert.showAndWait();
		    }
	    	
	    		
	    	boolean no = false;
	    	if(!carCheck && !motorcycleCheck)
	    	{
	    		no = true;
	    		Alert alert = new Alert(AlertType.WARNING);
	    		alert.setTitle("Warning Dialog");        		
	    		alert.setContentText("Please select vehicle type!");
	    		alert.showAndWait();
	    	}
	    	
	    	String plate_no = null;
	    	if(carCheck)
	    	{
	    		Car carS = tableCar.getSelectionModel().getSelectedItem();
	    		if(carS == null)
	    		{
	    			no = true;
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.setTitle("Warning Dialog");        		
		    		alert.setContentText("Please select a car from the table!");
		    		alert.showAndWait();
	    		}
	    		
	    		price = carS.getPrice();
	    		vName = carS.getName();
	    		plate_no = carS.getPlat_no();
	    	}
	    
	    	if(motorcycleCheck)
	    	{
	    		Motorcycle motorS = tableMotorcycle.getSelectionModel().getSelectedItem();
	    		if(motorS == null)
	    		{
	    			no = true;
		    		Alert alert = new Alert(AlertType.WARNING);
		    		alert.setTitle("Warning Dialog");        		
		    		alert.setContentText("Please select a motorcycle from the table!");
		    		alert.showAndWait();
	    		}
	    		price = motorS.getPrice();
	    		vName = motorS.getName();
	    		plate_no = motorS.getPlat_no();
	    	}
	    	
	    	
	    	
	    	    	if(!no && checkRent(plate_no, pickupDate.getValue(), dropoffDate.getValue())){
	    	    		
	    		    	  		    				    
	    	    		rn.setPlate_no(plate_no);
	    	    		rn.setPickupDate(pickupDate.getValue());
	    	    		rn.setDropoffDate(dropoffDate.getValue());
	    	    		
	    	    		
	    	    		String p1 = String.valueOf(pickupDate.getValue());
	    			    String p1year = p1.substring(0, 4); //separate year from date and cast to String
	    		        String p1month = p1.substring(5, 7);// separate month 
	    		        String p1day = p1.substring(8, 10);
	    			    
	    		        int pickup1Year = Integer.parseInt(p1year);
	    		        int pickup1Month = Integer.parseInt(p1month);
	    		        int pickup1day = Integer.parseInt(p1day);
	    			    
	    		        int totalP1Day = (pickup1Year*365) + (pickup1Month*30) + pickup1day;
	    		        
	    		        String d1 = String.valueOf(dropoffDate.getValue());
	    			    String d1year = d1.substring(0, 4); //separate year from date and cast to String
	    		        String d1month = d1.substring(5, 7);// separate month 
	    		        String d1day = d1.substring(8, 10);
	    			    
	    		        int drop1Year = Integer.parseInt(d1year);
	    		        int drop1Month = Integer.parseInt(d1month);
	    		        int drop1day = Integer.parseInt(d1day);
	    			    
	    		        int totalD1Day = (drop1Year*365) + (drop1Month*30) + drop1day;
	    		        
	    		        rn.setTotal_days(totalD1Day);
	    		        
	    		        totalDays = totalD1Day - totalP1Day;
	    		        total = price * totalDays;
	    		        
	    		        
	    		        
	    		        if (chkGPS.isSelected())
	    			    			{
	    			    				total += 30;
	    			    			}
	    			    	    			    
	    			    if (chkChild.isSelected())
	    			    			{
	    			    				total += 50;
	    			    			}
	    			    
	    			    if (chkDriver.isSelected())
	    			    			{
	    			    				total += 50;
	    			    			}
	    			    	    			    
	    			    if (chkLock.isSelected())
	    			    			{
	    			    				total += 30;
	    			    			}
	    			    
	    			    if (chkRain.isSelected())
	    			    			{
	    			    				total += 40;
	    			    			}
	    			    
	    			    if (chkSafety.isSelected())
	    			    			{
	    			    				total += 100;
	    			    			}
	    			    
	    		        
	    			    rn.setTotal_price(total);
	    			    
	    		    	TextField tfCname = new TextField();
	    			    tfCname.setText(vName);
	    			    result.add(new Label("Vehicle Name: "), 0, 1);
	    			    result.add(tfCname, 1, 1);
	    			    
	    			    
	    			    TextField tfTD = new TextField();
	    			    tfTD.setText(String.valueOf(totalDays));
	    			    result.add(new Label("Total days: "), 2, 1);
	    			    result.add(tfTD, 3, 1);
	    			    


	    			    TextField tfTotal = new TextField();
	    			    tfTotal.setText(String.valueOf(total));
	    			    result.add(new Label("Total Price: "), 4, 1);
	    			    result.add(tfTotal, 5, 1);
	    	
	    			    

	    	sc.setValue(0);	
		    vBox.getChildren().remove(pane);
		    vBox.getChildren().remove(rent);
		    vBox.getChildren().remove(vtable);
		    vBox.getChildren().remove(btNext);
		    vBox.getChildren().remove(paneForCheckBoxes);
		    Label txtCust = new Label("Customer information");
		    txtCust.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
			
		    vBox.getChildren().add(txtCust);
		    vBox.getChildren().add(custInfo);
		    Label txtRent = new Label("Rent information");
		    txtRent.setFont(Font.font("Tahoma", FontWeight.BOLD, 14));
			
		    vBox.getChildren().add(txtRent);
		    vBox.getChildren().add(result);
		    vBox.getChildren().add(new Label("               "));
		    vBox.getChildren().add(btConfirm);
	    	}
		    

	    	    	});
	    

	    btConfirm.setOnAction(e->{
	    	
	    	Alert alert1 = new Alert(AlertType.WARNING);
    		alert1.setTitle("Warning Dialog");        		
    		boolean no = false;
	    	if(tfName.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the name");
	    		alert1.showAndWait();
	    	}
	    	else
	    	{
	    		for(int i=0;i<tfName.getLength();i++){
            		
            		if((tfName.getText().charAt(i)>='a'&& tfName.getText().charAt(i)<='z')||
            				(tfName.getText().charAt(i)>='A'&&tfName.getText().charAt(i)<='Z'))
            		{}
            		else{
            			no = true;
    		    		alert1.setContentText("Name must contain character");
    		    		alert1.showAndWait();
    		    		break;
            		}
            		

	    	}
	    	
	    	if(tfEmail.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up the e-mail");
	    		alert1.showAndWait();
	    	}
	    	
	    	if(tfAge.getLength() != 2)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid age!!!");
	    		alert1.showAndWait();
	    	}
	    	else
	    	{
	    		for(int i=0;i<tfName.getLength();i++){
            		
            		if((tfAge.getText().charAt(i)>='a'&& tfAge.getText().charAt(i)<='z')||
            				(tfAge.getText().charAt(i)>='A'&&tfAge.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Age must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}
	    	if (Integer.parseInt(tfAge.getText()) < 18)
	    		{
	    		no = true;
	    		alert1.setContentText("Invalid age!!!");
	    		alert1.showAndWait();
	    		
	    		}
	    		
	    		
	    	}
	    	if(tfTelno.getLength() <= 10 && tfTelno.getLength() <= 14)
	    	{
	    		no = true;
	    		alert1.setContentText("Invalid Tel No.!!! must be between 12 to 14 digits");
	    		alert1.showAndWait();
	    	}
	    	else
	    	{
	    		for(int i=0;i<tfName.getLength();i++){
            		
            		if((tfTelno.getText().charAt(i)>='a'&& tfTelno.getText().charAt(i)<='z')||
            				(tfTelno.getText().charAt(i)>='A'&&tfTelno.getText().charAt(i)<='Z'))
            		{
            			no = true;
    		    		alert1.setContentText("Tel No. must contain number");
    		    		alert1.showAndWait();
    		    		break;
}
            		}
            	
	    		
	    	}

	    	if(tfLicenseNo.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill license number!!!");
	    		alert1.showAndWait();
	    	}
	    	if(tfIssuedIn.getLength() == 0)
	    	{
	    		no = true;
	    		alert1.setContentText("Please fill up issued in");
	    		alert1.showAndWait();
	    	}

	    	else
	    	{
	    		for(int i=0;i<tfName.getLength();i++){
            		
            		if((tfIssuedIn.getText().charAt(i)>='a'&& tfIssuedIn.getText().charAt(i)<='z')||
            				(tfIssuedIn.getText().charAt(i)>='A'&&tfIssuedIn.getText().charAt(i)<='Z'))
            		{}
            		else{
            			no = true;
    		    		alert1.setContentText("Issued in must contain character");
    		    		alert1.showAndWait();
    		    		break;
            		}
            		

	    	}
		    
	    	
	    	LocalDate a = LocalDate.now();
	    		
	    	if(expiryDate.getValue().isBefore(a))
		    {
		    	no = true;
	    		alert1.setContentText("Invalid expiry date!!!");
	    		alert1.showAndWait();
		    }
	    		
	    	if(!no){
	    	//String name, int age, String license_no, String issued_in, String e_mail, int tel_no, LocalDate exDate
	    	c = new Customer(tfName.getText(), Integer.parseInt(tfAge.getText()),
	    			tfLicenseNo.getText(), tfIssuedIn.getText(), tfEmail.getText(),
	    		tfTelno.getText(), expiryDate.getValue());
	    	rn.setCustomer(c);
	    		
	    	Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Success");        		
    		alert.setContentText("Congrats! Booking has been recorded");
    		alert.showAndWait();
    		RentalPage rp = new RentalPage();
    		primaryStage.hide();
    		rp.show();
    		}}
	    	
	    }});
	    
	    btMotorcycleList.setOnAction(e->
	    {
	    	primaryStage.hide();
	    	mp.show();
	    	
	    }
	    );
	    
	    btCarList.setOnAction(e->
	    {
	    	primaryStage.hide();
	    	cp.show();
	    	
	    }
	    );
	    
	    btExit.setOnAction(e->
	    {
	    	primaryStage.hide();
	    }
	    );

	}
    
    public static void getCarTable()
    {
    	tableCar.setEditable(true);
    	 
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
        
        tableCar.refresh();
        tableCar.setItems(Carlist);
 
        tableCar.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableCar.getColumns().addAll(NameCol, PlatNoCol, yearCol, typeCol, ccCol,
        		priceCol, transmissionCol, airconCol, noOfPCol, noOfLCol);
 
    }
    
    public static void getMotorcycleTable()
    {
    tableMotorcycle.setEditable(true);
        
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
 
    
	    
        tableMotorcycle.setItems(Motorcyclelist);
        tableMotorcycle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableMotorcycle.getColumns().addAll(NameCol, PlatNoCol, yearCol, typeCol, ccCol,
        		priceCol, minExCol, minAgeCol);
 
    }
	
    public static boolean checkRent(String plate_no, LocalDate pDate, LocalDate dDate)
    {
    	for(Rental rn : r)
    	{
    		if((!pDate.isBefore(rn.getPickupDate()) && !pDate.isAfter(rn.getDropoffDate())) 
    				|| (!dDate.isBefore(rn.getPickupDate()) && !dDate.isAfter(rn.getDropoffDate())))
    				{
    						if(plate_no == rn.getPlate_no())
    						{
    							return false;
    						}
    				}
    	}
    	return true;
    }
    
    
    /*	 public static void main(String[] args) {
	        launch(args);
	    }*/
	 
}