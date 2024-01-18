
public class Drink extends Item{
	private float ounces;
	private String type;
	
	Drink(){
		this.setName("");
		this.setCalories(0);
		this.setItemType("Drink");
		ounces = 0;
		type = "";
	}
	
	Drink(String name, float calories, float ounces, String type){
		this.setName(name);
		this.setCalories(calories);
		this.setItemType("Drink");
		this.ounces = ounces;
		this.type = type;
	}
	
	public float getOunces() {
		return ounces;
	}
	
	public void setOunces(float ounces) {
		this.ounces = ounces;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return this.getName() + ": (" + this.getType() + "): ";
	}
}
