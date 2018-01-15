package Bean;

public class Meal {
	private String meal_name,meal_description,meal_img,meal_NY;
	private float meal_price;
	private int meal_id,style_id;
	
	
	public String getMeal_name() {
		return meal_name;
	}
	public void setMeal_name(String meal_name) {
		this.meal_name = meal_name;
	}
	public String getMeal_description() {
		return meal_description;
	}
	public void setMeal_description(String meal_description) {
		this.meal_description = meal_description;
	}
	public String getMeal_img() {
		return meal_img;
	}
	public void setMeal_img(String meal_img) {
		this.meal_img = meal_img;
	}
	public String getMeal_NY() {
		return meal_NY;
	}
	public void setMeal_NY(String meal_NY) {
		this.meal_NY = meal_NY;
	}
	public float getMeal_price() {
		return meal_price;
	}
	public void setMeal_price(float meal_price) {
		this.meal_price = meal_price;
	}
	public int getMeal_id() {
		return meal_id;
	}
	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}
	public int getStyle_id() {
		return style_id;
	}
	public void setStyle_id(int style_id) {
		this.style_id = style_id;
	}
	
}
