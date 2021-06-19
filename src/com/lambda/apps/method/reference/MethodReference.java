package com.lambda.apps.method.reference;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

/**
 * If all a Lambda Expression does is call an existing method then Method Reference can be used instead of Lambda Expression
 */
public class MethodReference {

	public static void main(String[] args) {

		MethodReference methodRef = new MethodReference();
		
		/*Static method reference*/
		Thread thread = new Thread( MethodReference::doProcess ); //() -> doProcess() <-- implementation of Runnable interface
		thread.start(); //run() of Runnable is called here
		
		/*instance method reference*/
		int value = methodRef.multiply( methodRef::doProcess, 5 ); //p -> doProcess(p)
		System.out.println(value);
		
		/*instance method reference*/
		value = methodRef.add( new MethodReference()::doProcess, 3, 5 ); //(p,q) -> doProcess(p,q)
		System.out.println(value);
		
	}

	/** another example in Reduction.java */

	public static void doProcess() {
		System.out.println("No arg method reference");
	}
	
	
	public int multiply(IntFunction<Integer> fi, int value) {
		return fi.apply(value);
	}
	private int doProcess(int p) {
		return p*p;
	}
	
	
	public int add(IntBinaryOperator fi, int value1, int value2) {
		return fi.applyAsInt(value1,value2);
	}
	private int doProcess(int p, int q) {
		return p+q;
	}
	
}
