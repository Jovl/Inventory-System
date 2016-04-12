
public class Item {
	
	private int itemCount; // the total of an item in inventory
	private String itemName; // the name of the item
	private int reqAmount; // user requested amount of a specific item
	
	public int getItemCount() {
		return itemCount;
	}
	
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}
	
}
