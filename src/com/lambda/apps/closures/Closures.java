package com.lambda.apps.closures;

public class Closures {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		doProcess( a, x -> System.out.println(x+b) );

		b = 9;
		/* won't work since b is 'effectively final'.
		JRE keeps track of any local variables inside main() which are used in lambda expressions and makes it 'effectively final' --> Closure phenomenon
		Closure has immutable state
		https://www.youtube.com/watch?v=15X0qFtBqiQ&t=2023s */
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}


interface Process {
	void process(int i);
}
