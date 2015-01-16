//Effective Java Item03
package chapter2;

class Singleton {
	private Singleton() {
	};

	private static Singleton INSTANCE = new Singleton();

	public static Singleton getInstance() {
		return INSTANCE;
	}
}

enum AnotherSingleton {
	INSTANCE;
}

public class Item03 {
	public static void main(String[] args) {
		Singleton instance = Singleton.getInstance();
		AnotherSingleton anotherInstance = AnotherSingleton.INSTANCE;
	}
}
