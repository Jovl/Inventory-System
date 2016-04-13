/* ************************************
* File: GUI.java
* Assignment: 
* Author: Jeremiah Lantzer
* Collaborations: 
* Date: 
*
*Variable List: 
*
*Method List: 
*
************************************ */

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//class to display the Graphical Interface
public class GUI extends Application {

	// screen panes
	private GridPane profilePane, orderPane, supervisorPane, workflowPane;
	private StackPane bgPane1, bgPane2, bgPane3, bgPane4; // TODO: hold the background image

	// creates the pane to hold the menu's tabs
	private TabPane tabPane;
	private Tab orderTab, profileTab, supervisorTab, workFlowTab;

	// buttons in the program
	private Button profileSubmit, orderSubmit, superApprove, superDecline, orderFilled;
	
	private Inventory inventory;

	// class constructor
	public GUI() {

		// objects needed from other classes
		Profile profile = new Profile();

		// instantiates tabs
		orderTab = new Tab();
		profileTab = new Tab();
		supervisorTab = new Tab();
		workFlowTab = new Tab();

		// instantiates Panes
		tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// ^^^Denies access to closing tabs^^^
		profilePane = new GridPane();
		orderPane = new GridPane();
		supervisorPane = new GridPane();
		workflowPane = new GridPane();
		bgPane1 = new StackPane();
		bgPane2 = new StackPane();
		bgPane3 = new StackPane();
		bgPane4 = new StackPane();
		
		// Instantiates buttons
		profileSubmit = new Button("Submit");
		orderSubmit = new Button("Submit");
		superApprove = new Button("Approve");
		superDecline = new Button("Decline");
		orderFilled = new Button("Filled");
		
		// Inventory object declaration
		inventory = new Inventory();

		/* ---------order tab--------- */
		// tab
		orderTab.setText("Order");
		orderTab.setContent(orderPane);
		tabPane.getTabs().add(orderTab);
		
//		// background image
//		Image bgImg1 = new Image("file:Embry Riddle Logo.png");
//		ImageView imgView1 = new ImageView(bgImg1);	
//		TODO: Fix the back round images for all panes		
//		bgPane1.getChildren().add(imgView1);
//		VBox bgVbox = new VBox();
//		
//		bgVbox.getChildren().add(bgPane1);
		
		// text fields and prompts
		final TextField field1 = new TextField();
		Label label1 = new Label("#9 Reply Envelope:");

		final TextField field2 = new TextField();
		Label label2 = new Label("#10 Window Envelope:");

		final TextField field3 = new TextField();
		Label label3 = new Label("Admit Envelope:");

		final TextField field4 = new TextField();
		Label label4 = new Label("Admit Folder:");

		final TextField field5 = new TextField();
		Label label5 = new Label("Campus Maps:");

		final TextField field6 = new TextField();
		Label label6 = new Label("DB/PC Pennant:");

		final TextField field7 = new TextField();
		Label label7 = new Label("DB Pennant:");

		final TextField field8 = new TextField();
		Label label8 = new Label("Engineering Poster:");

		final TextField field9 = new TextField();
		Label label9 = new Label("International Grad Brochure:");

		final TextField field10 = new TextField();
		Label label10 = new Label("International Grad Checklist:");

		final TextField field11 = new TextField();
		Label label11 = new Label("Inquiry Card:");

		final TextField field12 = new TextField();
		Label label12 = new Label("Lanyards:");

		final TextField field13 = new TextField();
		Label label13 = new Label("Magazine Envelope:");

		final TextField field14 = new TextField();
		Label label14 = new Label("National Security Poster:");

		final TextField field15 = new TextField();
		Label label15 = new Label("Pilot Pens:");

		final TextField field16 = new TextField();
		Label label16 = new Label("Presentation Folder:");

		final TextField field17 = new TextField();
		Label label17 = new Label("Propellor:");

		final TextField field18 = new TextField();
		Label label18 = new Label("Transfer Brochure:");

		final TextField field19 = new TextField();
		Label label19 = new Label("Travel Piece:");

		final TextField field20 = new TextField();
		Label label20 = new Label("Viewbook:");

		final TextField field21 = new TextField();
		Label label21 = new Label("Viewbook Envelope:");
		
		//order submission button
		// submits the item totals
		orderSubmit.setOnAction(e -> {
			
			// sets the value of all variables to 
			inventory.initVals();
			
			// sets the name of every item
			inventory.setItemNames(); 
			
			// Receives the input. Converts to an integer. Store in the respective setter.
			if(!field1.getText().trim().isEmpty()){
				inventory.getReplyEnv().setReqAmount(Integer.parseInt(field1.getText()));
			}
			if(!field2.getText().trim().isEmpty()){
				inventory.getWindow10().setReqAmount(Integer.parseInt(field2.getText()));
			}
			if(!field3.getText().trim().isEmpty()){
				inventory.getAdmitEnv().setReqAmount(Integer.parseInt(field3.getText()));
			}
			if(!field4.getText().trim().isEmpty()){
				inventory.getAdmitFold().setReqAmount(Integer.parseInt(field4.getText()));
			}
			if(!field5.getText().trim().isEmpty()){
				inventory.getMaps().setReqAmount(Integer.parseInt(field5.getText()));
			}
			if(!field6.getText().trim().isEmpty()){
				inventory.getDbPcPennant().setReqAmount(Integer.parseInt(field6.getText()));
			}
			if(!field7.getText().trim().isEmpty()){
				inventory.getDbPennant().setReqAmount(Integer.parseInt(field7.getText()));
			}
			if(!field8.getText().trim().isEmpty()){
				inventory.getEngPoster().setReqAmount(Integer.parseInt(field8.getText()));
			}
			if(!field9.getText().trim().isEmpty()){
				inventory.getIntGradBroch().setReqAmount(Integer.parseInt(field9.getText()));
			}
			if(!field10.getText().trim().isEmpty()){
				inventory.getIntGradList().setReqAmount(Integer.parseInt(field10.getText()));
			}
			if(!field11.getText().trim().isEmpty()){
				inventory.getInqCards().setReqAmount(Integer.parseInt(field11.getText()));
			}
			if(!field12.getText().trim().isEmpty()){
				inventory.getLanyard().setReqAmount(Integer.parseInt(field12.getText()));
			}
			if(!field13.getText().trim().isEmpty()){
				inventory.getMagEnv().setReqAmount(Integer.parseInt(field13.getText()));
			}
			if(!field14.getText().trim().isEmpty()){
				inventory.getNatSecurPoster().setReqAmount(Integer.parseInt(field14.getText()));
			}
			if(!field15.getText().trim().isEmpty()){
				inventory.getPilotPens().setReqAmount(Integer.parseInt(field15.getText()));
			}
			if(!field16.getText().trim().isEmpty()){
				inventory.getPresFold().setReqAmount(Integer.parseInt(field16.getText()));
			}
			if(!field17.getText().trim().isEmpty()){
				inventory.getProps().setReqAmount(Integer.parseInt(field17.getText()));
			}
			if(!field18.getText().trim().isEmpty()){
				inventory.getTransferBro().setReqAmount(Integer.parseInt(field18.getText()));
			}
			if(!field19.getText().trim().isEmpty()){
				inventory.getTravPiece().setReqAmount(Integer.parseInt(field19.getText()));
			}
			if(!field20.getText().trim().isEmpty()){
				inventory.getViewBook().setReqAmount(Integer.parseInt(field20.getText()));
			}
			if(!field21.getText().trim().isEmpty()){
				inventory.getViewBkEnv().setReqAmount(Integer.parseInt(field21.getText()));
			}
			
			// function to store all items ordered in an order file
			inventory.storeItems();
		});

		// vbox to hold the first set of fields
		VBox orderVbox = new VBox();
		orderVbox.getChildren().addAll(label1, field1, label2, field2, label3, field3, label4, field4, label5, field5,
				label6, field6, label7, field7, label8, field8, label9, field9, label10, field10, label11, field11);
		// vbox to hold the second set of fields
		VBox orderVbox1 = new VBox();
		orderVbox1.getChildren().addAll(label12, field12, label13, field13, label14, field14, label15, field15, label16,
				field16, label17, field17, label18, field18, label19, field19, label20, field20, label21, field21);
		// formatting for order fields
		orderVbox.setTranslateX(25);
		orderVbox1.setTranslateX(200);

		// label for the shipping portion of the program
		Label shipLabel = new Label("Shipping");

		final TextField streetField = new TextField();
		streetField.setPromptText("Street");
		streetField.getText();

		final TextField cityField = new TextField();
		cityField.setPromptText("City");
		cityField.getText();

		final TextField stateField = new TextField();
		stateField.setPromptText("State");
		stateField.getText();

		final TextField zipField = new TextField();
		zipField.setPromptText("Zip Code");
		zipField.getText();

		// label for on campus section
		Label campusLabel = new Label("On Campus");

		final TextField locationField = new TextField();
		locationField.setPromptText("Location");
		locationField.getText();

		final TextField timeField = new TextField();
		timeField.setPromptText("Time");
		timeField.getText();

		VBox shipVbox = new VBox();
		shipVbox.getChildren().addAll(shipLabel, streetField, cityField, stateField, zipField);
		
		VBox campusVbox = new VBox();
		campusVbox.getChildren().addAll(campusLabel, locationField, timeField);

		VBox submitVbox = new VBox();
		submitVbox.getChildren().add(orderSubmit);

		// formatting for vboxes
		shipVbox.setTranslateX(520);
		campusVbox.setTranslateX(520);
		campusVbox.setTranslateY(150);
		submitVbox.setTranslateX(520);
		submitVbox.setTranslateY(250);
		
		shipVbox.setSpacing(5);
		campusVbox.setSpacing(5);

		// adds the order fields to the pane
		orderPane.getChildren().addAll(orderVbox, orderVbox1, shipVbox, campusVbox, submitVbox);
		/* ---------order tab--------- */
		//
		//
		/* ---------Profile Tab--------- */
		// tab
		profileTab.setText("Profile");
		profileTab.setContent(profilePane);
		tabPane.getTabs().add(profileTab);
		
		Label profileLabel = new Label("Please input your information: ");

		// text fields and prompts for items
		final TextField firstField = new TextField();
		firstField.setPromptText("First Name");

		final TextField lastField = new TextField();
		lastField.setPromptText("Last Name");

		final TextField emailField = new TextField();
		emailField.setPromptText("Email");

		final TextField phoneField = new TextField();
		phoneField.setPromptText("Office Phone #");
	
		
			
		profileSubmit.setOnAction(e -> {
			
			if(!firstField.getText().trim().isEmpty() && !lastField.getText().trim().isEmpty() && 
			!phoneField.getText().trim().isEmpty() && !emailField.getText().trim().isEmpty()){
				
				String firstName = firstField.getText(); // sets the information as a variable
				profile.setFirstName(firstName); // sends the variable to the profile class
				System.out.println(profile.getFirstName()); // outputs info to console
				
				String lastName = lastField.getText();
				profile.setLastName(lastName);
				System.out.println(profile.getLastName());
				
				String email = emailField.getText();
				profile.setEmail(email);
				System.out.println(profile.getEmail());
				
				String phoneNumber = phoneField.getText();
				profile.setPhoneNumber(phoneNumber);
				System.out.println(profile.getPhoneNumber());
				
				profile.storeInfo();
			}else{
				//TODO: Error Label
				Label errorLabel = new Label("Please fill all fields.");
				
				errorLabel.setTranslateX(20);
				errorLabel.setTranslateY(100);
				profilePane.getChildren().add(errorLabel);
			}
		});
		
		
		//holds the text fields for profile input
		VBox infoVbox = new VBox();
		infoVbox.getChildren().addAll(profileLabel, firstField, lastField, emailField, phoneField, profileSubmit);
		
		//GUI Formatting
		infoVbox.setMaxSize(200, 200);
		infoVbox.setTranslateX(20);
		infoVbox.setSpacing(5);
		
		profilePane.getChildren().addAll(infoVbox);
		/* ---------Profile Tab--------- */
		//
		//
		/* ---------supervisor tab--------- */
		// tab
		supervisorTab.setText("Supervisor");
		supervisorTab.setContent(supervisorPane);
		tabPane.getTabs().add(supervisorTab);

		// Label for orders that need approval
		Label currentsLabel = new Label("Current Orders:");
		// Vbox to hold the current orders
		VBox currentVOrders = new VBox();
		currentVOrders.setTranslateX(20);
		// list to hold the current orders
		ObservableList<String> orders = FXCollections.observableArrayList();

		// list view creates the list into a node to be displayed
		ListView<String> ordersListView = new ListView<String>(orders);
		// puts the nodes into a vBox
		ordersListView.setMaxSize(150, 400);
		currentVOrders.getChildren().addAll(currentsLabel, ordersListView);

		// preview/ task view Label
		Label taskView = new Label("Task View: ");

		// labels for the current order's address
		Label taskStreet = new Label("1234 Fake Street"); // TODO: put file i/o for address
		Label taskCityStateZip = new Label("City City" + ", " + "State" + " " + "56789"); // TODO: change to variables for address output
		

		// the list view for the order imported from the order
		ListView<String> itemsList = new ListView<String>();// TODO: import the
															// Observable list
															// for the items
		itemsList.setMaxSize(150, 200);

		// v box to store the list view
		VBox itemsBox = new VBox();
		
		itemsBox.getChildren().addAll(taskView, taskStreet, taskCityStateZip, itemsList, superApprove, superDecline);
		
		// label for the approved order section
		Label approvedLabel = new Label("Approved Orders:");
		// vbox for approved orders
		VBox approvedBox = new VBox();
		// observable list for approved orders
		ObservableList<String> approvedOrders = FXCollections.observableArrayList();
		// listview to hold the approved orders
		ListView<String> approvedList = new ListView<String>(approvedOrders);// TODO: import the
															// Observable list
															// for the orders
		// adding the listview to the vbox
		approvedBox.getChildren().addAll(approvedLabel, approvedList);

		// Vbox formatting
		itemsBox.setMaxSize(150, 500);
		itemsBox.setTranslateX(275);
		itemsBox.setSpacing(5);
		
		approvedBox.setMaxSize(150, 500);
		approvedBox.setTranslateX(525);
		

		// puts everything into the supervisor pane
		supervisorPane.getChildren().addAll(currentVOrders, itemsBox, approvedBox);
		/* ---------supervisor tab--------- */
		//
		//
		/* ---------work flow tab--------- */
		workFlowTab.setText("Work Flow");
		workFlowTab.setContent(workflowPane);
		tabPane.getTabs().add(workFlowTab);
		
		//label for the approved orders
		Label approvedOrds = new Label("Approved Orders: ");
		//observable list for the orders
		VBox approvedBoxWF = new VBox();
		// observable list for approved orders
		ObservableList<String> approvedOrdersWF = FXCollections.observableArrayList();
		// listview to hold the approved orders
		ListView<String> approvedListWF = new ListView<String>(approvedOrdersWF);// TODO: import the
															// Observable list
															// for the orders
		
		//label for the approved orders
		Label currentTaskList = new Label("Current Order's Items: ");
		//observable list for the orders
		VBox currentTask = new VBox();
		// observable list for approved orders
		ObservableList<String> currentTaskItems = FXCollections.observableArrayList();
		// listview to hold the approved orders
		ListView<String> taskItemsLV = new ListView<String>(currentTaskItems);// TODO: import the
															// Observable list
															// for the items
		//Vbox for address
		VBox addressBoxWF = new VBox();
		Label infoWF = new Label("Task View: ");
		
		Label wfStreet = new Label("1234 Fake Street"); // TODO: put file i/o for address
		Label wfCityStateZip = new Label("City City" + ", " + "State" + " " + "56789"); // TODO: change to variables for address output

		
		approvedBoxWF.getChildren().addAll(approvedOrds, approvedListWF);
		currentTask.getChildren().addAll(currentTaskList, taskItemsLV);
		addressBoxWF.getChildren().addAll(infoWF, wfStreet, wfCityStateZip, orderFilled);
		
		//formatting
		approvedBoxWF.setMaxSize(150, 500);
		approvedBoxWF.setTranslateX(20);
		
		currentTask.setMaxSize(150, 500);
		currentTask.setTranslateX(275);
		
		addressBoxWF.setMaxSize(150, 300);
		addressBoxWF.setTranslateX(500);
		addressBoxWF.setTranslateY(75);
		addressBoxWF.setSpacing(5);

		
		workflowPane.getChildren().addAll(approvedBoxWF, currentTask, addressBoxWF);
		/* ---------work flow tab--------- */

	}

	// method calls the other method to display the GUI
	@Override
	public void start(Stage primaryStage) throws Exception {

		// creates the scene that holds the tab pane
		Scene scene = new Scene(tabPane, 700, 500);
		// displays the tab pane scene
		primaryStage.setScene(scene);
		// Title for the program window
		primaryStage.setTitle("Intelligent Inventory System");
		// displays the GUI created in constructor
		primaryStage.show();

	}

	public static void main(String[] args) {
		GUI.launch(args); // displays the GUI
	}

}
