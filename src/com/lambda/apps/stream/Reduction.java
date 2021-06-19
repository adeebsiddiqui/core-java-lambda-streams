package com.lambda.apps.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Reduction {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);

        int sum = intStream.sum();
        System.out.println("Sum = " + sum);

        //intStream = IntStream.of(1, 2, 3, 4, 5); //observe the error
        OptionalInt optionalInt = intStream.reduce((x, y) -> Integer.sum(x, y));
        System.out.println("Sum using reduce = " + optionalInt.getAsInt());

        //intStream = IntStream.of(1, 2, 3, 4, 5); //see the cause of error below
        int sumWithIdentity = intStream.reduce(5, Integer::sum);
        System.out.println("Sum using reduce with identity = " + sumWithIdentity);
        /** Reduce with identity starts with identity value as X and first value of stream as Y in the accumulator function
         * The result of the accumulator function is then set as X and second value of stream as Y and so on...*/
    }
}
/**
 * Reduction is a Terminal Operation. After Terminal Operation is performed on a Stream it is closed, no additional operation can be performed on it
 */