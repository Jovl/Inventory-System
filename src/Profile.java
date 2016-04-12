import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Profile {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// File I/O method for writing the info to a file
	public void storeInfo(){
		Writer writer = null;
		File profileTxt = new File("Profile.txt");
		
		if(profileTxt.exists()){
			
		}
		
		try{
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("Profile.txt"), "utf-8"));
			writer.write(firstName);
			writer.write(" " + lastName);
			writer.write(" " + email);
			writer.write(" " + phoneNumber);
			
		} catch (IOException e){
			e.printStackTrace();
		}finally{
			try{writer.close();} catch (Exception e)
			{e.printStackTrace();}
		}
		
	}

}
