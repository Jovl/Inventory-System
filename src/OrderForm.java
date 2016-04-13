import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

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

public class OrderForm {

	// shipping variables
	private String shipStreet;
	private String shipCity;
	private String shipState;
	private String shipZip;

	// on campus variables
	private String campusLocation;
	private String campusTime;
	
	private Inventory inventory;

	public String getShipStreet() {
		return shipStreet;
	}

	public void setShipStreet(String shipStreet) {
		this.shipStreet = shipStreet;
	}

	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	public String getShipState() {
		return shipState;
	}

	public void setShipState(String shipState) {
		this.shipState = shipState;
	}

	public String getShipZip() {
		return shipZip;
	}

	public void setShipZip(String shipZip) {
		this.shipZip = shipZip;
	}

	public String getCampusLocation() {
		return campusLocation;
	}

	public void setCampusLocation(String campusLocation) {
		this.campusLocation = campusLocation;
	}

	public String getCampusTime() {
		return campusTime;
	}

	public void setCampusTime(String campusTime) {
		this.campusTime = campusTime;
	}
	
public void storeItems() {
		
		BufferedWriter writer = null; // initializes the writer
		
		inventory = new Inventory();
		
		try{
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("Inventory.txt"), "utf-8"));
			
			writer.write(inventory.replyEnv.getItemName() + " " + inventory.replyEnv.getReqAmount());
			writer.newLine();
			writer.write(inventory.window10.getItemName() + " " + inventory.window10.getReqAmount());
			writer.newLine();
			writer.write(inventory.admitEnv.getItemName() + " " + inventory.admitEnv.getReqAmount());
			writer.newLine();
			writer.write(inventory.admitFold.getItemName() + " " + inventory.admitFold.getReqAmount());
			writer.newLine();
			writer.write(inventory.maps.getItemName() + " " + inventory.maps.getReqAmount());
			writer.newLine();
			writer.write(inventory.dbPcPennant.getItemName() + " " + inventory.dbPcPennant.getReqAmount());
			writer.newLine();
			writer.write(inventory.dbPennant.getItemName() + " " + inventory.dbPennant.getReqAmount());
			writer.newLine();
			writer.write(inventory.engPoster.getItemName() + " " + inventory.engPoster.getReqAmount());
			writer.newLine();
			writer.write(inventory.intGradBroch.getItemName() + " " + inventory.intGradBroch.getReqAmount());
			writer.newLine();
			writer.write(inventory.intGradList.getItemName() + " " + inventory.intGradList.getReqAmount());
			writer.newLine();
			writer.write(inventory.inqCards.getItemName() + " " + inventory.inqCards.getReqAmount());
			writer.newLine();
			writer.write(inventory.lanyard.getItemName() + " " + inventory.lanyard.getReqAmount());
			writer.newLine();
			writer.write(inventory.magEnv.getItemName() + " " + inventory.magEnv.getReqAmount());
			writer.newLine();
			writer.write(inventory.natSecurPoster.getItemName() + " " + inventory.natSecurPoster.getReqAmount());
			writer.newLine();
			writer.write(inventory.pilotPens.getItemName() + " " + inventory.pilotPens.getReqAmount());
			writer.newLine();
			writer.write(inventory.presFold.getItemName() + " " + inventory.presFold.getReqAmount());
			writer.newLine();
			writer.write(inventory.props.getItemName() + " " + inventory.props.getReqAmount());
			writer.newLine();
			writer.write(inventory.transferBro.getItemName() + " " + inventory.transferBro.getReqAmount());
			writer.newLine();
			writer.write(inventory.travPiece.getItemName() + " " + inventory.travPiece.getReqAmount());
			writer.newLine();
			writer.write(inventory.viewBook.getItemName() + " " + inventory.viewBook.getReqAmount());
			writer.newLine();
			writer.write(inventory.viewBkEnv.getItemName() + " " + inventory.viewBkEnv.getReqAmount());
			writer.newLine();
			
		} catch (IOException e){
			 
			e.printStackTrace();
		}finally{
			
			try{writer.close();} catch (Exception e)
			{e.printStackTrace();}
			
		}
		
		
	}

}
