/* ************************************
* File: OrderForm.java
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

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class OrderForm {

	// shipping variables
	private String shipStreet;
	private String shipCity;
	private String shipState;
	private String shipZip;

	// on campus variables
	private String campusLocation;
	private String campusTime;
	

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
	
public void storeOrder(Inventory inventory) {
		
		BufferedWriter writer = null; // initializes the writer
		
		try{
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("OrderRequest.txt"), "utf-8"));
			
			writer.write("Shipping Info: ");
			writer.newLine();
			
			if(shipStreet != null && shipCity != null && shipState != null && shipZip != null){
				writer.write(shipStreet);
				writer.newLine();
				writer.write(shipCity + ", " + shipState + " " + shipZip);
				writer.newLine();
				writer.newLine();
			} else {
				writer.write(campusLocation);
				writer.newLine();
				writer.write(campusTime);
				writer.newLine();
				writer.newLine();
			}
			
			if(inventory.replyEnv.getReqAmount() != 0){
			writer.write(inventory.replyEnv.getItemName() + " " + inventory.replyEnv.getReqAmount());
			writer.newLine();
			}
			if(inventory.window10.getReqAmount() != 0){
			writer.write(inventory.window10.getItemName() + " " + inventory.window10.getReqAmount());
			writer.newLine();
			}
			if(inventory.admitEnv.getReqAmount() != 0){
			writer.write(inventory.admitEnv.getItemName() + " " + inventory.admitEnv.getReqAmount());
			writer.newLine();
			}
			if(inventory.admitFold.getReqAmount() != 0){
			writer.write(inventory.admitFold.getItemName() + " " + inventory.admitFold.getReqAmount());
			writer.newLine();
			}
			if(inventory.maps.getReqAmount() != 0){
			writer.write(inventory.maps.getItemName() + " " + inventory.maps.getReqAmount());
			writer.newLine();
			}
			if(inventory.dbPcPennant.getReqAmount() != 0){
			writer.write(inventory.dbPcPennant.getItemName() + " " + inventory.dbPcPennant.getReqAmount());
			writer.newLine();
			}
			if(inventory.dbPennant.getReqAmount() != 0){
			writer.write(inventory.dbPennant.getItemName() + " " + inventory.dbPennant.getReqAmount());
			writer.newLine();
			}
			if(inventory.engPoster.getReqAmount() != 0){
			writer.write(inventory.engPoster.getItemName() + " " + inventory.engPoster.getReqAmount());
			writer.newLine();
			}
			if(inventory.intGradBroch.getReqAmount() != 0){
			writer.write(inventory.intGradBroch.getItemName() + " " + inventory.intGradBroch.getReqAmount());
			writer.newLine();
			}
			if(inventory.intGradList.getReqAmount() != 0){
			writer.write(inventory.intGradList.getItemName() + " " + inventory.intGradList.getReqAmount());
			writer.newLine();
			}
			if(inventory.inqCards.getReqAmount() != 0){
			writer.write(inventory.inqCards.getItemName() + " " + inventory.inqCards.getReqAmount());
			writer.newLine();
			}
			if(inventory.lanyard.getReqAmount() != 0){
			writer.write(inventory.lanyard.getItemName() + " " + inventory.lanyard.getReqAmount());
			writer.newLine();
			}
			if(inventory.magEnv.getReqAmount() != 0){
			writer.write(inventory.magEnv.getItemName() + " " + inventory.magEnv.getReqAmount());
			writer.newLine();
			}
			if(inventory.natSecurPoster.getReqAmount() != 0){
			writer.write(inventory.natSecurPoster.getItemName() + " " + inventory.natSecurPoster.getReqAmount());
			writer.newLine();
			}
			if(inventory.pilotPens.getReqAmount() != 0){
			writer.write(inventory.pilotPens.getItemName() + " " + inventory.pilotPens.getReqAmount());
			writer.newLine();
			}
			if(inventory.presFold.getReqAmount() != 0){
			writer.write(inventory.presFold.getItemName() + " " + inventory.presFold.getReqAmount());
			writer.newLine();
			}
			if(inventory.props.getReqAmount() != 0){
			writer.write(inventory.props.getItemName() + " " + inventory.props.getReqAmount());
			writer.newLine();
			}
			if(inventory.transferBro.getReqAmount() != 0){
			writer.write(inventory.transferBro.getItemName() + " " + inventory.transferBro.getReqAmount());
			writer.newLine();
			}
			if(inventory.travPiece.getReqAmount() != 0){
			writer.write(inventory.travPiece.getItemName() + " " + inventory.travPiece.getReqAmount());
			writer.newLine();
			}
			if(inventory.viewBook.getReqAmount() != 0){
			writer.write(inventory.viewBook.getItemName() + " " + inventory.viewBook.getReqAmount());
			writer.newLine();
			}
			if(inventory.viewBkEnv.getReqAmount() != 0){
			writer.write(inventory.viewBkEnv.getItemName() + " " + inventory.viewBkEnv.getReqAmount());
			writer.newLine();
			}
			
		} catch (IOException e){
			 
			e.printStackTrace();
		}finally{
			
			try{writer.close();} catch (Exception e)
			{e.printStackTrace();}
			
		}
		
		
	}

}
