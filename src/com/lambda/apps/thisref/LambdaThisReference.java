package com.lambda.apps.thisref;

public class LambdaThisReference {

	public static void main(String[] args) {
		
		LambdaThisReference lambda = new LambdaThisReference();
		
		lambda.giveHomeworkToStudent(new Student() {
			@Override
			public void doHomework() {
				System.out.println("Doing math homework");
				System.out.println(this); //this refers to the instance of anonymous Student implementation, overrides the default
			}
		});
		
		lambda.giveHomeworkToStudent( () -> {
			System.out.println("Doing physics homework");
			//System.out.println(this); //won't work because lambda expressions actually are NOT implementation of any interface
		});
		
		lambda.prepareHomework();
	}
	
	
	public void giveHomeworkToStudent(Student student) {
		student.doHomework();
	}
	
	public void prepareHomework() {
		giveHomeworkToStudent(() -> {
			System.out.println("Doing biology homework");
			System.out.println(this); //this refers to the same instance referred outside of lambda expression i.e. the instance on which prepareHomework() was called
		});
	}
}
