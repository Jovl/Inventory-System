
/* ************************************
* File: ClientGUI.java
* Author: Jeremiah Lantzer
* 
* File Overview: This portion of the program
* is tasked with being the user interface
* for the student assistants in the mail
* room. 
* 
* Last Edited: 5/10/2016 
*
* Variable List: tabPane, workFlowTab, workflowPane,
* 				 orderFilled
*
* Method List: start, main
* 
* Constructor: ClientGUI
************************************ */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
// import javafx.scene.layout.StackPane; // will be implemented in the future
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.pubnub.api.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.*;

//class to display the Graphical Interface
public class ClientGUI extends Application {

	// screen panes
	private GridPane workflowPane;
	// private StackPane bgPane1, bgPane2, bgPane3, bgPane4; // TODO: hold the
	// background image

	// creates the pane to hold the menu's tabs
	private TabPane tabPane;
	private Tab workFlowTab;

	// buttons in the program
	private Button orderFilled;

	JSONObject orderRecev = new JSONObject();
	// will hold all of the information for an order after it is formatted
	// properly
	JSONObject orderFormat = new JSONObject();

	// holds the name of the file
	String name = null;

	Label wfStreet = null; // TODO: put file i/o
	// for address
	Label wfCityStateZip = null;
	Label locate = null;
	Label time1 = null;

