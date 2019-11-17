package com.lambda.apps.closures;

public class Closures {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		doProcess(a, new Process() {
			@Override
			public void process(int i) {
				System.out.println(i+b); 
			}
		});
		
		//b = 9;
		/* won't work since b is 'effectively final' because at runtime process() is executed inside doProcees() where b is out of scope.
		 * JRE keeps track of b inside main() and makes it 'effectively final' --> Closures phenomenon
		 */
		
		doProcess( a, x -> System.out.println(x+b) );
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}


interface Process {
	void process(int i);
}
