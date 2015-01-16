//Effective Java Item02 Source
package chapter2;

class NutritionFacts{
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	//Builder class is a helper class,it's better to define it as a static inner class
	public static class Builder{
		//required parameters
		private final int servingSize;
		private final int servings;
		//Optional parameters
		private int calories=0;
		private int fat=0;
		private int carbohydrate=0;
		private int sodium=0;
		public Builder(int servingSize,int servings){
		this.servingSize=servingSize;
		this.servings=servings;
		}
		public Builder calories(int val){
			this.calories=val;
			return this;
		}
		public Builder fat(int val){
		this.fat=val;
		return this;
		}
		public Builder carbohydrate(int val){
		this.carbohydrate=val;
		return this;
		}
		public Builder sodium(int val){
		this.sodium=val;
		return this;
		}
		public NutritionFacts build(){
			return new NutritionFacts(this);
		}
	}
	private NutritionFacts(Builder builder){
		this.servingSize=builder.servingSize;
		this.servings=builder.servings;
		this.calories=builder.calories;
		this.fat=builder.fat;
		this.carbohydrate=builder.carbohydrate;
		this.sodium=builder.sodium;
	}
}
public class Item02 {
	public static void main(String[] args){
		NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).calories(100).carbohydrate(35).build(); 
	}
}
