import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Inventory extends Item{
	
	Item replyEnv = new Item();
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
	
	public void setItemNames(){
		// function to set the name of every item at once
		replyEnv.setItemName("Reply Envelope");
		window10.setItemName("#10 Window Ennvelope");
		admitEnv.setItemName("Admit Envelope");
		admitFold.setItemName("Admit Folder");
		maps.setItemName("Campus Map");
		dbPcPennant.setItemName("DB/PC Pennant");
		dbPennant.setItemName("DB Pennant");
		engPoster.setItemName("Engineering Poster");
		intGradBroch.setItemName("International Graduate Brochure");
		intGradList.setItemName("International Graduate Checklist");
		inqCards.setItemName("Inquiry Card");
		lanyard.setItemName("Lanyard");
		magEnv.setItemName("Magazine Envelope");
		natSecurPoster.setItemName("National Security Poster");
		pilotPens.setItemName("Pilot Pen");
		presFold.setItemName("Presentation Folder");
		props.setItemName("Propeller");
		transferBro.setItemName("Transfer Brochure");
		travPiece.setItemName("Travel Piece");
		viewBook.setItemName("View Book");
		viewBkEnv.setItemName("View Book Envelope");
		
	}
	
	public void initVals(){
		
		replyEnv.setReqAmount(0);
		window10.setReqAmount(0);
		admitEnv.setReqAmount(0);
		admitFold.setReqAmount(0);
		maps.setReqAmount(0);
		dbPcPennant.setReqAmount(0);
		dbPennant.setReqAmount(0);
		engPoster.setReqAmount(0);
		intGradBroch.setReqAmount(0);
		intGradList.setReqAmount(0);
		inqCards.setReqAmount(0);
		lanyard.setReqAmount(0);
		magEnv.setReqAmount(0);
		natSecurPoster.setReqAmount(0);
		pilotPens.setReqAmount(0);
		presFold.setReqAmount(0);
		props.setReqAmount(0);
		transferBro.setReqAmount(0);
		travPiece.setReqAmount(0);
		viewBook.setReqAmount(0);
		viewBkEnv.setReqAmount(0);
		
	}
	
}
