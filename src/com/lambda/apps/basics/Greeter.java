package com.lambda.apps.basics;

/**
 * Lambda allows functional programming.
 * Functional programming allows to write more readable and maintainable code.
 */
public class Greeter {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		//prior to Java 8, we had to pass the Greeting behavior as an implementation class, in below case as an anonymous class
		greeter.greet( new Greeting() {
			@Override
			public void perform() {
				System.out.println("Hello World!");
			}
		});
		
		//using Lambda Expression with variable
		Greeting greeting = () -> System.out.println("Hello Lambda!"); //no implementation class required, just the function
		greeter.greet(greeting);
		
		//Using Lambda Expression inline
		greeter.greet( () -> System.out.println("Hello Lambda Inline!") ); //Type Inference -> compiler matches the Lambda Expression with Interface
	}
	
	
	public void greet( Greeting greeting ) { //retrieving the behavior, behavior can have many implementations
		greeting.perform();
	}
	/* Basically a Lambda Expression is an implementation of the single abstract method in a Functional Interface */
}

/**
 * <p>Interface which defines the type of a Lambda expression is called {@code Functional Interface}.</p><p>Functional Interfaces can't have more than one abstract methods.</p>
 * <p>Functional Interface annotation is optional so that programmers knows this interface is used for Lambda Expression and thereby don't add additional abstract methods to the interface.</p>
 * <p><strong>Lambda expression is executed when the method of Functional Interface is explicitly called.</strong></p>
 */
@FunctionalInterface
interface Greeting {
	void perform();
}
