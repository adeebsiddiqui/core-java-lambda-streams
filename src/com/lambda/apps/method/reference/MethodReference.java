package com.lambda.apps.method.reference;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

/**
 * When a Lambda Expression calls an existing method then Method Reference can be used instead of Lambda Expression,
 *	iff the argument and return type of both Lambda Expression and the calling method are exactly the same
 */
public class MethodReference {

	public static void main(String[] args) {

		MethodReference methodRef = new MethodReference();
		
		/*Static method reference*/
		Thread thread = new Thread( MethodReference::doProcess ); //() -> doProcess() <-- implementation of Runnable interface
		thread.start(); //run() of Runnable is called here
		
		/*instance method reference*/
		int value = methodRef.multiply( methodRef::doProcess ); //p -> doProcess(p)
		System.out.println(value);
		
		/*instance method reference*/
		value = methodRef.add( new MethodReference()::doProcess ); //(p,q) -> doProcess(p,q)
		System.out.println(value);
		
	}

	public static void doProcess() {
		System.out.println("No arg method reference");
	}
	
	
	public int multiply(IntFunction<Integer> fi) {
		return fi.apply(5);
	}
	private int doProcess(int p) {
		return p*p;
	}
	
	
	public int add(IntBinaryOperator fi) {
		return fi.applyAsInt(3,5);
	}
	private int doProcess(int p, int q) {
		return p+q;
	}
	
}
