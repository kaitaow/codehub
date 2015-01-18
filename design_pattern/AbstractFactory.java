package headfirst;

interface BusinessCar{
	public void drive();
}
interface SportsCar{
	public void drive();
}
class  BusinessBenz implements BusinessCar{
	public void drive(){
		System.out.println("Driving BusinessBenz");
	}
}
class SportsBenz implements SportsCar{
	public void drive(){
		System.out.println("Driving SportsBenz");
	}
}

class BusinessBmw implements BusinessCar{
	public void drive(){
		System.out.println("Driving BusinessBmw");
	}
}
class SportsBmw implements SportsCar{
	public void drive(){
		System.out.println("Driving SportsBmw");
	}
}

interface Factory{
	public BusinessCar createBusiness();
	public SportsCar createSports();
}
class BenzFactory implements Factory{
	public BusinessCar createBusiness(){
		return new BusinessBenz();
	}
	public SportsCar createSports(){
		return new SportsBenz();
	}
}
class BmwFactory implements Factory{
	public BusinessCar createBusiness(){
		return new BusinessBmw();
	}
	public SportsCar createSports(){
		return new SportsBmw();
	}
}

public class AbstractFactory{
	public static void main(String[] args){
		//by specify the kind of factory you want to instantiate you can specify the brand of car
		//by call the createBusiness of createSports method you can specify the style of car
		//it's convenient to add new brand,but if you want to add new style you have to modify
		//quite a amount of code
		Factory benzFactory=new BenzFactory();
		BusinessCar businessBenz=benzFactory.createBusiness();
		SportsCar sportsBenz=benzFactory.createSports();
		businessBenz.drive();
		sportsBenz.drive();
		
		Factory bmwFactory=new BmwFactory();
		BusinessCar businessBmw=bmwFactory.createBusiness();
		SportsCar sportsBmw=bmwFactory.createSports();
		businessBmw.drive();
		sportsBmw.drive();
	}
}
