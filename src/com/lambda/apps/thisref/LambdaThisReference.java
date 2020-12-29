package com.lambda.apps.thisref;

public class LambdaThisReference {

    public static void main(String[] args) {

        LambdaThisReference lambda1 = new LambdaThisReference();
        System.out.println("lambda1 = " + lambda1);

        LambdaThisReference lambda2 = new LambdaThisReference();
        System.out.println("lambda2 = " + lambda2);

        lambda1.giveHomeworkToStudent(new Student() {
            @Override
            public void doHomework() {
                System.out.println("Doing math homework");
                System.out.println(this); //In anonymous inner class, 'this' refers to the anonymous class instance
            }
        });

        lambda1.giveHomeworkToStudent(() -> {
            System.out.println("Doing physics homework");
            //System.out.println(this); //In Lambda, 'this' refers to the enclosing instance. In this case, there is no enclosing instance since main has static context
        });

        lambda1.prepareHomework();
        lambda2.prepareHomework();
    }


    public void giveHomeworkToStudent(Student student) {
        student.doHomework();
    }

    public void prepareHomework() {
        giveHomeworkToStudent(() -> {
            System.out.println("Doing biology homework");
            System.out.println(this); //In Lambda, 'this' refers to the enclosing instance. In this case, the instance on which prepareHomework() is called
        });
    }
}
