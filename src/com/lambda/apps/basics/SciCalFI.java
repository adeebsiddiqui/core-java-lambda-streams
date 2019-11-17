package com.lambda.apps.basics;

import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;

/**
 * Use of {@code Function Interface} from package 'java.util.function' so custom Functional Interfaces need not be declared
 */
public class SciCalFI {

	public static void main(String[] args) {
		
		SciCalFI cal = new SciCalFI();
		
		int result = cal.calculate( (a,b) -> a+b );
		System.out.println(result);
		
		result = cal.calculate( v -> v*v );
		System.out.println(result);
	}
	
	public int calculate(IntBinaryOperator fi) {
		return fi.applyAsInt(3,5);
	}
	
	public int calculate(IntFunction<Integer> fi) {
		return fi.apply(5);
	}
}