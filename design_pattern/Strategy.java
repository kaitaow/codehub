package headfirst;

interface FlyBehavior {
	public void fly();
}
class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}

interface QuackBehavior {
	public void quack();
}

class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}

abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
 
	public Duck() {
	}
 
	public void setFlyBehavior (FlyBehavior fb) {
		flyBehavior = fb;
	}
 
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
 
	abstract void display();
 
	public void performFly() {
		flyBehavior.fly();
	}
 
	public void performQuack() {
		quackBehavior.quack();
	}
 
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
public class Strategy {
	public static void main(String[] args){
		//you can implement more FlyBehavior and QuackBehavior
		//and create a new type of duck
		//the duck's behavior is determined by the FlyBehavior and QuackBehavior defined in
		//the concrete duck class
		Duck decoyduck=new DecoyDuck();
		decoyduck.display();
		decoyduck.performFly();
		decoyduck.performQuack();
	}
}