	// class constructor
	public ClientGUI() {

		workFlowTab = new Tab();

		// instantiates Panes
		tabPane = new TabPane();
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		// ^^^Denies access to closing tabs^^^

		workflowPane = new GridPane();
		// bgPane1 = new StackPane();
		// bgPane2 = new StackPane();
		// bgPane3 = new StackPane(); Will be implemented in the future
		// bgPane4 = new StackPane();

		// Instantiates buttons

		orderFilled = new Button("Filled");

		// pubnub object holds the publish key first and the subscribe key
		// second
		// communitctaes with SUpervisor
		Pubnub pubnub = new Pubnub("pub-c-53b7f411-085f-4f34-957c-f017f47ddc8a",
				"sub-c-87b4c5a8-0991-11e6-bb6c-02ee2ddab7fe");

		// observable list for approved orders
		ObservableList<String> approvedOrdersWF = FXCollections.observableArrayList();

		/* ---------work flow tab--------- */
		workFlowTab.setText("Work Flow");
		workFlowTab.setContent(workflowPane);
		tabPane.getTabs().add(workFlowTab);

		try {
			pubnub.subscribe("my_channel", new Callback() {

				@Override
				public void connectCallback(String channel, Object message) {
					System.out.println("SUBSCRIBE : CONNECT on channel:" + channel + " : " + message.getClass() + " : "
							+ message.toString());
				}

				@Override
				public void disconnectCallback(String channel, Object message) {
					System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel + " : " + message.getClass()
							+ " : " + message.toString());
				}

				public void reconnectCallback(String channel, Object message) {
					System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel + " : " + message.getClass()
							+ " : " + message.toString());
				}

				@Override
				public void successCallback(String channel, Object message) {
					System.out.println(
							"SUBSCRIBE : " + channel + " : " + message.getClass() + " : " + message.toString());

					// initializes the writer
					BufferedWriter writer = null;
					orderRecev = (JSONObject) message;

					try {
						name = ((JSONObject) message).getString("recipFirst");

						writer = new BufferedWriter(
								new OutputStreamWriter(new FileOutputStream(name + ".txt"), "utf-8"));

						// copies the JSON into a file with the Orderer's name
						writer.write(message.toString());

						writer.close();

						// adds the counselor's name into the listview
						if (name != null) {
							approvedOrdersWF.add(name);
						}

					} catch (Exception e4) {
						e4.printStackTrace();
					}
				}

				@Override
				public void errorCallback(String channel, PubnubError error) {
					System.out.println("SUBSCRIBE : ERROR on channel " + channel + " : " + error.toString());
				}
			});
		} catch (PubnubException e1) {

		}

		// label for the approved orders
		Label approvedOrds = new Label("Approved Orders: ");
		// observable list for the orders
		VBox approvedBoxWF = new VBox();

		// listview to hold the approved orders
		ListView<String> approvedListWF = new ListView<String>(approvedOrdersWF);// TODO:
																					// import
																					// the
		// Observable list
		// for the orders

		// label for the approved orders
		Label currentTaskList = new Label("Current Order's Items: ");
		// observable list for the orders
		VBox currentTask = new VBox();
		// observable list for approved orders
		ObservableList<String> currentTaskItems = FXCollections.observableArrayList();
		// listview to hold the approved orders
		ListView<String> taskItemsLV = new ListView<String>(currentTaskItems);

		// Vbox to hold the address information
		VBox addressBoxWF = new VBox();

		// label to specify the information being given
		Label infoWF = new Label("Task View: ");

		approvedListWF.setOnMouseClicked(e -> {

			// empties the listview
			currentTaskItems.clear(); // ovbservable list
			taskItemsLV.getItems().clear(); // list view

			try {

				// establishes the name of the person that was clicked on as the
				// file name
				String name = approvedListWF.getSelectionModel().getSelectedItem();

				// establishes the method that reads the file
				BufferedReader reader = new BufferedReader(new FileReader(name + ".txt"));

				// holds the current line being read
				String line;
				// holds the information read from the reader
				String orderUp = null;
				// will hold the filtered order string
				String newOrderUp = null;

				// checks the file while it has information in it
				while ((line = reader.readLine()) != null) {
					orderUp = line;
				}

				// closes the file that was being read
				reader.close();

				// System.out.println(orderUp); // for testing the info from the
				// file

				// filters out everything but the information needed
				newOrderUp = orderUp.replaceAll("[^a-zA-Z0-9:]", "\n");
				// System.out.println(newOrderUp); // used for testing the
				// string

				// replaces colons with a space
				newOrderUp = newOrderUp.replaceAll("[^a-zA-Z0-9]", " ");
				// replaces multiple spaces with a single space
				newOrderUp = newOrderUp.trim().replaceAll(" +", " ");

				// System.out.println(newOrderUp); // used for testing the
				// string

				String[] jsonPrep = newOrderUp.split(" ");

				String streetName = null;
				String cityName = null;
				String stateName = null;
				String zipNum = null;

				String locationName = null;
				String timeNum = null;

				for (int i = 0; i < jsonPrep.length; i++) {
					// System.out.println(jsonPrep[i]); // used for testing the
					// array

					if ((i % 2) == 0) {
						// places the name and value in the JSON
						orderFormat.put(jsonPrep[i], jsonPrep[i + 1]);

						// places the name of the item and the value into A list
						// view

						currentTaskItems.addAll((String) orderFormat.names().get(i / 2),
								(String) orderFormat.get(jsonPrep[i]));

						// if the list view has been filled with any of these
						// the previous add is undone
						if (currentTaskItems.contains("Zip")) {
							zipNum = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("Street")) {
							streetName = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("State")) {
							stateName = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("City")) {
							cityName = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("Time")) {
							timeNum = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("CampusLocation")) {
							locationName = (String) orderFormat.get(jsonPrep[i]);
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("recipFirst")) {
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}
						if (currentTaskItems.contains("recipLast")) {
							currentTaskItems.remove((String) orderFormat.names().get(i / 2));
							currentTaskItems.remove((String) orderFormat.get(jsonPrep[i]));
						}

					}

				}
				// System.out.println(orderFormat); // used to check the JSON
				// info

				if (streetName != null) {
					wfStreet = new Label(streetName); // TODO: put file i/o
					// for address
					wfCityStateZip = new Label(cityName + ", " + stateName + " " + zipNum);
					// puts the address in its own label
					addressBoxWF.getChildren().addAll(wfStreet, wfCityStateZip);

				} else if (timeNum != null) {
					// on campus location of package
					locate = new Label(locationName);

					// time for delivery
					time1 = new Label(timeNum);
					// puts the address in its own label
					addressBoxWF.getChildren().addAll(locate, time1);
				}

			} catch (Exception e5) {
				e5.printStackTrace();
			}
		});

		orderFilled.setOnAction(e -> {

			// removes the name from the list
			approvedOrdersWF.remove(name);

			// empties the listview
			currentTaskItems.clear(); // ovbservable list
			taskItemsLV.getItems().clear(); // list view

			if (locate != null) {
				addressBoxWF.getChildren().remove(locate);
				addressBoxWF.getChildren().remove(time1);
			} else if (wfStreet != null) {
				addressBoxWF.getChildren().remove(wfStreet);
				addressBoxWF.getChildren().remove(wfCityStateZip);
			}

			List<ValuePair> invenItems = new ArrayList<>();

			// subtracting from the inventoree.csv
			try {
				// establishes the reader for the inventoree file
				BufferedReader reader1 = new BufferedReader(new FileReader("Inventoree.csv"));

				// stores the current line being read
				String line;

				while ((line = reader1.readLine()) != null) {
					ValuePair curryData = ValuePair.parseValuePair(line);
					if (curryData != null) {
						invenItems.add(curryData);
					}

				}

				reader1.close();

			} catch (IOException e8) {
				e8.printStackTrace();
			}

			invenItems.sort((a, b) -> Double.compare(a.value, b.value));

			for (ValuePair pair : invenItems) {
				// System.out.printf("%s -- %.3f %n", pair.key, pair.value); //
				// used for testing the .csv

				// System.out.println(pair.key); //used to test the value

				if (pair.key.contains("replyEnv")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("ReplyEnvelope");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("window10")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("10WindowEnvelope");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("admitEnv")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("AdmitEnvelope");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("admitFold")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("AdmitFolder");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("maps")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("CampusMap");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("dbPcPennant")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("DBPCPennant");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("DBPennant")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("DBPennant");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("engposter")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("EngineeringPoster");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("intGradBroch")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("InterGraduateBrochure");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("intGradList")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("InterGraduateList");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("inqCards")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("InquiryCard");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("lanyard")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("Lanyard");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("magEnv")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("MagazineEnvelope");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("natSecurPoster")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("NationalSecurityPoster");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("pilotPens")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("PilotPen");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("presFold")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("PresentationFolder");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("props")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("Propeller");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("transferBro")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("TransferBrochure");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("travPiece")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("TravelPiece");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("viewBook")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("ViewBook");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				} else if (pair.key.contains("viewBookEnv")) {
					try {

						// System.out.println(Double.parseDouble((String)
						// orderRecev.get("ReplyEnvelope")));
						pair.value -= orderRecev.getInt("ViewBookEnvelope");
						// set the value in the csv to the result
					} catch (Exception e1) {
						// TODO Auto-generated catch block

					}
				}

				// prints the final inventory0
				System.out.printf("%s -- %.3f %n", pair.key, pair.value); // used
																			// for
																			// testing
																			// the
																			// .csv
			}

		});

		approvedBoxWF.getChildren().addAll(approvedOrds, approvedListWF);
		currentTask.getChildren().addAll(currentTaskList, taskItemsLV);
		addressBoxWF.getChildren().addAll(orderFilled, infoWF);

		// formatting
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

	static class ValuePair {
		public final String key;
		public double value;

		private ValuePair(String key, double value) {
			this.key = key;
			this.value = value;

		}

		public static ValuePair parseValuePair(String lineToParse) {
			String[] values = lineToParse.split(",");
			String key = values[0];
			try {
				double value = Double.parseDouble(values[1]);
				return new ValuePair(key, value);
			} catch (NumberFormatException e) {
				return null;
			}
		}

	}

	public static void main(String[] args) {
		ClientGUI.launch(args); // displays the GUI
	}

}
