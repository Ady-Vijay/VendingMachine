
public class Snack extends Item{
	
	private float weight;
	private boolean containsNuts;
	
	Snack(){
		this.setName("");
		this.setCalories(0);
		this.setItemType("Snack");
		weight = 0;
		containsNuts = false;
	}
	
	Snack(String name, float calories, float weight, boolean containsnuts){
		this.setName(name);
		this.setCalories(calories);
		this.setItemType("Snack");
		this.weight = weight;
		containsNuts = containsnuts;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public boolean getContainsNuts() {
		return containsNuts;
	}
	
	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}
	
	public String toString() {
		return this.getName() + ": (" + this.getItemType() + "): ";
	}

}
