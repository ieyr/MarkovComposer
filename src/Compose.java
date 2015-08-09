import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Compose {
	static String database;

	public static void main(String[] args) {
		String str = "";
		Compose c = new Compose();
		database = c.createDatabase("testtrain.txt");
		// TODO Auto-generated method stub
		char currNote = database.charAt((int) (Math.random() * database.length()) - 1);
		
		// System.out.println(database);
		str = str + currNote;
		while (currNote != ']') {

			currNote = new FrequencyTable(currNote).getMaxNote();
			str = str + currNote;
			//System.out.print(currNote);
		}
		System.out.println(str);

	}

	public Compose() {

	}

	public String createDatabase(String fileName) {
		Scanner in;
		String returnString = "";
		try {
			in = new Scanner(new FileReader(fileName));
			
			while (in.hasNextLine()) {returnString = returnString + "\n" + in.nextLine();}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return returnString;
	}

}
