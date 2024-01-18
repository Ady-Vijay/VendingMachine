import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataFile {
	
	private ArrayList<String> Inventory;
	private ArrayList<Integer> Request;
	
	DataFile(String Directory, String Input) throws FileNotFoundException{
		Inventory = new ArrayList<String>();
		Request = new ArrayList<Integer>();
		File file1 = new File(Directory);
		File file2 = new File(Input);
		
		Scanner reader = new Scanner(file1);
		while(reader.hasNextLine()) {
			Inventory.add(reader.nextLine());
		}
		reader.close();
		
		reader = new Scanner(file2);
		while(reader.hasNext()) {
			Request.add(reader.nextInt());
		}
		reader.close();
		
	}
	
	public ArrayList<String> loadDirectory(){
		return Inventory;
	}
	
	public ArrayList<Integer> loadSampleInput(){
		return Request;
	}
}
