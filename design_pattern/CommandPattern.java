package headfirst;

interface Command {
	public void execute();
}
//Receiver
class Light {

	public Light() {
	}

	public void on() {
		System.out.println("Light is on");
	}

	public void off() {
		System.out.println("Light is off");
	}
}

class LightOffCommand implements Command {
	Light light;

	public LightOffCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.off();
	}
}

class LightOnCommand implements Command {
	Light light;

	public LightOnCommand(Light light) {
		this.light = light;
	}

	public void execute() {
		light.on();
	}
}
//invoker
class SimpleRemoteControl {
	Command slot;

	public SimpleRemoteControl() {
	}

	public void setCommand(Command command) {
		slot = command;
	}

	public void buttonWasPressed() {
		slot.execute();
	}
}
//the Invoker doesn't directly manipulate on the Receiver,but use Command as a wrapper class to manipulate
//on the Receiver
public class CommandPattern {
	public static void main(String[] args){
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light();
		
		LightOnCommand lightOn = new LightOnCommand(light);

		remote.setCommand(lightOn);
		remote.buttonWasPressed();
	}
}
