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

}
