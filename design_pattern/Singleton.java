package headfirst;

//create the instance when the Class is loaded
class Singleton1 {
	private static Singleton1 uniqueInstance = new Singleton1();
 
	private Singleton1() {}
 
	public static Singleton1 getInstance() {
		return uniqueInstance;
	}
}

//create the instance when getInstance method is called
class Singleton2 {
	private static Singleton2 uniqueInstance;
 
	// other useful instance variables here
 
	private Singleton2() {}
 
	public static synchronized Singleton2 getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Singleton2();
		}
		return uniqueInstance;
	}
 
	// other useful methods here
}

public class Singleton {
	public static void main(String[] args){
		Singleton1 singleton1 = Singleton1.getInstance();
		Singleton2 singleton2 = Singleton2.getInstance();
	}
}
