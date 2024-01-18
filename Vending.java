import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vending {
	
	private ArrayList<Item> directory;
	private ArrayList<Queue> slots;
	
	Vending(ArrayList<String> file){
		directory = new ArrayList<Item>();
		slots = new ArrayList<Queue>();
		loadItem(file);
	}
	
	public void loadItem(ArrayList<String> Items) {// don't quite see how this could be done without a nested loop but that would be amazing
		for (int i = 0; i<Items.size(); i++) {
			List<String> line = Arrays.asList(Items.get(i).split(","));
			
			if(line.get(0).equals("Drink")) {
				Drink temp = new Drink(line.get(1), Float.valueOf(line.get(2)), Float.valueOf(line.get(3)), line.get(4).substring(1));
				Queue<Drink> slot = new LinkedList<Drink>();
				for(int j = 0; j < Integer.valueOf(line.get(5).substring(1)); j++) {
					slot.add(temp);
				}
				directory.add(temp);
				slots.add(slot);
			}
			else if(line.get(0).equals("Snack")) {
				Snack temp = new Snack(line.get(1), Float.valueOf(line.get(2)), Float.valueOf(line.get(3)), Boolean.parseBoolean(line.get(4).substring(1)));
				Queue<Snack> slot = new LinkedList<Snack>();
				for(int j = 0; j < Integer.valueOf(line.get(5).substring(1)); j++) {
					slot.add(temp);
				}
				directory.add(temp);
				slots.add(slot);
			}
			
		}
	}
	
	private int mostItems(ArrayList<Integer> products, int index) {
		int highest = index;
		for(int i = 1; i < products.size(); i++) { // loops through all indexes of the same object
			if(slots.get(products.get(i)).size() > slots.get(highest).size()) {//compares it to the size of the inital index and takes the highest one or base depending on if any have a value higher than one
				highest = products.get(i);
			}
		}
		return highest;
	}
	
	public void unloadItem(int index) {// remove the item from directory and slots if items are no longer left
		if(slots.get(index).size() >= 2) {//removes from if greater than 1
			slots.get(index).remove();
		}
		else if (slots.get(index).size() == 0) {
			System.out.println("Error, slot "+ index +" is currently empty");
		}
		else {
			ArrayList<Integer> products = findProduct(directory.get(index).getName());// all possible locations product is stored in vending machine
			if(products.size()> 1) {
				 slots.get(mostItems(products,index)).remove();
			}
			else {
				slots.get(index).remove();
			}
		}
	}
	
	public ArrayList<Integer> findProduct(String name){
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i = 0; i< directory.size(); i++) {
			if(name.equals(directory.get(i).getName())){
				index.add(i);
			}
		}
		return index;
	}
	
	public void unloadItems(ArrayList<Integer> requests) {
		for(int i = 0; i< requests.size(); i++) {
			unloadItem(requests.get(i));
		}
	}
	
	public String toString() {/* Testing to see if boolean objects were being recognized correctly
		if(((Snack)slots.get(3).peek()).getContainsNuts()) {
			return "true";
		}
		return "false";
		*/
		//return Float.toString(((Snack)slots.get(3).peek()).getCalories()); //checking to see if float values are being collected correctly
		
		return "";
	}
	
	public void displayItems(){
		for(int i = 0; i<directory.size(); i++) {
			System.out.println(directory.get(i).toString() + slots.get(i).size());
		}
	}
	
}
