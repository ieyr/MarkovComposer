import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FrequencyTable {
	List<Character> notes;
	List<Integer> freqs;

	public FrequencyTable(char note) {
		notes = new ArrayList<Character>();
		freqs = new ArrayList<Integer>();
		for (int i = 0; i < Compose.database.length() - 1; i++) {
			if (Compose.database.charAt(i) == note) {

				if (notes.contains(Compose.database.charAt(i + 1))) {
					freqs.set(notes.indexOf(Compose.database.charAt(i + 1)),
							freqs.get(notes.indexOf(Compose.database.charAt(i + 1))) + 1);
				} else {
					notes.add(Compose.database.charAt(i + 1));
					freqs.add(1);
				}
			}
		}

	}

	public char getMaxNote() {
		// int[]maxIndices = new int[freqs.size()/2+1];
		//// for(int i = 0; i < freqs.size(); i++){
		//// if(freqs.get(i) > freqs.get(maxIndex)){
		//// maxIndex = i;
		//// }
		//// }
		// Collections.sort(freqs);
		// for(int i = 0; i < maxIndices.length;i++){
		// maxIndices[i] = i;
		// }
		// System.out.println(freqs.toString());
		// return notes.get( maxIndices[(int)
		// (Math.random()*maxIndices.length)]);

		return notes.get((int) (Math.random() * notes.size()));
	}
}
