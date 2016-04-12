import java.io.FileOutputStream;
import java.io.IOException;

public class Inventory extends Item{

	private Item replyEnv = new Item();
	// #9 reply envelopes 1
	
	Item window10 = new Item();
	// #10 window envelopes 2
	
	Item admitEnv = new Item();
	// admit folder envelopes 3
	
	Item admitFold = new Item();
	// admit folders 4
	
	Item maps = new Item();
	// campus maps 5
	
	Item dbPcPennant = new Item();
	// Db.Pc Pennant 6
	
	Item dbPennant = new Item();
	// DB Pennant 7
	
	Item engPoster = new Item();
	// Engineering Poster 8
	
	Item intGradBroch = new Item();
	//International Graduate Brochure 9
	
	Item intGradList = new Item();
	// International Graduate Checklist 10
	
	Item inqCards = new Item();
	// inquiry Cards 11
	
	Item lanyard = new Item();
	// lanyards 12
	
	Item magEnv = new Item();
	// magazine envelopes 13
	
	Item natSecurPoster = new Item();
	// national security posters 14
	
	Item pilotPens = new Item();
	// pilot pens 15
	
	Item presFold = new Item();
	// presentation folders 16
	
	Item props = new Item();
	// Propellers 17
	
	Item transferBro = new Item();
	// transfer Brochure 18
	
	Item travPiece = new Item();
	// travel piece 19
	
	Item viewBook = new Item();
	// view books 20
	
	Item viewBkEnv = new Item();
	// view book envelopes 21
	

	public Item getReplyEnv() {
		return replyEnv;
	}

	public Item getWindow10() {
		return window10;
	}

	public Item getAdmitEnv() {
		return admitEnv;
	}

	public Item getAdmitFold() {
		return admitFold;
	}

	public Item getMaps() {
		return maps;
	}

	public Item getDbPcPennant() {
		return dbPcPennant;
	}

	public Item getDbPennant() {
		return dbPennant;
	}

	public Item getEngPoster() {
		return engPoster;
	}

	public Item getIntGradBroch() {
		return intGradBroch;
	}

	public Item getIntGradList() {
		return intGradList;
	}

	public Item getInqCards() {
		return inqCards;
	}

	public Item getLanyard() {
		return lanyard;
	}

	public Item getMagEnv() {
		return magEnv;
	}

	public Item getNatSecurPoster() {
		return natSecurPoster;
	}

	public Item getPilotPens() {
		return pilotPens;
	}

	public Item getPresFold() {
		return presFold;
	}

	public Item getProps() {
		return props;
	}

	public Item getTransferBro() {
		return transferBro;
	}

	public Item getTravPiece() {
		return travPiece;
	}

	public Item getViewBook() {
		return viewBook;
	}

	public Item getViewBkEnv() {
		return viewBkEnv;
	}
	
	public void storeItems() throws IOException{
		
		try{
			FileOutputStream inventory = new FileOutputStream("Inventory.txt");
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
}
