package headfirst;

interface Car{
	public void drive();
}
class  Benz implements Car{
	public void drive(){
		System.out.println("Driving Benz");
	}
}
class Bmw implements Car{
	public void drive(){
		System.out.println("Driving Bmw");
	}
}

class Factory{
	public static Car create(String type){
		if(type.equalsIgnoreCase("Benz")){
			return new Benz();
		}else if(type.equalsIgnoreCase("Bmw")){
			return new Bmw();
		}
		return null;
	}
}

public class SimpleFactory {
	public static void main(String[] args){
		Car benz=Factory.create("Benz");
		Car bmw=Factory.create("Bmw");
		benz.drive();
		bmw.drive();
	}
}
