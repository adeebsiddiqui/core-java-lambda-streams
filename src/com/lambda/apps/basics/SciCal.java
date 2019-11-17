package com.lambda.apps.basics;

public class SciCal {

	public static void main(String[] args) {
		
		SciCal cal = new SciCal();
		
		int result = cal.calculate( (a,b) -> {return a+b;} ); //if Lambda Expression has one liner body then keyword 'return' and method body braces'{}' can be omitted
		System.out.println(result);
		
		result = cal.calculate( v -> v*v ); //if Lambda Expression has one parameter then '()' can be omitted
		System.out.println(result);
	}
	
	public int calculate(OperationAdd op) {
		return op.add(5,3);
	}
	
	public int calculate(OperationSquare op) {
		return op.square(5);
	}
}


interface OperationAdd {
	int add(int x, int y);
}

interface OperationSquare {
	int square(int x);
}
