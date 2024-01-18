
public class Item {
	private String name;
	private float calories;
	private String ItemType;
	
	Item(){
		name = "";
		calories = 0;
		ItemType = "";
	}
	
	Item(String name, float calories, String ItemType){
		this.name = name;
		this.calories = calories;
		this.ItemType = ItemType;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getCalories() {
		return calories;
	}
	
	public void setCalories(float calories) {
		this.calories = calories;
	}
	
	public String getItemType() {
		return ItemType;
	}
	
	public void setItemType(String ItemType) {
		this.ItemType = ItemType;
	}
}
