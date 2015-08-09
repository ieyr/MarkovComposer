import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Compose {
	static String database;

	public static void main(String[] args) {
		String str = "";
		int spaceCount = 0;
		int lineCount = 0;
		boolean end = false;
		boolean start = true;
		Compose c = new Compose();
		database = c.createDatabase("testtrain.txt");
		// TODO Auto-generated method stub
		char currNote = database.charAt((int) (Math.random() * database.length()) - 1);
		while (currNote == '|' || currNote == ' ' || currNote == ':') {
			currNote = database.charAt((int) (Math.random() * database.length()) - 1);
		}

		// System.out.println(database);
		str = str + currNote;
		full: while (true) {
			char origNote = currNote;
			currNote = new FrequencyTable(origNote).getMaxNote();
			while (currNote == ']') {
				end = true;
				currNote = new FrequencyTable(origNote).getMaxNote();
			}

			if (currNote == ' ' || currNote == '|' || currNote == ':') {

			} else {
				spaceCount++;
				lineCount++;
			}

			String addition = "";
			if (spaceCount == 3) {
				addition = addition + " ";
				spaceCount = 0;
			}
			if (lineCount == 6) {
				lineCount = 0;
				if (end) {
					addition = addition + "|]";
					str = str.substring(0, str.length()-1) + currNote + addition;
					System.out.println("this");
					break full;
				} else {
					addition = addition + "| ";
				}
				
			}
			if (currNote == ' ' || currNote == '|' || currNote == ':') {
			} else {
				
				if (end) {
					
				}else if(start){
					start = false;
				}else{
					str = str + currNote + addition;
				}
			}
			System.out.println(str);
			// System.out.print(currNote);
		}
		System.out.println("X:1\nT:I made this\nM:6/8\nL:1/8\nR:jig\nK:G");
		System.out.println(str);

	}

	public Compose() {

	}

	public String createDatabase(String fileName) {
		Scanner in;
		String returnString = "";
		try {
			in = new Scanner(new FileReader(fileName));

			while (in.hasNextLine()) {
				returnString = returnString + in.nextLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return returnString;
	}

}
